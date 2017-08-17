package com.lantaiyuan.ebus.common.weather.seniverse;

import org.springframework.http.ResponseEntity;
/**
 * 描述:心知天气
 * 作者:温海金
 * 最后更改时间:下午2:16:19
 */
public class SeniverseWeatherHelper {
	/**
	 * 注册KEY值
	 */
	private static String KEY = "2poa1sq8xbc0dnxo";	
	/**
	 * 天气接口前缀
	 */
	public static String WEATHER_URL_PRE = "https://api.seniverse.com/v3/weather/now.json?language=zh-Hans&unit=c";
	/**
	 * 生活指数接口前缀
	 */
	public static String LIFE_URL_PRE = "https://api.seniverse.com/v3/life/suggestion.json?language=zh-Hans";
	/**
	 * 功能描述:返回接口调用结果
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月19日 下午2:40:10
	 */
	public static ResponseEntity<String> getSeniverseInterfaceResult(String URL, String cityName) {
		return getResultOfRequest(URL+"&location="+cityName.trim()+"&key="+KEY);
	}
	
	/**
	 * 功能描述:获取URL执行结果
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月19日 下午2:40:10
	 */
	private static ResponseEntity<String> getResultOfRequest(String url) {
		return RestTemplateSigleton.getInstance().getForEntity(url, String.class);
	}
	
}
