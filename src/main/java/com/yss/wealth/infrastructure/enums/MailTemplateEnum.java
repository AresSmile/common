package com.yss.wealth.infrastructure.enums;
/**
*
* @author:zhuhongmin
* @date:2020/6/16
* @description:
**/
public enum MailTemplateEnum {
    /**
     * 测试邮件
     */
    TEST("TEST","测试邮件");
    private String templateModule;
    private String desc;

    MailTemplateEnum(String templateModule, String desc) {
        this.templateModule = templateModule;
        this.desc = desc;
    }

    public String getTemplateModule() {
        return templateModule;
    }

    public void setTemplateModule(String templateModule) {
        this.templateModule = templateModule;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
