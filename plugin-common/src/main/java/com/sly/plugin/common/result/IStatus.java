package com.sly.plugin.common.result;

/**
 * 返回状态接口
 * 
 * @author sly
 * @time 2019年9月23日
 */
public interface IStatus {
	public int getStatus();

	public String getMessage();

	public String getName();
}
