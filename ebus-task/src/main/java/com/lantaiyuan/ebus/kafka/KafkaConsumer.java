package com.lantaiyuan.ebus.kafka;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.constants.KafkaConsts;
import com.lantaiyuan.ebus.model.BaseStation;
import com.lantaiyuan.ebus.model.Favoriate;
import com.lantaiyuan.ebus.model.JpushDemo;
import com.lantaiyuan.ebus.model.NoticeHistory;
import com.lantaiyuan.ebus.model.OnBusInfo;
import com.lantaiyuan.ebus.model.ProduceDestPoint;
import com.lantaiyuan.ebus.model.ProduceOriginPoint;
import com.lantaiyuan.ebus.service.BaseRouteServiceI;
import com.lantaiyuan.ebus.service.BaseStationServiceI;
import com.lantaiyuan.ebus.service.JpushServiceI;
import com.lantaiyuan.ebus.service.MyTrailServiceI;
import com.lantaiyuan.ebus.service.NoticeHistoryServiceI;
import com.lantaiyuan.ebus.service.OnBusInfoServiceI;
import com.lantaiyuan.ebus.service.RelRouteBusServiceI;
import com.lantaiyuan.ebus.service.TaskTimerServiceI;

/**
 * 消费者
 * @author yangyang
 */
@Component
public class KafkaConsumer {
	@Autowired
	private BaseRouteServiceI baseRouteService;
	@Autowired
	private RelRouteBusServiceI relRouteBusService;
	@Autowired
	private Map<String, String> topicCityMap;
	@Resource
	private BaseStationServiceI baseStationService;
	@Resource
	private OnBusInfoServiceI onBusInfoService;
	@Resource
	private TaskTimerServiceI taskTimerService;
	@Resource
	private NoticeHistoryServiceI noticeHistoryService;
	@Resource
	private JpushServiceI jpushServiceImpl;
	@Resource
	private MyTrailServiceI myTrailService;
	
	@KafkaListener(topics="gw2app-baoji") 
	@KafkaListener(topics="gw2app-liuzhou") 
	@KafkaListener(topics="gw2app-handan") 
	//@KafkaListener(topics="gw2app-kaiping")
	public void listen(ConsumerRecord<Integer, String> msg) {
		String record = msg.value();
		JSONObject jsonObj = JSONObject.parseObject(record);
		//代表的是车票类型的包
		if (KafkaConsts.TICKET_PACKAGE.equals(jsonObj.getString(KafkaConsts.PARAM_PACKE_TTYPE))) {
			dealWithTicket(jsonObj);
			return;
		}
//		int vehicleId = jsonObj.getIntValue("vehicleId");
//		int gprsId = jsonObj.getIntValue("gprsId");
//		int direction = jsonObj.getIntValue("direction");
//		
//		// 获得车辆当前所在的routeNo
//		String routeNo = baseRouteService.getRouteNo(String.valueOf(gprsId), direction, cityCode);
//		if (StringUtils.isEmpty(routeNo)) {
//			return;
//		}
//		// 获取车辆线车关系
//		RelRouteBus relRouteBus = relRouteBusService.getRelRouteBus(cityCode, vehicleId);
//		if(Objects.isNull(relRouteBus)) {// 如果不存在这辆车的线车关系，就增加一条
//			relRouteBusService.insertRelRouteBus(cityCode, vehicleId, routeNo);
//		}else if (routeNo.equals(relRouteBus.getRouteno())) {// 如果数据库中的线车关系就是最新的，返回
//			return;
//		}else {
//			// 更新车辆的routeNo
//			relRouteBusService.updateRouteNo(cityCode, vehicleId, routeNo);
//		}
	}
	
