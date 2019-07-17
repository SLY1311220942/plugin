package com.sly.plugin.http.model;

import java.io.Serializable;

/**
 * http结果类
 * @author sly
 * @time 2019年4月12日
 */
public class HttpClientResult implements Serializable {

	private static final long serialVersionUID = 1694577204428565059L;

	/**
	 * 响应状态码
	 */
	private int code;

	/**
	 * 响应数据
	 */
	private String content;

	public HttpClientResult() {
	}

	public HttpClientResult(int code) {
		this.code = code;
	}

	public HttpClientResult(int code, String content) {
		this.code = code;
		this.content = content;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
