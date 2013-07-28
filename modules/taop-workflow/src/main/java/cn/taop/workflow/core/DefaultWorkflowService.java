/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.core;

import java.io.Serializable;

import cn.taop.workflow.ProcessInstance;
import cn.taop.workflow.WorkflowContext;
import cn.taop.workflow.WorkflowContextFactory;
import cn.taop.workflow.WorkflowService;
import cn.taop.workflow.config.Configuration;

/**
 * 工作流引擎服务实现类
 * 
 * @author duduwolf
 */
public class DefaultWorkflowService implements WorkflowService {
	
	/* (non-Javadoc)
	 * @see cn.taop.workflow.WorkflowService#startWorkflow(java.io.Serializable)
	 */
	public ProcessInstance startWorkflow(Serializable processId) {
		Configuration configuration = context.getBean(Configuration.class);
		configuration.loadConfiguration(processId);
		return startWorkflow(configuration);
	}

	/* (non-Javadoc)
	 * @see cn.taop.workflow.WorkflowService#startWorkflow(cn.taop.workflow.config.Configuration)
	 */
	public ProcessInstance startWorkflow(Configuration configuration) {
		
		return null;
	}

	
	private WorkflowContext context = WorkflowContextFactory.getWorkflowContext();
}
