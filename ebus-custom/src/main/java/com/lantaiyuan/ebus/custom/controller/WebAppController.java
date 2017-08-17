package com.lantaiyuan.ebus.custom.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.carpool.model.CarpoolOrderQueryModel;
import com.lantaiyuan.ebus.carpool.model.CarpoolRouteStation;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.model.BaseImage;
import com.lantaiyuan.ebus.custom.model.BookBusQueryModel;
import com.lantaiyuan.ebus.custom.model.BusNews;
import com.lantaiyuan.ebus.custom.model.BusNewsQueryModel;
import com.lantaiyuan.ebus.custom.model.CustomLineApplicationQueryModel;
import com.lantaiyuan.ebus.custom.model.SysUser;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolMatchResultQueryModel;
import com.lantaiyuan.ebus.custom.model.enummodel.BusTypeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.EvaluationTypeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.LoginResultEnum;
import com.lantaiyuan.ebus.custom.service.BaseImageServiceI;
import com.lantaiyuan.ebus.custom.service.BookBusServiceI;
import com.lantaiyuan.ebus.custom.service.BusNewsServiceI;
import com.lantaiyuan.ebus.custom.service.CarpoolOrderServiceI;
import com.lantaiyuan.ebus.custom.service.CustomLineApplicationServiceI;
import com.lantaiyuan.ebus.custom.service.CustomLineServiceI;
import com.lantaiyuan.ebus.custom.service.EvaluationServiceI;
import com.lantaiyuan.ebus.custom.service.OrderDetailServiceI;
import com.lantaiyuan.ebus.custom.service.ServiceIpServiceI;
import com.lantaiyuan.ebus.custom.service.SysUserServiceI;
import com.lantaiyuan.ebus.realtime.service.JpushServiceI;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * 
 * @Title: WebAppController.java
 * @Package com.lantaiyuan.ebus.custom.controller
 * @Description:
 * @author yangyang
 * @date 2016年12月20日 下午2:10:11
 * @version v1.0
 */
@RestController
@RequestMapping("/webapp")
public class WebAppController extends BasicController {
	@Resource
	private SysUserServiceI sysUserService;
	@Resource
	private CustomLineServiceI customLineService;
	@Resource
	private CustomLineApplicationServiceI customLineApplicationService;
	@Resource
	private BookBusServiceI bookBusService;
	@Resource
	private EvaluationServiceI evaluationService;
	@Resource
	private BaseImageServiceI baseImageService;
	@Resource
	private ServiceIpServiceI serviceIpService;
	@Resource
	private BusNewsServiceI busNewsService;
	@Resource
	private JpushServiceI jpushService;
	@Resource
	private OrderDetailServiceI orderDetailService;
	@Resource
	private CarpoolOrderServiceI carPoolOrderService;
	
	/**
	 * 登录
	 * 
	 * @param userName
	 * @param passWord
	 * @param session
	 * @return
	 */
	@PostMapping(value = "/login")
	public Json login(String userName, String passWord, HttpSession session) {
		LoginResultEnum loginResult = sysUserService.login(userName, passWord,session);
		switch (loginResult) {
		case SUCCESS:
			return setSimpleSuccess();
		default:
			return setFailed(loginResult.desc());
		}
	}

