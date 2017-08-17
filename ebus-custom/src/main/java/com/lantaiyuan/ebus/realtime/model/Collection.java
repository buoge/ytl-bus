package com.lantaiyuan.ebus.realtime.model;

import java.io.Serializable;
import java.util.List;


/**
 * 收藏线路
 * @author Administrator
 *
 */
public class Collection implements Serializable {

	private static final long serialVersionUID = -8291049393430390112L;
	public Collection() {
		super();
	}
	public  Collection (String name,List<Group> group) {
		this.name = name;
		this.group = group;
	}
	private List<Group> group;
	
	private String name;

	public List<Group> getGroup() {
		return group;
	}

	public void setGroup(List<Group> group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
