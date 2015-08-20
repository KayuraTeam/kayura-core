/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author liangxia@live.com
 *
 */
public class PageList<E> implements Serializable {

	private static final long serialVersionUID = 1611112691285620907L;

	private List<E> rows;
	private Paginator paginator;

	public PageList() {
		rows = new ArrayList<E>();
	}

	public PageList(Collection<? extends E> data) {
		this();
		rows.addAll(data);
	}

	public PageList(Collection<? extends E> data, Paginator paginator) {
		this(data);
		this.paginator = paginator;
	}

	public PageList(Paginator paginator) {
		this.paginator = paginator;
	}

	public Paginator getPaginator() {
		return paginator;
	}

	public int getTotalPages() {
		return paginator.getTotalPages();
	}

	public int getTotalCount() {
		return paginator.getTotalCount();
	}

	public int getPageIndex() {
		return paginator.getPageIndex();
	}

	public List<E> getRows() {
		return rows;
	}

	public void setRows(List<E> rows) {
		this.rows = rows;
	}
}
