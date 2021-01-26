package com.yss.wealth.infrastructure.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {
    public static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context  = applicationContext;
    }

    public static <T> T getBean(Class<T> tClass){
        return context.getBean(tClass);
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }
}
