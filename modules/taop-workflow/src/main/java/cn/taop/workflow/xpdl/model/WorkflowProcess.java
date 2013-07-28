/**
 * Copyright 2009-2010 taop.cn
 * All rights reserved. 
 */
package cn.taop.workflow.xpdl.model;

import java.util.Set;

/**
 * 流程实体
 * 
 * @author duduwolf
 */
public class WorkflowProcess extends AbstractModel {

	/**
	 * 流程所属分类
	 */
	private String category = "";

	private Set<Note> notes;
	private Set<Data> datas;
	private Set<Actor> actors;
	private Set<Activity> activities;
	private Set<Transition> transitions;
	private Set<Action> actions;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	public Set<Data> getDatas() {
		return datas;
	}

	public void setDatas(Set<Data> datas) {
		this.datas = datas;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public Set<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(Set<Transition> transitions) {
		this.transitions = transitions;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}

	private static final long serialVersionUID = -9158775908225193796L;
}
