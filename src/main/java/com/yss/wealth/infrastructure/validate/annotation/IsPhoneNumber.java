package com.yss.wealth.infrastructure.validate.annotation;

import com.yss.wealth.infrastructure.validate.validator.IsPhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
*
* @author:zhuhongmin
* @date:2020/10/22
* @description:
**/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {IsPhoneNumberValidator.class}
)
@Target({ElementType.FIELD})
public @interface IsPhoneNumber {
    String message() default "电话号码格式有误";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
