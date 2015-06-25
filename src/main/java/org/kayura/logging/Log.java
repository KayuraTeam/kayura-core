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
  void error(String s, Throwable e);
  void error(String s);
  void debug(String s);
  void trace(String s);
  void warn(String s);
  
}
