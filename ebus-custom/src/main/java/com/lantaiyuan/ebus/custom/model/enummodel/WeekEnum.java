package com.lantaiyuan.ebus.custom.model.enummodel;

public enum WeekEnum {
	MONDAY(1, "星期一"), TUESDAY(2, "星期二"), WEDNESDAY(3, "星期三"),THURSDAY(4, "星期四"), 
	FRIDAY(5, "星期五"), SATURDAY(6, "星期六"), SUNDAY(7, "星期天"), DEFAULT(9, "未知");
	
	private int value;
	private String description;
	
	private WeekEnum(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int value() {
		return value;
	}
	
	public String description() {
		return description;
	}
	
	public static WeekEnum valueOf(int value) {
		for (WeekEnum weekEnum : WeekEnum.values()) {
			if (weekEnum.value() == value) {
				return weekEnum;
			}
		}
		return DEFAULT;
	}
	
}
