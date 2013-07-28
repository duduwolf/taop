package cn.taop.workflow.xpdl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.taop.workflow.WorkflowContextFactory;
import cn.taop.workflow.config.Configuration;

public class XPDLParserTest {

	@Before
	public void setUp() throws Exception {
		fileName = XPDLParserTest.class.getClassLoader().getResource("cn/taop/workflow/xpdl/processTemplate_1.xml").getPath();
		config = WorkflowContextFactory.getWorkflowContext().getBean(Configuration.class);
		parser = WorkflowContextFactory.getWorkflowContext().getBean(XPDLParser.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParseConfiguration() {
		assertNotNull(parser);
		config.loadConfiguration(fileName);
		parser.parseConfiguration(config);
		assertNotNull(config.getXPDLString());
	}
	
	String fileName = "";
	Configuration config = null;
	XPDLParser parser = null;
	
	final static Logger log = LoggerFactory.getLogger(XPDLParserTest.class);
}
