/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.kayura.mybatis.type.PageBounds;
import org.kayura.type.PageList;
import org.springframework.ui.Model;

/**
 * @author liangxia@live.com
 *
 */
public interface UISupport {
	
	/**
	 * 用于从提供请求信息中获取分页信息.
	 * @param req Http提供请求信息.
	 * @return 分页信息对象.
	 */
	PageBounds getPageBounds(HttpServletRequest req);
	
	/**
	 * 向请求结果集添加数据.
	 * <li>totalCount: 表示总记录数.<br>
	 * <li>data: 表示查询结果集.<br><br>
	 * @param model
	 * @param pageList
	 */
	void putData(Model model, PageList<?> pageList);
		
	/**
	 * 向请求结果集添加数据.
	 * <li>totalCount: 表示总记录数.<br>
	 * <li>data: 表示查询结果集.<br><br>
	 * @param model
	 * @param pageList
	 */
	void putData(Map<String, Object> map, PageList<?> pageList);
}
