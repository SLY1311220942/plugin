package com.sly.plugin.common.constant;

/**
 * AOP切面执行顺序
 * @author sly
 * @time 2019年6月26日
 */
public class AopOrder {
	/** 反重复提交切面顺序 */
	public static final int ANTI_DUPLICATE_COMMIT_ORDER = 1;
	/** 参数验证切面顺序 */
	public static final int VALIDATE_ORDER = 2;
}
