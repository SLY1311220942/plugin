package com.sly.plugin.sensitiveword.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.sly.plugin.sensitiveword.configuration.SensitiveWordConfig;

/**
 * 开启敏感词验证配置注解
 * 
 * @author sly
 * @time 2019年6月18日
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SensitiveWordConfig.class)
public @interface EnableSensitiveWord {

}
