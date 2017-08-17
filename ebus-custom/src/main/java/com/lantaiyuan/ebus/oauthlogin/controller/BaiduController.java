package com.lantaiyuan.ebus.oauthlogin.controller;

import java.util.HashMap;
import java.util.Map;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lantaiyuan.ebus.oauthlogin.constant.Constants;
import com.lantaiyuan.ebus.oauthlogin.model.BaiduAccessToken;

/**
 * 百度第三方接口controller
 * @author yangyang
 * @date 2017年6月16日 上午11:38:04 
 *
 */
@RestController
@RequestMapping("/baidu")
public class BaiduController extends BasicController {
	
	private static Logger logger = LoggerFactory.getLogger(BaiduController.class);
	
	/**
	 * 请求授权由前端发起，redirect_uri需要设置为本接口的请求路径
	 * 参考：http://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id=sYovrsHRZi3HfYz3MFMC7KAk&redirect_uri=http://localhost:8080/ebus-custom/baidu/code&scope=basic&display=page
	 * 用户同意授权后，百度回调本接口，会把code附加在url后面：/?code={#code}
	 * 获取code后，请求access token，
	 * 需要注意redirect uri需要与请求授权时的redirect uri保持一致（即redirect uri就是本接口）
	 * 如果不保持一致，会报400 bad request
	 * @author yangyang
	 * @param code
	 * @return
	 */
	@GetMapping("/code")
	public Json authCode(String code) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> map = new HashMap<>();
		map.put("code", code);
		map.put("BAIDU_API_KEY", Constants.BAIDU_API_KEY);
		map.put("BAIDU_SECRET_KEY", Constants.BAIDU_SECRET_KEY);
		map.put("BAIDU_REGISTERED_REDIRECT_URI", Constants.BAIDU_REGISTERED_REDIRECT_URI);
		ResponseEntity<BaiduAccessToken> entity = null;
		try {
			entity = restTemplate.getForEntity(Constants.BAIDU_ACCESS_TOKEN_URL, BaiduAccessToken.class, map);
		}catch (Exception e) {
			logger.error("请求百度access token报错", e);
		}
		if (!StringUtils.isEmpty(entity) && entity.getStatusCode() == HttpStatus.OK) {
			return setSimpleSuccess(entity.getBody());
		}
		return setFailed();
	}
	
	

}
