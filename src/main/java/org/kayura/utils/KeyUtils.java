/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.utils;

import java.util.UUID;

/**
 * @author liangxia@live.com
 */
public class KeyUtils {
    
    public static String newId() {
	return UUID.randomUUID().toString().toUpperCase();
    }
    
}
