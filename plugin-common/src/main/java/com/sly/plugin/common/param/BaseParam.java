package com.sly.plugin.common.param;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class BaseParam extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	/**
	 * 无参构造方法
	 */
	public BaseParam() {

	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public BaseParam(String key, Object value) {
		put(key, value);
	}

	/**
	 * 
	 * @param key1
	 * @param value1
	 * @param key2
	 * @param value2
	 */
	public BaseParam(String key1, Object value1, String key2, Object value2) {
		put(key1, value1);
		put(key2, value2);
	}

	/**
	 * 
	 * @param key1
	 * @param value1
	 * @param key2
	 * @param value2
	 * @param key3
	 * @param value3
	 */
	public BaseParam(String key1, Object value1, String key2, Object value2, String key3, Object value3) {
		put(key1, value1);
		put(key2, value2);
		put(key3, value3);
	}

	/**
	 * 
	 * @param key1
	 * @param value1
	 * @param key2
	 * @param value2
	 * @param key3
	 * @param value3
	 * @param key4
	 * @param value4
	 */
	public BaseParam(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4,
			Object value4) {
		put(key1, value1);
		put(key2, value2);
		put(key3, value3);
		put(key4, value4);
	}

	/**
	 * 添加方法（返回自身）
	 * 
	 * @return
	 * @author sly
	 * @time 2019年11月2日
	 */
	public BaseParam append(String key, Object value) {
		put(key, value);
		return this;
	}

	/**
	 * 获取参数里的对象
	 * 
	 * @param key
	 * @param clazz
	 * @return
	 * @author sly
	 * @time 2019年11月2日
	 */
	public <T> T getParamObject(String key, Class<T> clazz) {
		return JSON.parseObject(JSON.toJSONString(get(key)), clazz);

	}

	/**
	 * 获取参数里的list
	 * 
	 * @param key
	 * @param clazz
	 * @return
	 * @author sly
	 * @time 2019年11月2日
	 */
	public <T> List<T> getParamArray(String key, Class<T> clazz) {
		return JSON.parseArray(JSON.toJSONString(get(key)), clazz);
	}

}
