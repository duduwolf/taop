/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow;

import java.util.Collection;

/**
 * 工作流上下文核心容器
 * 
 * @author duduwolf
 */
public interface WorkflowContext {
	/**
	 * 通过beanName得到bean实例
	 * @param beanName bean的名称
	 * @return
	 */
	Object getBean(String beanName);
	
	/**
	 * 通过bean类得到bean实例
	 * @param clazz bean类
	 * @return
	 */
	<T> T getBean(Class<T> clazz);
	
	/**
	 * 得到所有beanName的集合
	 * @return
	 */
	Collection<String> getBeanNames();
}
