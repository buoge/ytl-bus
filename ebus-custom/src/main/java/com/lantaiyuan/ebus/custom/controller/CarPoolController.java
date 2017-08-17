package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;

import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.model.carpool.CarPoolSetting;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolTicketPrice;
import com.lantaiyuan.ebus.custom.service.CarPoolServiceI;

/**
 * 拼车控制器
 * @author YvanTan
 * @date 2017年6月12日 下午2:17:13 
 *
 */
@RestController
@RequestMapping("/carPool")
public class CarPoolController extends BasicController  {
	@Resource
	private CarPoolServiceI carPoolService;
	
	/**
	 * 用户拼车设置
	 * @param carPoolSetting
	 * @return
	 */
	@PostMapping("/setting/addition")
	public Json setCarPool(CarPoolSetting carPoolSetting) {
		return carPoolService.setCarPool(carPoolSetting) ? setSimpleSuccess():setFailed();
	}

	@GetMapping("/setting/{userId}")
	public Json setCarPool(@PathVariable Integer userId) {
		return setSimpleSuccess(carPoolService.queryByUserId(userId));
	}
	
	/**
	 * 拼车订单提交
	 * @param CarpoolOrder
	 * @return
	 */
	@PostMapping("/order")
	public Json creatOrder(CarpoolOrder carpoolOrder) {
		return setSimpleSuccess(carPoolService.creatOrder(carpoolOrder));
	}
	
	/**
	 * app后端计算用户拼车的单张票价
	 * @param CarpoolTicketPrice
	 * @return
	 */
	@GetMapping("/calculateSingleTicketPrice")
	public Json calculateSingleTicketPrice(@Validated CarpoolTicketPrice carpoolTicketPrice) {
		return setSimpleSuccess(carPoolService.calculateSingleTicketPrice(carpoolTicketPrice));
	}
}
