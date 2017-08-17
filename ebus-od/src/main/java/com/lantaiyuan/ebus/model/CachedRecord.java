/**
* <p>Title: CachedRecord.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.model;

/**
* <p>Title: CachedRecord</p>
* <p>Description: 缓存用户、车辆数据、次数Record</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月11日 下午5:46:02
*/
public class CachedRecord {
	//用户刚上车时车辆位置记录
	private GpsRecord gpsRecord;
	
	//出现次数
	private Integer times;

	/**
	* @return gpsRecord
	*/
	public GpsRecord getGpsRecord() {
		return gpsRecord;
	}

	/**
	* @param gpsRecord 要设置的 gpsRecord
	*/
	public void setGpsRecord(GpsRecord gpsRecord) {
		this.gpsRecord = gpsRecord;
	}

	/**
	* @return times
	*/
	public Integer getTimes() {
		return times;
	}

	/**
	* @param times 要设置的 times
	*/
	public void setTimes(Integer times) {
		this.times = times;
	}
	
}
