package com.sly.plugin.validate.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sly.plugin.common.constant.ResultStatus;
import com.sly.plugin.common.message.Message;
import com.sly.plugin.common.result.BaseResult;

/**
 * 参数验证切面
 * 
 * @author sly
 * @time 2019年6月18日
 */
@Aspect
public class ValidateAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidateAspect.class);

	@Around("@annotation(com.sly.plugin.validate.annotation.Validate)")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();

		// 判断请求类型
		String header = request.getHeader("X-Requested-With");
		boolean isAjax = "XMLHttpRequest".equals(header) ? true : false;

		// 获取注解
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();

		// 获取参数注解
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();

		// 是否验证通过
		boolean isCheckPassed = true;
		// 返回结果map
		BaseResult result = new BaseResult(ResultStatus.FAILED);

		// 验证参数组装返回信息

		// 验证不通过
		if (!isCheckPassed) {
			return result;
		}

		// 执行方法
		try {
			return point.proceed();
		} catch (Exception e) {
			LOGGER.error("原始异常:" + ExceptionUtils.getStackTrace(e));
			result.setStatus(ResultStatus.ERROR);
			result.setMessage(Message.SYSTEM_ERROR);
			return result;
		}
	}
}
