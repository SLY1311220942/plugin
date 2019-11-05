package com.sly.plugin.urf.mapper;

import com.sly.plugin.urf.model.User;

/**
 * 用户mapper
 * 
 * @author sly
 * @time 2019年11月5日
 */
public interface UserMapper {

	/**
	 * 新增
	 * 
	 * @param user
	 * @return
	 * @author sly
	 * @time 2019年11月5日
	 */
	int add(User user);

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
	 * @param user
	 * @return
	 * @author sly
	 * @time 2019年11月5日
	 */
	int update(User user);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 * @author sly
	 * @time 2019年11月5日
	 */
	User selectById(String id);
}
