package com.lantaiyuan.ebus.custom.model.carpool;


import org.lanqiao.ssm.common.model.Model;

import java.util.Date;

/**
 * 推送给用户的拼车动态
 * @author yangyang
 * @date 2017年6月13日 下午5:05:03 
 */
public class JpushDynamics extends Model {

	public JpushDynamics(String message, Date time) {
		super();
		this.message = message;
		this.time = time;
	}

	public JpushDynamics() {
		super();
	}

	private static final long serialVersionUID = -8439770337729156532L;
	
	private String message;
	
	private Date time;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
