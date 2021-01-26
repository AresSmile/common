package com.yss.wealth.infrastructure.enums;

/**
 * @author:zhuhongmin
 * @date:2020/4/9
 * @description: sse消息优先级枚举
 **/
public enum SseMessagePriorityEnum {
    HIGH("0", "高"),
    MID("1", "中"),
    LOW("2", "低");
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

    SseMessagePriorityEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
