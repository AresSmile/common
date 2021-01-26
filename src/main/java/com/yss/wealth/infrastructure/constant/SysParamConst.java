package com.yss.wealth.infrastructure.constant;

/**
 * @author:zhuhongmin
 * @date:2020/7/23
 * @description: 系统参数常量
 **/
public interface SysParamConst {

    /********参数类型【begin】********/
    /**
     * 业务系统参数
     */
    String TYPE_SYS_BIZ = "sysbiz";
    /**
     * 交易类参数
     */
    String TYPE_BIZ = "biz";
    /**
     * 账户类参数
     */
    String TYPE_ACC = "account";
    /**
     * 配置类参数
     */
    String TYPE_CONF = "config";
    /**
     * 费用类参数
     */
    String TYPE_FEE = "fee";
    /**
     * 其他类参数
     */
    String TYPE_OTHER = "other";
    /**
     * 公司信息
     */
    String TYPE_COMPANY = "company";
    /**
     * 分红类参数
     */
    String TYPE_DIVIDEND = "dividend";
    /********参数类型【end】********/

    /********参数代码【begin】********/
    /**
     * TA代码
     */
    String TA_CODE = "TaCode";
    /**
     * 需要复核
     */
    String AUDIT = "Audit";
    /**
     * 行情文件的路径
     */
    String NAV_PATH = "NavPath";
    /**
     * 行情文件的版本
     */
    String NAV_VERSION = "NavVersion";
    /**
     * 文件扫描终止时间
     */
    String SCAN_TIME = "SacnTime";
    /**
     * 基金账号的全局序号
     */
    String SYS_SEQUENCE = "SysSequence";
    /**
     * 允许多次账户冻结
     */
    String MULTI_ACT_FRZ = "MultiActFreeze";
    String MULTI_ACT_FRZ_NO = "0";
    String MULTI_ACT_FRZ_YES = "1";

    /**
     * 份额冻结允许账户冻结(0-不允许，1-允许)
     */
    String ACT_FRZ_ON_SHARE_FRZ = "ActFreezeOnShareFreeze";
    String ACT_FRZ_ON_SHARE_FRZ_NO = "0";
    String ACT_FRZ_ON_SHARE_FRZ_YES = "1";

    /**
     * TA发起业务立即确认
     */
    String TA_CFM_IMMEDIATELY = "TACfmImmediately";

    /**
     * 基金公司代码
     */
    String FUND_COMPANY_CODE = "FundCompanyCode";

    /**
     * 分红登记日以及前n个工作日不能修改分红方式
     */
    String DIVID_CHANGE_BEFORE_NWORKDAY = "DividendChangeBeforeNWorkDay";

    /**
     * 客户资料修改是否允许修改证件号码: 0-不允许，1-允许
     */
    String ALLOW_CHANGE_CERT_CODE = "AllowChangeCertCode";

    /**
     * 客户资料修改是否允许修改客户名称: 0-不允许，1-允许
     */
    String ALLOW_CHANGE_CUST_NAME = "AllowChangeCustName";

    /**
     * 不允许同时修改客户名称和证件号码: 0-不允许，1-允许
     */
    String ALLOW_CHANGE_CUST_NAME_CERT_CODE = "AllowChangeCustNameCertCode";

    /**
     * 允许部分份额解冻
     */
    String ALLOW_PARTIAL_SHARE_UNFRZ = "AllowPartialShareUnfreeze";

    /**
     * 份额冻结解冻必须由TA发起
     */
    String SHARE_FRZ_MUST_FROM_TA = "ShareFrozenMustFromTA";
    //否
    String SHARE_FRZ_MUST_FROM_TA_0 = "0";
    //是
    String SHARE_FRZ_MUST_FROM_TA_1 = "1";
    //按销售商设置
    String SHARE_FRZ_MUST_FROM_TA_2 = "2";
    //按基金销售商设置
    String SHARE_FRZ_MUST_FROM_TA_3 = "3";

