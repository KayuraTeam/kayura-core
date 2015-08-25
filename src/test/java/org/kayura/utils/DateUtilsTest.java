package org.kayura.utils;

import java.util.Date;

import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void strToDateTest() {
		String format = DateUtils.formatDate(new Date());
		System.out.println(format);
	}

	@Test
	public void strToDateTimeTest() {
		String format = DateUtils.format(new Date());
		System.out.println(format);
	}

	@Test
	public void dateToStrTest() {

		Date date1 = DateUtils.formatDate("2015-08-25");
		System.out.println(date1);

		Date date2 = DateUtils.formatDate("2015-08-25 12:23:34");
		System.out.println(date2);
	}

	@Test
	public void dateTimeToStrTest() {

		Date date1 = DateUtils.format("2015-08-25 12:23:34");
		System.out.println(date1);

		Date date2 = DateUtils.format("2015-08-25");
		System.out.println(date2);
	}

}
