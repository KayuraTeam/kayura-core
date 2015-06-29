/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.mybatis.plugin;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @author liangxia@live.com
 *
 */
public class PagerInterceptorTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("mybatisconfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		
	}

	@Test
	public void selectPagerTest() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			List<Map<Object, Object>> users = sqlSession.selectList("test.getUsers", null, new RowBounds());
			System.out.println(users);
		} finally {
			sqlSession.close();
		}
	}

}
