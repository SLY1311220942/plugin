package com.sly.plugin.validate.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.sly.plugin.validate.constant.Constant;
import com.sly.plugin.validate.constraints.Size.List;

/**
 * 尺寸大小
 * <p>
 * 最小值 默认0</br>
 * 最大值 默认{@code Long.MAX_VALUE}</br>
 * 支持类型是:
 * <ul>
 *     <li>{@code String} (验证字符串长度)</li>
 *     <li>{@code Collection} (验证Collection长度)</li>
 *     <li>{@code Map} (验证Map尺寸大小)</li>
 *     <li>Array (验证数组的长度)</li>
 * </ul>
 * <p>
 * @author sly
 * @time 2019年6月20日
 */
@Documented
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Repeatable(List.class)
public @interface Size {
	/**
	 * 最小值
	 * <p>
	 * 默认0
	 * </p>
	 * @return
	 * @author sly
	 * @time 2019年6月20日
	 */
	long min() default 0;
	
	/**
	 * 最大值
	 * <p>
	 * 默认{@code Long.MAX_VALUE}
	 * </p>
	 * @return
	 * @author sly
	 * @time 2019年6月20日
	 */
	long max() default Long.MAX_VALUE;
	
	/**
	 * message
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月18日
	 */
	String message() default "{com.sly.plugin.validate.constraints.Size.message}";

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
		Size[] value();
	}
}
