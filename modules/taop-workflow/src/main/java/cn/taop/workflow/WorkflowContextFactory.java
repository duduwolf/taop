/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.taop.workflow.core.DefaultWorkflowContext;

/**
 * 工作流核心引擎工厂
 * 
 * @author duduwolf
 */
public class WorkflowContextFactory {
	
	public static WorkflowContext getWorkflowContext() {
		if (wc == null) {
			wc = new DefaultWorkflowContext();
		} else {
			log.debug("从静态容器中获取容器上下文");
		}
		return wc;
	}
	
	public static void setWorkflowContext(WorkflowContext _wc) {
		wc = _wc;
		log.debug("工作流核心容器被手动注入");
	}
	
	private static WorkflowContext wc = null;
	
	private static final Logger log = LoggerFactory.getLogger(WorkflowContextFactory.class);
}
