package com.yss.wealth.infrastructure.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.function.BiPredicate;

import static springfox.documentation.schema.Types.isBaseType;

/**
 * @author:zhuhongmin
 * @date:2020/5/6
 * @description:
 **/
public class ObjectUtilExtends extends ObjectUtil {

    public static final String OLD = "old";
    public static final String NEW = "new";

    /**
     * 对比两个对象，返回两个对象不相等同的字段名
     *
     * @param oldObj          原对象
     * @param nowObj          现对象
     * @param parentFieldName
     * @return
     */
    public static List<String> compareObject(Object oldObj, Object nowObj, String parentFieldName) {
        if (!oldObj.getClass().equals(nowObj.getClass())) {
            throw new IllegalArgumentException("对比对象类型不一，无法对比");
        }
        List<String> result = new ArrayList<>();
        Field[] fields = ReflectUtil.getFields(oldObj.getClass());
        for (Field field : fields) {
            Object oldValue = ReflectUtil.getFieldValue(oldObj, field);
            Object nowValue = ReflectUtil.getFieldValue(nowObj, field);

            if (ObjectUtil.isNull(oldValue) && ObjectUtil.isNull(nowValue)) {
                continue;
            }

            if (isBaseObjType(field.getType()) || isBaseType(field.getType().getTypeName())) {
                //如果是基本数据类型
                if (!(ObjectUtil.isNull(nowValue) ? new Object() : nowValue).equals(oldValue)) {
                    if (StringUtil.isNotEmpty(parentFieldName)) {
                        result.add(parentFieldName + "." + field.getName());
                    } else {
                        result.add(field.getName());
                    }
                }
            } else {
                //如果不是基本数据类型
                result.addAll(compareObject(oldValue, nowValue, field.getName()));
            }
        }
        return result;

    }

    private static boolean isBaseObjType(Class clazz) {
        return clazz.equals(Integer.class) ||
                clazz.equals(Byte.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(Double.class) ||
                clazz.equals(Float.class) ||
                clazz.equals(Character.class) ||
                clazz.equals(Short.class) ||
                clazz.equals(Boolean.class) ||
                clazz.equals(List.class) ||
                clazz.equals(Date.class) ||
                clazz.equals(String.class) ||
                clazz.equals(BigDecimal.class) ||
                clazz.equals(Timestamp.class);
    }

    /**
     * 比较两个实体属性值，返回一个map以有差异的属性名为key，value为一个Map分别存oldObj,newObj此属性名的值
     *
     * @param oldObj 进行属性比较的对象1
     * @param newObj 进行属性比较的对象2
     * @return 属性差异比较结果map
     */
    public static Map<String, Map<String, Object>> compareTwoObject(Object oldObj, Object newObj, String[] ignoreFields) throws IllegalAccessException {
        Map<String, Map<String, Object>> diffMap = new LinkedHashMap<>();
        List<String> ignoreFieldList = Arrays.asList(ignoreFields);
        Class<?> clazz1 = oldObj.getClass();
        Class<?> clazz2 = newObj.getClass();
        Field[] fields1 = clazz1.getDeclaredFields();
        Field[] fields2 = clazz2.getDeclaredFields();

        BiPredicate biPredicate = new BiPredicate() {
            @Override
            public boolean test(Object object1, Object object2) {
                if (object1 == null && object2 == null) {
                    return true;
                }
                if (object1 == null && object2 != null) {
                    return false;
                }
                // 特殊类型需要特殊判断, BigDecimal
                if (object1 instanceof BigDecimal && object2 instanceof BigDecimal) {
                    if (object1 == null && object2 == null) {
                        return true;
                    }
                    if (object1 == null ^ object2 == null) {
                        return false;
                    }
                    return ((BigDecimal) object1).compareTo((BigDecimal) object2) == 0;
                }

                return object1.equals(object2);
            }
        };

        for (Field field1 : fields1) {
            for (Field field2 : fields2) {
                if (ignoreFieldList.contains(field1.getName()) || ignoreFieldList.contains(field2.getName())) {
                    continue;
                }
                if (field1.getName().equals(field2.getName())) {
                    field1.setAccessible(true);
                    field2.setAccessible(true);
                    if (!biPredicate.test(field1.get(oldObj), field2.get(newObj))) {
                        Map<String, Object> map = new HashMap<>();
                        map.put(OLD, field1.get(oldObj));
                        map.put(NEW, field2.get(newObj));
                        diffMap.put(field1.getName(), map);
                    }
                }
            }
        }
        return diffMap;
    }

    /**
     * 比较两个实体属性值，返回一个boolean,true则表时两个对象中的属性值有差异
     *
     * @param oldObj 进行属性比较的对象1
     * @param newObj 进行属性比较的对象2
     * @return 属性差异比较结果boolean
     */
    public static boolean compareObjectFieldsValue(Object oldObj, Object newObj, String[] ignoreFields) throws IllegalAccessException {
        Map<String, Map<String, Object>> resultMap = compareTwoObject(oldObj, newObj, ignoreFields);
        return resultMap.size() > 0;
    }

}
