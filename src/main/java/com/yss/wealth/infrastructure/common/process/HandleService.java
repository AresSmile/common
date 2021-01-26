package com.yss.wealth.infrastructure.common.process;

/**
 * @author libihui
 * @version 1.0 2020/9/22
 * @description： 数据处理业务
 */
public interface HandleService<T, E> {
    /**
     * 处理业务数据
     *
     * @param t
     */
    void handleData(T t, E e);
}
