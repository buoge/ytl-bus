package com.lantaiyuan.ebus.common.util;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @Title: HttpClientHelper.java
 * @Package com.lty.custom
 * @Description:HTTPClient调用第三方api接口工具类
 * @author yangyang
 * @date 2017年3月31日 下午6:32:24
 * @version v1.0
 */
public class HttpClientHelper {

	private static Logger logger = LoggerFactory.getLogger(HttpClientHelper.class);

	public static String get(String url, Map<String, String> params) {
		String result = null;
		URI uri = uri(url, params);
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					HttpEntity entity = response.getEntity();
					result = EntityUtils.toString(entity);
					EntityUtils.consume(entity);
				} else {
					result = "error|".concat(String.valueOf(response.getStatusLine().getStatusCode()));
				}
			} catch (IOException e) {
				logger.error("httpclient报错", e);
				result = "error|".concat(e.getMessage());
			} finally {
				response.close();
			}
		} catch (Exception e1) {
			logger.error("httpclient报错", e1);
			result = "error|".concat(e1.getMessage());
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				logger.error("httpclient close失败", e);
				result = "error|".concat(e.getMessage());
			}
		}
		return result;
	}

	private static URI uri(String url, Map<String, String> params) {
		URI uri = null;
		try {
			URIBuilder uriBuilder = new URIBuilder(url);
			if (!StringUtils.isEmpty(params)) {
				params.forEach((k, v) -> {
					uriBuilder.addParameter(k, v);
				});
			}
			uri = uriBuilder.build();
		} catch (Exception e) {
			logger.error("URI转换失败", e);
		}
		return uri;
	}

}
