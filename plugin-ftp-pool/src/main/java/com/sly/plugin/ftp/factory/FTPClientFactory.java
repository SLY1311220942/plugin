package com.sly.plugin.ftp.factory;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sly.plugin.common.exception.ServiceCustomException;
import com.sly.plugin.ftp.properties.FtpPoolProperties;

/**
 * ftpclient 工厂
 * 
 * @author jelly
 * @date 2018年10月10日 下午5:12:29
 *
 */
public class FTPClientFactory extends BasePooledObjectFactory<FTPClient> {

	private static final Logger LOGGER = LoggerFactory.getLogger(FTPClientFactory.class);

	private FtpPoolProperties ftpPoolConfig;

	public FtpPoolProperties getFtpPoolConfig() {
		return ftpPoolConfig;
	}

	public void setFtpPoolConfig(FtpPoolProperties ftpPoolConfig) {
		this.ftpPoolConfig = ftpPoolConfig;
	}

	/**
	 * 新建对象
	 * 
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年9月20日
	 */
	@Override
	public FTPClient create() throws Exception {
		FTPClient ftpClient = new FTPClient();
		ftpClient.setConnectTimeout(ftpPoolConfig.getConnectTimeOut());
		try {

			LOGGER.info("连接ftp服务器:" + ftpPoolConfig.getHost() + ":" + ftpPoolConfig.getPort());
			if (!ftpClient.isConnected()) {
				ftpClient.connect(ftpPoolConfig.getHost(), ftpPoolConfig.getPort());
			}
			

			int reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				LOGGER.error("FTPServer 拒绝连接");
				throw new ServiceCustomException(10001, "FTPServer 拒绝连接");
			}
			boolean result = ftpClient.login(ftpPoolConfig.getUsername(), ftpPoolConfig.getPassword());
			if (!result) {
				LOGGER.error("ftpClient登录失败!");
				throw new Exception("ftpClient登录失败! userName:" + ftpPoolConfig.getUsername() + ", password:"
						+ ftpPoolConfig.getPassword());
			}

			ftpClient.setControlEncoding(ftpPoolConfig.getControlEncoding());
			ftpClient.setBufferSize(ftpPoolConfig.getBufferSize());
			ftpClient.setFileType(ftpPoolConfig.getFileType());
			ftpClient.setDataTimeout(ftpPoolConfig.getDataTimeout());
			ftpClient.setUseEPSVwithIPv4(ftpPoolConfig.isUseEPSVwithIPv4());
			if (ftpPoolConfig.isPassiveMode()) {
				LOGGER.info("进入ftp被动模式");
				ftpClient.enterLocalPassiveMode();// 进入被动模式
			}
		} catch (IOException e) {
			LOGGER.error("FTP连接失败：", e);
		}
		return ftpClient;
	}

	/**
	 * 
	 * @param ftpClient
	 * @return
	 * @author sly
	 * @time 2019年9月20日
	 */
	@Override
	public PooledObject<FTPClient> wrap(FTPClient ftpClient) {
		return new DefaultPooledObject<FTPClient>(ftpClient);
	}

	/**
	 * 销毁对象
	 * 
	 * @param p
	 * @throws Exception
	 * @author sly
	 * @time 2019年9月20日
	 */
	@Override
	public void destroyObject(PooledObject<FTPClient> pooledObject) throws Exception {
		FTPClient ftpClient = pooledObject.getObject();
		ftpClient.logout();
		super.destroyObject(pooledObject);
	}

	/**
	 * 验证对象
	 * 
	 * @param p
	 * @return
	 * @author sly
	 * @time 2019年9月20日
	 */
	@Override
	public boolean validateObject(PooledObject<FTPClient> pooledObject) {
		FTPClient ftpClient = pooledObject.getObject();
		boolean connect = false;
		try {
			connect = ftpClient.sendNoOp();
		} catch (IOException e) {
			LOGGER.error("验证ftp连接对象,返回false");
		}
		return connect;
	}

}