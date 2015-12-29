/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.type;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liangxia@live.com
 */
public class GeneralResult implements Serializable {

	private static final long serialVersionUID = -6068065272117750613L;

	private StringBuilder message = new StringBuilder();
	private Integer code = Result.SUCCEED;
	private Exception exception;
	private Map<String, Object> attach = new HashMap<String, Object>();

	public GeneralResult() {

	}

	public GeneralResult(Integer code, String message) {
		this.code = code;
		this.message.append(message);
	}

	public GeneralResult(String message, Exception exception) {
		this.code = Result.ERROR;
		this.message.append(message);
		this.setException(exception);
	}

	public Map<String, Object> getAttach() {
		return attach;
	}

	public void addAttach(String key, Object value) {
		attach.put(key, value);
	}

	public Object getAttach(String key) {
		return attach.get(key);
	}

	public void removeAttach(String key) {
		attach.remove(key);
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

	public void setError(String message, Object... args) {
		this.code = 0;
		setMessage(message, args);
	}

	public void setSuccess(String message, Object... args) {
		this.code = 1;
		setMessage(message, args);
	}

	public void setMessage(String message, Object... args) {
		this.message = new StringBuilder();
		addMessage(message, args);
	}

	public void addMessage(String message, Object... args) {
		this.message.append(String.format(message, args));
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
}