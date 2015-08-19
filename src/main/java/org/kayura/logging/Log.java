/*
 *    Copyright 2015-2015 the original author or authors.
 *
 */
package org.kayura.logging;

/**
 * @author liangxia@live.com
 */
public interface Log {
    
    boolean isDebugEnabled();
    
    boolean isTraceEnabled();
    
    void error(String msg, Throwable e);
    
    void error(String msg, Object... args);
    
    void debug(String msg, Object... args);
    
    void trace(String msg, Object... args);
    
    void warn(String msg, Object... args);
    
}
