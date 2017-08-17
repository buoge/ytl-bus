package com.lantaiyuan.ebus.custom.model;

/**
 * 描述:心知天气及生活指数
 * 作者:温海金
 * 最后更改时间:下午4:10:20
 */
public class SeniverseWeatherAndLife {
	/**
	 * 心知天气信息
	 */
	private SeniverseWeather seniverseWeather;
	/**
	 * 心知生活指数
	 */
	private SeniverseLife seniverseLife;
	
	
	public SeniverseWeatherAndLife(SeniverseWeather seniverseWeather, SeniverseLife seniverseLife) {
		super();
		this.seniverseWeather = seniverseWeather;
		this.seniverseLife = seniverseLife;
	}
	
	public SeniverseWeather getSeniverseWeather() {
		return seniverseWeather;
	}
	public void setSeniverseWeather(SeniverseWeather seniverseWeather) {
		this.seniverseWeather = seniverseWeather;
	}
	public SeniverseLife getSeniverseLife() {
		return seniverseLife;
	}
	public void setSeniverseLife(SeniverseLife seniverseLife) {
		this.seniverseLife = seniverseLife;
	}
	
}
