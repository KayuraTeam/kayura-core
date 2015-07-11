/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.utils;

import java.util.regex.Pattern;

/**
 * 
 * @author liangxia@live.com
 */
public class StringUtils {

	public static final String SYMBOLS = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";

	/**
	 * 清除字符串中的特殊字符.
	 * @param source 源字符串.
	 * @return 返回清除后剩余的字符串.
	 */
	public static String cleanSpecial(String source) {
		return clean(source, SYMBOLS);
	}

	/**
	 * 清除所有空白字符串.
	 * @param source 源字符串.
	 * @return 返回清除后剩余的字符串.
	 */
	public static String cleanSpace(String source) {
		return source.replaceAll("\\s*", "");
	}

	/**
	 * 清除字符串中的指定字符.
	 * @param source 源字符串.
	 * @param symbols 要清除的匹配字符.
	 * @return 返回清除后剩余的字符串.
	 */
	public static String clean(String source, char[] symbols) {
		return clean(source, symbols.toString());
	}
	
	/**
	 * 清除字符串中的指定字符.
	 * @param source 源字符串.
	 * @param symbols 要清除的匹配字符.
	 * @return 返回清除后剩余的字符串.
	 */
	public static String clean(String source, String symbols) {
		return Pattern.compile(SYMBOLS).matcher(source).replaceAll("").trim();
	}

	/**
	 * 检查字符串是否为null或空字符或空白字符.
	 * @param str 源字符串.
	 * @return 若为null或空字符或空白字符，将返回 true.
	 */
	public static boolean isEmpty(String str) {
		return (str == null || "".equals(str.trim()));
	}

	public static boolean contains(char[] source, char symbols) {
		int strLen = source.length;
		for (int i = 0; i < strLen; i++) {
			if (symbols == source[i]) {
				return true;
			}
		}
		return false;
	}

	public static boolean contains(String source, char symbols) {
		int strLen = source.length();
		for (int i = 0; i < strLen; i++) {
			if (symbols == source.charAt(i)) {
				return true;
			}
		}
		return false;
	}
}
