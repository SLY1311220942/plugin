package com.sly.plugin.antiduplicatecommit.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sly.plugin.antiduplicatecommit.aop.AntiDuplicateCommitAspect;
import com.sly.plugin.antiduplicatecommit.properties.AntiDuplicateCommitProperties;

/**
 * 反重复提交配置类
 * @author sly
 * @time 2019年5月16日
 */
@Configuration
@EnableConfigurationProperties(AntiDuplicateCommitProperties.class)
public class AntiDuplicateCommitConfig {
	@Bean
	public AntiDuplicateCommitAspect getAntiDuplicateCommitAspect(AntiDuplicateCommitProperties properties) {
		System.out.println("初始化反重复提插件...");
		AntiDuplicateCommitAspect antiDuplicateCommitAspect = new AntiDuplicateCommitAspect();
		antiDuplicateCommitAspect.setAntiDuplicateCommitProperties(properties);
		return antiDuplicateCommitAspect;
	}
}
