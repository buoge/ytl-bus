/**
* <p>Title: Pois.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.model.gaode;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
* <p>Title: Pois</p>
* <p>Description: 返回前端Poi封装类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年4月28日 下午3:03:08
*/
public class MyPoi {
	@JsonIgnore
	private String address;
	
	@JsonIgnore
	private String adname;
	
	@JsonIgnore
	private String biz_ext;
	
	@JsonIgnore
	private String biz_type;
	
	@JsonIgnore
	private String cityname;
	
	@JsonIgnore
	private String distance;
	
	@JsonIgnore
	private String id;
	
	@JsonIgnore
	private String importance;
	
	@JsonIgnore
	private String location;
	
	private String name;
	
	private String lat;
	
	private String lon;
	
	@JsonIgnore
	private String pname;
	
	@JsonIgnore
	private String poiweight;
	
	@JsonIgnore
	private String shopid;
	
	@JsonIgnore
	private String shopinfo;
	
	@JsonIgnore
	private String tel;
	
	@JsonIgnore
	private String type;
	
	@JsonIgnore
	private String typecode;
	
	/**
	* @return address
	*/
	public String getAddress() {
		return address;
	}
	/**
	* @param address 要设置的 address
	*/
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	* @return adname
	*/
	public String getAdname() {
		return adname;
	}
	/**
	* @param adname 要设置的 adname
	*/
	public void setAdname(String adname) {
		this.adname = adname;
	}
	/**
	* @return biz_ext
	*/
	public String getBiz_ext() {
		return biz_ext;
	}
	/**
	* @param biz_ext 要设置的 biz_ext
	*/
	public void setBiz_ext(String biz_ext) {
		this.biz_ext = biz_ext;
	}
	/**
	* @return biz_type
	*/
	public String getBiz_type() {
		return biz_type;
	}
	/**
	* @param biz_type 要设置的 biz_type
	*/
	public void setBiz_type(String biz_type) {
		this.biz_type = biz_type;
	}
	/**
	* @return cityname
	*/
	public String getCityname() {
		return cityname;
	}
	/**
	* @param cityname 要设置的 cityname
	*/
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	/**
	* @return distance
	*/
	public String getDistance() {
		return distance;
	}
	/**
	* @param distance 要设置的 distance
	*/
	public void setDistance(String distance) {
		this.distance = distance;
	}
	/**
	* @return id
	*/
	public String getId() {
		return id;
	}
	/**
	* @param id 要设置的 id
	*/
	public void setId(String id) {
		this.id = id;
	}
	/**
	* @return importance
	*/
	public String getImportance() {
		return importance;
	}
	/**
	* @param importance 要设置的 importance
	*/
	public void setImportance(String importance) {
		this.importance = importance;
	}
	/**
	* @return location
	*/
	public String getLocation() {
		return location;
	}
	/**
	* @param location 要设置的 location
	*/
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	* @return name
	*/
	public String getName() {
		return name;
	}
	/**
	* @param name 要设置的 name
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**
	* @return pname
	*/
	public String getPname() {
		return pname;
	}
	/**
	* @param pname 要设置的 pname
	*/
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	* @return poiweight
	*/
	public String getPoiweight() {
		return poiweight;
	}
	/**
	* @param poiweight 要设置的 poiweight
	*/
	public void setPoiweight(String poiweight) {
		this.poiweight = poiweight;
	}
	/**
	* @return shopid
	*/
	public String getShopid() {
		return shopid;
	}
	/**
	* @param shopid 要设置的 shopid
	*/
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	/**
	* @return shopinfo
	*/
	public String getShopinfo() {
		return shopinfo;
	}
	/**
	* @param shopinfo 要设置的 shopinfo
	*/
	public void setShopinfo(String shopinfo) {
		this.shopinfo = shopinfo;
	}
	/**
	* @return tel
	*/
	public String getTel() {
		return tel;
	}
	/**
	* @param tel 要设置的 tel
	*/
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	* @return type
	*/
	public String getType() {
		return type;
	}
	/**
	* @param type 要设置的 type
	*/
	public void setType(String type) {
		this.type = type;
	}
	/**
	* @return typecode
	*/
	public String getTypecode() {
		return typecode;
	}
	/**
	* @param typecode 要设置的 typecode
	*/
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	/**
	* @return lat
	*/
	public String getLat() {
		return lat;
	}
	/**
	* @param lat 要设置的 lat
	*/
	public void setLat(String lat) {
		this.lat = lat;
	}
	/**
	* @return lon
	*/
	public String getLon() {
		return lon;
	}
	/**
	* @param lon 要设置的 lon
	*/
	public void setLon(String lon) {
		this.lon = lon;
	}
	
}