    /**
     * 登记日N天内不允许做非交易过户
     */
    String NONTRADING_TRANSFER_BEFORE_N_DAY = "NontradingTransferBeforeNDay";

    /**
     * 账户冻结是否允许非交易过户：0：否 1：是
     */
    String NONTRADING_TRANSFER_ON_ACT_FROZEN = "NontradingTransferOnActFrozen";

    /**
     * 货币基金当日新增收益参与兑付规则：0-按基金销售商设置（可修改）；1-按基金信息设置
     */
    String ADD_INCOME_CASH = "AddIncomeCash";

    /**
     * 分红期间是否允许解冻 0：否 1：是
     */
    String ALLOW_UNFRZ_ON_DIVIDENDS = "AllowUnfreezeOnDividends";

    /**
     * 超额申购后定期定额申购按比例确认  0-100%确认 1-按比例确认
     */
    String EXCESS_SUB_RATIO_CFM_TYPE = "ExcessSubscribeRatioCfmType";
    //0-100%确认
    String EXCESS_SUB_RATIO_CFM_TYPE_0 = "0";
    //100%
    int EXCESS_SUB_RATIO_CFM_TYPE_0_VALUE = 1;
    //1-按比例确认
    String EXCESS_SUB_RATIO_CFM_TYPE_1 = "1";

    /**
     * 认购确认处理时计算费用 0-否 1-是
     */
    String SUB_CFM_CALCULATE_COST = "SubscribeCfmCalculateCost";

    /**
     * 认申购指定费用大于TA计算结果确认失败 0-否 1-是
     */
    String PUR_SPECIFY_FEE_GT_TA_FEE_CFM_FAIL = "PurchaseSpecifyFeeGtTaFeeCfmFail";

    /**
     * 份额的精度控制  0-先计算确认份额后取精度 1-先取精度后计算确认份额
     */
    String SHARE_PRECISION_CTRL = "SharePrecisionControl";

    /**
     * 交易截止时间
     */
    String TIME_LIMIT = "TimeLimit";

    /**
     * 交易时间超过收市时间处理方式
     */
    String TIME_LIMIT_FLAG = "TimeLimitFlag";

    /**
     * 机构产品投资者是否检查经办人信息
     */
    String CHECK_TRANSACTOR = "CheckTransactor";

    /**
     * 机构产品投资者是否检查法人信息
     */
    String CHECK_TNSTREPR = "CheckTnstrepr";

    /**
     * 检查身份证长度
     */
    String CHECK_IDCARD_LENGTH = "CheckIdCardLength";

    /**
     * 检查身份证格式
     */
    String CHECK_IDCARD_FORMAT = "CheckIdCardFormat";

    /**
     * 检查身份证生日
     */
    String CHECK_IDCARD_BIRTHDAY = "CheckIdCardBirthday";

    /**
     * 检查身份证校验位
     */
    String CHECK_IDCARD_VALID = "CheckIdCardValid";

    /**
     * 投资者姓名不能包含特殊字符
     */
    String CHECK_CUST_NAME = "CheckCustName";

    /**
     * 投资者联系方式不能都为空
     */
    String CHECK_CUST_CONTACT = "CheckCustContact";

    /**
     * 投资者地址邮编不能为空
     */
    String CHECK_CUST_ADDRESS = "CheckCustAddress";

    /**
     * 个人投资者性别不能为空
     */
    String CHECK_PERSON_SEX = "CheckPersonSex";

    /**
     * 个人投资者出生日期不能为空
     */
    String CHECK_PERSON_BIRTHDAY = "CheckPersonBirthday";

    /**
     * 个人投资者职业不能为空
     */
    String CHECK_PERSON_VOCATION = "CheckPersonVocation";

    /**
     * 投资者使用其他证件类型（非身份证）并未提交出生日期时，是否视为成年人
     */
    String CHECK_PERSON_MINOR = "CheckPersonMinor";

    /**
     * 未成年人起始年龄
     */
    String MINOR_AGR = "MinorAge";

