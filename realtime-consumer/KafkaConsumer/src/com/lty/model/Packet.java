package com.lty.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.lty.enummodel.PacketTypeEnum;

/** 
  * @Title: Packet.java
  * @Package com.lty.model
  * @Description: 
  * @author yangyang   
  * @date 2017年4月19日 下午6:06:59
  * @version v1.0  
 */
public class Packet implements Serializable{

	private static final long serialVersionUID = 8059594233744971284L;
	
	private int vehicleId;
	private int gprsId;
	private String packetType;
	private String protocolVersion;
	private int direction;
	private String eventTime;
	
	public Packet(JSONObject jsonObj) {
		this.vehicleId = jsonObj.getIntValue("vehicleId");
		this.gprsId = jsonObj.getIntValue("gprsId");
		this.packetType = jsonObj.getString("packetType");
		this.protocolVersion = jsonObj.getString("protocolVersion");
		this.direction = jsonObj.getIntValue("direction");
		setEventTime(jsonObj,packetType);
	}
	
	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(JSONObject jsonObj,String packetType) {
		if (packetType.equals(PacketTypeEnum.INSTATION.value()) || packetType.equals(PacketTypeEnum.GPS.value())) {
			this.eventTime = jsonObj.getString("eventTime");
		}else if (packetType.equals(PacketTypeEnum.OUTSTATION.value())) {
			this.eventTime = jsonObj.getString("outStationTime");
		}
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getGprsId() {
		return gprsId;
	}

	public void setGprsId(int gprsId) {
		this.gprsId = gprsId;
	}

	public String getPacketType() {
		return packetType;
	}

	public void setPacketType(String packetType) {
		this.packetType = packetType;
	}

	public String getProtocolVersion() {
		return protocolVersion;
	}

	public void setProtocolVersion(String protocolVersion) {
		this.protocolVersion = protocolVersion;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	
	
	

}
