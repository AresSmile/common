package com.yss.wealth.infrastructure.constant;

/**
 * @Author: cr
 * @Date: 2020/10/27 10:45
 * @Description: 清算流程专用rediskey
 */
public interface CommonServerConst {

    /**
     * 清算流程缓存key的字段分隔符,分隔符不能*，redis中*号为通配符
     */
    String SPLIT = "_";

    /**
     * 工作日对象存储在redis的key
     */
    String WORK_DAY_PREFIX = "WORK_DAY_MSG";
    /**
     * 清算流程缓存key前缀
     */
    String PROCESS_KEY_PREFIX = "PROCESS_KEY:";
    /**
     * 产品信息存储于redis的前缀key
     */
    String PRD_INFO_PREFIX = "PRD_INFO:";
    /**
     * 系统参数的redis前缀key
     */
    String SYS_PARAM_PREFIX = "PROCESS_SYS_PARAM:";
    /**
     * 净值信息前缀key
     */
    String NAV_INFO_PREFIX = "NAV_INFO:";
    /**
     * 产品代销关系前缀key
     */
    String PRD_AGENCY_PREFIX = "PRD_AGENCY:";
    /**
     * 产品状态业务限制信息
      */
    String PRD_STATUS_BIZ_LIMIT_PREFIX = "PRD_STATUS_BIZ_LIMIT:";
    /**
     * 证件类型业务限制信息
     */
    String CERT_TYPE_BIZ_LIMIT_PREFIX = "CERT_TYPE_BIZ_LIMIT:";
    /**
     * 年龄业务限制信息
     */
    String AGE_BIZ_LIMIT_PREFIX = "AGE_BIZ_LIMIT:";

    /**
     * 产品转换限制信息
     */
    String CHANGE_BIZ_LIMIT_PREFIX = "CHANGE_BIZ_LIMIT:";


    /**
     * 定期定额业务限制
     */
    String RATION_BIZ_LIMIT_PREFIX = "RATION_BIZ_LIMIT:";
    /**
     * 机构信息
     */
    String ORG_INFO_PREFIX = "ORG_INFO:";

    /**
     * 产品机构参数信息前缀
     */
    String PRD_ORG_PARAM_PREFIX = "PRD_ORG_PARAM:";

    /**
     * 产品机构参数信息前缀
     */
    String PRD_ORG_BIZ_LIMIT_PREFIX = "PRD_ORG_BIZ_LIMIT:";

    /**
     * 网点信息
     */
    String NET_INFO_PREFIX = "NET_INFO:";


    /**
     * 费用信息前缀
     */
    String CHARGE_INFO_PREFIX = "CHARGE_INFO:";
    /**
     * redis通配符
     */
    String REDIS_WILDCARD = "*";

    /**
     * 业务key中的*，替换字符
     */
    String ALL = "all";

    /**
     * 客户名单
     */
    String CUST_LIST_PREFIX = "CUST_LIST:";


    /**
     * 费率信息前缀
     */
    String FEE_RATE_PREFIX = "FEE_RATE:";
    /**
     * 销售商折扣限制
     */
    String ORG_DISCOUNT_LIMIT = "ORG_DISCOUNT_LIMIT:";

    /**
     *费用分成前缀
     */
    String FEE_DIVIDE_PREFIX = "FEE_DIVIDE:";

    /**
     *补差费规则前缀
     */
    String FEE_RULE_PREFIX = "FEE_RULE:";

    /**
     *优惠折扣前缀
     */
    String TA_DISCOUNT_PREFIX = "TA_DISCOUNT:";

    /**
     *协议折扣前缀
     */
    String RATION_DISCOUNT_PREFIX = "RATION_DISCOUNT:";

    /**
     *赎回折扣前缀
     */
    String RED_DISCOUNT_PREFIX = "RED_DISCOUNT:";


    /**
     * 优惠折扣明细前缀
     */
    String SALES_DISCOUNT_DETAIL_PREFIX = "SALES_DISCOUNT_DETAIL:";

    /**
     * 空字符标识
     */
    String EMPTY_TAG = ";";

    /**
     * 历史费率信息前缀
     */
    String HIS_FEE_RATE_PREFIX = "HIS_FEE_RATE:";

    /**
     * 归基金资产比例信息前缀
     */
    String BELONG_PRD_RATE_PREFIX = "BELONG_PRD_RATE:";
    /**
     * 销售商折扣限制方案 的 分段方式 前缀
     */
    String CUT_TYPE_PREFIX = "CUT_TYPE_PREFIX:";

    /**
     * 交易检查赎回、转换共用的份额余额检查Redis前缀 剩余份额 前缀
     */
    String SHARE_REMAIN_PREFIX = "REMAIN:";

    /**
     * 交易检查赎回、转换共用的份额余额检查Redis前缀 冻结总份额 前缀
     */
    String FORZEN = "FORZEN:";

    /**
     * 交易检查赎回、转换共用的份额余额检查Redis前缀 份额明细 前缀
     */
    String SHARE_DETAIL = "SHARE_DETAIL:";

    /**
     * 交易检查赎回、转换共用的份额余额检查Redis前缀 静态份额 前缀
     */
    String STATIC_SHARE = "STATIC_SHARE:";

    /**
     * 基金拆分
     */
    String PRD_SPLIT = "PRD_SPLIT:";
    /**
     * 产品利率
     */
    String PRD_RATE = "PRD_RATE:";
    /**
     * 产品交易限额
     */
    String PRD_TRADE_LIMIT = "PRD_TRADE_LIMIT:";
}
