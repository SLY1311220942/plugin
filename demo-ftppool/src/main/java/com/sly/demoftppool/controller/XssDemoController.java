package com.sly.demoftppool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sly.plugin.common.result.BaseResult;
import com.sly.plugin.common.result.ResultStatus;

@Controller
@RequestMapping("/xssDemo")
public class XssDemoController {

	/**
	 * 测试拦截
	 * 
	 * @param keyWord
	 * @return
	 * @author sly
	 * @time 2019年10月19日
	 */
	@ResponseBody
	@RequestMapping("/testXssFilter")
	public BaseResult testXssFilter(String keyWord) {
		System.out.println();
		return new BaseResult(ResultStatus.QUERY_SUCCESS, "keyWord", keyWord);
	}

	/**
	 * 测试不拦截
	 * 
	 * @param keyWord
	 * @return
	 * @author sly
	 * @time 2019年10月19日
	 */
	@ResponseBody
	@RequestMapping("/unFilter")
	public BaseResult unFilter(String keyWord) {
		System.out.println();
		return new BaseResult(ResultStatus.QUERY_SUCCESS, "keyWord", keyWord);
	}
}
