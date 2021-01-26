package com.yss.wealth.infrastructure.annotation;

import com.yss.wealth.infrastructure.enums.DicFormatTypeEnum;

import java.lang.annotation.*;

/**
*
* @author:zhuhongmin
* @date:2020/4/17
* @description:
**/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
public @interface DicFormat {
    /**
     * 字段名
     * @return
     */
    String fieldName() default "";

    /**
     * 数据字典code，类似：sales_organization_category
     * @return
     */
    String dicCode() default "";


    /**
     * 接口类，用于去查询字典值的接口
     * @return
     */
    Class interfaceClass() default Object.class;

    /**
     * 方法名，用于去查询字典值得接口
     * @return
     */
    String methodName() default "getDictionaryMap";
    /**
     * 默认值
     * @return
     */
    String defaultValue() default "";

    /**
     * 字典格式化方式，默认直接去字典值
     * @return
     */
    DicFormatTypeEnum formatType() default DicFormatTypeEnum.DEFAULT;
}
