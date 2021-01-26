package com.yss.wealth.infrastructure.annotationprocessor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSONObject;
import com.yss.wealth.infrastructure.annotation.Format;
import com.yss.wealth.infrastructure.common.RestfulResponse;
import com.yss.wealth.infrastructure.constant.CommonConst;
import com.yss.wealth.infrastructure.util.BeanUtilExtend;
import com.yss.wealth.infrastructure.util.SpringContextUtil;
import com.yss.wealth.infrastructure.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:zhuhongmin
 * @date:2020/7/30
 * @description: 注解解释类（产品代码解释）
 **/
@Slf4j
public class NetFormatProcessor implements FormatProcessor {
    @Override
    public boolean match(Format.FormatType type) {
        return Format.FormatType.NET_FORMAT.equals(type);
    }


    @Override
    public void format(List<BeanUtilExtend.InnerFormat> formats) {
        //网点代码的格式化，直接走默认的接口去格式化网点名称
        Class<?> aClass;
        try {
            aClass = Class.forName(Format.FormatType.NET_FORMAT.getInterfaceName());
        } catch (ClassNotFoundException e) {
            log.warn("类：{}，不存在！无法格式化网点名称，请检查依赖！", Format.FormatType.NET_FORMAT.getInterfaceName());
            return;
        }
        Method method = ReflectUtil.getMethod(aClass, Format.FormatType.NET_FORMAT.getMethodName());
        if (ObjectUtil.isNull(method)) {
            log.warn("类：{}，不存在方法:{}", aClass, Format.FormatType.NET_FORMAT.getMethodName());
            return;
        }
        Object bean = SpringContextUtil.getBean(aClass);
        if (ObjectUtil.isNull(bean)) {
            log.warn("未在容器中找到bean，beanClass：{}", aClass);
            return;
        }
        try {
            Object invoke = method.invoke(bean);
            if (invoke instanceof RestfulResponse) {
                RestfulResponse response = (RestfulResponse) invoke;
                if (response.isSuccess()) {
                    //拿到所有机构、网点的的netCodeNameMapping
                    Map<String,Map<String,String>>  netCodeName = new HashMap<>();
                    List data = JSONObject.parseObject(JSONObject.toJSONString(response.getData()),List.class);
                    data.forEach(s->{
                        Map a = (Map) s;
                        Map<String,String> netCode = new HashMap<>();
                        List l = (List)a.get("netCodeMapList");
                        l.forEach(netCodeMap->{
                            Map net = (Map) netCodeMap;
                            netCode.put(net.get("netCode").toString(),net.get("netName").toString());
                        });
                        netCodeName.put(((Map)a.get("orgCodeMap")).get("orgCode").toString(),netCode);
                    });
                    formats.forEach(format -> {
                        format.getFields().forEach(field -> {
                            Format annotation = field.getAnnotation(Format.class);
                            String orgCodeFieldName = annotation.fieldName()[0];
                            String netCodeFieldName = annotation.fieldName()[1];
                            String orgCode = ObjectUtil.isNotNull(ReflectUtil.getFieldValue(format.getObj(), orgCodeFieldName)) ? ReflectUtil.getFieldValue(format.getObj(), orgCodeFieldName).toString() : "";
                            String netCode = ObjectUtil.isNotNull(ReflectUtil.getFieldValue(format.getObj(), netCodeFieldName)) ? ReflectUtil.getFieldValue(format.getObj(), netCodeFieldName).toString() : "";
                            if (StringUtils.isNotEmpty(orgCode) && StringUtil.isNotEmpty(netCode)) {
                                Map<String, String> net = netCodeName.get(orgCode);
                                if (CommonConst.ALL.equals(netCode)){
                                    ReflectUtil.setFieldValue(format.getObj(), field, CommonConst.ALL_NET);
                                }else {
                                    ReflectUtil.setFieldValue(format.getObj(), field, annotation.rule().getValue(netCode, ObjectUtil.isNull(net) ? "" : net.get(netCode)));
                                }
                            }
                        });
                    });
                } else {
                    log.warn("调用接口失败");
                    return;
                }
            }
        } catch (Exception e) {
            log.warn("调用方法异常");
        }

    }
}
