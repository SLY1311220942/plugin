package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.sly.plugin.common.constant.ResultStatus;
import com.sly.plugin.common.message.Message;
import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.validate.constraints.NumRange;

/**
 * 数字范围解析类
 * 
 * @author sly
 * @time 2019年6月24日
 */
public class NumRangeResolve {
	/** 开区间 */
	private static final String OPEN_OPEN = "()";
	/** 前开后闭区间 */
	private static final String OPEN_CLOSE = "(]";
	/** 前闭后开区间 */
	private static final String CLOSE_OPEN = "[)";
	/** 闭区间 */
	private static final String CLOSE_CLOSE = "[]";

	/**
	 * 解析NumRange注解参数是否合规
	 * 
	 * @param parameterValue
	 * @param type
	 * @param annotations
	 * @return
	 * @author sly
	 * @time 2019年6月24日
	 */
	public static BaseResult resolve(Object parameterValue, Class<?> type, Annotation annotations) {
		List<String> intervals = Arrays.asList(OPEN_OPEN, OPEN_CLOSE, CLOSE_OPEN, CLOSE_CLOSE);
		NumRange annotation = (NumRange) annotations;
		String interval = annotation.interval();
		if (!intervals.contains(interval)) {
			throw new RuntimeException("不支持区间类型异常：@NumRange注解区间只支持“()”、“(]”、“[)”和“[]”");
		}

		if (parameterValue instanceof Number) {
			BigDecimal value = new BigDecimal(parameterValue + "");
			BigDecimal min = new BigDecimal(annotation.min() + "");
			BigDecimal max = new BigDecimal(annotation.max() + "");
			if (OPEN_OPEN.equals(interval) || OPEN_CLOSE.equals(interval)) {
				if (value.compareTo(min) == 1) {
					// 大于最小值
					if (OPEN_OPEN.equals(interval)) {
						if (!(value.compareTo(max) == -1 || value.compareTo(max) == 0)) {
							// 右侧开区间 大于等于最大值
							return new BaseResult(ResultStatus.FAILED, annotation.message());
						}
					} else if (OPEN_CLOSE.equals(interval)) {
						if (!(value.compareTo(max) == -1)) {
							// 右侧闭区间 大于最大值
							return new BaseResult(ResultStatus.FAILED, annotation.message());
						}
					}
				}
			} else if (CLOSE_OPEN.equals(interval) || CLOSE_CLOSE.equals(interval)) {
				if (value.compareTo(max) == 1 || value.compareTo(max) == 0) {
					// 大于等于最小值
					if (CLOSE_OPEN.equals(interval)) {
						if (!(value.compareTo(max) == -1 || value.compareTo(max) == 0)) {
							// 右侧开区间 大于等于最大值
							return new BaseResult(ResultStatus.FAILED, annotation.message());
						}
					} else if (CLOSE_CLOSE.equals(interval)) {
						if (!(value.compareTo(max) == -1)) {
							// 右侧闭区间 大于最大值
							return new BaseResult(ResultStatus.FAILED, annotation.message());
						}
					}
				}
			}

		} else {
			throw new RuntimeException("不支持类型异常：@NumRange注解只支持数字类型的参数和字段");
		}

		return new BaseResult(ResultStatus.SUCCESS, Message.VALIDATE_PASSED);
	}
}
