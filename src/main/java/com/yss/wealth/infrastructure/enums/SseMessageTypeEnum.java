package com.yss.wealth.infrastructure.enums;

/**
 * @author:zhuhongmin
 * @date:2020/4/9
 * @description: sse消息消息类型枚举
 **/
public enum SseMessageTypeEnum {
    SYSTEM_ANNOUNCE("0", "系统公告"),
    BUSINESS_REMIND("1", "业务提醒"),
    WORKBENCH_REFRESH("2", "工作台数据刷新"),
    PROCESS_BULLET_FRAME_REMIND("3", "流程弹框任务完成提醒");

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

    SseMessageTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
