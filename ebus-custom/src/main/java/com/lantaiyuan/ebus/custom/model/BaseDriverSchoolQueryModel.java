package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 驾校信息的查询模型
 * @author yangyang
 * @date 2017年4月25日 下午4:09:19 
 *
 */
public class BaseDriverSchoolQueryModel extends BaseModel<BaseDriverSchool>{

	/** 
	* @Fields serialVersionUID
	*/ 
	private static final long serialVersionUID = -5493882407140723879L;
	
	private String cityCode;
	
	private Integer licenseType;
	
	private String name;
	
	private String location;
	 
	private String tel;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Integer getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(Integer licenseType) {
		this.licenseType = licenseType;
	}
	
}