    /**
     * 未成年人开户规则
     */
    String OPEN_RULE_MINOR = "OpenRuleMinor";

    /**
     * 未成年人开户，经办人是否支持其他证件类型
     */
    String MINOR_TRANSACTOR_CERT_TYPE = "MinorTransactorCerType";

    /**
     * 账户冻结解冻必须由TA发起
     */
    String ACC_FRZ_MUST_FROM_TA = "AccountFrozenMustFromTA";

    /**
     * 冻结解冻原因必须一致
     */
    String SAME_REASON_FOR_FRZ = "SameReasonForFreezing";

    /**
     * 是否自动解冻
     */
    String ACC_AUTO_UNFRZ = "AccountAutoUnfreeze";

    /**
     * 客户名称是否是重要资料
     */
    String CUSTOM_NAME_IMPORTANT = "CustomNameImportant";

    /**
     * 重复开户的处理方式
     */
    String OVERLAPPED_ACT = "OverlappedAct";

    /**
     * 重要资料变更方式
     */
    String IMPORT_FILE_CHANGE_TYPE = "ImportantFileChangeType";

    /**
     * 相同客户依据
     */
    String SAME_CUSTOMER = "SameCustomer";

    /**
     * 机构客户是否允许开立多个基金账号
     */
    String ORG_MULTI_ACT = "OrgMultiAct";

    /**
     * 基金账户序列获取规则
     */
    String FUND_ACC_RULE = "FundAccountRule";

    /**
     * 机构客户基金账号第三位填写规则
     */
    String ORG_FUND_ACC_RULE = "OrgFundAccountRule";

    /**
     * 基金账号校验位生成规则
     */
    String VERIFY_RULE = "VerifyRule";

    /**
     * 非T日申请限制
     */
    String NOT_T_DAY_APPLY_LIMIT = "NotTDayApplyLimit";
    /**
     * 申请日期小于签约日期处理规则
     */
    String APP_DATE_CONTRACT_DATE_RULE = "ApplyDateContractDateRule";
    //1-检查特殊
    String APP_DATE_CONTRACT_DATE_RULE_MANUAL_1 = "1";
    //2-确认失败
    String APP_DATE_CONTRACT_DATE_RULE_FALSE_2 = "2";


    /**
     * 每日认购申请截止时间
     */
    String DAILY_SUB_APP_END_TIME = "DailySubscribeApplyEndTime";
    /**
     * 申请折扣若不符合销售商最大折扣则确认失败
     */
    String APP_DISCOUNT_NOT_MEET_SELLER_MAX_DISCOUNT_CFM_FAIL = "ApplyDiscountNotMeetSellerMaxDiscountConfirmFail";
    /**
     * 开通内部员工限制功能
     */
    String OPEN_INSIDE_PERSON_LIMIT = "OpenInsidePersonLimit";

    /**
     * 开通内部员工减免申购赎回费用
     * 0:参与优惠;1:不参与优惠;2:分基金设置,默认不参与优惠
     */
    String OPEN_INSIDE_PERSON_AVOID_FEE = "OpenInsidePersonAvoidFee";
    String OPEN_INSIDE_PERSON_AVOID_FEE_0 = "0";
    String OPEN_INSIDE_PERSON_AVOID_FEE_1 = "1";
    String OPEN_INSIDE_PERSON_AVOID_FEE_2 = "2";

    /**
     * 利息转份额是否需要收费
     * 0-否，1-是
     */
    String INTEREST_TRANSFER_SHARE_CAL_FEE = "InterestTransferShareCalFee";
    /**
     * 对于人工逐笔确认失败的及因销售商规模控制确认失败的导致的处理方式
     * 1-按发行失败业务下发
     * 0:按成立业务下发
     */
    String DEAL_WAY_OF_THE_MANUAL_CFM_FAIL_AND_ORG_CTL_FAIL = "DealWayOfTheManualCfmFailAndOrgCtlFail";
    String DEAL_WAY_OF_THE_MANUAL_CFM_FAIL_AND_ORG_CTL_FAIL_1 = "1";
    String DEAL_WAY_OF_THE_MANUAL_CFM_FAIL_AND_ORG_CTL_FAIL_0 = "0";

