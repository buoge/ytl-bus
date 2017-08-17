package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * @author yangyang
 * 2016年12月14日 上午11:39:21
 *
 */
public class TimePersonCount extends Model{

	private static final long serialVersionUID = 1128205902252203766L;
	
	private String time;
	
	private int count;
	
	public static TimePersonCount newInstance(String time, int count) {
		TimePersonCount tpc = new TimePersonCount();
		tpc.setCount(count);
		tpc.setTime(time);
		return tpc;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
