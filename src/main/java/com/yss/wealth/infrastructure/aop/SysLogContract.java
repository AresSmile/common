package com.yss.wealth.infrastructure.aop;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.alibaba.fastjson.JSONObject;
import com.yss.wealth.infrastructure.common.SysLogDto;
import com.yss.wealth.infrastructure.constant.MqConst;
import com.yss.wealth.infrastructure.util.RequestUtil;
import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:zhuhongmin
 * @date:2020/4/10
 * @description: 系统日志AOP拦截
 **/
@Aspect
@Log
public class SysLogContract {
    @Autowired
    private AmqpTemplate mqTemplate;
    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Around("execution(* com.yss.*..interfaces.facade..*Controller.*(..))")
    public Object log(final ProceedingJoinPoint joinPoint) {
        Object returnObj = null;
        long start = System.currentTimeMillis();
        Signature signature = joinPoint.getSignature();
        SysLogDto sysLogDto = new SysLogDto();
        sysLogDto.setUserCode(RequestUtil.getUserCode())
                .setMac(RequestUtil.getMac())
                .setUrl(RequestUtil.getRequireUrl())
                .setClassName(signature.getDeclaringTypeName())
                .setMethodName(signature.getName())
                .setStartDateTime(new Date());
        boolean executeFlag = true;
        try {
            List<Object> args = new ArrayList<>();
            for (Object arg : joinPoint.getArgs()) {
                //排除无法序列化的对象
                if (arg instanceof MultipartFile
                        || arg instanceof ServletResponse
                        || arg instanceof ServletRequest) {
                } else {
                    args.add(arg);
                }
            }
            sysLogDto.setParam(JSONObject.toJSONString(args))
                    .setStatus(true);
            returnObj = joinPoint.proceed();
            executeFlag = false;
        } catch (Throwable throwable) {
            sysLogDto.setStatus(false);
            sysLogDto.setErrorMsg(ExceptionUtil.stacktraceToString(throwable));
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException) throwable;
            }
            throw new RuntimeException(throwable);

        } finally {
            if (executeFlag) {
                //如果失败异常了
                sysLogDto.setEndDateTime(new Date())
                        .setCostMillis(System.currentTimeMillis() - start);
/*                executor.execute(() -> {
                    mqTemplate.convertAndSend(MqConst.SYS_LOG_KEY, JSONObject.toJSONString(sysLogDto));
                });*/
            }
        }

        //成功
        sysLogDto.setEndDateTime(new Date())
                .setCostMillis(System.currentTimeMillis() - start);
        sysLogDto.setReturnObj(JSONObject.toJSONString(returnObj));
/*        executor.execute(() -> {
            mqTemplate.convertAndSend(MqConst.SYS_LOG_KEY, JSONObject.toJSONString(sysLogDto));
        });*/
        return returnObj;
    }

}