	/**
	 *监听大数据往kafka写入的消息，消费端负责推送到APP用户移动端且保存在关系数据库中，提供通知历史结果查询 
	 */
	@KafkaListener(topics="smartMessage")
	public void listenSmartMsg(ConsumerRecord<Integer, String> msg) {
		String record = msg.value();
		JSONObject smartMessage = JSONObject.parseObject(record);
		String messageId = smartMessage.getString("messageId");
		String userId = smartMessage.getString("userId");
		String messageContent = smartMessage.getString("messageContent");
		//1-上车提醒 2-下车提醒 3-评价提醒 4-车辆到站提醒 5-道路拥堵提醒
		String mssageType = smartMessage.getString("mssageType");
		//TODO 根据type给出不同的信息Title
		String mssageTitle = "消息提醒";
		//TODO 默认为蓝泰源图标
		String companyUrl = "http://120.77.82.161:80/group1/M00/00/01/rBL58lh-xMKAZrRpAAGMtrfRbWg166.png";
		//TODO 集成极光推送实时推送到用户
		NoticeHistory noticeMsg = new NoticeHistory(messageId,messageId,userId,messageContent,mssageTitle,companyUrl);
		noticeHistoryService.insertSelective(noticeMsg);
	}
	
	@KafkaListener(topics="TrafficMessage")
	public void dealWithTrafficFromBigData(ConsumerRecord<Integer, String> TrafficMsg) {
		JSONObject TrafficMessage = JSONObject.parseObject(TrafficMsg.value());
		String routeId = TrafficMessage.getString("routeId");
		String cityCode = TrafficMessage.getString("cityCode");
		List<Favoriate> favoriateList = taskTimerService.findFavoriateByRouteAndCity(routeId, cityCode);
		for (Favoriate favoriate : favoriateList) {
			favoriate.getUserid();
		}
	}
	
	
	@KafkaListener(topics = "${kafka.topic.jpushTopic}")
	public void jpushConsumer(ConsumerRecord<Integer, String> jpushObj) {
		JSONObject jpushJsonObj = JSONObject.parseObject(jpushObj.value());
		JpushDemo jpushDemo = JSON.parseObject(jpushJsonObj.toJSONString(), JpushDemo.class);
		//jpush by jpushDemo
		jpushServiceImpl.jpushByJpushDemo(jpushDemo);
		
	}
	
	/**
	 * 消费OD点数据 
	 * @author yangyang
	 * @param msg
	 */
	@KafkaListener(topics = "${kafka.topic.od-topic}")
	public void odConsumer(ConsumerRecord<Integer, String> msg) {
		String record = msg.value();
		JSONObject jsonObject = JSONObject.parseObject(record);
		if (!StringUtils.isEmpty(jsonObject.getString("startStationId"))) { // O点
			ProduceOriginPoint originPoint = JSONObject.parseObject(record, ProduceOriginPoint.class);
			myTrailService.insertOriginPoint(originPoint);
		} else { // D点
			ProduceDestPoint destPoint = JSONObject.parseObject(record, ProduceDestPoint.class);
			myTrailService.updateDestPoint(destPoint);
		}
	}
	
	private void dealWithTicket(JSONObject ticketInfo) {
		//车票唯一性Id标志，并不是指真正意义上的订单号
		String ticketId = ticketInfo.getString(KafkaConsts.PARAM_ORDER_NUMBER);
		//线路方向
		int direction = ticketInfo.getIntValue(KafkaConsts.PARAM_DIRECTION);
		//用户上车站台的站序
		int onBusStationNo = ticketInfo.getIntValue(KafkaConsts.PARAM_ONBUS_STATIONNO);
		String onBusTime=ticketInfo.getString(KafkaConsts.PARAM_ONBUS_TIME);
		//BaseStation onBusStation =baseStationService.queryStationByTicketIdAndStationNo(ticketId, direction, onBusStationNo);
		//OnBusInfo onBusInfo = new OnBusInfo(ticketId, onBusTime, onBusStation.getName());
		//onBusInfoService.insertSelective(onBusInfo);
		int flag = updateStatusToUsed(ticketId);
		Assert.isTrue(flag == 1, "车票id有误");
	}
	
	private int updateStatusToUsed(String ticketId) {
		return taskTimerService.updateStatusToUsed(ticketId);
	}
}