package com.lantaiyuan.ebus.custom.service.impl;

import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.common.weather.seniverse.SeniverseWeatherHelper;
import com.lantaiyuan.ebus.custom.model.NoticeHistory;
import com.lantaiyuan.ebus.custom.model.SeniverseLife;
import com.lantaiyuan.ebus.custom.model.SeniverseWeather;
import com.lantaiyuan.ebus.custom.model.SeniverseWeatherAndLife;
import com.lantaiyuan.ebus.custom.model.WeatherInfoAndNoticeHistory;
import com.lantaiyuan.ebus.custom.service.NoticeHistoryServiceI;
import com.lantaiyuan.ebus.custom.service.WeatherServiceI;

@CacheConfig(cacheNames="weatherInfo")
@Service("weatherService")
public class WeatherServiceImpl implements WeatherServiceI {

	@Resource
	private NoticeHistoryServiceI noticeHistoryService;

	/**
	 * 功能描述:得到聚合天气及生活指数信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月20日 下午4:47:18
	 */
	@Cacheable
	private SeniverseWeatherAndLife getSeniverseWeather(String cityName) {
		//1.得到天气信息
		ResponseEntity<String> weatherInfo = SeniverseWeatherHelper.getSeniverseInterfaceResult(SeniverseWeatherHelper.WEATHER_URL_PRE, cityName);
		String weatherBody = weatherInfo.getBody();
		JSONObject weatherJSONObj = JSONObject.parseObject(weatherBody);
		//得到天气对象数组
		JSONArray weatherArray = weatherJSONObj.getJSONArray("results");
		//得到数组内的对象
		JSONObject weatherObject = weatherArray.getJSONObject(0);
		//得到当前天气信息对象
		JSONObject now = weatherObject.getJSONObject("now");
		SeniverseWeather seniverseWeather = JSON.parseObject(now.toJSONString(), SeniverseWeather.class);
		//2.得到生活指数
		ResponseEntity<String> lifeInfo = SeniverseWeatherHelper.getSeniverseInterfaceResult(SeniverseWeatherHelper.LIFE_URL_PRE, cityName);
		JSONObject lifeJsonObj = JSONObject.parseObject(lifeInfo.getBody());
		JSONObject lifeObject = lifeJsonObj.getJSONArray("results").getJSONObject(0);
		JSONObject suggestion = lifeObject.getJSONObject("suggestion");
		
		String flu = suggestion.getJSONObject("flu").get("brief").toString();//感冒指数
		String sport = suggestion.getJSONObject("sport").get("brief").toString();//运动指数
		String uv = suggestion.getJSONObject("uv").get("brief").toString();//紫外线
		return new SeniverseWeatherAndLife(seniverseWeather, new SeniverseLife(sport, flu, uv));
	}
	
	/**
	 * 功能描述:根据用户id得到通知记录信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月19日 下午5:41:10
	 */
	private List<NoticeHistory> getNoticeHistorysByUserId4Weather(String userId) {
		return noticeHistoryService.getNoticeHistorysByUserId4Weather(userId);
	}

	/**
	 * 功能描述:得到心知天气信息（包括天气及生活指数信息）和用户的历史通知记录
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月20日 下午3:15:08
	 */
	@Override
	public WeatherInfoAndNoticeHistory getSeniverseWeatherAndNoticeHistory(String cityName, String userId) {
		//1.得到天气信息
		SeniverseWeatherAndLife seniverseWeather = this.getSeniverseWeather(cityName);
		//2.得到历史通知记录信息
		List<NoticeHistory> noticeHistorys;
		if(StringUtils.isEmpty(userId)) {//未登入用户返回空集合
			noticeHistorys = Collections.emptyList();
		} else {
			noticeHistorys = getNoticeHistorysByUserId4Weather(userId);
		}
		return new WeatherInfoAndNoticeHistory(seniverseWeather, noticeHistorys);
	}

	
}
