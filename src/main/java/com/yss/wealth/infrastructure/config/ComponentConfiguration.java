package com.yss.wealth.infrastructure.config;

import com.yss.wealth.infrastructure.component.MailService;
import com.yss.wealth.infrastructure.component.SseMessageService;
import com.yss.wealth.infrastructure.util.SpringContextUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* 公共组件配置中心
* @author:zhuhongmin
* @date:2020/6/5
* @description:
**/
@Configuration
public class ComponentConfiguration {
    @Bean
    public SpringContextUtil SpringContextUtil (){
        return new SpringContextUtil();
    }

    @Bean
    public SseMessageService sseMessageService(){
        return new SseMessageService();
    }

    @Bean
    public MailService mailService(){
        return new MailService();
    }
}
