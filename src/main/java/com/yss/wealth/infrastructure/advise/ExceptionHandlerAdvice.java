package com.yss.wealth.infrastructure.advise;

import com.yss.wealth.infrastructure.common.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author libihui
 * @version 1.0 2020/1/10
 * @description：全局统一异常处理
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {
    /**
     * 拦截所有的Exception
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public RestfulResponse<Void> exception(Exception exception, WebRequest request) {
        exception.printStackTrace();
        log.error("系统出现未知异常，请联系管理员！{}，请求地址：{}", exception.getMessage(), ((ServletWebRequest) request).getRequest().getRequestURI(), exception);
        return RestfulResponse.error(ECode.SYSTEM_UNKNOWN_ERROR);
    }

    /**
     * 拦截所有的MessageException
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = MessageException.class)
    public RestfulResponse<Void> messageException(MessageException exception, WebRequest request) {
        log.error("异常信息：{},异常代码：{}", exception.getMessage(), exception.getCode().getCode(), exception);
        return RestfulResponse.error(exception.getCode(), exception.getMessage());
    }

    /**
     * 拦截所有的WarningException
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = WarningException.class)
    public RestfulResponse<Void> warningException(WarningException exception, WebRequest request) {
        log.info("错误提示：{}，错误代码：{}", exception.getMessage(), exception.getCode(), exception);
        return RestfulResponse.warn(exception.getCode(), exception.getMessage());
    }

    /* 拦截所有的NoticeException
     *
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = NoticeException.class)
    public RestfulResponse<Void> warningException(NoticeException exception, WebRequest request) {
        log.info("错误提示：{}，错误代码：{}", exception.getMessage(), exception.getCode(), exception);
        return RestfulResponse.warn(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public RestfulResponse paramValidateErrorHandler(HttpServletRequest req, ConstraintViolationException e) {
        /** 对于统一参数校验的错误信息的获取 */
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            sb.append("Error: " + violation.getPropertyPath() + ":" + violation.getMessage() + "\n");
        }
        String mes = sb.toString();
        String logMsg = e.getConstraintViolations().toString();
        log.error("url={},errormsg={}", req.getRequestURL().toString(), logMsg);
        return RestfulResponse.error(ECode.ARG_ERROR, mes);
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public RestfulResponse benBindErrorHandler(HttpServletRequest req, BindException e) {
        List<ObjectError> errorList = e.getBindingResult().getAllErrors();

        String errorMsg = errorList.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));

        return RestfulResponse.error(ECode.ARG_ERROR, errorMsg);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RestfulResponse paramValidateErrorHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
        List<ObjectError> errorList = e.getBindingResult().getAllErrors();

        String errorMsg = errorList.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));

        return RestfulResponse.error(ECode.ARG_ERROR, errorMsg);
    }



    /**
     * 所有注解了@RequestMapping的方法可获得此键值对
     *
     * @param model
     */
    @ModelAttribute
    public void addAttribute(Model model, WebRequest request) {
        // 这里可添加额外信
//		model.addAttribute("openId", request.getAttribute("openId", RequestAttributes.SCOPE_REQUEST));
//		model.addAttribute("originalAppId", request.getAttribute("originalAppId", RequestAttributes.SCOPE_REQUEST));
    }

    /**
     * 定制WebDataBinder
     *
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields(""); // 这里可指定忽略request中的参数
    }
}
