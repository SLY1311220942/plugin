package com.sly.plugin.ftp.properties;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * FTP 配置参数对象 继承自GenericObjectPoolConfig
 * 
 * @author sly
 * @time 2019年9月20日
 */
@ConfigurationProperties(prefix = "plugin.ftp-pool")
public class FtpPoolProperties extends GenericObjectPoolConfig<FTPClient> {
	/** 主机名 */
	private String host;
	
	/** 端口 */
	private int port = 21;
	
	/** 用户名 */
	private String username;
	
	/** 密码 */
	private String password;
	
	/** 项目合同文件保存的根目录 */
	private String projectRoot;
	
	/** ftp 连接超时时间 毫秒 */
	private int connectTimeOut = 5000;
	
	/** 编码 */
	private String controlEncoding = "utf-8";
	
	/** 缓冲区大小 */
	private int bufferSize = 1024;
	
	/** 传输数据格式 二进制数据 */
	private int fileType = 2;
	
	/** 超时时间 */
	private int dataTimeout = 120000;
	
	/**  */
	private boolean useEPSVwithIPv4 = false;
	
	/** 是否启用被动模式 */
	private boolean passiveMode = true;

	public int getConnectTimeOut() {
		return connectTimeOut;
	}

	public void setConnectTimeOut(int connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProjectRoot() {
		return projectRoot;
	}

	public void setProjectRoot(String projectRoot) {
		this.projectRoot = projectRoot;
	}

	public String getControlEncoding() {
		return controlEncoding;
	}

	public void setControlEncoding(String controlEncoding) {
		this.controlEncoding = controlEncoding;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public int getDataTimeout() {
		return dataTimeout;
	}

	public void setDataTimeout(int dataTimeout) {
		this.dataTimeout = dataTimeout;
	}

	public boolean isUseEPSVwithIPv4() {
		return useEPSVwithIPv4;
	}

	public void setUseEPSVwithIPv4(boolean useEPSVwithIPv4) {
		this.useEPSVwithIPv4 = useEPSVwithIPv4;
	}

	public boolean isPassiveMode() {
		return passiveMode;
	}

	public void setPassiveMode(boolean passiveMode) {
		this.passiveMode = passiveMode;
	}

}
