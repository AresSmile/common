package com.yss.wealth.infrastructure.common.process;

/**
 * @author libihui
 * @version 1.0 2020/9/22
 * @description：数据处理业务代理类
 */
public abstract class HandleServiceProxy<T, E> implements HandleService<T, E> {
    //数据检查子类
    protected HandleService handleService;

    @Override
    public void handleData(T t, E e) {
        handleAppData(t, e);
        if (handleService == null) {
            //业务无特有数据处理逻辑
            return;
        }

        // 具体业务特有数据处理及相关逻辑
        handleService.handleData(t, e);
    }

    /**
     * 公共数据处理
     *
     * @param t
     * @param e
     * @return
     */
    public abstract void handleAppData(T t, E e);

    public void setHandleService(HandleService handleService) {
        this.handleService = handleService;
    }
}
