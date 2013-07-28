/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow;

import java.io.Serializable;

import cn.taop.workflow.config.Configuration;

/**
 * 工作流服务引擎接口，此接口实现大部分工作流基本功能
 * 
 * @author duduwolf
 */
public interface WorkflowService {
	
	/**
	 * 通过指定processId启动流程
	 * @param processId 流程唯一性标识，可以为filename、File、URI或数据库ID
	 * @return 返回流程实例
	 */
	ProcessInstance startWorkflow(Serializable processId);
	
	/**
	 * 通过指定配置文件启动流程
	 * @param configuration 流程配置
	 * @return 返回流程实例
	 */
	ProcessInstance startWorkflow(Configuration configuration);
}
