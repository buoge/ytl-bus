package com.lantaiyuan.ebus.realtime.model;

import org.lanqiao.ssm.common.model.Model;

import com.lantaiyuan.ebus.custom.model.BaseBus;

/**
 * 
* @Title: RealTime.java
* @Package com.lantaiyuan.ebus.realtime.model
* @Description: 实时信息返回结果
* @author yangyang   
* @date 2017年1月6日 下午1:38:01
* @version v1.0
 */
public class RealTime extends Model {

	private static final long serialVersionUID = -7272089779732841901L;
	
	public RealTime() {
		super();
	}

	public RealTime(BaseBus bus, BusDesc desc) {
		super();
		this.bus = bus;
		this.desc = desc;
	}

	private BaseBus bus;
	
	private BusDesc desc;

	public BaseBus getBus() {
		return bus;
	}

	public void setBus(BaseBus bus) {
		this.bus = bus;
	}

	public BusDesc getDesc() {
		return desc;
	}

	public void setDesc(BusDesc desc) {
		this.desc = desc;
	}


	@Override
	public String toString() {
		return  desc.toString();
	}
	
	
	
}
