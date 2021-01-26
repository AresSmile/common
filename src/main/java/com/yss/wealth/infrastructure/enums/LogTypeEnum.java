package com.yss.wealth.infrastructure.enums;
/**
* 日志类型
* @author:zhuhongmin
* @date:2020/5/30
* @description:
**/
public enum  LogTypeEnum {
    NORMAL(0,"普通日志"),
    SPECIAL(1,"特殊日志");

    private Integer type;
    private String desc;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    LogTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
