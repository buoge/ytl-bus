package com.lantaiyuan.ebus.custom.dao;

import com.lantaiyuan.ebus.carpool.model.jpush.PushMsg;
import com.lantaiyuan.ebus.carpool.model.jpush.PushMsgQueryModel;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import java.util.List;

public interface PushMsgMapper extends BaseDAO<PushMsg, PushMsgQueryModel> {

    /**
     * 根据订单号查询该订单号下的推送消息
     *
     * @param orderNo 订单号
     * @return 返回该订单号下的推送消息
     * @author yangyang
     * @date 2017/7/18 18:20
     */
    List<PushMsg> selectByOrderNo(@Param("orderNo") String orderNo);
}