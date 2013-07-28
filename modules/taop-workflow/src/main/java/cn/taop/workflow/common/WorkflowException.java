/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.common;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工作流基础异常抽象类
 * 
 * @author duduwolf
 */
public abstract class WorkflowException extends RuntimeException {

	private static final long serialVersionUID = -6693658212537559730L;
	private Throwable rootCause;

	public WorkflowException() {
	}

	public WorkflowException(String s) {
		super(s);
		this.printStackTrace();
	}

	public WorkflowException(String s, Throwable rootCause) {
		super(s);
		this.rootCause = rootCause;
		this.printStackTrace();
	}

	public WorkflowException(Throwable rootCause) {
		this.rootCause = rootCause;
		this.printStackTrace();
	}

	public Throwable getRootCause() {
		return rootCause;
	}

	public void printStackTrace() {
		super.printStackTrace();

		if (rootCause != null) {
			synchronized (System.err) {
				System.err.println("\nRoot cause:");
				rootCause.printStackTrace();
			}
		}
	}

	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);

		if (rootCause != null) {
			synchronized (s) {
				s.println("\nRoot cause:");
				rootCause.printStackTrace(s);
			}
		}
	}

	public void printStackTrace(PrintWriter s) {
		super.printStackTrace(s);

		if (rootCause != null) {
			synchronized (s) {
				s.println("\nRoot cause:");
				rootCause.printStackTrace(s);
			}
		}
	}
	
	static final Logger log = LoggerFactory.getLogger(WorkflowException.class);
}
