package com.yss.wealth.infrastructure.annotationprocessor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.yss.wealth.infrastructure.annotation.Format;
import com.yss.wealth.infrastructure.common.RestfulResponse;
import com.yss.wealth.infrastructure.constant.CommonConst;
import com.yss.wealth.infrastructure.util.BeanUtilExtend;
import com.yss.wealth.infrastructure.util.CollectionUtil;
import com.yss.wealth.infrastructure.util.SpringContextUtil;
import com.yss.wealth.infrastructure.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author:zhuhongmin
 * @date:2020/7/30
 * @description: 注解解释类（产品代码解释）
 **/
@Slf4j
public class PrdFormatProcessor implements FormatProcessor {
    @Override
    public boolean match(Format.FormatType type) {
        return Format.FormatType.PRD_FORMAT.equals(type);
    }


    @Override
    public void format(List<BeanUtilExtend.InnerFormat> formats) {
        if (CollectionUtil.isEmpty(formats)) {
            return;
        }
        String interfaceName = "";
        String methodName = "";
        Format f = formats.get(0).getFields().get(0).getAnnotation(Format.class);
        if (StringUtil.isNotEmpty(f.interfaceName())) {
            interfaceName = f.interfaceName();
        } else {
            interfaceName = Format.FormatType.PRD_FORMAT.getInterfaceName();
        }
        if (StringUtil.isNotEmpty(f.methodName())) {
            methodName = f.methodName();
        } else {
            methodName = Format.FormatType.PRD_FORMAT.getMethodName();
        }
        Class<?> aClass;
        try {
            aClass = Class.forName(interfaceName);
        } catch (ClassNotFoundException e) {
            log.warn("类：{}，不存在！无法格式化产品名称，请检查依赖！", interfaceName);
            return;
        }
        Method method = ReflectUtil.getMethod(aClass, methodName);
        if (ObjectUtil.isNull(method)) {
            log.warn("类：{}，不存在方法:{}", aClass, methodName);
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
                    //拿到所有产品的codenamemapping
                    Map data = (Map) response.getData();
                    formats.forEach(format -> {
                        format.getFields().forEach(field -> {
                            Format annotation = field.getAnnotation(Format.class);
                            String fieldName = annotation.fieldName()[0];
                            String prdCode = ObjectUtil.isNotNull(ReflectUtil.getFieldValue(format.getObj(), fieldName)) ? ReflectUtil.getFieldValue(format.getObj(), fieldName).toString() : "";
                            if (StringUtils.isNotEmpty(prdCode)) {
                                if (CommonConst.ALL.equals(prdCode)){
                                    ReflectUtil.setFieldValue(format.getObj(), field, CommonConst.ALL_PRD);
                                }else {
                                    ReflectUtil.setFieldValue(format.getObj(), field, annotation.rule().getValue(prdCode, ObjectUtil.isNull(data.get(prdCode)) ? "" : data.get(prdCode).toString()));
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
