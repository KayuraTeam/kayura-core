/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.type;

import java.io.Serializable;

/**
 * @author liangxia@live.com
 */
public class Result<E> implements Serializable {

	private static final long serialVersionUID = 37468166158631349L;

	public static final Integer ERROR = -1;
	public static final Integer FAILED = 0;
	public static final Integer SUCCEED = 1;

	private StringBuilder message = new StringBuilder();
	private Integer code = SUCCEED;
	private E data;

	public static GeneralResult error(String message, Exception e) {

		return new GeneralResult(message, e);
	}

	public static GeneralResult error(String message) {

		return new GeneralResult(ERROR, message);
	}

	public static GeneralResult falied(String message) {

		return new GeneralResult(FAILED, message);
	}

	public static GeneralResult succeed(String message) {

		return new GeneralResult(SUCCEED, message);
	}

	public Result() {
	}

	public Result(String message) {
		setMessage(message);
	}

	public Result(E data) {
		setData(data);
	}

	public Result(String message, E data) {
		setMessage(message);
		setData(data);
	}

	@Override
	public String toString() {
		return String.format("Code: %d; Message: %s", code, message.toString());
	}

	public Result(Integer code) {
		this();
		this.code = code;
	}

	public Result(Integer code, String message) {
		this(code);
		setMessage(message);
	}

	public void setError(String message, Object... args) {
		this.code = 0;
		setMessage(message, args);
	}

	public void setSuccess(String message, Object... args) {
		this.code = 1;
		setMessage(message, args);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message.toString();
	}

	public void setMessage(String message, Object... args) {
		if (this.message != null && this.message.length() > 0) {
			this.message = new StringBuilder();
		}
		addMessage(message, args);
	}

	public void addMessage(String message, Object... args) {
		if (args.length > 0) {
			this.message.append(String.format(message, args));
		} else {
			this.message.append(message);
		}
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
}