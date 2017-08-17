package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

import com.lantaiyuan.ebus.custom.model.enummodel.FindAuthEnum;

/**
 * 发现模块下的权限属性
 * @author yangyang
 * @date 2017年6月8日 下午4:08:41 
 *
 */
public class FindAuthProperty extends Model {

	public FindAuthProperty(FindAuthEnum findAuth) {
		super();
		this.name = findAuth.desc();
		this.value = findAuth.value();
		this.imageUrl = findAuth.imageUrl();
		this.linkUrl = findAuth.linkUrl();
	}

	public FindAuthProperty() {
		super();
	}

	private static final long serialVersionUID = 8551749977871354238L;
	
	private String name;
	
	private String value;

	private String imageUrl;
	
	private String linkUrl;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

}
