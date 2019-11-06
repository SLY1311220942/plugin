package com.sly.plugin.urf.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;
import com.sly.plugin.urf.service.FuncService;

/**
 * 功能controller
 * 
 * @author sly
 * @time 2019年11月6日
 */
@Controller
@RequestMapping("/func")
public class FuncController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FuncController.class);

	@Autowired
	private FuncService funcService;

	/**
	 * 根据id查询功能
	 * 
	 * @param id
	 * @return
	 * @author sly
	 * @time 2019年11月6日
	 */
	@ResponseBody
	@RequestMapping("/findFuncDetail")
	public BaseResult findFuncDetail(String id) {
		try {
			return funcService.findById(id);
		} catch (Exception e) {
			LOGGER.error(ExceptionUtils.getStackTrace(e));
			return new BaseResult(ResultStatus.QUERY_FAILED);
		}
	}
}
