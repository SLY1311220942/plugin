package com.sly.plugin.email.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.sly.plugin.email.configuration.EmailSenderConfig;

/**
 * 开启邮件发送配置注解
 * @author sly
 * @time 2019年7月11日
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(EmailSenderConfig.class)
public @interface EnableEmailSender {

}
