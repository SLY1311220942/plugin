package com.sly.plugin.ftp.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sly.plugin.ftp.factory.FTPClientFactory;
import com.sly.plugin.ftp.factory.FTPClientHelper;
import com.sly.plugin.ftp.pool.FTPClientPool;
import com.sly.plugin.ftp.properties.FtpPoolProperties;

/**
 * 配置FTP连接池
 * 
 * @author sly
 * @time 2019年9月20日
 */
@Configuration
@EnableConfigurationProperties(FtpPoolProperties.class)
public class FtpPoolConfig {

	/**
	 * FTP工厂类初始化
	 * 
	 * @param ftpPoolProperties
	 * @return
	 * @author sly
	 * @time 2019年9月20日
	 */
	@Bean
	public FTPClientFactory ftpClientFactory(FtpPoolProperties ftpPoolProperties) {
		FTPClientFactory ftpClientFactory = new FTPClientFactory();
		ftpClientFactory.setFtpPoolConfig(ftpPoolProperties);
		return ftpClientFactory;
	}

	/**
	 * FTPClientPool初始化
	 * 
	 * @param ftpClientFactory
	 * @return
	 * @author sly
	 * @time 2019年9月20日
	 */
	@Bean
	public FTPClientPool ftpClientPool(FTPClientFactory ftpClientFactory) {
		return new FTPClientPool(ftpClientFactory);
	}

	/**
	 * FTPClientHelper初始化
	 * 
	 * @param ftpClientPool
	 * @return
	 * @author sly
	 * @time 2019年9月20日
	 */
	@Bean
	public FTPClientHelper ftpClientHelper(FTPClientPool ftpClientPool) {
		FTPClientHelper ftpClientHelper = new FTPClientHelper();
		ftpClientHelper.setFtpClientPool(ftpClientPool);
		return ftpClientHelper;
	}
}
