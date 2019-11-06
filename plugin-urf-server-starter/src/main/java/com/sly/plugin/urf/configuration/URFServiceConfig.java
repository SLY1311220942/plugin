package com.sly.plugin.urf.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置urf service服务
 * 
 * @author sly
 * @time 2019年11月5日
 */
@Configuration
@MapperScan("com.sly.plugin.urf.mapper")
@ComponentScan("com.sly.plugin.urf.service.impl")
public class URFServiceConfig {
	
}
