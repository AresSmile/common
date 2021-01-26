package com.yss.wealth.infrastructure.config;

import com.yss.wealth.infrastructure.common.ClearThreadPoolProperties;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.impl.internal.util.ThreadFactoryUtil;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@AutoConfigureAfter(TaskExecutionAutoConfiguration.class)
@EnableConfigurationProperties(ClearThreadPoolProperties.class)
@Slf4j
public class ThreadPoolExecutorConfiguration {

    @Bean(name = "clearTaskExecutor")
    public ThreadPoolExecutor clearTaskExecutor(ClearThreadPoolProperties properties){
        ClearThreadPoolProperties.ThreadPoolProperties poolProperties = properties.getClearExecutor();
        return new ThreadPoolExecutor(poolProperties.getCorePoolSize(),
                poolProperties.getMaximumPoolSize(),
                poolProperties.getTimeOut(),
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(poolProperties.getQueueCapacity())
                , ThreadFactoryUtil.threadFactory(poolProperties.getPrefixName()), (r, e) -> {
            log.error("清算执行器已满。任务：{}，线程池：{}", r, e);
        });
    }

    @Bean(name = "specialClearTask")
    public ThreadPoolExecutor specialClearTask(ClearThreadPoolProperties properties){
        ClearThreadPoolProperties.ThreadPoolProperties poolProperties = properties.getSpecialExecutor();
        return  new ThreadPoolExecutor(poolProperties.getCorePoolSize(),
                poolProperties.getMaximumPoolSize(),
                poolProperties.getTimeOut(),
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(poolProperties.getQueueCapacity())
                , ThreadFactoryUtil.threadFactory(poolProperties.getPrefixName()), (r, e) -> {
            log.error("特殊清算任务执行器已满。任务：{}，线程池：{}", r, e);
        });
    }
}
