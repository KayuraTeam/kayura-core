/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.mybatis.plugin;

import org.kayura.logging.Log;
import org.kayura.logging.LogFactory;
import org.kayura.mybatis.type.PageBounds;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import sun.reflect.generics.scope.ClassScope;

/**
 * @author liangxia@live.com
 * 
 */
@Intercepts(value = { @Signature(type = Executor.class, method = "query", args = {
		MappedStatement.class, Object.class, RowBounds.class,
		ResultHandler.class }) })
public class PagerInterceptor implements Interceptor {

	private static Log log = LogFactory.getLog(PagerInterceptor.class);

	private String dialectClass;

	public Object intercept(Invocation invocation) throws Throwable {
		final Object[] args = invocation.getArgs();

		final Executor executor = (Executor) invocation.getTarget();
		final MappedStatement ms = (MappedStatement) args[0];
		final Object parameter = args[1];
		final RowBounds rowBounds = (RowBounds) args[2];
		final PageBounds pageBounds = new PageBounds(rowBounds);

		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		String dialect = properties.getProperty("dialect");
		setDialectClass(dialect);
	}

	public void setDialectClass(String dialectClass) {
		this.dialectClass = dialectClass;
		try {
			Class.forName(dialectClass);
			
		} catch (Exception e) {
			log.error("PagerInterceptor 插件 dialectClass 错误。", e);
		}
	}

}
