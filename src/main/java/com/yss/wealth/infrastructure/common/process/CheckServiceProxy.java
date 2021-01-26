package com.yss.wealth.infrastructure.common.process;

/**
 * @author libihui
 * @version 1.0 2020/9/22
 * @description：数据检查业务代理类
 */
public abstract class CheckServiceProxy<T, V> implements CheckService<T, V> {
    //数据检查子类
    protected CheckService checkService;

    @Override
    public boolean checkData(T t, V v) {
        boolean result = checkAppData(t, v);
        if (checkService == null || !result) {
            //业务无特有数据检查逻辑，或公共检查未通过，返回公共检查结果
            return result;
        }

        //具体业务特有数据检查及相关逻辑
        return checkService.checkData(t, v);
    }

    /**
     * 公共数据检查
     *
     * @param t
     * @param v
     * @return
     */
    public abstract boolean checkAppData(T t, V v);

    public void setCheckService(CheckService checkService) {
        this.checkService = checkService;
    }
}
