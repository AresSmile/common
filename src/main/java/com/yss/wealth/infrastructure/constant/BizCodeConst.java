package com.yss.wealth.infrastructure.constant;

/**
 * 包名称： com.yss.wealth.infrastructure.constant
 * 类名称：TaBizCodeConstants
 * 类描述：TA业务代码
 * 创建人：@author LiangJianAn
 * 创建时间：2020/9/23 13:35
 */
public interface BizCodeConst {

    /*申请业务类型*/

    /**
     * 开户申请
     */
    String ACC_OPEN_APP = "001";
    /**
     * 销户申请
     */
    String ACC_CANCEL_APP = "002";
    /**
     * 账户信息修改申请
     */
    String ACC_INFO_MODIFY_APP = "003";
    /**
     * 增加交易账户申请
     */
    String INCR_TRADE_ACC_APP = "008";
    /**
     * 变更交易账号
     */
    String CHANGE_TRADE_ACC = "058";
    /**
     * 撤销交易账户申请
     */
    String CANCEL_TRADE_ACC_APP = "009";
    /**
     * 基金账户冻结申请
     */
    String FUND_ACC_FRZ_APP = "004";
    /**
     * 基金账户解冻申请
     */
    String FUND_ACC_UNFRZ_APP = "005";
    /**
     * 基金账户卡解挂申请
     */
    String FUND_ACC_CARD_CANCEL_APP = "007";
    /**
     * 基金账户卡挂失申请
     */
    String FUND_ACC_CARD_LOSS_APP = "006";
    /**
     * 认购申请
     */
    String SUB_APP = "020";
    /**
     * 申购申请
     */
    String PUR_APP = "022";
    /**
     * 定时定额申购申请
     */
    String RATION_PUR_APP = "039";
    /**
     * 赎回申请
     */
    String RED_APP = "024";
    /**
     * 预约赎回申请
     */
    String RED_APP_IN_ADVANCE = "025";
    /**
     * 定时定额赎回申请
     */
    String RATION_RED_APP = "063";
    /**
     * 转销售人/机构申请
     */
    String RESELLE_ORG_APP = "026";
    /**
     * 转销售人/机构转入申请
     */
    String RESELLE_ORG_APP_IN = "027";
    /**
     * 转销售人/机构转出申请
     */
    String RESELLE_ORG_APP_OUT = "028";
    /**
     * 设置自动再投资申请
     */
    String AUTOMATIC_REINVESTMENT_APP = "029";
    /**
     * 基金份额冻结申请
     */
    String FUND_SHARE_FRZ_APP = "031";
    /**
     * 基金份额解冻申请
     */
    String FUND_SHARE_UNFRZ_APP = "032";
    /**
     * 基金转换申请
     */
    String FUND_COVERSION_APP = "036";
    /**
     * 基金转换转入申请
     */
    String FUND_COVERSION_APP_IN = "037";
    /**
     * 基金转换转出申请
     */
    String FUND_COVERSION_APP_OUT = "038";
    /**
     * 强制赎回
     */
    String FORCE_RED_APP = "042";
    /**
     * 044-份额强增-申请
     */
    String SHARE_FORCE_INCR_APP = "044";
    /**
     * 045-份额强减-申请
     */
    String SHARE_FORCE_DECR_APP = "045";
    /**
     * 撤预约单
     */
    String CANCEL_APPLY_IN_ADVANCE = "053";
    /**
     * 定时定额申购开通申请
     */
    String OPEN_RATION_PUR_APP = "059";
    /**
     * 定时定额申购撤销申请
     */
    String CANCEL_RATION_PUR_APP = "060";
    /**
     * 定时定额变更申请
     */
    String CHANGE_RATION_PUR_APP = "061";
    /**
     * 认购调整申请
     */
    String SUB_ADJUST_APP = "062";
    /**
     * TA发起的移行
     */
    String MIGRATION = "070";
    /**
     * 基金质押申请
     */
    String FUND_PLEDGE_APP = "088";

    /**
     * 强增
     */
    //String FORCE_IN = "";

    /**
     * 强减
     */
    String FORCE_RE = "082";

    /**
     * 快速过户申请
     */
    String FAST_TRANSFER_APP = "098";




    /*确认业务类型*/

