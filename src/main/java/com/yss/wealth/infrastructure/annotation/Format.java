package com.yss.wealth.infrastructure.annotation;


import com.yss.wealth.infrastructure.enums.DicFormatTypeEnum;

import java.lang.annotation.*;

/**
*
* @author:zhuhongmin
* @date:2020/7/30
* @description: 格式化注解
**/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
public @interface Format {
    /**
     * 格式化类型
     * @return
     */
    FormatType type();

    /**
     * 格式化字段变量名称（也可以是需要关联的字段）
     * @return
     */
    String[] fieldName();

    /**
     * 接口名称
     * @return
     */
    String interfaceName() default "";

    /**
     * 方法名称
     * @return
     */
    String methodName() default "";

    /**
     * 格式化规则
     * @return
     */
    DicFormatTypeEnum rule() default DicFormatTypeEnum.CODE_VALUE;

    /**
     * 其他字段(预留字段，比如关联账户信息的时候需要去指定该字段需要关联的字段名)
     * @return
     */
    String other() default "";

    enum FormatType{
        /**
         * 产品代码名称格式化
         */
        PRD_FORMAT("com.yss.ta.product.feign.ProductFeignClient","codeNameMapping"),
        /**
         * 机构代码名称格式化
         */
        ORG_FORMAT("com.yss.ta.organization.feign.OrganizationFeignClient","getOrgCodeMapping"),
        /**
         * 网点代码名称格式化
         */
        NET_FORMAT("com.yss.ta.organization.feign.OrganizationFeignClient","getNetInfoByOrgCode"),
        /**
         * 基金账户信息关联
         */
        FUND_ACCOUNT_RELATED("",""),
        /**
         * 交易账户关联
         */
        TRADE_ACCOUNT_RELATED("",""),

        /**
         * 证件类型格式化
         */
        CERTIFICATE_TYPE_FORMAT("","");

        private String interfaceName;
        private String methodName;


        FormatType(String interfaceName, String methodName) {
            this.interfaceName = interfaceName;
            this.methodName = methodName;
        }

        public String getInterfaceName() {
            return interfaceName;
        }

        public void setInterfaceName(String interfaceName) {
            this.interfaceName = interfaceName;
        }

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }
    }

}

