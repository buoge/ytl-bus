package com.lantaiyuan.ebus.custom.service.impl;

import java.math.BigDecimal;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.lanqiao.ssm.common.rsa.BalanceSignUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.lantaiyuan.ebus.common.constants.PayConstants;
import com.lantaiyuan.ebus.common.util.Tools;
import com.lantaiyuan.ebus.custom.dao.BookBusMapper;
import com.lantaiyuan.ebus.custom.dao.CustomLineMapper;
import com.lantaiyuan.ebus.custom.dao.OrderDetailMapper;
import com.lantaiyuan.ebus.custom.dao.WalletMapper;
import com.lantaiyuan.ebus.custom.dao.WalletRecordMapper;
import com.lantaiyuan.ebus.custom.dao.WalletSignMapper;
import com.lantaiyuan.ebus.custom.model.BookBus;
import com.lantaiyuan.ebus.custom.model.BookBusQueryModel;
import com.lantaiyuan.ebus.custom.model.Order;
import com.lantaiyuan.ebus.custom.model.OrderDetail;
import com.lantaiyuan.ebus.custom.model.Wallet;
import com.lantaiyuan.ebus.custom.model.WalletRecord;
import com.lantaiyuan.ebus.custom.model.WalletSign;
import com.lantaiyuan.ebus.custom.model.enummodel.OrderPayTypeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.WalletLogPayTypeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.WalletOptTypeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.WalletRecordStatusEnum;
import com.lantaiyuan.ebus.custom.service.BookBusServiceI;
import com.lantaiyuan.ebus.custom.service.OrderServiceI;
import com.lantaiyuan.ebus.realtime.service.JpushServiceI;

@Service("bookBusService")
public class BookBusServiceImpl extends BaseService<BookBus, BookBusQueryModel> implements BookBusServiceI {
	@Resource
	private BookBusMapper bookBusMapper;
	@Resource
	private JpushServiceI jpushService;
	@Resource
	private CustomLineMapper customLineMapper;	
	@Resource
	private WalletMapper walletMapper;
	@Resource
	private WalletRecordMapper walletRecordMapper;
	@Resource
	private WalletSignMapper walletSignMapper;
	@Resource
	private WalletServiceImpl walletService;
	@Resource
	private OrderServiceI orderService;
	@Resource
	private OrderDetailMapper orderDetailMapper;
	@Override
	public BaseDAO<BookBus, BookBusQueryModel> getDao() {
		return bookBusMapper;
	}

	/**
	 * @param orderNo
	 * @return
	 * @see com.lantaiyuan.ebus.custom.service.BookBusServiceI#updateStatusToTwo(java.lang.String)
	 */
	@Override
	public int updateStatusToTwo(String orderNo) {
		return bookBusMapper.updateStatusToTwo(orderNo);
	}

	/**
	 * 分页显示包车信息
	 * 
	 * @author yangyang
	 */
	@Override
	public Page<BookBus> findBookBusByPage(BookBusQueryModel model, int page) {
		model.getPageModel().setNowPage(page);
		List<BookBus> list = bookBusMapper.findBookBusByPage(model);
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}

	/**
	 * @author yangyang
	 */
	@Override
	public Page<BookBus> findBookBusByPageForOrderVerify(BookBusQueryModel model, int page) {
		model.getPageModel().setNowPage(page);
		List<BookBus> list = bookBusMapper.findBookBusByPageForOrderVerify(model);
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}

	/**
	 * @author yangyang
	 */
	@Override
	public Page<BookBus> findBookBusByPageForOrder(BookBusQueryModel model, int page) {
		model.getPageModel().setNowPage(page);
		List<BookBus> list = bookBusMapper.findBookBusByPageForOrder(model);
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}

	/**
	 * @author yangyang
	 */
	@Override
	public BookBus findBookBusDetailById(String goodsId) {
		return bookBusMapper.findBookBusDetailById(goodsId);

	}
	
