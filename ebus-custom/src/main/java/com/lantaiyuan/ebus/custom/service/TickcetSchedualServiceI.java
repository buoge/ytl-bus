package com.lantaiyuan.ebus.custom.service;

import java.util.List;
import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.TickcetSchedual;
import com.lantaiyuan.ebus.custom.model.TickcetSchedualInfo;
import com.lantaiyuan.ebus.custom.model.TickcetSchedualQueryModel;

/**
 * 
 * @ClassName: TickcetSchedualServiceI
 * @author Yuan.Tan
 * @date 2016年11月8日 上午11:51:01
 *
 */
public interface TickcetSchedualServiceI extends BaseServiceI<TickcetSchedual, TickcetSchedualQueryModel> {

	List<TickcetSchedualInfo> queryTicketByRouteId(String userid, String routeid, String citycode);

	/**
	 * updateRemainTicketNum(用户买票支付成功后，根据订单号码出线路id和服务日期， 然後对当天票数做减1操作)
	 */
	int updateRemainTicketNum(String orderNo);
	
	/**
	 * updateRemainTicketNum(用户超時未支付，根据失效订单号码出线路id和服务日期， 然後对当天票数做加1操作)
	 */
	int addRemainTicketNum(String orderNo);
	List<TickcetSchedual> getTicketNumBeforeMakeOrder(String routeId,String cityCode, String[] serverDate);
}
