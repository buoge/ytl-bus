package com.lantaiyuan.ebus.common.weather.juhe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:获取聚合天气信息
 * 作者:温海金
 * 最后更改时间:下午3:25:05
 */
public class JuheWeatherHelper {
	
	private static RestTemplate restTemplate = null;
	
	/**
	 * 全国天气预报appKey
	 */
	private static String WEATHER_ALL = "229b001eab138306715e06e890d32f7e";
	/**
	 * 天气质量appKey
	 */
	//private static String WEATHER_QUALITY = "91d8f3aa051ce080f2d9b00c9cbc9ee6";
	/**
	 * 灾害预警
	 */
	//private static String DISASTER_WARNING = "a75adbd65b23a1f13ce65c0484b65b61";
	
	public static RestTemplate getRestTemplate() {
		if(restTemplate == null) {
			synchronized (JuheWeatherHelper.class) {
				if(restTemplate == null) {
					restTemplate = new RestTemplate();
				}
			}
		}
		return restTemplate;
	}
	/**
	 * 功能描述:返回指定城市的天气预报
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月19日 下午2:40:10
	 */
	public static ResponseEntity<String> excuteWeatherForTheCity(String cityName) {
		String url = "http://v.juhe.cn/weather/index?format=2"+"&cityname="+cityName.trim()+"&key=" + WEATHER_ALL; 
		return getRestTemplate().getForEntity(url, String.class);
	}
	
	public static void main(String[] args) {
		String url = "https://api.seniverse.com/v3/weather/now.json?key=2poa1sq8xbc0dnxo&location=beijing&language=zh-Hans&unit=c";
		ResponseEntity<String> forEntity = getRestTemplate().getForEntity(url, String.class);
		System.out.println(forEntity);
	}
	
}
