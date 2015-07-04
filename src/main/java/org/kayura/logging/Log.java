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
  void error(String msg);
  void debug(String msg);
  void trace(String msg);
  void warn(String msg);
  
}
