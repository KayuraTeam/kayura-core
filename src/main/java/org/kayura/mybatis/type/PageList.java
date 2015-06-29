/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.mybatis.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liangxia@live.com
 *
 */
public class PageList<E> implements Serializable {

	private static final long serialVersionUID = 1611112691285620907L;

	private List<E> data;
	private Integer totleRecords;

	public PageList(List<E> data) {
		this(data, -1);
	}

	public PageList(List<E> data, Integer totleRecords) {
		this.data = new ArrayList<E>();
		this.data.addAll(data);
		this.totleRecords = totleRecords;
	}

	public List<E> getData() {
		return data;
	}

	public Integer getTotleRecords() {
		return totleRecords;
	}

	public void setTotleRecords(Integer totleRecords) {
		this.totleRecords = totleRecords;
	}

}
