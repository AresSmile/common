package com.yss.wealth.infrastructure.enums;

/**
 * @author:zhuhongmin
 * @date:2020/4/9
 * @description:  sse消息发送类型枚举
 **/
public enum SseMessageSendTypeEnum {
    TO_USER("0", "指定用户"),
    TO_ROLE("1", "指定角色");
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

    SseMessageSendTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
