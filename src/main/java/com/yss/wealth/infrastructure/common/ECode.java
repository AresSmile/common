package com.yss.wealth.infrastructure.common;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * 统一返回提示信息
 */
public enum ECode {
    /**
     * 正常
     */
    SUCCESS("200", "请求成功"),

    /**
     * 缺失参数
     */
    ARG_ERROR("1001", "缺失参数"),

    /**
     * 查询异常
     */
    QUEERY_ERROR("1002", "查询异常"),

    /**
     * 更新异常
     */
    UPDATE_ERROR("1003", "更新异常"),

    /**
     * 新增异常
     */
    ADD_ERROR("1004", "新增异常"),

    /**
     * 删除异常
     */
    DELETE_ERROR("1005", "删除异常"),

    /**
     * 未授权
     */
    UNAUTHORIZED("1006", "未授权"),

    /**
     * 不支持的编码
     */
    UN_SUPPORTED_ENCODING("1007", "不支持的编码"),

    /**
     * 无效的URL
     */
    MALFORMED_URL("1008", "无效的URL"),

    /**
     * DAO异常
     */
    FEIGN_ERROR("1010", "FEIGN请求异常"),

    /**
     * DAO异常
     */
    REMOTE_ERROR("1011", "远程请求异常"),

    /**
     * DAO异常
     */
    DAO_ERROR("1012", "DAO异常"),

    /**
     * 未知异常
     */
    SYSTEM_UNKNOWN_ERROR("1013", "系统出现未知异常，请与管理员联系"),

    NO_DATA_RESULT("1014", "未查询到数据"),

    NOT_LOGGED_IN("1015", "未登录"),

    WARNING("1016", ""),

    REQUEST_TIMEOUT("2000","请求超时");

    /**
     * 返回code
     */
    private final String code;

    /**
     * 提示信息
     */
    private final String message;

    /**
     * 构造函数
     *
     * @param code    code
     * @param message message
     */
    ECode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
