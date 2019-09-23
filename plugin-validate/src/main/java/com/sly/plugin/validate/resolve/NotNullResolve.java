package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;

import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import com.sly.plugin.validate.constraints.NotNull;

/**
 * NotNull注解解析类
 * 
 * @author sly
 * @time 2019年6月20日
 */
public class NotNullResolve {

	/**
	 * 解析NotNull注解参数是否合规
	 * 
	 * @param parameterValue
	 * @param type
	 * @param annotations
	 * @return
	 * @author sly
	 * @time 2019年6月20日
	 */
	public static BaseResult resolve(Object parameterValue, Class<?> type, Annotation annotations) {
		NotNull annotation = (NotNull) annotations;
		if (parameterValue == null) {
			return new BaseResult(ResultStatus.FAILED, annotation.message());
		}
		return new BaseResult(ResultStatus.VALIDATE_PASSED);
	}
}
