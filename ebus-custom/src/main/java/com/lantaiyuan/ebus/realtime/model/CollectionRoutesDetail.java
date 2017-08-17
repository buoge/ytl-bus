package com.lantaiyuan.ebus.realtime.model;

import java.util.List;

import org.lanqiao.ssm.common.model.Model;

/**
* @Title: Collection.java
* @Package com.lantaiyuan.ebus.realtime.model
* @Description: 收藏线路详情
* @author yangyang   
* @date 2016年12月21日 下午2:17:02
* @version v1.0
 */
public class CollectionRoutesDetail extends Model {

	private static final long serialVersionUID = -8291049393430390112L;
	public CollectionRoutesDetail() {
		super();
	}
	public  CollectionRoutesDetail (String name,List<Group> group) {
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
