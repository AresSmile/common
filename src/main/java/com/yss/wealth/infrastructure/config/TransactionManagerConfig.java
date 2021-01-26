/****************************************************
 * 创建人：     @author hechengcheng    
 * 创建时间: 2020年1月9日/下午5:07:32
 * 项目名称：  dfas-common-util
 * 文件名称: TransactionManagerConfig.java
 * 文件描述: @Description: TODO(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2020
 *
 ********************************************************/
package com.yss.wealth.infrastructure.config;

import com.yss.wealth.infrastructure.common.NoticeException;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 包名称： com.win.dfas.common.config
 * 类名称：TransactionManagerConfig
 * 类描述：事物管配置
 * 创建人：@author hechengcheng
 * 创建时间：2020年1月9日/下午5:07:32
 */
@Configuration
public class TransactionManagerConfig {

    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.yss.*..application.service..*(..))";

    @Autowired
    private PlatformTransactionManager transactionManager;

    /**
     * @return
     * @throws @author: hechengcheng
     * @Title: txAdvice
     * @Description: 事物配置
     * @return: TransactionInterceptor
     * @Date: 2020年1月9日/下午5:20:36
     */
    @Bean
    public TransactionInterceptor txAdvice() {

        // 事物管理规则
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();

        // 只读事物
        RuleBasedTransactionAttribute readOnlyRule = new RuleBasedTransactionAttribute();

        readOnlyRule.setReadOnly(true);

        // PROPAGATION_NOT_SUPPORTED事务传播级别, 以非事务运行, 如果当前存在事务，则把当前事务挂起
        readOnlyRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);

        // 写事物
        RuleBasedTransactionAttribute requireRule = new RuleBasedTransactionAttribute();

        // 抛出异常后执行切点回滚
        requireRule.setRollbackRules(Arrays.asList(new RollbackRuleAttribute(Exception.class),
                new NoRollbackRuleAttribute(NoticeException.class)));

        // 若当前存在事务, 则加入该事务; 如果当前没有事务, 则创建一个新的事务
        requireRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        // 设置事物方法
        Map<String, TransactionAttribute> txMap = new HashMap<String, TransactionAttribute>();

        txMap.put("get*", readOnlyRule);
        txMap.put("list*", readOnlyRule);
        txMap.put("pageList*", readOnlyRule);
        txMap.put("count*", readOnlyRule);
        txMap.put("export*", readOnlyRule);
        txMap.put("save*", requireRule);
        txMap.put("delete*", requireRule);
        txMap.put("update*", requireRule);
        txMap.put("batchSave*", requireRule);
        txMap.put("batchDelete*", requireRule);
        txMap.put("import*", requireRule);
        txMap.put("check*", requireRule);

        source.setNameMap(txMap);

        TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, source);

        return txAdvice;
    }

    /**
     * @return
     * @throws @author: hechengcheng
     * @Title: txAdviceAdvisor
     * @Description: 设置切面(切点 + 通知)
     * @return: Advisor
     * @Date: 2020年1月9日/下午5:23:04
     */
    @Bean
    public Advisor txAdviceAdvisor() {

        // 声明切点的面
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

        // 声明和设置需要拦截的方法
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);

        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}
