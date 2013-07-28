/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.config;

import java.io.Serializable;

/**
 * 流程配置装载器接口 
 * 
 * @author duduwolf
 */
public interface ConfigurationLoader {
	
	/**
	 * 获得流程配置描述
	 * @return
	 */
	String getConfigurationString();
	
	void loadConfiguration(Serializable id);
} 
