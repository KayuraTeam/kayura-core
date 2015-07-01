/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.mybatis.plugin.paginator;

import org.apache.ibatis.mapping.BoundSql;
import org.kayura.mybatis.type.PageBounds;

/**
 * @author liang.xia
 *
 */
public abstract class Dialect {

	protected BoundSql boundSql;
	protected PageBounds pageBounds;

	public Dialect(BoundSql boundSql, PageBounds pageBounds) {
		this.boundSql = boundSql;
		this.pageBounds = pageBounds;
	}

	public String getCountString() {
		return getCountString(boundSql.getSql());
	}

	protected String getCountString(String queryString) {
		return "SELECT (1) FROM (" + queryString + ") __mybatis__table__";
	}

	public String getLimitString() {

		String sql = boundSql.getSql();
		int offset = pageBounds.getOffset();
		int limit = pageBounds.getLimit();

		return getLimitString(sql, offset, limit);
	}

	protected abstract String getLimitString(String queryString, int offset,
			int limit);
}
