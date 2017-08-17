package com.lantaiyuan.ebus.custom.model.carpool;

import org.lanqiao.ssm.common.model.Model;

import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;

/**
 * 计算拼车线路中站点距离用户的距离
 * @author yangyang
 * @date 2017年6月14日 下午4:36:38 
 *
 */
public class StationToUserDistance extends Model{

	public StationToUserDistance(CarpoolRouteStation relRouteStation, double userDistance) {
		super();
		this.relRouteStation = relRouteStation;
		this.userDistance = userDistance;
	}

	public StationToUserDistance() {
		super();
	}

	private static final long serialVersionUID = 5177052429226790981L;
	
	private CarpoolRouteStation relRouteStation;
	
	private Double userDistance;

	public CarpoolRouteStation getRelRouteStation() {
		return relRouteStation;
	}

	public void setRelRouteStation(CarpoolRouteStation relRouteStation) {
		this.relRouteStation = relRouteStation;
	}

	public Double getUserDistance() {
		return userDistance;
	}

	public void setUserDistance(double userDistance) {
		this.userDistance = userDistance;
	}
	
	

}
