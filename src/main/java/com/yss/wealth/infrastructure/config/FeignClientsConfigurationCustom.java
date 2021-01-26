package com.yss.wealth.infrastructure.config;

import com.google.common.base.Strings;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author libihui
 * @version 1.0 2020/1/15
 * @description：确保session和request能在微服务之间正常传递
 */
@Configuration
public class FeignClientsConfigurationCustom {
	@Bean
	@ConditionalOnMissingBean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> {
			String sessionId = null;
			try {
				//有可能当前线程还没有request对象。
				sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
			} catch (IllegalStateException e) {
				return;
			}
			if (!Strings.isNullOrEmpty(sessionId)) {
				requestTemplate.header("Cookie", "SESSION=" + sessionId);
			}

			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			Enumeration<String> headerNames = request.getHeaderNames();
			if (headerNames != null) {
				while (headerNames.hasMoreElements()) {
					String name = headerNames.nextElement();
					if ("Content-Type".equalsIgnoreCase(name) || "Accept".equalsIgnoreCase(name)){
						//feign接口调用的时候不要复制content-type,Accept到请求头，存在两个接口请求头不一样的时候feign接口将会报错
						continue;
					}
					String values = request.getHeader(name);
					requestTemplate.header(name, values);
				}
			}
		};
	}
}