    /**
     * 开户确认
     */
    String ACC_OPEN_CFM = "101";
    /**
     * 销户确认
     */
    String ACC_CANCEL_CFM = "102";
    /**
     * 账户信息修改确认
     */
    String ACC_INFO_MODIFY_CFM = "103";
    /**
     * 增加交易账户确认
     */
    String INCR_TRADE_ACC_CFM = "108";
    /**
     * 变更交易账号确认
     */
    String CHANGE_TRADE_ACC_CFM = "158";
    /**
     * 撤销交易账户确认
     */
    String CANCEL_TRADE_ACC_CFM = "109";
    /**
     * 基金账户冻结确认
     */
    String FUND_ACC_FRZ_CFM = "104";
    /**
     * 基金账户解冻确认
     */
    String FUND_ACC_UNFRZ_CFM = "105";
    /**
     * 基金账户卡解挂确认
     */
    String FUND_ACC_CARD_CANCEL_CFM = "107";
    /**
     * 基金账户卡挂失确认
     */
    String FUND_ACC_CARD_LOSS_CFM = "106";
    /**
     * 认购确认
     */
    String SUB_CFM = "120";
    /**
     * 申购确认
     */
    String PUR_CFM = "122";
    /**
     * 定时定额申购确认
     */
    String RATION_PUR_CFM = "139";
    /**
     * 赎回确认
     */
    String RED_CFM = "124";
    /**
     * 强行赎回确认
     */
    String FORCE_RED_CFM = "142";
    /**
     * 发行失败
     */
    String RELEASE_FAILED = "140";
    /**
     * 定时定额赎回确认
     */
    String RATION_RED_CFM = "163";
    /**
     * 预约赎回确认
     */
    String RED_CFM_IN_ADVANCE = "125";
    /**
     * 转销售人/机构确认
     */
    String RESELLE_ORG_CFM = "126";
    /**
     * 转销售人/机构转入确认
     */
    String RESELLE_ORG_CFM_IN = "127";
    /**
     * 转销售人/机构转出确认
     */
    String RESELLE_ORG_CFM_OUT = "128";
    /**
     * 设置自动再投资确认
     */
    String AUTOMATIC_REINVESTMENT_CFM = "129";
    /**
     * 基金成立
     */
    String SUB_RESULT = "130";
    /**
     * 基金份额冻结确认
     */
    String FUND_SHARE_FRZ_CFM = "131";
    /**
     * 基金份额解冻确认
     */
    String FUND_SHARE_UNFRZ_CFM = "132";
    /**
     * 基金红利解冻确认
     */
    String FUND_DIVIDE_UNFRZ_CFM = "157";
    /**
     * 非交易过户转入确认
     */
    String NONTRADE_TRANSFER_CFM_IN = "134";
    /**
     * 非交易过户转出确认
     */
    String NONTRADE_TRANSFER_CFM_OUT = "135";
    /**
     * 基金转换转入确认
     */
    String FUND_CHANGE_CFM_IN = "137";
    /**
     * 基金转换转出确认
     */
    String FUND_CHANGE_CFM_OUT = "138";
    /**
     * 撤预约单确认
     */
    String CANCEL_APPOINTMENT_CFM = "153";
    /**
     * 强行调增
     */
    String FORCE_INCR = "144";
    /**
     * 强行调减
     */
    String FORCE_DECR = "145";
    /**
     * 认购调整确认
     */
    String SUB_ADJUST_CFM = "162";
    /**
     * 定时定额申购开通确认
     */
    String OPEN_RATION_PUR_CFM = "159";
    /**
     * 定时定额申购撤销确认
     */
    String CANCEL_RATION_PUR_CFM = "160";
    /**
     * 定时定额变更确认
     */
    String CHANGE_RATION_PUR_CFM = "161";
    /**
     * 基金质押确认
     */
    String FUND_PLEDGE_CFM = "188";
    /**
     * 快速过户确认
     */
    String QUICK_TRANSFER_CFM = "198";
    /**
     * 募集失败
     */
    String FAILED_RAISE = "149";
    /**
     * 基金清盘
     */
    String FUND_LIQUIDATION = "150";
    /**
     * 基金终止
     */
    String FUND_TERMINATION = "151";
    /**
     * 强行赎回
     */
    String FORCED_RED = "142";
    /**
     * 红利发放
     */
    String BONUS_DISTRIBUTE = "143";
    /**
     * 配号
     */
    String MATCHING_NUMBER = "146";
    /**
     * 基金销售人资金清算
     */
    String FUND_ORG_ASSET_CLEAR = "155";
    /**
     * 红利解冻
     */
    String BONUS_UNFRZ = "157";
    /**
     * 积分确认
     */
    String POINTS_CFM = "169";
}
