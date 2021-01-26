package com.yss.wealth.infrastructure.constant;

public interface DicConst {

    /**
     * 收费类型:0-折扣率方式(按TA计费) 1-指定费率 2-指定费用
     **/
    String ORG_CHARGE_TYPE = "org_charge_type";
    //0-折扣率方式
    String ORG_CHARGE_TYPE_0 = "0";
    //1-指定费率
    String ORG_CHARGE_TYPE_1 = "1";
    //2-指定费用
    String ORG_CHARGE_TYPE_2 = "2";
    /**
     * 3-指定费率和指定费用都支持
     */
    String ORG_CHARGE_TYPE_3 = "3";

    /**
     * 交易时间超过收市时间处理方式
     **/
    String TIME_LIMIT_FLAG = "time_limit_flag";
    //确认失败处理
    String TIME_LIMIT_FLAG_FAIL = "0";
    //确认成功处理
    String TIME_LIMIT_FLAG_SUCC = "1";

    /**
     * 销售机构类型
     */
    String SALES_ORG_TYPE = "sales_organization_type";
    //直销
    String SALES_ORG_TYPE_0 = "0";
    //代销
    String SALES_ORG_TYPE_1 = "1";
    //虚拟销售机构
    String SALES_ORG_TYPE_2 = "2";

    /**
     * 销售机构状态
     */
    String SALES_ORG_STATUS = "sales_organization_status";
    //正常
    String SALES_ORG_STATUS_N = "N";
    //注销
    String SALES_ORG_STATUS_T = "T";
    //停止新业务
    String SALES_ORG_STATUS_F = "F";

    /**
     * 销售机构机构类别
     */
    String SALES_ORG_CATEGORY = "sales_organization_category";
    //直销
    String SALES_ORG_CATEGORY_0 = "0";
    //银行
    String SALES_ORG_CATEGORY_1 = "1";
    //券商
    String SALES_ORG_CATEGORY_2 = "2";
    //第三方销售
    String SALES_ORG_CATEGORY_3 = "3";
    //证券投资咨询机构
    String SALES_ORG_CATEGORY_4 = "4";

    /**
     * 接口配置版本
     */
    String INTERFACE_CONF_VERSION = "interface_configuration_version";
    //标准基金业务交换协议2.0
    String INTERFACE_CONF_VERSION_JJBZ20 = "JJBZ20";
    //中央数据交换平台开放式基金业务数据交换协议2.1
    String INTERFACE_CONF_VERSION_JJBZ21 = "JJBZ21";

    /**
     * 销售网点是否为大集中模式
     */
    String NET_LARGE_CONCENTRATION = "net_large_concentration";
    //非大集中模式
    String NET_LARGE_CONCENTRATION_0 = "0";
    //大集中模式
    String NET_LARGE_CONCENTRATION_1 = "1";

    /**
     * 销售机构是否支持多交易账号
     */
    String ORG_MULTI_TRANS_ACC = "org_muilt_trans_account";


    /**
     * 销售网点是否支持多交易账号
     */
    String NET_MULTI_TRANS_ACC = "net_muilt_trans_account";


    /**
     * 销售机构是否支持单步转托管入
     */
    String ORG_SINGLE_TRANSFER_IN = "org_single_transfer_in";

    /**
     * 定期定额是否上传协议
     */
    String REGULAR_QUOTAAGREEMENT_UPLOAD = "regular_quotaagreement_upload";


    /**
     * 销售机构是否接收广播
     */
    String ORG_RECEVIE_BROADCAST = "org_recevie_broadcast";

    /**
     * 05文件的对账方式
     */
    String FILE_RECONCILIATION = "file_reconciliation";
    //全量明细对账
    String FILE_RECONCILIATION_0 = "0";
    //全量汇总对账
    String FILE_RECONCILIATION_1 = "1";
    //增量明细对账
    String FILE_RECONCILIATION_2 = "2";
    //增量汇总对账
    String FILE_RECONCILIATION_3 = "3";

    /**
     * 申请超时处理方式
     */
    String OVERTIME_DEAL_WAY = "overtime_deal_way";
    //按正常处理
    String OVERTIME_DEAL_WAY_0 = "0";
    //按失败处理
    String OVERTIME_DEAL_WAY_1 = "1";
    //检查特殊
    String OVERTIME_DEAL_WAY_3 = "3";

    /**
     * 产品转换下发的业务代码
     */
    String SWITCH_CONFIRM_WAY = "switch_confirm_way";
    //按一笔“136：转换确认”下发
    String SWITCH_CONFIRM_WAY_1 = "1";
    //按两笔“138-转出确认|137-转入确认”下发
    String SWITCH_CONFIRM_WAY_2 = "2";

    /**
     * 产品成立下发的业务代码
     */
    String FUNDSETUP_BIZ_CODE = "fundsetup_biz_code";
    //按 “130-产品成立”业务下发
    String FUNDSETUP_BIZ_CODE_1 = "1";
    //按“149-募集失败”业务下发
    String FUNDSETUP_BIZ_CODE_2 = "2";

    /**
     * 001-是否允许基金账户开户申请
     */
    String FUND_ACC_OPEN_ACC = "fund_account_open_account";

    /**
     * 002-是否允许基金账户销户申请
     */
    String FUND_ACC_DESTROY_ACCOUNT = "fund_account_distory_Account";

    /**
     * 003-是否允许账户资料修改申请
     */
    String ACC_INFO_MODIFY = "account_information_modify";


    /**
     * 004-是否允许基金账户冻结申请
     */
    String FUND_ACC_FRZ = "fund_account_forzen";

    /**
     * 005-是否允许基金账户解冻申请
     */
    String FUND_ACC_UNFRZ = "fund_account_unforzen";


    /**
     * 008-是否允许基金账户登记申请
     */
    String FUND_ACC_REGISTER = "fund_account_register";


    /**
     * 009-是否允许取消账户登记申请
     */
    String FUND_ACC_UNREGISTER = "fund_account_unregister";


    /**
     * 058-是否允许变更交易账号申请
     */
    String TRANS_ACC_CHANGE = "trans_account_change";


    /**
     * 网点状态
     */
    String NET_STATUS = "net_status";
    //正常
    String NET_STATUS_N = "N";
    //注销
    String NET_STATUS_T = "T";

    /**
     * 是否扫描OK文件
     */
    String SCAN_OK_FILE = "scan_ok_file";

    /**
     * 产品大类
     */
    String PRD_CATEGORY = "product_category";
    //公募产品
    String PRD_CATEGORY_0 = "0";
    //专户产品
    String PRD_CATEGORY_1 = "1";

    /**
     * 产品币种
     */
    String PRD_CURRENCY = "product_currency";
    //人民币
    String PRD_CURRENCY_156 = "156";
    //港币
    String PRD_CURRENCY_344 = "344";
    //美元
    String PRD_CURRENCY_840 = "840";

    /**
     * 产品状态
     */
    String PRODUCT_STATUS = "product_status";
    //正常
    String PRODUCT_STATUS_NORMAL = "0";
    //发行
    String PRODUCT_STATUS_ISSUE = "1";
    //发行成功
    String PRODUCT_STATUS_ISSUE_SUC = "2";
    //产品封闭
    String PRODUCT_STATUS_SEAL = "3";
    //产品终止
    String PRODUCT_STATUS_TERM = "4";
    //发行失败
    String PRODUCT_STATUS_ISSUE_FAIL = "5";
    //停止交易
    String PRODUCT_STATUS_STOP_TRADE = "6";
    //停止申购
    String PRODUCT_STATUS_STOP_PURCHASE = "7";
    //停止赎回
    String PRODUCT_STATUS_STOP_REDEEM = "8";


    /*
    *   新的产品状态，到时直接改常量名即可
    * */
    //  可申购赎回
    String PRODUCT_STATUS_0= "0";
    //  发行
    String PRODUCT_STATUS_1 = "1";
    //  停止申购赎回
    String PRODUCT_STATUS_4 = "4";
    //  停止申购
    String PRODUCT_STATUS_5= "5";
    //  停止赎回
    String PRODUCT_STATUS_6= "6";
    //  基金终止
    String PRODUCT_STATUS_8= "8";
    //  基金封闭
    String PRODUCT_STATUS_9 = "9";
    //  发行失败
    String PRODUCT_STATUS_10= "10";


    /**
     * 产品类型
     */
    String PRODUCT_TYPE = "product_type";
    //股票型
    String PRODUCT_TYPE_1 = "1";
    //债券型
    String PRODUCT_TYPE_2 = "2";
    //混合型
    String PRODUCT_TYPE_3 = "3";
    //货币型
    String PRODUCT_TYPE_4 = "4";
    //理财型
    String PRODUCT_TYPE_5 = "5";
    //保本型
    String PRODUCT_TYPE_6 = "6";
    //指数型
    String PRODUCT_TYPE_7 = "7";
    //QDII
    String PRODUCT_TYPE_8 = "8";
    //LOF
    String PRODUCT_TYPE_9 = "9";
    //ETF
    String PRODUCT_TYPE_10 = "10";
    //FOF
    String PRODUCT_TYPE_11 = "11";

    /**
     * 投资主体方向
     */
    String INVESTMENT_SUBJECT_DIRECTION = "investment_subject_direction";
    //股票市场
    String INVESTMENT_SUBJECT_DIRECTION_1 = "1";
    //债券市场
    String INVESTMENT_SUBJECT_DIRECTION_2 = "2";
    //混合市场
    String INVESTMENT_SUBJECT_DIRECTION_3 = "3";
    //货币市场
    String INVESTMENT_SUBJECT_DIRECTION_4 = "4";

    /**
     * 投资区域
     */
    String INVESTMENT_AREA = "investment_area";
    //境内
    String INVESTMENT_AREA_0 = "0";
    //境外（QDII）
    String INVESTMENT_AREA_1 = "1";
    //境内外
    String INVESTMENT_AREA_2 = "2";

    /**
     * 交易对象
     */
    String TRADING_PARTNERS = "trading_partners";
    //机构
    String TRADING_PARTNERS_ORG = "0";
    //个人
    String TRADING_PARTNERS_PERSON = "1";
    //全部
    String TRADING_PARTNERS_ALL = "3";

    /**
     * 份额类别
     */
    String SHARE_CATEGORY = "share_category";
    //前收费
    String SHARE_CATEGORY_0 = "0";
    //后收费
    String SHARE_CATEGORY_1 = "1";
    //前/后收费
    String SHARE_CATEGORY_2 = "2";

    /**
     * 份额类别
     */
    String SHARE_TYPE_WORD = "share_type_word";
    //前收费
    String SHARE_TYPE_WORD_A = "A";
    //后收费
    String SHARE_TYPE_WORD_B = "B";
    //全部份额类别
    String SHARE_TYPE_WORD_ALL = "all";

    /**
     * 转换标志
     */
    String CONVERSION_FLAG = "conversion_flag";
    //允许转入转出
    String CONVERSION_FLAG_0 = "0";
    //禁止转入转出
    String CONVERSION_FLAG_1 = "1";
    //允许转入
    String CONVERSION_FLAG_2 = "2";
    //允许转出
    String CONVERSION_FLAG_3 = "3";

    /**
     * 产品风险等级
     */
    String PRODUCT_RISK_LEVEL = "product_risk_level";
    //低风险
    String PRODUCT_RISK_LEVEL_1 = "1";
    //中低风险
    String PRODUCT_RISK_LEVEL_2 = "2";
    //中风险
    String PRODUCT_RISK_LEVEL_3 = "3";
    //中高风险
    String PRODUCT_RISK_LEVEL_4 = "4";
    //高风险
    String PRODUCT_RISK_LEVEL_5 = "5";

    /**
     * 公募标识
     */
    String PUBLICFERING_LOGO = "publicfering_logo";
    //非公募
    String PUBLICFERING_LOGO_0 = "0";
    //公募
    String PUBLICFERING_LOGO_1 = "1";

    /**
     * 产品分类
     */
    String PRODUCT_CATEGORIES = "product_categories";
    //股票型
    String PRODUCT_CATEGORIES_1 = "1";
    //债券型
    String PRODUCT_CATEGORIES_2 = "2";
    //混合型
    String PRODUCT_CATEGORIES_3 = "3";
    //货币型
    String PRODUCT_CATEGORIES_4 = "4";
    //其它公募类
    String PRODUCT_CATEGORIES_5 = "5";
    //银行理财产品
    String PRODUCT_CATEGORIES_11 = "11";
    //信托计划
    String PRODUCT_CATEGORIES_12 = "12";
    //基金公司专户
    String PRODUCT_CATEGORIES_13 = "13";
    //基金子公司产品
    String PRODUCT_CATEGORIES_14 = "14";
    //保险产品
    String PRODUCT_CATEGORIES_15 = "15";
    //保险公司及其子公司的资产管理计划
    String PRODUCT_CATEGORIES_16 = "16";
    //证券公司集合理财产品（含证券公司大集合）
    String PRODUCT_CATEGORIES_17 = "17";
    //证券公司专项资管计划
    String PRODUCT_CATEGORIES_18 = "18";
    //证券公司定向资管计划
    String PRODUCT_CATEGORIES_19 = "19";
    //期货公司及其子公司的资产管理计划
    String PRODUCT_CATEGORIES_20 = "20";
    //私募投资基金
    String PRODUCT_CATEGORIES_21 = "21";
    //政府类引导基金
    String PRODUCT_CATEGORIES_22 = "22";
    //全国社保基金
    String PRODUCT_CATEGORIES_23 = "23";
    //地方社保基金
    String PRODUCT_CATEGORIES_24 = "24";
    //基本养老保险
    String PRODUCT_CATEGORIES_25 = "25";
    //养老金产品
    String PRODUCT_CATEGORIES_26 = "26";
    //企业年金及职业年金
    String PRODUCT_CATEGORIES_27 = "27";
    //境外资金（QFII）
    String PRODUCT_CATEGORIES_28 = "28";
    //境外资金（RQFII）
    String PRODUCT_CATEGORIES_29 = "29";
    //其它境外资金
    String PRODUCT_CATEGORIES_30 = "30";
    //社会公益基金（慈善基金捐赠基金等）
    String PRODUCT_CATEGORIES_31 = "31";
    //其他产品
    String PRODUCT_CATEGORIES_32 = "32";

    /**
     * 关系用途
     */
    String RELATIONSHIP_USE = "relationship_use";
    //统计
    String RELATIONSHIP_USE_1 = "1";

    /**
     * 产品发行方式
     */
    String PRODUCT_RELEASE_METHOD = "product_release_method";
    //不配售
    String PRODUCT_RELEASE_METHOD_0 = "0";
    //末日比例配售
    String PRODUCT_RELEASE_METHOD_1 = "1";
    //全程比例配售
    String PRODUCT_RELEASE_METHOD_2 = "2";

    /**
     * 户数超限处理方式
     */
    String NUMBER_HOUSEHOLDS_OVERRUN = "number_households_overrun";
    //时间优先
    String NUMBER_HOUSEHOLDS_OVERRUN_0 = "0";
    //金额优先（按汇总）
    String NUMBER_HOUSEHOLDS_OVERRUN_1 = "1";

    /**
     * 募集期利息处理方式
     */
    String RAISING_PERIOD_INTEREST_HANDLING = "raising_period_interest_handling";
    //利息归基金资产
    String RAISING_PERIOD_INTEREST_HANDLING_0 = "0";
    //利息返还投资者
    String RAISING_PERIOD_INTEREST_HANDLING_1 = "1";
    //利息转份额
    String RAISING_PERIOD_INTEREST_HANDLING_2 = "2";
    //3-利息归销售商
    String RAISING_PERIOD_INTEREST_HANDLING_3 = "3";

    /**
     * 份额超规模处理方式
     */
    String SHARE_OVERSIZE_PROCESSING = "share_oversize_processing";
    //时间优先
    String SHARE_OVERSIZE_PROCESSING_0 = "0";
    //金额优先
    String SHARE_OVERSIZE_PROCESSING_1 = "1";

    /**
     * 超规模末笔处理方式
     */
    String SUPERSCALE_FINAL_STROKE_PROCESSING = "superscale_final_stroke_processing";
    //全部成功
    String SUPERSCALE_FINAL_STROKE_PROCESSING_0 = "0";
    //全部失败
    String SUPERSCALE_FINAL_STROKE_PROCESSING_1 = "1";
    //部分成功
    String SUPERSCALE_FINAL_STROKE_PROCESSING_2 = "2";

    /**
     * 资产过低判断类型
     */
    String LOW_ASSET_JUDGMENT_TYPE = "low_asset_judgment_type";
    //份额
    String LOW_ASSET_JUDGMENT_TYPE_0 = "0";
    //金额
    String LOW_ASSET_JUDGMENT_TYPE_1 = "1";

    /**
     * 允许变更分红方式
     */
    String ALLOW_CHANGE_DIVIDEND_METHOD = "allow_change_dividend_method";

    /**
     * 默认分红方式
     */
    String DEFAULT_DIVIDEND_METHOD = "default_dividend_method";
    //红利转投
    String DEFAULT_DIVIDEND_METHOD_0 = "0";
    //现金红利
    String DEFAULT_DIVIDEND_METHOD_1 = "1";

    /**
     * 份额明细处理方式
     */
    String SHARE_BREAKDOWN_PROCESSING = "share_breakdown_processing";
    //后进先出
    String SHARE_BREAKDOWN_PROCESSING_0 = "0";
    //先进先出
    String SHARE_BREAKDOWN_PROCESSING_1 = "1";

    /**
     * 账户最低控制
     */
    String MINIMUM_ACCOUNT_CONTROL = "minimum_account_control";
    //按最低持有份额
    String MINIMUM_ACCOUNT_CONTROL_0 = "0";
    //按最低持有金额
    String MINIMUM_ACCOUNT_CONTROL_1 = "1";

    /**
     * 剩余份额处理方式
     */
    String TREATMENT_REMAINING_SHARES = "treatment_remaining_shares";
    //低于最低持有_保留最低持有
    String TREATMENT_REMAINING_SHARES_0 = "0";
    //低于最低持有_生成强赎
    String TREATMENT_REMAINING_SHARES_1 = "1";

    /**
     * 剩余份额处理触发
     */
    String REMAINING_SHARE_PROCESSING_TRIGGER = "remaining_share_processing_trigger";
    //发生赎回确认时触发
    String REMAINING_SHARE_PROCESSING_TRIGGER_0 = "0";
    //发生赎回/转换出/转托管出确认时触发
    String REMAINING_SHARE_PROCESSING_TRIGGER_1 = "1";

    /**
     * 级差控制方式
     */
    String RANGE_CONTROL_METHOD = "range_control_method";
    //首次和追加投资级差控制
    String RANGE_CONTROL_METHOD_0 = "0";
    //首次投资级差控制
    String RANGE_CONTROL_METHOD_1 = "1";
    //追加投资级差控制
    String RANGE_CONTROL_METHOD_2 = "2";

    /**
     * 追加投资方式标准
     */
    String ADDITIONAL_INVESTMENT_METHOD_STANDARDS = "additional_investment_method_standards";
    //有份额算追加
    String ADDITIONAL_INVESTMENT_METHOD_STANDARDS_1 = "1";
    //有交易算追加
    String ADDITIONAL_INVESTMENT_METHOD_STANDARDS_2 = "2";

    /**
     * 费用合并方式
     */
    String COST_CONSOLIDATION = "cost_consolidation";
    //单笔计算
    String COST_CONSOLIDATION_0 = "0";
    //当天合并计算
    String COST_CONSOLIDATION_1 = "1";

    /**
     * 费率计算方式
     */
    String RATE_CALCULATION_METHOD = "rate_calculation_method";
    //按有效申请金额计算
    String RATE_CALCULATION_METHOD_1 = "1";
    //按原申请金额计算
    String RATE_CALCULATION_METHOD_2= "2";

    /**
     * 认申购费计算方式
     */
    String SUBSCRIPTION_FEE_CALCULATION_METHOD = "subscription_fee_calculation_method";
    //价内
    String SUBSCRIPTION_FEE_CALCULATION_METHOD_0 = "0";
    //价外
    String SUBSCRIPTION_FEE_CALCULATION_METHOD_1 = "1";

    /**
     * 赎回后收费计算方式
     */
    String REDEEM_CHARGE_CALCULATION_METHOD = "redeem_charge_calculation_method";
    //按原始成本价
    String REDEEM_CHARGE_CALCULATION_METHOD_0 = "0";
    //按成本价
    String REDEEM_CHARGE_CALCULATION_METHOD_1 = "1";
    //按现价
    String REDEEM_CHARGE_CALCULATION_METHOD_2 = "2";
    //按现价与成本价最小值
    String REDEEM_CHARGE_CALCULATION_METHOD_3 = "3";
    //按现价与原始成本价最小值
    String REDEEM_CHARGE_CALCULATION_METHOD_4 = "4";

    /**
     * 转换后收费计算方式
     */
    String CONVERSION_CHARGE_CALCULATION_METHOD = "conversion_charge_calculation_method";
    //按原始成本价
    String CONVERSION_CHARGE_CALCULATION_METHOD_0 = "0";
    //按成本价
    String CONVERSION_CHARGE_CALCULATION_METHOD_1 = "1";
    //按现价
    String CONVERSION_CHARGE_CALCULATION_METHOD_2 = "2";

    /**
     * 赎回费计算方式
     */
    String HOW_REDEMPTION_FEES_ARE_CALCULATED = "how_redemption_fees_are_calculated";
    //价内
    String HOW_REDEMPTION_FEES_ARE_CALCULATED_0 = "0";
    //价外
    String HOW_REDEMPTION_FEES_ARE_CALCULATED_1 = "1";

    /**
     * 利率模式
     */
    String INTEREST_RATE_MODEL = "interest_rate_model";
    //募集期利率
    String INTEREST_RATE_MODEL_0 = "0";
    //封闭期利率
    String INTEREST_RATE_MODEL_1 = "1";

    /**
     * 利率类型
     */
    String INTEREST_RATE_TYPE = "interest_rate_type";
    //活期
    String INTEREST_RATE_TYPE_0 = "0";
    //一个月定期利率
    String INTEREST_RATE_TYPE_1 = "1";
    //三个月定期利率
    String INTEREST_RATE_TYPE_2 = "2";
    //半年定期利率
    String INTEREST_RATE_TYPE_3 = "3";
    //一年定期利率
    String INTEREST_RATE_TYPE_4 = "4";
    //二年定期利率
    String INTEREST_RATE_TYPE_5 = "5";
    //三年定期利率
    String INTEREST_RATE_TYPE_6 = "6";
    //五年定期利率
    String INTEREST_RATE_TYPE_7 = "7";

