package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/** 
  * @Title: TrendStatistics.java
  * @Package com.lantaiyuan.ebus.custom.model
  * @Description: 趋势分析
  * @author yangyang   
  * @date 2017年2月24日 下午2:13:39
  * @version v1.0  
 */
public class TrendStatistics extends Model{

	private static final long serialVersionUID = 440536712405748039L;
	
	private long newusers;
	private long activeusers;
	private long starttimes;
	private long totalusers;
	private String date;

	public TrendStatistics newusers(long newusers) {
		this.newusers = newusers;
		return this;
	}
	
	public TrendStatistics activeusers(long activeusers) {
		this.activeusers = activeusers;
		return this;
	}
	
	public TrendStatistics starttimes(long starttimes) {
		this.starttimes = starttimes;
		return this;
	}
	
	public TrendStatistics totalusers(long totalusers) {
		this.totalusers = totalusers;
		return this;
	}
	
	public TrendStatistics date(String date) {
		this.date = date;
		return this;
	}
	
	public long getNewusers() {
		return newusers;
	}

	public void setNewusers(long newusers) {
		this.newusers = newusers;
	}

	public long getActiveusers() {
		return activeusers;
	}

	public void setActiveusers(long activeusers) {
		this.activeusers = activeusers;
	}

	public long getStarttimes() {
		return starttimes;
	}

	public void setStarttimes(long starttimes) {
		this.starttimes = starttimes;
	}

	public long getTotalusers() {
		return totalusers;
	}

	public void setTotalusers(long totalusers) {
		this.totalusers = totalusers;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
