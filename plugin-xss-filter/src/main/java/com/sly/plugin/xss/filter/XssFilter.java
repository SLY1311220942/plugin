package com.sly.plugin.xss.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sly.plugin.xss.properties.XssFilterProperties;
/**
 * xss过滤器
 * @author sly
 * @time 2018年12月12日
 */
public class XssFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(XssHttpServletRequestWrapper.class);
	
	private XssFilterProperties properties;
	
	/**
	 * 无参构造器
	 */
	public XssFilter() {
		
	}
	
	/**
	 * 有参构造器
	 * @param properties
	 */
	public XssFilter(XssFilterProperties properties) {
		this.properties = properties;
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("XssFilter初始化...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String uri = httpServletRequest.getRequestURI();
		String contextPath = httpServletRequest.getContextPath();
		String requestPath = uri.replaceFirst(contextPath, "").replaceFirst("/+", "/");
		
		if (isExcludePath(requestPath)) {
			chain.doFilter(request, response);// 放行
		}else {
			XssHttpServletRequestWrapper xssHttpServletRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request, properties);
			chain.doFilter(xssHttpServletRequest, response);
		}
		
		
	}

	@Override
	public void destroy() {
		LOGGER.info("XssFilter销毁...");
	}
	
	/**
	 * 判断是否为排除路径
	 * @param requestPath
	 * @return
	 * @author sly
	 * @time 2019年6月18日
	 */
	private boolean isExcludePath(String requestPath) {
		String[] excludePaths = properties.getExclude().getExcludePath();
		for (String excludePath : excludePaths) {
			if(requestPath.startsWith(excludePath)) {
				return true;
			}
		}
		return false;
	}

}
