/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.taop.workflow.config.Configuration;
import cn.taop.workflow.config.DefaultConfiguration;
import cn.taop.workflow.core.DefaultWorkflowService;
import cn.taop.workflow.xpdl.DefaultXPDLParser;
import cn.taop.workflow.xpdl.XPDLParser;


/**
 * 工作流核心容器的抽象实现类
 * 
 * @author duduwolf
 */
@SuppressWarnings("unchecked")
public abstract class AbstractWorkflowContext implements WorkflowContext {
	
	/**
	 * 所有需要加载到容器里的bean，通过静态方式写入，类似配置文件的作用
	 */
	static String beanArray[][] = new String[][]{
		{ProcessInstance.class.getName(), DefaultProcessInstance.class.getName()},
		{WorkflowService.class.getName(), DefaultWorkflowService.class.getName()},
		{Configuration.class.getName(), DefaultConfiguration.class.getName()},
		{XPDLParser.class.getName(), DefaultXPDLParser.class.getName()}
	};
	
	public AbstractWorkflowContext() {
		beforeSetup();
	}

	public Object getBean(String beanName) {
		return beans.get(beanName);
	}
	
	public <T> T  getBean(Class<T> clazz) {
		return (T)beans.get(clazz.getName());
	}
	
	public Collection<String> getBeanNames() {
		return Collections.unmodifiableCollection(beans.keySet());
	}
	
	/**
	 * 初始化容器前必须调用的方法，方法体内实现一些基础配置工作
	 */
	protected void beforeSetup() {
		for (String bean[] : beanArray) {
			String clazzName = bean[0];
			String clazzInstance = bean[1];
			Object classValue = null;
			Class clazz = null;
			try {
				clazz = Thread.currentThread().getContextClassLoader().loadClass(clazzInstance);
			} catch (ClassNotFoundException e) {
				throw new WorkflowContextException("未找到要装载到容器的类：" + clazzInstance, e);
			}
			if (clazz != null) {
				try {
					classValue = clazz.newInstance();
				} catch (InstantiationException e) {
					throw new WorkflowContextException("容器实例化要装载的类时出错，" 
							+ e.getMessage() + "无法正常实例化", e);
				} catch (IllegalAccessException e) {
					throw new WorkflowContextException(e);
				}
				
				beans.put(clazzName, classValue);
				log.info("装载bean[{}]成功", clazzName);
			}
		}
	}
	
	/**
	 * Bean容器装载Map
	 */
	protected static Map beans = new HashMap();	//old: TreeMap
	
	static final Logger log = LoggerFactory.getLogger(AbstractWorkflowContext.class);
}
