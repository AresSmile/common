package com.yss.wealth.infrastructure.enums;
/**
*
* @author:zhuhongmin
* @date:2020/10/27
* @description: 审核状态枚举
**/
public enum AuditStateEnum {
    //状态分为未提交（草稿），待复核，已生效（正式）
    UN_COMMIT("0","未提交"),
    UN_CHECK("1","待复核"),
    CHECKED("2","已生效");
    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

     AuditStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
