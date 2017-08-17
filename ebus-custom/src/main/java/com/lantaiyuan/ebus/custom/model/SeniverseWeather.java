package com.lantaiyuan.ebus.custom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 描述:心知天气-天气信息对象
 * 作者:温海金
 * 最后更改时间:下午6:53:11
 */
public class SeniverseWeather {
	/**
	 * 天气情况
	 */
	private String text;
	/**
	 * 返回编码（不展示给前端）
	 */
	@JsonIgnore
	private String code;
	/**
	 * 温度
	 */
	private String temperature;
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	
}
