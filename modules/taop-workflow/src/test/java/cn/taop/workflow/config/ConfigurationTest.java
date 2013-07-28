/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.config;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.taop.workflow.WorkflowContext;
import cn.taop.workflow.WorkflowContextFactory;

/**
 * 
 * 
 * @author duduwolf
 */
public class ConfigurationTest {

	static WorkflowContext wc = WorkflowContextFactory.getWorkflowContext();
	Configuration config = null;
	
	@Before
	public void setUp() throws Exception {
		config = (Configuration)wc.getBean(Configuration.class.getName());
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * 测试流程配置管理器的初始化
	 */
	@Test
	public void testInitializeConfiguration() {
		Configuration _config = null;
		
		//测试默认加载器
		_config = (Configuration)wc.getBean(Configuration.class.getName());
		assertNotNull(_config);
		
		//测试手动指定加载器
		_config = (Configuration)wc.getBean(Configuration.class.getName());
		_config.setLoader(new XMLConfigurationLoader());
		assertNotNull(_config);
	}

	/**
	 * 测试用默认加载器通过文件名加载配置
	 */
	@Test
	public void testLoadFileNameByAuto() {
		Configuration _config = null;
		String fileName = "logback-test.xml";
		String result = null;
		fileName = ConfigurationTest.class.getClassLoader().getResource(fileName).getPath();
		
		//测试通过默认加载器加载配置文件
		_config = (Configuration)wc.getBean(Configuration.class.getName());
		assertNotNull(_config);
		_config.loadConfiguration(fileName);
		result = _config.getXPDLString();
		assertNotNull(result);
		log.debug(result);
	}
	
	/**
	 * 测试用手动加载器通过文件名加载配置
	 */
	@Test
	public void testLoadFileNameByCustom() {
		Configuration _config = null;
		String fileName = "pom.xml";
		String result = null;
		//fileName = ConfigurationTest.class.getClassLoader().getResource(fileName).getPath();
		
		
		//测试手动指定加载器
		_config = (Configuration)wc.getBean(Configuration.class.getName());
		_config.setLoader(new XMLConfigurationLoader());
		assertNotNull(_config);
		
		_config.loadConfiguration(fileName);
		result = _config.getXPDLString();
		assertNotNull(result);
		log.debug(result);
	}
	
	/**
	 * 测试多种方式加载XML文件
	 */
	@Test
	public void testLoadXML() {
		String fileName = null;
		boolean isException = false;
		try {
			config.loadConfiguration(fileName);
		} catch (ConfigurationException e) {
			isException = true;
			log.error(e.getMessage(), e);
		}
		
		assertTrue(isException);
	}
	
	/**
	 * 测试加载本地文件
	 */
	@Test
	public void testLoadLocal() {
		String fileName = System.getProperty("user.home") + "\\.m2\\settings.xml";
		String result = null;
		config.loadConfiguration(fileName);
		result = config.getXPDLString();
		assertNotNull(result);
		log.debug(result);
	}
	
	/**
	 * 测试加载URL文件
	 * @throws MalformedURLException 
	 */
	@Test
	public void testLoadURL() throws MalformedURLException {
		//String fileName = "http://maven.apache.org/maven-v4_0_0.xsd";
		String fileName = "http://repo.taop.cn/content/repositories/central/.meta/repository-metadata.xml";
		String result = null;
		URL url = new URL(fileName);
		config.loadConfiguration(url);
		result = config.getXPDLString();
		assertNotNull(result);
		log.debug(result);
	}
	final static Logger log = LoggerFactory.getLogger(ConfigurationTest.class);
}
