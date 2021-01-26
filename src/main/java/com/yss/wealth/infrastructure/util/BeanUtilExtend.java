package com.yss.wealth.infrastructure.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.yss.wealth.infrastructure.annotation.DicFormat;
import com.yss.wealth.infrastructure.annotation.Format;
import com.yss.wealth.infrastructure.annotation.WinExcelTemplateDic;
import com.yss.wealth.infrastructure.annotationprocessor.FormatProcessors;
import com.yss.wealth.infrastructure.common.NewPageInfo;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class BeanUtilExtend extends BeanUtil {
    private static Logger logger = LoggerFactory.getLogger(BeanUtilExtend.class);
    private static StringRedisTemplate redisTemplate;
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 36, 30, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2048));

    static {
        redisTemplate = SpringContextUtil.getBean(StringRedisTemplate.class);
    }

    /**
     * 复制拷贝分页对象
     *
     * @param sourcePage
     * @param tClass
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> NewPageInfo<T> copyPageInfo(PageInfo sourcePage, Class<T> tClass) throws Exception {
        NewPageInfo<T> resultPageInfo = new NewPageInfo<>();
        copyProperties(sourcePage, resultPageInfo);
        resultPageInfo.setList(copyList(sourcePage.getList(), tClass, false));
        return resultPageInfo;
    }

    /**
     * 复制拷贝分页对象
     *
     * @param sourcePage
     * @param tClass
     * @param <T>
     * @param formatFlag 是否格式化
     * @return
     * @throws Exception
     */
    public static <T> NewPageInfo<T> copyPageInfo(PageInfo sourcePage, Class<T> tClass, boolean formatFlag) throws Exception {
        NewPageInfo<T> resultPageInfo = new NewPageInfo<>();
        copyProperties(sourcePage, resultPageInfo);
        resultPageInfo.setList(copyList(sourcePage.getList(), tClass, formatFlag));
        return resultPageInfo;
    }

    /**
     * 复制拷贝对象
     *
     * @param source
     * @param tClass
     * @param <T>
     * @param formatFlag 是否格式化
     * @return
     * @throws Exception
     */
    public static <T> T copySingleObject(Object source, Class<T> tClass, boolean formatFlag) throws Exception {
        T t = tClass.newInstance();
        if (Objects.isNull(source)) {
            return t;
        }
        copyProperties(source, t);
        if (formatFlag) {
            format(t);
        }
        return t;
    }


    /**
     * 拷贝复制List对象
     *
     * @param sourceList
     * @param tClass
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> copyList(List sourceList, Class<T> tClass, boolean formatFlag) throws Exception {
        List<T> resultList = new ArrayList<>();
        if (CollectionUtil.isEmpty(sourceList)) {
            return resultList;
        }
        for (Object o : sourceList) {
            T t = tClass.newInstance();
            copyProperties(o, t);
            resultList.add(t);
        }
        return formatFlag ? formatList(resultList) : resultList;
    }

    /**
     * 格式化列表（主要是为了解释注解）
     *
     * @param sourceList
     * @param <T>
     * @return
     */
    public static <T> List<T> formatList(List<T> sourceList) {
        long l = System.currentTimeMillis();
        if (CollectionUtil.isEmpty(sourceList)) {
            return sourceList;
        }
        Map<Format.FormatType, List<InnerFormat>> formats = new HashMap<>();
        sourceList.forEach(s -> {
            Map<Format.FormatType, List<Field>> collect = Arrays.stream(ReflectUtil.getFields(s.getClass())).filter(f -> ObjectUtil.isNotNull(f.getAnnotation(Format.class))).collect(Collectors.groupingBy(field -> field.getAnnotation(Format.class).type()));
            collect.forEach((k, v) -> {
                if (CollectionUtil.isEmpty(formats.get(k))) {
                    List<InnerFormat> list = new ArrayList<>();
                    list.add(InnerFormat.builder().obj(s).fields(v).build());
                    formats.put(k, list);
                } else {
                    formats.get(k).add(InnerFormat.builder().obj(s).fields(v).build());
                }
            });
        });
        //解释注解Format（多线程执行）
        CountDownLatch latch = new CountDownLatch(formats.size());
        formats.forEach((k, v) -> {
            executor.execute(() -> {
                try {
                    FormatProcessors.process(k, v);
                } finally {
                    //无论如何都得countDown下去，否则主线程无法结束
                    latch.countDown();
                }
            });
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            logger.warn("线程被意外中断");
        }
        long millis = System.currentTimeMillis();
        logger.info("跨服务关联查询耗时:{}", millis - l);
        //格式化字典值
        formatListDic(sourceList);
        logger.info("字典格式化耗时:{}", System.currentTimeMillis() - millis);
        return sourceList;
    }

    @Data
    @Builder
    public static class InnerFormat {
        /**
         * 需要格式化的对象
         */
        private Object obj;
        /**
         * 需要格式化的变量
         */
        private List<Field> fields;
    }

    /**
     * 格式化单个对象
     *
     * @param object
     */
    public static void format(Object object) {
        formatList(Lists.newArrayList(object));
    }

    /**
     * 格式化字典值
     *
     * @param objects
     * @param <T>
     */
    public static <T> void formatListDic(List<T> objects) {
        if (CollectionUtil.isEmpty(objects)) {
            return;
        }
        Map<String, Map<String, String>> dicKeyValue = getDicKeyValueMap(objects.get(0).getClass());
        objects.forEach(o -> {
            List<Field> dicFormatList = getFieldByAnno(o.getClass(), DicFormat.class);
            for (Field field : dicFormatList) {
                DicFormat annotation = field.getAnnotation(DicFormat.class);
                String fieldName = annotation.fieldName();
                String dicCode = annotation.dicCode();
                Object fieldValue = ReflectUtil.getFieldValue(o, fieldName);
                if (ObjectUtil.isNull(fieldValue) || StringUtils.isEmpty(fieldValue.toString())) {
                    continue;
                }
                Object dicValue = Optional.ofNullable(dicKeyValue.get(dicCode)).orElse(new HashMap<>()).get(fieldValue.toString());
                dicValue = annotation.formatType().getValue(fieldValue.toString(), ObjectUtil.isNotNull(dicValue) ? dicValue.toString() : "");
                ReflectUtil.setFieldValue(o, field, ObjectUtil.isNull(dicValue) ? annotation.defaultValue() : dicValue);
            }
        });

    }

    /**
     * 获取字典值的key-value映射
     *
     * @param aClass
     * @return
     */
    private static Map<String, Map<String, String>> getDicKeyValueMap(Class<?> aClass) {
        Map<String, Map<String, String>> result = new HashMap<>();
        List<Field> dicFormatList = getFieldByAnno(aClass, DicFormat.class);
        if (CollectionUtil.isEmpty(dicFormatList)) {
            return new HashMap<>();
        }
        DicFormat format = dicFormatList.get(0).getAnnotation(DicFormat.class);

        Set<String> dicKeys = dicFormatList.stream().map(field -> {
            DicFormat annotation = field.getAnnotation(DicFormat.class);
            return annotation.dicCode();
        }).collect(Collectors.toSet());
        List<String> noRedisKey = new ArrayList<>();

        //从redis获取对应数据字典
        getDickeyFromRedis(result, format, dicKeys, noRedisKey);
        return result;
    }

    /**
     * 获取字典值的key-value映射--导出模板专用
     *
     * @param aClass
     * @return
     */
    public static Map<String, Map<String, String>> getDicKeyValueMapExp(Class<?> aClass) {
        Map<String, Map<String, String>> result = new HashMap<>();
        List<Field> dicFormatList = getFieldByAnno(aClass, WinExcelTemplateDic.class);
        if (CollectionUtil.isEmpty(dicFormatList)) {
            return new HashMap<>();
        }
        WinExcelTemplateDic winExcelTemplateDic = dicFormatList.get(0).getAnnotation(WinExcelTemplateDic.class);
        Set<String> dicKeys = new HashSet<>();
        dicFormatList.forEach(field -> {
            WinExcelTemplateDic annotation = field.getAnnotation(WinExcelTemplateDic.class);
            dicKeys.addAll(Arrays.asList(annotation.dicCode()));
        });
        List<String> noRedisKey = new ArrayList<>();
        if(com.yss.wealth.infrastructure.util.CollectionUtil.isEmpty(dicKeys)) {
            return new HashMap<>();
        }
        //从redis获取对应数据字典
        getDickeyFromRedis(result, winExcelTemplateDic, dicKeys, noRedisKey);
        return result;
    }

    /**
     * 从redis获取对应数据字典
     *
     * @param result
     * @param annotation
     * @param dicKeys
     * @param noRedisKey
     */
    private static void getDickeyFromRedis(Map<String, Map<String, String>> result, Annotation annotation, Set<String> dicKeys, List<String> noRedisKey) {
        Class<?> interfaceClass = null;
        String methodName = "";
        if (annotation instanceof WinExcelTemplateDic) {
            interfaceClass = ((WinExcelTemplateDic) annotation).interfaceClass();
            methodName = ((WinExcelTemplateDic) annotation).methodName();
        }
        if (annotation instanceof DicFormat) {
            interfaceClass = ((DicFormat) annotation).interfaceClass();
            methodName = ((DicFormat) annotation).methodName();
        }

        //首先从redis中取dickey。
        dicKeys.forEach(k -> {
            String key = redisTemplate.opsForValue().get("dic:key:" + k);
            if (StringUtil.isNotEmpty(key)) {
                result.put(k, JSONObject.parseObject(key, Map.class));
            } else {
                noRedisKey.add(k);
            }
        });
        if (CollectionUtil.isNotEmpty(noRedisKey)) {
            Map<String, Map<String, String>> noKeys = getDicKeyValueMapByFeign(noRedisKey, interfaceClass, methodName);
            if (CollectionUtil.isNotEmpty(noKeys)) {
                noKeys.forEach((k, v) -> {
                    result.put(k, v);
                    redisTemplate.opsForValue().set("dic:key:" + k, JSONObject.toJSONString(v), 1, TimeUnit.DAYS);
                });
            }
        }
    }


    /**
     * 使用feign接口获取字典值
     *
     * @param noRedisKey
     * @return
     */
    private static Map<String, Map<String, String>> getDicKeyValueMapByFeign(List<String> noRedisKey, Class<?> interfaceClass, String methodName) {
        if (CollectionUtil.isEmpty(noRedisKey)) {
            return null;
        }
        Object bean = SpringContextUtil.getBean(interfaceClass);
        if (ObjectUtil.isNull(bean)) {
            logger.warn("未在容器中找到相关bean，class:{}", interfaceClass);
            return null;
        }
        Method method = ReflectUtil.getMethod(interfaceClass, methodName, String[].class);
        if (ObjectUtil.isNull(method)) {
            logger.warn("该bean上没有该方法，class:{}，methodName:{}", interfaceClass, methodName);
            return null;
        }
        Map<String, Map<String, String>> dictionaryMap = null;
        String[] args = noRedisKey.toArray(new String[noRedisKey.size()]);
        try {
            //method.invoke方法的第二个参数是数组，所以当参数是数组的时候必须用new Object[]{}.
            dictionaryMap = (Map<String, Map<String, String>>) method.invoke(bean, new Object[]{args});
        } catch (Exception e) {
            logger.warn("方法执行异常", e);
            return null;
        }
        return dictionaryMap;
    }

    public static <A extends Annotation> List<Field> getFieldByAnno(Class<?> aClass, Class<A> annotationClass) {
        List<Field> res = new ArrayList<>();
        List<Field> allFields = new ArrayList<>();
        getAllField(aClass, allFields);
        for (Field field : allFields) {
            if (field.getAnnotationsByType(annotationClass).length != 0) {
                res.add(field);
            }

        }
        return res;
    }

    private static void getAllField(Class<?> aClass, List<Field> fields) {
        fields.addAll(Arrays.asList(aClass.getDeclaredFields()));
        if (!Object.class.equals(aClass.getSuperclass())) {
            getAllField(aClass.getSuperclass(), fields);
        }
    }


}
