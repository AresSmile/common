package com.yss.wealth.infrastructure.annotationprocessor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.yss.wealth.infrastructure.annotation.Format;
import com.yss.wealth.infrastructure.common.RestfulResponse;
import com.yss.wealth.infrastructure.constant.CommonConst;
import com.yss.wealth.infrastructure.util.BeanUtilExtend;
import com.yss.wealth.infrastructure.util.SpringContextUtil;
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
public class OrgFormatProcessor implements FormatProcessor {
    @Override
    public boolean match(Format.FormatType type) {
        return Format.FormatType.ORG_FORMAT.equals(type);
    }


    @Override
    public void format(List<BeanUtilExtend.InnerFormat> formats) {
        //机构代码的格式化，直接走默认的接口去格式化机构名称
        Class<?> aClass;
        try {
            aClass = Class.forName(Format.FormatType.ORG_FORMAT.getInterfaceName());
        } catch (ClassNotFoundException e) {
            log.warn("类：{}，不存在！无法格式化机构名称，请检查依赖！", Format.FormatType.ORG_FORMAT.getInterfaceName());
            return;
        }
        Method method = ReflectUtil.getMethod(aClass, Format.FormatType.ORG_FORMAT.getMethodName());
        if (ObjectUtil.isNull(method)) {
            log.warn("类：{}，不存在方法:{}", aClass, Format.FormatType.ORG_FORMAT.getMethodName());
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
                    //拿到所有机构的的codenamemapping
                    Map data = (Map) response.getData();
                    formats.forEach(format -> {
                        format.getFields().forEach(field -> {
                            Format annotation = field.getAnnotation(Format.class);
                            String fieldName = annotation.fieldName()[0];
                            String orgCode = ObjectUtil.isNotNull(ReflectUtil.getFieldValue(format.getObj(), fieldName))?ReflectUtil.getFieldValue(format.getObj(), fieldName).toString():"";
                            if ( StringUtils.isNotEmpty(orgCode)) {
                                if (CommonConst.ALL.equals(orgCode)){
                                    ReflectUtil.setFieldValue(format.getObj(), field, CommonConst.ALL_ORG);
                                }else {
                                    ReflectUtil.setFieldValue(format.getObj(), field, annotation.rule().getValue(orgCode, ObjectUtil.isNull(data.get(orgCode)) ? "" : data.get(orgCode).toString()));
                                }
                            }
                        });
                    });

                } else {
                    log.warn("调用接口失败");
                }
            }
        } catch (Exception e) {
            log.warn("调用方法异常");
        }

    }
}
