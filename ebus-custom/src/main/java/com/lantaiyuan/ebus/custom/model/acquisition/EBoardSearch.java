/**
* <p>Title: EBoardSearch.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/**
* <p>Title: EBoardSearch</p>
* <p>Description: 电子站牌查询埋点类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年2月14日 下午4:21:00
*/
//cmd:110
public class EBoardSearch extends BaseModel{
	/***serialVersionUID***/
	private static final long serialVersionUID = 1L;
	
    //城市编码
    private String citycode;
    //站点名称
    private String stationname;
    //站点id
    private String stationid;
    //搜索人位置
    private String position;
    
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getStationid() {
		return stationid;
	}
	public void setStationid(String stationid) {
		this.stationid = stationid;
	}
    
}
