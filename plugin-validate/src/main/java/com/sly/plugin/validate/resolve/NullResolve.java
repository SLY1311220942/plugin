package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;

import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import com.sly.plugin.validate.constraints.Null;

/**
 * Null注解解析类
 * 
 * @author sly
 * @time 2019年6月26日
 */
public class NullResolve {

	/**
	 * 解析Null注解参数是否合规
	 * 
	 * @param parameterValue
	 * @param type
	 * @param annotations
	 * @return
	 * @author sly
	 * @time 2019年6月26日
	 */
	public static BaseResult resolve(Object parameterValue, Class<?> type, Annotation annotations) {
		Null annotation = (Null) annotations;
		if (parameterValue != null) {
			return new BaseResult(ResultStatus.FAILED, annotation.message());
		}
		return new BaseResult(ResultStatus.VALIDATE_PASSED);
	}
}
