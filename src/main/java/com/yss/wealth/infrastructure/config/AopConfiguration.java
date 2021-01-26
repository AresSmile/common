package com.yss.wealth.infrastructure.config;

import com.yss.wealth.infrastructure.aop.*;
import com.yss.wealth.infrastructure.util.SpringContextUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * @description：统一加入自动配置的配置类
 */
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class AopConfiguration {

    @ConditionalOnMissingBean
    @Bean
    public ParameterContract insertParameterContract() { return new ParameterContract(); }

    @ConditionalOnMissingBean
    @Bean
    public PropertyContract propertyContract() {
        return new PropertyContract();
    }

    @ConditionalOnMissingBean
    @Bean
    public SysLogContract syslogContract() {
        return new SysLogContract();
    }

    @ConditionalOnMissingBean
    @Bean
    public CompareSymbolContract compareSymbolContract() {
        return new CompareSymbolContract();
    }

    @ConditionalOnMissingBean
    @Bean
    public DatabaseCostTimeMoniter databaseCostTimeMoniter() {
        return new DatabaseCostTimeMoniter();
    }


}
