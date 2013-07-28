/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow;

import java.io.Serializable;

/**
 * 流程实例接口，存储实例化后在容器中运行的流程信息
 * 
 * @author duduwolf
 */
public interface ProcessInstance extends Serializable {

	String getTest();
}
