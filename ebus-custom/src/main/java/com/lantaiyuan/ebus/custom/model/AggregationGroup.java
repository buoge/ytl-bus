package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/** 
  * @Title: AggregationGroup.java
  * @Package com.lantaiyuan.ebus.custom.model
  * @Description: 
  * @author yangyang   
  * @date 2017年2月23日 下午3:28:05
  * @version v1.0  
 */
public class AggregationGroup extends Model{

	private static final long serialVersionUID = -5423163574211622585L;

	private String citycode;
	
	private int count;

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
