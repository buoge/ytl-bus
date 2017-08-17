package com.lantaiyuan.ebus.custom.service.impl;

import com.lantaiyuan.ebus.carpool.model.jpush.PushMsg;
import com.lantaiyuan.ebus.carpool.model.jpush.PushMsgQueryModel;
import com.lantaiyuan.ebus.carpool.model.kafkamodel.CarpoolPushMsg;
import com.lantaiyuan.ebus.custom.dao.PushMsgMapper;
import com.lantaiyuan.ebus.custom.service.PushMsgServiceI;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 拼车推送service impl
 *
 * @author yangyang
 * @date 2017/7/18 18:21
 * @email kekecany@163.com
 */
@Service("pushMsgService")
public class PushMsgServiceImpl extends BaseService<PushMsg, PushMsgQueryModel> implements PushMsgServiceI {

    @Autowired
    private PushMsgMapper carpoolPushMsgMapper;

    @Override
    public BaseDAO<PushMsg, PushMsgQueryModel> getDao() {
        return carpoolPushMsgMapper;
    }

    /**
     * 根据订单号查询该订单号下的推送消息
     *
     * @param orderNo 订单号
     * @return 返回该订单号下的推送消息
     * @author yangyang
     * @date 2017/7/18 18:20
     */
    @Override
    public List<PushMsg> selectByOrderNo(String orderNo) {
        return carpoolPushMsgMapper.selectByOrderNo(orderNo);
    }
}
