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
 *
 */
public class Result implements Serializable {

	private static final long serialVersionUID = -6068065272117750613L;

	private StringBuilder msgBuilder = new StringBuilder();
	private Integer code;
	private Map<String, Object> attach;

	public Result() {
		attach = new HashMap<String, Object>();
		this.code = 0;
	}

	public Result(Integer code) {
		this();
		this.code = code;
	}

	public Result(Integer code, String message) {
		this(code);
		this.msgBuilder.append(message);
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
		return msgBuilder.toString();
	}

	public void addMessage(String message, Object... args) {
		this.msgBuilder.append(String.format(message, args) + "\r\n");
	}
}