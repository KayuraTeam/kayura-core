/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.mybatis.type;

import java.io.Serializable;

import org.apache.ibatis.session.RowBounds;

/**
 * @author liangxia@live.com
 *
 */
public class PageBounds extends RowBounds implements Serializable {

	private static final long serialVersionUID = -2108309143990112254L;
	private Integer pageIndex;
	private Integer pageSize;
	private Boolean containsTotalRecords;
	private String orderBy;

	/**
	 * 
	 * @param rowBounds
	 */
	public PageBounds(RowBounds rowBounds) {
		if (rowBounds instanceof PageBounds) {
			PageBounds pageBounds = (PageBounds) rowBounds;
			this.pageIndex = pageBounds.pageIndex;
			this.pageSize = pageBounds.pageSize;
			this.containsTotalRecords = pageBounds.containsTotalRecords;
			this.orderBy = pageBounds.orderBy;
		} else {
			this.pageIndex = (rowBounds.getOffset() / rowBounds.getLimit()) + 1;
			this.pageSize = rowBounds.getLimit();
		}
	}

	/**
	 * 分页参数类型构造方法.
	 * 
	 * @param pageIndex
	 *            将要访问的页数索引.
	 * @param pageSize
	 *            每页要显示的行数,如果该值小于等于零,表示不分页.
	 */
	public PageBounds(Integer pageIndex, Integer pageSize) {
		this(pageIndex, pageSize, true);
	}

	/**
	 * 分页参数类型构造方法.
	 * 
	 * @param pageIndex
	 *            将要访问的页数索引.
	 * @param pageSize
	 *            每页要显示的行数,如果该值小于等于零,表示不分页.
	 * @param containsTotalRecords
	 *            是否需要统计总记录数.
	 */
	public PageBounds(Integer pageIndex, Integer pageSize,
			Boolean containsTotalRecords) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.containsTotalRecords = containsTotalRecords;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	@Override
	public int getOffset() {
		if (pageIndex >= 1) {
			return (pageIndex - 1) * pageSize;
		}
		return 0;
	}

	@Override
	public int getLimit() {
		return pageSize;
	}

	public Boolean getAsyncTotalRecords() {
		return containsTotalRecords;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

}
