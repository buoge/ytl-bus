package com.lantaiyuan.ebus.custom.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.model.BookBusOrder;
import com.lantaiyuan.ebus.custom.model.BookTicketOrder;
import com.lantaiyuan.ebus.custom.model.TicketDetailQueryModel;
import com.lantaiyuan.ebus.custom.model.enummodel.CancelOrderResultEnum;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundOrder;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundOrderQueryModel;
import com.lantaiyuan.ebus.custom.service.BookBusServiceI;
import com.lantaiyuan.ebus.custom.service.BookTicketServiceI;
import com.lantaiyuan.ebus.custom.service.OrderDetailServiceI;
import com.lantaiyuan.ebus.custom.service.OrderServiceI;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 
  * @ClassName: OrderController
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2016年12月20日 下午9:01:37
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BasicController  {
	@Resource
	private OrderServiceI orderService;
	@Resource
	private OrderDetailServiceI orderDetailService;
	@Resource
	private BookBusServiceI bookBusService;
	@Resource
	private BookTicketServiceI bookTicketService;

	@ApiOperation(value = "申请专车（包车）接口")
	@PostMapping(value = "/applyCustomBus" )
	public Json applyCustomBus(BookBusOrder bookBusOrder) {
		return setSimpleSuccess(orderService.applyCustomBus(bookBusOrder));
	}

	@ApiOperation(value = "提交买票信息")
	@PostMapping(value = "/buyTicket")
	public Map<String, String> buyTicket(BookTicketOrder bookTicketOrder) {
		return orderService.buyTicket(bookTicketOrder);
	}

	@ApiOperation(value = "根据用户id查询 用户欲提交当前订单(包括订票和专车申请)前 未支付订单的数量 " )
	@PostMapping(value = "/queryUnPaidOrderNums" )
	public Json queryUnPaidOrderNums(@ApiParam(value = "用户ID") @RequestParam String userid) {
		// 1、根据userid查询订单详情id orderDetailService.selectByUserId(userid)
		// 2、根据订单详情id和支付状态为0的条件，查询未支付状态的订单是否是否存在 select count(*) from order
		// 3、结果大于等于1时，提示不能提交订单
		return setSimpleSuccess(orderService.queryUnPaidOrder(userid));
	}

	@ApiOperation(value = "根据用户的订单号去app后台数据库查询 支付状态  返回json")
	@PostMapping(value = "/queryOrderStatus" )
	public Map<String, String> queryOrderStatus(@ApiParam(value = "订单号") @RequestParam String orderno) {
		return orderService.queryOrderStatus(orderno);
	}

	/**
	 * payTicket(根据支付方式，选择不同的第三方支付，根据支付金额和订单号、及对应的第三方支付接口在后台生成对应的支付签名，
	 * 返回给前台去调用第三方去支付)
	 */
	@ApiOperation(value = "支付车票费用 ,返回支付签名给前端APP 让其调用第三方")
	@PostMapping(value = "/payTicket" )
	public Map<String, Object> payTicket(@ApiParam(value = "订单号") @RequestParam String orderno,
			@ApiParam(value = "支付方式") @RequestParam String paytype) {
		return orderService.payTicket(orderno,paytype);
	}

	@ApiOperation(value = "根据用户Id查询我的车票 " )
	@PostMapping(value = "/queryMyTickets")
	public Json queryMyTickets(@ApiParam(value = "用户ID") @RequestParam String userid,@ApiParam(value = "citycode") @RequestParam String citycode) {
		return setSimpleSuccess(bookTicketService.queryMyTickets(userid,citycode));
	}
	
	/**
	 * 功能描述:查询包车订单
	 * 作者:温海金
	 * 最后更改时间 : 下午3:03:20
	 */
	@GetMapping(value = "/selectBookBusOrder")
	public Object selectBookBusOrder(@RequestParam @NotNull(message="用户id不能为空") int userId, @RequestParam String citycode) {
	    return setSimpleSuccess(orderService.selectBookBusOrder(userId, citycode));
	}
	
	/**
	 * 功能描述:取消订单
	 * 作者:温海金
	 * 最后更改时间 : 下午3:29:59
	 */
	@PostMapping(value = "/cancelOrder")
	public Object cancelOrder(@NotNull(message="订单编号不能为空")@RequestParam String orderNo, @NotNull(message="专车id不能为空")@RequestParam String goodsId) {
	    return orderService.cancelOrder(orderNo, goodsId) == 2  ? 
		   setSimpleSuccess() : 
		   setFailed("未找到相应订单或包车信息，请检查参数是否正确传递！");
	}
	
	@ApiOperation(value = "专车申请费用 ,返回支付签名给前端APP 让其调用第三方")
	@PostMapping(value = "/payBookBus" )
	public Object payBookBus(@ApiParam(value = "订单号") @RequestParam String orderno,
			@ApiParam(value = "支付方式") @RequestParam String paytype) {
		return orderService.payBookBus(orderno, paytype);
	}
	
	@ApiOperation(value = "生成单张车票二维码字符串，距离当前时间最近的那张" )
	@PostMapping(value = "/generateTicketCode")
	public Json generateTicketCode(TicketDetailQueryModel ticketDetailQueryModel) {
		return setSimpleSuccess(bookTicketService.generateTicketCode(ticketDetailQueryModel));
	}
	
	/**
	 * 功能描述:查询车票订单列表
	 * 作者:YvanTan
	 * 最后更改时间 : 下午3:03:20
	 */
	@GetMapping(value = "/ticketOrderList")
	public Object queryTicketOrderList(@RequestParam @NotNull(message="用户id不能为空") int userid, @RequestParam String citycode) {
	    return setSimpleSuccess(orderService.queryTicketOrderList(userid, citycode));
	}
	
	/**
	 * 功能描述:根据订单号查询车票详情（乘车日期、车票状态，当天票价）
	 * 作者:YvanTan
	 * 最后更改时间 : 下午3:03:20
	 */
	@GetMapping(value = "/ticketDetailByOrderNo")
	public Object queryTicketDetailByOrderNo(@RequestParam @NotNull(message="订单号不能为空") String orderNo) {
	    return setSimpleSuccess(orderService.queryTicketDetailByOrderNo(orderNo));
	}
	
	/**
	 * 功能描述：退票
	 * 作者:YvanTan
	 * 最后更改时间 : 下午3:03:20
	 */
	@PostMapping(value = "/refundTicket")
	public Object refundTicket(@RequestParam @NotNull(message="用户id不能为空") int userId,String orderNo, @RequestParam String ticketIdList) {
	   return setSimpleSuccess(orderService.refundTicket(userId,orderNo,ticketIdList));
	}
	
	/**
	 * 功能描述：钱包方式-支付订单
	 * 作者:YvanTan
	 * 最后更改时间 :2017-03-04-11：16
	 */
	@PostMapping(value = "/payOrderByWallet")
	public Json payOrderByWallet(@RequestParam @NotNull(message="用户id不能为空") String userId,@RequestParam @NotNull(message="订单号不能为空") String orderNo) {
	   return setSimpleSuccess(orderService.payOrderByWallet(userId,orderNo));
	}
	
	/**
	 * 功能描述:取消车票订单
	 * 作者:YvanTan
	 * 最后更改时间 : 2017-04-25 20:46
	 */
	@PostMapping(value = "/cancelTicetOrder")
	public Json cancelTicetOrder(@NotNull(message="订单编号不能为空")@RequestParam String orderNo) {
		return orderService.cancelTicetOrder(orderNo) == CancelOrderResultEnum.SUCCESS.getCancelResult() ? 
		   setSimpleSuccess():
		   setFailed("车票订单取消失败");
	}
 
	/**
	 * 功能描述:查询订单列表
	 * 作者:YvanTan
	 * 最后更改时间 : 下午201706-20-16:03:20
	 */
	@GetMapping(value = "/list")
	public Json queryOrderList(@RequestParam @NotNull(message="用户id不能为空") int userId, @RequestParam String cityCode) {
	    return setSimpleSuccess(orderService.queryOrderList(userId, cityCode));
	}
	
	@ApiOperation(value = "拼车订单费用 ,返回支付签名给前端APP 让其调用第三方")
	@PostMapping(value = "/payCarPoolOrder" )
	public Json payCarPoolOrder(@ApiParam(value = "订单号") @RequestParam String orderNo,
			@ApiParam(value = "支付方式") @RequestParam String payType) {
		Map<String, Object> signMap = new HashMap<>();
		signMap.put(SysGlobalConstants.PARAM_PAY_SIGN, orderService.payTicket(orderNo, payType).get(SysGlobalConstants.PARAM_PAY_SIGN));
		return setSimpleSuccess(signMap);
	}
	
	/**
	 * 生成周边游订单
	 * @param CarpoolOrder
	 * @return
	 */
	@PostMapping("/creatTravelOrder")
	public Json creatTravelOrder(TravelAroundOrder travelOrder) {
		return setSimpleSuccess(orderService.creatTravelOrder(travelOrder));
	}
	
	@ApiOperation(value = "统一支付接口 订单费用 ,返回支付签名给前端APP 让其调用第三方")
	@PostMapping(value = "/payOrder" )
	public Json payTravelOrder(@ApiParam(value = "订单号") @RequestParam String orderNo,
			@ApiParam(value = "支付方式") @RequestParam String payType) {
		Map<String, Object> signMap = new HashMap<>();
		signMap.put(SysGlobalConstants.PARAM_PAY_SIGN, orderService.payTicket(orderNo, payType).get(SysGlobalConstants.PARAM_PAY_SIGN));
		return setSimpleSuccess(signMap);
	}
	
	/**
	 * 功能描述:根据订单号查询周边游订单详情
	 * 作者:YvanTan
	 * 最后更改时间 : 2017-07-24下午3:03:20
	 */
	@GetMapping(value = "/travel/detail")
	public Json queryTravelOrderByOrderNo(@RequestParam @NotNull(message="订单号不能为空") String orderNo) {
	    return setSimpleSuccess(orderService.queryTravelOrderByOrderNo(orderNo));
	}
}
