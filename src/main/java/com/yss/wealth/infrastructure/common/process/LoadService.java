package com.yss.wealth.infrastructure.common.process;

/**
 * @author libihui
 * @version 1.0 2020/9/22
 * @description： 数据加载类业务
 */
public interface LoadService<T, V> {
    /**
     * 数据加载
     *
     * @param t 数据加载的查询条件参数
     * @param v 公共加载的数据，实现类数据加载时可能需要
     */
//    V loadData(T t, V... vv);
    default V loadData(T t, V v) {
        return null;
    }

    /**
     * 数据加载
     *
     * @param t 数据加载的查询条件参数
     * @return
     */
    default V loadData(T t) {
        return null;
    }
}
