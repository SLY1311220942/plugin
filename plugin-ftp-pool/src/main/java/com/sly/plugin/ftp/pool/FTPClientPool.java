package com.sly.plugin.ftp.pool;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.impl.GenericObjectPool;

import com.sly.plugin.ftp.factory.FTPClientFactory;

/**
 * FTP 客户端连接池
 * 
 * @author sly
 * @time 2019年9月20日
 */
public class FTPClientPool {

	private GenericObjectPool<FTPClient> pool;

	private FTPClientFactory clientFactory;

	/**
	 * 构造函数
	 * 
	 * @param clientFactory
	 * @author sly
	 * @time 2019年9月20日
	 */
	public FTPClientPool(FTPClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		pool = new GenericObjectPool<FTPClient>(clientFactory, clientFactory.getFtpPoolConfig());

	}

	public FTPClientFactory getClientFactory() {
		return clientFactory;
	}

	public GenericObjectPool<FTPClient> getPool() {
		return pool;
	}

	/**
	 * 获取一个连接对象
	 * 
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年9月20日
	 */
	public FTPClient borrowObject() throws Exception {
		FTPClient client = pool.borrowObject();
		return client;

	}

	/**
	 * 归还一个连接对象
	 * 
	 * @param ftpClient
	 * @author sly
	 * @time 2019年9月20日
	 */
	public void returnObject(FTPClient ftpClient) {

		if (ftpClient != null) {
			pool.returnObject(ftpClient);
		}
	}
}