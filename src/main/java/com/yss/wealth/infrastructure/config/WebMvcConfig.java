package com.yss.wealth.infrastructure.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.netflix.appinfo.AmazonInfo;
import com.netflix.discovery.converters.jackson.builder.StringInterningAmazonInfoBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * 注册自定义拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(permissionInterceptor()).addPathPatterns("/**");
	}

	/**
	 * 设置访问路径URL中不忽略"."符号
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}

//	@Bean
//	public PermissionInterceptor permissionInterceptor() {
//		return new PermissionInterceptor();
//	}

	/**
	 * 返回结果的空值不进行序列化处理
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(0, new MappingJackson2HttpMessageConverter() {
			@Override
			public ObjectMapper getObjectMapper() {
				super.getObjectMapper().setSerializationInclusion(JsonInclude.Include.ALWAYS);

				// XSS 脚本过滤
				SimpleModule simpleModule = new SimpleModule();
				simpleModule.addDeserializer(AmazonInfo.class, new StringInterningAmazonInfoBuilder());
				//修复Long类型json序列化丢失精度的问题
				simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
				simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
				super.getObjectMapper().registerModule(simpleModule);
				return super.getObjectMapper();
			}
		});
	}

}