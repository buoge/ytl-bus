package com.lantaiyuan.ebus.custom.service;

import com.lantaiyuan.ebus.custom.model.WeatherInfoAndNoticeHistory;

/**
 * 描述:天气预报业务接口
 * 作者:温海金
 * 最后更改时间:下午4:04:55
 */
public interface WeatherServiceI {
	
	/**
	 * 功能描述:获取心知天气信息及紧急通知记录
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月19日 下午4:58:40
	 */
	WeatherInfoAndNoticeHistory getSeniverseWeatherAndNoticeHistory(String cityName, String userId);
}
