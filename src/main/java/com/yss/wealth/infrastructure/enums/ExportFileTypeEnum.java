package com.yss.wealth.infrastructure.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * 包名称：com.win.dfas.common.enumeration
 * 类名称：ExportFileTypeEnum
 * 类描述：文件导出类型
 * 创建人：@author liuting
 * 创建时间：2020/8/31 14:52
 */
@Getter
public enum ExportFileTypeEnum {
    /**
     * 导出类型
     */
    XLS("xls"),
    XLSX("xlsx"),
    ;
    private final String type;

    ExportFileTypeEnum(String type) {
        this.type = type;
    }

    public static ExportFileTypeEnum getByType(String type) {
        if (Objects.isNull(type)) {
            return null;
        }

        for (ExportFileTypeEnum typeEnum : ExportFileTypeEnum.values()) {
            if (typeEnum.type.equals(type)) {
                return typeEnum;
            }
        }
        return null;
    }
}
