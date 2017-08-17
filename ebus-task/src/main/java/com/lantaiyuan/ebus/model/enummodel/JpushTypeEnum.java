package com.lantaiyuan.ebus.model.enummodel;

/**
 * 描述:消息推送类型
 * 作者:温海金
 * 最后更改时间:下午12:58:12
 */
public enum JpushTypeEnum {
	
	/**
	 * msgType取值如下
	 */
	NEWS("NEWS", "新闻资讯"), LOST_AND_FOUND("LOST_AND_FOUND", "失物招领"), NOTICE("NOTICE", "紧急通知");
	
	private String value;
	private String description;
	
	private JpushTypeEnum(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String value() {
		return value;
	}
	
	public String description() {
		return description;
	}
	
}