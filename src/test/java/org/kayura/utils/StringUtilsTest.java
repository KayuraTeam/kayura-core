package org.kayura.utils;


import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void cleanSymbolsTest() {
		String str = "中@华$人%民:共m和9国,{}'[]";
		String result = StringUtils.cleanSpecial(str);
		System.out.println(result);
	}

	@Test
	public void cleanSpaceTest(){
		String str = "中 华 a 人 民 共\rm和 国 ";
		String result = StringUtils.cleanSpace(str);
		System.out.println(result);		
	}
}
