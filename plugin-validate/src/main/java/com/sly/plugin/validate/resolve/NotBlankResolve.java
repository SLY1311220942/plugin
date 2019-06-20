package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;

import org.apache.commons.lang3.StringUtils;

import com.sly.plugin.common.constant.ResultStatus;
import com.sly.plugin.common.message.Message;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.validate.constraints.NotBlank;

/**
 * NotBlank注解解析类
 * 
 * @author sly
 * @time 2019年6月20日
 */
public class NotBlankResolve {

	/**
	 * 解析非空注解参数是否合规
	 * 
	 * @param parameterValue
	 * @param type
	 * @return
	 * @author sly
	 * @param annotations
	 * @time 2019年6月20日
	 */
	public static BaseResult resolve(Object parameterValue, Class<?> type, Annotation annotations) {
		if (!(parameterValue instanceof String)) {
			throw new RuntimeException("非支持类型：@NotBlank注解只支持String类型的参数和字段");
		}
		NotBlank notBlank = (NotBlank) annotations;
		if (StringUtils.isBlank((String) parameterValue)) {
			return new BaseResult(ResultStatus.FAILED, notBlank.message());
		}
		return new BaseResult(ResultStatus.SUCCESS, Message.VALIDATE_PASSED);
	}

}
