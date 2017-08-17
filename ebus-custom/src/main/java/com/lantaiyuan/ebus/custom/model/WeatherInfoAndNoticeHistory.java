package com.lantaiyuan.ebus.custom.model;

import java.util.List;

public class WeatherInfoAndNoticeHistory {
	/**
	 * 天气信息
	 */
	private SeniverseWeatherAndLife seniverseWeatherAndLife;
	/**
	 * 紧急通知列表
	 */
	private List<NoticeHistory> noticeHistorys;
	
	
	public WeatherInfoAndNoticeHistory() {
	}
	
	public WeatherInfoAndNoticeHistory(SeniverseWeatherAndLife seniverseWeatherAndLife, List<NoticeHistory> noticeHistorys) {
		super();
		this.seniverseWeatherAndLife = seniverseWeatherAndLife;
		this.noticeHistorys = noticeHistorys;
	}


	public SeniverseWeatherAndLife getSeniverseWeatherAndLife() {
		return seniverseWeatherAndLife;
	}



	public void setSeniverseWeatherAndLife(SeniverseWeatherAndLife seniverseWeatherAndLife) {
		this.seniverseWeatherAndLife = seniverseWeatherAndLife;
	}



	public List<NoticeHistory> getNoticeHistorys() {
		return noticeHistorys;
	}
	public void setNoticeHistorys(List<NoticeHistory> noticeHistorys) {
		this.noticeHistorys = noticeHistorys;
	}
	
	
}
