package com.yss.wealth.infrastructure.annotation;

import java.lang.annotation.*;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * @description：为微服务调用之间的返回值设置value
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Property {
    /**
     * 是否
     */
    String name() default "";

    /**
     * 对应的实现类对象
     */
    Class<?> realize() default Object.class;

    /**
     * 对应的实现方法名
     */
    String method() default "";

    /**
     * 其他定key，如数据字典dictionaryId
     *
     * @return
     */
    String other() default "";

    /**
     * 是否在列表查询时获取该值(为提高查询效率，有些值不在列表显示，设为false后将不会查询)
     *
     * @return
     */
    boolean search() default true;
}
