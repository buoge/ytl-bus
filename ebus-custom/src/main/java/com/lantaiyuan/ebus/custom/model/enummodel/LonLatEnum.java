package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * @ClassName: LonLatEnum 
 * @Description: 经度纬度类型，用枚举表示，更加清晰
 * @author yangyang
 * @date 2017年4月19日 下午1:53:48 
 */
public enum LonLatEnum {
	
	LONGITUDE(1, "经度"),
	LATITUDE(2, "纬度"),
	DEFAULT(-1, "默认");
	
	private int value;
	
	private String desc;
	
	LonLatEnum(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int value() {
		return value;
	}

	public String desc() {
		return desc;
	}
	
	public static LonLatEnum valueOf(int value) {
		for(LonLatEnum e: LonLatEnum.values()) {
			if(e.value == value) {
				return e;
			}
		}
		return DEFAULT;
	}
	

}
