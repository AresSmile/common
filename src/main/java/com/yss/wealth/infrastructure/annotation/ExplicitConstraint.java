/****************************************************
 * 创建人：@author fengxin
 * 创建时间: 2020/3/20/13:19
 * 项目名称: dfbp-repo-manage
 * 文件名称: FontHeight.java
 * 文件描述: excel导出下拉选值
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.yss.wealth.infrastructure.annotation;

import java.lang.annotation.*;

/**
 * 此注解用于excel导出时指定某一列的取值范围
 * @author Ctrl-C master
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExplicitConstraint {
    // 定义固定下拉选值来源数组
    String[] source() default {};

    // 定义动态下拉内容，取自数据字典
    Class[]sourceClass()default {};
}
