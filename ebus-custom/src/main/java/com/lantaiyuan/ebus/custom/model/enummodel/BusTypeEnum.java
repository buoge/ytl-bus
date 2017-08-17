package com.lantaiyuan.ebus.custom.model.enummodel;

/** 
  * @Title: BusType.java
  * @Package com.lantaiyuan.ebus.custom.enummodel
  * @Description: 
  * @author yangyang   
  * @date 2016年12月23日 上午10:20:29
  * @version v1.0  
 */
public enum BusTypeEnum {
	
	BOOKBUS(1),
	CUSTOMLINE(2);
	
	private int type;
	
	BusTypeEnum(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
}
