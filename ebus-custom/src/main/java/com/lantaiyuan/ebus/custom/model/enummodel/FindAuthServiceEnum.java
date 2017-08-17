package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 发现模块外层(公交服务、第三方服务、定制服务等)配置 
 * @author yangyang
 * @date 2017年6月16日 下午2:24:09 
 *
 */
public enum FindAuthServiceEnum {
	
	BUS_SERVICE(0, "busService", "公交服务"),
	CUSTOM_SERVICE(1, "customService", "定制服务"),
	THIRD_SERVICE(2, "thirdService", "第三方服务"),
	DEFAULT(-1,"default", "默认");
	
	private int val;
	
	private String desc;
	
	private String title;

	private FindAuthServiceEnum(int val, String desc, String title) {
		this.val = val;
		this.desc = desc;
		this.title = title;
	}
	
	public int val() {
		return val;
	}
	
	public String desc() {
		return desc;
	}
	
	public String title() {
		return title;
	}
	
}