	/**
	 * @author yangyang
	 */
	@Override
	public boolean updateQuote(String quotedPrice, String userId, String userName, String goodsId, String orderNo) {
		int updateQuote = bookBusMapper.updateQuote(quotedPrice, userId, userName, goodsId);
		int updateOrder = bookBusMapper.updateOrder(quotedPrice, orderNo);
		if (updateQuote >= 1 && updateOrder >= 1) {
			//报价成功后，根据包车订单号和金额做加密处理
			//TODO：将订单号码和加密字符存表
			try {
				String OrderSign = BalanceSignUtil.rsaSign(orderNo+quotedPrice);
			} catch (SignatureException e) {
				return false;
			}	
		}
		return updateQuote >= 1 && updateOrder >= 1;
	}

	/**
	 * 申请退款
	 * @author yangyang
	 */
	@Override
	public boolean applyRefund(String goodsId, String orderNo, String remark) {
		//专线退款需要提前一天以上
		int days = bookBusMapper.queryRemainDays(goodsId);
		if (days < 1) {
			return false;
		}
		int updateOrderApplyRefund = bookBusMapper.updateOrderApplyRefund(orderNo, remark);
		int updateBookBusApplyRefund = bookBusMapper.updateBookBusApplyRefund(goodsId);
		return updateOrderApplyRefund >= 1 && updateBookBusApplyRefund >= 1;
	}

	/**
	 * 拒绝退款
	 * @author yangyang
	 */
	@Override
	public boolean refuseRefund(String goodsId, String orderNo) {
		int updateBookBusRefuseRefund = bookBusMapper.updateBookBusRefuseRefund(goodsId);
		int updateOrderRefuseRefund = bookBusMapper.updateOrderRefuseRefund(orderNo);
		return updateBookBusRefuseRefund >= 1 && updateOrderRefuseRefund >= 1;
	}

	/**
	 * 同意退款
	 * @author yangyang
	 */
	@Override
	public boolean approveRefund(String goodsId, String orderNo) {
		String userId = customLineMapper.queryUserIdByOrderNo(orderNo);
		BigDecimal amount = orderService.selectByOrderNo(orderNo).getAmount();
		Map<String, Object> refundMap = refundBookBusOrder(Integer.valueOf(userId), orderNo, amount);
		//退款状态：1-成功
    	if ("1".equals(refundMap.get(PayConstants.PARAM_STATUS))) {
    		int updateBookBusApproveRefund = bookBusMapper.updateBookBusApproveRefund(goodsId);
    		int updateOrderApproveRefund = bookBusMapper.updateOrderApproveRefund(orderNo);
    		return updateBookBusApproveRefund >= 1 && updateOrderApproveRefund >= 1;
		}else{
			return false;
		}
	}
	/**
	 * 功能描述:专车开通
	 * 作者:温海金
	 * 参数:id是base_order_detail里面的goodsId,消息推送时要查的也是base_order_detail里面的userId
	 * 最后更改时间 : 2017年2月21日 下午5:07:45
	 */
	@Override
	public int openCustomBus(String id) {
	    //1.TODO 对接调度系统实现专车开通 
	    //2.对专车申请人进行消息推送
	    Integer userId = bookBusMapper.getUserIdByGoodsId(id);
	    jpushService.jpushByUserId(userId, "您申请的专车信息已通过审核，请您持续关注我们的信息！",null);
	    return 0;
	}
	
