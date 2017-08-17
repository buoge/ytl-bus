package com.lantaiyuan.ebus.custom.service.impl;

import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import com.lantaiyuan.ebus.common.util.Position;
import com.lantaiyuan.ebus.common.util.Tools;
import com.lantaiyuan.ebus.custom.dao.carpool.CarPoolSettingMapper;
import com.lantaiyuan.ebus.custom.model.Order;
import com.lantaiyuan.ebus.custom.model.OrderDetail;
import com.lantaiyuan.ebus.custom.model.carpool.CarPoolSetting;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolTicketPrice;
import com.lantaiyuan.ebus.custom.model.enummodel.OrderPayStatusEnum;
import com.lantaiyuan.ebus.custom.service.CarPoolServiceI;
import com.lantaiyuan.ebus.custom.service.CarpoolOrderServiceI;
import com.lantaiyuan.ebus.custom.service.OrderDetailServiceI;
import com.lantaiyuan.ebus.custom.service.OrderServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service("carPoolService")
public class CarPoolServiceImpl implements CarPoolServiceI{
	@Resource
	private OrderServiceI orderService;
	@Resource
	private OrderDetailServiceI orderDetailService;
	@Resource
	private CarpoolOrderServiceI carPoolOrderService;
	@Resource
	private CarPoolSettingMapper carPoolSettingMapper;
	@Override
	public Boolean setCarPool(CarPoolSetting carPoolSetting) {
		CarPoolSetting carPoolSetResult = carPoolSettingMapper.selectByUserId(carPoolSetting.getUserId());
		if (Objects.isNull(carPoolSetResult)) {
			return carPoolSettingMapper.insertSelective(carPoolSetting) == 1 ?true:false;
		} else {
			carPoolSetting.setId(carPoolSetResult.getId());
			return carPoolSettingMapper.updateByPrimaryKeySelective(carPoolSetting) == 1 ?true:false;
		}
	}
	
	@Override
	public CarPoolSetting queryByUserId(Integer userId) {
		CarPoolSetting carPoolSetting = carPoolSettingMapper.selectByUserId(userId);
		if (Objects.isNull(carPoolSetting)) {
			CarPoolSetting returnSetting = new CarPoolSetting();
			returnSetting.setUserId(userId);
			returnSetting.setWalkType("5");
			returnSetting.setEarlyMinute(new BigDecimal(10));
			returnSetting.setDelayMinute(new BigDecimal(20));
			returnSetting.setPriceType("1");
			returnSetting.setCarType("1");
			return returnSetting;
		}
		return carPoolSetting;
	}

	@Override
	public Map<String, String> creatOrder(CarpoolOrder carpoolOrder) {
		// TODO 用户提交拼车数据前推荐
		// TODO 根据用户提供的起始点位置（经纬度）、人数和线路类型计算出单张票价,目前写固定值
		// TODO 将拼车订单数据（包括订单生成时间）写入Kafka供大数据分析
		BigDecimal distance = Position.getDistance(new Position(carpoolOrder.getInitialStartLon().doubleValue(), carpoolOrder.getInitialStartLat().doubleValue())
				, new Position(carpoolOrder.getInitialEndLon().doubleValue(), carpoolOrder.getInitialEndLat().doubleValue()));
		Map<String, String> priceMap = calculateSingleTicketPrice(new CarpoolTicketPrice(carpoolOrder.getUserId(), distance.intValue(), carpoolOrder.getCityCode()));
		BigDecimal singlePrice = new BigDecimal(priceMap.get("singlePrice"));
		BigDecimal orderAmount = singlePrice.multiply(new BigDecimal(carpoolOrder.getSeats())).setScale(2,BigDecimal.ROUND_DOWN);
		// 生成订单号
		String orderNo = Tools.generateOrderNo();
		// 申请订单详情id
		String orderDetailId = Tools.generateOrderDetailId();
		
		Order order = new Order();
		order.setOrderno(orderNo);
		order.setOrderdetailid(orderDetailId);
		order.setOrderstatus((byte) OrderPayStatusEnum.NOTPAY.getPayStaus());
		// 申请人在系统里即为付款人
		order.setPayperson(carpoolOrder.getUserName());
		order.setAmount(orderAmount);
		orderService.insertSelective(order);
		
		
		String goodsId = Tools.generateGoodsId();
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderdetailid(orderDetailId);
		orderDetail.setUserid(carpoolOrder.getUserId());
		orderDetail.setUsername(carpoolOrder.getUserName());
		// 拼车:3-拼车订单
		orderDetail.setType((byte) 3);
		orderDetail.setGoodsid(goodsId);
		orderDetailService.insertSelective(orderDetail);
		
		carpoolOrder.setOrderNo(orderNo);
		carpoolOrder.setInitialPrice(singlePrice);
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("isCreated", "0");
		carpoolOrder.setInitialPrice(singlePrice);
		carpoolOrder.setPaidPrice(orderAmount);
		carpoolOrder.setRealStartPlace(carpoolOrder.getInitialStartPlace());
		carpoolOrder.setRealStartLon(carpoolOrder.getInitialStartLon());
		carpoolOrder.setRealStartLat(carpoolOrder.getInitialStartLat());
		carpoolOrder.setRealEndPlace(carpoolOrder.getInitialEndPlace());
		carpoolOrder.setRealEndLon(carpoolOrder.getInitialEndLon());
		carpoolOrder.setRealEndLat(carpoolOrder.getInitialEndLat());
		if (carPoolOrderService.insertSelective(carpoolOrder) == 1) {
			resultMap.put("isCreated", "1");
			resultMap.put("orderNum", orderNo);
			resultMap.put("orderAmount", orderAmount.toString());
			return resultMap;
		} else {
			return resultMap;	
		}
	}

	/**
	 * app后端计算用户拼车的单张票价
	 * @param CarpoolTicketPrice
	 * @return
	 */
	@Override
	public Map<String, String> calculateSingleTicketPrice(CarpoolTicketPrice carpoolTicketPrice) {
		// TODO 根据citycode读取数据库配置判断城市的订票机制：一票制还是分段收费   项目初期默认都是一票制
		/*
		 * 一票制票价=【车辆公里成本】*【趟次总里程】/【趟次座位数】*(1+【0.80】)
  			【趟次总里程】< 10  则【趟次总里程】= 10
  			【趟次总里程】< 20  则【趟次总里程】= 20
  			【趟次总里程】< 30  则【趟次总里程】= 30
  			【趟次总里程】> 30  则【趟次总里程】= 发起人实际里程
  			项目初期默认 车辆公里成本=4.2元/公里（千米） 趟次座位数=20
		 */
		int distance = carpoolTicketPrice.getDistance();
		if (distance < 10) {
			distance = 10;
		} else if (distance < 20) {
			distance = 20;
		} else if (distance < 30) {
			distance = 30;
		}
		double price = 4.2 * distance * (1+0.8) / 20;
		Map<String, String> priceMap = new  HashMap<>();
		priceMap.put("singlePrice", new BigDecimal(price).setScale(2,RoundingMode.HALF_UP).toString());
		return priceMap;
	}
}