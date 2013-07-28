/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow;

/**
 * 默认流程实例接口
 * 
 * @author duduwolf
 */
public class DefaultProcessInstance implements ProcessInstance {

	private static final long serialVersionUID = 4759158001895656736L;

	public String getTest() {
		return "测试通过";
	}
}