    /**
     * 禁止内部员工购买专户产品
     */
    String FORBID_INSIDE_PERSON_BUY_SPECIAL = "ForbidInsidePersonBuySpecial";

    /**
     * 开通认申购支持指定交易费功能 0-否 1-是
     */
    String OPEN_SUB_PUR_SPECIFY_TRADE_FEE = "OpenPurchaseSpecifyTradeFee";
    String OPEN_SUB_PUR_SPECIFY_TRADE_FEE_0 = "0";
    String OPEN_SUB_PUR_SPECIFY_TRADE_FEE_1 = "1";

    /**
     * 认购确认失败是否计息 0-否 1-是
     */
    String OPEN_SUB_CFM_FAIL_INTEREST = "OpenSubscribeCfmFailInterest";

    /**
     * 开通销售商计息功能 0-否 1-是
     */
    String OPEN_ORG_INTEREST = "OpenOrgInterest";

    /**
     * 定期定额是否判断起购金额  0-否 1-是
     */
    String SUB_JUDGE_APPLY_AMT = "SubscribeJudgeApplyAmt";

    /**
     * 定期定额是否检查协议信息
     */
    String SUB_CHECK_AGREEMENT = "SubscribeCheckAgreement";
    /**
     * 定期定额是否检查协议信息: 1-是
     */
    String SUB_CHECK_AGREEMENT_1 = "1";

    /**
     * 定期定额申购金额与协议不符处理方式
     */
    String SUB_AGREEMENT_DIF_TYPE = "SubscribeAgreementDifType";
    /**
     * 定期定额申购金额与协议不符处理方式: 0-按失败处理
     */
    String SUB_AGREEMENT_DIF_TYPE_0 = "0";

    /**
     * 是否从身份证提取个人信息
     */
    String GETINFO_BYIDCARD = "GetInfoByIdCard";
    /**
     * 认申购业务固定费用时，是否打折:0-不打折,1-打折,2-分销售商
     */
    String IS_SUB_PUR_FIXED_FEE_DISCOUNT = "IsSubPurFixedFeeDiscount";
    String IS_SUB_PUR_FIXED_FEE_DISCOUNT_0 = "0";
    String IS_SUB_PUR_FIXED_FEE_DISCOUNT_1 = "1";
    String IS_SUB_PUR_FIXED_FEE_DISCOUNT_2 = "2";
    /**
     * 多重折扣处理方式:0-按折上折,1-按最大折扣
     */
    String MULTI_DISCOUNT_HANDLE_TYPE = "MultiDisCountHandleType";
    String MULTI_DISCOUNT_HANDLE_TYPE_0 = "0";
    String MULTI_DISCOUNT_HANDLE_TYPE_1 = "1";
    /**
     * 费用分成兜底方式:0-由管理人兜底,1-由销售商兜底
     */
    String CHOOSE_CHARGE_DIVIDE_LAST_ONE = "ChooseChargeDivideLastOne";
    String CHOOSE_CHARGE_DIVIDE_LAST_ONE_0 = "0";
    String CHOOSE_CHARGE_DIVIDE_LAST_ONE_1 = "1";
    /**
     * 赎回费率确认方式:0-按认申购时的费率,1-按赎回时的费率
     */
    String FEE_REDEEM_CFN_TYPE = "FeeRedeemCfmType";
    String FEE_REDEEM_CFN_TYPE_0 = "0";
    String FEE_REDEEM_CFN_TYPE_1 = "1";
    /**
     * 赎回后收费确认方式:0-按认申购时的费率,1-按赎回时的费率
     */
    String FEE_REDEEM_BACK_CFN_TYPE = "FeeRedeemBackCfmType";
    String FEE_REDEEM_BACK_CFN_TYPE_0 = "0";
    String FEE_REDEEM_BACK_CFN_TYPE_1 = "1";
    /**
     * 赎回转换业务固定费用时，是否打折:0-不打折,1-交易费打折,2-所有费用打折
     */
    String IS_REDEEM_FIXED_FEE_DISCOUNT = "IsRedeemFixedFeeDiscount";
    String IS_REDEEM_FIXED_FEE_DISCOUNT_0 = "0";
    String IS_REDEEM_FIXED_FEE_DISCOUNT_1 = "1";
    String IS_REDEEM_FIXED_FEE_DISCOUNT_2 = "2";
    /**
     * 赎回确认金额为零时处理方式：0-确认失败，1-确认成功
     */
    String REDEEM_CFM_AMT_EQUAL_ZERO = "RedeemCfmAmtEqualZero";
    String REDEEM_CFM_AMT_EQUAL_ZERO_0 = "0";
    String REDEEM_CFM_AMT_EQUAL_ZERO_1 = "1";
    /**
     * 巨额赎回时强赎处理方式：0-不发起，1-正常发起
     */
    String HUGE_REDEEM_OCCUR = "HugeRedeemOccur";
    String HUGE_REDEEM_OCCUR_0 = "0";
    String HUGE_REDEEM_OCCUR_1 = "1";
    /**
     * 赎回费率区间的金额确认方式:0-按明细份额的原确认金额,1-按赎回金额
     */
    String FEE_RANGE_REDEEM_CFN_TYPE = "FeeRangeRedeemCfmType";
    String FEE_RANGE_REDEEM_CFN_TYPE_0 = "0";
    String FEE_RANGE_REDEEM_CFN_TYPE_1 = "1";
    //......
    /********参数代码【end】********/


