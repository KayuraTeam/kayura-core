/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangxia@live.com
 */
public class GeneralResult extends Result<Map<String, Object>> {

	private static final long serialVersionUID = 1606589046205613193L;

	private Exception exception;

	public GeneralResult() {
		this.setData(new HashMap<String, Object>());
	}

	public Exception getException() {
		return exception;
	}
	
	public void setError(String message, Exception exception) {
		this.setCode(ERROR);
		this.setMessage(message);
		this.exception = exception;
	}

	public void setException(Exception exception) {
		this.setCode(ERROR);
		this.exception = exception;
	}

	public void addData(String key, Object value) {
		Map<String, Object> data = this.getData();
		data.put(key, value);
	}

	public Object getData(String key) {
		Map<String, Object> data = this.getData();
		return data.get(key);
	}

}