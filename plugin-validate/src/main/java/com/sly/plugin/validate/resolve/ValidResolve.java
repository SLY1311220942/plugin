package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import com.sly.plugin.validate.constraints.Email;
import com.sly.plugin.validate.constraints.NotBlank;
import com.sly.plugin.validate.constraints.NotNull;
import com.sly.plugin.validate.constraints.Null;
import com.sly.plugin.validate.constraints.NumRange;
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
		Field[] fields = type.getDeclaredFields();
		for (Field field : fields) {
			// 这样才可以访问私有属性
			field.setAccessible(true);
			Annotation[] annotations = field.getAnnotations();
			Object fieldValue = field.get(object);
			for (int i = 0; i < annotations.length; i++) {
				if((annotations[i] instanceof NotBlank) && Arrays.asList(((NotBlank)annotations[i]).group()).contains(group)) {
					// NotBlank验证
					BaseResult resolveResult = NotBlankResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS.getStatus()) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof NotNull) && Arrays.asList(((NotNull)annotations[i]).group()).contains(group)) {
					// NotNull验证
					BaseResult resolveResult = NotNullResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS.getStatus()) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Null) && Arrays.asList(((Null)annotations[i]).group()).contains(group)) {
					// Null验证
					BaseResult resolveResult = NullResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS.getStatus()) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Size) && Arrays.asList(((Size)annotations[i]).group()).contains(group)) {
					// Size验证
					BaseResult resolveResult = SizeResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS.getStatus()) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof NumRange) && Arrays.asList(((NumRange)annotations[i]).group()).contains(group)) {
					// NumRange验证
					BaseResult resolveResult = NumRangeResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS.getStatus()) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Regex) && Arrays.asList(((Regex)annotations[i]).group()).contains(group)) {
					// Regex验证
					BaseResult resolveResult = RegexResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS.getStatus()) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Phone) && Arrays.asList(((Phone)annotations[i]).group()).contains(group)) {
					// Phone验证
					BaseResult resolveResult = PhoneResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS.getStatus()) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Tel) && Arrays.asList(((Tel)annotations[i]).group()).contains(group)) {
					// Tel验证
					BaseResult resolveResult = TelResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS.getStatus()) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof PhoneOrTel) && Arrays.asList(((PhoneOrTel)annotations[i]).group()).contains(group)) {
					// PhoneOrTel验证
					BaseResult resolveResult = PhoneOrTelResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS.getStatus()) {
						return resolveResult;
					}
				} else if((annotations[i] instanceof Email) && Arrays.asList(((Email)annotations[i]).group()).contains(group)) {
					// Email验证
					BaseResult resolveResult = EmailResolve.resolve(fieldValue, field.getType(),annotations[i]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS.getStatus()) {
						return resolveResult;
					}
				}
			}
		}
		return new BaseResult(ResultStatus.VALIDATE_PASSED);
	}

}
