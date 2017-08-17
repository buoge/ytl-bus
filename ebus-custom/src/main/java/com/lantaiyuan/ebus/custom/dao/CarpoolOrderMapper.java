package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrderQueryModel;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.carpool.CarpoolDetail;
import com.lantaiyuan.ebus.custom.model.carpool.CarpoolOrderResult;

/**
 * 用户拼车业务信息
 * @author yangyang
 * @date 2017年6月13日 下午3:11:41 
 */
public interface CarpoolOrderMapper extends BaseDAO<CarpoolOrder, CarpoolOrderQueryModel>{
	/**
	 * 根据订单号查找用户提交的拼车信息和最新拼车动态
	 * @author yangyang
	 * @param orderNo
	 * @return
	 */
	CarpoolDetail selectOrderAndMatchByOrderNo(String orderNo);

	List<CarpoolOrder> findMatchPersonByPage(CarpoolOrderQueryModel model);
	
	List<CarpoolOrderResult> queryCarPoolOrderList(@Param("userId")int userId, @Param("cityCode")String cityCode);

	int updateStatusToPaid(String orderNo);
}