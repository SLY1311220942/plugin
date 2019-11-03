package com.sly.plugin.urf.model;

import com.sly.plugin.common.model.BaseModel;

/**
 * 用户 model
 * 
 * @author sly
 * @time 2019年11月3日
 */
public class User extends BaseModel {

	private static final long serialVersionUID = -8462253590023475257L;

	/** id varchar(32) NOT NULL主键UUID */
	private String id;
	/** username varchar(32) NULL用户名称 */
	private String username;
	/** password varchar(32) NULL用户密码 */
	private String password;
	/** nickname varchar(32) NULL用户昵称 */
	private String nickname;
	/** realname varchar(64) NULL用户真实姓名 */
	private String realname;
	/** phone varchar(24) NULL用户移动电话 */
	private String phone;
	/** tel varchar(24) NULL用户电话 */
	private String tel;
	/** email varchar(64) NULL用户email */
	private String email;
	/** gender tinyint(4) NULL性别:男1 女0 */
	private Integer gender;
	/** createTime varchar(24) NULL创建时间 */
	private String createTime;
	/** updateTime varchar(24) NULL修改时间 */
	private String updateTime;
	/** tag tinyint(4) NULL用户类型:1.系统内置用户 2.普通用户 */
	private Integer tag;
	/** status tinyint(4) NULL用户状态:0.未激活 1.激活 2.封禁 */
	private Integer status;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
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

	public Integer getTag() {
		return tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
