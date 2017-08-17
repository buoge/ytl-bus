/**
* <p>Title: FavoriateLineSearch.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/**
* <p>Title: FavoriateLineSearch</p>
* <p>Description: 查询线路收藏详情埋点类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年2月14日 下午4:23:25
*/
//cmd:115
public class FavoriateLineSearch extends BaseModel{
	/***serialVersionUID***/
	private static final long serialVersionUID = 1L;
	
    //城市编码
    private String citycode;
    //搜索人位置
    private String position;
    
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
    
}
