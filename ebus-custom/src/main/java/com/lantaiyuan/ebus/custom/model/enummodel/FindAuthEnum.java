package com.lantaiyuan.ebus.custom.model.enummodel;

import java.util.Objects;

/**
 * 发现模块权限枚举
 * @author yangyang
 * @date 2017年6月8日 下午3:38:47 
 *
 */
public enum FindAuthEnum {
	
	BUS_CARD("bus_card", "公交卡充值", FindAuthServiceEnum.BUS_SERVICE, ""),
	LOST_PROPERTY("lost_property", "失物招领", FindAuthServiceEnum.BUS_SERVICE, ""),
	NEWS("news", "资讯信息", FindAuthServiceEnum.BUS_SERVICE, ""),
	DRIVER_SCHOOL("driver_school", "驾校报名", FindAuthServiceEnum.BUS_SERVICE, ""),
	CUSTOM_COMMUNITY("custom_community", "定制社区", FindAuthServiceEnum.CUSTOM_SERVICE, ""),
	AROUND("around", "周边游",FindAuthServiceEnum.CUSTOM_SERVICE, ""),
	BIKE("bike", "自行车", FindAuthServiceEnum.THIRD_SERVICE, ""),
	TRAIN("train", "火车查询", FindAuthServiceEnum.THIRD_SERVICE, ""),
	BUS("bus", "汽车查询", FindAuthServiceEnum.THIRD_SERVICE, ""),
	PLANE("plane", "航班查询", FindAuthServiceEnum.THIRD_SERVICE, ""),
	DEFAULT("default", "默认", FindAuthServiceEnum.DEFAULT, "");
	
	private FindAuthEnum(String value, String desc, FindAuthServiceEnum authServiceEnum, String imageUrl) {
		this.value = value;
		this.desc = desc;
		this.authServiceEnum = authServiceEnum;
		this.imageUrl = imageUrl;
	}
	
	public static FindAuthEnum getValueOf(String value) {
		for (FindAuthEnum findAuth : FindAuthEnum.values()) {
			if (Objects.equals(findAuth.value(), value)) {
				return findAuth;
			}
		}
		return DEFAULT;
	}

	private String value;
	
	private String desc;
	
	private FindAuthServiceEnum authServiceEnum;
	
	private String imageUrl;
	
	private String linkUrl;

	public String value() {
		return value;
	}

	public String desc() {
		return desc;
	}

	public FindAuthServiceEnum authServiceEnum() {
		return authServiceEnum;
	}

	public String imageUrl() {
		return imageUrl;
	}
	
	public String linkUrl() {
		return linkUrl;
	}

	

}
