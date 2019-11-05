package com.sly.plugin.urf.mapper;

import com.sly.plugin.urf.model.Role;

/**
 * 角色mapper
 * 
 * @author sly
 * @time 2019年11月5日
 */
public interface RoleMapper {
	/**
	 * 新增
	 * 
	 * @param role
	 * @return
	 * @author sly
	 * @time 2019年11月5日
	 */
	int add(Role role);

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
	 * @param role
	 * @return
	 * @author sly
	 * @time 2019年11月5日
	 */
	int update(Role role);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 * @author sly
	 * @time 2019年11月5日
	 */
	Role selectById(String id);
}
