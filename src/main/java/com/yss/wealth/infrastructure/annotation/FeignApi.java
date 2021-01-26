package com.yss.wealth.infrastructure.annotation;

import java.lang.annotation.*;

/**
 * @author libihui
 * @version 1.0 2020/1/16
 * @description：是否提供给其他微服务调用的REST API
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface FeignApi {
}
