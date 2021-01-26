package com.yss.wealth.infrastructure.annotation;


import java.lang.annotation.*;

/**
 * 包名称：com.win.dfas.common.annotation
 * 类名称：WinExcelTemplateDic
 * 类描述：Excel导入模板数据字典下拉框注解
 * 创建人：@author zhaokai
 * 创建时间：2020/9/25 14:34
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface WinExcelTemplateDic {

    /**
     * Excel下拉框列位置，默认从0开始
     * @return
     */
    int index() default 0;

    //可以放多个 父类code    数据字典code，类似：sales_organization_category
    String[] dicCode() default {};

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
}
