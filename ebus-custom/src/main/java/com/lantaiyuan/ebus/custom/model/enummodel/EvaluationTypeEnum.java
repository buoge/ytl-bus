package com.lantaiyuan.ebus.custom.model.enummodel;

/** 
  * @Title: EvaluationTypeEnum.java
  * @Package com.lantaiyuan.ebus.custom.enummodel
  * @Description: 评价类型枚举类
  * @author YvanTan 
  * @date 2016年12月20日 下午5:34:14
  * @version v1.3.0 
 */
public enum EvaluationTypeEnum {
	BUS_EVALUATION("B"),		 
	STATION_EVALUATION("S");		 
	
	private String type;
	EvaluationTypeEnum(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
