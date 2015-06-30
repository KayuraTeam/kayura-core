/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author liangxia@live.com
 *
 */
public class OrderBy implements Serializable {

	private static final long serialVersionUID = 6612623083549201741L;

	private String column;
	private Direction direction;

	public OrderBy(String column, Direction direction) {
		this.setColumn(column);
		this.setDirection(direction);
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * 
	 * @param order 排序列，示例： code asc,name desc
	 * @return 返回排序列集合.
	 */
	public static List<OrderBy> fromString(String orderGroup) {
		List<OrderBy> results = new ArrayList<OrderBy>();
		String[] orders = orderGroup.split(",");
		for (String o : orders) {
			results.add(_fromString(o));
		}
		return results;
	}

	private static OrderBy _fromString(String orderItem) {
		String[] arrayList = orderItem.split("\\s+");
		
		String column = arrayList[0];
		String direction = arrayList.length == 2 ? arrayList[1] : "asc";

		return new OrderBy(column, Direction.fromString(direction));
	}

	public static enum Direction {
		ASC, DESC;
		public static Direction fromString(String value) {
			try {
				return Direction.valueOf(value.toUpperCase(Locale.US));
			} catch (Exception e) {
				return ASC;
			}
		}
	}
}
