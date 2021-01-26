package com.yss.wealth.infrastructure.util;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author libihui
 * @version 1.0 2020/3/10
 * @description：
 */
public class MethodHandleUtil {
    public static MethodHandle getPropertyMethod(Object receiver, String method, Class<?> paramType, Class<?> resultType)
            throws NoSuchMethodException, IllegalAccessException {
        MethodType mt = MethodType.methodType(resultType, paramType);
        return MethodHandles.lookup().findVirtual(receiver.getClass(), method, mt).bindTo(receiver);
    }
}
