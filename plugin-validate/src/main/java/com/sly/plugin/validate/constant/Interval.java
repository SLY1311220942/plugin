package com.sly.plugin.validate.constant;

public enum Interval {
	/** 开区间 */
	OPEN_OPEN("()"),
	/** 前开后闭区间 */
	OPEN_CLOSE("(]"),
	/** 前闭后开区间 */
	CLOSE_OPEN("[)"),
	/** 闭区间 */
	CLOSE_CLOSE("[]"),
	;
	
	private String interval;
	
	private Interval(String interval) {
		this.interval = interval;
	}
	
	public String getInterval() {
		return this.interval;
	}
	
	public String getName() {
		return this.name();
	}
}
