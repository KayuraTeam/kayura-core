/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.mybatis.plugin.paginator.dialect;

import org.apache.ibatis.mapping.BoundSql;
import org.kayura.mybatis.plugin.paginator.Dialect;
import org.kayura.mybatis.type.PageBounds;

/**
 * @author liangxia@live.com
 *
 */
public class MySQLDialect extends Dialect {

	/**
	 * @param boundSql
	 * @param pageBounds
	 */
	public MySQLDialect(BoundSql boundSql, PageBounds pageBounds) {
		super(boundSql, pageBounds);
	}

	@Override
	public String getLimitString(String queryString, int offset, int limit) {
		return queryString + (offset > 0 ? " limit ?, ?" : " limit ?");
	}

}