    /**
     * 募集户计息天数
     */
    String NUMBER_INTEREST_BEARING_DAYS = "number_interest_bearing_days";
    //360
    String NUMBER_INTEREST_BEARING_DAYS_0 = "0";
    //365
    String NUMBER_INTEREST_BEARING_DAYS_1 = "1";
    //实际天数
    String NUMBER_INTEREST_BEARING_DAYS_2 = "2";

    /**
     * 托管户计息天数
     */
    String CUSTODIAN_INTEREST_DAYS = "custodian_interest_days";
    //360
    String CUSTODIAN_INTEREST_DAYS_0 = "0";
    //365
    String CUSTODIAN_INTEREST_DAYS_1 = "1";
    //实际天数
    String CUSTODIAN_INTEREST_DAYS_2 = "2";

    /**
     * 募集期最后一天计息
     */
    String LAST_FUNDRAISING_PERIOD_INTEREST = "last_fundraising_period_interest";
    //不计息
    String LAST_FUNDRAISING_PERIOD_INTEREST_0 = "0";
    //计息
    String LAST_FUNDRAISING_PERIOD_INTEREST_1 = "1";

    /**
     * 封闭期最后一天计息
     */
    String LAST_CLOSED_PERIOD_INTEREST = "last_closed_period_interest";
    //不计息
    String LAST_CLOSED_PERIOD_INTEREST_0 = "0";
    //计息
    String LAST_CLOSED_PERIOD_INTEREST_1 = "1";


    /**
     * 通用精度处理方式
     */
    String PRECISION_PROCESSING = "precision_processing";
    //四舍五入 ROUND_HALF_UP
    String PRECISION_PROCESSING_0 = "0";
    //正舍负入 ROUND_FLOOR
    String PRECISION_PROCESSING_1 = "1";
    //截位 ROUND_DOWN
    String PRECISION_PROCESSING_2 = "2";
    //进位 ROUND_UP
    String PRECISION_PROCESSING_3 = "3";

    /**
     * 通用小数保留位数
     */
    String DECIMAL_RESERVATION = "decimal_reservation";
    //16位
    String DECIMAL_RESERVATION_0 = "0";
    //8位
    String DECIMAL_RESERVATION_1 = "1";
    //4位
    String DECIMAL_RESERVATION_2 = "2";
    //2位
    String DECIMAL_RESERVATION_3 = "3";

    /**
     * 金额的精度处理方式（使用-“通用精度处理方式”）
     */
    String AMOUNT_PRECISION_PROCESSING = "amount_precision_processing";
    //四舍五入
    String AMOUNT_PRECISION_PROCESSING_0 = "0";
    //正舍负入
    String AMOUNT_PRECISION_PROCESSING_1 = "1";
    //截位
    String AMOUNT_PRECISION_PROCESSING_2 = "2";
    //进位
    String AMOUNT_PRECISION_PROCESSING_3 = "3";

    /**
     * 份额的精度处理方式（使用-“通用精度处理方式”）
     */
    String SHARE_PRECISION_PROCESSING = "share_precision_processing";
    //四舍五入
    String SHARE_PRECISION_PROCESSING_0 = "0";
    //正舍负入
    String SHARE_PRECISION_PROCESSING_1 = "1";
    //截位
    String SHARE_PRECISION_PROCESSING_2 = "2";
    //进位
    String SHARE_PRECISION_PROCESSING_3 = "3";

    /**
     * 费用的精度处理方式（使用-“通用精度处理方式”）
     */
    String COST_ACCURACY_PROCESSING = "cost_accuracy_processing";
    //四舍五入
    String COST_ACCURACY_PROCESSING_0 = "0";
    //正舍负入
    String COST_ACCURACY_PROCESSING_1 = "1";
    //截位
    String COST_ACCURACY_PROCESSING_2 = "2";
    //进位
    String COST_ACCURACY_PROCESSING_3 = "3";

    /**
     * 分红的精度处理方式（使用-“通用精度处理方式”）
     */
    String DIVIDEND_ACCURACY_PROCESSING_METHOD = "dividend_accuracy_processing_method";
    //四舍五入
    String DIVIDEND_ACCURACY_PROCESSING_METHOD_0 = "0";
    //正舍负入
    String DIVIDEND_ACCURACY_PROCESSING_METHOD_1 = "1";
    //截位
    String DIVIDEND_ACCURACY_PROCESSING_METHOD_2 = "2";
    //进位
    String DIVIDEND_ACCURACY_PROCESSING_METHOD_3 = "3";

    /**
     * 利息的精度处理方式（使用-“通用精度处理方式”）
     */
    String INTEREST_PRECISION_METHOD = "interest_precision_method";
    //四舍五入
    String INTEREST_PRECISION_METHOD_0 = "0";
    //正舍负入
    String INTEREST_PRECISION_METHOD_1 = "1";
    //截位
    String INTEREST_PRECISION_METHOD_2 = "2";
    //进位
    String INTEREST_PRECISION_METHOD_3 = "3";

    /**
     * 固定收益的精度处理方式（使用-“通用精度处理方式”）
     */
    String FIXED_INCOME_PRECISION_PROCESSING = "fixed_income_precision_processing";
    //四舍五入
    String FIXED_INCOME_PRECISION_PROCESSING_0 = "0";
    //正舍负入
    String FIXED_INCOME_PRECISION_PROCESSING_1 = "1";
    //截位
    String FIXED_INCOME_PRECISION_PROCESSING_2 = "2";
    //进位
    String FIXED_INCOME_PRECISION_PROCESSING_3 = "3";

    /**
     * 业绩报酬的精度处理方式（使用-“通用精度处理方式”）
     */
    String PERFORMANCE_REWARDS_PRECISION_PROCESSING = "performance_rewards_precision_processing";
    //四舍五入
    String PERFORMANCE_REWARDS_PRECISION_PROCESSING_0 = "0";
    //正舍负入
    String PERFORMANCE_REWARDS_PRECISION_PROCESSING_1 = "1";
    //截位
    String PERFORMANCE_REWARDS_PRECISION_PROCESSING_2 = "2";
    //进位
    String PERFORMANCE_REWARDS_PRECISION_PROCESSING_3 = "3";

    /**
     * 金额计算的保留位数（使用-“通用小数保留位数”）
     */
    String DIGITS_CALCULATION_NUMBER_RESERVET = "digits_calculation_number_reservet";
    //16位
    String DIGITS_CALCULATION_NUMBER_RESERVET_0 = "0";
    //8位
    String DIGITS_CALCULATION_NUMBER_RESERVET_1 = "1";
    //4位
    String DIGITS_CALCULATION_NUMBER_RESERVET_2 = "2";
    //2位
    String DIGITS_CALCULATION_NUMBER_RESERVET_3 = "3";

    /**
     * 份额计算的保留位数（使用-“通用小数保留位数”）
     */
    String BITS_CALCULATION_SHARES_NUMBER_RESERVET = "bits_calculation_shares_number_reservet";
    //16位
    String BITS_CALCULATION_SHARES_NUMBER_RESERVET_0 = "0";
    //8位
    String BITS_CALCULATION_SHARES_NUMBER_RESERVET_1 = "1";
    //4位
    String BITS_CALCULATION_SHARES_NUMBER_RESERVET_2 = "2";
    //2位
    String BITS_CALCULATION_SHARES_NUMBER_RESERVET_3 = "3";

    /**
     * 费用计算的保留位数（使用-“通用小数保留位数”）
     */
    String BITS_COST_CALCULATION_NUMBER_RESERVET = "bits_cost_calculation_number_reservet";
    //16位
    String BITS_COST_CALCULATION_NUMBER_RESERVET_0 = "0";
    //8位
    String BITS_COST_CALCULATION_NUMBER_RESERVET_1 = "1";
    //4位
    String BITS_COST_CALCULATION_NUMBER_RESERVET_2 = "2";
    //2位
    String BITS_COST_CALCULATION_NUMBER_RESERVET_3 = "3";

    /**
     * 分红计算的保留位数（使用-“通用小数保留位数”）
     */
    String DIGITS_DIVIDEND_CALCULATION_NUMBER_RESERVET = "digits_dividend_calculation_number_reservet";
    //16位
    String DIGITS_DIVIDEND_CALCULATION_NUMBER_RESERVET_0 = "0";
    //8位
    String DIGITS_DIVIDEND_CALCULATION_NUMBER_RESERVET_1 = "1";
    //4位
    String DIGITS_DIVIDEND_CALCULATION_NUMBER_RESERVET_2 = "2";
    //2位
    String DIGITS_DIVIDEND_CALCULATION_NUMBER_RESERVET_3 = "3";

    /**
     * 利息计算的保留位数（使用-“通用小数保留位数”）
     */
    String BITS_INTEREST_NUMBER_RESERVET = "bits_interest_number_reservet";
    //16位
    String BITS_INTEREST_NUMBER_RESERVET_0 = "0";
    //8位
    String BITS_INTEREST_NUMBER_RESERVET_1 = "1";
    //4位
    String BITS_INTEREST_NUMBER_RESERVET_2 = "2";
    //2位
    String BITS_INTEREST_NUMBER_RESERVET_3 = "3";

    /**
     * 固定收益的保留位数（使用-“通用小数保留位数”）
     */
    String BITS_FIXED_INCOME_NUMBER_RESERVET = "bits_fixed_income_number_reservet";
    //16位
    String BITS_FIXED_INCOME_NUMBER_RESERVET_0 = "0";
    //8位
    String BITS_FIXED_INCOME_NUMBER_RESERVET_1 = "1";
    //4位
    String BITS_FIXED_INCOME_NUMBER_RESERVET_2 = "2";
    //2位
    String BITS_FIXED_INCOME_NUMBER_RESERVET_3 = "3";

    /**
     * 业绩报酬的保留位数（使用-“通用小数保留位数”）
     */
    String PERFORMANCE_REWARDS_NUMBER_RESERVET = "performance_rewards_number_reservet";
    //16位
    String PERFORMANCE_REWARDS_NUMBER_RESERVET_0 = "0";
    //8位
    String PERFORMANCE_REWARDS_NUMBER_RESERVET_1 = "1";
    //4位
    String PERFORMANCE_REWARDS_NUMBER_RESERVET_2 = "2";
    //2位
    String PERFORMANCE_REWARDS_NUMBER_RESERVET_3 = "3";

    /**
     * 020产品认购申请
     */
    String PRODUCT_SUBSCRIPTION_APPLICATION = "product_subscription_application";

    /**
     * 022产品申购申请
     */
    String PRODUCT_PURCHASE_APPLICATION = "product_purchase_application";

    /**
     * 039产品定期定额申购申请
     */
    String REGULAR_APPLICATION = "regular_application";

    /**
     * 024产品赎回申请
     */
    String PRODUCT_REDEMPTION_APPLICATION = "product_redemption_application";


    /**
     * 036产品转换申请
     */
    String PRODUCT_CONVERSION_APPLICATION = "product_conversion_application";

    /**
     * 026产品转托管申请
     */
    String PRODUCT_SUBHOSTING_APPLICATION = "product_subhosting_application";

    /**
     * 028产品转托管出申请
     */
    String PRODUCT_SUBHOSTING_OUT_APPLICATION = "product_subhosting_out_application";


    /**
     * 027产品转托管入申请
     */
    String PRODUCT_SUBHOSTING_IN_APPLICATION = "product_subhosting_in_application";


    /**
     * 029分红方式变更申请
     */
    String CHANGE_DIVIDEND_METHO_APPLICATION = "change_dividend_metho_application";


    /**
     * 031产品份额冻结申请
     */
    String PRODUCT_SHARE_FREEZE_APPLICATION = "product_share_freeze_application";


    /**
     * 032产品份额解冻申请
     */
    String PRODUCT_SHARE_THAWING_APPLICATION = "product_share_thawing_application";


    /**
     * 033非交易过户申请
     */
    String NOTRANSACTION_TRANSFER_APPLICATION = "notransaction_transfer_application";


    /**
     * 052交易撤单申请
     */
    String TRANSACTION_CANCELLATION_APPLICATION = "transaction_cancellation_application";


    /**
     * 059开通定期定额申购计划
     */
    String OPENED_REGULAR_FIXED_SUBSCRIPTION_PLAN = "opened_regular_fixed_subscription_plan";


    /**
     * 061变更定期定额申购计划
     */
    String CHANGE_REGULAR_FIXED_SUBSCRIPTION_PLAN = "change_regular_fixed_subscription_plan";

    /**
     * 060终止定期定额申购计划
     */
    String TERMINATION_REGULAR_FIXED_SUBSCRIPTION_PLAN = "termination_regular_fixed_subscription_plan";

    /**
     * 025产品预约赎回计划
     */
    String PRODUCT_APPOINTMENT_REDEMPTION_PLAN = "product_appointment_redemption_plan";


    /**
     * 053预约计划撤单申请
     */
    String RESERVATION_PLAN_CANCELLATION_APPLICATION = "reservation_plan_cancellation_application";


    /**
     * 080确权申请
     */
    String CONFIRMATION_APPLICATION = "confirmation_application";


    /**
     * 098快速过户申请
     */
    String QUICK_TRANSFER_APPLICATION = "quick_transfer_application";


    /**
     * 允许违约赎回
     */
    String ALLOW_DEFAULT_REDEMPTION = "allow_default_redemption";


    /**
     * 违约是否仍收取赎回费
     */
    String CHARGE_BREACH_CONTRACT_STILL_REDEMPTION_FEE = "charge_breach_contract_still_redemption_fee";

    /**
     * 违约赎回费收取方式
     */
    String COLLECTION_DEFAULT_REDEMPTION_FEE = "collection_default_redemption_fee";
    //按赎回费率
    String COLLECTION_DEFAULT_REDEMPTION_FEE_0 = "0";
    //按违约赎回费率
    String COLLECTION_DEFAULT_REDEMPTION_FEE_1 = "1";

    /**
     * 封闭期清算频率
     */
    String CLOSING_PERIOD_LIQUIDATION_FREQUENCE = "closing_period_liquidation_frequence";
    //每日清算
    String CLOSING_PERIOD_LIQUIDATION_FREQUENCE_0 = "0";
    //每周一清算
    String CLOSING_PERIOD_LIQUIDATION_FREQUENCE_1 = "1";
    //每周二清算
    String CLOSING_PERIOD_LIQUIDATION_FREQUENCE_2 = "2";
    //每周三清算
    String CLOSING_PERIOD_LIQUIDATION_FREQUENCE_3 = "3";
    //每周四清算
    String CLOSING_PERIOD_LIQUIDATION_FREQUENCE_4 = "4";
    //每周五清算
    String CLOSING_PERIOD_LIQUIDATION_FREQUENCE_5 = "5";

    /**
     * 遇巨额赎回顺延方式 
     */
    String IN_CASE_HUGE_REDEMPTION_AND_POSTPONEMENT = "in_case_huge_redemption_and_postponement";
    //顺延至下个工作日
    String IN_CASE_HUGE_REDEMPTION_AND_POSTPONEMENT_0 = "0";
    //顺延至下个开放日
    String IN_CASE_HUGE_REDEMPTION_AND_POSTPONEMENT_1 = "1";

    /**
     * 赎回持有天数计算方式
     */
    String CALCULATION_REDEMPTION_HOLDING_DAY = "calculation_redemption_holding_day";
    //按持有天数
    String CALCULATION_REDEMPTION_HOLDING_DAY_0 = "0";
    //按到期天数
    String CALCULATION_REDEMPTION_HOLDING_DAY_1 = "1";

    /**
     * 违约是否计提业绩报酬
     */
    String WHETHER_TO_PROVIDE_PERFORMANCE_COMPENSATION = "whether_to_provide_performance_compensation";


    /**
     * 是否必须指定笔赎回
     */
    String MUST_SPECIFY_PEN_REDEMPTION = "must_specify_pen_redemption";

    /**
     * 允许部分赎回
     */
    String ALLOW_PARTIAL_REDEMPTION = "allow_partial_redemption";

    /**
     * 净值公布频率
     */
    String NET_VALUE_ANNOUNCEMENT_FREQUENCE = "net_value_announcement_frequence";
    //每日
    String NET_VALUE_ANNOUNCEMENT_FREQUENCE_0 = "0";
    //每周
    String NET_VALUE_ANNOUNCEMENT_FREQUENCE_1 = "1";
    //每月
    String NET_VALUE_ANNOUNCEMENT_FREQUENCE_2 = "2";
    //每季
    String NET_VALUE_ANNOUNCEMENT_FREQUENCE_3 = "3";
    //每半年
    String NET_VALUE_ANNOUNCEMENT_FREQUENCE_4 = "4";
    //每年
    String NET_VALUE_ANNOUNCEMENT_FREQUENCE_5 = "5";
    //从不
    String NET_VALUE_ANNOUNCEMENT_FREQUENCE_6 = "6";

    /**
     * 净值公布日期类型
     */
    String NET_VALUE_ANNOUNCEMENT_DATE_TYPE = "net_value_announcement_date_type";
    //所选周期第一个工作日
    String NET_VALUE_ANNOUNCEMENT_DATE_TYPE_0 = "0";
    //所选周期最后一个
    String NET_VALUE_ANNOUNCEMENT_DATE_TYPE_1 = "1";

    /**
     * 业绩报酬尾差处理
     */
    String PERFORMANCE_COMPENSATION_TAIL_DIFFERENCE_PROCESSING = "performance_compensation_tail_difference_processing";
    //不兜底
    String PERFORMANCE_COMPENSATION_TAIL_DIFFERENCE_PROCESSING_0 = "0";
    //兜底
    String PERFORMANCE_COMPENSATION_TAIL_DIFFERENCE_PROCESSING_1 = "1";

    /**
     * 计算收益年天
     */
    String CALCULATING_EARNINGS_EVERY_DAY = "calculating_earnings_every_day";
    //360
    String CALCULATING_EARNINGS_EVERY_DAY_0 = "0";
    //365
    String CALCULATING_EARNINGS_EVERY_DAY_1 = "1";
    //实际天数
    String CALCULATING_EARNINGS_EVERY_DAY_2 = "2";

    /**
     * 是否计提
     */
    String ACCUMULATOR_SWITCH = "accumulator_switch";

    /**
     * 计提时点
     */
    String ACCRUAL_TIME = "accrual_time";
    //赎回计提
    String ACCRUAL_TIME_0 = "0";
    //固定日计提
    String ACCRUAL_TIME_1 = "1";
    //分红计提
    String ACCRUAL_TIME_2 = "2";
    //清盘计提
    String ACCRUAL_TIME_3 = "3";
    //定开日计提
    String ACCRUAL_TIME_4 = "4";

    /**
     * 计提算法
     */
    String ACCRUAL_ALGORITHM = "accrual_algorithm";
    //绝对收益率超过业绩比较基准算法
    String ACCRUAL_ALGORITHM_0 = "0";
    //年化收益率超过业绩比较基准算法
    String ACCRUAL_ALGORITHM_1 = "1";

    /**
     * 累进计算模式
     */
    String PROGRESSIVE_CALCULATION_MODE = "progressive_calculation_mode";
    //不累进计算
    String PROGRESSIVE_CALCULATION_MODE_0 = "0";
    //累进计算
    String PROGRESSIVE_CALCULATION_MODE_1 = "1";

    /**
     * 对标指数模式
     */
    String BENCHMARKING_INDEX_MODE = "benchmarking_index_mode";
    //不对标指数
    String BENCHMARKING_INDEX_MODE_0 = "0";
    //对标指数
    String BENCHMARKING_INDEX_MODE_1 = "1";

    /**
     * 计提周期
     */
    String ACCRUAL_CYCLE = "accrual_cycle";
    //月
    String ACCRUAL_CYCLE_0 = "0";
    //季
    String ACCRUAL_CYCLE_1 = "1";
    //半年
    String ACCRUAL_CYCLE_2 = "2";
    //年
    String ACCRUAL_CYCLE_3 = "3";
    //具体日期
    String ACCRUAL_CYCLE_4 = "4";

    /**
     * 计提日期类型
     */
    String ACCRUAL_DATE_TYPE = "accrual_date_type";
    //所选周期第一个工作日
    String ACCRUAL_DATE_TYPE_0 = "0";
    //所选周期最后一个
    String ACCRUAL_DATE_TYPE_1 = "1";

    /**
     * 关联机构类型
     */
    String RELATED_ORG_TYPE = "related_org_type";
    //托管人
    String RELATED_ORG_TYPE_0 = "0";
    //发起人
    String RELATED_ORG_TYPE_1 = "1";
    //管理人
    String RELATED_ORG_TYPE_2 = "2";
    //投资顾问机构
    String RELATED_ORG_TYPE_3 = "3";
    //注册登记机构
    String RELATED_ORG_TYPE_4 = "4";

    /**
     * 关联机构类别
     */
    String RELATED_ORG_CLASS = "related_org_class";
    //银行
    String RELATED_ORG_CLASS_0 = "0";
    //证券
    String RELATED_ORG_CLASS_1 = "1";
    //基金
    String RELATED_ORG_CLASS_2 = "2";
    //保险
    String RELATED_ORG_CLASS_3 = "3";
    //信托
    String RELATED_ORG_CLASS_4 = "4";
    //期货
    String RELATED_ORG_CLASS_5 = "5";
    //私募
    String RELATED_ORG_CLASS_6 = "6";
    //咨询服务
    String RELATED_ORG_CLASS_7 = "7";

    /**
     * 关联机构状态
     */
    String RELATED_ORG_STATUS = "related_org_status";
    //正常
    String RELATED_ORG_STATUS_N = "N";
    //停用
    String RELATED_ORG_STATUS_C = "C";
    //注销
    String RELATED_ORG_STATUS_D = "D";

    /**
     * 数据导入子任务状态
     */
    String DATA_IMP_CHILD_TASK_STATUS = "data_imp_child_task_status";
    //待导入
    String DATA_IMP_CHILD_TASK_STATUS_0 = "0";
    //导入中
    String DATA_IMP_CHILD_TASK_STATUS_1 = "1";
    //导入成功
    String DATA_IMP_CHILD_TASK_STATUS_2 = "2";
    //导入失败
    String DATA_IMP_CHILD_TASK_STATUS_3 = "3";
    //无需导入
    String DATA_IMP_CHILD_TASK_STATUS_4 = "4";

