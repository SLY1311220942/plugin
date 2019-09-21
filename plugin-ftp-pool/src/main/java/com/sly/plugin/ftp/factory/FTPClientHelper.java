package com.sly.plugin.ftp.factory;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sly.plugin.common.utils.CommonUtils;
import com.sly.plugin.ftp.pool.FTPClientPool;

/**
 * ftp客户端辅助帮助类
 * 
 * @author sly
 * @time 2019年9月20日
 */
public class FTPClientHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(FTPClientHelper.class);

	private FTPClientPool ftpClientPool;

	public void setFtpClientPool(FTPClientPool ftpClientPool) {
		this.ftpClientPool = ftpClientPool;
	}

	/**
	 * 上传文件
	 * 
	 * @param remoteDir
	 * @param remoteFile
	 * @param inputStream
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年9月20日
	 */
	public boolean storeFile(String remoteDir, String remoteFile, InputStream inputStream) {

		FTPClient client = null;
		try {

			long start = System.currentTimeMillis();
			client = ftpClientPool.borrowObject();
			client.makeDirectory(remoteDir);
			boolean b = client.storeFile(remoteDir + "/" + remoteFile, inputStream);
			long end = System.currentTimeMillis();
			System.out.println("ftp上传耗时(毫秒):" + (end - start));
			return b;
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		} finally {
			ftpClientPool.returnObject(client);
		}
		return false;

	}

	/**
	 * 下载 remote文件 流
	 * 
	 * @param remote
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年9月20日
	 */
	public byte[] retrieveFileStream(String remote) {
		FTPClient client = null;
		InputStream in = null;
		try {
			long start = System.currentTimeMillis();
			client = ftpClientPool.borrowObject();
			in = client.retrieveFileStream(remote);

			long end = System.currentTimeMillis();
			System.out.println("ftp下载耗时(毫秒):" + (end - start));

			if (in != null) {
				return CommonUtils.inputStreamToByteArray(in);
			} else {
				return new byte[0];
			}

		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (client != null) {
				try {
					client.logout();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					client.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			ftpClientPool.returnObject(client);
		}
		return new byte[0];
	}

	/**
	 * 创建目录 单个 不可递归
	 * 
	 * @param pathname
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年9月20日
	 */
	public boolean makeDirectory(String pathname) {

		FTPClient client = null;
		try {
			client = ftpClientPool.borrowObject();
			return client.makeDirectory(pathname);
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		} finally {
			ftpClientPool.returnObject(client);
		}
		return false;
	}

	/**
	 * 删除目录，单个，不可递归
	 * 
	 * @param pathname
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年9月20日
	 */
	public boolean removeDirectory(String pathname) {
		FTPClient client = null;
		try {
			client = ftpClientPool.borrowObject();
			return client.removeDirectory(pathname);
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		} finally {
			ftpClientPool.returnObject(client);
		}
		return false;
	}

	/**
	 * 删除文件 单个 ，不可递归
	 * 
	 * @param pathname
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年9月20日
	 */
	public boolean deleteFile(String pathname) {

		FTPClient client = null;
		try {
			client = ftpClientPool.borrowObject();
			return client.deleteFile(pathname);
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		} finally {
			ftpClientPool.returnObject(client);
		}
		return false;
	}

	/**
	 * 上传文件
	 * 
	 * @param remote
	 * @param inputStream
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年9月20日
	 */
	public boolean storeFile(String remote, InputStream inputStream) {

		FTPClient client = null;
		try {
			client = ftpClientPool.borrowObject();
			return client.storeFile(remote, inputStream);
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
		} finally {
			ftpClientPool.returnObject(client);
		}
		return false;
	}

}
