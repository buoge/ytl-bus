package com.lantaiyuan.ebus.custom.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.BookBus;
import com.lantaiyuan.ebus.custom.model.BookBusQueryModel;

/**
  * @ClassName: BookBusServiceI
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:49:41
  *
 */
public interface BookBusServiceI extends BaseServiceI<BookBus, BookBusQueryModel>{
	 
	int updateStatusToTwo(String orderNo);

	Object findBookBusByPage(BookBusQueryModel model, int page);

	Object findBookBusDetailById(String goodsId);

	boolean updateQuote(String quotedPrice, String userId, String userName, String goodsId, String orderNo);

	Object findBookBusByPageForOrder(BookBusQueryModel model, int page);

	boolean refuseRefund(String goodsId, String orderNo);

	boolean approveRefund(String goodsId, String orderNo);

	boolean applyRefund(String goodsId, String orderNo, String remark);

	Object findBookBusByPageForOrderVerify(BookBusQueryModel model, int page);
	
	/**
	 * 功能描述:专车开通
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月21日 下午5:07:45
	 */
	int openCustomBus(String id);

}
