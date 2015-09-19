/*
 *    Copyright 2015-2015 the original author or authors.
 *
 */
package org.kayura.logging;

import java.lang.reflect.Constructor;

/**
 * @author liangxia@live.com
 * @author Clinton Begin
 * @author Eduardo Macarron
 */
public final class LogFactory {

	/**
	 * Marker to be used by logging implementations that support markers
	 */
	public static final String MARKER = "KAYURA";

	private static Constructor<? extends Log> logConstructor;

	static {
		tryImplementation(new Runnable() {
			public void run() {
				try {
					useLog4jLogging();
				} catch (LogException e) {
					e.printStackTrace();
				}
			}
		});
		tryImplementation(new Runnable() {
			public void run() {
				try {
					useLog4j2Logging();
				} catch (LogException e) {
					e.printStackTrace();
				}
			}
		});
		tryImplementation(new Runnable() {
			public void run() {
				try {
					useNoLogging();
				} catch (LogException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private LogFactory() {
		// disable construction
	}

	public static Log getLog(Class<?> aClass) {
		return getLog(aClass.getName());
	}

	public static Log getLog(String logger) {
		try {
			return logConstructor.newInstance(new Object[] { logger });
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return new org.kayura.logging.nologging.NoLoggingImpl(logger);
	}

	public static synchronized void useCustomLogging(Class<? extends Log> clazz)
			throws LogException {
		setImplementation(clazz);
	}

	public static synchronized void useLog4jLogging() throws LogException {
		setImplementation(org.kayura.logging.log4j.Log4jImpl.class);
	}

	public static synchronized void useLog4j2Logging() throws LogException {
		setImplementation(org.kayura.logging.Log4j2.Log4j2Impl.class);
	}

	public static synchronized void useNoLogging() throws LogException {
		setImplementation(org.kayura.logging.nologging.NoLoggingImpl.class);
	}

	private static void tryImplementation(Runnable runnable) {
		if (logConstructor == null) {
			try {
				runnable.run();
			} catch (Throwable t) {
				// ignore
			}
		}
	}

	private static void setImplementation(Class<? extends Log> implClass) throws LogException {
		try {
			Constructor<? extends Log> candidate = implClass
					.getConstructor(new Class[] { String.class });
			String lname = LogFactory.class.getName();
			Log log = candidate.newInstance(new Object[] { lname });
			log.debug("Logging initialized using '" + implClass + "' adapter.");
			logConstructor = candidate;
		} catch (Throwable t) {
			throw new LogException("Error setting Log implementation.  Cause: " + t, t);
		}
	}

}
