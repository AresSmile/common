package com.yss.wealth.infrastructure.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author:zhuhongmin
 * @date:2021/1/26
 * @description: 线程池配置属性类
 **/
@ConfigurationProperties(prefix = "clear.thread.pool")
public class ClearThreadPoolProperties {

    /**
     * 清算线程池
     */
    private ThreadPoolProperties clearExecutor = new ThreadPoolProperties();

    /**
     * 特殊任务线程池配置
     */
    private ThreadPoolProperties specialExecutor = new ThreadPoolProperties();

    @Data
    public static class ThreadPoolProperties {
        /**
         * 线程任务前缀
         */
        private String prefixName = "clearThread-";
        /**
         * 核心线程数
         */
        private int corePoolSize = 12;
        /**
         * 最大线程数
         */
        private int maximumPoolSize = 32;
        /**
         * 任务队列大小
         */
        private int queueCapacity = Integer.MAX_VALUE;

        /**
         * 线程存活时间（分）
         */
        private int timeOut = 30;

    }

    public ThreadPoolProperties getClearExecutor() {
        return clearExecutor;
    }

    public void setClearExecutor(ThreadPoolProperties clearExecutor) {
        this.clearExecutor = clearExecutor;
    }

    public ThreadPoolProperties getSpecialExecutor() {
        return specialExecutor;
    }

    public void setSpecialExecutor(ThreadPoolProperties specialExecutor) {
        this.specialExecutor = specialExecutor;
    }
}
