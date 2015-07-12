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

	private Integer code;
	private String message;
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
		this.message = message;
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
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}