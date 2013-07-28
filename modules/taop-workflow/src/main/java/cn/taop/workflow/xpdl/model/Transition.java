/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.xpdl.model;

/**
 * 流程迁移实体
 * 
 * @author duduwolf
 */
public class Transition extends AbstractModel {

	private String id;
	private String name;
	private String to[];
	private String from[];

	

	private static final long serialVersionUID = 1147667669589765809L;
}
