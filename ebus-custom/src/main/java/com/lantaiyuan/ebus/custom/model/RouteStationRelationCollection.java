package com.lantaiyuan.ebus.custom.model;

import java.util.List;

import org.lanqiao.ssm.common.model.Model;

/***
 * 
* <p>Title: RouteStationRelation</p>
* <p>Description: 线站自定义集合类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年3月31日 下午3:18:17
 */
public class RouteStationRelationCollection extends Model {
    private static final long serialVersionUID = 1L;
    
    private String id;
    
    //线路方向拼接字符串
    private String routeiddirection;
    
    private List<RouteStationRelation> routeStationRelations;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getRouteiddirection() {
		return routeiddirection;
	}

	public void setRouteiddirection(String routeiddirection) {
		this.routeiddirection = routeiddirection;
	}

	public List<RouteStationRelation> getRouteStationRelations() {
		return routeStationRelations;
	}

	public void setRouteStationRelations(List<RouteStationRelation> routeStationRelations) {
		this.routeStationRelations = routeStationRelations;
	}

	@Override
	public String toString() {
		return "RouteStationRelationCollection [id=" + id + ", routeiddirection=" + routeiddirection
				+ ", routeStationRelations=" + routeStationRelations + "]";
	}

}