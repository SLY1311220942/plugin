package com.sly.plugin.urf.mapper;

import com.sly.plugin.urf.model.Func;

/**
 * 功能mapper
 * 
 * @author sly
 * @time 2019年11月5日
 */
public interface FuncMapper {
	/**
	 * 新增
	 * 
	 * @param func
	 * @return
	 * @author sly
	 * @time 2019年11月5日
	 */
	int add(Func func);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 * @author sly
	 * @time 2019年11月5日
	 */
	int delete(String id);

	/**
	 * 修改
	 * 
	 * @param func
	 * @return
	 * @author sly
	 * @time 2019年11月5日
	 */
	int update(Func func);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 * @author sly
	 * @time 2019年11月5日
	 */
	Func selectById(String id);

}
