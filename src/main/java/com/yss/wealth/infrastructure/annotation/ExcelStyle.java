/****************************************************
 * 创建人：@author fengxin    
 * 创建时间: 2020/3/20/13:19
 * 项目名称: dfbp-repo-manage
 * 文件名称: FontHeight.java
 * 文件描述: excel导出表头字体高度
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.yss.wealth.infrastructure.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 包名称：com.win.dfas.common.annotation
 * 类名称：ExcelStyle
 * 类描述：excel导出样式参数设置注解
 * 创建人：@author fengxin
 * 创建时间：2020/3/20/13:19
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelStyle {
    /**
     * 表头字体大小
     */
    int headFontHeight() default 11;
    /**
     * 表头背景色 默认为天蓝色
     * @see org.apache.poi.ss.usermodel.IndexedColors
     */
    int headBackColor() default 40;

    /**
     * 内容字体大小
     */
    int contentFontHeight() default 11;

    /**
     * 内容背景色 默认为白色
     * @see org.apache.poi.ss.usermodel.IndexedColors
     */
    int contentBackColor() default 9;

    /**
     * 边框颜色 默认为黑色
     * @see org.apache.poi.ss.usermodel.IndexedColors
     */
    int borderColor() default 8;
    /**
     * 边框样式 默认为THIN
     * @see org.apache.poi.ss.usermodel.BorderStyle
     */
    int borderStyle() default 1;

}
