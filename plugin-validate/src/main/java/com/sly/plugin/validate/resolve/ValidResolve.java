package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.sly.plugin.common.constant.ResultStatus;
import com.sly.plugin.common.message.Message;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.validate.constraints.NotBlank;

/**
 * 对象注解解析类
 * 
 * @author sly
 * @time 2019年6月20日
 */
public class ValidResolve {
	/**
	 * 解析包装对象参数是否合规
	 * 
	 * @param object
	 * @param type
	 * @return
	 * @author sly
	 * @param group
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @time 2019年6月20日
	 */
	public static BaseResult resolve(Object object, Class<?> type, String group) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = type.getFields();
		for (Field field : fields) {
			// 这样才可以访问私有属性
			field.setAccessible(true);
			Annotation[] annotations = field.getAnnotations();
			Object fieldValue = field.get(object);
			for (int i = 0; i < annotations.length; i++) {
				// NotBlank验证
				if(annotations[i] instanceof NotBlank) {
					BaseResult resolveResult = NotBlankResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				}
			}
		}
		return new BaseResult(ResultStatus.SUCCESS, Message.VALIDATE_PASSED);
	}

}
