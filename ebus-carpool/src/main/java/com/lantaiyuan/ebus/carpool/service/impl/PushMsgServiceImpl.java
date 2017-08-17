package com.lantaiyuan.ebus.carpool.service.impl;

import com.lantaiyuan.ebus.carpool.configure.Constants;
import com.lantaiyuan.ebus.carpool.enums.PushMsgType;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatchDetail;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import com.lantaiyuan.ebus.carpool.model.jpush.JpushData;
import com.lantaiyuan.ebus.carpool.service.JpushServiceI;
import com.lantaiyuan.ebus.carpool.service.PushTemplateService;
import com.xiaoleilu.hutool.date.DateUtil;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.carpool.dao.PushMsgMapper;
import com.lantaiyuan.ebus.carpool.model.jpush.PushMsg;
import com.lantaiyuan.ebus.carpool.model.jpush.PushMsgQueryModel;
import com.lantaiyuan.ebus.carpool.model.jpush.UserSimpleInfo;
import com.lantaiyuan.ebus.carpool.service.PushMsgService;

import java.util.HashMap;
import java.util.Map;

@Service
public class PushMsgServiceImpl extends BaseService<PushMsg, PushMsgQueryModel> implements PushMsgService {

    @Autowired
    private PushMsgMapper pushMsgMapper;
    @Autowired
    private JpushServiceI jpushService;
    @Autowired
    private PushTemplateService pushTemplateService;

    @Override
    public BaseDAO<PushMsg, PushMsgQueryModel> getDao() {
        return pushMsgMapper;
    }

    @Override
    public String getRegIdByUserId(Integer userId) {
        return pushMsgMapper.getRegIdByUserId(userId);
    }

    @Override
    public UserSimpleInfo getUserSimpleInfoByUserId(Integer userId) {
        return pushMsgMapper.getUserSimpleInfoByUserId(userId);
    }

    /**
     * 批量推送拼车成功或失败结果
     *
     * @param carpoolMatchDetail 拼车详情
     * @param msgType            消息类型
     * @author yangyang
     * @date 2017/7/18 16:51
     */
    @Override
    public void jpushBatchCarpoolResult(CarpoolMatchDetail carpoolMatchDetail, PushMsgType msgType) {
        if (msgType == PushMsgType.MATCH_SUCCESS) {
            carpoolMatchDetail.getCarpoolOrderList().forEach(carpoolOrder ->
                    jpushCarpoolSuccess(carpoolOrder, DateUtil.format(carpoolMatchDetail.getDepartTime(),
                    Constants.DATE_FORMAT)));
        } else if (msgType == PushMsgType.MATCH_FAIL) {
            carpoolMatchDetail.getCarpoolOrderList().forEach(this::jpushCarpoolFail);
        }
    }

    /**
     * 推送并存储正在拼车的消息
     *
     * @author yangyang
     * @date 2017/7/18 15:58
     */
    @Override
    public void jpushCarpooling(String startStation, String endStation, Integer userId, String orderNo, String cityCode) {
        Map<String, String> varMap = new HashMap<>();
        varMap.put(Constants.START_STATION, startStation);//设置起点站
        varMap.put(Constants.END_STATION, endStation);//设置终点站
        jpushService.jpushByJpushData(new JpushData(Constants.CAR_POOLING_TEMPLATE_ID, userId, varMap));
        //消息存储
        String jpushTitle = pushTemplateService.getJpushTitle(Constants.CAR_POOLING_TEMPLATE_ID);
        String jpushMsg = pushTemplateService.getJpushMsg(Constants.CAR_POOLING_TEMPLATE_ID, varMap);
        PushMsg pushMsg = new PushMsg(orderNo, jpushTitle, userId, jpushMsg, cityCode);
        pushMsgMapper.insertSelective(pushMsg);
    }

    /**
     * 推送并存储拼车成功的消息
     *
     * @param carpoolOrder 拼车订单
     * @param departTime   发车时间
     * @author yangyang
     * @date 2017/7/18 15:53
     */
    private void jpushCarpoolSuccess(CarpoolOrder carpoolOrder, String departTime) {
        //推送消息
        Map<String, String> varMap = new HashMap<>();
        varMap.put(Constants.START_STATION, carpoolOrder.getRealStartPlace());//设置上车站
        varMap.put(Constants.END_STATION, carpoolOrder.getRealEndPlace());//设置下车站
        varMap.put(Constants.START_TIME, departTime);//设置发车时间
        JpushData jpushData = new JpushData(Constants.CAR_POOL_SUCCESS_TEMPLATE_ID, carpoolOrder.getUserId(), varMap);
        jpushService.jpushByJpushData(jpushData);
        //消息存储
        String jpushTitle = pushTemplateService.getJpushTitle(Constants.CAR_POOL_SUCCESS_TEMPLATE_ID);
        String jpushMsg = pushTemplateService.getJpushMsg(Constants.CAR_POOL_SUCCESS_TEMPLATE_ID, varMap);
        PushMsg pushMsg = new PushMsg(carpoolOrder.getOrderNo(), jpushTitle, carpoolOrder.getUserId(), jpushMsg, carpoolOrder.getCityCode());
        pushMsgMapper.insertSelective(pushMsg);
    }

    /**
     * 推送并存储拼车失败的消息
     *
     * @param carpoolOrder 拼车订单
     * @author yangyang
     * @date 2017/7/18 15:57
     */
    private void jpushCarpoolFail(CarpoolOrder carpoolOrder) {
        //消息发送
        jpushService.jpushByJpushData(new JpushData(Constants.CAR_POOL_FAIL_TEMPLATE_ID, carpoolOrder.getUserId(), null));
        //消息存储
        String jpushTitle = pushTemplateService.getJpushTitle(Constants.CAR_POOL_FAIL_TEMPLATE_ID);
        String jpushMsg = pushTemplateService.getJpushMsg(Constants.CAR_POOL_FAIL_TEMPLATE_ID, null);
        PushMsg pushMsg = new PushMsg(carpoolOrder.getOrderNo(), jpushTitle, carpoolOrder.getUserId(), jpushMsg, carpoolOrder.getCityCode());
        pushMsgMapper.insertSelective(pushMsg);
    }



}
