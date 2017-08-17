package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/** 
  * @Title: FindAuthority.java
  * @Package com.lantaiyuan.ebus.custom.model.acquisition
  * @Description: 发现权限
  * @author yangyang   
  * @date 2017年2月15日 下午1:46:57
  * @version v1.0  
 */
public class FindAuthority extends BaseModel{
	
	private static final long serialVersionUID = 1345058396020630775L;
	private String citycode;
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

}
