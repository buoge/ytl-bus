package com.lantaiyuan.ebus.custom.model.carpool;

import java.math.BigDecimal;
import java.util.List;

import org.lanqiao.ssm.common.model.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;
import com.lantaiyuan.ebus.realtime.model.Path;

/**
 * 拼车生成的线路详情，线路基础信息，线路辅助站点，线路线站关系，用户距离该线路最近的站点
 * 
 * @author yangyang
 * @date 2017年6月14日 下午2:51:56
 */
public class CarpoolRouteDetail extends Model {

	private static final long serialVersionUID = -3767352200718200452L;

	private Long id;

	private String carpoolRouteId;

	private String carpoolRouteName;

	/**
	 * 1：普通专线，2：直达专线 
	 */
	private Integer carpoolRouteType;


	/**
	 * 票价(单位：元) 
	 */
	private BigDecimal price;
	
	/**
	 * 辅助站点
	 */
	@JsonIgnore
	private String stationMap;
	
	private List<Path> assistStations;
	
	/**
	 * 线站关系
	 */
	private List<CarpoolRouteStation> relRouteStation;
	
	
	private CarpoolRouteStation currentStation;


	public List<Path> getAssistStations() {
		return assistStations;
	}


	public void setAssistStations(List<Path> assistStations) {
		this.assistStations = assistStations;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCarpoolRouteId() {
		return carpoolRouteId;
	}


	public void setCarpoolRouteId(String carpoolRouteId) {
		this.carpoolRouteId = carpoolRouteId;
	}


	public String getCarpoolRouteName() {
		return carpoolRouteName;
	}


	public void setCarpoolRouteName(String carpoolRouteName) {
		this.carpoolRouteName = carpoolRouteName;
	}


	public Integer getCarpoolRouteType() {
		return carpoolRouteType;
	}


	public void setCarpoolRouteType(Integer carpoolRouteType) {
		this.carpoolRouteType = carpoolRouteType;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getStationMap() {
		return stationMap;
	}


	public void setStationMap(String stationMap) {
		this.stationMap = stationMap;
	}


	public List<CarpoolRouteStation> getRelRouteStation() {
		return relRouteStation;
	}


	public void setRelRouteStation(List<CarpoolRouteStation> relRouteStation) {
		this.relRouteStation = relRouteStation;
	}


	public CarpoolRouteStation getCurrentStation() {
		return currentStation;
	}


	public void setCurrentStation(CarpoolRouteStation currentStation) {
		this.currentStation = currentStation;
	}
	
	
}
