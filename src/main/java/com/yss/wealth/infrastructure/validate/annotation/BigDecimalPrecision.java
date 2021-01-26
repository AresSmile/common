package com.yss.wealth.infrastructure.validate.annotation;

import com.yss.wealth.infrastructure.validate.validator.BigDecimalPrecisionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shihao
 * @date 2020/11/04
 * @description BigDecimal 精度检查
 **/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {BigDecimalPrecisionValidator.class}
)
@Target({ElementType.FIELD})
public @interface BigDecimalPrecision {

    /**
     * 整数位 最大长度
     */
    int pointPreMaxLength();

    /**
     * 小数位 最大长度
     */
    int pointAfterLength();

    String message() default "精度有误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
