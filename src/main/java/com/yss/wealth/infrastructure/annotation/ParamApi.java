package com.yss.wealth.infrastructure.annotation;

import com.yss.wealth.infrastructure.common.EDataFormat;

import java.lang.annotation.*;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * @description：为微服务调用之间的返回值设置value
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface ParamApi {
    /**
     * 参数
     */
    String value() default "";
    /**
     * 是否必填项
     */
    boolean required() default false;

    /**
     * 错误提示码
     */
    String code() default "";

    /**
     * 错误提示信息
     */
    String message() default "";

    /**
     * 最小值(数字类型)
     *
     * @return
     */
    double minVal() default 0;

    /**
     * 最大值(数字类型)
     *
     * @return
     */
    double maxVal() default Double.MAX_VALUE;

    /**
     * 最大长度(数字类型)
     *
     * @return
     */
    int maxLength() default Integer.MAX_VALUE;

    /**
     * 数据校验格式
     *
     * @return
     */
    EDataFormat dataFormat() default EDataFormat.DEVALUE;
}
