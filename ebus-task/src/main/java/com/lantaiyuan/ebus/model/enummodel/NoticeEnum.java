package com.lantaiyuan.ebus.model.enummodel;

/**
 * 描述:紧急通知相关枚举类
 * 作者:温海金
 * 最后更改时间:下午4:05:15
 */
public enum NoticeEnum {
	//发布状态
	NOT_PUBLISHED((short) 1, "未发布"), ALREADY_PUBLISHED((short) 2, "已发布"),
	//发布范围
	RANGE_ALL_CITY((short) 1, "所有城市"), RANGE_THE_ONE_CITY((short) 2, "全城"), RANGE_THE_ALLOWED_PLACE((short) 3, "指定地点范围"), RANGE_THE_ALLOWED_ROUTE((short) 4, "指定线路范围"),
	//重要等级
	GRADE_general((short) 1, "一般"), GRADE_ALITTLE_IMPORTANT((short) 2, "较重要"), GRADE_VERY_IMPORTANT((short) 3, "非常重要");

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
}
