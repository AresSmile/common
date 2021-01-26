package com.yss.wealth.infrastructure.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.yss.wealth.infrastructure.common.MessageException;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author:zhuhongmin
 * @date:2020/6/16
 * @description: 断言工具类
 **/
public class Assert {

    public static <T> void notNull(T object) {
        if (object == null) {
            throw new MessageException("对象不能为空");
        }
    }

    public static <T> void notNull(T object, String errorMessageTemplate, Object... params) {
        if (object == null) {
            throw new MessageException(StrUtil.format(errorMessageTemplate, params));
        }
    }


    public static <T> void notEmpty(String string, String errorMessageTemplate, Object... params) {
        if (StringUtil.isEmpty(string)) {
            throw new MessageException(StrUtil.format(errorMessageTemplate, params));
        }
    }
    public static <T> void notEmpty(Collection<?> collection, String errorMessageTemplate, Object... params) {
        if (CollectionUtil.isEmpty(collection)) {
            throw new MessageException(StrUtil.format(errorMessageTemplate, params));
        }
    }

    public static void isTrue(Boolean condition, String errorMessageTemplate, Object... params) {
        if (condition) {
            throw new MessageException(StrUtil.format(errorMessageTemplate, params));
        }
    }

    public static void isFalse(Boolean condition, String errorMessageTemplate, Object... params) {
        if (condition) {
            throw new MessageException(StrUtil.format(errorMessageTemplate, params));
        }
    }

    public static void notEmptyMap(Map map, String errorMessageTemplate, Object... params) {
        if (MapUtil.isEmpty(map)) {
            throw new MessageException(StrUtil.format(errorMessageTemplate, params));
        }
    }

}
