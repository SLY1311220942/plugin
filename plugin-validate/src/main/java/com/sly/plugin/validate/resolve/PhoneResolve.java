package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;

import com.sly.plugin.common.constant.CommonRegex;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import com.sly.plugin.validate.constraints.Phone;

/**
 * Phone注解解析类
 * 
 * @author sly
 * @time 2019年6月26日
 */
public class PhoneResolve {

	/**
	 * 解析Phone注解参数是否合规
	 * 
	 * @param parameterValue
	 * @param type
	 * @param annotations
	 * @return
	 * @author sly
	 * @time 2019年6月26日
	 */
	public static BaseResult resolve(Object parameterValue, Class<?> type, Annotation annotations) {
		Phone annotation = (Phone) annotations;
		if(parameterValue != null) {
			if(!(parameterValue instanceof String)) {
				throw new RuntimeException("不支持类型异常：@Phone注解只支持String类型的参数和字段");
			}
			if(!((String)parameterValue).matches(CommonRegex.PHONE_REGEX)) {
				return new BaseResult(ResultStatus.FAILED, annotation.message());
			}
		}
		return new BaseResult(ResultStatus.VALIDATE_PASSED);
	}
}
