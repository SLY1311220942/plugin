package com.sly.plugin.validate.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 验证注解
 * 
 * @author sly
 * @time 2019年6月18日
 */
@Target({ METHOD })
@Retention(RUNTIME)
@Documented
public @interface Validate {
	

}
