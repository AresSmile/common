package com.yss.wealth.infrastructure.common;


/**
 * @author Zhou
 * @version 1.0
 * @created 08-4��-2020 11:23:22
 */
public enum CheckStatus {
    /**
     * 1-待审核
     * 2-审核通过
     * 3-驳回
     */
    UNCHECK(0, "待审核"),
    CHECK_SUCCESS(1, "通过"),
    CHECK_FAILED(2, "驳回"),
    UN_COMMIT(3,"未提交");

    private Integer key;
    private String value;

    CheckStatus(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

