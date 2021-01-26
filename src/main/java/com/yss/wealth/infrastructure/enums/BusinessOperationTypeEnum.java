package com.yss.wealth.infrastructure.enums;
/**
*
* @author:zhuhongmin
* @date:2020/4/9
* @description: 业务日志操作类型枚举
**/
public enum BusinessOperationTypeEnum {
    ADD(0,"新增"),
    DELETE(1,"删除"),
    UPDATE(2,"修改"),
    SELECT(3,"查询"),
    COPY(4,"复制"),
    IMP(5,"导入"),
    EXP(6,"导出");

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    BusinessOperationTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private Integer type;
    private String desc;
}
