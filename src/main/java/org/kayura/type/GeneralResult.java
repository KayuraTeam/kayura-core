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

	private StringBuilder message;
	private Integer code = 1;
	private Map<String, Object> attach;

	public GeneralResult() {
		this.message = new StringBuilder();
		this.attach = new HashMap<String, Object>();
		this.code = 0;
	}

	public GeneralResult(Integer code) {
		this();
		this.code = code;
	}

	public GeneralResult(String message) {
		this.message.append(message);
	}

	public GeneralResult(Integer code, String message) {
		this(code);
		this.message.append(message);
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

	public void setMessage(String message, Object... args) {
		this.message = new StringBuilder();
		addMessage(message, args);
	}

	public void addMessage(String message, Object... args) {
		this.message.append(String.format(message, args));
	}
}