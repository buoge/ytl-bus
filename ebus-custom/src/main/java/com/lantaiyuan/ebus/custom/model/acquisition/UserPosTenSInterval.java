/**
* <p>Title: UserPosTenSInterval.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/**
* <p>Title: UserPosTenSInterval</p>
* <p>Description: 10s获取用户位置埋点类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年2月14日 下午3:25:41
*/
//cmd:103
public class UserPosTenSInterval extends BaseModel{
	/***serialVersionUID***/
	private static final long serialVersionUID = 1L;
	
    //城市编码
    private String citycode;
    //搜索人位置
    private String position;
    
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
    
}
