package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 描述:公交专线状态枚举
 * 作者:温海金
 * 最后更改时间:上午11:09:11
 */
public enum CustomLineStatusEnum {
	
	CROWD(1, "众筹中"), PRE_HANDLE(2, "待处理"), DONOT_OPEN(3, "不开通"), ALREAD_OPEN(4, "已开通");
	
	private int value;
	private String description;
	
	private CustomLineStatusEnum(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int value() {
		return value;
	}
	
	public String description() {
		return description;
	}
	
}
