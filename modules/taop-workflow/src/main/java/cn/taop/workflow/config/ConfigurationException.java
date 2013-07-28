/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.config;

import cn.taop.workflow.common.WorkflowException;

/**
 * 
 * 
 * @author duduwolf
 */
public class ConfigurationException extends WorkflowException {

	private static final long serialVersionUID = -8477039081098763995L;

	public ConfigurationException(String s) {
		super(s);
	}
	
	public ConfigurationException(Throwable t) {
		super(t);
	}

	public ConfigurationException(String s, Throwable t) {
		super(s, t);
	}
}
