package com.yss.wealth.infrastructure.enums;

/**
 * @author: changhaiyan
 * @date: 2020/7/15 10:28
 **/
public enum ExportTypeEnum {

    SELECTED("0","选中导出"),
    CURRENT_PAGE("1","当前页导出"),
    COMPLETE("2","全部导出");

    private String status;

    private String desc;

    ExportTypeEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
