package com.lantaiyuan.ebus.custom.model;

import java.util.List;

import org.lanqiao.ssm.common.model.Model;

public class StationRelation extends Model {

	private static final long serialVersionUID = -4878913148580030959L;
	
	private StationCount start;
	private StationCount end;
	private List<TimePersonCount> time_person;
	private double angle;
	
	public static StationRelation newInstance(StationCount start, StationCount end,
			 List<TimePersonCount> time_person) {
		StationRelation sr = new StationRelation();
		sr.setStart(start);
		sr.setEnd(end);
		sr.setTime_person(time_person);
		return sr;
	}
	
	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public List<TimePersonCount> getTime_person() {
		return time_person;
	}

	public void setTime_person(List<TimePersonCount> time_person) {
		this.time_person = time_person;
	}


	public StationCount getStart() {
		return start;
	}

	public void setStart(StationCount start) {
		this.start = start;
	}

	public StationCount getEnd() {
		return end;
	}

	public void setEnd(StationCount end) {
		this.end = end;
	}

	
}
