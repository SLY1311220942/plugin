package com.sly.plugin.urf.model;

import com.sly.plugin.common.model.BaseModel;

/**
 * 用户角色关系model
 * 
 * @author sly
 * @time 2019年11月3日
 */
public class UserRole extends BaseModel {

	private static final long serialVersionUID = -3484977638910177316L;

	/** id int(11) NOT NULL主键自增 */
	private Integer id;
	/** userId varchar(32) NULL用户ID */
	private String userId;
	/** roleId varchar(32) NULL角色ID */
	private String roleId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
