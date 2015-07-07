/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liangxia@live.com
 *
 */
public class DateUtils {

	public static Date now() {
		return new Date(System.currentTimeMillis());
	}

	public static String now(String format) {
		return format(now(), format);
	}

	public static String format(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
}
