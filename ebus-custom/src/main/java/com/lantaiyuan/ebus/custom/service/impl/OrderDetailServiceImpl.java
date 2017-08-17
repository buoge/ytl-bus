package com.lantaiyuan.ebus.custom.service.impl;

import javax.annotation.Resource;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;
import com.lantaiyuan.ebus.custom.dao.OrderDetailMapper;
import com.lantaiyuan.ebus.custom.model.OrderDetail;
import com.lantaiyuan.ebus.custom.model.OrderDetailQueryModel;
import com.lantaiyuan.ebus.custom.service.OrderDetailServiceI;

@Service("orderDetailService")
public class OrderDetailServiceImpl extends BaseService<OrderDetail, OrderDetailQueryModel> implements OrderDetailServiceI {
	@Resource
	private OrderDetailMapper orderDetailMapper;

	@Override
	public BaseDAO<OrderDetail, OrderDetailQueryModel> getDao() {
		return orderDetailMapper;
	}

	@Override
	public OrderDetail queryOrderDetailByOrderNo(String orderNo) {
		return orderDetailMapper.queryOrderDetailByOrderNo(orderNo);
	}


}
