package org.kayura.logging.Log4j2;

import org.kayura.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.AbstractLogger;

public class Log4j2Impl implements Log {
    
    private Log log;
    
    public Log4j2Impl(String clazz) {
	Logger logger = LogManager.getLogger(clazz);
	
	if (logger instanceof AbstractLogger) {
	    log = new Log4j2AbstractLoggerImpl((AbstractLogger) logger);
	} else {
	    log = new Log4j2LoggerImpl(logger);
	}
    }
    
    public boolean isDebugEnabled() {
	return log.isDebugEnabled();
    }
    
    public boolean isTraceEnabled() {
	return log.isTraceEnabled();
    }
    
    public void error(String s, Throwable e) {
	log.error(s, e);
    }
    
    public void error(String s, Object... args) {
	log.error(String.format(s, args));
    }
    
    public void debug(String s, Object... args) {
	log.debug(String.format(s, args));
    }
    
    public void trace(String s, Object... args) {
	log.trace(String.format(s, args));
    }
    
    public void warn(String s, Object... args) {
	log.warn(String.format(s, args));
    }
    
}
