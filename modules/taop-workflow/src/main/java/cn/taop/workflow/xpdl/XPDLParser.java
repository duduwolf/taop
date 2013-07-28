/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.xpdl;

import cn.taop.workflow.config.Configuration;

/**
 * 流程配置解析器基础类
 * 
 * @author duduwolf
 */
public interface XPDLParser {
	/**
	 * 解析流程配置
	 * @param configuration
	 */
	void parseConfiguration(Configuration configuration);
}
