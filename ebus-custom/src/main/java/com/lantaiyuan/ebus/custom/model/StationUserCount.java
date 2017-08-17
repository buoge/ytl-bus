package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * @Title: StationUserCount.java
 * @Package com.lantaiyuan.ebus.custom.model
 * @Description: 用户查看某站点的次数统计
 * @author yangyang
 * @date 2017年2月27日 下午3:15:10
 * @version v1.0
 */
public class StationUserCount extends Model {
	private static final long serialVersionUID = -9215057693351834477L;

	private String stationInfo;
	private Integer count;

	public StationUserCount stationInfo(String stationInfo){
		this.stationInfo = stationInfo;
		return this;
	}

	public StationUserCount count(Integer count) {
		this.count = count;
		return this;
	}

	public String getStationInfo() {
		return stationInfo;
	}

	public void setStationInfo(String stationInfo) {
		this.stationInfo = stationInfo;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
