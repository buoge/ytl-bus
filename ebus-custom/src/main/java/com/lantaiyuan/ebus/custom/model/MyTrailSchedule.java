package com.lantaiyuan.ebus.custom.model;


import java.util.List;

import org.lanqiao.ssm.common.model.Model;


/**
 * 描述:我的行程（手机端展示）对象
 * 作者:温海金
 * 最后更改时间:上午11:40:00
 */
public class MyTrailSchedule extends Model{

	private static final long serialVersionUID = 1805487859675897484L;
	/**
	 * 行程列表
	 */
	private List<MyTrailVo> schedule;
	
	/**
	 * 行程时间
	 */
	private String scheduleTime;

	public List<MyTrailVo> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<MyTrailVo> schedule) {
		this.schedule = schedule;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	
	
}