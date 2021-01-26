package com.yss.wealth.infrastructure.constant;

/**
 * @author zhangzhihui
 * @description redis key值各个模块的前缀
 * @date 2020/7/29
 */
public interface RedisPrefixConstants {

    /**
     * 公告管理
     */
    String ANNOUNCEMENT = "product_announcement_";
    /**
     * 产品转换限制
     */
    String PRDCONVERTLIMIT = "product_proconvertlimit_";
    /**
     * 证件类型限制
     */
    String CERTIFICATE_TYPE_LIMIT = "product_certificatetypelimit_";

    /**
     * 产品养老金方案
     */
    String PRD_PENSION = "product_prd_pension_";

    /**
     * 尾随佣金方案
     */
    String TRAIL_COMMISSION_SCHEME = "trail_commission_scheme";

    /**
     * 省市名称的映射
     */
    String PROVINCE_CITY_CODE_NAME = "province_city_code_name";

    /**
     * 省市的所有信息（集合）
     */
    String PROVINCE_CITY_INFO = "province_city_info";

    /**
     * 基金清盘方案
     */
    String PRODUCT_LIQUIDATION_SCHEME = "product_liquidation_scheme:";
}
