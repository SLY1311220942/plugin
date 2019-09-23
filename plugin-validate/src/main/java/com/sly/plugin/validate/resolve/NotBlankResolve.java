package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;

import org.apache.commons.lang3.StringUtils;

import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import com.sly.plugin.validate.constraints.NotBlank;

/**
 * NotBlank注解解析类
 * 
 * @author sly
 * @time 2019年6月20日
 */
public class NotBlankResolve {

	/**
	 * 解析NotBlank注解参数是否合规
	 * 
	 * @param parameterValue
	 * @param type
	 * @return
	 * @author sly
	 * @param annotations
	 * @time 2019年6月20日
	 */
	public static BaseResult resolve(Object parameterValue, Class<?> type, Annotation annotations) {
		NotBlank annotation = (NotBlank) annotations;
		if(parameterValue == null) {
			return new BaseResult(ResultStatus.FAILED, annotation.message());
		} else if (!(parameterValue instanceof String)) {
			throw new RuntimeException("不支持类型异常：@NotBlank注解只支持String类型的参数和字段");
		}
		
		if (StringUtils.isBlank((String) parameterValue)) {
			return new BaseResult(ResultStatus.FAILED, annotation.message());
		}
		return new BaseResult(ResultStatus.VALIDATE_PASSED);
	}

}
