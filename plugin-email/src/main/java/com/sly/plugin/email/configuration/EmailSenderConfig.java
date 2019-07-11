package com.sly.plugin.email.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sly.plugin.email.properties.EmailSenderProperties;
import com.sly.plugin.email.sender.EmailSender;

@Configuration
@EnableConfigurationProperties(EmailSenderProperties.class)
public class EmailSenderConfig {
	
	/**
	 * 邮件注册验证
	 * @param properties
	 * @return
	 * @author sly
	 * @time 2019年7月11日
	 */
	@Bean
	public EmailSender getEmailSender(EmailSenderProperties properties) {
		EmailSender emailSender = new EmailSender();
		emailSender.setEmailSenderProperties(properties);
		return emailSender; 
	}
}
