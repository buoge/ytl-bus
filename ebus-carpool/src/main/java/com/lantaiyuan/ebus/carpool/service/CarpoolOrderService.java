package com.lantaiyuan.ebus.carpool.service;

import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrderQueryModel;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.service.BaseServiceI;

import java.util.List;

/**
 * 单个用户拼车订单
 *
 * @author yangyang
 * @date 2017/7/13 10:17
 * @email kekecany@163.com
 */
public interface CarpoolOrderService extends BaseServiceI<CarpoolOrder, CarpoolOrderQueryModel> {

    /**
     * 根据orderNo有选择地更新数据
     *
     * @param carpoolOrder 订单信息
     * @return 1：更新成功，0：更新失败
     */
    int updateByOrderNoSelective(CarpoolOrder carpoolOrder);

    /**
     * 根据matchId查询出该大拼车订单下的所有小拼车订单
     *
     * @param matchId 拼车id
     * @return 返回该拼车id下的所有小拼车订单
     */
    List<CarpoolOrder> selectByMatchId(@Param("matchId") String matchId);

    /**
     * 根据订单号查询出拼车订单信息
     *
     * @param orderNo 订单号
     * @return 返回拼车订单信息
     * @author yangyang
     * @date 2017/7/18 16:56
     */
    CarpoolOrder selectByOrderNo(@Param("orderNo") String orderNo);

}
