package com.yss.wealth.infrastructure.common.process;

/**
 * @author libihui
 * @version 1.0 2020/9/22
 * @description： 数据检查类业务
 */
public interface CheckService<T, V> {
    /**
     * 业务数据检查
     *
     * @param t
     * @param v
     */
    boolean checkData(T t, V v);

}
