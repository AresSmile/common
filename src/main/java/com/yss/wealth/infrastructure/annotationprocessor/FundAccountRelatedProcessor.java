package com.yss.wealth.infrastructure.annotationprocessor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
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
 * @description: 基金账号关联注解处理类
 **/
@Slf4j
public class FundAccountRelatedProcessor implements FormatProcessor {
    private static final String FEIGN_CLASSNAME = "com.yss.ta.account.feign.AccountFeignClient";
    private static final String METHOD_NAME = "queryFundAccountMsg";
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 36, 30, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2048));
    private static final Class[] PARAM_CLASS = {List.class};
    private static final int BATCH_NUM = 200;


    @Override
    public boolean match(Format.FormatType type) {
        return Format.FormatType.FUND_ACCOUNT_RELATED.equals(type);
    }

    @Override
    public void format(List<BeanUtilExtend.InnerFormat> formats) {
        Set<String> fundAccounts = new HashSet<>();
        formats.forEach(format -> {
            format.getFields().forEach(field -> {
                Format annotation = field.getAnnotation(Format.class);
                String fieldName = annotation.fieldName()[0];
                Object fieldValue = ReflectUtil.getFieldValue(format.getObj(), fieldName);
                fundAccounts.add(Optional.ofNullable(fieldValue).orElse("").toString());
            });
        });
        Map<String, Map> accountInfos = getAccountInfos(Lists.newArrayList(fundAccounts));
        formats.forEach(format -> {
            format.getFields().forEach(field -> {
                Format annotation = field.getAnnotation(Format.class);
                String other = annotation.other();
                Object fieldValue = ReflectUtil.getFieldValue(format.getObj(), annotation.fieldName()[0]);
                String fundAccount = ObjectUtil.isEmpty(fieldValue) ? "" : fieldValue.toString();
                ReflectUtil.setFieldValue(format.getObj(), field, Optional.ofNullable(accountInfos.get(fundAccount)).orElse(new HashMap()).get(other));
            });
        });
    }


    /**
     * 查询基金账号信息
     *
     * @param fundAccounts
     * @return
     */
    public Map<String, Map> getAccountInfos(List<String> fundAccounts) {
        if (CollectionUtil.isEmpty(fundAccounts)) {
            return new HashMap<>(1);
        }
        Class<?> accountFeignClass;
        Method method;
        try {
            accountFeignClass = Class.forName(FEIGN_CLASSNAME);
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
        List<Map> result = Collections.synchronizedList(Lists.newArrayList());
        //分批多线程去查询
        List<List<String>> lists = CollectionUtil.averageAssign(fundAccounts, fundAccounts.size() % BATCH_NUM > 0 ? fundAccounts.size() / BATCH_NUM + 1 : fundAccounts.size() / BATCH_NUM);
        CountDownLatch latch = new CountDownLatch(lists.size());
        lists.forEach(l -> {
            executor.execute(() -> {
                try {
                    Object invoke = method.invoke(feignClient, l);
                    if (invoke instanceof RestfulResponse) {
                        RestfulResponse response = (RestfulResponse) invoke;
                        if (response.isSuccess()) {
                            result.addAll(TradeAccountRelatedProcessor.listToMap((List<Object>) response.getData()));
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

        return result.stream().collect(Collectors.toMap(a -> a.get("fundAccount").toString(), vo -> vo, (k1, k2) -> k1));

    }


    /**
     * Format注解中需要Other字段需要填写的属性，
     *
     * @see Format
     * eg:@Format(type = Format.FormatType.FUND_ACCOUNT_RELATED,fieldName = "fundAccount",other = FundAccountRelatedProcessor.FundAccountFieldConstants.specialCode)
     */
    public interface FundAccountFieldConstants {
        /**
         * 基金账号
         */
        String fundAccount = "fundAccount";
        /**
         * 客户名称
         */
        String custName = "custName";
        /**
         * 客户编码
         */
        String customerNo = "customerNo";
        /**
         * 账户状态
         */
        String accountStatus = "accountStatus";
        /**
         * 账户状态
         */
        String accountStatusName = "accountStatusName";
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
         * 证件有效期
         */
        String certValidDate = "certValidDate";
        /**
         * 账户开户日期
         */
        String openDate = "openDate";
        /**
         * 最后修改日期
         */
        String lastUpdateDate = "lastUpdateDate";
        /**
         * 客户简称
         */
        String custShortName = "custShortName";
        /**
         * 邮政编码
         */
        String postCode = "postCode";
        /**
         * 通信地址
         */
        String address = "address";
        /**
         * 电话号码
         */
        String telNo = "telNo";
        /**
         * 传真号码
         */
        String faxNo = "faxNo";
        /**
         * 手机号码
         */
        String mobileTelNo = "mobileTelNo";
        /**
         * 电子邮件
         */
        String emailAddress = "emailAddress";
        /**
         * 性别
         */
        String sex = "sex";
        /**
         * 性别
         */
        String sexName = "sexName";
        /**
         * 生日
         */
        String birthday = "birthday";
        /**
         * 职业
         */
        String vocationCode = "vocationCode";
        /**
         * 职业
         */
        String vocationName = "vocationName";
        /**
         * 学历
         */
        String educationLevel = "educationLevel";
        /**
         * 学历
         */
        String educationLevelName = "educationLevelName";
        /**
         * 年收入
         */
        String annualIncome = "annualIncome";
        /**
         * 单位名称
         */
        String corpName = "corpName";
        /**
         * 单位电话
         */
        String officeTelNo = "officeTelNo";
        /**
         * 经办人名称
         */
        String transactorName = "transactorName";
        /**
         * 经办人证件类型
         */
        String transactorCertType = "transactorCertType";
        /**
         * 经办人证件类型
         */
        String transactorCertTypeName = "transactorCertTypeName";
        /**
         * 经办人证件号码
         */
        String transactorCertNo = "transactorCertNo";
        /**
         * 对账单寄送方式
         */
        String deliverWay = "deliverWay";
        /**
         * 对账单寄送方式
         */
        String deliverWayName = "deliverWayName";
        /**
         * 对账单寄送途径
         */
        String deliverType = "deliverType";
        /**
         * 对账单寄送途径
         */
        String deliverTypeName = "deliverTypeName";
        /**
         * 国籍
         */
        String nationality = "nationality";
        /**
         * 法人名称
         */
        String instreprName = "instreprName";
        /**
         * 法人证件类型
         */
        String instreprIdType = "instreprIdType";
        /**
         * 法人证件类型
         */
        String instreprIdTypeName = "instreprIdTypeName";
        /**
         * 法人证件号码
         */
        String instreprIdCode = "instreprIdCode";
        /**
         * 经纪人
         */
        String broker = "broker";
        /**
         * 推荐人
         */
        String commendPerson = "commendPerson";
        /**
         * 推荐人类型
         */
        String commendPersonType = "commendPersonType";
        /**
         * 推荐人类型
         */
        String commendPersonTypeName = "commendPersonTypeName";
        /**
         * 城市代码
         */
        String city = "city";
        /**
         * 修改重要内容信息
         */
        String modifyInfo = "modifyInfo";
        /**
         * 修改重要内容信息
         */
        String modifyInfoName = "modifyInfoName";
        /**
         * 退信原因
         */
        String backReason = "backReason";
        /**
         * 开户机构网点
         */
        String openAgencyNo = "openAgencyNo";
        /**
         * 销售机构
         */
        String orgName = "orgName";
        /**
         * 经办人证件有效期
         */
        String instTranCertValidDate = "instTranCertValidDate";
        /**
         * 法人证件有效期
         */
        String instReprCertValidDate = "instReprCertValidDate";
        /**
         * 控股股东
         */
        String controlHolder = "controlHolder";
        /**
         * 实际控制人
         */
        String actualController = "actualController";
        /**
         * 销户日期
         */
        String closeDate = "closeDate";
        /**
         * 基金账户卡的凭证号
         */
        String accountCardId = "accountCardId";
        /**
         * 特殊代码
         */
        String specialCode = "specialCode";
    }
}
