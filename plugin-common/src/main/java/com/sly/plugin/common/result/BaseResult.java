package com.sly.plugin.common.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;

/**
 * 公共返回对象
 * 
 * @author sly
 * @time 2018年11月12日
 */
public class BaseResult extends HashMap<String, Object> {

	private static final long serialVersionUID = -1937095802242495571L;

	/**
	 * 空参构造方法
	 */
	public BaseResult() {

	}

	/**
	 * 构造方法
	 * 
	 * @param status
	 */
	public BaseResult(Integer status) {
		setStatus(status);
	}

	/**
	 * 构造方法
	 * 
	 * @param status
	 * @param message
	 */
	public BaseResult(Integer status, String message) {
		setStatus(status);
		setMessage(message);
	}

	/**
	 * 构造方法
	 * 
	 * @param status
	 * @param message
	 */
	public BaseResult(IStatus status, String message) {
		setStatus(status.getStatus());
		setMessage(message);
	}

	/**
	 * 构造方法
	 * 
	 * @param status
	 */
	public BaseResult(IStatus status) {
		setStatus(status.getStatus());
		setMessage(status.getMessage());
	}

	/**
	 * 构造方法
	 * 
	 * @param status
	 * @param message
	 * @param key
	 * @param value
	 */
	public BaseResult(Integer status, String message, String key, Object value) {
		setStatus(status);
		setMessage(message);
		put(key, value);
	}

	/**
	 * 构造方法
	 * 
	 * @param status
	 * @param message
	 * @param key
	 * @param value
	 */
	public BaseResult(IStatus status, String key, Object value) {
		setStatus(status.getStatus());
		setMessage(status.getMessage());
		put(key, value);
	}

	/**
	 * 构造方法
	 * 
	 * @param status
	 * @param message
	 * @param dataMap
	 */
	public BaseResult(Integer status, String message, Map<String, Object> dataMap) {
		setDataMap(dataMap);
		setStatus(status);
		setMessage(message);
	}

	/**
	 * 构造方法
	 * 
	 * @param status
	 * @param dataMap
	 */
	public BaseResult(IStatus status, Map<String, Object> dataMap) {
		setDataMap(dataMap);
		setStatus(status.getStatus());
		setMessage(status.getMessage());
	}

	/**
	 * 构造方法
	 * 
	 * @param status
	 * @param message
	 * @param total
	 * @param rows
	 */
	public BaseResult(Integer status, String message, Integer total, List<?> rows) {
		setStatus(status);
		setMessage(message);
		setTotal(total);
		setRows(rows);
	}

	/**
	 * 构造方法
	 * 
	 * @param status
	 * @param total
	 * @param rows
	 */
	public BaseResult(IStatus status, Integer total, List<?> rows) {
		setStatus(status.getStatus());
		setMessage(status.getMessage());
		setTotal(total);
		setRows(rows);
	}
	
	/**
	 * 构造方法
	 * 
	 * @param status
	 * @param total
	 * @param rows
	 */
	public BaseResult(IStatus status, Long total, List<?> rows) {
		setStatus(status.getStatus());
		setMessage(status.getMessage());
		setTotal(total.intValue());
		setRows(rows);
	}

	/**
	 * 获取返回状态
	 * 
	 * @return
	 * @author sly
	 * @time 2018年11月12日
	 */
	public Integer getStatus() {
		return (Integer) get("status");
	}

	/**
	 * 设置返回状态
	 * 
	 * @param status
	 * @author sly
	 * @time 2018年11月12日
	 */
	public void setStatus(Integer status) {
		put("status", status);
	}

	/**
	 * 获取返回信息
	 * 
	 * @return
	 * @author sly
	 * @time 2018年11月12日
	 */
	public String getMessage() {
		return (String) get("message");
	}

	/**
	 * 设置返回信息
	 * 
	 * @param message
	 * @author sly
	 * @time 2018年11月12日
	 */
	public void setMessage(String message) {
		put("message", message);
	}

	/**
	 * 获取返回分页数据
	 * 
	 * @return
	 * @author sly
	 * @time 2018年11月12日
	 */
	public List<?> getRows() {
		return (List<?>) get("rows");
	}

	/**
	 * 设置返回分页数据
	 * 
	 * @param rows
	 * @author sly
	 * @time 2018年11月12日
	 */
	public void setRows(List<?> rows) {
		put("rows", rows);
	}

	/**
	 * 获取返回分页数据数量
	 * 
	 * @return
	 * @author sly
	 * @time 2018年11月12日
	 */
	public Integer getTotal() {
		return (Integer) get("total");
	}

	/**
	 * 设置返回分页数据数量
	 * 
	 * @return
	 * @author sly
	 * @time 2018年11月12日
	 */
	public void setTotal(Integer total) {
		put("total", total);
	}

	/**
	 * 设置数据map
	 * 
	 * @param dataMap
	 * @author sly
	 * @time 2018年11月12日
	 */
	public void setDataMap(Map<String, Object> dataMap) {
		Set<String> keySet = dataMap.keySet();
		for (String key : keySet) {
			this.put(key, dataMap.get(key));
		}
	}

	/**
	 * 获取结果里的对象
	 * 
	 * @param key
	 * @param clazz
	 * @return
	 * @author sly
	 * @time 2019年11月2日
	 */
	public <T> T getResultObject(String key, Class<T> clazz) {
		return JSON.parseObject(JSON.toJSONString(get(key)), clazz);

	}

	/**
	 * 获取结果里的list
	 * 
	 * @param key
	 * @param clazz
	 * @return
	 * @author sly
	 * @time 2019年11月2日
	 */
	public <T> List<T> getResultArray(String key, Class<T> clazz) {
		return JSON.parseArray(JSON.toJSONString(get(key)), clazz);
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @author sly
	 * @time 2019年11月2日
	 */
	public BaseResult append(String key, Object value) {
		put(key, value);
		return this;
	}

}
