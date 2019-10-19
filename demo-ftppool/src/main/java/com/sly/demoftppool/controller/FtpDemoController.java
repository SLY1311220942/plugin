package com.sly.demoftppool.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sly.plugin.common.utils.CommonUtils;
import com.sly.plugin.ftp.factory.FTPClientHelper;

@Controller
@RequestMapping("/ftpDemo")
public class FtpDemoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FtpDemoController.class);

	@Autowired
	private FTPClientHelper ftpClientHelper;

	@ResponseBody
	@RequestMapping("/upload")
	public Object upload(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String filePath = "D:\\Test\\ftpPool\\testUplodFile.txt";
			InputStream inputStream = new FileInputStream(filePath);
			if (ftpClientHelper.storeFile("/ftpdemo/" + CommonUtils.genUUID() + ".txt", inputStream)) {
				result.put("status", 200);
			} else {
				result.put("status", 400);
			}

		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));

		}
		return result;

	}

	@RequestMapping("/toUplod")
	public String toUplod(HttpServletRequest request, HttpServletResponse response) {
		return "/index.html";
	}

}
