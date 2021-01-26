package com.yss.wealth.infrastructure.enums;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author:zhuhongmin
 * @date:2020/5/22
 * @description:字典格式化类型枚举
 **/
public enum DicFormatTypeEnum {
    /**
     * 默认直接返回字典值
     */
    DEFAULT {
        @Override
        public String getValue(String code, String value) {
            return value;
        }
    },
    /**
     * code-value格式
     */
    CODE_VALUE {
        @Override
        public String getValue(String code, String value) {
            return ObjectUtil.isEmpty(value) ? code : code + "-" + value;
        }
    };

    public abstract String getValue(String code, String value);
}
