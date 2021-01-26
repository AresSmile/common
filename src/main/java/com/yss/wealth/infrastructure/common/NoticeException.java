package com.yss.wealth.infrastructure.common;

import org.springframework.lang.Nullable;

/**
 * @author libihui
 * @version 1.0 2020/4/10
 * @description：全局统一自定义消息提示异常类，根据需求定义规则提醒，不会回滚事务
 */
public class NoticeException extends WarningException {

    public NoticeException(String message, String code) {
        super(message, code);
    }

    public static void notNull(@Nullable Object object, String message, String code) {
        if (object == null) {
            throw new NoticeException(message, code);
        }
    }

    public NoticeException(String message, String code, Throwable e) {
        super(message, code, e);
    }

    public static void notNull(@Nullable Object object, String message, String code, Throwable e) {
        if (object == null) {
            throw new NoticeException(message, code, e);
        }
    }
}
