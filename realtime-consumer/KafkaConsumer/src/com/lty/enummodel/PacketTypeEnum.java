package com.lty.enummodel;

/** 
  * @Title: PacketTypeEnum.java
  * @Package com.lty.enummodel
  * @Description: 
  * @author yangyang   
  * @date 2017年4月19日 下午5:53:00
  * @version v1.0  
 */
public enum PacketTypeEnum {
	
	INSTATION("inStation", "进站包"),
	GPS("gps", "gps包"),
	OUTSTATION("outStation", "出站包"),
	DEFAULT("default", "默认");
	
	private String value;
	private String desc;
	private PacketTypeEnum(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	public String value() {
		return value;
	}
	public String desc() {
		return desc;
	}
	

}
