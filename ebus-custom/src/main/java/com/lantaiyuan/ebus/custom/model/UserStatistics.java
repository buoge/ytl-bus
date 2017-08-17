package com.lantaiyuan.ebus.custom.model;

import java.util.List;

import org.lanqiao.ssm.common.model.Model;

/** 
  * @Title: UserStatistics.java
  * @Package com.lantaiyuan.ebus.custom.model
  * @Description: 用户统计返回结果
  * @author yangyang   
  * @date 2017年2月23日 上午10:35:24
  * @version v1.0  
 */
public class UserStatistics extends Model{
	
	private static final long serialVersionUID = 4882613164583045912L;
	
	private List<Statistics> todayEachCity;
	private List<Statistics> yesterdayEachCity;
	private Statistics todayAllCities;
	private Statistics yesterdayAllCities;
	
	public UserStatistics todayEachCity(List<Statistics> todayEachCity) {
		this.todayEachCity = todayEachCity;
		return this;
	}
	
	public UserStatistics yesterdayEachCity(List<Statistics> yesterdayEachCity) {
		this.yesterdayEachCity = yesterdayEachCity;
		return this;
	}
	
	public UserStatistics todayAllCities(Statistics todayAllCities) {
		this.todayAllCities = todayAllCities;
		return this;
	}
	
	public UserStatistics yesterdayAllCities(Statistics yesterdayAllCities) {
		this.yesterdayAllCities = yesterdayAllCities;
		return this;
	}
	
	public List<Statistics> getTodayEachCity() {
		return todayEachCity;
	}
	public void setTodayEachCity(List<Statistics> todayEachCity) {
		this.todayEachCity = todayEachCity;
	}
	public List<Statistics> getYesterdayEachCity() {
		return yesterdayEachCity;
	}
	public void setYesterdayEachCity(List<Statistics> yesterdayEachCity) {
		this.yesterdayEachCity = yesterdayEachCity;
	}
	public Statistics getTodayAllCities() {
		return todayAllCities;
	}
	public void setTodayAllCities(Statistics todayAllCities) {
		this.todayAllCities = todayAllCities;
	}
	public Statistics getYesterdayAllCities() {
		return yesterdayAllCities;
	}
	public void setYesterdayAllCities(Statistics yesterdayAllCities) {
		this.yesterdayAllCities = yesterdayAllCities;
	}
}
