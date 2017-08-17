package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * @Title: StatisticsQueryModel.java
 * @Package com.lantaiyuan.ebus.custom.model
 * @Description:用户统计查询
 * @author yangyang
 * @date 2017年2月17日 下午6:06:47
 * @version v1.0
 */
public class StatisticsQueryModel extends BaseModel<Statistics> {

	private static final long serialVersionUID = 3138607629304498720L;

	private String cityCode;

	private String startDate;

	private String endDate;

	private Integer statFrequency; // 日、周、月

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getStatFrequency() {
		return statFrequency;
	}

	public void setStatFrequency(Integer statFrequency) {
		this.statFrequency = statFrequency;
	}

}