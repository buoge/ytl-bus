package com.lantaiyuan.ebus.custom.service;

import java.util.Map;

import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import com.lantaiyuan.ebus.custom.model.carpool.CarPoolSetting;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolTicketPrice;

public interface CarPoolServiceI {

	Boolean setCarPool(CarPoolSetting carPoolSetting);

	CarPoolSetting queryByUserId(Integer userId);

	Map<String, String> creatOrder(CarpoolOrder carpoolOrder);

	/**
	 * app后端计算用户拼车的单张票价
	 * @param CarpoolTicketPrice
	 * @return
	 */
	Map<String, String> calculateSingleTicketPrice(CarpoolTicketPrice carpoolTicketPrice);
}