package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 描述:最后登入系统类型枚举类
 * 作者:温海金
 * 最后更改时间:下午4:22:36
 */
public enum LastLoginSysTypeEnum {
	
	ANDROID(1, "安卓系统"), IOS(2, "IOS系统");
	
	private Integer value;
	private String description;
	
	private LastLoginSysTypeEnum(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

	public Integer value() {
		return value;
	}
	
	public String description() {
		return description;
	}
	
}
