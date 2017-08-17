package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.custom.model.NoticeHistory;
import com.lantaiyuan.ebus.custom.model.NoticeHistoryQueryModel;
import com.lantaiyuan.ebus.custom.model.enummodel.JpushTypeEnum;
import com.lantaiyuan.ebus.custom.service.BusNewsServiceI;
import com.lantaiyuan.ebus.custom.service.NoticeHistoryServiceI;

/**
 * 描述:通知记录控制类
 * 作者:温海金 
 * 最后更改时间:下午3:36:16showNewsAngle
 */
@RestController
@RequestMapping("/noticehistory")
public class NoticeHistoryController extends BasicController {

	@Resource
	private NoticeHistoryServiceI noticeHistoryService;

	@Resource
	private BusNewsServiceI	busNewsService;
	/**
	 * 功能描述:通知记录 
	 * 作者:温海金 
	 * 最后更改时间 : 2017年4月18日 下午4:28:10
	 */
	@PostMapping(value = "/add")
	public Json add(@Validated NoticeHistory noticeHistory) {
		return setSimpleSuccess(noticeHistoryService.insertSelective(noticeHistory));
	}

	/**
	 * 功能描述:删除紧急通知记录
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:37:32
	 */
	@DeleteMapping(value = "/delete/{id}")
	public Json delete(@PathVariable String id) {
		return setSimpleSuccess(noticeHistoryService.deleteByPrimaryKey(id));
	}

	/**
	 * 功能描述:分页查询紧急信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:38:22
	 */
	@GetMapping(value = "/listByPage")
	public Json listByPage(NoticeHistoryQueryModel noticeHistoryQM) {
		return setSimpleSuccess(noticeHistoryService.listByPage(noticeHistoryQM));
	}
	
	/**
	 * 功能描述:根据用户ID得到紧急通知列表
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月27日 上午9:29:45
	 */
	@GetMapping(value = "/getNoticeHistorys/{userId}")
	public Json getNoticeHistorys(@PathVariable String userId) {
		return setSimpleSuccess(noticeHistoryService.getNoticeHistorysByUserId(userId));
	}
	
	/**
	 * 功能描述:短消息是否显示角标
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月18日 上午11:36:17
	 */
	@GetMapping(value = "/showhowAngle")
	public Json showhowAngle(@RequestParam(required = true) String userId, @RequestParam(required = false) String lastRequestTime) {
		return setSimpleSuccess(noticeHistoryService.showAngleByUserId(userId, lastRequestTime));
	}
	
	/**
	 * 功能描述:新闻咨询是否显示角标
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月18日 上午11:36:17
	 */
	@GetMapping(value = "/showNewsAngle")
	public Json showNewsAngle(@RequestParam(required = true) String userId, @RequestParam(required = false) String lastRequestTime) {
		return setSimpleSuccess(busNewsService.showAngle(userId, lastRequestTime, JpushTypeEnum.NEWS));
	}
	
	/**
	 * 功能描述:失物招领是否显示角标
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月18日 上午11:36:17
	 */
	@GetMapping(value = "/showLostAndFoundAngle")
	public Json showLostAndFoundAngle(@RequestParam(required = true) String userId, @RequestParam(required = false) String lastRequestTime) {
		return setSimpleSuccess(busNewsService.showAngle(userId, lastRequestTime, JpushTypeEnum.LOST_AND_FOUND));
	}
	
	
}
