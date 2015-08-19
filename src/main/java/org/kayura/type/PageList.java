/**
 * Copyright 2015-2015 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author liangxia@live.com
 *
 */
public class PageList<E> extends ArrayList<E> implements Serializable {
    
    private static final long serialVersionUID = 1611112691285620907L;
    
    private Paginator paginator;
    
    public PageList() {
    }
    
    public PageList(Collection<? extends E> data) {
	super(data);
    }
    
    public PageList(Collection<? extends E> data, Paginator paginator) {
	super(data);
	this.paginator = paginator;
    }
    
    public PageList(Paginator paginator) {
	this.paginator = paginator;
    }
    
    public Paginator getPaginator() {
	return paginator;
    }
    
    public int getTotalPages() {
	return paginator.getTotalPages();
    }
    
    public int getTotalCount() {
	return paginator.getTotalCount();
    }
}
