package com.yss.wealth.infrastructure.common.process;

import cn.hutool.core.util.ObjectUtil;
import com.yss.wealth.infrastructure.util.BeanUtilExtend;

/**
 * @author libihui
 * @version 1.0 2020/9/22
 * @description：数据加载业务代理类
 */
public abstract class LoadServiceProxy<T, V> implements LoadService<T, V> {
    //数据加载子类
    protected LoadService loadService;

    //数据检查代理类
    protected CheckServiceProxy checkServiceProxy;

    @Override
    public V loadData(T t) {
        // v - 加载的原公共数据(返回值是父类)
        V v = loadAppData(t);
        if (loadService != null) {
            // v1 - 加载自身业务需要的特殊数据（返回值是子类）
            V v1 = (V) loadService.loadData(t);
            if (ObjectUtil.isEmpty(v1)) {
                v1 = (V) loadService.loadData(t, v);
            }

            if (ObjectUtil.isNotEmpty(v) && ObjectUtil.isNotEmpty(v1)) {
                // 组合加载数据
                BeanUtilExtend.copyProperties(v1, v);
            }else if (ObjectUtil.isEmpty(v) && ObjectUtil.isNotEmpty(v1)) {
                v = v1;
            }
        }

        if (checkServiceProxy != null) {
            //做业务数据校验
            checkServiceProxy.checkData(t, v);
        }
        return v;
    }

    /**
     * 公共数据加载
     *
     * @param t 公共数据加载的参数
     */
    public abstract V loadAppData(T t);

    public void setLoadService(LoadService loadService) {
        this.loadService = loadService;
    }

    public void setLoadService(LoadService loadService, CheckServiceProxy checkServiceProxy) {
        this.loadService = loadService;
        this.checkServiceProxy = checkServiceProxy;
    }
}
