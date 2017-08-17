package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import org.lanqiao.ssm.common.model.Model;

/*
 * 周边游路线对应的专线基本信息
 */
public class TravelAroundRoute extends Model {
    private static final long serialVersionUID = 1L;

    private String routeid;

    private String routename;

    private Integer routetype;

    private BigDecimal distance;

    private String price;
    
    private String startstation;

    private String endstation;

    private Integer direction;

    private String citycode;

	public String getRouteid() {
		return routeid;
	}

	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}

	public String getRoutename() {
		return routename;
	}

	public void setRoutename(String routename) {
		this.routename = routename;
	}

	public Integer getRoutetype() {
		return routetype;
	}

	public void setRoutetype(Integer routetype) {
		this.routetype = routetype;
	}

	public BigDecimal getDistance() {
		return distance;
	}

	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStartstation() {
		return startstation;
	}

	public void setStartstation(String startstation) {
		this.startstation = startstation;
	}

	public String getEndstation() {
		return endstation;
	}

	public void setEndstation(String endstation) {
		this.endstation = endstation;
	}

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
    
}