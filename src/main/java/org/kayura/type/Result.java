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
    
    private StringBuilder message;
    private Integer code;
    private E data;
    
    public Result() {
	this.message = new StringBuilder();
	this.code = 1;
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
	this.message.append(String.format(message, args));
    }
    
    public E getData() {
	return data;
    }
    
    public void setData(E data) {
	this.data = data;
    }
}