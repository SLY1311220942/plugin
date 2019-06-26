package com.sly.plugin.validate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sly.plugin.validate.aop.ValidateAspect;

/**
 * 配置参数验证
 * 
 * @author sly
 * @time 2019年6月18日
 */
@Configuration
public class ValidateConfig implements WebMvcConfigurer{
	
	@Bean
	public ValidateAspect getValidateAspectAspect() {
		System.out.println("初始化参数验证插件...");
		ValidateAspect validateAspect = new ValidateAspect();
		return validateAspect;
	}
}
