package com.lantaiyuan.ebus.carpool;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lantaiyuan.ebus.carpool.configure.Constants;
import com.lantaiyuan.ebus.carpool.enums.JpushNoticeTypeEnum;
import com.lantaiyuan.ebus.carpool.model.jpush.JpushData;
import com.lantaiyuan.ebus.carpool.model.jpush.PushMsg;
import com.lantaiyuan.ebus.carpool.service.JpushServiceI;
import com.lantaiyuan.ebus.carpool.service.PushMsgService;
import com.lantaiyuan.ebus.carpool.service.PushTemplateService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EbusCarpoolApplicationTests {
	
	@Resource
	private JpushServiceI jpushService;
	
	@Resource
	private PushMsgService pushMsgService;
	
	@Resource PushTemplateService pushTemplateService;
	@Test
	public void contextLoads() {
	}

	@Test
	public void jpushCarpoolSuccess() {
		//推送消息
		Map<String, String> varMap = new HashMap<>();
		varMap.put(Constants.START_STATION, "西丽法庭");//设置上车站
		varMap.put(Constants.END_STATION, "豪威大厦");//设置下车站
		varMap.put(Constants.START_TIME, "8:30");//设置发车时间
		JpushData jpushData = new JpushData(Constants.CAR_POOL_SUCCESS_TEMPLATE_ID, 2, varMap);
		jpushService.jpushByJpushData(jpushData);
		//消息存储
		String jpushTitle = pushTemplateService.getJpushTitle(Constants.CAR_POOL_SUCCESS_TEMPLATE_ID);
		String jpushMsg = pushTemplateService.getJpushMsg(Constants.CAR_POOL_SUCCESS_TEMPLATE_ID, varMap);
		//PushMsg pushMsg = new PushMsg(orderNo, jpushTitle, userId, jpushMsg, cityCode);
		//pushMsgService.insertSelective(pushMsg);
	}
	
	@Test
	public void jpushCarpoolFail() {
		//消息发送
		jpushService.jpushByJpushData(new JpushData(Constants.CAR_POOL_FAIL_TEMPLATE_ID, 2, null));
		//消息存储
		String jpushTitle = pushTemplateService.getJpushTitle(Constants.CAR_POOL_FAIL_TEMPLATE_ID);
		String jpushMsg = pushTemplateService.getJpushMsg(Constants.CAR_POOL_FAIL_TEMPLATE_ID, null);
		//PushMsg pushMsg = new PushMsg(orderNo, jpushTitle, userId, jpushMsg, cityCode);
		//pushMsgService.insertSelective(pushMsg);
	}
	
	@Test
	public void jpushCarpooling() {
		Map<String, String> varMap = new HashMap<>();
		varMap.put(Constants.START_STATION, "西丽法庭");//设置起点站
		varMap.put(Constants.END_STATION, "豪威大厦");//设置终点站
		jpushService.jpushByJpushData(new JpushData(Constants.CAR_POOLING_TEMPLATE_ID, 2, varMap));
		//消息存储
		String jpushTitle = pushTemplateService.getJpushTitle(Constants.CAR_POOLING_TEMPLATE_ID);
		String jpushMsg = pushTemplateService.getJpushMsg(Constants.CAR_POOLING_TEMPLATE_ID, varMap);
		//PushMsg pushMsg = new PushMsg(orderNo, jpushTitle, userId, jpushMsg, cityCode);
		//pushMsgService.insertSelective(pushMsg);
	}
}