    /**
     * 数据导入状态
     */
    String DATA_IMP_TASK_STATUS = "data_imp_task_status";
    //待导入
    String DATA_IMP_TASK_STATUS_0 = "0";
    //导入中
    String DATA_IMP_TASK_STATUS_1 = "1";
    //导入成功
    String DATA_IMP_TASK_STATUS_2 = "2";
    //导入失败
    String DATA_IMP_TASK_STATUS_3 = "3";
    //置成功
    String DATA_IMP_TASK_STATUS_4 = "4";
    //等待文件上传
    String DATA_IMP_TASK_STATUS_5 = "5";

    /**
     * 文件导入类型
     */
    String IMP_FILE_TYPE = "imp_file_type";
    //明细文件
    String IMP_FILE_TYPE_1 = "1";
    //索引文件
    String IMP_FILE_TYPE_2 = "2";

    /**
     * 接口文件名格式
     */
    String RELATED_FILE_NAME_FORMAT = "related_file_name_format";
    //业务名+日期_托管行代码_TA代码
    String RELATED_FILE_NAME_FORMAT_0 = "0";
    //业务名+日期_托管行代码
    String RELATED_FILE_NAME_FORMAT_1 = "1";
    //业务名+日期
    String RELATED_FILE_NAME_FORMAT_2 = "2";

    /**
     * 会计接口版本
     */
    String ACCOUNTANT_INTERFACE_VERSION = "accountant_interface_version";
    String ACCOUNTANT_INTERFACE_VERSION_0 = "V1.2";
    String ACCOUNTANT_INTERFACE_VERSION_1 = "V1.3";
    String ACCOUNTANT_INTERFACE_VERSION_2 = "V1.4";
    String ACCOUNTANT_INTERFACE_VERSION_3 = "V2.3";
    String ACCOUNTANT_INTERFACE_VERSION_4 = "V2.4";
    String ACCOUNTANT_INTERFACE_VERSION_5 = "V2.5";
    String ACCOUNTANT_INTERFACE_VERSION_6 = "V2.6";

    /**
     * 货币基金大额赎回是否收取强制赎回费
     */
    String LARGERED_FARE = "largered_fare";


    /**
     * 复核状态
     */
    String REVIEW_STATE = "review_state";
    //待复核
    String REVIEW_STATE_0 = "0";
    //复核通过
    String REVIEW_STATE_1 = "1";
    //复核拒绝
    String REVIEW_STATE_2 = "2";
    //已导入
    String REVIEW_STATE_3 = "3";
    //已检查
    String REVIEW_STATE_4 = "4";

    /**
     * 数据来源
     */
    String DATA_SOURCE = "data_source";
    //手工录入
    String DATA_SOURCE_0 = "0";
    //估值系统
    String DATA_SOURCE_1 = "1";

    /**
     * 检查状态
     */
    String CHECK_STATE = "check_state";
    //错误
    String CHECK_STATE_0 = "0";
    //警告
    String CHECK_STATE_1 = "1";
    //通过
    String CHECK_STATE_2 = "2";

    /**
     * 清算标的
     */
    String CLEAR_FLAG = "clear_flag";
    //托管行
    String CLEAR_FLAG_0 = "0";
    //销售商
    String CLEAR_FLAG_1 = "1";

    /**
     * 锁定状态
     */
    String D1000033 = "1000033";

    /**
     * 用户类型
     */
    String D1000031 = "1000031";
    //普通用户
    String D1000031_1 = "1";
    //机构用户
    String D1000031_2 = "2";

    /**
     * 用户状态
     */
    String D1000032 = "1000032";
    //在职
    String D1000032_1 = "1";
    //注销
    String D1000032_2 = "2";

    /**
     * 菜单类型
     */
    String D1000030 = "1000030";
    //普通菜单
    String D1000030_0 = "0";
    //标签菜单
    String D1000030_1 = "1";

    /**
     * 基金周期
     */
    String PRD_CYCLE = "prd_cycle";
    //筹备期
    String PRD_CYCLE_1 = "1";
    //筹备期_立项
    String PRD_CYCLE_101 = "101";
    //筹备期_立项_拟稿
    String PRD_CYCLE_10101 = "10101";
    //筹备期_立项_准入
    String PRD_CYCLE_1010101 = "1010101";
    //筹备期_申请材料制作
    String PRD_CYCLE_102 = "102";
    //筹备期_上报审批
    String PRD_CYCLE_103 = "103";
    //发行期
    String PRD_CYCLE_2 = "2";
    //发行期_中登签署协议
    String PRD_CYCLE_201 = "201";
    //发行期_确定代销机构
    String PRD_CYCLE_202 = "202";
    //发行期_开户
    String PRD_CYCLE_203 = "203";
    //发行期_开户_结算备付金
    String PRD_CYCLE_20301 = "20301";
    //发行期_开户_托管户
    String PRD_CYCLE_20302 = "20302";
    //发行期_开户_证券户
    String PRD_CYCLE_20303 = "20303";
    //发行期_开户_期货账户
    String PRD_CYCLE_20304 = "20304";
    //发行期_募集
    String PRD_CYCLE_204 = "204";
    //发行期_验资
    String PRD_CYCLE_205 = "205";
    //运作期
    String PRD_CYCLE_3 = "3";
    //运作期_开放期
    String PRD_CYCLE_301 = "301";
    //运作期_开放期_临时封闭
    String PRD_CYCLE_30101 = "30101";
    //运作期_开放期_分红
    String PRD_CYCLE_30102 = "30102";
    //运作期_封闭期
    String PRD_CYCLE_302 = "302";
    //运作期_封闭期_临时开放
    String PRD_CYCLE_30201 = "30201";
    //运作期_封闭期_分红
    String PRD_CYCLE_30202 = "30202";
    //清算期
    String PRD_CYCLE_4 = "4";
    //清算期_清仓
    String PRD_CYCLE_401 = "401";
    //清算期_结算
    String PRD_CYCLE_402 = "402";

    /**
     * 基金状态
     */
    String PRD_STATUS = "prd_status";
    //可申购赎回
    String PRD_STATUS_0 = "0";
    //发行
    String PRD_STATUS_1 = "1";
    //停止申购赎回
    String PRD_STATUS_4 = "4";
    //停止申购
    String PRD_STATUS_5 = "5";
    //停止赎回
    String PRD_STATUS_6 = "6";
    //基金终止
    String PRD_STATUS_8 = "8";

    /**
     * 数据导出状态
     */
    String DATA_EXP_TASK_STATUS = "data_exp_task_status";
    //待导出
    String DATA_EXP_TASK_STATUS_0 = "0";
    //导出中
    String DATA_EXP_TASK_STATUS_1 = "1";
    //导出成功
    String DATA_EXP_TASK_STATUS_2 = "2";
    //导出失败
    String DATA_EXP_TASK_STATUS_3 = "3";

    /**
     * 比较符号
     */
    String COMPARE_SYMBOL = "compare_symbol";
    //大于
    String COMPARE_SYMBOL_MORE = ">";
    //大于等于
    String COMPARE_SYMBOL_MORE_EQ = "≥";
    //等于
    String COMPARE_SYMBOL_EQ = "=";
    //小于等于
    String COMPARE_SYMBOL_LESS_EQ = "≤";
    //小于
    String COMPARE_SYMBOL_LESS = "<";

    /**
     * 产品费用设置--费用类型
     */
    String PRD_FEE_TYPE = "prd_fee_type";
    //前收费
    String PRD_FEE_TYPE_0 = "0";
    //后收费
    String PRD_FEE_TYPE_1 = "1";
    //交易费
    String PRD_FEE_TYPE_2 = "2";
    //违约费
    String PRD_FEE_TYPE_3 = "3";
    //补差费
    String PRD_FEE_TYPE_4 = "4";

    /**
     * 产品费用设置--业务类型
     * 销售商折扣限制--业务类型 的下拉选项跟这里的选项值一样，直接用
     */
    String PRD_FEE_BIZ_CODE = "prd_fee_biz_code";
    //认购
    String PRD_FEE_BIZ_CODE_0 = "0";
    //申购
    String PRD_FEE_BIZ_CODE_1 = "1";
    //赎回
    String PRD_FEE_BIZ_CODE_2 = "2";
    //转换
    String PRD_FEE_BIZ_CODE_3 = "3";

    /**
     * 产品费用设置--客户类型
     */
    String PRD_FEE_CUST_TYPE = "prd_fee_cust_type";
    //机构
    String PRD_FEE_CUST_TYPE_0 = "0";
    //个人
    String PRD_FEE_CUST_TYPE_1 = "1";
    //产品
    String PRD_FEE_CUST_TYPE_2 = "2";

    /**
     * 产品费用设置--转入/转出份额类别
     */
    String PRD_FEE_SHARE_TYPE = "prd_fee_share_type";
    //前收费
    String PRD_FEE_SHARE_TYPE_0 = "0";
    //后收费
    String PRD_FEE_SHARE_TYPE_1 = "1";

    /**
     * 产品费用设置--分段方式
     */
    String PRD_FEE_CUT_TYPE = "prd_fee_cut_type";
    //不分段
    String PRD_FEE_CUT_TYPE_0 = "0";
    //按交易金额分段
    String PRD_FEE_CUT_TYPE_1 = "1";
    //按持有天数分段
    String PRD_FEE_CUT_TYPE_2 = "2";
    //按预约天数分段
    String PRD_FEE_CUT_TYPE_3 = "3";

    /**
     * 产品费用设置--费用分成方式
     */
    String PRD_FEE_DIVIDE_WAY = "prd_fee_divide_way";
    //总费用比例
    String PRD_FEE_DIVIDE_WAY_0 = "0";
    //扣除归基金资产后
    String PRD_FEE_DIVIDE_WAY_1 = "1";

    /**
     * 文件格式类型
     */
    String FILE_FORMAT_TYPE = "file_format_type";
    //数据文件
    String FILE_FORMAT_TYPE_0 = "0";
    //索引文件
    String FILE_FORMAT_TYPE_1 = "1";

    /**
     * 文件格式类型
     */
    String FILE_TYPE = "file_type";
    //申请文件导入
    String FILE_TYPE_IMP = "IMP";
    //确认文件导出
    String FILE_TYPE_EXP = "EXP";
    //净值文件导入
    String FILE_TYPE_NAVIMP = "NAVIMP";
    //净值文件导出
    String FILE_TYPE_NAVEXP = "NAVEXP";

    /**
     * 补差费计算模式
     */
    String PRD_FEE_CALCULATION_TYPE = "prd_fee_calculation_type";
    //按计算的模式计转换费
    String PRD_FEE_CALCULATION_TYPE_0 = "0";
    //按费率表中的设置，统一按转换业务
    String PRD_FEE_CALCULATION_TYPE_1 = "1";
    //按费率表中的设置，交易费按赎回业务，补差费按转换业务
    String PRD_FEE_CALCULATION_TYPE_2 = "2";
    //按费率表中的设置，统一按赎回业务
    String PRD_FEE_CALCULATION_TYPE_3 = "3";
    //计算模式补差，根据明细，取历史最高申购费率计算
    String PRD_FEE_CALCULATION_TYPE_4 = "4";
    //计算模式补差，根据明细，取认申购费用差计算
    String PRD_FEE_CALCULATION_TYPE_5 = "5";
    //计算模式补差，根据明细，取认申购费率差计算
    String PRD_FEE_CALCULATION_TYPE_6 = "6";

    /**
     * 费率模式
     */
    String PRD_FEE_RATE_TYPE = "prd_fee_rate_type";
    //根据明细原始份额来源取认/申购费率
    String PRD_FEE_RATE_TYPE_0 = "0";
    //默认取认购费率
    String PRD_FEE_RATE_TYPE_1 = "1";
    //默认取申购费率
    String PRD_FEE_RATE_TYPE_2 = "2";

    /**
     * 费率判断方式
     */
    String PRD_FEE_RATE_JUDGE_TYPE = "prd_fee_rate_judge_type";
    //根据单笔明细金额
    String PRD_FEE_RATE_JUDGE_TYPE_0 = "0";
    //根据汇总金额
    String PRD_FEE_RATE_JUDGE_TYPE_1 = "1";

    /**
     * 下发代码
     */
    String ISSUED_CODE = "issued_Code";

    /**
     * 清盘模式
     */
    String LIQUIDATION_MODE = "liquidation_mode";
    // 全部清盘
    String LIQUIDATION_MODE_0 = "0";
    // 部分清盘
    String LIQUIDATION_MODE_1 = "1";
    // 首次清盘份额为基准份额清盘
    String LIQUIDATION_MODE_2 = "2";

    /**
     * 清盘方式
     */
    String LIQUIDATION_WAY = "liquidation_way";
    // 按单位净值清盘
    String LIQUIDATION_WAY_0 = "0";
    // 按总金额清盘
    String LIQUIDATION_WAY_1 = "1";
    // 按指定可分配资产和可分配份额清盘
    String LIQUIDATION_WAY_2 = "2";

    /**
     * 处理标志
     */
    String DEAL_FLAG = "deal_flag";


    /**
     * 日志类型
     */
    String BUSINESS_LOG_TYPE = "business_log_type";
    //普通日志
    String BUSINESS_LOG_TYPE_0 = "0";
    //特殊日志
    String BUSINESS_LOG_TYPE_1 = "1";

    /**
     * 日志类型
     */
    String BUSINESS_OPERATION_TYPE = "business_operation_type";
    //新增
    String BUSINESS_OPERATION_TYPE_0 = "0";
    //删除
    String BUSINESS_OPERATION_TYPE_1 = "1";
    //修改
    String BUSINESS_OPERATION_TYPE_2 = "2";
    //查询
    String BUSINESS_OPERATION_TYPE_3 = "3";

    /**
     * 性别
     */
    String ACCOUNT_INFO_SEX = "account_info_sex";
    //男
    String ACCOUNT_INFO_SEX_1 = "1";
    //女
    String ACCOUNT_INFO_SEX_2 = "2";

    /**
     * 业务类型(具体业务类型请见TaBizCodeConstants类)
     */
    String ACCOUNT_TRADE_BIZ_CODE = "account_trade_biz_code";


    /**
     * 账户/交易，确认状态
     */
    String ACCOUNT_TRADE_CONFIRM_STATUS = "account_trade_confirm_status";
    //未处理
    String ACCOUNT_TRADE_CONFIRM_STATUS_0 = "0";
    //确认成功
    String ACCOUNT_TRADE_CONFIRM_STATUS_1 = "1";
    //确认失败
    String ACCOUNT_TRADE_CONFIRM_STATUS_2 = "2";
    //交易撤销
    String ACCOUNT_TRADE_CONFIRM_STATUS_9 = "9";

    /**
     * 账户冻结原因
     */
    String ACCOUNT_TRADE_FROZEN_CAUSES = "account_trade_frozen_causes";
    //司法冻结
    String ACCOUNT_TRADE_FROZEN_CAUSES_0 = "0";
    //柜台冻结
    String ACCOUNT_TRADE_FROZEN_CAUSES_1 = "1";
    //质押冻结
    String ACCOUNT_TRADE_FROZEN_CAUSES_2 = "2";
    //质押、司法双重冻结
    String ACCOUNT_TRADE_FROZEN_CAUSES_3 = "3";
    //柜台、司法双重冻结
    String ACCOUNT_TRADE_FROZEN_CAUSES_4 = "4";
    //内部员工自动冻结解冻
    String ACCOUNT_TRADE_FROZEN_CAUSES_5 = "5";

    /**
     * ta发起标志
     */
    String ACCOUNT_TRADE_TA_FLAG = "account_trade_ta_flag";
    //销售商发起
    String ACCOUNT_TRADE_TA_FLAG_0 = "0";
    //TA发起
    String ACCOUNT_TRADE_TA_FLAG_1 = "1";
    // 2-认购确认成功后，人工确认失败
    String ACCOUNT_TRADE_TA_FLAG_2 = "2";

    /**
     * 份额类别/收费类别
     */
    String ACCOUNT_TRADE_SHARE_TYPE = "account_trade_share_type";
    //前收费
    String ACCOUNT_TRADE_SHARE_TYPE_0 = "0";
    //后收费
    String ACCOUNT_TRADE_SHARE_TYPE_1 = "1";
    //前/后收费
    String ACCOUNT_TRADE_SHARE_TYPE_2 = "2";

    /**
     * 巨额赎回处理方式
     */
    String ACCOUNT_TRADE_LARGE_BUY_FLAG = "account_trade_large_buy_flag";
    //取消
    String ACCOUNT_TRADE_LARGE_BUY_FLAG_0 = "0";
    //顺延
    String ACCOUNT_TRADE_LARGE_BUY_FLAG_1 = "1";

    /**
     * 定期定额周期
     */
    String ACCOUNT_TRADE_PERIOD_SUB_TIME_UNIT = "account_trade_period_sub_time_unit";
    //日
    String ACCOUNT_TRADE_PERIOD_SUB_TIME_UNIT_0 = "0";
    //周
    String ACCOUNT_TRADE_PERIOD_SUB_TIME_UNIT_1 = "1";
    //月
    String ACCOUNT_TRADE_PERIOD_SUB_TIME_UNIT_2 = "2";

    /**
     * 交易方式
     */
    String ACCOUNT_TRADE_PERIOD_TRADING_METHOD = "account_trade_period_trading_method";
    //CALLCENTER
    String ACCOUNT_TRADE_PERIOD_TRADING_METHOD_10000000 = "10000000";
    //INTERNET
    String ACCOUNT_TRADE_PERIOD_TRADING_METHOD_01000000 = "01000000";
    //自助终端
    String ACCOUNT_TRADE_PERIOD_TRADING_METHOD_00100000 = "00100000";
    //柜台
    String ACCOUNT_TRADE_PERIOD_TRADING_METHOD_00010000 = "00010000";

    /**
     * 资金方式
     */
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE = "account_trade_period_capital_mode";
    //全部方式
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_ALL = "0";
    //普通方式
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_1 = "1";
    //兴业银基通
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_2 = "2";
    //银联通
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_3 = "3";
    //工行网银
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_4 = "4";
    //好易联
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_5 = "5";
    //汇付天下
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_6 = "6";
    //工行银基通
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_7 = "7";
    //好易联托收
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_8 = "8";
    //银行代扣款
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_9 = "9";
    //农行网银
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_A = "A";
    //建行网银
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_B = "B";
    //交行网银
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_C = "C";
    //北京银行
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_D = "D";
    //支付宝
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_E = "E";
    //浦发网银
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_F = "F";
    //招行网银
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_G = "G";
    //开联网银
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_H = "H";
    //富友
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_I = "I";
    //民生网银
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_J = "J";
    //网下转账
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_K = "K";
    //平安网银
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_L = "L";
    //通联
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_M = "M";
    //中行网银
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_N = "N";
    //易宝
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_P = "P";
    //财富通
    String ACCOUNT_TRADE_PERIOD_CAPITAL_MODE_Q = "Q";

    /**
     * 申请结束标志
     */
    String ACCOUNT_TRADE_BIZ_FINISH_FLAG = "account_trade_biz_finish_flag";
    //中间过程
    String ACCOUNT_TRADE_BIZ_FINISH_FLAG_0 = "0";
    //业务过程结束
    String ACCOUNT_TRADE_BIZ_FINISH_FLAG_1 = "1";

    /**
     * 强增强减原因
     */
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG = "account_trade_share_adjust_flag";
    //柜台业务
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_0 = "0";
    //管理人批量调整
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_1 = "1";
    //管理人普通调整
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_2 = "2";
    //ETF份额标准化
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_3 = "3";
    //货币基金收益结转
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_4 = "4";
    //基金分拆
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_5 = "5";
    //确权
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_6 = "6";
    //基金升降级
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_7 = "7";
    //净值调整
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_9 = "9";
    //业绩报酬
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_A = "A";
    //业绩补偿
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_B = "B";
    //联名卡还款份额调整
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_C = "C";
    //基金展期份额调整
    String ACCOUNT_TRADE_SHARE_ADJUST_FLAG_D = "D";

    /**
     * 账户类业务类型
     */
    String ACCOUNT_BUSINESS_TYPE = "account_business_type";
    //开户申请
    String ACCOUNT_BUSINESS_TYPE_001 = "001";
    //账户信息修改申请
    String ACCOUNT_BUSINESS_TYPE_003 = "003";
    //销户申请
    String ACCOUNT_BUSINESS_TYPE_002 = "002";
    //撤销交易账户申请
    String ACCOUNT_BUSINESS_TYPE_009 = "009";
    //增加交易账户申请
    String ACCOUNT_BUSINESS_TYPE_008 = "008";
    //变更交易账号
    String ACCOUNT_BUSINESS_TYPE_058 = "058";
    //开户确认
    String ACCOUNT_BUSINESS_TYPE_101 = "101";
    //销户确认
    String ACCOUNT_BUSINESS_TYPE_102 = "102";
    //账户信息修改确认
    String ACCOUNT_BUSINESS_TYPE_103 = "103";
    //增加交易账户确认
    String ACCOUNT_BUSINESS_TYPE_108 = "108";
    //变更交易账户确认
    String ACCOUNT_BUSINESS_TYPE_158 = "158";
    //撤销交易账户确认
    String ACCOUNT_BUSINESS_TYPE_109 = "109";

