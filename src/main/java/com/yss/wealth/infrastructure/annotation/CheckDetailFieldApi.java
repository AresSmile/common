package com.yss.wealth.infrastructure.annotation;

import com.yss.wealth.infrastructure.common.EDataFormat;

import java.lang.annotation.*;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * @description：对比详情需要展示的字段，添加此注解
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckDetailFieldApi {
    /**
     * 字段中文名称
     */
    String value() default "";

}
