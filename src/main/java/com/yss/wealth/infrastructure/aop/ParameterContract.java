package com.yss.wealth.infrastructure.aop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.yss.wealth.infrastructure.annotation.ParamApi;
import com.yss.wealth.infrastructure.common.EDataFormat;
import com.yss.wealth.infrastructure.common.IBaseDTO;
import com.yss.wealth.infrastructure.common.WarningException;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.EnumUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * @description：验证新增对象参数是否合法
 */
@Aspect
public class ParameterContract {
	@Before("execution(* com.yss.*..interfaces.facade..*Controller.save*(..)) || execution(* com.yss.*..interfaces.facade..*Controller.update*(..))")
	public void checkParam(final JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		IBaseDTO dto = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof IBaseDTO) {
				dto = (IBaseDTO) args[i];
				break;
			}
		}
		if (dto == null) {
			return;
		}

		// 解析字段上的注解
		Class<ParamApi> anno = ParamApi.class;
		List<Field> fieldList = Lists.newArrayList();
		Class<?> clz = dto.getClass();
		while (clz != null) {
			List<Field> list = Stream.of(clz.getDeclaredFields())
					.filter(f -> f.isAnnotationPresent(anno) && f.getAnnotation(anno).required())
					.collect(Collectors.toList());

			fieldList.addAll(list);
			clz = clz.getSuperclass();
		}

		JSONObject paramJson = JSONObject.parseObject(JSONObject.toJSONString(dto));
		for (Field field : fieldList) {
			String fieldName = "".equals(field.getAnnotation(anno).value())?field.getName():field.getAnnotation(anno).value();
			String msg = field.getAnnotation(anno).message();
			String code = field.getAnnotation(anno).code();
			double maxVal = field.getAnnotation(anno).maxVal();
			double minVal = field.getAnnotation(anno).minVal();
			int maxLength = field.getAnnotation(anno).maxLength();
			EDataFormat eDataFormat = field.getAnnotation(anno).dataFormat();
			if (field.getType() == List.class) {
				JSONArray arr = paramJson.getJSONArray(field.getName());
				if (arr == null || arr.size() == 0) {
					throw WarningException.builder().message(msg).code(code).build();
				}
			} else if (field.getType().getName().startsWith("com.yss")) { //modify from "com.yss.ta"
				JSONObject obj = paramJson.getJSONObject(field.getName());
				if (obj == null || "".equals(obj.toJSONString())) {
					throw WarningException.builder().message(msg).code(code).build();
				}
			} else {
				String propertyValue = paramJson.getString(field.getName());
				boolean result;
				if ("null".equals(propertyValue)) {
					propertyValue = null;
				}
				if (propertyValue == null || "".equals(propertyValue)) {
					throw WarningException.builder().message(msg).code(code).build();
				}
				if (Number.class.isAssignableFrom(field.getType())) {
//					if (Double.valueOf(propertyValue) == 0) {
//						throw WarningException.builder().message(fieldName + "不能为0!").build();
//					}
					if(Double.valueOf(propertyValue) > maxVal){
						throw WarningException.builder().message(fieldName + "不能大于"+maxVal+"!").build();
					}
					if(Double.valueOf(propertyValue) < minVal) {
						throw WarningException.builder().message(fieldName + "不能小于" + minVal + "!").build();
					}
				}
				if(propertyValue.length() > maxLength){
					throw WarningException.builder().message(fieldName + "长度不能大于" + maxLength + "位!").build();
				}
				if(EnumUtils.isValidEnumIgnoreCase(EDataFormat.class,eDataFormat.name())){
					switch (eDataFormat.name()) {
						case "DATA":
							result=Pattern.compile("\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}").matcher(propertyValue).find();
							if (!result) {
								throw WarningException.builder().message("请输入规范的" + fieldName + "!").build();
							}
							break;
						case "CELL_PHONE":
							result=Pattern.compile("0?(13|14|15|17|18|19)[0-9]{9}").matcher(propertyValue).find();
							if (!result) {
								throw WarningException.builder().message("请输入规范的" + fieldName + "!").build();
							}
							break;
						case "TELEPHONE":
							result=Pattern.compile("[0-9-()（）]{7,18}").matcher(propertyValue).find();
							if (!result) {
								throw WarningException.builder().message("请输入规范的" + fieldName + "!").build();
							}
							break;
						case "ID_NUMBER":
							result=Pattern.compile("^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$").matcher(propertyValue).find();
							if (!result) {
								throw WarningException.builder().message("请输入规范的" + fieldName + "!").build();
							}
							break;
						case "DEVALUE":
						default :break;
					}
				}
			}
		}
	}
}