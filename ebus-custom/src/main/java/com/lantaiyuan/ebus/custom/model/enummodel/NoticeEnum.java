package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 描述:紧急通知相关枚举类
 * 作者:温海金
 * 最后更改时间:下午4:05:15
 */
public enum NoticeEnum {
	//发布范围
	RANGE_ALL_CITY((short) 1, "所有城市"), 
	RANGE_THE_ONE_CITY((short) 2, "全城"), 
	RANGE_THE_ALLOWED_PLACE((short) 3, "指定地点范围"), 
	RANGE_THE_ALLOWED_ROUTE((short) 4, "指定线路范围"),
	DEFAULT((short)5, "默认");

	private short value;
	private String description;

	private NoticeEnum(short value, String description) {
		this.value = value;
		this.description = description;
	}

	public short value() {
		return value;
	}

	public String description() {
		return description;
	}
	
	public static NoticeEnum valueOf(short value) {
		for (NoticeEnum noticeEnum : NoticeEnum.values()) {
			if (noticeEnum.value() == value) {
				return noticeEnum;
			}
		}
		return DEFAULT;
	}
}
