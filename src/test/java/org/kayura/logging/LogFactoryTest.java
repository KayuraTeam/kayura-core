/*
 * Copyright 2015-2015 the original author or authors.
 *
 * HomePage: http://www.kayura.org
 *
 */
package org.kayura.logging;

import org.kayura.logging.Log4j2.Log4j2Impl;
import org.kayura.logging.log4j.Log4jImpl;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author liang.xia
 *
 */
public class LogFactoryTest {

	@Test
	public void shouldUseLog4j() throws LogException {
		LogFactory.useLog4jLogging();
		Log log = LogFactory.getLog(LogFactory.class);
		logSomething(log);
		assertEquals(log.getClass().getName(), Log4jImpl.class.getName());
	}

	@Test
	public void shouldUseLog4j2() throws LogException {
		LogFactory.useLog4j2Logging();
		Log log = LogFactory.getLog(LogFactory.class);
		logSomething(log);
		assertEquals(log.getClass().getName(), Log4j2Impl.class.getName());
	}

	@Test
	public void shouldUseNoLogging() throws LogException {
		LogFactory.useNoLogging();
		Log log = LogFactory.getLog(LogFactory.class);
		logSomething(log);
		assertEquals(log.getClass().getName(), Log4j2Impl.class.getName());
	}

	private void logSomething(Log log) {
		log.warn("Warning message.");
		log.debug("Debug message.");
		log.error("Error message.");
		log.error("Error with Exception.", new Exception("Test exception."));
	}
}
