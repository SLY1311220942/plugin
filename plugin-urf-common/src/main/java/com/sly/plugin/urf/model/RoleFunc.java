package com.sly.plugin.urf.model;

import com.sly.plugin.common.model.BaseModel;

/**
 * 角色功能关系model
 * 
 * @author sly
 * @time 2019年11月3日
 */
public class RoleFunc extends BaseModel {

	private static final long serialVersionUID = -6571492708067013517L;

	/** id int(11) NOT NULL主键自增 */
	private Integer id;
	/** roleId varchar(32) NULL角色ID */
	private String roleId;
	/** funcId varchar(32) NULL功能ID */
	private String funcId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}
}
