package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.sly.plugin.common.constant.ResultStatus;
import com.sly.plugin.common.message.Message;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.validate.constraints.NotBlank;
import com.sly.plugin.validate.constraints.NotNull;
import com.sly.plugin.validate.constraints.Size;

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
				if((annotations[i] instanceof NotBlank) && ((NotBlank)annotations[i]).group().equals(group)) {
					// NotBlank验证
					BaseResult resolveResult = NotBlankResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof NotNull) && ((NotNull)annotations[i]).group().equals(group)) {
					// NotNull验证
					BaseResult resolveResult = NotNullResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Size) && ((Size)annotations[i]).group().equals(group)) {
					// Size验证
					BaseResult resolveResult = SizeResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				}
			}
		}
		return new BaseResult(ResultStatus.SUCCESS, Message.VALIDATE_PASSED);
	}

}
