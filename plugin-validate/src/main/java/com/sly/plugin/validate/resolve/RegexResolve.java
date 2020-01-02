package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;

import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import com.sly.plugin.validate.constraints.Regex;

/**
 * Regex注解解析类
 * 
 * @author sly
 * @time 2019年6月26日
 */
public class RegexResolve {

	/**
	 * 解析Regex注解参数是否合规
	 * 
	 * @param parameterValue
	 * @param type
	 * @param annotations
	 * @return
	 * @author sly
	 * @time 2019年6月26日
	 */
	public static BaseResult resolve(Object parameterValue, Class<?> type, Annotation annotations) {
		Regex annotation = (Regex) annotations;
		String regexp = annotation.regexp();
		if(parameterValue != null) {
			parameterValue = String.valueOf(parameterValue);
			if (!((String) parameterValue).matches(regexp)) {
				return new BaseResult(ResultStatus.FAILED, annotation.message());
			}
		}
		
		return new BaseResult(ResultStatus.VALIDATE_PASSED);
	}
}