    /**
     * 交易类业务类型
     */
    String TRANSACTION_BUSINESS_TYPE = "transaction_business_type";
    //认购申请
    String TRANSACTION_BUSINESS_TYPE_020 = "020";
    //申购申请
    String TRANSACTION_BUSINESS_TYPE_022 = "022";
    //定时定额申购申请
    String TRANSACTION_BUSINESS_TYPE_039 = "039";
    //ETF申购申请
    String TRANSACTION_BUSINESS_TYPE_091 = "091";
    //赎回申请
    String TRANSACTION_BUSINESS_TYPE_024 = "024";
    //预约赎回申请
    String TRANSACTION_BUSINESS_TYPE_025 = "025";
    //定时定额赎回申请
    String TRANSACTION_BUSINESS_TYPE_063 = "063";
    //ETF赎回申请
    String TRANSACTION_BUSINESS_TYPE_093 = "093";
    //转销售人/机构申请
    String TRANSACTION_BUSINESS_TYPE_026 = "026";
    //转销售人/机构转入申请
    String TRANSACTION_BUSINESS_TYPE_027 = "027";
    //转销售人/机构转出申请
    String TRANSACTION_BUSINESS_TYPE_028 = "028";
    //设置自动再投资申请
    String TRANSACTION_BUSINESS_TYPE_029 = "029";
    //基金份额冻结申请
    String TRANSACTION_BUSINESS_TYPE_031 = "031";
    //基金份额解冻申请
    String TRANSACTION_BUSINESS_TYPE_032 = "032";
    //基金转换申请
    String TRANSACTION_BUSINESS_TYPE_036 = "036";
    //基金转换转入申请
    String TRANSACTION_BUSINESS_TYPE_037 = "037";
    //基金转换转出申请
    String TRANSACTION_BUSINESS_TYPE_038 = "038";
    //撤预约单
    String TRANSACTION_BUSINESS_TYPE_053 = "053";
    //定时定额申购开通申请
    String TRANSACTION_BUSINESS_TYPE_059 = "059";
    //定时定额申购撤销申请
    String TRANSACTION_BUSINESS_TYPE_060 = "060";
    //定时定额变更申请
    String TRANSACTION_BUSINESS_TYPE_061 = "061";
    //认购调整申请
    String TRANSACTION_BUSINESS_TYPE_062 = "062";
    //基金质押申请
    String TRANSACTION_BUSINESS_TYPE_088 = "088";
    //快速过户申请
    String TRANSACTION_BUSINESS_TYPE_098 = "098";
    //认购确认
    String TRANSACTION_BUSINESS_TYPE_120 = "120";
    //申购确认
    String TRANSACTION_BUSINESS_TYPE_122 = "122";
    //定时定额申购确认
    String TRANSACTION_BUSINESS_TYPE_139 = "139";
    //ETF申购一次确认
    String TRANSACTION_BUSINESS_TYPE_191 = "191";
    //ETF申购二次确认
    String TRANSACTION_BUSINESS_TYPE_192 = "192";
    //赎回确认
    String TRANSACTION_BUSINESS_TYPE_124 = "124";
    //强行赎回确认
    String TRANSACTION_BUSINESS_TYPE_142 = "142";
    //定时定额赎回确认
    String TRANSACTION_BUSINESS_TYPE_163 = "163";
    //ETF赎回一次确认
    String TRANSACTION_BUSINESS_TYPE_193 = "193";
    //ETF赎回二次确认
    String TRANSACTION_BUSINESS_TYPE_194 = "194";
    //转销售人/机构确认
    String TRANSACTION_BUSINESS_TYPE_126 = "126";
    //转销售人/机构转入确认
    String TRANSACTION_BUSINESS_TYPE_127 = "127";
    //转销售人/机构转出确认
    String TRANSACTION_BUSINESS_TYPE_128 = "128";
    //设置自动再投资确认
    String TRANSACTION_BUSINESS_TYPE_129 = "129";
    //认购结果
    String TRANSACTION_BUSINESS_TYPE_130 = "130";
    //基金份额冻结确认
    String TRANSACTION_BUSINESS_TYPE_131 = "131";
    //基金份额解冻确认
    String TRANSACTION_BUSINESS_TYPE_132 = "132";
    //基金红利解冻确认
    String TRANSACTION_BUSINESS_TYPE_157 = "157";
    //非交易过户转入确认
    String TRANSACTION_BUSINESS_TYPE_134 = "134";
    //非交易过户转出确认
    String TRANSACTION_BUSINESS_TYPE_135 = "135";
    //基金转换转入确认
    String TRANSACTION_BUSINESS_TYPE_137 = "137";
    //基金转换转出确认
    String TRANSACTION_BUSINESS_TYPE_138 = "138";
    //撤预约单确认
    String TRANSACTION_BUSINESS_TYPE_153 = "153";
    //强行调增
    String TRANSACTION_BUSINESS_TYPE_144 = "144";
    //强行调减
    String TRANSACTION_BUSINESS_TYPE_145 = "145";
    //认购调整确认
    String TRANSACTION_BUSINESS_TYPE_162 = "162";
    //定时定额申购开通确认
    String TRANSACTION_BUSINESS_TYPE_159 = "159";
    //定时定额申购撤销确认
    String TRANSACTION_BUSINESS_TYPE_160 = "160";
    //定时定额变更确认
    String TRANSACTION_BUSINESS_TYPE_161 = "161";
    //基金质押确认
    String TRANSACTION_BUSINESS_TYPE_188 = "188";
    //快速过户确认
    String TRANSACTION_BUSINESS_TYPE_198 = "198";
    //募集失败
    String TRANSACTION_BUSINESS_TYPE_149 = "149";
    //基金清盘
    String TRANSACTION_BUSINESS_TYPE_150 = "150";
    //基金终止
    String TRANSACTION_BUSINESS_TYPE_151 = "151";
    //预约赎回确认
    String TRANSACTION_BUSINESS_TYPE_125 = "125";

    /**
     * 名单类别
     */
    String ACCOUNT_LIST_CLASS = "account_list_class";
    //普通
    String ACCOUNT_LIST_CLASS_0 = "0";
    //集团客户
    String ACCOUNT_LIST_CLASS_1 = "1";

    /**
     * 名单类型
     */
    String ACCOUNT_LIST_TYPE = "account_list_type";
    //白名单
    String ACCOUNT_LIST_TYPE_0 = "0";
    //黑名单
    String ACCOUNT_LIST_TYPE_1 = "1";
    //内部员工
    String ACCOUNT_LIST_TYPE_2 = "2";

    /**
     * 客户状态
     */
    String ACCOUNT_LIST_STATUS = "account_list_status";
    //正常
    String ACCOUNT_LIST_STATUS_0 = "0";
    //无效
    String ACCOUNT_LIST_STATUS_1 = "1";

    /**
     * 产品证件类型
     */
    String ACCOUNT_INFO_PRODUCT_CERT_TYPE = "account_info_product_cert_type";
    //营业执照
    String ACCOUNT_INFO_PRODUCT_CERT_TYPE_1 = "1";
    //其他
    String ACCOUNT_INFO_PRODUCT_CERT_TYPE_8 = "8";
    //登记证书
    String ACCOUNT_INFO_PRODUCT_CERT_TYPE_9 = "9";
    //批文
    String ACCOUNT_INFO_PRODUCT_CERT_TYPE_A = "A";

    /**
     * 消息状态
     */
    String COMMUNICATION_MESSAGE_STATUS = "communication_message_status";
    //未读
    String COMMUNICATION_MESSAGE_STATUS_0 = "0";
    //已读
    String COMMUNICATION_MESSAGE_STATUS_1 = "1";

    /**
     * 消息发送模块
     */
    String COMMUNICATION_MESSAGE_SENDER_MODEL = "communication_message_sender_model";
    //权限
    String COMMUNICATION_MESSAGE_SENDER_MODEL_0 = "0";
    //交易
    String COMMUNICATION_MESSAGE_SENDER_MODEL_1 = "1";
    //产品
    String COMMUNICATION_MESSAGE_SENDER_MODEL_2 = "2";
    //账户
    String COMMUNICATION_MESSAGE_SENDER_MODEL_3 = "3";
    //消息域
    String COMMUNICATION_MESSAGE_SENDER_MODEL_communication = "communication";
    //流程域
    String COMMUNICATION_MESSAGE_SENDER_MODEL_schedule = "schedule";
    //工具域
    String COMMUNICATION_MESSAGE_SENDER_MODEL_tool = "tool";
    //清算流程域
    String COMMUNICATION_MESSAGE_SENDER_MODEL_process = "process";
    //管理域administration
    String COMMUNICATION_MESSAGE_SENDER_MODEL_administration = "administration";

    /**
     * 消息类型
     */
    String COMMUNICATION_MESSAGE_TYPE = "communication_message_type";
    //系统公告
    String COMMUNICATION_MESSAGE_TYPE_0 = "0";
    //业务提醒
    String COMMUNICATION_MESSAGE_TYPE_1 = "1";
    //工作台数据刷新
    String COMMUNICATION_MESSAGE_TYPE_2 = "2";

    /**
     * 消息优先级
     */
    String COMMUNICATION_MESSAGE_PRIORITY = "communication_message_priority";
    //高
    String COMMUNICATION_MESSAGE_PRIORITY_0 = "0";
    //中
    String COMMUNICATION_MESSAGE_PRIORITY_1 = "1";
    //低
    String COMMUNICATION_MESSAGE_PRIORITY_2 = "2";

    /**
     * 账户状态
     */
    String ACCOUNT_INFO_ACCOUNT_STATUS = "account_info_account_status";
    //正常
    String ACCOUNT_INFO_ACCOUNT_STATUS_0 = "0";
    //注销
    String ACCOUNT_INFO_ACCOUNT_STATUS_1 = "1";
    //冻结
    String ACCOUNT_INFO_ACCOUNT_STATUS_2 = "2";

    /**
     * 职业
     */
    String ACCOUNT_INFO_VOCATION_CODE = "account_info_vocation_code";
    //党政机关、事业单位
    String ACCOUNT_INFO_VOCATION_CODE_01 = "01";
    //企业单位
    String ACCOUNT_INFO_VOCATION_CODE_02 = "02";
    //自由业主
    String ACCOUNT_INFO_VOCATION_CODE_03 = "03";
    //学生
    String ACCOUNT_INFO_VOCATION_CODE_04 = "04";
    //军人
    String ACCOUNT_INFO_VOCATION_CODE_05 = "05";
    //其他
    String ACCOUNT_INFO_VOCATION_CODE_06 = "06";

    /**
     * 学历
     */
    String ACCOUNT_INFO_EDUCATION_LEVEL = "account_info_education_level";
    //研究生
    String ACCOUNT_INFO_EDUCATION_LEVEL_01 = "01";
    //大学本科
    String ACCOUNT_INFO_EDUCATION_LEVEL_02 = "02";
    //大学专科
    String ACCOUNT_INFO_EDUCATION_LEVEL_03 = "03";
    //中专或技校
    String ACCOUNT_INFO_EDUCATION_LEVEL_04 = "04";
    //技工学校
    String ACCOUNT_INFO_EDUCATION_LEVEL_05 = "05";
    //高中
    String ACCOUNT_INFO_EDUCATION_LEVEL_06 = "06";
    //初中
    String ACCOUNT_INFO_EDUCATION_LEVEL_07 = "07";
    //小学
    String ACCOUNT_INFO_EDUCATION_LEVEL_08 = "08";
    //文盲或半文盲
    String ACCOUNT_INFO_EDUCATION_LEVEL_09 = "09";

    /**
     * 个人证件类型
     */
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE = "account_info_transactor_cert_type";
    //身份证
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_0 = "0";
    //护照
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_1 = "1";
    //军官证
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_2 = "2";
    //士兵证
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_3 = "3";
    //港澳居民来往内地通行证
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_4 = "4";
    //户口本
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_5 = "5";
    //外国护照
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_6 = "6";
    //其它
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_7 = "7";
    //文职证
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_8 = "8";
    //警官证
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_9 = "9";
    //台胞证
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_A = "A";
    //外国人永久居留身份证
    String ACCOUNT_INFO_TRANSACTOR_CERT_TYPE_B = "B";

    /**
     * 机构证件类型
     */
    String ACCOUNT_INFO_INSTREPR_ID_TYPE = "account_info_instrepr_id_type";
    //组织机构代码证
    String ACCOUNT_INFO_INSTREPR_ID_TYPE_0 = "0";
    //营业执照
    String ACCOUNT_INFO_INSTREPR_ID_TYPE_1 = "1";
    //行政机关
    String ACCOUNT_INFO_INSTREPR_ID_TYPE_2 = "2";
    //社会团体
    String ACCOUNT_INFO_INSTREPR_ID_TYPE_3 = "3";
    //军队
    String ACCOUNT_INFO_INSTREPR_ID_TYPE_4 = "4";
    //武警
    String ACCOUNT_INFO_INSTREPR_ID_TYPE_5 = "5";
    //下属机构（具有主管单位批文号）
    String ACCOUNT_INFO_INSTREPR_ID_TYPE_6 = "6";
    //基金会
    String ACCOUNT_INFO_INSTREPR_ID_TYPE_7 = "7";
    //其它
    String ACCOUNT_INFO_INSTREPR_ID_TYPE_8 = "8";
    //登记证书
    String ACCOUNT_INFO_INSTREPR_ID_TYPE_9 = "9";
    //批文
    String ACCOUNT_INFO_INSTREPR_ID_TYPE_A = "A";

    /**
     * 对账单寄送途径
     */
    String ACCOUNT_INFO_DELIVER_WAY = "account_info_deliver_way";
    //邮寄
    String ACCOUNT_INFO_DELIVER_WAY_10000000 = "10000000";
    //传真
    String ACCOUNT_INFO_DELIVER_WAY_01000000 = "01000000";
    //E-mail
    String ACCOUNT_INFO_DELIVER_WAY_00100000 = "00100000";
    //短消息
    String ACCOUNT_INFO_DELIVER_WAY_00010000 = "00010000";
    //保留
    String ACCOUNT_INFO_DELIVER_WAY_00001000 = "00001000";
    //保留
    String ACCOUNT_INFO_DELIVER_WAY_00000100 = "00000100";
    //保留
    String ACCOUNT_INFO_DELIVER_WAY_00000010 = "00000010";
    //保留
    String ACCOUNT_INFO_DELIVER_WAY_00000001 = "00000001";

    /**
     * 对账单寄送类型
     */
    String ACCOUNT_INFO_DELIVER_TYPE = "account_info_deliver_type";
    //不寄送
    String ACCOUNT_INFO_DELIVER_TYPE_1 = "1";
    //按月
    String ACCOUNT_INFO_DELIVER_TYPE_2 = "2";
    //按季
    String ACCOUNT_INFO_DELIVER_TYPE_3 = "3";
    //半年
    String ACCOUNT_INFO_DELIVER_TYPE_4 = "4";
    //一年
    String ACCOUNT_INFO_DELIVER_TYPE_5 = "5";

    /**
     * 推荐人类型
     */
    String ACCOUNT_INFO_COMMEND_PERSON_TYPE = "account_info_commend_person_type";
    //内部员工
    String ACCOUNT_INFO_COMMEND_PERSON_TYPE_1 = "1";
    //注册用户
    String ACCOUNT_INFO_COMMEND_PERSON_TYPE_2 = "2";
    //基金账户
    String ACCOUNT_INFO_COMMEND_PERSON_TYPE_3 = "3";
    //客户经理编号
    String ACCOUNT_INFO_COMMEND_PERSON_TYPE_4 = "4";
    //客户经理姓名
    String ACCOUNT_INFO_COMMEND_PERSON_TYPE_5 = "5";
    //其他
    String ACCOUNT_INFO_COMMEND_PERSON_TYPE_0 = "0";

    /**
     * 修改重要内容信息
     */
    String ACCOUNT_INFO_MODIFY_INFO = "account_info_modify_info";
    //是
    String ACCOUNT_INFO_MODIFY_INFO_0 = "0";
    //否
    String ACCOUNT_INFO_MODIFY_INFO_1 = "1";

    /**
     * 交易账号状态
     */
    String ACCOUNT_INFO_TRANS_ACCO_STATUS = "account_info_trans_acco_status";
    //正常
    String ACCOUNT_INFO_TRANS_ACCO_STATUS_0 = "0";
    //注销
    String ACCOUNT_INFO_TRANS_ACCO_STATUS_1 = "1";
    //冻结
    String ACCOUNT_INFO_TRANS_ACCO_STATUS_2 = "2";

    /**
     * 公告类别
     */
    String PRODUCT_ANNOUNCEMENT_CATEGORY = "product_announcement_category";
    //异常
    String PRODUCT_ANNOUNCEMENT_CATEGORY_0 = "0";
    //正常
    String PRODUCT_ANNOUNCEMENT_CATEGORY_1 = "1";

    /**
     * 优惠方式
     */
    String DISCOUNT_WAY = "discount_way";
    //折扣费用
    String DISCOUNT_WAY_0 = "0";
    //折扣费率
    String DISCOUNT_WAY_1 = "1";
    //降低费用
    String DISCOUNT_WAY_2 = "2";
    //降低费率
    String DISCOUNT_WAY_3 = "3";
    //固定收取
    String DISCOUNT_WAY_4 = "4";

    /**
     * 交易渠道
     */
    String TRADE_CHANNEL = "trade_channel";
    //全部
    String TRADE_CHANNEL_0 = "0";
    //柜台
    String TRADE_CHANNEL_1 = "1";
    //电话
    String TRADE_CHANNEL_2 = "2";
    //网上
    String TRADE_CHANNEL_3 = "3";
    //自助
    String TRADE_CHANNEL_4 = "4";
    //传真
    String TRADE_CHANNEL_5 = "5";
    //分红
    String TRADE_CHANNEL_6 = "6";
    //其他
    String TRADE_CHANNEL_7 = "7";

    /**
     * 分红模式
     */
    String DIVIDEND_MODE = "dividend_mode";
    //单位分红
    String DIVIDEND_MODE_0 = "0";
    //分配红利总额
    String DIVIDEND_MODE_1 = "1";

    /**
     * 分红处理标志
     */
    String DIVIDEND_DEAL_FLAG = "dividend_deal_flag";
    //未处理
    String DIVIDEND_DEAL_FLAG_0 = "0";
    //已处理
    String DIVIDEND_DEAL_FLAG_1 = "1";
    //处理中
    String DIVIDEND_DEAL_FLAG_2 = "2";

    /**
     * 产品运行状态
     */
    String PRD_RUN_STATUS = "prd_run_status";
    //超额申购
    String PRD_RUN_STATUS_1 = "1";
    //巨额赎回
    String PRD_RUN_STATUS_2 = "2";

    /**
     * 产品规模处理标志
     */
    String PRD_RUN_DEAL_FLAG = "prd_run_deal_flag";
    //未处理
    String PRD_RUN_DEAL_FLAG_0 = "0";
    //已处理
    String PRD_RUN_DEAL_FLAG_1 = "1";

    /**
     * 行情检查信息状态
     */
    String NAV_CHECK_INFO_STATUS = "nav_check_info_status";
    //不可忽略
    String NAV_CHECK_INFO_STATUS_0 = "0";
    //未忽略
    String NAV_CHECK_INFO_STATUS_1 = "1";
    //已忽略
    String NAV_CHECK_INFO_STATUS_2 = "2";

    /**
     * 产品优惠分段方式
     */
    String PRD_DISCOUNT_CUT_TYPE = "prd_discount_cut_type";
    //按交易金额分段
    String PRD_DISCOUNT_CUT_TYPE_1 = "1";
    //按持有天数分段
    String PRD_DISCOUNT_CUT_TYPE_2 = "2";
    //不分段
    String PRD_DISCOUNT_CUT_TYPE_0 = "0";
    //按优惠次数分段
    String PRD_DISCOUNT_CUT_TYPE_3 = "3";

    /**
     * 连接符号
     */
    String TOOL_SQL_CONNECTION_SYMBOL = "tool_sql_connection_symbol";
    //等于
    String TOOL_SQL_CONNECTION_SYMBOL_EQ = "=";
    //大于
    String TOOL_SQL_CONNECTION_SYMBOL_MORE = ">";
    //大于等于
    String TOOL_SQL_CONNECTION_SYMBOL_MORE_EQ = ">=";
    //不等于
    String TOOL_SQL_CONNECTION_SYMBOL_NOT_EQ = "<>";
    //小于
    String TOOL_SQL_CONNECTION_SYMBOL_LESS = "<";
    //小于等于
    String TOOL_SQL_CONNECTION_SYMBOL_LESS_EQ = "<=";
    //模糊查
    String TOOL_SQL_CONNECTION_SYMBOL_LIKE = "LIKE";
    //区间
    String TOOL_SQL_CONNECTION_SYMBOL_BETWEEN = "BETWEEN";
    //空
    String TOOL_SQL_CONNECTION_SYMBOL_IS_NULL = "IS NULL";
    //非空
    String TOOL_SQL_CONNECTION_SYMBOL_IS_NOT_NULL = "IS NOT NULL";

    /**
     * 连接条件
     */
    String TOOL_SQL_CONNECTION_CONDITION = "tool_sql_connection_condition";
    //并且
    String TOOL_SQL_CONNECTION_CONDITION_AND = "AND";
    //或者
    String TOOL_SQL_CONNECTION_CONDITION_OR = "OR";

    /**
     * 受理方式
     */
    String ACCEPT_METHOD = "accept_method";
    //柜台
    String ACCEPT_METHOD_0 = "0";
    //电话
    String ACCEPT_METHOD_1 = "1";
    //网上
    String ACCEPT_METHOD_2 = "2";
    //自助
    String ACCEPT_METHOD_3 = "3";
    //传真
    String ACCEPT_METHOD_4 = "4";
    //其他
    String ACCEPT_METHOD_5 = "5";

    /**
     * 是否约定赎回份额标志
     */
    String PROMISE_SHARES_FLAG = "promise_shares_flag";

    /**
     * 冻结类型
     */
    String SHARE_FROZEN_TYPE = "share_frozen_type";
    //账户冻结
    String SHARE_FROZEN_TYPE_0 = "0";
    //份额冻结
    String SHARE_FROZEN_TYPE_1 = "1";

    /**
     * 是否冻结权益
     */
    String FREEZING_RIGHT = "freezing_right";
    //不冻结
    String FREEZING_RIGHT_0 = "0";
    //冻结
    String FREEZING_RIGHT_1 = "1";

    /**
     * 解冻标志
     */
    String UNFREEZE_FLAG = "unfreeze_flag";
    //未解冻
    String UNFREEZE_FLAG_0 = "0";
    //解冻
    String UNFREEZE_FLAG_1 = "1";

    /**
     * 产品优惠设置-业务类型
     */
    String PRD_DISCOUNT_BIZ_CODE = "prd_discount_biz_code";
    //认购
    String PRD_DISCOUNT_BIZ_CODE_0 = "0";
    //申购
    String PRD_DISCOUNT_BIZ_CODE_1 = "1";
    //定投
    String PRD_DISCOUNT_BIZ_CODE_2 = "2";
    //定期定额申购协议
    String PRD_DISCOUNT_BIZ_CODE_3 = "3";
    //赎回
    String PRD_DISCOUNT_BIZ_CODE_4 = "4";
    //转换
    String PRD_DISCOUNT_BIZ_CODE_5 = "5";

    /**
     * 客户类型
     */
    String ACCOUNT_INFO_CUST_TYPE = "account_info_cust_type";
    //机构
    String ACCOUNT_INFO_CUST_TYPE_0 = "0";
    //个人
    String ACCOUNT_INFO_CUST_TYPE_1 = "1";
    //产品
    String ACCOUNT_INFO_CUST_TYPE_2 = "2";

