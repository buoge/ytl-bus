package com.lantaiyuan.ebus.custom.model;

import java.util.List;

import com.lantaiyuan.ebus.custom.model.carpool.CarpoolMatchAndRouteResultModel;

public class AllLines {
	/**
	 * 普通人民公交
	 */
	private List<BaseRoute> baseRoutes;
	/**
	 * 专线信息
	 */
	private List<CustomLine> customLines;
	/**
	 * 拼车中的信息
	 */
	private List<CarpoolMatchAndRouteResultModel> carpoolMatchs;
	
	public AllLines() {
		super();
	}
	
	public AllLines(List<BaseRoute> baseRoutes, List<CustomLine> customLines, List<CarpoolMatchAndRouteResultModel> carpoolMatchs) {
		super();
		this.baseRoutes = baseRoutes;
		this.customLines = customLines;
		this.carpoolMatchs = carpoolMatchs;
	}
	
	public List<BaseRoute> getBaseRoutes() {
		return baseRoutes;
	}
	public void setBaseRoutes(List<BaseRoute> baseRoutes) {
		this.baseRoutes = baseRoutes;
	}
	public List<CustomLine> getCustomLines() {
		return customLines;
	}
	public void setCustomLines(List<CustomLine> customLines) {
		this.customLines = customLines;
	}
	public List<CarpoolMatchAndRouteResultModel> getCarpoolMatchs() {
		return carpoolMatchs;
	}
	public void setCarpoolMatchs(List<CarpoolMatchAndRouteResultModel> carpoolMatchs) {
		this.carpoolMatchs = carpoolMatchs;
	}
	
	
}
