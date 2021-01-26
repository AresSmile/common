package com.yss.wealth.infrastructure.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * @description：全局统一自定义异常类(程序或业务异常提示返回给前端信息)
 */
@Builder
@Data
public class MessageException extends RuntimeException {
    private String message;
    private ECode code;

    public MessageException() {
    }

    public MessageException(String message) {
        this.code = ECode.WARNING;
        this.message = message;

    }

    public MessageException(String message, Throwable throwable) {
        super(message, throwable);
        this.code = ECode.WARNING;
        this.message = message;

    }

    public MessageException(ECode code) {
        this.code = code;
        this.message = code.getMessage();
    }

    public MessageException(String message, ECode code) {
        this.code = code;
        this.message = message;
    }

    public static MessageExceptionBuilder builder() {
        return new MessageExceptionBuilder();
    }

    public static class MessageExceptionBuilder {
        private String message;
        private ECode code;

        public MessageExceptionBuilder message(String message) {
            this.message = message;
            return this;
        }

        public MessageExceptionBuilder code(ECode code) {
            this.code = code;
            return this;
        }

    }

    public static void notNull(@Nullable Object object, String message){
        if (object == null) {
            throw new MessageException(message);
        }
    }
}
