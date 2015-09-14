package org.kayura.logging.Log4j2;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.kayura.logging.Log;
import org.kayura.logging.LogFactory;

/**
 * @author Eduardo Macarron
 */
public class Log4j2LoggerImpl implements Log {

	private static Marker MARKER = MarkerManager.getMarker(LogFactory.MARKER);

	private Logger log;

	public Log4j2LoggerImpl(Logger logger) {
		log = logger;
	}

	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	public void error(String s, Throwable e) {
		log.error(MARKER, s, e);
	}

	public void error(String s) {
		log.error(MARKER, s);
	}

	public void debug(String s) {
		log.debug(MARKER, s);
	}

	public void trace(String s) {
		log.trace(MARKER, s);
	}

	public void warn(String s) {
		log.warn(MARKER, s);
	}

}
