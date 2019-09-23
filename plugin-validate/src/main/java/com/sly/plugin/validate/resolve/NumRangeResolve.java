package com.sly.plugin.validate.resolve;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import com.sly.plugin.validate.constant.Interval;
import com.sly.plugin.validate.constraints.NumRange;

/**
 * 数字范围解析类
 * 
 * @author sly
 * @time 2019年6月24日
 */
public class NumRangeResolve {

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
		List<Interval> intervals = Arrays.asList(Interval.OPEN_OPEN, Interval.OPEN_CLOSE, Interval.CLOSE_OPEN, Interval.CLOSE_CLOSE);
		NumRange annotation = (NumRange) annotations;
		Interval interval = annotation.interval();
		if (!intervals.contains(interval)) {
			throw new RuntimeException("不支持区间类型异常：@NumRange注解区间只支持“OPEN_OPEN”、“OPEN_CLOSE”、“CLOSE_OPEN”和“CLOSE_CLOSE”");
		}
		
		
		if(parameterValue == null) {
			// 空值默认验证失败
			return new BaseResult(ResultStatus.FAILED, annotation.message());
		} else if (parameterValue instanceof Number) {
			BigDecimal value = new BigDecimal(String.valueOf(parameterValue));
			BigDecimal min = new BigDecimal(String.valueOf(annotation.min()));
			BigDecimal max = new BigDecimal(String.valueOf(annotation.max()));
			
			if (Interval.OPEN_OPEN.equals(interval) || Interval.OPEN_CLOSE.equals(interval)) {
				if (value.compareTo(min) == 1) {
					// 大于最小值
					if (Interval.OPEN_OPEN.equals(interval)) {
						if (value.compareTo(max) == 1 || value.compareTo(max) == 0) {
							// 右侧开区间 大于等于最大值
							return new BaseResult(ResultStatus.FAILED, annotation.message());
						}
					} else if (Interval.OPEN_CLOSE.equals(interval)) {
						if (value.compareTo(max) == 1) {
							// 右侧闭区间 大于最大值
							return new BaseResult(ResultStatus.FAILED, annotation.message());
						}
					}
				} else {
					return new BaseResult(ResultStatus.FAILED, annotation.message());
				}
			} else if (Interval.CLOSE_OPEN.equals(interval) || Interval.CLOSE_CLOSE.equals(interval)) {
				if (value.compareTo(min) == 1 || value.compareTo(min) == 0) {
					// 大于等于最小值
					if (Interval.CLOSE_OPEN.equals(interval)) {
						if (value.compareTo(max) == 1 || value.compareTo(max) == 0) {
							// 右侧开区间 大于等于最大值
							return new BaseResult(ResultStatus.FAILED, annotation.message());
						}
					} else if (Interval.CLOSE_CLOSE.equals(interval)) {
						if (value.compareTo(max) == 1) {
							// 右侧闭区间 大于最大值
							return new BaseResult(ResultStatus.FAILED, annotation.message());
						}
					}
				} else {
					return new BaseResult(ResultStatus.FAILED, annotation.message());
				}
			}

		} else {
			throw new RuntimeException("不支持类型异常：@NumRange注解只支持数字类型的参数和字段");
		}

		return new BaseResult(ResultStatus.VALIDATE_PASSED);
	}
}
