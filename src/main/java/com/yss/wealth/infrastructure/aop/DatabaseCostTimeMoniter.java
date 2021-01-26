package com.yss.wealth.infrastructure.aop;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class DatabaseCostTimeMoniter {

    @Around("execution(* com.yss.*..domain.mapper..*Mapper.*(..))")
    public Object doDao(final ProceedingJoinPoint joinPoint) throws Throwable {
        long l = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();
        log.info("数据库操作记录，方法名称：{},耗时：{}", joinPoint.getSignature().getDeclaringTypeName().concat(".").concat(joinPoint.getSignature().getName()), System.currentTimeMillis() - l);
        return proceed;

    }
}
