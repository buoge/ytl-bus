/**
* <p>Title: Bus.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

/**
* <p>Title: Bus</p>
* <p>Description: 蚌埠Bus专用</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2016年12月9日 下午4:48:00
* version 1.0
*/
public class Bus {
	private String id;
	private String busName;
	private String lineId;
	private String devId;
	private Date createTime;
	
	private String lineName;
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	*/
	public Bus() {
		super();
	}
	
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param id
	* @param busName
	* @param lineId
	* @param devId
	* @param createTime
	* @param lineName
	*/
	public Bus(String id, String busName, String lineId, String devId, Date createTime, String lineName) {
		super();
		this.id = id;
		this.busName = busName;
		this.lineId = lineId;
		this.devId = devId;
		this.createTime = createTime;
		this.lineName = lineName;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getDevId() {
		return devId;
	}
	public void setDevId(String devId) {
		this.devId = devId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", busName=" + busName + ", lineId=" + lineId + ", devId=" + devId + ", createTime="
				+ createTime + ", lineName=" + lineName + "]";
	}
	
}
