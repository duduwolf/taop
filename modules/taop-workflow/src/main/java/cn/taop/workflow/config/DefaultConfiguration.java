/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.config;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.taop.workflow.WorkflowContextFactory;
import cn.taop.workflow.xpdl.XPDLParser;

/**
 * 默认的流程配置类，包括流程配置的装载、解析、以及持久化等操作
 * 
 * @author duduwolf
 */
public class DefaultConfiguration implements Configuration {

	@Override
	public String getXPDLString() {
		if (loader == null) {
			throw new ConfigurationException("未找到流程配置装载器");
		}
			
		return loader.getConfigurationString();
	}

	@Override
	public void loadConfiguration(Serializable source, ConfigurationLoader loader) {
		setLoader(loader);
		this.loader.loadConfiguration(source);
		WorkflowContextFactory.getWorkflowContext().getBean(XPDLParser.class).parseConfiguration(this);
	}

	@Override
	public void loadConfiguration(Serializable source) {
		loadConfiguration(source, new XMLConfigurationLoader());
	}

	@Override
	public void setLoader(ConfigurationLoader loader) {
		this.loader = loader;
	}

	private ConfigurationLoader loader;
	
	static final Logger log = LoggerFactory.getLogger(DefaultConfiguration.class);

	@Override
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration saveConfiguration(String xpdl) {
		// TODO Auto-generated method stub
		return null;
	}
}
