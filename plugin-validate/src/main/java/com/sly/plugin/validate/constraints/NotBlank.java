package com.sly.plugin.validate.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.sly.plugin.validate.constant.Constant;
import com.sly.plugin.validate.constraints.NotBlank.List;

/**
 * 非空
 * <p>
 * 支持类型是:
 * <ul>
 *     <li>{@code String} (字符串必须有非空格的字符)</li>
 * </ul>
 * <p>
 * @author sly
 * @time 2019年6月18日
 */
@Documented
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Repeatable(List.class)
public @interface NotBlank {
	/**
	 * message
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月18日
	 */
	String message() default "{com.sly.plugin.validate.constraints.NotBlank.message}";

	/**
	 * 验证分组
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月18日
	 */
	String[] group() default { Constant.DEFAULT_GROUP };

	/**
	 * 
	 * @author sly
	 * @time 2019年6月18日
	 */
	@Target({ FIELD, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		NotBlank[] value();
	}
}
