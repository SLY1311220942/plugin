package com.sly.plugin.urf.model;

import com.sly.plugin.common.model.BaseModel;

/**
 * 角色model
 * 
 * @author sly
 * @time 2019年11月3日
 */
public class Role extends BaseModel {

	private static final long serialVersionUID = 1559834147726149695L;

	/** id varchar(32) NOT NULL主键UUID */
	private String id;
	/** userId varchar(32) NULL用户ID */
	private String userId;
	/** roleName varchar(32) NULL角色名称 */
	private String roleName;
	/** createTime varchar(24) NULL创建时间 */
	private String createTime;
	/** updateTime varchar(24) NULL修改时间 */
	private String updateTime;
	/** isOpen tinyint(4) NULL是否启用:0.关闭 1.启用 */
	private Integer isOpen;
	/** logicDel tinyint(4) NULL逻辑删除:0.未删除 1.删除 */
	private Integer logicDel;
	/** remark varchar(240) NULL备注 */
	private String remark;
	/** projectKZ1 text NULL扩展字段1 */
	private String projectKZ1;
	/** projectKZ2 text NULL扩展字段2 */
	private String projectKZ2;
	/** projectKZ3 text NULL扩展字段3 */
	private String projectKZ3;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}

	public Integer getLogicDel() {
		return logicDel;
	}

	public void setLogicDel(Integer logicDel) {
		this.logicDel = logicDel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getProjectKZ1() {
		return projectKZ1;
	}

	public void setProjectKZ1(String projectKZ1) {
		this.projectKZ1 = projectKZ1;
	}

	public String getProjectKZ2() {
		return projectKZ2;
	}

	public void setProjectKZ2(String projectKZ2) {
		this.projectKZ2 = projectKZ2;
	}

	public String getProjectKZ3() {
		return projectKZ3;
	}

	public void setProjectKZ3(String projectKZ3) {
		this.projectKZ3 = projectKZ3;
	}

}
