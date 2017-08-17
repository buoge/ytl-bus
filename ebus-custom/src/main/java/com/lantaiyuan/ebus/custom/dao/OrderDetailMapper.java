package com.lantaiyuan.ebus.custom.dao;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import com.lantaiyuan.ebus.custom.model.OrderDetail;
import com.lantaiyuan.ebus.custom.model.OrderDetailQueryModel;
/**
 * 
  * @ClassName: OrderDetailMapper
  * @author Yuan.Tan
  * @date 2016年11月8日 上午11:42:59
  *
 */
public interface OrderDetailMapper extends BaseDAO<OrderDetail, OrderDetailQueryModel> {

	OrderDetail queryOrderDetailByOrderNo(String orderNo);

}