	/**
	 * 退出
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping(value = "/logout")
	public Json logout(HttpSession session) {
		if(!StringUtils.isEmpty(session)) {
			session.invalidate();
		}
		return setSimpleSuccess();
	}

	/**
	 * 分页查询定制公交
	 * 
	 * @param page
	 * @param rows
	 * @param status
	 * @param startStation
	 * @param endStation
	 * @param session
	 * @return
	 */
	@PostMapping(value = "/customlinelist")
	public Json customlinelist(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "20") Integer rows, @RequestParam(defaultValue = "-1") Integer status,
			String startStation, String endStation, HttpSession session) {
		String cityCode = userCityCode(session);
		return setSimpleSuccess(
				customLineService.findCustomLineListByPage(page, rows, status, cityCode, startStation, endStation));
	}

	/**
	 * 分页查询定制公交加入人 && 次数统计
	 * 
	 * @param page
	 * @param rows
	 * @param lineId
	 * @return
	 */
	@PostMapping(value = "/customlinesublist")
	public Json customlinesublist(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "20") Integer rows, String lineId) {
		CustomLineApplicationQueryModel model = new CustomLineApplicationQueryModel();
		model.setLineid(lineId);
		model.getPageModel().setPageShow(rows);
		return setSimpleSuccess(customLineApplicationService.findCustomLineSubListByPage(model, page));
	}

	/**
	 * 地图次数统计
	 * 
	 * @param lineId
	 * @return
	 */
	@PostMapping(value = "/customlinemap")
	public Json customlinesublist(String lineId) {
		return setSimpleSuccess(customLineApplicationService.getMapCount(lineId));
	}

	/**
	 * 分页查询专车管理
	 * 
	 * @param orderNo
	 * @param contactPhone
	 * @param page
	 * @param rows
	 * @param bookBusType
	 * @param status
	 * @param orderStatus
	 * @param session
	 * @return
	 */
	@PostMapping(value = "/bookbuslist")
	public Json bookbuslist(String orderNo, String contactPhone, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int rows, @RequestParam(defaultValue = "-1") Integer bookBusType,
			@RequestParam(defaultValue = "-1") Integer status, @RequestParam(defaultValue = "-1") Integer orderStatus,
			HttpSession session) {
		String cityCode = userCityCode(session);
		BookBusQueryModel model = new BookBusQueryModel();
		model.setOrderNo(orderNo);
		model.getPageModel().setPageShow(rows);
		model.setContactphone(contactPhone);
		model.setBookbustype(bookBusType);
		model.setStatus(status);
		model.setCitycode(cityCode);
		model.setOrderStatus(orderStatus);
		return setSimpleSuccess(bookBusService.findBookBusByPage(model, page));
	}

	/**
	 * 申请退款
	 * 
	 * @param orderNo
	 *            订单号
	 * @param goodsId
	 *            商品id
	 * @param orderDetailId
	 * @param type
	 * @return
	 */
	@PostMapping(value = "/apply_refund")
	public Json apply_refund(String orderNo, String goodsId, String orderDetailId, String remark, Integer type) {
		boolean result = type == BusTypeEnum.BOOKBUS.getType() ? bookBusService.applyRefund(goodsId, orderNo, remark) :
			customLineService.applyRefund(orderNo, orderDetailId, remark);
		return result ? setSimpleSuccess() : setFailed("退款失败！退款规则：专车退款申请需要提前一天(24小时)以上；专线退款需要每一张车票均为有效状态。");
	}

	/**
	 * 申请退款第二版：专线退款需要提前一天以上,买票退款只能退此订单下全部的车票-即只有当全部车票未使用，才可以走后台退票流程，
	 * 否则只能走前端App退票流程
	 */
	@PostMapping(value = "/apply_refund_second")
	public Object apply_refund_second(String orderNo, String goodsId, String orderDetailId, String remark,
			Integer type) {
		boolean result = type == BusTypeEnum.BOOKBUS.getType() ? bookBusService.applyRefund(goodsId, orderNo, remark) :
			customLineService.applyRefund(orderNo, orderDetailId, remark);
		return result ? setSimpleSuccess() : setFailed("退款失败！退款规则：专车退款需要提前一天以上；专线退款需每一张车票均为有效状态。");
	}

	/**
	 * 拒绝退款
	 * 
	 * @param orderNo
	 * @param goodsId
	 * @param orderDetailId
	 * @param type
	 * @return
	 */
	@PostMapping(value = "/refuse_refund")
	public Json refuseRefund(String orderNo, String goodsId, String orderDetailId, Integer type) {
		boolean result =  type == BusTypeEnum.BOOKBUS.getType() ? bookBusService.refuseRefund(goodsId, orderNo)
				: customLineService.refuseRefund(orderNo, orderDetailId);
		return result ? setSimpleSuccess() : setFailed("操作失败");
	}

	/**
	 * 同意退款
	 * 
	 * @param orderNo
	 * @param goodsId
	 * @param orderDetailId
	 * @param type
	 * @return
	 */
	@PostMapping(value = "/approve_refund")
	public Json approveRefund(String orderNo, String goodsId, String orderDetailId, Integer type) {
		boolean result =  type == BusTypeEnum.BOOKBUS.getType() ? bookBusService.approveRefund(goodsId, orderNo)
				: customLineService.approveRefund(orderNo, orderDetailId);
		return result ? setSimpleSuccess() : setFailed("操作失败");
	}

	/**
	 * 订单管理
	 * 
	 * @param orderNo
	 * @param contactPhone
	 * @param page
	 * @param rows
	 * @param bookBusType
	 * @param status
	 * @param type
	 * @param orderStatus
	 * @param session
	 * @return
	 */
	@PostMapping(value = "/orderlist")
	public Json orderlist(String orderNo, String contactPhone, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int rows, @RequestParam(defaultValue = "-1") Integer bookBusType,
			@RequestParam(defaultValue = "-1") Integer status, @RequestParam(defaultValue = "1") Integer type,
			@RequestParam(defaultValue = "-1") Integer orderStatus, HttpSession session) {
		String cityCode = userCityCode(session);
		BookBusQueryModel model = new BookBusQueryModel();
		model.setOrderNo(orderNo);
		model.getPageModel().setPageShow(rows);
		model.setRows(rows);
		model.setContactphone(contactPhone);
		model.setBookbustype(bookBusType);
		model.setStatus(status);
		model.setOrderStatus(orderStatus);
		model.setCitycode(cityCode);
		return type == BusTypeEnum.BOOKBUS.getType()
				? setSimpleSuccess(bookBusService.findBookBusByPageForOrder(model, page))
				: setSimpleSuccess(customLineService.findOrderByPage(model, page));

	}

	@PostMapping(value = "/orderverifylist")
	public Json orderverifylist(String orderNo, String contactPhone, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int rows, @RequestParam(defaultValue = "-1") Integer bookBusType,
			@RequestParam(defaultValue = "-1") Integer status, @RequestParam(defaultValue = "1") Integer type,
			@RequestParam(defaultValue = "-1") Integer orderStatus, HttpSession session) {
		String cityCode = userCityCode(session);
		BookBusQueryModel model = new BookBusQueryModel();
		model.setOrderNo(orderNo);
		model.getPageModel().setPageShow(rows);
		model.setRows(rows);
		model.setContactphone(contactPhone);
		model.setBookbustype(bookBusType);
		model.setStatus(status);
		model.setOrderStatus(orderStatus);
		model.setCitycode(cityCode);
		return type == BusTypeEnum.BOOKBUS.getType()
				? setSimpleSuccess(bookBusService.findBookBusByPageForOrderVerify(model, page))
				: setSimpleSuccess(customLineService.findVerifyOrderByPage(model, page));
	}

	/**
	 * 包车管理详情
	 * 
	 * @param goodsId
	 * @return
	 */
	@PostMapping(value = "/bookbusdetail")
	public Json bookbusdetail(String goodsId) {
		return setSimpleSuccess(bookBusService.findBookBusDetailById(goodsId));
	}

	/**
	 * 报价
	 * 
	 * @param goodsId
	 * @param orderNo
	 * @param quotedPrice
	 * @param session
	 * @return
	 */
	@PostMapping(value = "/quote")
	public Json quote(String goodsId, String orderNo, String quotedPrice, HttpSession session) {
		SysUser user = (SysUser)session.getAttribute(SysGlobalConstants.USER_SESSION_KEY);
		String userId = user.getId();
		String userName = user.getUsername();
		boolean b = bookBusService.updateQuote(quotedPrice, userId, userName, goodsId, orderNo);
		if (b) {
			jpushService.jpushByUserId(orderDetailService.queryOrderDetailByOrderNo(orderNo).getUserid(), "订单号为:"+orderNo+"的专车订单已报价，请支付", null);
		}
		return b ? setSimpleSuccess() : setFailed("报价失败");
	}

	/**
	 * 获取所有城市
	 * 
	 * @auther yangyang
	 */
	@PostMapping(value = "/cities")
	public Json getAllCities(HttpSession session) {
		String cityCode = userCityCode(session);
		return setSimpleSuccess(serviceIpService.getCities(cityCode));
	}

	/**
	 * 分页查询公交新闻
	 * 
	 * @auther yangyang
	 */
	@PostMapping(value = "/busNewsByPage")
	public Json getBusNewsByPage(BusNewsQueryModel model, HttpSession session) {
		String cityCode = userCityCode(session);
		return setSimpleSuccess(busNewsService.findBusNewsByPage(model, model.getPage(), cityCode));
	}


	/**
	 * 添加新闻
	 * 
	 * @auther yangyang
	 */
	@PostMapping(value = "/insertNews")
	public Json insertNews(BusNews news) {
		return busNewsService.insertFromWebapp(news) ? setSimpleSuccess() : setFailed("添加失败");
	}

	/**
	 * 修改新闻
	 * 
	 * @auther yangyang
	 */
	@PostMapping(value = "/updateNews")
	public Json updateNews(BusNews news) {
		return busNewsService.updateNews(news) ? setSimpleSuccess() : setFailed("修改失败");
	}

	/**
	 * 删除新闻
	 * 
	 * @auther yangyang
	 */
	@DeleteMapping(value = "/deleteNews/{id}")
	public Json deleteNews(@PathVariable int id) {
		return busNewsService.deleteBusNews(id) ? setSimpleSuccess() : setFailed("删除失败");
	}

	/**
	 * 获取新闻内容
	 * 
	 * @auther yangyang
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/newsContent")
	public Json newsContent(int id) {
		String content = busNewsService.getNewsContent(id);
		return setSimpleSuccess(StringUtils.isEmpty(content) ? "" : content);
	}

	/**
	 * 查询车辆评价列表 后期根据城市区分
	 */
	@PostMapping(value = "/queryBusEvaluationList")
	public Json queryBusEvaluationList(String routeName, String evaluatObjName, String userName, String startDate,
			String endDate, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "20") Integer rows, HttpSession session) {
		String cityCode = userCityCode(session);
		return setSimpleSuccess(evaluationService.selectByCityCode(cityCode, routeName, evaluatObjName, userName,
				startDate, endDate, page, rows, EvaluationTypeEnum.BUS_EVALUATION.getType()));  

	}

	/**
	 * 查询站台评价列表 后期根据城市区分
	 */
	@PostMapping(value = "/queryStationEvaluationList")
	public Json queryStationEvaluationList(String routeName, String evaluatObjName, String userName, String startDate,
			String endDate, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "20") Integer rows, HttpSession session) {
		String cityCode = userCityCode(session);
		return setSimpleSuccess(evaluationService.selectByCityCode(cityCode, routeName, evaluatObjName, userName,
				startDate, endDate, page, rows, EvaluationTypeEnum.STATION_EVALUATION.getType())); 

	}

	/**
	 * 查询评价饼状数据 后期根据城市区分
	 */
	@PostMapping(value = "/queryEvaluationPie")
	public Json queryEvaluationPie(String cityCode, HttpSession session) {
		cityCode = userCityCode(session);
		return setSimpleSuccess(evaluationService.queryEvaluationPie(cityCode));
	}

	/**
	 * 后台管理系统：新增广告屏闪记录
	 */
	@ApiOperation(value = "后台管理系统：新增广告屏闪记录")
	@PostMapping(value = "/saveImage")
	public Json saveImage(BaseImage baseImage) {
		return setSimpleSuccess(baseImageService.insertSelective(baseImage));
	}

	/**
	 * 后台管理系统：修改广告闪屏记录状态》使其重新生效(从当天开始的七天内)
	 */
	@ApiOperation(value = "后台管理系统：修改广告闪屏记录状态》使其重新生效(从当天开始的七天内)")
	@PostMapping(value = "/modifyImageToValid")
	public Object modifyImageToValid(String id) {
		return setSimpleSuccess(baseImageService.modifyImageToValid(id));
	}

	/**
	 * 后台管理系统：修改广告闪屏记录状态》使其失效
	 */
	@ApiOperation(value = "后台管理系统：修改广告闪屏记录状态》使其失效")
	@PostMapping(value = "/modifyImageToUnValid")
	public Json modifyImageToUnValid(String id) {
		return setSimpleSuccess(baseImageService.modifyImageToUnValid(id));
	}

	/**
	 * 后台管理系统：修改广告屏闪记录
	 */
	@ApiOperation(value = "后台管理系统：修改广告屏闪记录")
	@PostMapping(value = "/updateImage")
	public Json updateImage(BaseImage baseImage) {
		return setSimpleSuccess(baseImageService.updateByPrimaryKeySelective(baseImage));
	}

	/**
	 * 后台管理系统：查询广告屏闪列表记录
	 */
	@ApiOperation(value = "后台管理系统：查询广告屏闪列表记录")
	@PostMapping(value = "/queryImageList")
	public Json queryImageList(String type, String isValid, @RequestParam(defaultValue = "-1") String citycode,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer rows,
			HttpSession session) {
		// -1表示首次进入闪屏列表或者点击查询时，没有下来选择城市
		if ("-1".equals(citycode)) {
			citycode = userCityCode(session);
		}
		return setSimpleSuccess(baseImageService.queryImageList(type, isValid, citycode, page, rows));
	}
	
	
	/**
	 * 分页查询正在撮合表（carpool_match）的记录
	 * @auther YvanTan
	 */
	@GetMapping(value = "/carPoolMatch/list")
	public Json getCarPoolOrderList(CarpoolMatchResultQueryModel model, HttpSession session) {
		String cityCode = userCityCode(session);
		return setSimpleSuccess(carPoolOrderService.findMatchResultByPage(model, model.getPage(), cityCode));
	}
	
	/**
	 * 分页查询单个撮合记录下的拼车人员的情况
	 * @auther YvanTan
	 */
	@GetMapping(value = "/carPoolMatch/person/list")
	public Json getMatchPersonList(CarpoolOrderQueryModel model, HttpSession session) {
		String cityCode = userCityCode(session);
		return setSimpleSuccess(carPoolOrderService.findMatchPersonByPage(model, model.getPage(), cityCode));
	}
	
	/**
	 * 根据撮合ID查询撮合记录生成的线路的情况（基本站点、线路辅助站点）
	 * @auther YvanTan
	 */
	@GetMapping(value = "/carPoolMatch/routeInfo")
	public Json getMatchRouteInfo(CarpoolRouteStation model) {
		return setSimpleSuccess(carPoolOrderService.getMatchRouteInfo(model));
	}
	
	/**
	 * 获取用户城市编码
	 * @auther yangyang
	 * @param session
	 * @return
	 */
	private String userCityCode(HttpSession session) {
		SysUser user = (SysUser)session.getAttribute(SysGlobalConstants.USER_SESSION_KEY);
		return user.getCitycode();
	}
}