    /**
     * 巨额赎回标志
     */
    String NAV_LARGE_REDEEM_FLAG = "nav_large_redeem_flag";

    /**
     * 超额申购标志
     */
    String NAV_LARGE_ALLOT_FLAG = "nav_large_allot_flag";


    /**
     * 超额申购标志
     */
    String PERFORMANCE_ACHIVMENT_TYPE = "performance_achivment_type";
    //清盘业绩提成
    String PERFORMANCE_ACHIVMENT_TYPE_1 = "1";
    //赎回业绩提成
    String PERFORMANCE_ACHIVMENT_TYPE_2 = "2";
    //分红业绩提成
    String PERFORMANCE_ACHIVMENT_TYPE_3 = "3";
    //统一业绩提成
    String PERFORMANCE_ACHIVMENT_TYPE_4 = "4";

    /**
     * 系统参数 是否冻结现金
     */
    String SYSTEM_PARAM_FROZEN_BALANCE_RIGHT = "system_param_frozen_balance_right";


    /**
     * 系统参数 是否冻结份额
     */
    String SYSTEM_PARAM_FROZEN_SHARE_RIGHT = "system_param_frozen_share_right";


    /**
     * 系统参数 冻结是否强制再投资
     */
    String SYSTEM_PARAM_FROZEN_FORCE_REINVEST = "system_param_frozen_force_reinvest";

    /**
     * 业务分类
     */
    String BUSINESS_CLASSIFICATION = "business_classification";
    //账户类业务
    String BUSINESS_CLASSIFICATION_ACCOUNT = "0";
    //交易类业务
    String BUSINESS_CLASSIFICATION_TRADE = "1";

    /**
     * 基金账号预分配使用标志
     */
    String SNO_FUND_ACCT_ORG_USE_FLAG = "sno_fund_acct_org_use_flag";
    //号码已用完
    String SNO_FUND_ACCT_ORG_USE_FLAG_0 = "0";
    //正在使用
    String SNO_FUND_ACCT_ORG_USE_FLAG_1 = "1";

    /**
     * 产品阶段
     */
    String PRD_LEVEL = "prd_level";
    //设计期
    String PRD_LEVEL_0 = "0";
    //募集期
    String PRD_LEVEL_1 = "1";
    //运行期
    String PRD_LEVEL_2 = "2";
    //终止
    String PRD_LEVEL_3 = "3";

    /**
     * 账户业务类型
     */
    String ACT_BIZ_TYPE = "act_biz_type";
    //开户
    String ACT_BIZ_TYPE_001 = "001";
    //增加交易账户
    String ACT_BIZ_TYPE_008 = "008";
    //基金账户冻结
    String ACT_BIZ_TYPE_004 = "004";
    //账户信息修改
    String ACT_BIZ_TYPE_003 = "003";
    //基金账户卡挂失
    String ACT_BIZ_TYPE_006 = "006";
    //销户
    String ACT_BIZ_TYPE_002 = "002";
    //撤销交易账户
    String ACT_BIZ_TYPE_009 = "009";
    //基金账户解冻
    String ACT_BIZ_TYPE_005 = "005";
    //变更交易账号
    String ACT_BIZ_TYPE_058 = "058";
    //基金账户卡解冻
    String ACT_BIZ_TYPE_007 = "007";
    //基金联名卡开通
    String ACT_BIZ_TYPE_067 = "067";
    //基金联名卡注销
    String ACT_BIZ_TYPE_068 = "068";
    //基金转换
    String ACT_BIZ_TYPE_036 = "036";
    //基金转换入
    String ACT_BIZ_TYPE_037 = "037";
    //基金转换出
    String ACT_BIZ_TYPE_038 = "038";

    /**
     * 认申购业务
     */
    String RSG_BIZ_TYPE = "rsg_biz_type";
    //认购
    String RSG_BIZ_TYPE_020 = "020";
    //申购
    String RSG_BIZ_TYPE_022 = "022";
    //赎回
    String RSG_BIZ_TYPE_024 = "024";
    //定时定额注册
    String RSG_BIZ_TYPE_059 = "059";
    //预约认购
    String RSG_BIZ_TYPE_021 = "021";
    //预约申购
    String RSG_BIZ_TYPE_023 = "023";
    //预约赎回
    String RSG_BIZ_TYPE_025 = "025";
    //定时定额注销
    String RSG_BIZ_TYPE_060 = "060";
    //定时定额申购
    String RSG_BIZ_TYPE_039 = "039";
    //定时定额赎回
    String RSG_BIZ_TYPE_063 = "063";
    //强制赎回
    String RSG_BIZ_TYPE_042 = "042";
    //ETF申购
    String RSG_BIZ_TYPE_091 = "091";
    //ETF赎回
    String RSG_BIZ_TYPE_093 = "093";

    /**
     * 转换业务
     */
    String SW_BIZ_TYPE = "sw_biz_type";
    //基金转换
    String SW_BIZ_TYPE_036 = "036";
    //基金转换入
    String SW_BIZ_TYPE_037 = "037";
    //基金转换出
    String SW_BIZ_TYPE_038 = "038";

    /**
     * 份额调整业务
     */
    String FEDZ_BIZ_TYPE = "fedz_biz_type";
    //基金份额冻结
    String FEDZ_BIZ_TYPE_031 = "031";
    //非交易过户
    String FEDZ_BIZ_TYPE_033 = "033";
    //强行调增
    String FEDZ_BIZ_TYPE_044 = "044";
    //快速过户
    String FEDZ_BIZ_TYPE_098 = "098";
    //基金份额解冻
    String FEDZ_BIZ_TYPE_032 = "032";
    //非交易过户转入
    String FEDZ_BIZ_TYPE_034 = "034";
    //强行调减
    String FEDZ_BIZ_TYPE_045 = "045";
    //快速过户入
    String FEDZ_BIZ_TYPE_097 = "097";
    //非交易过户转出
    String FEDZ_BIZ_TYPE_035 = "035";
    //快速过户出
    String FEDZ_BIZ_TYPE_096 = "096";

    /**
     * 分红业务
     */
    String DIV_BIZ_TYPE = "div_biz_type";
    //设置分红方式
    String DIV_BIZ_TYPE_029 = "029";
    //红利冻结
    String DIV_BIZ_TYPE_044 = "044";
    //红利解冻
    String DIV_BIZ_TYPE_043 = "043";

    /**
     * 客户名称修改标志
     */
    String MODIFY_NAME_FLAG = "modify_name_flag";
    //未修改
    String MODIFY_NAME_FLAG_0 = "0";
    //修改
    String MODIFY_NAME_FLAG_1 = "1";

    /**
     * 证件修改标志
     */
    String MODIFY_CERTIFICATE_FLAG = "modify_certificate_flag";
    //未修改
    String MODIFY_CERTIFICATE_FLAG_0 = "0";
    //修改
    String MODIFY_CERTIFICATE_FLAG_1 = "1";

    /**
     * 证件修改标志
     */
    String CLIENT_RISK_RATE = "client_risk_rate";
    //低风险承受能力
    String CLIENT_RISK_RATE_1 = "1";
    //较低风险承受能力
    String CLIENT_RISK_RATE_2 = "2";
    //中等风险承受能力
    String CLIENT_RISK_RATE_3 = "3";
    //较高风险承受能力
    String CLIENT_RISK_RATE_4 = "4";
    //高风险承受能力
    String CLIENT_RISK_RATE_5 = "5";

    /**
     * 网络类型
     */
    String D1000061 = "1000061";
    //内网
    String D1000061_1 = "1";
    //VPN
    String D1000061_2 = "2";

    /**
     * 网络访问策略
     */
    String D1000056 = "1000056";
    //限制内网访问
    String D1000056_1 = "1";
    //限制VPN访问
    String D1000056_2 = "2";

    /**
     * 网络访问过滤
     */
    String D1000062 = "1000062";
    //限制访问菜单
    String D1000062_1 = "1";
    //限制登录
    String D1000062_2 = "2";

    /**
     * 当日新增收益参与兑付
     */
    String ADD_INCOME_CASH = "add_income_cash";

    /**
     * 是否允许发起违约赎回
     */
    String ALLOW_BETRAYAL_REDEEM = "allow_betrayal_redeem";

    /**
     * 全赎后兑付份额自动强赎
     */
    String AUTO_REDEEM_CASH_SHARE = "auto_redeem_cash_share";


    /**
     * 全赎后兑付份额自动强赎
     */
    String CHARGE_LATER_CALCU_TYPE = "charge_later_calcu_type";
    //价内法
    String CHARGE_LATER_CALCU_TYPE_0 = "0";
    //价外法
    String CHARGE_LATER_CALCU_TYPE_1 = "1";

    /**
     * 后收费分成模式
     */
    String CHARGE_LATER_DIVIDE_TYPE = "charge_later_divide_type";
    //按确认金额一定比例
    String CHARGE_LATER_DIVIDE_TYPE_0 = "0";
    //按费率计算后分成
    String CHARGE_LATER_DIVIDE_TYPE_1 = "1";
    //按前收费率设置计算
    String CHARGE_LATER_DIVIDE_TYPE_2 = "2";
    //按前收费率设置及分成比例计算
    String CHARGE_LATER_DIVIDE_TYPE_3 = "3";

    /**
     * 确权申请开通标志
     */
    String CONFIRM_APPLY_OPEN = "confirm_apply_open";
    //不开通
    String CONFIRM_APPLY_OPEN_0 = "0";
    //开通
    String CONFIRM_APPLY_OPEN_1 = "1";

    /**
     * T日确认的份额T+1日是否可用
     */
    String CONFIRM_SHARE_AVAILABLE = "confirm_share_available";

    /**
     * 超额认申购处理方式
     */
    String EXCESS_SUB_RED_WAY = "excess_sub_red_way";
    //物理顺序优先
    String EXCESS_SUB_RED_WAY_1 = "1";
    //申请单号优先
    String EXCESS_SUB_RED_WAY_2 = "2";
    //申请时间优先
    String EXCESS_SUB_RED_WAY_3 = "3";
    //申请金额优先
    String EXCESS_SUB_RED_WAY_4 = "4";
    //分销售商汇总金额优先
    String EXCESS_SUB_RED_WAY_5 = "5";
    //所有销售商汇总金额优先
    String EXCESS_SUB_RED_WAY_6 = "6";

    /**
     * 导出基金行情
     */
    String EXP_PRD_NAV_INFO = "exp_prd_nav_info";

    /**
     * 服务费支付频率
     */
    String PAY_FEE_FREQUENCY = "pay_fee_frequency";
    //按月
    String PAY_FEE_FREQUENCY_1 = "1";
    //按季
    String PAY_FEE_FREQUENCY_2 = "2";

    /**
     * 申购资金交收方式
     */
    String PURCHASE_FUND_TYPE = "purchase_fund_type";
    //按确认金额交收
    String PURCHASE_FUND_TYPE_1 = "1";
    //按成交金额交收
    String PURCHASE_FUND_TYPE_2 = "2";

    /**
     * 赎回资金交收方式
     */
    String REDEEM_FUND_TYPE = "redeem_fund_type";
    //按确认金额交收
    String REDEEM_FUND_TYPE_1 = "1";
    //按成交金额交收
    String REDEEM_FUND_TYPE_2 = "2";

    /**
     * 注册机构费用处理方式
     */
    String REGISTER_ORG_FEE_TYPE = "register_org_fee_type";
    //归注册机构
    String REGISTER_ORG_FEE_TYPE_0 = "0";
    //赎回归基金资产
    String REGISTER_ORG_FEE_TYPE_1 = "1";
    //赎回转换归基金资产
    String REGISTER_ORG_FEE_TYPE_2 = "2";

    /**
     * 销售服务费计算方式
     */
    String SALE_FEE_CALCU_TYPE = "sale_fee_calcu_type";
    //保有金额
    String SALE_FEE_CALCU_TYPE_0 = "0";
    //保有份额
    String SALE_FEE_CALCU_TYPE_1 = "1";

    /**
     * 认购款到账方式
     */
    String SUB_FUND_RECEIVE_TYPE = "sub_fund_receive_type";
    //每天T+n到账
    String SUB_FUND_RECEIVE_TYPE_1 = "1";
    //募集结束日+n到账
    String SUB_FUND_RECEIVE_TYPE_2 = "2";

    /**
     * 账户申请业务代码
     */
    String ACCOUNT_APPLY_BIZ_CODE = "account_apply_biz_code";
    //开户申请
    String ACCOUNT_APPLY_BIZ_CODE_001 = "001";
    //销户申请
    String ACCOUNT_APPLY_BIZ_CODE_002 = "002";
    //账户信息修改申请
    String ACCOUNT_APPLY_BIZ_CODE_003 = "003";
    //账户冻结
    String ACCOUNT_APPLY_BIZ_CODE_004 = "004";
    //账户解冻
    String ACCOUNT_APPLY_BIZ_CODE_005 = "005";
    //增加交易账户申请
    String ACCOUNT_APPLY_BIZ_CODE_008 = "008";
    //撤销交易账户申请
    String ACCOUNT_APPLY_BIZ_CODE_009 = "009";
    //变更交易账号
    String ACCOUNT_APPLY_BIZ_CODE_058 = "058";

    /**
     * 是否人工修改标志
     */
    String ARTIFICIAL_EDIT_FLAG = "artificial_edit_flag";

    /**
     * 人工确认标志
     */
    String ARTIFICIAL_FLAG = "artificial_flag";
    //无须人工确认
    String ARTIFICIAL_FLAG_0 = "0";
    //待人工确认
    String ARTIFICIAL_FLAG_1 = "1";
    //人工逐笔确认
    String ARTIFICIAL_FLAG_2 = "2";
    //人工确认成功
    String ARTIFICIAL_FLAG_3 = "3";
    //人工逐笔否决
    String ARTIFICIAL_FLAG_4 = "4";
    //规模控制导致失败
    String ARTIFICIAL_FLAG_5 = "5";

    /**
     * 邮件服务器协议类型
     */
    String MAIL_PROTOCOL_TYPE = "mail_protocol_type";
    //smpt
    String MAIL_PROTOCOL_TYPE_SMPT = "SMPT";
    //pop3
    String MAIL_PROTOCOL_TYPE_POP3 = "POP3";
    //map4
    String MAIL_PROTOCOL_TYPE_MAP4 = "MAP4";

    /**
     * 邮件模板状态
     */
    String MAIL_TEMPLATE_STATUS = "mail_template_status";
    //正常
    String MAIL_TEMPLATE_STATUS_1 = "1";
    //禁用
    String MAIL_TEMPLATE_STATUS_0 = "0";

    /**
     * 份额冻结解冻由TA发起
     */
    String FREEZE_UNFREEZE_SHARE_BY_TA = "freeze_unfreeze_share_by_ta";

    /**
     * 过户原因
     */
    String TRANSFER_REASON = "transfer_reason";
    //司法
    String TRANSFER_REASON_0 = "0";
    //继承
    String TRANSFER_REASON_1 = "1";
    //捐赠
    String TRANSFER_REASON_2 = "2";
    //赠与
    String TRANSFER_REASON_3 = "3";
    //自愿离婚
    String TRANSFER_REASON_4 = "4";
    //分家析产
    String TRANSFER_REASON_5 = "5";
    //国有资产无偿划转
    String TRANSFER_REASON_6 = "6";
    //机构合并或分立
    String TRANSFER_REASON_7 = "7";
    //资产售卖
    String TRANSFER_REASON_8 = "8";
    //机构清算
    String TRANSFER_REASON_9 = "9";
    //企业破产清算
    String TRANSFER_REASON_a = "a";
    //强制执行
    String TRANSFER_REASON_b = "b";
    //份额转让
    String TRANSFER_REASON_d = "d";
    //份额转让协议
    String TRANSFER_REASON_g = "g";
    //098二次垫资
    String TRANSFER_REASON_k = "k";
    //其他
    String TRANSFER_REASON_l = "l";

    /**
     * 分红方案分红方式
     */
    String DIVIDEND_PLAN_DIV_TYPE = "dividend_plan_div_type";
    //红利转投
    String DIVIDEND_PLAN_DIV_TYPE_0 = "0";
    //现金分红
    String DIVIDEND_PLAN_DIV_TYPE_1 = "1";
    //投资者意愿
    String DIVIDEND_PLAN_DIV_TYPE_2 = "2";

    /**
     * 分红方式
     */
    String ACCOUNT_TRADE_DEF_DIVIDEND_METHOD = "account_trade_def_dividend_method";
    //红利转投
    String ACCOUNT_TRADE_DEF_DIVIDEND_METHOD_0 = "0";
    //现金分红
    String ACCOUNT_TRADE_DEF_DIVIDEND_METHOD_1 = "1";

    /**
     * 开通标志
     */
    String PRD_PERIODIC_RATED_OPEN_FLAG = "prd_periodic_rated_open_flag";
    //不开通
    String PRD_PERIODIC_RATED_OPEN_FLAG_0 = "0";
    //开通
    String PRD_PERIODIC_RATED_OPEN_FLAG_1 = "1";

    /**
     * 申请金额/份额与协议不符处理方式
     */
    String PRD_PERIODIC_RATED_DISAGREE_DEAL_TYPE = "prd_periodic_rated_disagree_deal_type";
    //不限制
    String PRD_PERIODIC_RATED_DISAGREE_DEAL_TYPE_0 = "0";
    //按失败处理
    String PRD_PERIODIC_RATED_DISAGREE_DEAL_TYPE_1 = "1";

    /**
     * 超额申购后定期定额申购按比例确认
     */
    String EXCESS_SUBSCRIBE_RATIO_CFM_TYPE = "excess_subscribe_ratio_cfm_type";
    //100%确认
    String EXCESS_SUBSCRIBE_RATIO_CFM_TYPE_0 = "0";
    //按比例确认
    String EXCESS_SUBSCRIBE_RATIO_CFM_TYPE_1 = "1";

    /**
     * 定期定额采用不同的费率
     */
    String PRD_PERIODIC_RATED_RATE_TYPE = "prd_periodic_rated_rate_type";
    //与申购/赎回相同
    String PRD_PERIODIC_RATED_RATE_TYPE_0 = "0";
    //采用不同费率
    String PRD_PERIODIC_RATED_RATE_TYPE_1 = "1";

    /**
     * 违约赎回标志
     */
    String ALLOW_BREACH_REDEMPT = "allow_breach_redempt";
    //0-不允许
    String ALLOW_BREACH_REDEMPT_0 = "0";
    //1-允许
    String ALLOW_BREACH_REDEMPT_1 = "1";

    /**
     * 邮件发送状态
     */
    String MAIL_SEND_STATUS = "mail_send_status";
    //待发送
    String MAIL_SEND_STATUS_0 = "0";
    //发送成功
    String MAIL_SEND_STATUS_1 = "1";
    //发送失败
    String MAIL_SEND_STATUS_2 = "2";

    /**
     * 特殊份额标志
     */
    String SPECIAL_SHARE_FLAG = "special_share_flag";
    //普通份额
    String SPECIAL_SHARE_FLAG_0 = "0";
    //封转开份额
    String SPECIAL_SHARE_FLAG_1 = "1";

    /**
     * 份额来源
     */
    String SOURCE_SHARE = "source_share";
    //全部
    String SOURCE_SHARE_0 = "0";
    //认购所得
    String SOURCE_SHARE_1 = "1";
    //申购所得
    String SOURCE_SHARE_2 = "2";
    //分红所得
    String SOURCE_SHARE_3 = "3";
    //转换所得
    String SOURCE_SHARE_4 = "4";
    //非交易过户所得
    String SOURCE_SHARE_5 = "5";
    //转托管所得
    String SOURCE_SHARE_6 = "6";
    //份额调整所得
    String SOURCE_SHARE_7 = "7";

    /**
     * 源份额来源
     */
    String ORIGIN_SOURCE_SHARE = "origin_source_share";
    //全部
    String ORIGIN_SOURCE_SHARE_0 = "0";
    //认购所得
    String ORIGIN_SOURCE_SHARE_1 = "1";
    //申购所得
    String ORIGIN_SOURCE_SHARE_2 = "2";
    //分红所得
    String ORIGIN_SOURCE_SHARE_3 = "3";

    /**
     * 限制的条件
     */
    String CONDITION_LIMIT = "condition_limit";
    //份额确认日
    String CONDITION_LIMIT_0 = "0";
    //份额注册日期
    String CONDITION_LIMIT_1 = "1";

    /**
     * TA发起类业务
     */
    String INITIATE_BY_TA = "initiate_by_ta";
    //认购结果
    String INITIATE_BY_TA_130 = "130";
    //强行调增
    String INITIATE_BY_TA_144 = "144";
    //强行调减
    String INITIATE_BY_TA_145 = "145";
    //募集失败
    String INITIATE_BY_TA_149 = "149";
    //基金清盘
    String INITIATE_BY_TA_150 = "150";
    //基金终止
    String INITIATE_BY_TA_151 = "151";
    //强行赎回
    String INITIATE_BY_TA_142 = "142";
    //红利发放
    String INITIATE_BY_TA_143 = "143";
    //配号
    String INITIATE_BY_TA_146 = "146";
    //基金销售人资金清算
    String INITIATE_BY_TA_155 = "155";
    //积分确认
    String INITIATE_BY_TA_169 = "169";

    /**
     * 账户类申请业务
     */
    String ACCOUNT_APPLY_BUSINESS_TYPE = "account_apply_business_type";
    //开户申请
    String ACCOUNT_APPLY_BUSINESS_TYPE_001 = "001";
    //销户申请
    String ACCOUNT_APPLY_BUSINESS_TYPE_002 = "002";
    //账户信息修改申请
    String ACCOUNT_APPLY_BUSINESS_TYPE_003 = "003";
    //增加交易账户申请
    String ACCOUNT_APPLY_BUSINESS_TYPE_008 = "008";
    //变更交易账号申请
    String ACCOUNT_APPLY_BUSINESS_TYPE_058 = "058";
    //撤销交易账号申请
    String ACCOUNT_APPLY_BUSINESS_TYPE_009 = "009";
    //基金账户冻结申请
    String ACCOUNT_APPLY_BUSINESS_TYPE_004 = "004";
    //基金账户解冻申请
    String ACCOUNT_APPLY_BUSINESS_TYPE_005 = "005";
    //基金账户卡解挂申请
    String ACCOUNT_APPLY_BUSINESS_TYPE_007 = "007";
    //基金账户卡挂失申请
    String ACCOUNT_APPLY_BUSINESS_TYPE_006 = "006";

