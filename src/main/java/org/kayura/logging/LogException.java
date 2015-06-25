/*
 *    Copyright 2015-2015 the original author or authors.
 *
 */
package org.kayura.logging;

import org.kayura.exceptions.KayuraException;

/**
 * @author liangxia@live.com
 */
public class LogException extends KayuraException {

	private static final long serialVersionUID = -3692684395355808647L;

	public LogException() {
		super();
	}

	public LogException(String message) {
		super(message);
	}

	public LogException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogException(Throwable cause) {
		super(cause);
	}

}
