package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/** 
  * @Title: ODMap.java
  * @Package com.lantaiyuan.ebus.custom.model
  * @Description: 
  * @author yangyang   
  * @date 2017年2月27日 下午4:37:41
  * @version v1.0  
 */
public class ODMap extends Model {

	private static final long serialVersionUID = 2264396433524754529L;
	
	private OriDestPoint start;
	private OriDestPoint end;
	private int persons;
	private double angle;
	private boolean isIgnore = false;
	
	public ODMap isIgnore(boolean isIgnore) {
		this.isIgnore = isIgnore;
		return this;
	}
	
	public ODMap start(OriDestPoint start) {
		this.start = start;
		return this;
	}
	
	public ODMap end(OriDestPoint end) {
		this.end = end;
		return this;
	}
	
	public ODMap persons(int persons) {
		this.persons = persons;
		return this;
	}
	
	public ODMap angle(double angle) {
		this.angle = angle;
		return this;
	}
	
	
	

	public boolean isIgnore() {
		return isIgnore;
	}

	public void setIgnore(boolean isIgnore) {
		this.isIgnore = isIgnore;
	}

	public OriDestPoint getStart() {
		return start;
	}
	public void setStart(OriDestPoint start) {
		this.start = start;
	}
	public OriDestPoint getEnd() {
		return end;
	}
	public void setEnd(OriDestPoint end) {
		this.end = end;
	}
	public int getPersons() {
		return persons;
	}
	public void setPersons(int persons) {
		this.persons = persons;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public String toString() {
		return "ODMap [start=" + start + ", end=" + end + ", persons=" + persons + ", angle=" + angle + ", isIgnore="
				+ isIgnore + "]";
	}
	
	
}
