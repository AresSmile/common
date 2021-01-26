package com.yss.wealth.infrastructure.validate.validator;


import cn.hutool.core.util.ObjectUtil;
import com.yss.wealth.infrastructure.validate.annotation.IsPhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author:zhuhongmin
 * @date:2020/10/22
 * @description: 电话号码校验器
 **/
public class IsPhoneNumberValidator implements ConstraintValidator<IsPhoneNumber, Object> {
    private static Pattern pattern = Pattern.compile("/^1[3456789]d{9}$/");

    @Override
    public void initialize(IsPhoneNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        return ObjectUtil.isNotNull(o) && pattern.matcher(o.toString()).matches();
    }
}
