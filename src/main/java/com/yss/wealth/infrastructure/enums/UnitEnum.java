package com.yss.wealth.infrastructure.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuanfei.Chen
 * @description
 * @date 2020/5/29 11:17
 */
public enum UnitEnum {
    B("B", "字节"),
    K("K", "千字节"),
    M("M", "兆字节"),
    G("G", "千兆字节");

    /** 枚举值 */
    private final String code;

    /** 枚举描述 */
    private final String message;

    /**
     * 构造方法
     * @param code
     * @param message
     */
    UnitEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 通过code获取msg
     *
     * @param code 枚举值
     *
     * @return
     */
    public static String getMsgByCode(Integer code) {
        if (code == null) {
            return null;
        }
        UnitEnum enumList = getByCode(code);
        if (enumList == null) {
            return null;
        }
        return enumList.getMessage();
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * values() 方法将枚举转变为数组
     *
     * @return AuthGradeEnum
     */
    public static UnitEnum getByCode(Integer code) {
        for (UnitEnum enumList : values()) {
            if (enumList.getCode().equals(code)) {
                return enumList;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return List<AuthGradeEnum>
     */
    public static List<UnitEnum> getAllEnum() {
        List<UnitEnum> list = new ArrayList<>(values().length);
        for (UnitEnum enumList : values()) {
            list.add(enumList);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     *
     * @return List<String>
     */
    public static List<String> getAllEnumCode() {
        List<String> list = new ArrayList<>(values().length);
        for (UnitEnum enumList : values()) {
            list.add(enumList.getCode());
        }
        return list;
    }
}
