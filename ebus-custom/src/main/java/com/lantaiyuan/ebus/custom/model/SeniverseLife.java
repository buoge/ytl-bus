package com.lantaiyuan.ebus.custom.model;

/**
 * 描述:心知天气生活指数
 * 作者:温海金
 * 最后更改时间:下午4:10:20
 */
public class SeniverseLife {
	/**
	 * 运动指数
	 */
	private String sport;
	/**
	 * 感冒指数
	 */
	private String flu;
	/**
	 * 紫外线
	 */
	private String uv;
	
	public SeniverseLife(String sport, String flu, String uv) {
		super();
		this.sport = sport;
		this.flu = flu;
		this.uv = uv;
	}
	
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getFlu() {
		return flu;
	}
	public void setFlu(String flu) {
		this.flu = flu;
	}
	public String getUv() {
		return uv;
	}
	public void setUv(String uv) {
		this.uv = uv;
	}
	
}
