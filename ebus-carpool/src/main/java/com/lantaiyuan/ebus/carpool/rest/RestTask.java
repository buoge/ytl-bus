/**
* <p>Title: TestImplCommandLineRunner.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.carpool.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.carpool.model.kafkamodel.ReturnResult;
import com.lantaiyuan.ebus.carpool.model.kafkamodel.UserCarpoolBasic;

/**
 * <p>Title: TestImplCommandLineRunner</p>
 * <p>Description: RESTful调用第三方接口</p>
 * <p>Company: lty</p>
 * @author liuhao
 * @date 2017年5月15日 下午3:57:36
 */
@Component
public class RestTask {
	private static final Logger logger = LoggerFactory.getLogger(RestTask.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${carpool.joining.url}")
	private String carpoolJoiningUrl;
	
	@Value("${carpool.drawback.url}")
	private String carpoolDrawbackUrl;
	
	/***********HTTP GET method*************/
    public ReturnResult invokeUrl(UserCarpoolBasic basic){
    	Map<String, Object> paramMap = new HashMap<>();
    	paramMap.put("orderNo", basic.getOrderNo());
    	paramMap.put("matchId", basic.getMatchId());
    	paramMap.put("userId", basic.getUserId());
    	paramMap.put("paidPrice", basic.getPaidPrice());
    	paramMap.put("startPlaceName", basic.getStartPlaceName());
    	paramMap.put("startPlaceLon", basic.getStartPlaceLon());
    	paramMap.put("startPlaceLat", basic.getStartPlaceLat());
    	paramMap.put("endPlaceName", basic.getEndPlaceName());
    	paramMap.put("endPlaceLon", basic.getEndPlaceLon());
    	paramMap.put("endPlaceLat", basic.getEndPlaceLat());
    	paramMap.put("seats", basic.getSeats());
    	paramMap.put("maxWalkDistance", basic.getMaxWalkDistance());
    	paramMap.put("earliestStartTime", basic.getEarliestStartTime());
    	paramMap.put("latestStartTime", basic.getLatestStartTime());
    	paramMap.put("isRegular", basic.getIsRegular());
    	paramMap.put("regularDetail", basic.getRegularDetail());
    	paramMap.put("cityCode", basic.getCityCode());
    	
        JSONObject jsonObject;
		try {
			jsonObject = restTemplate.getForEntity(carpoolJoiningUrl, JSONObject.class, paramMap).getBody();
		} catch (Exception e) {
			logger.error("大数据url接口异常！",e);
			return null;
		}
        
        if (jsonObject == null) {
        	return null;
        }
         
        return JSONObject.toJavaObject(jsonObject, ReturnResult.class);
    }
    
    /***********HTTP GET method*************/
    public ReturnResult invokeUrl(List<String> carpoolOrders){
    	if (StringUtils.isEmpty(carpoolDrawbackUrl)) {
    		return null;
		}
    	Map<String, Object> paramMap = new HashMap<>();
    	paramMap.put("orderNos", carpoolOrders);
    	
        JSONObject jsonObject;
		try {
			jsonObject = restTemplate.getForEntity(carpoolDrawbackUrl, JSONObject.class, paramMap).getBody();
		} catch (Exception e) {
			logger.error("退款url接口异常！",e);
			return null;
		}
        
        if (jsonObject == null) {
        	return null;
        }
         
        return JSONObject.toJavaObject(jsonObject, ReturnResult.class);
    }

}
