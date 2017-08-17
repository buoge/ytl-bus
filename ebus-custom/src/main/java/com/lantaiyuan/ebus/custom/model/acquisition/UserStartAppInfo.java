package com.lantaiyuan.ebus.custom.model.acquisition;

import java.util.Date;
import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/**
 * @Title: UserStartAppInfo.java
 * @Package com.lantaiyuan.ebus.custom.model.acquisition
 * @Description:记录用户首次启动app时间
 * @author yangyang
 * @date 2017年2月18日 下午3:24:53
 * @version v1.0
 */
public class UserStartAppInfo extends BaseModel {

	private static final long serialVersionUID = -7053282542298049460L;
	
	public UserStartAppInfo() {
		super();
	}
	
	public UserStartAppInfo(StartAppInfo info) {
		super();
		this.phonemodel = info.getPhonemodel();
		this.firststarttime = info.getCurrenttime();
		this.citycode = info.getCitycode();
	}
	 
	private String phonemodel;

	private Date firststarttime;
	
	private String citycode;

	public String getPhonemodel() {
		return phonemodel;
	}

	public void setPhonemodel(String phonemodel) {
		this.phonemodel = phonemodel;
	}

	public Date getFirststarttime() {
		return firststarttime;
	}

	public void setFirststarttime(Date firststarttime) {
		this.firststarttime = firststarttime;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

}
