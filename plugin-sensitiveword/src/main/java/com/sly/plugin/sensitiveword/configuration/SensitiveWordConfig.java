package com.sly.plugin.sensitiveword.configuration;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.sly.plugin.sensitiveword.filter.SensitivewordFilter;
import com.sly.plugin.sensitiveword.init.SensitiveWordInit;
import com.sly.plugin.sensitiveword.properties.SensitiveWordProperties;

/**
 * 配置敏感词验证
 * 
 * @author sly
 * @time 2019年6月27日
 */
@Configuration
@EnableConfigurationProperties(SensitiveWordProperties.class)
public class SensitiveWordConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(SensitiveWordConfig.class);

	/**
	 * 敏感词验证注册
	 * 
	 * @param sensitiveWordProperties
	 * @return
	 * @author sly
	 * @time 2019年6月27日
	 */
	@Bean
	public SensitivewordFilter getSensitivewordFilter(SensitiveWordProperties sensitiveWordProperties) {
		SensitivewordFilter sensitivewordFilter = new SensitivewordFilter(sensitiveWordProperties);

		if (StringUtils.isNotBlank(sensitiveWordProperties.getWordFileLocation())) {
			SensitiveWordInit sensitiveWordInit = new SensitiveWordInit();
			ClassPathResource classPathResource = new ClassPathResource(sensitiveWordProperties.getWordFileLocation());
			InputStream inputStream = null;
			try {
				inputStream = classPathResource.getInputStream();
				sensitivewordFilter.sensitiveWordMap = sensitiveWordInit.initKeyWord(inputStream);
				sensitivewordFilter.sensitiveWordset = sensitiveWordInit.sensitiveWordset;
			} catch (IOException e) {
				LOGGER.error(ExceptionUtils.getStackTrace(e));
				throw new RuntimeException("敏感词验证对象初始化失败", e);
			} finally {
				if(inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						LOGGER.error(ExceptionUtils.getStackTrace(e));
					}
				}
			}

		}

		return sensitivewordFilter;
	}
}
