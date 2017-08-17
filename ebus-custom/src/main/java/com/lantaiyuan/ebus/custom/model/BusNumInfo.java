package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

public class BusNumInfo extends Model {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

	private String routename;

    private String busnum;
    

    /**
	 * @return the routename
	 */
	public String getRoutename() {
		return routename;
	}

	/**
	 * @param routename the routename to set
	 */
	public void setRoutename(String routename) {
		this.routename = routename;
	}

	/**
	 * @return the busnum
	 */
	public String getBusnum() {
		return busnum;
	}

	/**
	 * @param busnum the busnum to set
	 */
	public void setBusnum(String busnum) {
		this.busnum = busnum;
	}
}