package com.sly.plugin.xss.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sly.plugin.xss.properties.XssFilterProperties;

/**
 * 描述 : 跨站请求防范
 * 
 * @author sly
 * @time 2019年6月18日
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
	private static final Logger LOGGER = LoggerFactory.getLogger(XssHttpServletRequestWrapper.class);

	HttpServletRequest orgRequest = null;
	private XssFilterProperties properties;

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		this.orgRequest = request;
	}

	public XssHttpServletRequestWrapper(HttpServletRequest request, XssFilterProperties properties) {
		super(request);
		this.orgRequest = request;
		this.properties = properties;
	}

	/**
	 * 获取参数
	 * 
	 * @param parameter
	 * @return
	 * @author sly
	 * @time 2018年12月12日
	 */
	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}

		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = cleanXSS(values[i]);
		}
		return encodedValues;
	}

	/**
	 * 获取单个参数
	 * 
	 * @param parameter
	 * @return
	 * @author sly
	 * @time 2018年12月12日
	 */
	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		if (value == null) {
			return null;
		}
		return cleanXSS(value);
	}

	/**
	 * 获取请求头
	 * 
	 * @param name
	 * @return
	 * @author sly
	 * @time 2018年12月12日
	 */
	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		if (value == null) {
			return null;
		}
		return cleanXSS(value);
	}

	/**
	 * 替换
	 * 
	 * @param value
	 * @return
	 * @author sly
	 * @time 2018年12月12日
	 */
	private String cleanXSS(String value) {
		String oldValue = new String(value);
		value = replaceStr(value);
		if (!oldValue.equals(value)) {
			LOGGER.info("替换前:" + oldValue);
			LOGGER.info("替换后:" + value);
		}
		return value;
	}

	/**
	 * 替换关键字
	 * 
	 * @param value
	 * @return
	 * @author sly
	 * @time 2019年6月18日
	 */
	private String replaceStr(String value) {
		// 循环比较SQL和xss关键字
		String[] sqlstr = properties.getFilter().getSqlstr();
		String[] nsqlstr = properties.getFilter().getNsqlstr();
		for (int i = 0; i < sqlstr.length; i++) {
			value = value.replaceAll("(?i)" + sqlstr[i], nsqlstr[i]);
		}
		return value;
	}

}
