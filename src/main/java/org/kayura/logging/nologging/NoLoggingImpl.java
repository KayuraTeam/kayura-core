package org.kayura.logging.nologging;

import org.kayura.logging.Log;

/**
 * @author Clinton Begin
 */
public class NoLoggingImpl implements Log {
    
    public NoLoggingImpl(String clazz) {
    }
    
    public boolean isDebugEnabled() {
	return false;
    }
    
    public boolean isTraceEnabled() {
	return false;
    }
    
    public void error(String msg, Throwable e) {
    }
    
    public void error(String msg, Object... args) {
    }
    
    public void debug(String msg, Object... args) {
    }
    
    public void trace(String msg, Object... args) {
    }
    
    public void warn(String msg, Object... args) {
    }
}