package cn.taop.workflow;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.taop.workflow.core.DefaultWorkflowContext;

public class WorkflowContextFactoryTest {

	@Test
	public void getWorkflowContext() {
		WorkflowContext wc = WorkflowContextFactory.getWorkflowContext();
		assertNotNull(wc);
	}

	@Test
	public void setWorkflowContext() {
		WorkflowContext wc = WorkflowContextFactory.getWorkflowContext();
		assertNotNull(wc);

		WorkflowContext wc2 = new DefaultWorkflowContext();
		WorkflowContextFactory.setWorkflowContext(wc2);
		assertEquals(wc2, WorkflowContextFactory.getWorkflowContext());
		assertNotSame(wc, WorkflowContextFactory.getWorkflowContext());
	}

	@Test
	public void getProcessInstanceBean() {
		WorkflowContext wc = WorkflowContextFactory.getWorkflowContext();
		assertNotNull(wc);
		
		ProcessInstance pi = (ProcessInstance)wc.getBean(ProcessInstance.class.getName());
		
		assertNotNull(pi);
		assertEquals(pi.getTest(), "测试通过");
	}
	
	@Test
	public void getProcessInstanceBean2() {
		WorkflowContext wc = WorkflowContextFactory.getWorkflowContext();
		assertNotNull(wc);
		
		TaskInstance ti = (TaskInstance)wc.getBean(TaskInstance.class.getName());
		assertNull(ti);
	}
	
	@Test
	public void getBeanNames() {
		WorkflowContext wc = WorkflowContextFactory.getWorkflowContext();
		assertNotNull(wc);
		
		Collection<String> beans = wc.getBeanNames();
		log.info("打印当前容器里的所有beanName...");
		for (String bean : beans) {
			log.info(bean);
		}
		log.info("打印完成，当前容器里有{}个bean", beans.size());
	}
	
	final static Logger log = LoggerFactory.getLogger(WorkflowContextFactoryTest.class);
}
