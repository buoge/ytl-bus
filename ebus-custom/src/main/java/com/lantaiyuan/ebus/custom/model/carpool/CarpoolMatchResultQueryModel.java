package com.lantaiyuan.ebus.custom.model.carpool;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * 动态撮合表查询model
 * 
 * @author yangyang
 * @date 2017年6月13日 下午3:04:10
 *
 */
public class CarpoolMatchResultQueryModel extends BaseModel<CarpoolMatchResult> {

	private static final long serialVersionUID = -440936793241875081L;

	private String startPlace;
	
	private String endPlace;

	private String startTime;

	private String endTime;

	private String cityCode;

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
}
