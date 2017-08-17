package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 驾校报名查询模型
 * @author yangyang
 * @date 2017年4月27日 上午11:31:29 
 *
 */
public class DriverSchoolSignUpQueryModel extends BaseModel<DriverSchoolSignUp> {

	/** 
	* @Fields serialVersionUID
	*/ 
	private static final long serialVersionUID = -4661696165706190198L;
	
	private String cityCode;
	
	private Integer licenseType;
	
	private String name;
	
	private String tel;
	
	private String status;
	
	private String[] statusArray;

	public String[] getStatusArray() {
		return statusArray;
	}

	public void setStatusArray(String[] statusArray) {
		this.statusArray = statusArray;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}