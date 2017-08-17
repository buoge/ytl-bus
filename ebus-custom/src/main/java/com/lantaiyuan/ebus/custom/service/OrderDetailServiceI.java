package com.lantaiyuan.ebus.custom.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.OrderDetail;
import com.lantaiyuan.ebus.custom.model.OrderDetailQueryModel;

/**
 * 
  * @ClassName: OrderDetailServiceI
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:50:21
  *
 */
public interface OrderDetailServiceI extends BaseServiceI<OrderDetail, OrderDetailQueryModel>{
	OrderDetail queryOrderDetailByOrderNo(String orderNo);
}
