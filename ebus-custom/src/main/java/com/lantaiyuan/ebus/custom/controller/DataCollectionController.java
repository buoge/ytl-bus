/**
 * @Title: DataCollectionController.java
 * @Package com.lantaiyuan.ebus.custom.controller
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月14日 上午11:22:43
 */
package com.lantaiyuan.ebus.custom.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lantaiyuan.ebus.custom.model.acquisition.UserPosTenSInterval;
import com.lantaiyuan.ebus.realtime.service.TraveByCarServiceI;

/**
 * @ClassName: DataCollectionController
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2017年2月14日 上午11:22:43
 */
@RestController
@RequestMapping("/dataCollection")
public class DataCollectionController extends BasicController {
	@Resource
	private TraveByCarServiceI traveByCarService;

	@Resource(name="kafkaTemplate")
	private KafkaTemplate<Integer, String> kafkaTemplate;
	
	/**
	 * 线路详情埋点
	 * 
	 * @auther yangyang
	 * @return
	 */
	@GetMapping(value = "/routeDetail")
	public Json routeDetail() {
		return setSimpleSuccess();
	}

	/**
	 * 发现埋点
	 * 
	 * @auther yangyang
	 * @return
	 */
	@GetMapping(value = "/findAuthority")
	public Json findAuthority() {
		return setSimpleSuccess();
	}

	/**
	 * 换乘查询埋点
	 * 
	 * @auther yangyang
	 * @return
	 */
	@GetMapping(value = "/transfer")
	public Json transfer() {
		return setSimpleSuccess();
	}

	/**
	 * 每隔10s获取一次用户位置
	 * @auther liuhao
	 */
	@GetMapping(value = "/userPos")
	public Json userPos(@RequestParam String datacollection) {
		//向kafka发送位置信息(添加时间)
		UserPosTenSInterval userPosTenSInterval = JSON.parseObject(datacollection, UserPosTenSInterval.class);
		userPosTenSInterval.setCurrenttime(new Date());
		kafkaTemplate.sendDefault(JSON.toJSONString(userPosTenSInterval));
		
		// 根据用户信息进行上下车提醒
		traveByCarService.jpush4GoToCarAndLeavingCar(datacollection);
		return setSimpleSuccess();
	}

	/**
	 * 安装APP 获取用户手机相关信息（设备型号、手机系统、网络类型）、下载渠道
	 * @auther YvanTan
	 */
	@PostMapping(value = "/installAppInfo")
	public Json installAppInfo() {
		return setSimpleSuccess();
	}

	/**
	 * 启动APP 获取用户打开APP时间、启动位置（经纬度）、用户当前版本情况
	 * @auther YvanTan
	 */
	@PostMapping(value = "/startAppInfo")
	public Json startAppInfo() {
		return setSimpleSuccess();
	}

	/**
	 * 功能描述:地图查看数据埋点 作者:温海金 最后更改时间 : 2017年2月23日 下午5:28:00
	 */
	@GetMapping(value = "/nearStations4MapView")
	public Json nearStations4MapView() {
		return setSimpleSuccess();
	}

	/**
	 * 功能描述:步行导航数据埋点 作者:温海金 最后更改时间 : 2017年2月23日 下午5:28:00
	 */
	@GetMapping(value = "/nearStations4WalkingNavigation")
	public Json nearStations4WalkingNavigation() {
		return setSimpleSuccess();
	}

}
