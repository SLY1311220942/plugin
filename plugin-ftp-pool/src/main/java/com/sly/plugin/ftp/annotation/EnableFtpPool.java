package com.sly.plugin.ftp.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.sly.plugin.ftp.configuration.FtpPoolConfig;

/**
 * 开启FTP连接池配置注解
 * 
 * @author sly
 * @time 2019年9月20日
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(FtpPoolConfig.class)
public @interface EnableFtpPool {

}
