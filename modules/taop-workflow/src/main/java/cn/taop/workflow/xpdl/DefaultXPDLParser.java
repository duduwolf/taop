/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.xpdl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.taop.workflow.config.Configuration;

/**
 * 默认的流程配置解析器实现类
 * 
 * @author duduwolf
 */
public class DefaultXPDLParser implements XPDLParser {

	@Override
	public void parseConfiguration(Configuration configuration) {
		log.debug(configuration.getXPDLString());
	}

	static final Logger log = LoggerFactory.getLogger(DefaultXPDLParser.class);
}
