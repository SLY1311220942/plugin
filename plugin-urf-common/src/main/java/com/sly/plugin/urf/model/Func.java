package com.sly.plugin.urf.model;

import com.sly.plugin.common.model.BaseModel;

/**
 * 功能model
 * 
 * @author sly
 * @time 2019年11月3日
 */
public class Func extends BaseModel {

	private static final long serialVersionUID = -3550588738934534055L;

	/** id varchar(32) NOT NULL主键 UUID */
	private String id;
	/** userId varchar(32) NULL用户ID */
	private String userId;
	/** funcName varchar(32) NULL功能名称 */
	private String funcName;
	/** funcIcon varchar(64) NULL功能图标 */
	private String funcIcon;
	/** funcUrl text NULL功能url */
	private String funcUrl;
	/** funcTag tinyint(4) NULL功能标签:0.菜单 1.按钮 */
	private Integer funcTag;
	/** funcType tinyint(4) NULL功能类型:0.系统内置 1.普通功能 */
	private Integer funcType;
	/** parentId varchar(32) NULL父功能ID */
	private String parentId;
	/** createTime varchar(24) NULL创建时间 */
	private String createTime;
	/** updateTime varchar(24) NULL修改时间 */
	private String updateTime;
	/** funcSort int(11) NULL功能排序 */
	private Integer funcSort;
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

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getFuncIcon() {
		return funcIcon;
	}

	public void setFuncIcon(String funcIcon) {
		this.funcIcon = funcIcon;
	}

	public String getFuncUrl() {
		return funcUrl;
	}

	public void setFuncUrl(String funcUrl) {
		this.funcUrl = funcUrl;
	}

	public Integer getFuncTag() {
		return funcTag;
	}

	public void setFuncTag(Integer funcTag) {
		this.funcTag = funcTag;
	}

	public Integer getFuncType() {
		return funcType;
	}

	public void setFuncType(Integer funcType) {
		this.funcType = funcType;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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

	public Integer getFuncSort() {
		return funcSort;
	}

	public void setFuncSort(Integer funcSort) {
		this.funcSort = funcSort;
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
