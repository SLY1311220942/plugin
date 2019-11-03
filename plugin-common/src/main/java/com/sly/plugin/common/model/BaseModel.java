package com.sly.plugin.common.model;

import java.io.Serializable;

/**
 * 基础model,包含了分页字段
 * 
 * @author sly
 * @time 2019年11月3日
 */
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 5802378914129213676L;

	/** 分页大小 */
	private Integer pageSize = 10;
	/** 当前页 */
	private Integer currentPage = 1;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getStartNum() {
		return (currentPage - 1) * pageSize;
	}

}
