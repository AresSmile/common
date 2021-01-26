package com.yss.wealth.infrastructure.common;

import cn.hutool.core.util.ReflectUtil;
import com.yss.wealth.infrastructure.annotation.CheckDetailFieldApi;
import com.yss.wealth.infrastructure.util.BeanUtilExtend;
import com.yss.wealth.infrastructure.util.CollectionUtil;
import com.yss.wealth.infrastructure.util.ObjectUtilExtends;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 包名称： com.yss.wealth.infrastructure.common
 * 类名称：CheckDataDetailInfoDTO
 * 类描述：变化前后数值对比
 * 创建人：@author LiangJianAn
 * 创建时间：2020/5/9 10:00
 */
@Builder
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class CheckDataDetailInfoDTO implements Serializable {
    /**
     * 获取对比详情数据 liangjianan
     *
     * @param objectBefore 修改后的值，
     * @param objectAfter  修改前的值
     * @return
     */
    public static List<CheckDataDetailInfoDTO> getCheckDataDetailInfoList(Object objectBefore, Object objectAfter) throws Exception {

        List<CheckDataDetailInfoDTO> checkDataDetailInfoList = new ArrayList<>();
        if (Objects.isNull(objectBefore) && Objects.isNull(objectAfter)) {
            throw WarningException.builder().message("所传两个对象都为null").build();
        }
        //构建对比数据
        if (Objects.nonNull(objectBefore)) {
            BeanUtilExtend.format(objectBefore);
        }
        if (Objects.nonNull(objectAfter)) {
            BeanUtilExtend.format(objectAfter);
        }
        List<String> list = null;
        if (Objects.nonNull(objectBefore) && Objects.nonNull(objectAfter)) {
            //修改的话，只取 修改前后不同的数据
            list = ObjectUtilExtends.compareObject(objectBefore, objectAfter, null);
        }

        Object object = Objects.isNull(objectBefore) ? objectAfter : objectBefore;
        //获取私有属性
        Field[] fields = ReflectUtil.getFields(object.getClass());

        for (Field field : fields) {
            if (!CollectionUtil.isEmpty(list)) {
                //只要修改前后不同属性
                if (!list.contains(field.getName())) {
                    continue;
                }
            }
            //获取ApiModelProperty注解的value属性
            CheckDetailFieldApi annotation = field.getAnnotation(CheckDetailFieldApi.class);

            if (Objects.nonNull(annotation)) {
                CheckDataDetailInfoDTO checkDataDetailInfoDTO = CheckDataDetailInfoDTO.builder().build();

                String fieldName = field.getName();
                //变化前属性的值
                Object fieldValueBefore = null;
                if (Objects.nonNull(objectBefore)) {
                    fieldValueBefore = getFieldValue(objectBefore, fieldName);
                    if (Objects.nonNull(fieldValueBefore)) {
                        checkDataDetailInfoDTO.setBeforeChangeValue(fieldValueBefore.toString());
                    }
                }

                //变化后属性值
                Object fieldValueAfter = null;
                if (Objects.nonNull(objectAfter)) {
                    fieldValueAfter = getFieldValue(objectAfter, fieldName);
                    if (Objects.nonNull(fieldValueAfter)) {
                        checkDataDetailInfoDTO.setAfterChangeValue(fieldValueAfter.toString());
                    }
                }

                if (Objects.isNull(fieldValueBefore) && Objects.isNull(fieldValueAfter)) {
                    continue;
                }

                String value = annotation.value();
                checkDataDetailInfoDTO.setAttribute(value);
                checkDataDetailInfoList.add(checkDataDetailInfoDTO);
            }
        }
        return checkDataDetailInfoList;
    }

    /**
     *
     * @param object
     * @param declaredFieldName
     * @return object
     * @throws Exception
     */
    private static Object getFieldValue(Object object, String declaredFieldName) throws Exception {
        if (Objects.isNull(object)) {
            throw WarningException.builder().message("所传对象为null").build();
        }

        Class<?> clazz = object.getClass();
        declaredFieldName = declaredFieldName.substring(0, 1).toUpperCase()
                + declaredFieldName.substring(1);

        Method method = null;
        method = clazz.getMethod("get" + declaredFieldName);
        try {
            return method.invoke(object);
        } catch (Exception e) {
            throw e;
        }
    }

    @ApiModelProperty(value = "主键id")
    private Long id;

    @ApiModelProperty(value = "关联check_data_info表id")
    private Long relaId;

    @ApiModelProperty(value = "变更属性")
    private String attribute;

    @ApiModelProperty(value = "变更前属性")
    private String beforeChangeValue;

    @ApiModelProperty(value = "变更后属性")
    private String afterChangeValue;
}