    /**
     * 账户类确认业务
     */
    String ACCOUNT_CONFIRM_BUSINESS_TYPE = "account_confirm_business_type";
    //开户确认
    String ACCOUNT_CONFIRM_BUSINESS_TYPE_101 = "101";
    //销户确认
    String ACCOUNT_CONFIRM_BUSINESS_TYPE_102 = "102";
    //账户信息修改确认
    String ACCOUNT_CONFIRM_BUSINESS_TYPE_103 = "103";
    //增加交易账户确认
    String ACCOUNT_CONFIRM_BUSINESS_TYPE_108 = "108";
    //变更交易账号确认
    String ACCOUNT_CONFIRM_BUSINESS_TYPE_158 = "158";
    //撤销交易账户确认
    String ACCOUNT_CONFIRM_BUSINESS_TYPE_109 = "109";
    //基金账户冻结确认
    String ACCOUNT_CONFIRM_BUSINESS_TYPE_104 = "104";
    //基金账户解冻确认
    String ACCOUNT_CONFIRM_BUSINESS_TYPE_105 = "105";
    //基金账户卡解挂确认
    String ACCOUNT_CONFIRM_BUSINESS_TYPE_107 = "107";
    //基金账户卡挂失确认
    String ACCOUNT_CONFIRM_BUSINESS_TYPE_106 = "106";

    /**
     * 申请类业务
     */
    String APPLY_BUSINESS_TYPE = "apply_business_type";
    //开户申请
    String APPLY_BUSINESS_TYPE_001 = "001";
    //销户申请
    String APPLY_BUSINESS_TYPE_002 = "002";
    //账户信息修改申请
    String APPLY_BUSINESS_TYPE_003 = "003";
    //增加交易账户申请
    String APPLY_BUSINESS_TYPE_008 = "008";
    //变更交易账号申请
    String APPLY_BUSINESS_TYPE_058 = "058";
    //撤销交易账号申请
    String APPLY_BUSINESS_TYPE_009 = "009";
    //基金账户冻结申请
    String APPLY_BUSINESS_TYPE_004 = "004";
    //基金账户解冻申请
    String APPLY_BUSINESS_TYPE_005 = "005";
    //基金账户卡解挂申请
    String APPLY_BUSINESS_TYPE_007 = "007";
    //基金账户卡挂失申请
    String APPLY_BUSINESS_TYPE_006 = "006";
    //认购申请
    String APPLY_BUSINESS_TYPE_020 = "020";
    //申购申请
    String APPLY_BUSINESS_TYPE_022 = "022";
    //定时定额申购申请
    String APPLY_BUSINESS_TYPE_039 = "039";
    //赎回申请
    String APPLY_BUSINESS_TYPE_024 = "024";
    //预约赎回申请
    String APPLY_BUSINESS_TYPE_025 = "025";
    //定时定额赎回申请
    String APPLY_BUSINESS_TYPE_063 = "063";
    //转销售人/机构申请
    String APPLY_BUSINESS_TYPE_026 = "026";
    //转销售人/机构转入申请
    String APPLY_BUSINESS_TYPE_027 = "027";
    //转销售人/机构转出申请
    String APPLY_BUSINESS_TYPE_028 = "028";
    //设置自动再投资申请
    String APPLY_BUSINESS_TYPE_029 = "029";
    //基金份额冻结申请
    String APPLY_BUSINESS_TYPE_031 = "031";
    //基金份额解冻申请
    String APPLY_BUSINESS_TYPE_032 = "032";
    //基金转换申请
    String APPLY_BUSINESS_TYPE_036 = "036";
    //基金转换转入申请
    String APPLY_BUSINESS_TYPE_037 = "037";
    //基金转换转出申请
    String APPLY_BUSINESS_TYPE_038 = "038";
    //撤预约单
    String APPLY_BUSINESS_TYPE_053 = "053";
    //定时定额申购开通申请
    String APPLY_BUSINESS_TYPE_059 = "059";
    //定时定额申购撤销申请
    String APPLY_BUSINESS_TYPE_060 = "060";
    //定时定额变更申请
    String APPLY_BUSINESS_TYPE_061 = "061";
    //认购调整申请
    String APPLY_BUSINESS_TYPE_062 = "062";
    //基金质押申请
    String APPLY_BUSINESS_TYPE_088 = "088";
    //快速过户申请
    String APPLY_BUSINESS_TYPE_098 = "098";

    /**
     * 确认类业务
     */
    String CONFIRM_BUSINESS_TYPE = "confirm_business_type";
    //开户确认
    String CONFIRM_BUSINESS_TYPE_101 = "101";
    //销户确认
    String CONFIRM_BUSINESS_TYPE_102 = "102";
    //账户信息修改确认
    String CONFIRM_BUSINESS_TYPE_103 = "103";
    //增加交易账户确认
    String CONFIRM_BUSINESS_TYPE_108 = "108";
    //变更交易账号确认
    String CONFIRM_BUSINESS_TYPE_158 = "158";
    //撤销交易账户确认
    String CONFIRM_BUSINESS_TYPE_109 = "109";
    //基金账户冻结确认
    String CONFIRM_BUSINESS_TYPE_104 = "104";
    //基金账户解冻确认
    String CONFIRM_BUSINESS_TYPE_105 = "105";
    //基金账户卡解挂确认
    String CONFIRM_BUSINESS_TYPE_107 = "107";
    //基金账户卡挂失确认
    String CONFIRM_BUSINESS_TYPE_106 = "106";
    //认购确认
    String CONFIRM_BUSINESS_TYPE_120 = "120";
    //申购确认
    String CONFIRM_BUSINESS_TYPE_122 = "122";
    //定时定额申购确认
    String CONFIRM_BUSINESS_TYPE_139 = "139";
    //赎回确认
    String CONFIRM_BUSINESS_TYPE_124 = "124";
    //强行赎回确认
    String CONFIRM_BUSINESS_TYPE_142 = "142";
    //定时定额赎回确认
    String CONFIRM_BUSINESS_TYPE_163 = "163";
    //预约赎回确认/机构申请
    String CONFIRM_BUSINESS_TYPE_125 = "125";
    //转销售人/机构确认/机构转入申请
    String CONFIRM_BUSINESS_TYPE_126 = "126";
    //转销售人/机构转入确认/机构转出申请
    String CONFIRM_BUSINESS_TYPE_127 = "127";
    //转销售人/机构转出确认
    String CONFIRM_BUSINESS_TYPE_128 = "128";
    //设置自动再投资确认
    String CONFIRM_BUSINESS_TYPE_129 = "129";
    //认购结果
    String CONFIRM_BUSINESS_TYPE_130 = "130";
    //基金份额冻结确认
    String CONFIRM_BUSINESS_TYPE_131 = "131";
    //基金份额解冻确认
    String CONFIRM_BUSINESS_TYPE_132 = "132";
    //基金红利解冻确认
    String CONFIRM_BUSINESS_TYPE_157 = "157";
    //非交易过户转入确认
    String CONFIRM_BUSINESS_TYPE_134 = "134";
    //非交易过户转出确认
    String CONFIRM_BUSINESS_TYPE_135 = "135";
    //基金转换转入确认
    String CONFIRM_BUSINESS_TYPE_137 = "137";
    //基金转换转出确认
    String CONFIRM_BUSINESS_TYPE_138 = "138";
    //撤预约单确认
    String CONFIRM_BUSINESS_TYPE_153 = "153";
    //强行调增
    String CONFIRM_BUSINESS_TYPE_144 = "144";
    //强行调减
    String CONFIRM_BUSINESS_TYPE_145 = "145";
    //认购调整确认
    String CONFIRM_BUSINESS_TYPE_162 = "162";
    //定时定额申购开通确认
    String CONFIRM_BUSINESS_TYPE_159 = "159";
    //定时定额申购撤销确认
    String CONFIRM_BUSINESS_TYPE_160 = "160";
    //定时定额变更确认
    String CONFIRM_BUSINESS_TYPE_161 = "161";
    //基金质押确认
    String CONFIRM_BUSINESS_TYPE_188 = "188";
    //快速过户确认
    String CONFIRM_BUSINESS_TYPE_198 = "198";
    //募集失败
    String CONFIRM_BUSINESS_TYPE_149 = "149";
    //基金清盘
    String CONFIRM_BUSINESS_TYPE_150 = "150";
    //基金终止
    String CONFIRM_BUSINESS_TYPE_151 = "151";

    /**
     * TA总业务
     */
    String TA_TOTAL_BUSINESS_TYPE = "ta_total_business_type";
    //开户申请
    String TA_TOTAL_BUSINESS_TYPE_001 = "001";
    //销户申请
    String TA_TOTAL_BUSINESS_TYPE_002 = "002";
    //账户信息修改申请
    String TA_TOTAL_BUSINESS_TYPE_003 = "003";
    //增加交易账户申请
    String TA_TOTAL_BUSINESS_TYPE_008 = "008";
    //变更交易账号申请
    String TA_TOTAL_BUSINESS_TYPE_058 = "058";
    //撤销交易账号申请
    String TA_TOTAL_BUSINESS_TYPE_009 = "009";
    //基金账户冻结申请
    String TA_TOTAL_BUSINESS_TYPE_004 = "004";
    //基金账户解冻申请
    String TA_TOTAL_BUSINESS_TYPE_005 = "005";
    //基金账户卡解挂申请
    String TA_TOTAL_BUSINESS_TYPE_007 = "007";
    //基金账户卡挂失申请
    String TA_TOTAL_BUSINESS_TYPE_006 = "006";
    //认购申请
    String TA_TOTAL_BUSINESS_TYPE_020 = "020";
    //申购申请
    String TA_TOTAL_BUSINESS_TYPE_022 = "022";
    //定时定额申购申请
    String TA_TOTAL_BUSINESS_TYPE_039 = "039";
    //赎回申请
    String TA_TOTAL_BUSINESS_TYPE_024 = "024";
    //预约赎回申请
    String TA_TOTAL_BUSINESS_TYPE_025 = "025";
    //定时定额赎回申请
    String TA_TOTAL_BUSINESS_TYPE_063 = "063";
    //转销售人/机构申请/机构申请
    String TA_TOTAL_BUSINESS_TYPE_026 = "026";
    //转销售人/机构转入申请/机构确认/机构转入申请
    String TA_TOTAL_BUSINESS_TYPE_027 = "027";
    //转销售人/机构转出申请/机构转入确认/机构转出申请
    String TA_TOTAL_BUSINESS_TYPE_028 = "028";
    //设置自动再投资申请/机构转出确认
    String TA_TOTAL_BUSINESS_TYPE_029 = "029";
    //基金份额冻结申请
    String TA_TOTAL_BUSINESS_TYPE_031 = "031";
    //基金份额解冻申请
    String TA_TOTAL_BUSINESS_TYPE_032 = "032";
    //基金转换申请
    String TA_TOTAL_BUSINESS_TYPE_036 = "036";
    //基金转换转入申请
    String TA_TOTAL_BUSINESS_TYPE_037 = "037";
    //基金转换转出申请
    String TA_TOTAL_BUSINESS_TYPE_038 = "038";
    //撤预约单
    String TA_TOTAL_BUSINESS_TYPE_053 = "053";
    //定时定额申购开通申请
    String TA_TOTAL_BUSINESS_TYPE_059 = "059";
    //定时定额申购撤销申请
    String TA_TOTAL_BUSINESS_TYPE_060 = "060";
    //定时定额变更申请
    String TA_TOTAL_BUSINESS_TYPE_061 = "061";
    //认购调整申请
    String TA_TOTAL_BUSINESS_TYPE_062 = "062";
    //基金质押申请
    String TA_TOTAL_BUSINESS_TYPE_088 = "088";
    //快速过户申请
    String TA_TOTAL_BUSINESS_TYPE_098 = "098";
    //开户确认
    String TA_TOTAL_BUSINESS_TYPE_101 = "101";
    //销户确认
    String TA_TOTAL_BUSINESS_TYPE_102 = "102";
    //账户信息修改确认
    String TA_TOTAL_BUSINESS_TYPE_103 = "103";
    //增加交易账户确认
    String TA_TOTAL_BUSINESS_TYPE_108 = "108";
    //变更交易账号确认
    String TA_TOTAL_BUSINESS_TYPE_158 = "158";
    //撤销交易账户确认
    String TA_TOTAL_BUSINESS_TYPE_109 = "109";
    //基金账户冻结确认
    String TA_TOTAL_BUSINESS_TYPE_104 = "104";
    //基金账户解冻确认
    String TA_TOTAL_BUSINESS_TYPE_105 = "105";
    //基金账户卡解挂确认
    String TA_TOTAL_BUSINESS_TYPE_107 = "107";

    /**
     * 交易类申请业务
     */
    String TRANSACTION_APPLY_BUSINESS_TYPE = "transaction_apply_business_type";
    //认购申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_020 = "020";
    //申购申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_022 = "022";
    //定时定额申购申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_039 = "039";
    //赎回申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_024 = "024";
    //预约赎回申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_025 = "025";
    //定时定额赎回申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_063 = "063";
    //转销售人/机构申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_026 = "026";
    //转销售人/机构转入申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_027 = "027";
    //转销售人/机构转出申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_028 = "028";
    //设置自动再投资申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_029 = "029";
    //基金份额冻结申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_031 = "031";
    //基金份额解冻申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_032 = "032";
    //基金转换申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_036 = "036";
    //基金转换转入申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_037 = "037";
    //基金转换转出申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_038 = "038";
     //044-份额强增-申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_044 = "044";
    //045-份额强减-申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_045 = "045";
    //撤预约单
    String TRANSACTION_APPLY_BUSINESS_TYPE_053 = "053";
    //定时定额申购开通申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_059 = "059";
    //定时定额申购撤销申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_060 = "060";
    //定时定额变更申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_061 = "061";
    //认购调整申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_062 = "062";
    //基金质押申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_088 = "088";
    //快速过户申请
    String TRANSACTION_APPLY_BUSINESS_TYPE_098 = "098";


    /**
     * 交易类确认业务
     */
    String TRANSACTION_CONFIRM_BUSINESS_TYPE = "transaction_confirm_business_type";
    //认购确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_120 = "120";
    //申购确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_122 = "122";
    //定时定额申购确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_139 = "139";
    //赎回确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_124 = "124";
    //强行赎回确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_142 = "142";
    //定时定额赎回确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_163 = "163";
    //预约赎回确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_125 = "125";
    //转销售人/机构确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_126 = "126";
    //转销售人/机构转入确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_127 = "127";
    //转销售人/机构转出确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_128 = "128";
    //设置自动再投资确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_129 = "129";
    //认购结果
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_130 = "130";
    //基金份额冻结确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_131 = "131";
    //基金份额解冻确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_132 = "132";
    //基金红利解冻确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_157 = "157";
    //非交易过户转入确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_134 = "134";
    //非交易过户转出确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_135 = "135";
    //基金转换转入确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_137 = "137";
    //基金转换转出确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_138 = "138";
    //撤预约单确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_153 = "153";
    //强行调增
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_144 = "144";
    //强行调减
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_145 = "145";
    //认购调整确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_162 = "162";
    //定时定额申购开通确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_159 = "159";
    //定时定额申购撤销确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_160 = "160";
    //定时定额变更确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_161 = "161";
    //基金质押确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_188 = "188";
    //快速过户确认
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_198 = "198";
    //募集失败
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_149 = "149";
    //基金清盘
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_150 = "150";
    //基金终止
    String TRANSACTION_CONFIRM_BUSINESS_TYPE_151 = "151";

    /**
     * 基金业务类型
     */
    String PRD_BUSINESS_TYPE = "prd_business_type";
    //认购
    String PRD_BUSINESS_TYPE_020 = "020";
    //申购
    String PRD_BUSINESS_TYPE_022 = "022";
    //赎回
    String PRD_BUSINESS_TYPE_024 = "024";
    //预约赎回
    String PRD_BUSINESS_TYPE_025 = "025";
    //转托管
    String PRD_BUSINESS_TYPE_026 = "026";
    //托管转入
    String PRD_BUSINESS_TYPE_027 = "027";
    //托管转出
    String PRD_BUSINESS_TYPE_028 = "028";
    //修改分红方式
    String PRD_BUSINESS_TYPE_029 = "029";
    //份额冻结
    String PRD_BUSINESS_TYPE_031 = "031";
    //份额解冻
    String PRD_BUSINESS_TYPE_032 = "032";
    //非交易过户
    String PRD_BUSINESS_TYPE_033 = "033";
    //非交易过户出
    String PRD_BUSINESS_TYPE_035 = "035";
    //基金转换
    String PRD_BUSINESS_TYPE_036 = "036";
    //基金转换出
    String PRD_BUSINESS_TYPE_038 = "038";
    //定期定额申购
    String PRD_BUSINESS_TYPE_039 = "039";
    //份额强增
    String PRD_BUSINESS_TYPE_044 = "044";
    //份额强减
    String PRD_BUSINESS_TYPE_045 = "045";
    //撤单
    String PRD_BUSINESS_TYPE_052 = "052";
    //撤预约单
    String PRD_BUSINESS_TYPE_053 = "053";
    //定期申购注册
    String PRD_BUSINESS_TYPE_059 = "059";
    //定期申购注销
    String PRD_BUSINESS_TYPE_060 = "060";
    //定期申购修改
    String PRD_BUSINESS_TYPE_061 = "061";
    //定期定额赎回
    String PRD_BUSINESS_TYPE_063 = "063";
    //联名卡查询
    String PRD_BUSINESS_TYPE_066 = "066";
    //联名卡开通
    String PRD_BUSINESS_TYPE_067 = "067";
    //联名卡取消
    String PRD_BUSINESS_TYPE_068 = "068";
    //联名卡还款
    String PRD_BUSINESS_TYPE_069 = "069";
    //定期赎回修改
    String PRD_BUSINESS_TYPE_078 = "078";
    //质押转移
    String PRD_BUSINESS_TYPE_088 = "088";
    //定期赎回注册
    String PRD_BUSINESS_TYPE_091 = "091";
    //承诺优惠协议
    String PRD_BUSINESS_TYPE_092 = "092";
    //特殊小额申购
    String PRD_BUSINESS_TYPE_093 = "093";
    //定期赎回注销
    String PRD_BUSINESS_TYPE_094 = "094";
    //内部转托管
    String PRD_BUSINESS_TYPE_097 = "097";
    //快速过户
    String PRD_BUSINESS_TYPE_098 = "098";

    /**
     * 末日比例配售确认方式
     */
    String LAST_DAY_PROPORTIONAL_PLACING_TYPE = "last_day_proportional_placing_type";
    //认购确认时比例确认
    String LAST_DAY_PROPORTIONAL_PLACING_TYPE_0 = "0";
    //基金成立时比例确认
    String LAST_DAY_PROPORTIONAL_PLACING_TYPE_1 = "1";

    /**
     * 超限确认方式
     */
    String TRANSFINITE_CONFIRM_TYPE = "transfinite_confirm_type";
    //确认失败
    String TRANSFINITE_CONFIRM_TYPE_0 = "0";
    //部分确认
    String TRANSFINITE_CONFIRM_TYPE_1 = "1";

    /**
     * 首次投资是否需包含费用
     */
    String INITIAL_INCLUDE_FEE_TYPE = "initial_include_fee_type";

    /**
     * 追加投资是否需包含费用
     */
    String APPEND_INCLUDE_FEE_TYPE = "append_include_fee_type";

    /**
     * 投资者户数处理方式
     */
    String ACCOUNT_MAX_TREATMENT = "account_max_treatment";
    //按申请金额/申请时间/基金账号
    String ACCOUNT_MAX_TREATMENT_0 = "0";
    //按申请时间/申请金额/基金账号
    String ACCOUNT_MAX_TREATMENT_1 = "1";
    //按申请金额/申请时间/申请单号
    String ACCOUNT_MAX_TREATMENT_2 = "2";
    //按申请时间/申请金额/申请单号
    String ACCOUNT_MAX_TREATMENT_3 = "3";
    //按申请时间/申请单号/申请金额
    String ACCOUNT_MAX_TREATMENT_4 = "4";

    /**
     * 是否分销售商控制最大账户数
     */
    String ORG_CONTROL_MAX_ACCOUNT_TYPE = "org_control_max_account_type";

    /**
     * 户数限制中直销优先
     */
    String ACCOUNT_LIMIT_ORG_TYPE = "account_limit_org_type";

    /**
     * 专户不受户数限制判断方式
     */
    String SPECIAL_ACCOUNT_NUM_LIMIT_TYPE = "special_account_num_limit_type";
    //按笔
    String SPECIAL_ACCOUNT_NUM_LIMIT_TYPE_0 = "0";
    //按累计
    String SPECIAL_ACCOUNT_NUM_LIMIT_TYPE_1 = "1";
    //不控制
    String SPECIAL_ACCOUNT_NUM_LIMIT_TYPE_2 = "2";

    /**
     * 专户不受户数限制金额
     */
    String SPECIAL_ACCOUNT_NUM_LIMIT_CASH_TYPE = "special_account_num_limit_cash_type";
    //3000000
    String SPECIAL_ACCOUNT_NUM_LIMIT_CASH_TYPE_0 = "0";

    /**
     * 大额限制处理方式
     */
    String HIGH_CASH_LIMIT_TYPE = "high_cash_limit_type";
    //单笔超限确认失败
    String HIGH_CASH_LIMIT_TYPE_1 = "1";
    //当天累计超限都失败
    String HIGH_CASH_LIMIT_TYPE_2 = "2";
    //按金额由大到小，超额部分失败
    String HIGH_CASH_LIMIT_TYPE_3 = "3";
    //按申请时间先后，超额部分失败
    String HIGH_CASH_LIMIT_TYPE_4 = "4";

    /**
     * 大额限制业务适用范围
     */
    String BUSINESS_LIMIT_RANGE_TYPE = "business_limit_range_type";
    //申购
    String BUSINESS_LIMIT_RANGE_TYPE_1 = "1";
    //基金转换
    String BUSINESS_LIMIT_RANGE_TYPE_2 = "2";
    //定期定额申购
    String BUSINESS_LIMIT_RANGE_TYPE_3 = "3";

    /**
     * 最高持有处理方式
     */
    String HIGH_HOLD_TREATMENT_TYPE = "high_hold_treatment_type";
    //按金额由大到小
    String HIGH_HOLD_TREATMENT_TYPE_0 = "0";
    //按申请时间先后
    String HIGH_HOLD_TREATMENT_TYPE_1 = "1";

