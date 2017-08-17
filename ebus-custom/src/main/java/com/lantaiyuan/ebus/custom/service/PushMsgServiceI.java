package com.lantaiyuan.ebus.custom.service;

import com.lantaiyuan.ebus.carpool.model.jpush.PushMsg;
import com.lantaiyuan.ebus.carpool.model.jpush.PushMsgQueryModel;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.service.BaseServiceI;

import java.util.List;

/**
 * 拼车推送service
 *
 * @author yangyang
 * @date 2017/7/18 18:19
 * @email kekecany@163.com
 */
public interface PushMsgServiceI extends BaseServiceI<PushMsg, PushMsgQueryModel> {

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
