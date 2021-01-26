package com.yss.wealth.infrastructure.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author libihui
 * @version 1.0 2020/1/19
 * @description：类型转换基类
 */
@Slf4j
public class BeanConvert {
    /**
     * 通过浅拷贝实现类型转换
     *
     * @param source
     * @param clz
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> T convert(S source, Class<?> clz) {
        Optional.ofNullable(source).orElseThrow(() -> new MessageException("类型转换失败，原类型值为空！"));
        Function<S, T> c = d -> {
            T v = null;
            try {
                v = (T) clz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }

            BeanUtils.copyProperties(d, v);
            return v;
        };

        return c.apply(source);
    }

    /**
     * 通过json实现类型转换
     *
     * @param source
     * @param clz
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> T convertWithJson(S source, Class<?> clz) {
        Optional.ofNullable(source).orElseThrow(() -> new MessageException("类型转换失败，原类型值为空！"));
        return (T) JSONObject.parseObject(JSONObject.toJSONString(source), clz);
    }

    /**
     * 列表类型转换
     *
     * @param sourceList
     * @param clz
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> convertList(List<S> sourceList, Class<?> clz) {
        if (sourceList == null || sourceList.size() == 0) {
            throw MessageException.builder().message("类型转换失败，原类型值为空！").build();
        }

        return (List<T>) JSONArray.parseArray(JSONArray.toJSONString(sourceList), clz);
    }

    /**
     * 对象值合并
     *
     * @param s
     * @param t
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> T merge(S s, T t) {
        JSONObject sJson = JSONObject.parseObject(JSONObject.toJSONString(s));
        JSONObject tJson = JSONObject.parseObject(JSONObject.toJSONString(t));
        tJson.putAll(sJson);

        return (T) JSONObject.parseObject(tJson.toJSONString(), t.getClass());
    }
}
