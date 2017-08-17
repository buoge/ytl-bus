package com.lantaiyuan.ebus.custom.model;

import com.lantaiyuan.ebus.realtime.model.RealTime;

/**
 * 描述:推荐线路中的人民公交数据对象
 * 作者:温海金
 * 最后更改时间:下午3:07:15
 */
public class GeneralRoute {
	/**
	 * 线路信息
	 */
	private BaseRoute baseRoute;
	/**
	 * 上车站点
	 */
	private UpAndDownStation upStation;
	/**
	 * 下车站点
	 */
	private UpAndDownStation downStation;
	/**
	 * 距离上车站点最近的一辆车辆
	 */
	private RealTime nearestBus;
	
	public GeneralRoute() {
		super();
	}

	public GeneralRoute(BaseRoute baseRoute, UpAndDownStation upStation, UpAndDownStation downStation, RealTime nearestBus) {
		super();
		this.baseRoute = baseRoute;
		this.upStation = upStation;
		this.downStation = downStation;
		this.nearestBus = nearestBus;
	}
	
	public BaseRoute getBaseRoute() {
		return baseRoute;
	}
	public void setBaseRoute(BaseRoute baseRoute) {
		this.baseRoute = baseRoute;
	}
	public UpAndDownStation getUpStation() {
		return upStation;
	}
	public void setUpStation(UpAndDownStation upStation) {
		this.upStation = upStation;
	}
	public UpAndDownStation getDownStation() {
		return downStation;
	}
	public void setDownStation(UpAndDownStation downStation) {
		this.downStation = downStation;
	}
	public RealTime getNearestBus() {
		return nearestBus;
	}
	public void setNearestBus(RealTime nearestBus) {
		this.nearestBus = nearestBus;
	}
	
}
