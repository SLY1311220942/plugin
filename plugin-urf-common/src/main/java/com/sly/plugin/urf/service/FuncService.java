package com.sly.plugin.urf.service;

import org.springframework.web.bind.annotation.RequestMapping;

import com.sly.plugin.common.result.BaseResult;

public interface FuncService {
	/**
	 * 根据id查询功能
	 * 
	 * @param id
	 * @return
	 * @author sly
	 * @time 2019年11月6日
	 */
	@RequestMapping("/func/findById")
	BaseResult findById(String id);

}
