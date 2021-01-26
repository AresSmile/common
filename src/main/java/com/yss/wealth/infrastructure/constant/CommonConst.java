package com.yss.wealth.infrastructure.constant;

/**
*
* @author:zhuhongmin
* @date:2020/10/22
* @description: 公共常量
**/
public interface CommonConst {
    String SEMICOLON = ";";

    /**
     * 是
     */
    String YES = "1";

    /**
     *
     */
    String NO = "0";

    /**
     * 基金销售商TA
     */
    String TA = "TA0";

    /**
     * 支持
     */
    String SUPPORT = "1";

    /**
     * 不支持
     */
    String NOT_SUPPORT = "0";

    /**
     * 允许
     */
    String ALLOW = "1";

    /**
     * 禁止
     */
    String BAN = "0";

    /**
     * 已锁定
     */
    String LOCKED = "1";

    /**
     * 未锁定
     */
    String UN_LOCKED = "0";

    /**
     * 已处理
     */
    String PROCESSED = "1";

    /**
     * 处理中
     */
    String PROCESSING = "2";

    /**
     * 未处理
     */
    String UN_PROCESSED = "0";

    /**
     * 未就绪
     */
    String NOT_READY = "N";

    /**
     * 男性
     */
    String MALE = "1";

    /**
     * 女性
     */
    String FEMALE = "2";

    /**自定义查询客户默认查询状态**/
    String CONDITION_FIELD_QUERY_FLAG = "1";
    /**默认用户id（用于自定义条件与列查询）**/
    String DEFAULT_USER_ID = "0";
    /** 自定义列客户默认显示状态**/
    String QUERY_FIELD_VISIBLE = "1";

    //全部
    String ALL = "all";

    String ALL_ORG = "全部销售商";

    String ALL_PRD = "全部产品";

    String ALL_NET = "全部网点";

    String ALL_SHARE_TYPE = "全部份额类别";

    String ORG = "org";
    /**
     * 日清算处理类型-检查 或者检查确认
     */
    int CHECK = 0;

    /**
     * 日清算处理类型-确认
     */
    int CFM = 1;
    /**
     * TA发起立即确认
     */
    int TA_CFM = 2;

    /**
     * 1- 导出选中
     */
    String EXP_CHOOSE_TYPE = "1";

    /**
     * 2- 导出当前页
     */
    String EXP_CURRENT_TYPE = "2";

    /**
     * 3-导出全部数据
     */
    String EXP_ALL_TYPE = "3";

    /**
     * 世界末日
     */
    String DOOMSDAY = "2099-12-31";

    /**
     * 保有金额/保有份额 最小值
     */
    String HOLD_AMOUNT_SHARE_MIN = "0";

    /**
     * 保有金额/保有份额 最大值
     */
    String HOLD_AMOUNT_SHARE_MAX = "99999999999999";

    /**
     * 保有比例 最小值
     */
    String HOLD_RATIO_MIN = "0";

    /**
     * 保有比例 最大值
     */
    String HOLD_RATIO_MAX = "1";

    /**
     * 简单复制
     */
    String COPY_TYPE_SIMPLE = "A";

    /**
     * 精确复制
     */
    String COPY_TYPE_COMPLEX = "B";

    /**
     * 按产品复制
     */
    String COPY_BY_PRD = "0";

    /**
     * 按销售商复制
     */
    String COPY_BY_ORG = "1";

    /**
     * 查询数据清算状态
     * 查询标志：2-交易清算状态"
     */
    String CLEAR_PROCESS_QUERY_FLAG_1 ="1";
    /**
     * 查询数据清算状态
     * 查询标志：2-交易清算状态"
     */
    String CLEAR_PROCESS_QUERY_FLAG_2="2";

    /**
     * 分隔符
     */
    String VALUE_DELIMITER = ",";

    /**
     * 赎回申请数据来源
     */
    // 巨额赎回顺延数据
    Integer REDEEM_VASTLY = 1;
    // 03申请文件: 024-赎回申请;025-预约赎回申请;063-定时定额赎回申请
    Integer REDEEM_NORMAL = 2;
    // 违约数据申请数据
    Integer REDEEM_BREACH = 3;

}
