package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * @Title: TrendQueryModel.java
 * @Package com.lantaiyuan.ebus.custom.model
 * @Description: 
 * @author yangyang
 * @date 2017年2月24日 下午4:19:09
 * @version v1.0
 */
public class TrendQueryModel extends Model {

	private static final long serialVersionUID = -5379318775155451766L;

	private String citycode;

	private Date startDate;

	private Date endDate;

	public TrendQueryModel citycode(String citycode) {
		this.citycode = citycode;
		return this;
	}

	public TrendQueryModel startDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}

	public TrendQueryModel endDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
