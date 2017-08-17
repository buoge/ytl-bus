package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.pay.wexin.util.WeiXinPayHelper;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.model.Notice;
import com.lantaiyuan.ebus.custom.model.NoticeQueryModel;
import com.lantaiyuan.ebus.custom.model.SysUser;
import com.lantaiyuan.ebus.custom.model.TrafficInfo;
import com.lantaiyuan.ebus.custom.service.NoticeServiceI;
import com.lantaiyuan.ebus.custom.service.ServiceIpServiceI;
import com.tencent.common.Configure;
import com.tencent.protocol.refund_query_protocol.RefundQueryResData;

/**
 * 描述:天气信息滚动 
 * 作者:温海金 
 * 最后更改时间:下午3:36:16
 */
@RestController
@RequestMapping("/notice")
public class NoticeController extends BasicController {

	@Resource
	private NoticeServiceI noticeService;
	
	@Resource
	private ServiceIpServiceI serviceIpService;
	
	/**
	 * 功能描述:新增紧急通知 
	 * 作者:温海金 
	 * 最后更改时间 : 2017年4月18日 下午4:28:10
	 */
	@PostMapping(value = "/add")
	public Json add(@RequestBody @Valid Notice notice, HttpSession session) {
		SysUser user = (SysUser)session.getAttribute(SysGlobalConstants.USER_SESSION_KEY);
		return setSimpleSuccess(noticeService.insertAndPublishNotice(notice, user));
	}

	/**
	 * 功能描述:修改紧急通知
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:36:35
	 */
	@PostMapping(value = "/update")
	public Json update(@RequestBody @Valid Notice notice, HttpSession session) {
		SysUser user = (SysUser)session.getAttribute(SysGlobalConstants.USER_SESSION_KEY);
		return setSimpleSuccess(noticeService.updateSelective(notice, user));
	}

	/**
	 * 功能描述:删除紧急通知
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:37:32
	 */
	@DeleteMapping(value = "/delete/{id}")
	public Json delete(@PathVariable String id) {
		return setSimpleSuccess(noticeService.deleteByPrimaryKey(id));
	}

	/**
	 * 功能描述:分页查询紧急信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:38:22
	 */
	@GetMapping(value = "/listByPage")
	public Json listByPage(NoticeQueryModel noticeQM) {
		return setSimpleSuccess(noticeService.listByPage(noticeQM));
	}
	
	/**
	 * 功能描述: 条件查询通知信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:38:22
	 */
	@GetMapping(value = "/listByCondition")
	public Json listByCondition(NoticeQueryModel noticeQM) {
		return setSimpleSuccess(noticeService.listByCondition(noticeQM));
	}
	
	/**
	 * 功能描述:获取当前后台系统用户所在城市
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月16日 下午4:52:10
	 */
	@GetMapping(value = "/getCityName")
	public Json getCityNameByCurrentUser(HttpSession session) {
		SysUser currentUser = (SysUser)session.getAttribute(SysGlobalConstants.USER_SESSION_KEY);
		return setSimpleSuccess(noticeService.getCityNameByCurrentUser(currentUser));
	}
	
		/**
		 * 大数据将拥堵情况上报
		 */
		@PostMapping(value ="uploadTraffic")
		public Json uploadTraffic(TrafficInfo trafficInfo) {
			noticeService.uploadTraffic(trafficInfo);
			return setSimpleSuccess();
		}

}
