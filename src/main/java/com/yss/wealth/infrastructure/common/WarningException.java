package com.yss.wealth.infrastructure.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

/**
 * @author libihui
 * @version 1.0 2020/2/20
 * @description：全局统一自定义警告异常类，根据需求定义规则提醒
 */
@Builder
@Data
public class WarningException extends RuntimeException {
    private String message;
    private String code;

    private WarningException() {
    }

    public WarningException(String message, String code, Throwable e) {
        super(message, e);
        this.code = code;
        this.message = message;
    }

    public WarningException(String message, String code) {
        this.code = code;
        this.message = message;
    }

    public static WarningException.WarningExceptionBuilder builder() {
        return new WarningException.WarningExceptionBuilder();
    }

    public static class WarningExceptionBuilder {
        private String message;
        private String code;

        public WarningException.WarningExceptionBuilder message(String message) {
            this.message = message;
            return this;
        }

        public WarningException.WarningExceptionBuilder code(String code) {
            this.code = code;
            return this;
        }
    }

    public static void notNull(@Nullable Object object, String message, String code) {
        if (object == null) {
            throw new WarningException(message, code);
        }
    }

    public static void notNull(@Nullable Object object, String message, String code, Throwable e) {
        if (object == null) {
            throw new WarningException(message, code, e);
        }
    }
}
