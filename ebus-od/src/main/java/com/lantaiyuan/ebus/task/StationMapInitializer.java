/**
* <p>Title: TestImplCommandLineRunner.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.task;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.lantaiyuan.ebus.map.GlobalMap;
import com.lantaiyuan.ebus.model.StationRecord;
import com.lantaiyuan.ebus.model.modelenum.CityTopicEnum;

/**
* <p>Title: TestImplCommandLineRunner</p>
* <p>Description: 执行stationMap初始化任务</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月15日 下午3:57:36
*/
@Component
public class StationMapInitializer implements CommandLineRunner {
	@Autowired
    private RestTemplate restTemplate;
    
    @Value("${invoke.url}")
    private String url;
    
    /***********HTTP GET method*************/
    @Override
    public void run(String... args) throws Exception{
        JSONObject jsonObject = restTemplate.getForEntity(url, JSONObject.class).getBody();
        
        if (jsonObject.getBooleanValue("success")) {
        	JSONArray jsonArray = jsonObject.getJSONArray("obj");
			
        	String jsonArrayStr=jsonArray.toJSONString();//将array数组转换成字符串  
        	
        	List<StationRecord>  stationRecords = JSONObject.parseArray(jsonArrayStr, StationRecord.class);//把字符串转换成集合 
        	
        	ConcurrentHashMap<String,StationRecord> map = new ConcurrentHashMap<>();
        	
        	String globalCityCode = CityTopicEnum.QINHUANGDAO_TOPIC.getCityCode();
        	
        	for(StationRecord stationRecord : stationRecords){
        		if(!globalCityCode.equals(stationRecord.getCitycode())){
        			GlobalMap.stationMap.put(globalCityCode, map);
        			globalCityCode = stationRecord.getCitycode();
        			map = new ConcurrentHashMap<>();
        		}
        		
        		map.put(stationRecord.getRouteiddirectionstationno(), stationRecord);
        	}
        	
        	GlobalMap.stationMap.put(globalCityCode, map);
        }
    }

}
