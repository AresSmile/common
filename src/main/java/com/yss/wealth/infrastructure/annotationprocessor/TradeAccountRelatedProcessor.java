package com.yss.wealth.infrastructure.annotationprocessor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.yss.wealth.infrastructure.annotation.Format;
import com.yss.wealth.infrastructure.common.RestfulResponse;
import com.yss.wealth.infrastructure.util.BeanUtilExtend;
import com.yss.wealth.infrastructure.util.CollectionUtil;
import com.yss.wealth.infrastructure.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author:zhuhongmin
 * @date:2020/7/31
 * @description: 交易账号关联注解处理类
 **/
@Slf4j
public class TradeAccountRelatedProcessor implements FormatProcessor {
    private static final String FEIGN_CLASSNAME = "com.yss.ta.account.feign.AccountFeignClient";
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 36, 30, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2048));
    private static final String METHOD_NAME = "queryTransAccountMsg";
    private static final Class[] PARAM_CLASS = {List.class};
    private static final int BATCH_NUM = 200;


    @Override
    public boolean match(Format.FormatType type) {
        return Format.FormatType.TRADE_ACCOUNT_RELATED.equals(type);
    }

    @Override
    public void format(List<BeanUtilExtend.InnerFormat> formats) {
        Set<String> tradeAccounts = new HashSet<>();
        formats.forEach(format -> {
            format.getFields().forEach(field -> {
                Format annotation = field.getAnnotation(Format.class);
                StringBuilder sb = new StringBuilder();
                for (String fieldName : annotation.fieldName()) {
                    Object fieldValue = ReflectUtil.getFieldValue(format.getObj(), fieldName);
                    if (ObjectUtil.isNull(fieldValue)) {
                        break;
                    } else {
                        sb.append(fieldValue.toString()).append(",");
                    }
                }
                tradeAccounts.add(sb.substring(0, sb.length()));
            });
        });
        Map<String, Map> tradeAccountInfos = getTradeAccountInfos(Lists.newArrayList(tradeAccounts));
        formats.forEach(format -> {
            format.getFields().forEach(field -> {
                Format annotation = field.getAnnotation(Format.class);
                String other = annotation.other();
                String key = "";
                for (String fieldName : annotation.fieldName()) {
                    key += ReflectUtil.getFieldValue(format.getObj(), fieldName);
                }
                ReflectUtil.setFieldValue(format.getObj(), field, Optional.ofNullable(tradeAccountInfos.get(key)).orElse(new HashMap()).get(other));
            });
        });
    }

    /**
     * 查询交易账号信息
     *
     * @param tradeAccounts 交易账号（机构代码,网点代码,交易账号）拼接而成
     * @return
     */
    private Map<String, Map> getTradeAccountInfos(List<String> tradeAccounts) {
        if (CollectionUtil.isEmpty(tradeAccounts)) {
            return new HashMap<>(1);
        }
        Class<?> accountFeignClass;
        Class<?> paramClass;
        Method method;
        try {
            accountFeignClass = Class.forName(FEIGN_CLASSNAME);
            paramClass = Class.forName("com.yss.ta.account.dto.TradeAccountQueryDTO");
        } catch (ClassNotFoundException e) {
            log.warn("class not found ，className:{}", FEIGN_CLASSNAME);
            return new HashMap<>();
        }
        try {
            method = accountFeignClass.getMethod(METHOD_NAME, PARAM_CLASS);
        } catch (NoSuchMethodException e) {
            log.warn("method not found ，className:{},methodName:{}", FEIGN_CLASSNAME, METHOD_NAME);
            return new HashMap<>();
        }
        Object feignClient = SpringContextUtil.getBean(accountFeignClass);
        if (ObjectUtil.isNull(feignClient)) {
            log.warn("容器中未找到相关bean，无法完成交易账号关联，请查看项目依赖！");
            return new HashMap<>();
        }
        List<Thread> threads = new ArrayList<>();
        List<Map> result = Collections.synchronizedList(Lists.newArrayList());
        List<Map<String, String>> params = new ArrayList<>();
        tradeAccounts.forEach(s -> {
            String[] split = s.split(",");
            if(split.length != 3){
                return;
            }
            Map<String, String> param = new HashMap<>();
            param.put("orgCode", split[0]);
            param.put("netCode", split[1]);
            param.put("tradeAccount", split[2]);
            params.add(param);
        });
        //分批多线程去查询
        List<List<Map<String, String>>> lists = CollectionUtil.averageAssign(params, tradeAccounts.size() % BATCH_NUM > 0 ? tradeAccounts.size() / BATCH_NUM + 1 : tradeAccounts.size() / BATCH_NUM);
        CountDownLatch latch = new CountDownLatch(lists.size());
        lists.forEach(l -> {
            executor.execute(() -> {
                String paramJson = JSONObject.toJSONString(l);
                List<?> objects = JSONObject.parseArray(paramJson, paramClass);
                try {
                    Object invoke = method.invoke(feignClient, objects);
                    if (invoke instanceof RestfulResponse) {
                        RestfulResponse response = (RestfulResponse) invoke;
                        if (response.isSuccess()) {
                            result.addAll(listToMap((List<Object>) response.getData()));
                        } else {
                            log.warn("外部账户接口查询异常");
                        }
                    }
                } catch (Exception e) {
                    log.warn("接口调用异常");
                } finally {
                    latch.countDown();
                }
            });
        });
        //等待所有线程执行完毕
        try {
            latch.await();
        } catch (InterruptedException e) {
            log.warn("线程被意外中断", e);
        }
        return result.stream().collect(Collectors.toMap(a -> a.get("orgCode").toString() + a.get("netCode").toString() + a.get("transAccount").toString(), vo -> vo, (k1, k2) -> k1));
    }

    static Map beanToMap(Object o) {
        String json = JSONObject.toJSONString(o);
        return JSONObject.parseObject(json, Map.class);
    }


    static List<Map> listToMap(List<Object> list) {
        List<Map> result = new ArrayList<>();
        list.forEach(l -> {
            result.add(beanToMap(l));
        });
        return result;
    }


    /**
     * Format注解中需要Other字段需要填写的属性，
     * 在使用format注解去关联交易账户信息的时候，fieldName字段的顺序必须是orgCode，netCode，transAccount"
     * @see Format
     * eg: @Format(type = Format.FormatType.TRADE_ACCOUNT_RELATED,fieldName = {"orgCode","netCode","transAccount"},other = TradeAccountRelatedProcessor.TradeAccountFieldConstants.bankNo)
     */
    public interface TradeAccountFieldConstants {
        /**
         * 基金账号
         */
        String fundAccount = "fundAccount";
        /**
         * 客户名称
         */
        String custName = "custName";
        /**
         * 销售机构代码
         */
        String orgCode = "orgCode";
        /**
         * 销售机构
         */
        String orgName = "orgName";
        /**
         * 网点代码
         */
        String netCode = "netCode";
        /**
         * 网点
         */
        String netName = "netName";
        /**
         * 交易账号
         */
        String transAccount = "transAccount";
        /**
         * 交易账号状态
         */
        String transAccoStatus = "transAccoStatus";
        /**
         * 交易账号状态
         */
        String transAccoStatusName = "transAccoStatusName";
        /**
         * 银行编号
         */
        String bankNo = "bankNo";
        /**
         * 交收行账户
         */
        String bankAcctNo = "bankAcctNo";
        /**
         * 交收行户名
         */
        String bankAcctName = "bankAcctName";
        /**
         * 操作网点编号
         */
        String operatorNetCode = "operatorNetCode";
        /**
         * 客户类型
         */
        String custType = "custType";
        /**
         * 客户类型
         */
        String custTypeName = "custTypeName";
        /**
         * 证件类型
         */
        String certificateType = "certificateType";
        /**
         * 证件类型
         */
        String certificateTypeName = "certificateTypeName";
        /**
         * 证件号码
         */
        String certificateCode = "certificateCode";
        /**
         * 开户行名称
         */
        String bankName = "bankName";
        /**
         * 银联号
         */
        String bankBranch = "bankBranch";
        /**
         * 开户行省份代码
         */
        String bankProvince = "bankProvince";
        /**
         * 开户行城市代码
         */
        String bankCity = "bankCity";
    }
}
