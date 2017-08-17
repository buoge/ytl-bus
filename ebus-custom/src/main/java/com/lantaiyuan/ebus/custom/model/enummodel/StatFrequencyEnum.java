package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * @Title: StatFrequency.java
 * @Package com.lantaiyuan.ebus.custom.model.enummodel
 * @Description: 统计频率
 * @author yangyang
 * @date 2017年2月22日 上午11:50:05
 * @version v1.0
 */
public enum StatFrequencyEnum {
	DEFAULT(0, "默认"), DAY(1, "日"), WEEK(7, "周"), MONTH(30, "月");

	private int value;
	private String description;

	private StatFrequencyEnum(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int value() {
		return value;
	}

	public String description() {
		return description;
	}

	public static StatFrequencyEnum valueOf(int value) {
		for (StatFrequencyEnum sf : StatFrequencyEnum.values()) {
			if (value == sf.value) {
				return sf;
			}
		}
		return DEFAULT;
	}
}
