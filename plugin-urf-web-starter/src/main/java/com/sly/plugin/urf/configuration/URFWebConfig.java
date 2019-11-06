package com.sly.plugin.urf.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sly.plugin.urf.properties.URFWebProperties;
import com.sly.plugin.urf.service.FuncService;
import com.sly.plugin.urf.service.RoleFuncService;
import com.sly.plugin.urf.service.RoleService;
import com.sly.plugin.urf.service.UserRoleService;
import com.sly.plugin.urf.service.UserService;

import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;

@Configuration
@ComponentScan("com.sly.plugin.urf.controller")
@EnableConfigurationProperties(URFWebProperties.class)
public class URFWebConfig {

	@Autowired
	private URFWebProperties urfWebProperties;

	/**
	 * 用户feign客户端
	 * 
	 * @param contract
	 * @param decoder
	 * @param encoder
	 * @return
	 * @author sly
	 * @time 2019年11月6日
	 */
	@Bean
	public UserService getUserService(Contract contract, Decoder decoder, Encoder encoder) {
		return Feign.builder().contract(contract).encoder(encoder).decoder(decoder).target(UserService.class,
				urfWebProperties.getServiceUrl());
	}

	/**
	 * 角色feign客户端
	 * 
	 * @param contract
	 * @param decoder
	 * @param encoder
	 * @return
	 * @author sly
	 * @time 2019年11月6日
	 */
	@Bean
	public RoleService getRoleService(Contract contract, Decoder decoder, Encoder encoder) {
		return Feign.builder().contract(contract).encoder(encoder).decoder(decoder).target(RoleService.class,
				urfWebProperties.getServiceUrl());
	}

	/**
	 * 功能feign客户端
	 * 
	 * @param contract
	 * @param decoder
	 * @param encoder
	 * @return
	 * @author sly
	 * @time 2019年11月6日
	 */
	@Bean
	public FuncService getFuncService(Contract contract, Decoder decoder, Encoder encoder) {
		return Feign.builder().contract(contract).encoder(encoder).decoder(decoder).target(FuncService.class,
				urfWebProperties.getServiceUrl());
	}

	/**
	 * 用户角色关系feign客户端
	 * 
	 * @param contract
	 * @param decoder
	 * @param encoder
	 * @return
	 * @author sly
	 * @time 2019年11月6日
	 */
	public UserRoleService getUserRoleService(Contract contract, Decoder decoder, Encoder encoder) {
		return Feign.builder().contract(contract).encoder(encoder).decoder(decoder).target(UserRoleService.class,
				urfWebProperties.getServiceUrl());
	}

	/**
	 * 角色功能关系feign客户端
	 * 
	 * @param contract
	 * @param decoder
	 * @param encoder
	 * @return
	 * @author sly
	 * @time 2019年11月6日
	 */
	public RoleFuncService getRoleFuncService(Contract contract, Decoder decoder, Encoder encoder) {
		return Feign.builder().contract(contract).encoder(encoder).decoder(decoder).target(RoleFuncService.class,
				urfWebProperties.getServiceUrl());
	}
}