    /*********分红系统参数【开始】**********/
    /**
     * 分红处理时,主动冻结份额的分红款不冻结
     */
    String ACTIVE_FRZ_SHARE_DIVID_NOT_FRZ = "ActiveFrzShareDividNotFrz";
    /**
     * 分红处理时对于黑名单客户强制再投资
     */
    String BLACKLIST_MUST_REVEST = "BlacklistMustRevest";
    /**
     * 分红处理方式
     */
    String DEAL_TYPE = "DealType";
    /**
     * 0-登记日当天批处理后分红；
     */
    String DEAL_TYPE_0 = "0";

    /**
     * 分红有冻结时,是否强制再投资
     */
    String FROZEN_REINVEST = "FrozenReinvest";
    /**
     * 分红按份额明细生成
     */
    String GEN_BY_SHARE_DETAIL = "GenByShareDetail";
    /**
     * 内部员工份额自动冻结解冻
     */
    String INTER_EMP_SHARES_AUTO_FRZ_UNFRZ = "InterEmpSharesAutoFrzUnfrz";
    /**
     * 开通业绩提成按收益率区间分成功能
     */
    String OPEN_PERFORM_COMPEN_BY_RTN_RATE_DIVIDED = "OpenPerformCompenByRtnRateDivided";
    /**
     * 分红业绩提成超出分红金额部分是否强减份额
     */
    String PERFORM_COMPEN_OVER_DIVID_NEED_REDUCE_SHARE = "PerformCompenOverDividNeedReduceShare";
    /**
     * 业绩报酬自营账户判断交易账号
     */
    String PERFORM_COMPEN_SELF_ACC_JUDGE_TRADEACC = "PerformCompenSelfAccJudgeTradeAcc";
    /**
     * 份额冻结生成再投资分红明细时按照冻结明细生成
     */
    String REVEST_DETAIL_GEN_BY_FRZ_DETAIL = "RevestDetailGenByFrzDetail";
    /**
     * 挂TA份额分红强制再投资
     */
    String TA_SHARES_MUST_REVEST = "TaSharesMustRevest";
    /**
     * 冻结现金
     */
    String FRZ_CASH = "FrozenCash";
    /**
     * 冻结份额
     */
    String FRZ_SHARE = "FrozenShare";
    /**
     * 红利再投是否算费
     */
    String REVEST_CALC_FEE = "RevestCalcFee";

