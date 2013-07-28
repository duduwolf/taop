/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.xpdl.model;

import java.util.Set;

/**
 * 活动节点实体
 * 
 * @author duduwolf
 */
public class Activity extends AbstractModel {

	private String id;
	private String name;
	private String type;
	private String desc;
	private Set<Actor> actors;
	private Set<Action> actions;
	
	

	private static final long serialVersionUID = 3126412462823815076L;
}
