package com.lantaiyuan.ebus.carpool.service;

import com.lantaiyuan.ebus.carpool.enums.PushMsgType;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatchDetail;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.carpool.model.jpush.PushMsg;
import com.lantaiyuan.ebus.carpool.model.jpush.PushMsgQueryModel;
import com.lantaiyuan.ebus.carpool.model.jpush.UserSimpleInfo;

/**
 * 描述:处理推送消息及用户相关信息
 * 作者:温海金
 * 最后更改时间:下午3:41:18
 */
public interface PushMsgService extends BaseServiceI<PushMsg, PushMsgQueryModel> {
    /**
     * 功能描述:根据用户ID查找极光注册ID
     * 作者:温海金
     * 最后更改时间 : 2017年7月14日 下午6:40:14
     */
    String getRegIdByUserId(Integer userId);

    /**
     * 功能描述:根据用户ID查找用户相关信息
     * 作者:温海金
     * 最后更改时间 : 2017年7月17日 下午3:40:52
     */
    UserSimpleInfo getUserSimpleInfoByUserId(Integer userId);

    /**
     * 批量推送拼车成功或失败结果
     *
     * @param carpoolMatchDetail 拼车详情
     * @param msgType            消息类型
     * @author yangyang
     * @date 2017/7/18 16:51
     */
    void jpushBatchCarpoolResult(CarpoolMatchDetail carpoolMatchDetail, PushMsgType msgType);

    /**
     * 推送并存储正在拼车的消息
     *
     * @author yangyang
     * @date 2017/7/18 15:58
     */
    void jpushCarpooling(String startStation, String endStation, Integer userId, String orderNo, String cityCode);
}
