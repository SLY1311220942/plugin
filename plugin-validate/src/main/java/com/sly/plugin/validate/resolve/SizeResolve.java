package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;

import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import com.sly.plugin.validate.constraints.Size;

/**
 * Size注解解析类
 * 
 * @author sly
 * @time 2019年6月20日
 */
public class SizeResolve {
	
	/**
	 * 解析Size注解参数是否合规
	 * 
	 * @param parameterValue
	 * @param type
	 * @param annotations
	 * @return
	 * @author sly
	 * @time 2019年6月20日
	 */
	@SuppressWarnings("rawtypes")
	public static BaseResult resolve(Object parameterValue, Class<?> type, Annotation annotations) {
		long size = 0;
		if(parameterValue == null) {
			size = 0;
		}else if (!(parameterValue instanceof String) && !(parameterValue instanceof Collection)
				&& !(parameterValue instanceof Map) && !(parameterValue.getClass().isArray())) {
			throw new RuntimeException("不支持类型异常：@Size注解只支持String、Collection、Map、和Array类型的参数和字段");
		}
		Size annotation = (Size) annotations;
		long min = annotation.min();
		long max = annotation.max();
		
		if (parameterValue != null) {
			if(parameterValue instanceof String) {
				size = ((String) parameterValue).length();
			}else if(parameterValue instanceof Collection) {
				size = ((Collection) parameterValue).size();
			}else if(parameterValue instanceof Map) {
				size = ((Map) parameterValue).size();
			}else if(parameterValue.getClass().isArray()) {
				size = ((Object[]) parameterValue).length;
			}
		}
		
		if(size >= min && size <= max) {
			return new BaseResult(ResultStatus.VALIDATE_PASSED);
		}else {
			return new BaseResult(ResultStatus.FAILED, annotation.message());
		}
		
		
	}
}
