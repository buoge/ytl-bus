package com.lantaiyuan.ebus.custom.model.enummodel;

/** 
  * @Title: BusNewsType.java
  * @Package com.lantaiyuan.ebus.custom.enummodel
  * @Description: 
  * @author yangyang   
  * @date 2016年12月20日 下午5:34:14
  * @version v1.0  
 */
public enum BusNewsTypeEnum {
	HEADTITLE(1),		//大标题新闻
	SUBTITLE(2);		//小标题新闻
	
	private int type;
	BusNewsTypeEnum(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}

}
