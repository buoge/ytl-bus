package com.lantaiyuan.ebus.custom.model.carpool;

import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;

import java.util.Date;

/**
 * 拼车撮合后行程的线路辅助站点表
 * CarpoolRouteStationResult
 * 数据库表：CarpoolRouteStationResult
 */

public class CarpoolRouteStationResult extends CarpoolRouteStation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 上车时间
     * 表字段 : carpool_order.expect_aboard_time
     */
    private Date AboardTime;
    
    /**
     * 上车人数
     */
    private int upPersionNum;
   
    /**
     * 下车人数
     */
    private int downPersionNum;

	public Date getAboardTime() {
		return AboardTime;
	}

	public void setAboardTime(Date aboardTime) {
		AboardTime = aboardTime;
	}

	public int getUpPersionNum() {
		return upPersionNum;
	}

	public void setUpPersionNum(int upPersionNum) {
		this.upPersionNum = upPersionNum;
	}

	public int getDownPersionNum() {
		return downPersionNum;
	}

	public void setDownPersionNum(int downPersionNum) {
		this.downPersionNum = downPersionNum;
	}
	
	/**
	 * 上车人数加1
	 * @return
	 */
	public int addUpPersionNum() {
		return this.getUpPersionNum() + 1;
	}
    
	/**
	 * 下车人数加1
	 * @return
	 */
	public int addDownPersionNum() {
		return this.getDownPersionNum() + 1;
	}
}