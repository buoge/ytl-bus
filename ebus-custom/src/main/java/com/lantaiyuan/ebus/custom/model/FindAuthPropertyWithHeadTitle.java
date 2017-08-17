package com.lantaiyuan.ebus.custom.model;

import java.util.List;

import org.lanqiao.ssm.common.model.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 发现权限(带上模块标题)
 * @author yangyang
 * @date 2017年6月16日 下午2:18:28 
 *
 */
public class FindAuthPropertyWithHeadTitle extends Model{
	
	public FindAuthPropertyWithHeadTitle(String title, String value, List<FindAuthProperty> propertyList) {
		super();
		this.title = title;
		this.value = value;
		this.propertyList = propertyList;
	}

	public FindAuthPropertyWithHeadTitle() {
		super();
	}

	private static final long serialVersionUID = -7510322761108999506L;

	private String title;
	@JsonIgnore
	private String value;
	
	private List<FindAuthProperty> propertyList;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<FindAuthProperty> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<FindAuthProperty> propertyList) {
		this.propertyList = propertyList;
	}
	
	
	
	

}