    /*********分红系统参数【结束】**********/

    /**
     * 基金转换按费率设置计费时，交易费率、补差费率获取方式
     */
    String TRADE_COMPENSATION_RATE_WAY_CHARGE = "TradeCompensationRateWayCharge";
    //按份额注册日期费率收取
    String TRADE_COMPENSATION_RATE_WAY_CHARGE_0 = "0";
    //按确认日期费率收取
    String TRADE_COMPENSATION_RATE_WAY_CHARGE_1 = "1";

    /**
     * 支持预约日期赎回
     */
    String ADVANCE_DATE_REDEEM = "advanceDateRedeem";

    /**
     * 销售商折扣率超限处理方式
     */
    String ORG_DISC_OVER_LIMIT_DEAL_TYPE = "orgDiscOverLimitDealType";
    // 0-确认失败
    String ORG_DISC_OVER_LIMIT_DEAL_TYPE_FAIL = "0";
    // 1-取允许的最大折扣
    String ORG_DISC_OVER_LIMIT_DEAL_TYPE_ALLOW_MAX = "1";

    /**
     * 指定赎回处理方式
     */
    String DESIGNATE_REDEEM_TYPE = "designateRedeemType";
    // 0-确认失败
    String DESIGNATE_REDEEM_TYPE_FAIL = "0";
    // 1-按普通赎回处理
    String DESIGNATE_REDEEM_TYPE_NORMAL = "1";
    // 2- 指定份额明细赎回
    String DESIGNATE_REDEEM_TYPE_DETAIL = "2";

    /**
     * 指定赎回余额不足处理方式
     */
    String DESIGNATE_REDEEM_BALANCE_UNDER_TYPE = "designateRedeemBalanceUnderType";
    // 0-确认失败
    String DESIGNATE_REDEEM_BALANCE_UNDER_TYPE_FAIL = "0";
    // 1-部分确
    String DESIGNATE_REDEEM_BALANCE_UNDER_TYPE_PART = "1";

    /**
     * 销售商上报费用方式与TA不符
     */
    String ORG_SUBMIT_COST_MODE_DIFF_FOR_TA = "orgSubmitCostModeDiffForTA";
    // 0-确认失败
    String ORG_SUBMIT_COST_MODE_DIFF_FOR_TA_FAIL = "0";
    // 1-按TA费用处理
    String ORG_SUBMIT_COST_MODE_DIFF_FOR_TA_FEE = "1";


    /**
     * 专户产品禁止转换业务
     */
    String PRD_BAN_CHANGE_BY_SPECIAL_ACC = "prdBanChangeBySpecialAcc";

    /**
     * 境外产品禁止转换业务
     */
    String PRD_BAN_CHANGE_BY_PRD_AREA_IS_OVERSEAS = "prdBanChangeByPrdAreaIsOverseas";

    /**
     * 货币产品禁止转换非货币产品
     */
    String CURRENCY_PRD_BAN_CHANGE_TO_NON_MONETARY = "currencyPrdBanChangeToNonMonetary";

    /**
     * 指定转换处理方式
     */
    String DESIGNATE_CHANGE_DEAL_TYPE = "designateChangeDealType";
    //0-确认失败
    String DESIGNATE_CHANGE_DEAL_TYPE_0 = "0";
    //1-指定份额明细转换
    String DESIGNATE_CHANGE_DEAL_TYPE_1 = "1";
    //2-按普通转换处理
    String DESIGNATE_CHANGE_DEAL_TYPE_2 = "2";


    /**
     * 指定转换余额不足处理方式
     */
    String DESIGNATE_CHANGE_SHARE_LESS_DEAL_TYPE = "designateChangeShareLessDealType";

    //0-确认失败
    String DESIGNATE_CHANGE_SHARE_LESS_DEAL_TYPE_0 = "0";
    //1-部分确认
    String DESIGNATE_CHANGE_SHARE_LESS_DEAL_TYPE_1 = "1";


