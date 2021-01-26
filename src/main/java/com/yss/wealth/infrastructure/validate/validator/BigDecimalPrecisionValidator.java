package com.yss.wealth.infrastructure.validate.validator;

import com.yss.wealth.infrastructure.validate.annotation.BigDecimalPrecision;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * @author shihao
 * @date 2020/11/04
 * @description BigDecimal 检查
 **/
@Slf4j
public class BigDecimalPrecisionValidator implements ConstraintValidator<BigDecimalPrecision, BigDecimal> {

    /**
     * 小数点
     */
    private static final String POINT = ".";

    /**
     * 2
     */
    private static final int COUNT = 2;

    /**
     * 整数位长度
     */
    private int pointPreMaxLength;

    /**
     * 小数位长度
     */
    private int pointAfterLength;

    /**
     * 初始化
     *
     * @param bigDecimalPrecision bigDecimalPrecision
     * @author shihao
     */
    @Override
    public void initialize(BigDecimalPrecision bigDecimalPrecision) {
        log.info("init BigDecimalPrecision");
        this.pointPreMaxLength = bigDecimalPrecision.pointPreMaxLength();
        this.pointAfterLength = bigDecimalPrecision.pointAfterLength();
    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext constraintValidatorContext) {
        log.info("judge BigDecimal precision, value: {}", value);
        // value 为 null 的时候，就不用继续判断了。因为这里只关心value的精度问题，不关心是否必输。
        if (value == null) {
            return true;
        } else {
//            String realValue = value.toString();
            String realValue = value.toPlainString();
            // 判断是否包含小数位
            if (realValue.contains(POINT)) {
                String[] valueArray = realValue.split("\\" + POINT, -1);

                if (valueArray.length != COUNT) {
                    return false;
                }

                // 整数位 最大长度判断
                // 小数位 最大长度判断
                return valueArray[0].length() <= this.pointPreMaxLength &&
                        valueArray[1].length() <= this.pointAfterLength;
            } else {
                // 如果没有小数位,则直接判断 整数位的长度 是否 小于等于 指定的整数位最大长度
                return realValue.length() <= this.pointPreMaxLength;
            }
        }
    }
}
