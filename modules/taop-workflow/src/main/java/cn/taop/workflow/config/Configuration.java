/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.config;

import java.io.Serializable;

/**
 * 流程配置，主要实现XPDL配置文件相关功能
 * 
 * @author duduwolf
 */
public interface Configuration {
	
	/**
	 * 获取流程配置XML字符串
	 * @return XML String
	 */
	String getXPDLString();
	
	/**
	 * 用指定的流程配置加载器读取流程配置信息
	 * @param id 流程唯一性标识，可以为fileName、File、URI等类型
	 * @param loader 流程配置文件加载器 
	 * 目前系统提供
	 * <li>XMLConfigurationLoader {@link cn.taop.workflow.config.XMLConfigurationLoader#loadConfiguration()} </li>
	 * <li>DBConfigurationLoader {@link cn.taop.workflow.config.DBConfigurationLoader#loadConfiguration()}</li>
	 */
	void loadConfiguration(Serializable id, ConfigurationLoader loader);
	
	/**
	 * 用默认的流程配置文件加载器读取流程配置信息<br/>
	 * 系统默认提供XMLConfigurationLoader {@link cn.taop.workflow.config.XMLConfigurationLoader#loadConfiguration()}
	 * @param id 流程唯一性标识，可以为fileName、File、URI等类型
	 */
	void loadConfiguration(Serializable id);
	
	/**
	 * 指定流程加载器
	 * @param loader 流程加载器
	 */
	void setLoader(ConfigurationLoader loader);
	
	/**
	 * 保存流程配置信息
	 * @param xpdl 流程配置XML字符串
	 * @return 返回已保存的流程配置信息
	 */
	Configuration saveConfiguration(String xpdl);
	
	/**
	 * 获取流程配置信息唯一标示符，
	 * @return
	 */
	Serializable getId();
}
