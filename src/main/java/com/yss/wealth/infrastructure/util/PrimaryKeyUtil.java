package com.yss.wealth.infrastructure.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
*
* @author:zhuhongmin
* @date:2020/4/15
* @description: 主键生成工具
**/
public class PrimaryKeyUtil {
    private static final Logger logger = LoggerFactory.getLogger(PrimaryKeyUtil.class);

    private Long key;

    public Long getKey() {
        return generateId();
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public PrimaryKeyUtil() {
    }

    public static Long generateId() {
        Long id = null;
        Snowflake snowflake = IdUtil.getSnowflake(1L, 1L);
        id = snowflake.nextId();
        return id;
    }
}
