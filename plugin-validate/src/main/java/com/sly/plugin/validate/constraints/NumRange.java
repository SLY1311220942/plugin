package com.sly.plugin.validate.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.sly.plugin.validate.constant.Constant;
import com.sly.plugin.validate.constant.Interval;
import com.sly.plugin.validate.constraints.NumRange.List;

/**
 * 范围大小
 * <p>
 * 最小值 默认0</br>
 * 最大值 默认{@code Double.MAX_VALUE}</br>
 * 支持类型是:
 * <ul>
 * 		<li>numeric (验证数字范围)</li>
 * </ul>
 * <p>
 * @author sly
 * @time 2019年6月20日
 */
@Documented
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Repeatable(List.class)
public @interface NumRange {

	/**
	 * 最小值
	 * <p>
	 * 默认0
	 * </p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月20日
	 */
	double min() default 0;

	/**
	 * 最大值
	 * <p>
	 * 默认{@code Long.MAX_VALUE}
	 * </p>
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月20日
	 */
	double max() default Double.MAX_VALUE;
	
	/**
	 * 区间闭合性
	 * <p>
	 * 	默认：[]</br>
	 * 	()</br>
	 *  [)</br>
	 *  (]</br>
	 *  []</br>
	 * </p>
	 * @return
	 * @author sly
	 * @time 2019年6月24日
	 */
	Interval interval() default Interval.CLOSE_CLOSE;
	
	/**
	 * message
	 * 
	 * @return
	 * @author sly
	 * @time 2019年6月18日
	 */
	String message() default "{com.sly.plugin.validate.constraints.NumRange.message}";

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
		NumRange[] value();
	}
}
