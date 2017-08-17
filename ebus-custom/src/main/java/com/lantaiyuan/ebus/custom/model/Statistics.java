package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/** 
  * @Title: UserStatistics.java
  * @Package com.lantaiyuan.ebus.custom.model
  * @Description: 数据统计
  * @author yangyang   
  * @date 2017年2月17日 下午5:42:26
  * @version v1.0  
 */
public class Statistics extends Model{
	private static final long serialVersionUID = -4075516165357220358L;
	private String citycode;
	private String cityname;
	private int newusers;
	private int activeusers;
	private int starttimes;
	@Override
	public String toString() {
		return "Statistics [citycode=" + citycode + ", cityname=" + cityname + ", newusers=" + newusers
				+ ", activeusers=" + activeusers + ", starttimes=" + starttimes + ", totalusers=" + totalusers
				+ ", upordown=" + upordown + ", order=" + order + "]";
	}

	private int totalusers;
	private int upordown;
	private int order;
	
	public Statistics citycode(String citycode) {
		this.citycode = citycode;
		return this;
	}
	
	public Statistics cityname(String cityname) {
		this.cityname = cityname;
		return this;
	}
	
	public Statistics newusers(int newusers) {
		this.newusers = newusers;
		return this;
	}
	
	public Statistics activeusers(int activeusers) {
		this.activeusers = activeusers;
		return this;
	}
	
	public Statistics starttimes(int starttimes) {
		this.starttimes = starttimes;
		return this;
	}
	
	public Statistics totalusers(int totalusers) {
		this.totalusers = totalusers;
		return this;
	}
	
	public Statistics order(int order) {
		this.order = order;
		return this;
	}
	
	public String getCitycode() {
		return citycode;
	} 
	
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public int getNewusers() {
		return newusers;
	}
	public void setNewusers(int newusers) {
		this.newusers = newusers;
	}
	public int getActiveusers() {
		return activeusers;
	}
	public void setActiveusers(int activeusers) {
		this.activeusers = activeusers;
	}
	public int getStarttimes() {
		return starttimes;
	}
	public void setStarttimes(int starttimes) {
		this.starttimes = starttimes;
	}
	public int getTotalusers() {
		return totalusers;
	}
	public void setTotalusers(int totalusers) {
		this.totalusers = totalusers;
	}
	public int getUpordown() {
		return upordown;
	}
	public void setUpordown(int upordown) {
		this.upordown = upordown;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
}