	/**
	  * refundBookBusOrder(包车订单退款到余额)
	  * @Title: refundTicket
	  * @param @param userid
	  * @param @param orderNo
	  * @param @param ticketIdList
	  * @param @return    设定文件
	  * @return Map<String,Object>    返回类型
	 */
	public Map<String, Object>  refundBookBusOrder(int userid,String orderNo, BigDecimal amount) {
		Map<String, Object> refundMap = new HashMap<>();
		//验证用户id和订单号
		OrderDetail orderDetail = orderDetailMapper.queryOrderDetailByOrderNo(orderNo);
		if (!Objects.equals(orderDetail.getUserid().intValue(), userid)) {
			refundMap.put(PayConstants.PARAM_STATUS, "2");
			refundMap.put(PayConstants.PARAM_REASON,  "用户没有此订单");
			return refundMap;	
		}
		//支付宝原路退款
		Order order = orderService.selectByOrderNo(orderNo);
		if (Objects.equals(order.getPaytype().toString(),OrderPayTypeEnum.ALIPAY.getPayType())) {
			try {
				Map<String, Object> aliPayRefundRes = orderService.dealAliPayRefund(orderNo,order.getAmount());
				if ("1".equals(aliPayRefundRes.get(PayConstants.PARAM_STATUS))) {
					WalletRecord walletRecord = new WalletRecord(orderNo, String.valueOf(userid),
							order.getAmount(), WalletOptTypeEnum.REFUND.getOptType(), WalletLogPayTypeEnum.ALIPAY.getpayType());
					walletRecord.setPayStatus(WalletRecordStatusEnum.PAID.getStatus());
					walletRecordMapper.insertSelective(walletRecord);
				}
				return aliPayRefundRes;
			} catch (AlipayApiException e) {
				logger.error("支付宝退款" + e.getMessage(), e);
				Assert.isTrue(false,  e.getMessage());
			}
		}
		
		//微信原路退款
		if (Objects.equals(order.getPaytype().toString(),OrderPayTypeEnum.WEIXIN.getPayType())) {
			BigDecimal hundred = new BigDecimal(100);
			Map<String, Object> weiXinRefundRes = orderService.dealWeiXinRefund(orderNo,order.getAmount().multiply(hundred).intValue(),order.getAmount().multiply(hundred).intValue());
			//退款申请成功(默认退款成功)：1-成功
			if ("1".equals(weiXinRefundRes.get(PayConstants.PARAM_STATUS))) {
				WalletRecord walletRecord = new WalletRecord(orderNo, String.valueOf(userid),
						order.getAmount(), WalletOptTypeEnum.REFUND.getOptType(), WalletLogPayTypeEnum.WEIXIN.getpayType());
				walletRecord.setPayStatus(WalletRecordStatusEnum.PAID.getStatus());
				walletRecordMapper.insertSelective(walletRecord);
			}
			return weiXinRefundRes ;  
		}
		//1 金额退款
		//2更改用户金额
		walletService.queryMyBalance(String.valueOf(userid));//防止数据库无记录，先查询做初始化
		Wallet myWallet = walletMapper.selectByPrimaryKey(String.valueOf(userid));
		WalletSign myWalletSign = walletSignMapper.selectByPrimaryKey(String.valueOf(userid));
		String rsaSign ="";
		try {
			rsaSign = BalanceSignUtil.rsaSign(JSON.toJSONString(myWallet));
			if (rsaSign.equals(myWalletSign.getSign())) {//签名验证成功
				//3更改需要退票记录的状态
				//4新增流水记录
				WalletRecord walletRecord = new WalletRecord(Tools.generateOrderNo(),String.valueOf(userid),amount,
						WalletOptTypeEnum.REFUND.getOptType(), WalletLogPayTypeEnum.WALLET_PAY.getpayType());
				walletRecord.setPayStatus(WalletRecordStatusEnum.PAID.getStatus());
				walletRecordMapper.insertSelective(walletRecord);
				//5退款到账户
				myWallet = new Wallet(String.valueOf(userid), amount);
				walletService.addBalanceByUserId(myWallet);
				//6更新签名
				walletService.updateWalletSign(String.valueOf(userid));
				orderService.updateByPrimaryKeySelective(new Order(orderNo,new Integer(5).byteValue()));//5退款状态
				refundMap.put(PayConstants.PARAM_STATUS,  "1");
				refundMap.put(PayConstants.PARAM_REASON,  "退款成功");
			}else {
				refundMap.put(PayConstants.PARAM_STATUS,  "0");
				refundMap.put(PayConstants.PARAM_REASON,  "账户异常");
			}
		} catch (SignatureException e) {
			logger.error("退款失败"+e.getMessage(),e);
		}
		return refundMap;
	}
 
	  
}
