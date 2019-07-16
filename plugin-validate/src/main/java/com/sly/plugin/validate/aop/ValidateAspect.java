package com.sly.plugin.validate.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import com.sly.plugin.common.constant.ResultStatus;
import com.sly.plugin.common.message.Message;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.validate.annotation.Valid;
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
import com.sly.plugin.validate.resolve.EmailResolve;
import com.sly.plugin.validate.resolve.NotBlankResolve;
import com.sly.plugin.validate.resolve.NotNullResolve;
import com.sly.plugin.validate.resolve.NullResolve;
import com.sly.plugin.validate.resolve.PhoneOrTelResolve;
import com.sly.plugin.validate.resolve.PhoneResolve;
import com.sly.plugin.validate.resolve.RegexResolve;
import com.sly.plugin.validate.resolve.SizeResolve;
import com.sly.plugin.validate.resolve.TelResolve;
import com.sly.plugin.validate.resolve.ValidResolve;

/**
 * 参数验证切面
 * 
 * @author sly
 * @time 2019年6月18日
 */
@Aspect
@Order(2000)
public class ValidateAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateAspect.class);

	@Around("@annotation(com.sly.plugin.validate.annotation.Validate)")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		// 获取注解
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();

		// 获取参数map
		Object[] paramValues = point.getArgs();
		String[] parameterNames = signature.getParameterNames();
		Class<?>[] parameterTypes = signature.getParameterTypes();
		Map<String, Object> parameterValueMap = new HashMap<>(16);
		Map<String, Class<?>> parameterTypeMap = new HashMap<>(16);
		for (int i = 0; i < parameterNames.length; i++) {
			parameterValueMap.put(parameterNames[i], paramValues[i]);
			parameterTypeMap.put(parameterNames[i], parameterTypes[i]);
		}

		// 获取参数
		Parameter[] parameters = method.getParameters();
		for (int i = 0; i < parameters.length; i++) {
			Parameter parameter = parameters[i];
			String parameterName = parameter.getName();
			Annotation[] annotations = parameter.getAnnotations();
			for (int j = 0; j < annotations.length; j++) {
				Class<?> type = parameter.getType();
				Object parameterValue = parameterValueMap.get(parameterName);
				if (annotations[j] instanceof Valid) {
					// Valid验证对象
					Valid valid = (Valid) annotations[j];
					BaseResult resolveResult = ValidResolve.resolve(parameterValue, type, valid.value());
					if (resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if (annotations[j] instanceof NotBlank) {
					// NotBlank验证
					BaseResult resolveResult = NotBlankResolve.resolve(parameterValue, type, annotations[j]);
					if (resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if(annotations[j] instanceof NotNull) {
					// NotNull验证
					BaseResult resolveResult = NotNullResolve.resolve(parameterValue, type, annotations[j]);
					if (resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if(annotations[j] instanceof Null) {
					// Null验证
					BaseResult resolveResult = NullResolve.resolve(parameterValue, type, annotations[j]);
					if (resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if(annotations[j] instanceof Size) {
					// Size验证
					BaseResult resolveResult = SizeResolve.resolve(parameterValue, type, annotations[j]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if(annotations[j] instanceof NumRange) {
					// NumRange验证
					BaseResult resolveResult = SizeResolve.resolve(parameterValue, type, annotations[j]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if(annotations[j] instanceof Regex) {
					// Regex验证
					BaseResult resolveResult = RegexResolve.resolve(parameterValue, type, annotations[j]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if(annotations[j] instanceof Phone) {
					// Phone验证
					BaseResult resolveResult = PhoneResolve.resolve(parameterValue, type, annotations[j]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if(annotations[j] instanceof Tel) {
					// Tel验证
					BaseResult resolveResult = TelResolve.resolve(parameterValue, type, annotations[j]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if(annotations[j] instanceof PhoneOrTel) {
					// PhoneOrTel验证
					BaseResult resolveResult = PhoneOrTelResolve.resolve(parameterValue, type, annotations[j]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				} else if(annotations[j] instanceof Email) {
					// Email验证
					BaseResult resolveResult = EmailResolve.resolve(parameterValue, type, annotations[j]);
					if(resolveResult.getStatus() != ResultStatus.SUCCESS) {
						return resolveResult;
					}
				}
			}
		}

		// 执行方法
		try {
			return point.proceed();
		} catch (Exception e) {
			LOGGER.error("原始异常:" + ExceptionUtils.getStackTrace(e));
			return new BaseResult(ResultStatus.ERROR, Message.SYSTEM_ERROR);
		}
	}
}