    /**
     * 最高持有判断方式
     */
    String HIGH_HOLD_JUDGMENT_TYPE = "high_hold_judgment_type";
    //最高金额
    String HIGH_HOLD_JUDGMENT_TYPE_0 = "0";
    //最高比例
    String HIGH_HOLD_JUDGMENT_TYPE_1 = "1";

    /**
     * 级差判断模式
     */
    String GRADE_JUDGMENT_TYPE = "grade_judgment_type";
    //扣费前判断级差
    String GRADE_JUDGMENT_TYPE_0 = "0";
    //扣费后判断级差
    String GRADE_JUDGMENT_TYPE_1 = "1";

    /**
     * 级差处理方式
     */
    String GRADE_TREATMENT_TYPE = "grade_treatment_type";
    //人工干预
    String GRADE_TREATMENT_TYPE_0 = "0";
    //确认失败
    String GRADE_TREATMENT_TYPE_1 = "1";
    //确认整数倍金额
    String GRADE_TREATMENT_TYPE_2 = "2";

    /**
     * 归基金资产比例设置的业务类型
     */
    String PRD_ASSET_RATE_BIZ_TYPE = "prd_asset_rate_biz_type";
    // 全部
    String PRD_ASSET_RATE_BIZ_TYPE_ALL = "all";
    // 03-赎回
    String PRD_ASSET_RATE_BIZ_TYPE_REDEMPTION = "03";
    // 13-基金转换
    String PRD_ASSET_RATE_BIZ_TYPE_SWITCH = "13";

    /**
     * 养老金账户标识
     */
    String PENSION_ACC_FLAG = "pension_acc_flag";

    /**
     * 利率类型
     */
    String RATE_TYPE = "rate_type";
    //自定义
    String RATE_TYPE_ALL = "*";
    //活期
    String RATE_TYPE_0 = "0";
    //一个月定期利率
    String RATE_TYPE_1 = "1";
    //三个月定期利率
    String RATE_TYPE_2 = "2";
    //半年定期利率
    String RATE_TYPE_3 = "3";
    //一年定期利率
    String RATE_TYPE_4 = "4";
    //二年定期利率
    String RATE_TYPE_5 = "5";
    //三年定期利率
    String RATE_TYPE_6 = "6";
    //五年定期利率
    String RATE_TYPE_7 = "7";
    //3年期定存税后收益率
    String RATE_TYPE_A = "A";

    /**
     * 公告未发送状态
     **/
    String SEND_FLAG_NO = "0";
    /**
     * 公告已发送状态
     **/
    String SEND_FLAG_YES = "1";

    /* 状态常量 */
    //草稿
    String DRAFT = "0";
    //待复核
    String UNCHECK = "1";
    //正式
    String CHECKED = "2";

    /**
     * 是否支持养老金固定费用
     */
    String SUPPORT_FIXED_EXPENSES = "support_fixed_expenses";

    /**
     * 是否支持账号预分配    【0-否、1-是】，默认【1-是】
     */
    String SUPPORT_SNO_FUND_ACCT = "support_sno_fund_acct";

    /**
     * 账户登记是否修改客户资料    【0-否、1-是】，默认【1-是】
     */
    String MDF_CUST_INFO_OPEN_ACCT = "mdf_cust_info_open_acct";

    /**
     * 小份额强赎处理方式:0-批处理后强制赎回、1-部分按原业务一笔确认、2-全部按原业务一笔确认
     */
    String LITTLE_SHARE_DEAL_WAY = "little_share_deal_way";
    //0-批处理后强制赎回
    String LITTLE_SHARE_DEAL_WAY_0 = "0";
    //1-部分按原业务一笔确认
    String LITTLE_SHARE_DEAL_WAY_1 = "1";
    //2-全部按原业务一笔确认
    String LITTLE_SHARE_DEAL_WAY_2 = "2";

    /**
     * 销户时检查交易账户是否登记:0-否、1-是
     */
    String CHECK_TRADE_ACCT_CANCEL_ACCT = "check_trade_acct_cancel_acct";

    /**
     * 赎回转换确认可用份额不足处理方式:1-确认失败、2-部分确认
     */
    String REDEEM_CFM_INSUFFICIENT_WAY = "redeem_cfm_insufficient_way";
    //1-确认失败
    String REDEEM_CFM_INSUFFICIENT_WAY_1 = "1";
    //2-部分确认
    String REDEEM_CFM_INSUFFICIENT_WAY_2 = "2";

    /**
     * 赎回转换确认可用份额不足处理方式:0-确认失败、1-部分确认
     */
    String REDEEM_CHANGE_CFM_INSUFFICIENT_WAY = "redeem_change_cfm_insufficient_way";
    //1-确认失败
    String REDEEM_CHANGE_CFM_INSUFFICIENT_WAY_0 = "0";
    //2-部分确认
    String REDEEM_CHANGE_CFM_INSUFFICIENT_WAY_1 = "1";

    /**
     * 是否导出节假日行情:0-否、1-是
     */
    String EXP_HOLIDAY_MARKET = "exp_holiday_market";

    /**
     * 导出发行失败或终止产品:0-否、1-是
     */
    String EXP_TERMINATE_PRD = "exp_terminate_prd";

    /**
     * 费用方式:0-按TA计算费用、1-指定费率、2-指定费用
     */
    String FEE_WAY = "fee_way";
    // 0-按TA计算费用
    String FEE_WAY_0 = "0";
    //1-指定费率
    String FEE_WAY_1 = "1";
    //2-指定费用
    String FEE_WAY_2 = "2";

    /**
     * 认申购固定费用是否打折:0-否，1-是
     */
    String DISCOUNT_SUB_PUR_FEE = "discount_sub_pur_fee";

    /**
     * 最低费率限制的客户类型:0-确认失败，1-部分确认
     */
    String LIMIT_CUST_TYPE_MIN_FEE = "limit_cust_type_min_fee";
    //0-确认失败
    String LIMIT_CUST_TYPE_MIN_FEE_0 = "0";
    //1-部分确认
    String LIMIT_CUST_TYPE_MIN_FEE_1 = "1";

    /**
     * 认购成功人工否决立即下发确认   0-否，1-是
     */
    String CMF_IMMEDIATE_SUB_VETO = "cmf_immediate_sub_veto";

    /**
     * 方案类型
     */
    String TRAIL_COMMISSION_SCHEME_TYPE = "trail_commission_scheme_type";
    // 0-保有金额
    String TRAIL_COMMISSION_SCHEME_TYPE_HOLD_AMOUNT = "0";
    // 1-保有份额
    String TRAIL_COMMISSION_SCHEME_TYPE_HOLD_SHARE = "1";
    // 2-保有比例
    String TRAIL_COMMISSION_SCHEME_TYPE_HOLD_RATIO = "2";

    /**
     * 尾随佣金计算方式
     */
    String CALC_SCHEME_TYPE = "trail_commission_calc_scheme_type";
    // 0-按当前市值包含再投资;
    String CALC_SCHEME_TYPE_MARKET_INCLUDES_REINVESTMENT = "0";
    // 1-按当前市值不包含再投资;
    String CALC_SCHEME_TYPE_MARKET_NOT_INCLUDES_REINVESTMENT = "1";
    // 2-按成本包含再投资;
    String CALC_SCHEME_TYPE_COST_INCLUDES_REINVESTMENT = "2";
    // 3-按成本不包含再投资
    String CALC_SCHEME_TYPE_COST_NOT_INCLUDES_REINVESTMENT = "3";

    /**
     * 是否累进计算
     */
    String PROGRESSIVE_CALC_TYPE = "trail_commission_progressive_calc_type";

    /**
     * 通用的是否标志字典项
     */
    String COMMON_YES_NO_FLAG = "common_yes_no_flag";

    /**
     * '业绩提成方式
     */
    String ACHIEVEMENT_PAY_TYPE = "achievement_pay_type";
    // 0-赎回业绩提成
    String ACHIEVEMENT_PAY_TYPE_0 = "0";
    // 1-统一业绩提成
    String ACHIEVEMENT_PAY_TYPE_1 = "1";
    // 2-分红业绩提成
    String ACHIEVEMENT_PAY_TYPE_2 = "2";
    // 3-清盘业绩提成
    String ACHIEVEMENT_PAY_TYPE_3 = "3";

    /**
     * '业绩提成算法
     */
    String ACHIEVEMENT_PAY_ALGO = "achievement_pay_algo";
    // 1-根据持有期累计净值变化计算收益率
    String ACHIEVEMENT_PAY_ALGO_1 = "1";
    // 2-默认算法基础上以银行利率为动态基准
    String ACHIEVEMENT_PAY_ALGO_2 = "2";
    // 3-区分认申购份额，并考虑分红是否回本
    String ACHIEVEMENT_PAY_ALGO_3 = "3";
    // 4-超过年化收益率比较基准按比例计提
    String ACHIEVEMENT_PAY_ALGO_4 = "4";

    /**
     * '自营账户份额赎回处理方式
     */
    String ACCOUNT_SHARE_RED_DEAL_WAY = "account_share_red_deal_way";
    // 0-不赎回
    String ACCOUNT_SHARE_RED_DEAL_WAY_0 = "0";
    // 1-全部赎回
    String ACCOUNT_SHARE_RED_DEAL_WAY_1 = "1";
    // 2-赎回业绩提成强增的份额
    String ACCOUNT_SHARE_RED_DEAL_WAY_2 = "2";

    /**
     * '是否返还手续费
     */
    String RETURN_FEE_FLAG = "return_fee_flag";
    // 0-不返还
    String RETURN_FEE_FLAG_0 = "0";
    // 1-返还
    String RETURN_FEE_FLAG_1 = "1";

    /**
     * '年天数标准
     */
    String YEAR_DAY_STANDARD = "year_day_standard";
    // 0-当年实际天数
    String YEAR_DAY_STANDARD_0 = "0";
    // 1-固定365天
    String YEAR_DAY_STANDARD_1 = "1";
    // 2-固定360天
    String YEAR_DAY_STANDARD_2 = "2";
    // 2-固定366天
    String YEAR_DAY_STANDARD_3 = "3";

    /**
     * '持有天数计算标准
     */
    String HOLD_DAY_ALGO_STANDARD = "hold_day_algo_standard";
    // 0-按确认日期计算
    String HOLD_DAY_ALGO_STANDARD_0 = "0";
    // 1-按申请日期计算
    String HOLD_DAY_ALGO_STANDARD_1 = "1";

    /**
     * '收益率标准'
     */
    String YIELD_STANDARD = "yield_standard";
    // 0-实际收益率
    String YIELD_STANDARD_0 = "0";
    // 1-年化收益率
    String YIELD_STANDARD_1 = "1";

    /**
     * '收益率金额区间定义'
     */
    String YIELD_AMT_RANGE = "yield_amt_range";
    // 0-份额明细原确认金额
    String YIELD_AMT_RANGE_0 = "0";
    // 1-份额明细当前市值
    String YIELD_AMT_RANGE_1 = "1";

    /**
     * '收益是否含费'
     */
    String INCOME_COVER_FEE_FLAG = "income_cover_fee_flag";
    // 0-收益计算扣除赎回费用
    String INCOME_COVER_FEE_FLAG_0 = "0";
    // 1-收益计算包含赎回费用
    String INCOME_COVER_FEE_FLAG_1 = "1";

    /**
     * '分红本金是否扣除'
     */
    String DIVIDEND_DEDUCT_FLAG = "dividend_deduct_flag";
    // 0-收益计算扣除赎回费用
    String DIVIDEND_DEDUCT_FLAG_0 = "0";
    // 1-收益计算包含赎回费用
    String DIVIDEND_DEDUCT_FLAG_1 = "1";

    /**
     * '计提日期更新规则'
     */
    String PAY_DATE_UPDATE_RULE = "pay_date_update_rule";
    // 0-始终更新上次业绩计提日期
    String PAY_DATE_UPDATE_RULE_0 = "0";
    // 1-达到业绩提成基准才更新计提日期
    String PAY_DATE_UPDATE_RULE_1 = "1";
    // 1-不更新业绩计提日期
    String PAY_DATE_UPDATE_RULE_2 = "2";

    /**
     * '是否抵扣管理费'
     */
    String MANAGE_FEE_DEDUCT_FLAG = "manage_fee_deduct_flag";
    // 0-不抵扣管理费
    String MANAGE_FEE_DEDUCT_FLAG_0 = "0";
    // 1-抵扣管理费
    String MANAGE_FEE_DEDUCT_FLAG_1 = "1";

    /**
     * '方案处理标志'
     */
    String PLAN_DEAL_FLAG = "plan_deal_flag";
    // 0-未处理
    String PLAN_DEAL_FLAG_0 = "0";
    // 1-已处理
    String PLAN_DEAL_FLAG_1 = "1";
    // 2-已失效
    String PLAN_DEAL_FLAG_2 = "2";
    // 3-处理中
    String PLAN_DEAL_FLAG_3 = "3";

    /**
     * '多区间处理方式'
     */
    String INTERVAL_DEAL_FLAG = "interval_deal_flag";
    // 0-不累退计算业绩报酬
    String INTERVAL_DEAL_FLAG_0 = "0";
    // 1-分段累退计算业绩报酬
    String INTERVAL_DEAL_FLAG_1 = "1";

    /**
     * '业绩提成金额基准'
     */
    String ACHIEVEMENT_AMT_STANDARD = "achievement_amt_standard";
    // 0-按超过基准部分计提
    String ACHIEVEMENT_AMT_STANDARD_0 = "0";
    // 1-按收益部分计提
    String ACHIEVEMENT_AMT_STANDARD_1 = "1";
    // 2-按退出金额计提
    String ACHIEVEMENT_AMT_STANDARD_2 = "2";
    // 3-按超过基准部分和按收益部分取小
    String ACHIEVEMENT_AMT_STANDARD_3 = "3";

    /**
     * '提成金额费用赋值方式'
     */
    String PAY_AMT_FEE_WAY = "pay_amt_fee_way";
    // 0-业绩报酬
    String PAY_AMT_FEE_WAY_0 = "0";
    // 1-交易费用
    String PAY_AMT_FEE_WAY_1 = "1";

    /**
     * '赎回业绩提成计提范围'
     */
    String RED_ACHIEVEMENT_PAY_RANGE = "red_achievement_pay_range";
    // 0-全部赎回有效
    String RED_ACHIEVEMENT_PAY_RANGE_0 = "0";
    // 1-违约赎回有效
    String RED_ACHIEVEMENT_PAY_RANGE_1 = "1";
    // 2-非违约赎回有效
    String RED_ACHIEVEMENT_PAY_RANGE_2 = "2";

    /**
     * '投资者收益情况计提方式'
     */
    String INCOME_PAY_WAY = "income_pay_way";
    // 0-全部赎回有效
    String INCOME_PAY_WAY_0 = "0";
    // 1-违约赎回有效
    String INCOME_PAY_WAY_1 = "1";

    /**
     * '动态基准利率类型'
     */
    String BENCHMARK_RATE_TYPE = "benchmark_rate_type";
    // 0-活期
    String BENCHMARK_RATE_TYPE_0 = "0";
    // 1-一个月定期利率
    String BENCHMARK_RATE_TYPE_1 = "1";
    // 2-三个月定期利率
    String BENCHMARK_RATE_TYPE_2 = "2";
    // 3-半年定期利率
    String BENCHMARK_RATE_TYPE_3 = "3";
    // 4-一年定期利率
    String BENCHMARK_RATE_TYPE_4 = "4";
    // 5-二年定期利率
    String BENCHMARK_RATE_TYPE_5 = "5";
    // 6-三年定期利率
    String BENCHMARK_RATE_TYPE_6 = "6";
    // 7-五年定期利率
    String BENCHMARK_RATE_TYPE_7 = "7";

    /**
     * '年化收益率比较基准'
     */
    String ANNUAL_YIELD_BENCHMARK = "annual_yield_benchmark";
    // 0-固定年化收益率
    String ANNUAL_YIELD_BENCHMARK_0 = "0";
    // 1-按参考指数收益率计算
    String ANNUAL_YIELD_BENCHMARK_1 = "1";

    /**
     * '期初单位（累计）净值基准取值方式'
     */
    String BEGIN_NAV_BENCHMARK_VALUE_WAY = "begin_nav_benchmark_value_way";
    // 0-按上次计提日
    String BEGIN_NAV_BENCHMARK_VALUE_WAY_0 = "0";
    // 1-始终按份额注册日
    String BEGIN_NAV_BENCHMARK_VALUE_WAY_1 = "1";

    /**
     * '收益率起始日期选取规则
     */
    String INCOME_RATE_START_DATE_RULE = "income_rate_start_date_rule";
    // 0-高水位日期
    String INCOME_RATE_START_DATE_RULE_0 = "0";
    // 1-上次计提日期
    String INCOME_RATE_START_DATE_RULE_1 = "1";

    /**
     * '分红收益期末日期选取规则'
     */
    String DIVIDEND_END_DATE_RULE = "dividend_end_date_rule";
    // 0-分红处理日
    String DIVIDEND_END_DATE_RULE_0 = "0";
    // 1-分红登记日
    String DIVIDEND_END_DATE_RULE_1 = "1";
    // 2-指定分红期末截止日期
    String DIVIDEND_END_DATE_RULE_2 = "2";
    // 3-指定期末累计净值
    String DIVIDEND_END_DATE_RULE_3 = "3";

    /**
     * 份额强增强减的申请业务类型(具体业务类型请见TaBizCodeConstants类，044，045)
     *
     * @see BizCodeConst
     */
    String SHARE_ADJUST_BIZ_TYPE = "share_adjust_biz_type";

    /**
     * 巨额赎回顺延方式 
     */
    String LARGE_REDEEM_POSTPONE = "large_redeem_postpone";
    // 顺延至下个工作日
    String LARGE_REDEEM_POSTPONE_SYS_DATE = "0";
    // 顺延至下个开放周期日
    String LARGE_REDEEM_POSTPONE_OPEN_DATE = "1";
    // 顺延到基金状态可赎回日
    String LARGE_REDEEM_POSTPONE_STATE_SHARED = "2";

    /**
     * 赎回确认可用份额不足处理方式
     */
    String REDEEM_SHARE_REMAIN_NOT_ENOUGH = "redeem_share_remain_not_enough";
    // 0-确认失败
    String REDEEM_SHARE_REMAIN_NOT_ENOUGH_FAIL = "1";
    // 1-部分确
    String REDEEM_SHARE_REMAIN_NOT_ENOUGH_PART = "2";

    /**
     * 最低账面金额是否含收益
     */
    String LOWEST_AMT_INCLUDE_INCOME = "lowest_amt_include_income";
    /**
     * 基金拆分方案-----拆分方式
     */
    String SPLIT_TYPE = "split_type";
    //每单位拆分份额
    String SPLIT_TYPE_0 = "0";
    //分配总基金资产
    String SPLIT_TYPE_1 = "1";


    /**
     * 基金拆分方案-----赎回折算方式
     */
    String REDEEM_CONVERT_TYPE = "redeem_convert_type";
    //不折算
    String REDEEM_CONVERT_TYPE_0 = "0";
    //全部按比例确认
    String REDEEM_CONVERT_TYPE_1 = "1";
    //全额赎回时拆分后份额全部赎回
    String REDEEM_CONVERT_TYPE_2 = "2";

    /**
     * 基金拆分方案-----拆分份额方式
     */
    String SPLIT_SHARE_TYPE = "split_share_type";
    //按照明细拆分到原份额明细
    String SPLIT_SHARE_TYPE_0 = "0";
    //按照明细生成拆分份额
    String SPLIT_SHARE_TYPE_1 = "1";
    //按照汇总生成拆分份额
    String SPLIT_SHARE_TYPE_2 = "2";
    //按照汇总拆分到原份额明细
    String SPLIT_SHARE_TYPE_3 = "3";

    /**
     * 最低账面余额判断方式
     */
    String LOWEST_BALANCE_JUDGE_TYPE = "lowest_balance_judge_type";
    // 0-按最低账面金额
    String LOWEST_BALANCE_JUDGE_TYPE_AMT = "0";
    // 1-按最低账面份额
    String LOWEST_BALANCE_JUDGE_TYPE_SHARE = "1";

    /**
     * 赎回后低于最低余额处理方式
     */
    String REDEEM_UNDER_LOWEST_TYPE = "redeem_under_lowest_type";
    // 0-确认失败
    String REDEEM_UNDER_LOWEST_TYPE_FAIL = "0";
    // 1-人工干预
    String REDEEM_UNDER_LOWEST_TYPE_INTERVENT = "1";
    // 2-全部确认
    String REDEEM_UNDER_LOWEST_TYPE_ALL = "2";
    // 3-保留账面最低金额
    String REDEEM_UNDER_LOWEST_TYPE_RETAIN = "3";

    /**
     * 低于最低余额处理方式
     */
    String UNDER_LOWEST_DEAL_TYPE = "under_lowest_type";
    // 0-确认失败
    String UNDER_LOWEST_DEAL_TYPE_FAIL = "0";
    // 1-人工干预
    String UNDER_LOWEST_DEAL_TYPE_INTERVENTION = "1";
    // 2-全部确认
    String UNDER_LOWEST_DEAL_TYPE_ALL = "2";
    // 3-保留账面最低金额
    String UNDER_LOWEST_DEAL_TYPE_RETAIN = "3";

    /**
     * 小份额强赎触发方式
     */
    String SMALL_SHARE_FORCE_TYPE = "small_share_force_type";
    // 0-小份额都强赎
    String SMALL_SHARE_FORCE_TYPE_0 = "0";
    // 1-按业务触发小份额强赎
    String SMALL_SHARE_FORCE_TYPE_1 = "1";
    // 2-从不发起小份额强赎
    String SMALL_SHARE_FORCE_TYPE_2 = "2";

    /**
     * 触发小份额强赎的业务
     */
    String SMALL_FORCE_REDEEM_BIZ = "small_force_redeem_biz";
    // 024-赎回
    String SMALL_FORCE_REDEEM_BIZ_REDEEM = "024";
    // 025-预约赎回
    String SMALL_FORCE_REDEEM_BIZ_ADVANCE_REDEEM = "025";
    // 063-定时赎回
    String SMALL_FORCE_REDEEM_BIZ_SCHEDULE = "063";
    // 036-基金转换
    String SMALL_FORCE_REDEEM_BIZ_FUND_TRANSFER = "036";
    // 026-转托管
    String SMALL_FORCE_REDEEM_BIZ_TRANSFER_TUO = "026";
    // 028-转托管出
    String SMALL_FORCE_REDEEM_BIZ_TRANSFER_TUO_OUT = "028";

