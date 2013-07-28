/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow;

import cn.taop.workflow.common.WorkflowException;

/**
 * 工作流容器异常
 * 
 * @author duduwolf
 */
public class WorkflowContextException extends WorkflowException {

	private static final long serialVersionUID = 412091365464416814L;

	public WorkflowContextException(String s) {
		super(s);
	}
	
	public WorkflowContextException(Throwable t) {
		super(t);
	}

	public WorkflowContextException(String s, Throwable t) {
		super(s, t);
	}
	
}