    /**
     * 选择利息退还投资者，在利息退还日导出销售商和会计分红数据：0-否；1-是
     */
    String EXPORT_RETURN_DATE_INTEREST_BACK_INVESTORS = "exportReturnDateInterestBackInvestors";
    //否
    String EXPORT_RETURN_DATE_INTEREST_BACK_INVESTORS_0 = "0";
    //是
    String EXPORT_RETURN_DATE_INTEREST_BACK_INVESTORS_1 = "1";

    /**
     * 发行失败是否需要计息：0-否；1-是
     */
    String IF_INVEREST_ISSUE_FAILED = "ifInverestIssueFailed";
    //0-否
    String IF_INVEREST_ISSUE_FAILED_0 = "0";
    //1-是
    String IF_INVEREST_ISSUE_FAILED_1 = "1";

    /**
     * 基金转换费率区间的金额确定方式：0-按份额明细原确认金额 1-按转换金额
     */
    String AMOUNT_WAY_FUND_CHANGE_RATE = "AmountWayFundChangeRate";
    //0-按份额明细原确认金额
    String AMOUNT_WAY_FUND_CHANGE_RATE_0 = "0";
    //1-按转换金额
    String AMOUNT_WAY_FUND_CHANGE_RATE_1 = "1";

    /**
     * 赎回基金转换业务，折扣优惠的金额确定方式：0-按明细份额原确认金额 1-按份额明细确认金额 2-按交易确认金额
     */
    String AMOUNT_WAY_FUND_CHANGE_REDEEM_DISCOUNT = "AmountWayFundChangeRedeemDiscount";
    //0-按明细份额原确认金额
    String AMOUNT_WAY_FUND_CHANGE_REDEEM_DISCOUNT_0 = "0";
    //1-按份额明细确认金额
    String AMOUNT_WAY_FUND_CHANGE_REDEEM_DISCOUNT_1 = "1";
    //2-按交易确认金额
    String AMOUNT_WAY_FUND_CHANGE_REDEEM_DISCOUNT_2 = "2";

    /**
     * 认购费用允许打折
     */
    String SUB_FEE_AGIO_FLAG = "subFeeAgioFlag";
    // 0-不打折
    String SUB_FEE_AGIO_FLAG_0 = "0";
    // 1-都打折
    String SUB_FEE_AGIO_FLAG_1 = "1";
    // 2-认购打折
    String SUB_FEE_AGIO_FLAG_2 = "2";
    // 3-申购打折
    String SUB_FEE_AGIO_FLAG_3 = "3";

    /**
     * 末日比例配售时,参与利息计算的金额选取方式
     */
    String LAST_DAY_PROPORTIONAL_INTEREST_TYPE = "lastDayProportionalInterestType";
    // 0-首次确认后的金额
    String LAST_DAY_PROPORTIONAL_INTEREST_TYPE_0 = "0";
    // 1-配售比例后确认金额
    String LAST_DAY_PROPORTIONAL_INTEREST_TYPE_1 = "1";

    /**
     * 利息年天数
     */
    String INTEREST_YEAR_DAY = "interestYearDay";
    // 0-360天
    String INTEREST_YEAR_DAY_0 = "0";
    // 1-365天
    String INTEREST_YEAR_DAY_1 = "1";

    /**
     * 认购确认成功，人工确认失败是否计息
     */
    String SUB_SUCCESS_ARTIFICIAL_FAIL_INTEREST = "subSuccessArtificialFailInterest";
    // 0-不计息
    String SUB_SUCCESS_ARTIFICIAL_FAIL_INTEREST_0 = "0";
    // 1-计息
    String SUB_SUCCESS_ARTIFICIAL_FAIL_INTEREST_1 = "1";

    /**
     * 单批数据处理量
     */
    String BATCH_NUM = "processBatchNum";

    /**
     * 异步清算开关
     */
    String ASYNC_CLEAR = "asyncClear";
}
