package com.yss.wealth.infrastructure.aop;

import com.yss.wealth.infrastructure.annotation.Symbol;
import com.yss.wealth.infrastructure.common.ECode;
import com.yss.wealth.infrastructure.common.MessageException;
import com.yss.wealth.infrastructure.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author xuanfei.Chen
 * @description 比较符号协议。数据字典compare_symbol。查询入参的比较符号自动转换
 * @date 2020/5/11 11:01
 */
@Aspect
public class CompareSymbolContract {
    @Before("execution(* com.yss.*..interfaces.facade..*Controller.list*(..))")
    public void convertSymbol(final JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();

        //遍历参数 修改带有需求字段对象的值
        for (Object obj : args) {
            try{
                //跳过空参数的校验
                if(Objects.isNull(obj)) {
                    continue;
                }
                Class<?> resultClz = obj.getClass();
                //获取class里的所有字段  父类字段获取不到
                Field[] fieldInfo = resultClz.getDeclaredFields();
                for (Field field : fieldInfo) {
                    if(field.isAnnotationPresent(Symbol.class)){
                        field.setAccessible(true);
                        //原属性值
                        String fieldValue = (String)field.get(obj);
                        if(StringUtil.isNotEmpty(fieldValue)){
                            field.set(obj, switchMethod(fieldValue));
                        }
                    }
                }
            }catch (Exception e) {
                throw MessageException.builder().message("转换入参错误").code(ECode.QUEERY_ERROR).build();
            }
        }
    }

    private String switchMethod(String symbol) {
        switch (symbol) {
            case "≥":
                return ">=";
            case "≤":
                return "<=";
            default:
                return symbol;
        }
    }

}
