package com.yss.wealth.infrastructure.common;

/**
 * @author libihui
 * @version 1.0 2020/3/11
 * @description： 全局MQ队列名
 */
public interface IRabbitQueue {
    /**
     * 简单清空redis缓存的消息队列，消费端放调度域
     */
    String REDIS_CLEAR_QUEUE = "REDIS_CLEAR_QUEUE";
}
