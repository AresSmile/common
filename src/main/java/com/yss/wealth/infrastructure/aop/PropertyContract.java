package com.yss.wealth.infrastructure.aop;

import com.alibaba.fastjson.JSONObject;
import com.yss.wealth.infrastructure.annotation.Property;
import com.yss.wealth.infrastructure.common.IBaseVO;
import com.yss.wealth.infrastructure.common.MessageException;
import com.yss.wealth.infrastructure.common.RestfulResponse;
import com.yss.wealth.infrastructure.util.CollectionUtil;
import com.yss.wealth.infrastructure.util.MethodHandleUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * @description：配合@Property注解使用实现动态微服务之间调用，并设置返回值，避免频繁写相关关联查
 */
@Aspect
public class PropertyContract implements BeanFactoryAware {
    private static final Logger log = LoggerFactory.getLogger(PropertyContract.class);
    private BeanFactory beanFactory = null;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Around("execution(* com.yss.*..domain.mapper..*Mapper.list*(..)) || execution(* com.yss.*..domain.mapper..*Mapper.get*(..))")
    public Object setResult(ProceedingJoinPoint pjp) throws Throwable {
        Object result = pjp.proceed();
        if (result == null) {
            return result;
        }

        Class<?> clz = null;
        Map<String, List<String>> paramList = new HashMap<>();
        Map<String, Class<?>> clzMap = new HashMap<>();
        Map<String, Map<String, List<String>>> paramMap = new HashMap<>();
        if (result instanceof List) {
            List<Object> list = (List<Object>) result;
            //过滤空元素，避免空指针异常
            list = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
            if (list.size() == 0) {
                return result;
            }

            clz = list.get(0).getClass();
            boolean isList = list.size() > 1;
            for (int i = 0; i < list.size(); i++) {
                JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(list.get(i)));
                getParam(clz, json, paramList, paramMap, isList, clzMap);
            }
        } else if (result instanceof IBaseVO) {
            clz = result.getClass();
            JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(result));
            getParam(clz, json, paramList, paramMap, false, clzMap);
        } else {
            return result;
        }

        if (paramList.size() == 0 && paramMap.size() == 0) {
            return result;
        }

        Map<String, Map<String, Object>> resultList = getResultList(paramList, clzMap);
        Map<String, Map<String, Map<String, String>>> resultMap = getResultMap(paramMap, clzMap);
        if (result instanceof List) {
            List<Object> list = (List<Object>) result;
            for (int i = 0; i < list.size(); i++) {
                JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(list.get(i)));
                setResult(clz, json, resultList, resultMap);

                list.set(i, JSONObject.parseObject(json.toJSONString(), clz));
            }

            return list;
        } else if (result instanceof IBaseVO) {
            JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(result));
            setResult(clz, json, resultList, resultMap);

            return JSONObject.parseObject(json.toJSONString(), clz);
        }
        return result;
    }

    private void getParam(Class<?> clz, JSONObject json, Map<String, List<String>> paramList,
                          Map<String, Map<String, List<String>>> paramMap, boolean isList, Map<String, Class<?>> clzMap) {
        Map<Boolean, List<Field>> annoMap = getFieldMap(clz, json);
        if (annoMap == null || annoMap.size() == 0) {
            return;
        }

        List<Field> trueList = annoMap.get(true);
        if (!CollectionUtil.isEmpty(trueList)) {
            Map<String, List<Field>> trueMap = toMap(isList, trueList);
            getParamList(trueMap, json, paramList, clzMap);
        }

        List<Field> falseList = annoMap.get(false);
        if (!CollectionUtil.isEmpty(falseList)) {
            Map<String, List<Field>> falseMap = toMap(isList, falseList);
            getParamMap(falseMap, json, paramMap, clzMap);
        }
    }

    private Map<String, List<Field>> toMap(boolean isList, List<Field> list) {
        return list.stream().filter(f -> !isList || getProperty(f).search())
                .collect(groupingBy(f -> getPropertyKey(f)));
    }

    private void setResult(Class<?> clz, JSONObject json, Map<String, Map<String, Object>> resultList,
                           Map<String, Map<String, Map<String, String>>> resultMap) {
        Map<Boolean, List<Field>> annoMap = getFieldMap(clz, json);
        List<Field> trueList = annoMap.get(true);
        if (!CollectionUtil.isEmpty(trueList)) {
            setListJson(trueList, json, resultList);
        }

        List<Field> falseList = annoMap.get(false);
        if (!CollectionUtil.isEmpty(falseList)) {
            setMapJson(falseList, json, resultMap);
        }
    }

    private Map<Boolean, List<Field>> getFieldMap(Class<?> clz, JSONObject json) {
        List<Field> fieldList = new ArrayList<>();
        while (clz != null) {
            List<Field> list = Stream.of(clz.getDeclaredFields()).filter(f -> {
                if (f.isAnnotationPresent(Property.class)) {
                    String property = getProperty(f).name();
                    String value = json.getString(property);
                    return value != null && !"".equals(value);
                }
                return false;
            }).collect(toList());

            fieldList.addAll(list);
            clz = clz.getSuperclass();
        }

        return fieldList.stream().collect(groupingBy(f -> {
            String other = getProperty(f).other();
            return other == null || "".equals(other);
        }));
    }

    private void getParamList(Map<String, List<Field>> annoMap, JSONObject json, Map<String, List<String>> paramList, Map<String, Class<?>> clzMap) {
        if (annoMap == null || annoMap.size() == 0) {
            return;
        }
        annoMap.forEach((key, value) -> {
            List<String> list = value.stream().map(j -> json.getString(getProperty(j).name())).distinct()
                    .collect(toList());
            if (paramList.containsKey(key)) {
                paramList.get(key).addAll(list);
            } else {
                paramList.put(key, list);
                Class<?> clz = getProperty(value.get(0)).realize();
                clzMap.put(key, clz);
            }
        });

    }

    private void getParamMap(Map<String, List<Field>> annoMap, JSONObject json,
                             Map<String, Map<String, List<String>>> paramMap, Map<String, Class<?>> clzMap) {
        if (annoMap == null || annoMap.size() == 0) {
            return;
        }
        annoMap.forEach((key, value) -> {
            Map<String, List<String>> map = value.stream().collect(groupingBy(f -> getProperty(f).other(),
                    mapping(f -> json.getString(getProperty(f).name()), toList())));

            if (paramMap.containsKey(key)) {
                Map<String, List<String>> pmap = paramMap.get(key);
                map.forEach((k, v) -> {
                    if (pmap.containsKey(k)) {
                        pmap.get(k).addAll(v);
                    } else {
                        pmap.put(k, v);
                    }
                });
            } else {
                paramMap.put(key, map);
                Class<?> clz = getProperty(value.get(0)).realize();
                clzMap.put(key, clz);
            }
        });
    }

    private Map<String, Map<String, Object>> getResultList(Map<String, List<String>> paramList, Map<String, Class<?>> clzMap) {
        Map<String, Map<String, Object>> result = new HashMap<>();
        if (paramList == null || paramList.size() == 0) {
            return result;
        }
        paramList.forEach((key, value) -> {
            String[] keyArr = key.split("::");
            Object i = beanFactory.getBean(clzMap.get(key));
            MethodHandle md = null;
            try {
                md = MethodHandleUtil.getPropertyMethod(i, keyArr[1], String.class, Map.class);
            } catch (NoSuchMethodException e) {
                log.error("未匹配到类：{}的方法：{}，请确认类名、方法名以及参数是否正确！", i.getClass().getSimpleName(), keyArr[1]);
                throw new MessageException(e.getMessage());
            } catch (IllegalAccessException e) {
                log.error("没有访问类：{}的方法：{}的权限！", i.getClass().getSimpleName(), keyArr[1]);
                throw new MessageException(e.getMessage());
            }

            String ids = value.stream().distinct().collect(joining(","));
            try {
                Map<String, Object> resultMap = (Map<String, Object>) md.invokeExact(ids);
                result.put(key, resultMap);
            } catch (Throwable e) {
                log.error("调用类：{}的方法：{}出错！", i.getClass().getSimpleName(), keyArr[1]);
                throw new MessageException(e.getMessage());
            }
        });

        return result;
    }

    private Map<String, Map<String, Map<String, String>>> getResultMap(
            Map<String, Map<String, List<String>>> paramMap, Map<String, Class<?>> clzMap) {
        Map<String, Map<String, Map<String, String>>> result = new HashMap<>();
        if (paramMap == null || paramMap.size() == 0) {
            return result;
        }
        paramMap.forEach((key, value) -> {
            String[] keyArr = key.split("::");
            Object i = beanFactory.getBean(clzMap.get(key));

            MethodHandle md = null;
            try {
                md = MethodHandleUtil.getPropertyMethod(i, keyArr[1], String[].class, Map.class);
            } catch (NoSuchMethodException e) {
                log.error("未匹配到类：{}的方法：{}，请确认类名、方法名以及参数是否正确！", i.getClass().getSimpleName(), keyArr[1]);
                throw new MessageException(e.getMessage());
            } catch (IllegalAccessException e) {
                log.error("没有访问类：{}的方法：{}的权限！", i.getClass().getSimpleName(), keyArr[1]);
                throw new MessageException(e.getMessage());
            }
            try {
                //暂时查询选定数据字典所有下拉选项，不考虑过滤用户指定选项了
                Map<String, Map<String, String>> resultMap = (Map<String, Map<String, String>>) md.invokeExact(value.keySet().toArray(new String[value.size()]));
                result.put(key, resultMap);
            } catch (Throwable e) {
                log.error("调用类：{}的方法：{}出错!", i.getClass().getSimpleName(), keyArr[1]);
                throw new MessageException(e.getMessage());
            }
        });

        return result;
    }

    private void setListJson(List<Field> fieldList, JSONObject json, Map<String, Map<String, Object>> resultList) {
        if (resultList == null || resultList.size() == 0) {
            return;
        }
        resultList.forEach((key, value) -> {
            Object resultKey = value.keySet().iterator().next();
            fieldList.stream().filter(f -> key.equals(getPropertyKey(f))).forEach(e -> {
                Object property = json.getObject(getProperty(e).name(), resultKey.getClass());
                Object result = value.get(property);
                if (result instanceof List && IBaseVO.class.isAssignableFrom(e.getType())) {
                    List<Object> obList = (List<Object>) result;
                    json.put(e.getName(), obList.get(0));
                } else {
                    json.put(e.getName(), result);
                }
            });
        });
    }

    private void setMapJson(List<Field> fieldList, JSONObject json,
                            Map<String, Map<String, Map<String, String>>> resultMap) {
        if (resultMap == null || resultMap.size() == 0) {
            return;
        }
        resultMap.forEach((key, value) -> {
            fieldList.stream().filter(f -> key.equals(getPropertyKey(f))).forEach(e -> {
                Map<String, String> map = value.get(getProperty(e).other());
                if (map != null && map.size() > 0) {
                    json.put(e.getName(), map.get(json.getString(getProperty(e).name())));
                }
            });
        });
    }

    private Property getProperty(Field f) {
        return f.getAnnotation(Property.class);
    }

    private String getPropertyKey(Field f) {
        String realize = getProperty(f).realize().getSimpleName();
        if (realize == null || "".equals(realize)) {
            realize = "basicFeignClient";
        }
        String method = getProperty(f).method();
        if (method == null || "".equals(method)) {
            method = "getDictionaryMap";
        }

        return realize + "::" + method;
    }
}