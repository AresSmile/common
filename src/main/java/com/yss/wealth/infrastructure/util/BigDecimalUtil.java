package com.yss.wealth.infrastructure.util;

import com.yss.wealth.infrastructure.constant.DicConst;
import com.yss.wealth.infrastructure.constant.SysParamConst;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author hy-copy-shihao
 * @version 1.0, 2020-11-12
 * @see
 * @since 1.0, 2020-11-12
 */
@Slf4j
public class BigDecimalUtil {
    /**
     * 小数点
     */
    private static final String POINT = ".";

    /**
     * 2
     */
    private static final int COUNT = 2;

    /**
     *
     */
    public static boolean judgePrecision(BigDecimal value, int pointPreMaxLength, int pointAfterLength) {
        // value 为 null 的时候，就不用继续判断了。因为这里只关心value的精度问题，不关心是否必输。
        if (value == null) {
            return true;
        } else {
            String realValue = value.toString();
            // 判断是否包含小数位
            if (realValue.contains(POINT)) {
                String[] valueArray = realValue.split("\\" + POINT, -1);

                if (valueArray.length != COUNT) {
                    return false;
                }

                // 整数位 最大长度判断
                // 小数位 最大长度判断
                return valueArray[0].length() <= pointPreMaxLength &&
                        valueArray[1].length() <= pointAfterLength;
            } else {
                // 如果没有小数位,则直接判断 整数位的长度 是否 小于等于 指定的整数位最大长度
                return realValue.length() <= pointPreMaxLength;
            }
        }
    }

    /**
     * @param precisionType 精度处理方式
     * @return
     */
    public static RoundingMode roundingModeMapping(String precisionType) {
        Assert.notEmpty(precisionType, "精度处理方式不能为空");
        switch (precisionType) {
            case DicConst.AMOUNT_PRECISION_PROCESSING_0:
                return RoundingMode.HALF_UP;
            case DicConst.AMOUNT_PRECISION_PROCESSING_1:
                return RoundingMode.FLOOR;
            case DicConst.AMOUNT_PRECISION_PROCESSING_2:
                return RoundingMode.DOWN;
            case DicConst.AMOUNT_PRECISION_PROCESSING_3:
                return RoundingMode.UP;
            default:
                log.warn("不合理的精度处理方式参数:{}", precisionType);
                break;
        }
        // 默认四舍五入
        return RoundingMode.HALF_UP;
    }

    /**
     * @param precisionNum 精度保留位数的字典值
     * @return
     */
    public static int precisionNumMapping(String precisionNum) {
        Assert.notEmpty(precisionNum, "产品参数【精度的保留位数】字典值不能为空");
        switch (precisionNum) {
            case DicConst.DECIMAL_RESERVATION_0:
                return 16;
            case DicConst.DECIMAL_RESERVATION_1:
                return 8;
            case DicConst.DECIMAL_RESERVATION_2:
                return 4;
            case DicConst.DECIMAL_RESERVATION_3:
                return 2;
            default:
                log.warn("不合理的产品参数【精度的保留位数】字典值:{}", precisionNum);
                break;
        }
        // 默认保留两位小数
        return 2;
    }

    /**
     * 系统小数位字典处理映射
     *
     * @param scaleType 小数位字典值
     * @return
     */
    public static int scaleMapping(String scaleType) {
        switch (scaleType) {
            case DicConst.DECIMAL_RESERVATION_0:
                return 16;
            case DicConst.DECIMAL_RESERVATION_1:
                return 8;
            case DicConst.DECIMAL_RESERVATION_2:
                return 4;
            case DicConst.DECIMAL_RESERVATION_3:
                return 2;
            default:
                return 0;
        }
    }

    /**
     * @param yearDayDic 精度保留位数的字典值
     * @return
     */
    public static int yearDaysMapping(String yearDayDic) {
        Assert.notEmpty(yearDayDic, "系统参数【年天】字典值不能为空");
        switch (yearDayDic) {
            case SysParamConst.INTEREST_YEAR_DAY_0:
                return 360;
            case SysParamConst.INTEREST_YEAR_DAY_1:
                return 365;
            default:
                log.warn("不合理的系统参数【年天】字典值:{}", yearDayDic);
                break;
        }
        // 默认保留两位小数
        return 365;
    }

}
