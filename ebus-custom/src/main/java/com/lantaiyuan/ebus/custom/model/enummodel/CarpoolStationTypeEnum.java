package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 描述:站点类型枚举类
 * 作者:温海金
 * 最后更改时间:下午4:05:15
 */
public enum CarpoolStationTypeEnum {
	
	START_STATION((byte) 1, "起点"), 
	MID_STATION((byte) 2, "中途站点"),
	END_STATION((byte) 3, "终点"),
	DEFAULT((byte) 4, "默认值");

	private Byte value;
	private String description;

	private CarpoolStationTypeEnum(Byte value, String description) {
		this.value = value;
		this.description = description;
	}

	public Byte value() {
		return value;
	}

	public String description() {
		return description;
	}
	
	public static CarpoolStationTypeEnum valueOf(short value) {
		for (CarpoolStationTypeEnum noticeEnum : CarpoolStationTypeEnum.values()) {
			if (noticeEnum.value() == value) {
				return noticeEnum;
			}
		}
		return DEFAULT;
	}
}
