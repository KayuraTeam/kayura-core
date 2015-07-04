/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.mybatis.plugin;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.kayura.mybatis.type.PageBounds;
import org.kayura.type.PageList;

/**
 * @author liangxia@live.com
 *
 */
public class PagerInterceptorTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		InputStream inputStream = Resources
				.getResourceAsStream("mybatisconfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void selectPagerTest() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			PageBounds bounds = new PageBounds(2, 2);
			List<Map<Object, Object>> data = sqlSession.selectList(
					"test.getUsers", null, bounds);
			
			PageList<Map<Object, Object>> users = (PageList<Map<Object, Object>>)data;
			
			System.out.println(users);
		} finally {
			sqlSession.close();
		}
	}

}
