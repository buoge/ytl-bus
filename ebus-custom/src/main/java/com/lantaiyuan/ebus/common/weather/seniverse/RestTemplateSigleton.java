package com.lantaiyuan.ebus.common.weather.seniverse;

import org.springframework.web.client.RestTemplate;
/**
 * 描述:http请求模板对象实例类
 * 作者:温海金
 * 最后更改时间:下午2:19:49
 */
public class RestTemplateSigleton {
	/**
	 * spring提供的rest接口访问模板对象
	 */
	private static RestTemplate restTemplate = null;
	
	public static RestTemplate getInstance() {
		if(restTemplate == null) {
			synchronized (RestTemplateSigleton.class) {
				if(restTemplate == null) {
					restTemplate = new RestTemplate();
				}
			}
		}
		return restTemplate;
	}
	
}
