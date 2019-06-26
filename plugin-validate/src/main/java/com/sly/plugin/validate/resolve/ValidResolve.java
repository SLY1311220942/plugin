package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.sly.plugin.common.constant.ResultStatus;
import com.sly.plugin.common.message.Message;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.validate.constraints.Email;
import com.sly.plugin.validate.constraints.NotBlank;
import com.sly.plugin.validate.constraints.NotNull;
import com.sly.plugin.validate.constraints.Null;
import com.sly.plugin.validate.constraints.Phone;
import com.sly.plugin.validate.constraints.PhoneOrTel;
import com.sly.plugin.validate.constraints.Regex;
import com.sly.plugin.validate.constraints.Size;
import com.sly.plugin.validate.constraints.Tel;

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
				} else if((annotations[i] instanceof Null) && ((Null)annotations[i]).group().equals(group)) {
					// Null验证
					BaseResult resolveResult = NullResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Size) && ((Size)annotations[i]).group().equals(group)) {
					// Size验证
					BaseResult resolveResult = SizeResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Size) && ((Size)annotations[i]).group().equals(group)) {
					// NumRange验证
					BaseResult resolveResult = NumRangeResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Regex) && ((Regex)annotations[i]).group().equals(group)) {
					// Regex验证
					BaseResult resolveResult = RegexResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Phone) && ((Phone)annotations[i]).group().equals(group)) {
					// Phone验证
					BaseResult resolveResult = PhoneResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Tel) && ((Tel)annotations[i]).group().equals(group)) {
					// Tel验证
					BaseResult resolveResult = TelResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof PhoneOrTel) && ((PhoneOrTel)annotations[i]).group().equals(group)) {
					// PhoneOrTel验证
					BaseResult resolveResult = PhoneOrTelResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Email) && ((Email)annotations[i]).group().equals(group)) {
					// Email验证
					BaseResult resolveResult = EmailResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				}
			}
		}
		return new BaseResult(ResultStatus.SUCCESS, Message.VALIDATE_PASSED);
	}

}
