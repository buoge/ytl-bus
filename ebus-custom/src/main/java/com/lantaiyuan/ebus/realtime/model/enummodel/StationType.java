package com.lantaiyuan.ebus.realtime.model.enummodel;

/** 
  * @Title: StationType.java
  * @Package com.lantaiyuan.ebus.custom.enummodel
  * @Description: 
  * @author yangyang   
  * @date 2016年12月21日 上午9:15:11
  * @version v1.0  
 */
public enum StationType {
	STRART(0),				//起点
	END(1),					//终点
	BOTH_START_AND_END(2);	//既是起点也是终点
	
	private int type;
	
	StationType(int type) {
		this.type = type;
	}
	
    public int getType() {
    	return type;
    }

}
