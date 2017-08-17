package com.lantaiyuan.ebus.realtime.model.enummodel;

/** 
  * @Title: PacketType.java
  * @Package com.lantaiyuan.ebus.custom.enummodel
  * @Description: 网关数据包类型
  * @author yangyang   
  * @date 2016年12月28日 下午5:46:38
  * @version v1.0  
 */
public enum PacketType {
	//	0 到站 1 过站
	GPS(1,"gps"),
	INSTATION(0,"inStation"),
	OUTSTATION(1,"outStation");
	
	PacketType(Integer type, String desc) {
		this.type = type;
		this.desc = desc;
	}
	
	private String desc;
	private Integer type;
	public String getDesc() {
		return desc;
	}
	public Integer getType() {
		return type;
	}

	

}
