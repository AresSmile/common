package com.yss.wealth.infrastructure.util;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.yss.wealth.infrastructure.constant.RequestConstants.*;

/**
 * @author:zhuhongmin
 * @date:2020/4/9
 * @description:
 **/
public class RequestUtil {
    public RequestUtil() {
    }

    public static String getIp() {
        HttpServletRequest request = getRequest();
        return ObjectUtil.isNotNull(request) ? request.getHeader("ip") : null;
    }

    public static String getMac() {
        HttpServletRequest request = getRequest();
        return ObjectUtil.isNotNull(request) ? request.getHeader(HEADER_USER_MAC) : null;
    }

    public static String getUserCode() {
        Map userMap = getUserMap();
        return ObjectUtil.isNotNull(userMap) ? (String) userMap.get("userCode") : "system";
    }

    private static Map getUserMap() {
        HttpServletRequest request = getRequest();
        String user = ObjectUtil.isNotNull(request) ? request.getHeader(HEADER_USER_KEY) : null;
        if (ObjectUtil.isNull(user)) {
            return null;
        }
        return JSONObject.parseObject(user, Map.class);
    }


    public static String getReqMenuId() {
        HttpServletRequest request = getRequest();
        return ObjectUtil.isNotNull(request) ? request.getHeader(HEADER_USER_MENU) : null;
    }

    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return ObjectUtil.isNull(requestAttributes) ? null : ((ServletRequestAttributes) requestAttributes).getRequest();
    }


    public static String getRole() {
        Map userMap = getUserMap();
        return ObjectUtil.isNotNull(userMap) ? (String) userMap.get("workingRoleCode") : null;
    }

    public static String getRequireUrl() {
        HttpServletRequest request = getRequest();
        return ObjectUtil.isNotNull(request) ? request.getRequestURI() : null;
    }
}
