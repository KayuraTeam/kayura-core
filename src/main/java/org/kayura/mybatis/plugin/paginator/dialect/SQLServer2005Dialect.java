/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.mybatis.plugin.paginator.dialect;

import java.util.Locale;

import org.apache.ibatis.mapping.BoundSql;
import org.kayura.mybatis.plugin.paginator.Dialect;
import org.kayura.mybatis.type.PageBounds;

/**
 * @author liangxia@live.com
 *
 */
public class SQLServer2005Dialect extends Dialect {

	private static final String SELECT = "select";
	private static final String SELECT_WITH_SPACE = SELECT + ' ';
	private static final String DISTINCT = "distinct";
	private static final String ORDER_BY = "order by";
	
	public SQLServer2005Dialect(BoundSql boundSql, PageBounds pageBounds) {
		super(boundSql, pageBounds);
	}

	@Override
	public String getLimitString(String queryString, int offset, int limit) {
		
		final StringBuilder sb = new StringBuilder( queryString );
		
		if ( sb.charAt( sb.length() - 1 ) == ';' ) {
			sb.setLength( sb.length() - 1 );
		}

		final String selectClause = "*";

		final int orderByIndex = shallowIndexOfWord( sb, ORDER_BY, 0 );
		if ( orderByIndex > 0 ) {
			// ORDER BY requires using TOP.
			addTopExpression( sb );
		}

		encloseWithOuterQuery( sb );

		// Wrap the query within a with statement:
		sb.insert( 0, "WITH query AS (" ).append( ") SELECT " ).append( selectClause ).append( " FROM query " );
		sb.append( "WHERE __mybatis_row_nr__ >= ").append(offset).append(" AND __mybatis_row_nr__ < ").append(limit);

		return sb.toString();
	}
	
	private void encloseWithOuterQuery(StringBuilder sb) {
		sb.insert( 0, "SELECT inner_query.*, ROW_NUMBER() OVER (ORDER BY CURRENT_TIMESTAMP) as __mybatis_row_nr__ FROM ( " );
		sb.append( " ) inner_query " );
	}

	private void addTopExpression(StringBuilder sql) {
		final int distinctStartPos = shallowIndexOfWord( sql, DISTINCT, 0 );
		if ( distinctStartPos > 0 ) {
			// Place TOP after DISTINCT.
			sql.insert( distinctStartPos + DISTINCT.length(), " TOP(?)" );
		}
		else {
			final int selectStartPos = shallowIndexOf( sql, SELECT_WITH_SPACE, 0 );
			// Place TOP after SELECT.
			sql.insert( selectStartPos + SELECT.length(), " TOP(?)" );
		}
	}

	private static int shallowIndexOfWord(final StringBuilder sb, final String search, int fromIndex) {
		final int index = shallowIndexOf( sb, ' ' + search + ' ', fromIndex );
		return index != -1 ? ( index + 1 ) : -1;
	}
	
	private static int shallowIndexOf(StringBuilder sb, String search, int fromIndex) {
		final String lowercase = sb.toString().toLowerCase(Locale.ROOT);
		final int len = lowercase.length();
		final int searchlen = search.length();
		int pos = -1;
		int depth = 0;
		int cur = fromIndex;
		do {
			pos = lowercase.indexOf( search, cur );
			if ( pos != -1 ) {
				for ( int iter = cur; iter < pos; iter++ ) {
					final char c = sb.charAt( iter );
					if ( c == '(' ) {
						depth = depth + 1;
					}
					else if ( c == ')' ) {
						depth = depth - 1;
					}
				}
				cur = pos + searchlen;
			}
		} while ( cur < len && depth != 0 && pos != -1 );
		return depth == 0 ? pos : -1;
	}
}
