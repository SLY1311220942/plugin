package com.sly.plugin.validate.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.sly.plugin.validate.configuration.ValidateConfig;

/**
 * 开启参数验证注解
 * @author sly
 * @time 2019年6月18日
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ValidateConfig.class)
public @interface EnableValidate {

}
