package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * 专为枚举类服务，返回枚举的value和desc
 * @author yangyang
 * @date 2017年4月27日 上午11:42:15 
 *
 */
public class CommonDescValueModel extends Model {

	private static final long serialVersionUID = 2363987096833430265L;
	
	public CommonDescValueModel(String desc, int value) {
		super();
		this.desc = desc;
		this.value = value;
	}
	public CommonDescValueModel() {
		super();
	}
	private String desc;
	
	private int value;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
