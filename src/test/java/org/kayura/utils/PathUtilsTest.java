/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.utils;


import org.junit.Test;

/**
 * @author liangxia@live.com
 */
public class PathUtilsTest {
	
	@Test
	public void mergeATest() {
		String format = PathUtils.merge("/aa/aff/", "/fds/afds/fdsaf/");
		System.out.println(format);
	}
	
}
