package com.yss.wealth.infrastructure.advise;

import com.yss.wealth.infrastructure.annotation.FeignApi;
import com.yss.wealth.infrastructure.common.RestfulResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author libihui
 * @version 1.0 2020/1/10
 * @description：为controller层所有方法附加统一返回值格式 设置value绕开swagger文档
 * modify by cxf : @RestControllerAdvice("com.yss.ta") --> @RestControllerAdvice("com.yss") 兼容智能投顾
 */
@RestControllerAdvice("com.yss")
public class RestfulResponseAdvise implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        Method method = methodParameter.getMethod();
        String name = method.getName();
        String message = "请求成功";
        for (noticeMessageEnums messageEnums : noticeMessageEnums.values()) {
            Pattern pattern = Pattern.compile(messageEnums.rex);
            if (pattern.matcher(name).matches()){
                message = messageEnums.message;
                break;
            }
        }
        if (method.isAnnotationPresent(FeignApi.class)) {
            return body;
        }
        if (body == null) {
            RestfulResponse<Object> result = new RestfulResponse<>(body);
            result.setMessage(message);
            return result;
        } else if (body instanceof RestfulResponse) {
            return body;
        } else if (body.getClass().getTypeName().equals("com.win.dfas.common.vo.WinResponseData")) {
            return body;
        } else {
            RestfulResponse<Object> result = new RestfulResponse<>(body);
            result.setMessage(message);
            return result;
        }
    }

    enum noticeMessageEnums {
        ADD(".*(save|insert).*","新增成功"),
        UPDATE(".*(update|edit).*","修改成功"),
        BATCH_DELETE(".*(batchDelete).*","删除成功"),
        DELETE(".*(delete).*","删除成功"),
        BATCH(".*(batch).*","批操作成功"),
        EXPORT(".*(export).","导出成功"),
        IMPORT(".*(import).","导入成功");
        private String rex;
        private String message;

        noticeMessageEnums(String rex, String message) {
            this.rex = rex;
            this.message = message;
        }

        public String getRex() {
            return rex;
        }

        public void setRex(String rex) {
            this.rex = rex;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
