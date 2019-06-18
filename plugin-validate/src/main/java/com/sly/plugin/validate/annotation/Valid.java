package com.sly.plugin.validate.annotation;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.sly.plugin.validate.constant.Constant;

/**
 * 验证参数注解
 * 
 * @author sly
 * @time 2019年6月18日
 */
@Target({ PARAMETER })
@Retention(RUNTIME)
@Documented
public @interface Valid {
	/**
	 * 验证分组
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月18日
	 */
	String group() default Constant.DEFAULT_GROUP;
}
