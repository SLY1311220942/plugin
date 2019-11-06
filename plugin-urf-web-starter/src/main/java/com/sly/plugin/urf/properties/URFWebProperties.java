package com.sly.plugin.urf.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * URF web端配置文件
 * 
 * @author sly
 * @time 2019年11月6日
 */
@ConfigurationProperties(prefix = "plugin.urf")
public class URFWebProperties {
	private String serviceUrl = "";

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

}
