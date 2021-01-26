package com.yss.wealth.infrastructure.enums;
/**
*
* @author:zhuhongmin
* @date:2020/6/16
* @description:
**/
public enum MailSendTypeEnum {
    TO_USER("0","发送给用户"),
    TO_ROLE("1","发送给角色"),
    TO_ADDR("2","发送给指定地址");
    private String type;
    private String desc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    MailSendTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
