package com.yss.wealth.infrastructure.util;

import com.yss.wealth.infrastructure.common.MessageException;
import com.yss.wealth.infrastructure.constant.DicConst;

/**
 * 包名称： com.yss.wealth.infrastructure.util
 * 类名称：SwitchBizCodeUtil
 * 类描述：转换业务代码工具类
 * 创建人：@author LiangJianAn
 * 创建时间：2021/1/5 15:33
 */
public class SwitchBizCodeUtil {

    /**
     * 按照份额明细时，获取费用信息时业务代码的转换
     *
     * @param bizCode
     * @return
     */
    public static String switchBizCodeFeeByShareDetail(String bizCode) {
        if (DicConst.ORIGIN_SOURCE_SHARE_1.equals(bizCode)) {
            return DicConst.PRD_FEE_BIZ_CODE_0;
        }
        if (DicConst.ORIGIN_SOURCE_SHARE_2.equals(bizCode)) {
            return DicConst.PRD_FEE_BIZ_CODE_1;
        }
        throw MessageException.builder().message("按照份额明细时, 获取费用信息时业务代码的转换, 未识别的业务代码【" + bizCode + "】").build();
    }


    /**
     * 获取费用信息时业务代码的转换
     *
     * @param bizCode
     * @return
     */
    public static String switchBizCodeFee(String bizCode) {
        switch (bizCode) {
            case DicConst.TRANSACTION_BUSINESS_TYPE_020:
                return DicConst.PRD_FEE_BIZ_CODE_0;
            case DicConst.TRANSACTION_BUSINESS_TYPE_022:
                return DicConst.PRD_FEE_BIZ_CODE_1;
            case DicConst.TRANSACTION_BUSINESS_TYPE_024:
            case DicConst.TRANSACTION_BUSINESS_TYPE_025:
            case DicConst.TRANSACTION_BUSINESS_TYPE_063:
                return DicConst.PRD_FEE_BIZ_CODE_2;
            case DicConst.TRANSACTION_BUSINESS_TYPE_036:
                return DicConst.PRD_FEE_BIZ_CODE_3;
            default:
                throw new MessageException("获取费用信息时业务代码的转换, 未识别的业务代码【" + bizCode + "】");
        }
    }

    /**
     * 获取折扣优惠信息时业务代码的转换
     *
     * @param bizCode
     * @return
     */
    public static String switchBicCodeDiscount(String bizCode) {
        switch (bizCode) {
            case DicConst.TRANSACTION_BUSINESS_TYPE_020:
                return DicConst.PRD_DISCOUNT_BIZ_CODE_0;
            case DicConst.TRANSACTION_BUSINESS_TYPE_022:
                return DicConst.PRD_DISCOUNT_BIZ_CODE_1;
            case DicConst.TRANSACTION_BUSINESS_TYPE_024:
            case DicConst.TRANSACTION_BUSINESS_TYPE_025:
            case DicConst.TRANSACTION_BUSINESS_TYPE_063:
                return DicConst.PRD_DISCOUNT_BIZ_CODE_4;
            case DicConst.TRANSACTION_BUSINESS_TYPE_036:
                return DicConst.PRD_DISCOUNT_BIZ_CODE_5;
            default:
                throw new MessageException("获取折扣优惠信息时业务代码的转换, 未识别的业务代码【" + bizCode + "】");
        }
    }

    /**
     * 获取归基金资产信息时业务代码的转换
     *
     * @param bizCode
     * @return
     */
    public static String switchBicCodeBelongToPrd(String bizCode) {
        switch (bizCode) {
            case DicConst.TRANSACTION_BUSINESS_TYPE_024:
            case DicConst.TRANSACTION_BUSINESS_TYPE_025:
            case DicConst.TRANSACTION_BUSINESS_TYPE_063:
                return DicConst.PRD_ASSET_RATE_BIZ_TYPE_REDEMPTION;
            case DicConst.TRANSACTION_BUSINESS_TYPE_036:
                return DicConst.PRD_ASSET_RATE_BIZ_TYPE_SWITCH;
            default:
                throw new MessageException("获取归基金资产信息时业务代码的转换, 未识别的业务代码【" + bizCode + "】");
        }
    }
}