    /**
     * 强赎存在冻结份额处理方式
     */
    String SMALL_FORCE_REDEEM_FROZEN_TYPE = "small_force_redeem_frozen_type";
    // 0-不强赎任何份额
    String SMALL_FORCE_REDEEM_FROZEN_TYPE_NO = "0";
    // 1-只强赎可用份额
    String SMALL_FORCE_REDEEM_FROZEN_TYPE_REMAIN = "1";

    /**
     * 小份额强赎一笔确认的业务
     */
    String SMALL_FORCE_REDEEM_ONE_BIZ = "small_force_redeem_one_biz";
    // 024-赎回
    String SMALL_FORCE_REDEEM_ONE_BIZ_REDEEM = "024";
    // 025-预约赎回
    String SMALL_FORCE_REDEEM_ONE_BIZ_ADVANCE_REDEEM = "025";
    // 063-定时赎回
    String SMALL_FORCE_REDEEM_ONE_BIZ_SCHEDULE = "063";
    // 036-基金转换
    String SMALL_FORCE_REDEEM_ONE_BIZ_FUND_TRANSFER = "036";
    // 026-转托管
    String SMALL_FORCE_REDEEM_ONE_BIZ_TRANSFER_TUO = "026";
    // 028-转托管出
    String SMALL_FORCE_REDEEM_ONE_BIZ_TRANSFER_TUO_OUT = "028";

    /**
     * 全额赎回/转换标记
     */
    String ALL_REDEEM_FLAG = "all_redeem_flag";
    // 部分赎回/转换
    String ALL_REDEEM_FLAG_PART = "0";
    // 全额赎回/转换
    String ALL_REDEEM_FLAG_ALL = "1";

    /**
     * 强制赎回类型
     */
    String FORCE_RED_TYPE = "force_red_type";
    //1-小份额强赎
    String FORCE_RED_TYPE_1 = "1";
    //2-管理人主动强赎
    String FORCE_RED_TYPE_2 = "2";
    //3-T+0垫资账户强赎
    String FORCE_RED_TYPE_3 = "3";
    //4-T+0剩余收益强赎
    String FORCE_RED_TYPE_4 = "4";
    //5-短期理财违约赎回额度控制强赎
    String FORCE_RED_TYPE_5 = "5";
    //6-拆分强赎
    String FORCE_RED_TYPE_6 = "6";
    //7-HiFas自营账户强赎
    String FORCE_RED_TYPE_7 = "7";
    //8-份额配比强赎
    String FORCE_RED_TYPE_8 = "8";
    //9-未付收益强赎
    String FORCE_RED_TYPE_9 = "9";
    //a-短期理财违约强赎
    String FORCE_RED_TYPE_a = "a";
    //b-预期收益率产品强赎
    String FORCE_RED_TYPE_b = "b";
    //c-周期理财产品强赎
    String FORCE_RED_TYPE_c = "c";
    //d-存款类产品强赎
    String FORCE_RED_TYPE_d = "d";
    //e-拆分份额强赎
    String FORCE_RED_TYPE_e = "e";
    //g-升降级新级别强赎
    String FORCE_RED_TYPE_g = "g";
    //h-短期理财到期小份额强赎
    String FORCE_RED_TYPE_h = "h";
    //k-定期发起小份额强赎
    String FORCE_RED_TYPE_k = "k";
    //p-违约赎回强赎
    String FORCE_RED_TYPE_p = "p";
    //x-保证金解约赎回
    String FORCE_RED_TYPE_x = "x";

    /**
     * 产品发行状态
     */
    String ISSUE_STATUS = "issue_status";
    //0-正常
    String ISSUE_STATUS_0 = "0";
    //1-失败
    String ISSUE_STATUS_1 = "1";


//   末日比例配售处理方式
    String LAST_DAY_RATE_DEAL_TYPE="last_day_rate_deal_type";
//   认购确认时比例确认
   String LAST_DAY_RATE_DEAL_TYPE_0="0";
//   基金成立时确认
    String LAST_DAY_RATE_DEAL_TYPE_1="1";
    
//   违约退出罚金计算方式
    String SPECIAL_VIOLATE_FINE_TYPE="special_violate_fine_type";
//   退出总额扣除业绩提成
    String SPECIAL_VIOLATE_FINE_TYPE_0="0";
//   退出总额不扣除业绩提成
    String SPECIAL_VIOLATE_FINE_TYPE_1="1";
    
//   允许部分赎回
    String  SPECIAL_SOME_RED_FLAG="special_some_red_flag";
//   否
    String SPECIAL_SOME_RED_FLAG_0="0";
//   是
    String SPECIAL_SOME_RED_FLAG_1="1";
    
//   份额完全退出后允许再次申购
    String SPECIAL_SHARE_OUT_AGAIN_FLAG="special_share_out_again_flag";
//   否
    String SPECIAL_SHARE_OUT_AGAIN_FLAG_0="0";
//   是
    String SPECIAL_SHARE_OUT_AGAIN_FLAG_1="1";
    
//   户数限制中直销优先
    String SPECIAL_SELL_PRIORITY_FLAG="special_sell_priority_flag";
//   否
    String SPECIAL_SELL_PRIORITY_FLAG_0="0";
//   是
    String SPECIAL_SELL_PRIORITY_FLAG_1="1";
    
//   违约赎回是否收取交易费
    String SPECIAL_RED_VIOLATE_FEE_FLAG="special_red_violate_fee_flag";
//   否
    String SPECIAL_RED_VIOLATE_FEE_FLAG_0="0";
//   是
    String SPECIAL_RED_VIOLATE_FEE_FLAG_1="1";
    
//   违约赎回受产品状态影响
    String SPECIAL_RED_VIOLATE_AFFECT="special_red_violate_affect";
//   否
    String SPECIAL_RED_VIOLATE_AFFECT_0="0";
//   是
    String SPECIAL_RED_VIOLATE_AFFECT_1="1";

//   赎回最低账面金额含收益
    String SPECIAL_RED_MIN_AMT_FEE_FLAG="special_red_min_amt_fee_flag";
//   否
    String SPECIAL_RED_MIN_AMT_FEE_FLAG_0="0";
//   是
    String SPECIAL_RED_MIN_AMT_FEE_FLAG_1="1";

//   赎回持有天数计算方式
    String SPECIAL_RED_HOLD_CALCULATE_TYPE="special_red_hold_calculate_type";
//   按持有天数
    String SPECIAL_RED_HOLD_CALCULATE_TYPE_0="0";
//   按到期天数
    String SPECIAL_RED_HOLD_CALCULATE_TYPE_1="1";

//   赎回后资产低于最低保有金额
    String SPECIAL_RED_ASSET_LESS="special_red_asset_less";
//   以最低保有金额作为上限部分确认
    String SPECIAL_RED_ASSET_LESS_0="0";
//   全部确认
    String SPECIAL_RED_ASSET_LESS_1="1";
//   人工干预
    String SPECIAL_RED_ASSET_LESS_2="2";
//   确认失败
    String SPECIAL_RED_ASSET_LESS_3="3";
//   低于最低账面份额全部确认
    String SPECIAL_RED_ASSET_LESS_4="4";

//   开放期申购份额是否可用
    String SPECIAL_OPEN_PUR_SHARE_FLAG="special_open_pur_share_flag";
//   不可用
    String SPECIAL_OPEN_PUR_SHARE_FLAG_0="0";
//   可用
    String SPECIAL_OPEN_PUR_SHARE_FLAG_1="1";

//   专户不受户数限制判断方式
    String SPECIAL_NOT_ACC_LIMIT_TYPE="special_not_acc_limit_type";
//   按笔
    String SPECIAL_NOT_ACC_LIMIT_TYPE_0="0";
//   按累计
    String SPECIAL_NOT_ACC_LIMIT_TYPE_1="1";
//   不控制
    String SPECIAL_NOT_ACC_LIMIT_TYPE_2="2";

//   专户产品最低账户处理方式
    String SPECIAL_MIN_ACC_DEAL_TYPE="special_min_acc_deal_type";
//   取最低账面金额
    String SPECIAL_MIN_ACC_DEAL_TYPE_0="0";
//   取最低账面份额
    String SPECIAL_MIN_ACC_DEAL_TYPE_1="1";

//   巨额赎回顺延方式
    String SPECIAL_LARGE_RED_TYPE="special_large_red_type";
//   顺延到下个工作日
    String SPECIAL_LARGE_RED_TYPE_0="0";
//   顺延到下个开放周期日
    String SPECIAL_LARGE_RED_TYPE_1="1";
//   顺延到基金状态可赎回日
    String SPECIAL_LARGE_RED_TYPE_2="2";

//   是否分红
    String SPECIAL_DIVIDEND_FLAG="special_dividend_flag";
//   否
    String SPECIAL_DIVIDEND_FLAG_0="0";
//   是
    String SPECIAL_DIVIDEND_FLAG_1="1";

//   封闭期清算频率
    String SPECIAL_CLOSED_CLEAR_CYCLE="special_closed_clear_cycle";
//   每日清算
    String SPECIAL_CLOSED_CLEAR_CYCLE_0="0";
//   每周一
    String SPECIAL_CLOSED_CLEAR_CYCLE_1="1";
//   每周二
    String SPECIAL_CLOSED_CLEAR_CYCLE_2="2";
//   每周三
    String SPECIAL_CLOSED_CLEAR_CYCLE_3="3";
//   每周四
    String SPECIAL_CLOSED_CLEAR_CYCLE_4="4";
//   每周五
   String SPECIAL_CLOSED_CLEAR_CYCLE_5="5";

//   户数限制处理方式
   String  SPECIAL_ACC_LIMIT_DEAL_TYPE="special_acc_limit_deal_type";
//   按申请金额/申请时间/基金账号
    String SPECIAL_ACC_LIMIT_DEAL_TYPE_0="0";
//   按申请时间/申请金额/基金账号
    String SPECIAL_ACC_LIMIT_DEAL_TYPE_1="1";
//   按申请金额/申请时间/申请单号
    String SPECIAL_ACC_LIMIT_DEAL_TYPE_2="2";
//   按申请时间/申请金额/申请单号
    String SPECIAL_ACC_LIMIT_DEAL_TYPE_3="3";
//   按申请时间/申请单号/申请金额
    String SPECIAL_ACC_LIMIT_DEAL_TYPE_4="4";

//   份额的精度处理方式
    String SHARE_PRECISION_TYPE="share_precision_type";

//   金额的精度处理方式
    String AMT_PRECISION_TYPE="amt_precision_type";

//   校验净值精度处理方式
    String CHECK_NAV_PRECISION_TYPE="check_nav_precision_type";

//   归资产费用的精度处理方式
    String BELONG_ASSET_PRECISION_TYPE="belong_asset_precision_type";

//   费用的精度处理方式
    String FEE_PRECISION_TYPE="fee_precision_type";

//   分红的精度处理方式
   String  DIVIDEND_PRECISION_TYPE="dividend_precision_type";

//   收益率的精度处理方式
    String INCOME_RATE_PRECISION_TYPE="income_rate_precision_type";

//   利息的精度处理方式
    String INCOME_PRECISION_TYPE="income_precision_type";

//   赎回转换业务兑付收益规则
    String RED_SWITCH_INCOME_CASH_RULE="red_switch_income_cash_rule";
//   按比例兑付
    String RED_SWITCH_INCOME_CASH_RULE_0="0";
//   负收益按比例兑付
    String RED_SWITCH_INCOME_CASH_RULE_1="1";
//   剩余资产为负按比例兑付
    String RED_SWITCH_INCOME_CASH_RULE_2="2";
//   只全部赎回兑付
    String RED_SWITCH_INCOME_CASH_RULE_3="3";
//   部分和全部赎回都不兑付
    String RED_SWITCH_INCOME_CASH_RULE_4="4";

//   赎回份额明细处理方式
    String RED_SHARE_DEAL_TYPE="red_share_deal_type";
//   后进先出
    String RED_SHARE_DEAL_TYPE_0="0";
//   先进先出
    String RED_SHARE_DEAL_TYPE_1="1";

//   赎回费归基金资产方式
    String RED_FEE_BELONG_ASSET="red_fee_belong_asset";
//   打折后赎回费
    String RED_FEE_BELONG_ASSET_0="0";
//   打折前赎回费
    String RED_FEE_BELONG_ASSET_1="1";

//   收益尾差处理方式
    String POOR_CASH_DEAL_TYPE="poor_cash_deal_type";
//   参与下个工作日的分配
    String POOR_CASH_DEAL_TYPE_0="0";
//   按持有份额由大到小每户一分
    String POOR_CASH_DEAL_TYPE_1="1";
//   按截去的收益由大到小每户一份
    String POOR_CASH_DEAL_TYPE_2="2";
//   按历史累计的截去的收益由大到小每户一份
    String POOR_CASH_DEAL_TYPE_3="3";

//   暂停申购允许定投
    String PAUSE_PUR_INVEST="pause_pur_invest";
//   否
    String PAUSE_PUR_INVEST_0="0";
//   是
    String PAUSE_PUR_INVEST_1="1";

//   超额申购判断
    String OVER_PUR_JUDGMENT="over_pur_judgment";
//   超额申购比例
    String OVER_PUR_JUDGMENT_0="0";
//   最高规模份额
    String OVER_PUR_JUDGMENT_1="1";
//   最高规模金额
    String OVER_PUR_JUDGMENT_2="2";
//   当日最大净申购金额
    String OVER_PUR_JUDGMENT_3="3";

//   超额申购处理模式
    String OVER_PUR_DEAL_TYPE="over_pur_deal_type";
    //   按比例确认
    String OVER_PUR_DEAL_TYPE_1="1";
    //   分销售商按申请编号
    String OVER_PUR_DEAL_TYPE_2="2";
    //   分销售商按时间处理
    String OVER_PUR_DEAL_TYPE_3 ="3";
    //   分销售商按销售商的规则
    String OVER_PUR_DEAL_TYPE_4 ="4";

//   分销售商按汇总金额
    String OVER_PUR_DEAL_TYPE_5="5";
//   分销售商按单笔金额
    String OVER_PUR_DEAL_TYPE_6="6";
//   不分销售商按申请时间
    String OVER_PUR_DEAL_TYPE_7="7";
//   不分销售商按汇总金额
    String OVER_PUR_DEAL_TYPE_8="8";
//   不分销售商按单笔金额
    String OVER_PUR_DEAL_TYPE_9="9";

//   未付收益分红方式
    String NOT_PAY_INCOME_DIVIDEND_TYPE="not_pay_income_dividend_type";
//   红利再投资
    String NOT_PAY_INCOME_DIVIDEND_TYPE_0="0";
//   现金红利
    String NOT_PAY_INCOME_DIVIDEND_TYPE_1="1";

//   未付收益参与收益分配
    String NOT_PAY_INCOME_ALLOT_FLAG="not_pay_income_allot_flag";
//   否
   String NOT_PAY_INCOME_ALLOT_FLAG_0="0";
//   是
    String NOT_PAY_INCOME_ALLOT_FLAG_1="1";

//   行情导入是否校验份额
    String NAV_CHECK_SHARE_FLAG="nav_check_share_flag";
//   否
    String NAV_CHECK_SHARE_FLAG_0="0";
//   是
    String NAV_CHECK_SHARE_FLAG_1="1";

//   行情导入是否校验净值
    String NAV_CHECK_NAV_FLAG="nav_check_nav_flag";
//   否
    String NAV_CHECK_NAV_FLAG_0="0";
//   是
    String NAV_CHECK_NAV_FLAG_1="1";

//   巨额赎回处理方式
    String LARGE_REDEEM_DEAL_TYPE="large_redeem_deal_type";
//   取消
    String LARGE_REDEEM_DEAL_TYPE_0="0";
//   顺延
    String LARGE_REDEEM_DEAL_TYPE_1="1";
//   人工干预
    String LARGE_REDEEM_DEAL_TYPE_2="2";

//   会计收益每天结转成份额
    String INCOME_DAILY_CARRY_SHARE="income_daily_carry_share";
//   否
    String INCOME_DAILY_CARRY_SHARE_0="0";
//   是
   String  INCOME_DAILY_CARRY_SHARE_1="1";

//   收益结转模式
    String INCOME_CARRY_TYPE="income_carry_type";
//   新生成一笔份额明细
    String INCOME_CARRY_TYPE_0="0";
//   每月一笔分红份额明细
   String  INCOME_CARRY_TYPE_1="1";
//   始终一笔分红份额明细
    String INCOME_CARRY_TYPE_2="2";

//   收益结转频率
    String INCOME_CARRY_CYCLE="income_carry_cycle";
//   按月
    String INCOME_CARRY_CYCLE_0="0";
//   按日
   String  INCOME_CARRY_CYCLE_1="1";
//   不兑付
    String INCOME_CARRY_CYCLE_N="n";

//   大额交易控制方式
   String  HIGH_CASH_LIMIT_TRADE_TYPE="high_cash_limit_trade_type";
//   按基金控制
    String HIGH_CASH_LIMIT_TRADE_TYPE_0="0";
//   按直销代销控制
   String  HIGH_CASH_LIMIT_TRADE_TYPE_1="1";

//   转换份额明细处理方式
    String SWITCH_SHARE_DEAL_TYPE="switch_share_deal_type";
//   后进先出
    String SWITCH_SHARE_DEAL_TYPE_0="0";
//   先进先出
    String SWITCH_SHARE_DEAL_TYPE_1="1";

//   强制赎回方式
    String PRD_FORCE_RED_TYPE="prd_force_red_type";
//   小份额都强赎
    String PRD_FORCE_RED_TYPE_0="0";
//   只发生赎回确认
    String PRD_FORCE_RED_TYPE_1="1";
//   发生赎回|转换出|转托管出确认
    String PRD_FORCE_RED_TYPE_2="2";
//   不发起强制赎回
    String PRD_FORCE_RED_TYPE_3="3";

//   当日新增收益是否参与兑付
    String DAILY_INCOME_CASH_FLAG="daily_income_cash_flag";
//   否
    String DAILY_INCOME_CASH_FLAG_0="0";
//   是
    String DAILY_INCOME_CASH_FLAG_1="1";
    
//   是否必须指定赎回
    String ASSIGN_RED_FLAG="assign_red_flag";
//   否
    String ASSIGN_RED_FLAG_0="0";
//   是
   String  ASSIGN_RED_FLAG_1="1";

    /**
     * 对于人工逐笔确认失败的及因销售商规模控制确认失败的导致的
     */
    String ARTIFICIAL_ORG_CONTROL_FAIL = "artificial_org_control_fail";
    // 0- 按成立业务下发
    String ARTIFICIAL_ORG_CONTROL_FAIL_0 = "0";
    // 1- 按发行失败业务下发
    String ARTIFICIAL_ORG_CONTROL_FAIL_1 = "1";

    /**
     * 产品验资成立状态
     * 0-待验资，1-验资中，2-验资成功，3-验资失败，4-产品发行处理中，5-产品成立，6-产品成立失败,
     * 7-主动发行失败（待处理）,8-主动发行失败（处理中），9-主动发行失败（发行失败）
     */
    String PRD_SET_UP_STATUS = "prd_set_up_status";
    String PRD_SET_UP_STATUS_0 = "0";
    String PRD_SET_UP_STATUS_1 = "1";
    String PRD_SET_UP_STATUS_2 = "2";
    String PRD_SET_UP_STATUS_3 = "3";
    String PRD_SET_UP_STATUS_4 = "4";
    String PRD_SET_UP_STATUS_5 = "5";
    String PRD_SET_UP_STATUS_6 = "6";
    String PRD_SET_UP_STATUS_7 = "7";
    String PRD_SET_UP_STATUS_8 = "8";
    String PRD_SET_UP_STATUS_9 = "9";

    /**
     * 基金规模控制状态
     * 0-基金规模控制待处理,1-基金规模控制处理中,2-基金规模控制处理成功,3-基金规模控制处理失败
     */
    String PRD_SET_UP_FUND_SIZE_STATUS = "prd_set_up_fund_size_status";
    String PRD_SET_UP_FUND_SIZE_STATUS_0 = "0";
    String PRD_SET_UP_FUND_SIZE_STATUS_1 = "1";
    String PRD_SET_UP_FUND_SIZE_STATUS_2 = "2";
    String PRD_SET_UP_FUND_SIZE_STATUS_3 = "3";

    /**
     *交易所标志: 0-深圳场内,  1-上海场内, 2-场外
     */
    String EXCHANGE_MARKET_FLAG = "exchange_market_flag";
    String exchange_market_flag_0 = "0";
    String exchange_market_flag_1 = "1";
    String exchange_market_flag_2 = "2";

    /**
     * 定期定额类型:
     * 0-定期定额申购
     * 1-定期不定额申购
     * 2-定额不定期申购
     * 3-不定额不定期申购
     */
    String RATION_TYPE = "ration_type";
    String RATION_TYPE_0 = "0";
    String RATION_TYPE_1 = "1";
    String RATION_TYPE_2 = "2";
    String RATION_TYPE_3 = "3";

    /**
     * 有效标志: 0-无效；1-有效
     */
    String EFFECT_FLAG = "effect_flag";
    String EFFECT_FLAG_0 = "0";
    String EFFECT_FLAG_1 = "1";

    /**
     * 默认协议标识:0-否;1-是
     */
    String AGREEMENT_FLAG = "agreement_flag";
    String AGREEMENT_FLAG_0 = "0";
    String AGREEMENT_FLAG_1 = "1";

    /**
     * 自动计算可分配资产
     */
    String AUTO_PROVISION_DISTRIBUTABLE_ASSETS = "auto_provision_distributable_assets";

    /**
     * 计提业绩报酬: 0-不计提;1-按试算结果计提;2-重新计提（清盘）
     */
    String CARRY_FLAG = "carry_flag";
    String CARRY_FLAG_0 = "0";
    String CARRY_FLAG_1 = "1";
    String CARRY_FLAG_2 = "2";

    /**
     * 下发确认的单位净值: 0-按单位净值下发;1-行情中的单位净值
     */
    String CFM_NAV = "cfm_nav";
    String CFM_NAV_0 = "0";
    String CFM_NAV_1 = "1";

    /**
     * 账户类型（银行） 0-普通账户 1-信用账户
     */
    String CREDIT_ACC_FLAG = "credit_acc_Flag";
    String CREDIT_ACC_FLAG_0 = "0";
    String CREDIT_ACC_FLAG_1 = "1";

}