package com.yss.wealth.infrastructure.common;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * @description：Controller 方法统一返回值
 */
@ApiModel
public class RestfulResponse<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7115914438015603229L;

    /**
     * 默认响应
     */
    public static final String DEFAULT_CODE = "200";

    /**
     * 响应�?
     */
    private String code = DEFAULT_CODE;

    /**
     * 成功与否标志，接口成功，但是需要提供像关系
     */
    private Boolean success;

    /**
     * 数据
     */
    private T data;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 构�?�函�?
     */
    public RestfulResponse() {
        this(null, ECode.SUCCESS);
    }

    /**
     * 构�?�函�?
     *
     * @param data 返回数据
     */
    public RestfulResponse(T data) {
        this(data, null);
    }

    /**
     * 构�?�函�?
     *
     * @param code code
     */
    public RestfulResponse(ECode code) {
        this(null, code);
    }

    /**
     * 构�?�函�?
     *
     * @param code code
     */
    public RestfulResponse(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
        this.success = isSuccess();
    }

    /**
     * 构�?�函�?
     *
     * @param data data
     * @param code code
     */
    public RestfulResponse(T data, ECode code) {
        this.data = data;
        if (code != null) {
            this.code = code.getCode();
            this.message = code.getMessage();
        } else {
            this.code = ECode.SUCCESS.getCode();
            this.message = ECode.SUCCESS.getMessage();
        }
        this.success = isSuccess();
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    /**
     * @param <T>  <T>
     * @param code code
     * @return T>
     */
    public static <T> RestfulResponse<T> error(ECode code) {
        RestfulResponse<T> resp = new RestfulResponse<T>(code);
        return resp;
    }

    /**
     * @param message message
     * @return RestfulResponse;
     */
    public static RestfulResponse<Void> error(String message) {
        RestfulResponse<Void> response = new RestfulResponse<Void>();
        response.setSuccess(response.isSuccess());
        return response.message(message);
    }

    public static RestfulResponse<Void> error(ECode code, String message) {
        RestfulResponse<Void> resp = new RestfulResponse<Void>(code);
        resp.setMessage(message);
        resp.setSuccess(resp.isSuccess());
        return resp;
    }

    public static RestfulResponse<Void> warn(String code, String message) {
        RestfulResponse<Void> resp = new RestfulResponse<Void>(code, message);
        resp.setSuccess(resp.isSuccess());
        return resp;
    }
    public boolean isSuccess(){
        return ECode.SUCCESS.getCode().equals(this.getCode());
    }

    /**
     * @param code code
     * @return this
     */
    public RestfulResponse<T> code(String code) {
        this.code = code;
        return this;
    }

    /**
     * @param messagex message
     * @return this
     */
    public RestfulResponse<T> message(String messagex) {
        this.message = messagex;
        return this;
    }

    /**
     * @param datax data
     * @return this
     */
    public RestfulResponse<T> data(T datax) {
        this.data = datax;
        return this;
    }

    /**
     * @param success data
     * @return this
     */
    public RestfulResponse<T> success(Boolean success) {
        this.success = success;
        return this;
    }

    /**
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     */
    public T getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
