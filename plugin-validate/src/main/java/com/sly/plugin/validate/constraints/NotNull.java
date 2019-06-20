package com.sly.plugin.validate.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.sly.plugin.validate.constant.Constant;
import com.sly.plugin.validate.constraints.NotNull.List;

/**
 * 非空
 * @author sly
 * @time 2019年6月20日
 */
@Documented
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Repeatable(List.class)
public @interface NotNull {
	/**
	 * message
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月18日
	 */
	String message() default "{com.sly.plugin.validate.constraints.NotNull.message}";

	/**
	 * 验证分组
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月18日
	 */
	String group() default Constant.DEFAULT_GROUP;

	/**
	 * 
	 * @author sly
	 * @time 2019年6月18日
	 */
	@Target({ FIELD, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		NotNull[] value();
	}
}
