package com.yss.wealth.infrastructure.annotation;

import java.lang.annotation.*;

/**
 * @author xuanfei.Chen
 * @description 符号转换标志
 * @date 2020/5/11 15:37
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Symbol {
}
