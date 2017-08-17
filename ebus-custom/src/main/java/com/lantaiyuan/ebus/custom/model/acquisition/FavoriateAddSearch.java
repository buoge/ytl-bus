/**
* <p>Title: FavoriateAddSearch.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/**
* <p>Title: FavoriateAddSearch</p>
* <p>Description: 收藏新增埋点类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年2月14日 下午4:27:33
*/
//cmd:116
public class FavoriateAddSearch extends BaseModel{
    /***serialVersionUID***/
	private static final long serialVersionUID = 1L;
	
	//城市编码
    private String citycode;
    //搜索人位置
    private String position;
    //线路id
    private String routeid;
    //站点id
    private String stationid;
    //站点名称
    private String stationname;
    //线路方向
    private String direction;
    
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getRouteid() {
		return routeid;
	}
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}
	public String getStationid() {
		return stationid;
	}
	public void setStationid(String stationid) {
		this.stationid = stationid;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
    
}
