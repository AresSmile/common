package com.yss.wealth.infrastructure.util;

import com.yss.wealth.infrastructure.common.WarningException;
import org.apache.poi.ss.formula.functions.T;

import java.util.*;

/**
 * @author libihui
 * @version 1.0 2020/3/10
 * @description：集合工具类
 */
public class CollectionUtil {
    /**
     * 集合为空或size为0
     *
     * @param collection
     * @return
     */
    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map == null || map.size() == 0;
    }

    public static <T> boolean isNotEmpty(Collection<T> collection) {
        return !isEmpty(collection);
    }

    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !isEmpty(map);
    }

    /**
     * 等分list
     *
     * @param source 原list
     * @param n      等分成N份
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remainder = source.size() % n;  //(先计算出余数)
        int number = source.size() / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }


    /**
     * 等分list
     *
     * @param source 源list
     * @param n      每份n个
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> dividedList(List<T> source, int n) {
        if (CollectionUtil.isEmpty(source)) {
            throw new WarningException("等分数组未空，无法等分", "500");
        }
        if (n == 0) {
            throw new WarningException("等分数不能为0", "500");
        }
        return averageAssign(source, source.size() % n == 0 ? source.size() / n : source.size() / n + 1);
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as", "as");
        List<List<String>> lists = dividedList(strings, 3);
        System.out.println(lists);
    }


}
