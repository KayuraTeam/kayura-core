package org.kayura.logging.log4j;

import org.kayura.logging.Log;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Eduardo Macarron
 */
public class Log4jImpl implements Log {

	private static final String FQCN = Log4jImpl.class.getName();

	private Logger log;

	public Log4jImpl(String clazz) {
		log = Logger.getLogger(clazz);
	}

	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	public void error(String s, Throwable e) {
		log.log(FQCN, Level.ERROR, s, e);
	}

	public void error(String s, Object... args) {
		log.log(FQCN, Level.ERROR, String.format(s, args), null);
	}

	public void debug(String s, Object... args) {
		log.log(FQCN, Level.DEBUG, String.format(s, args), null);
	}

	public void trace(String s, Object... args) {
		log.log(FQCN, Level.TRACE, String.format(s, args), null);
	}

	public void warn(String s, Object... args) {
		log.log(FQCN, Level.WARN, String.format(s, args), null);
	}

}