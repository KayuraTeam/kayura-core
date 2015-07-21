/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.type;

import java.io.Serializable;

/**
 * @author liangxia@live.com
 */
public class Result<E extends Serializable> implements Serializable {

	private static final long serialVersionUID = 37468166158631349L;

	private String message;
	private Integer code;
	private E data;

	public Result() {
		this.code = 1;
	}

	public Result(Integer code) {
		this();
		this.code = code;
	}

	public Result(Integer code, String message) {
		this(code);
		this.message = message;
	}

	public Result(Integer code, String message, E data) {
		this(code);
		this.message = message;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message, Object... args) {
		this.message = String.format(message, args);
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
}