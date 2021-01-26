package com.yss.wealth.infrastructure.annotationprocessor;

import com.yss.wealth.infrastructure.annotation.Format;
import com.yss.wealth.infrastructure.util.BeanUtilExtend;

import java.util.List;

/**
 * @author:zhuhongmin
 * @date:2020/7/30
 * @description: Format注解处理器基类
 * @see com.yss.wealth.infrastructure.annotation.Format
 **/
public interface FormatProcessor {

    /**
     * 匹配注解处理器
     *
     * @param type
     * @return
     */
    boolean match(Format.FormatType type);

    /**
     * 格式化字段
     *
     * @param formats
     */
    void format(List<BeanUtilExtend.InnerFormat> formats);


}
