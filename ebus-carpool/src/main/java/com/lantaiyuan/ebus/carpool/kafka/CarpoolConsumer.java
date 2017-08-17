package com.lantaiyuan.ebus.carpool.kafka;

import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.carpool.enums.ChargingModelEnum;
import com.lantaiyuan.ebus.carpool.enums.PushMsgType;
import com.lantaiyuan.ebus.carpool.model.*;
import com.lantaiyuan.ebus.carpool.model.kafkamodel.BigCarpoolDynamic;
import com.lantaiyuan.ebus.carpool.model.kafkamodel.CarpoolPushMsg;
import com.lantaiyuan.ebus.carpool.model.kafkamodel.CarpoolRouteBasic;
import com.lantaiyuan.ebus.carpool.model.kafkamodel.UserCarpoolDynamic;
import com.lantaiyuan.ebus.carpool.service.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 拼车动态消费者
 *
 * @author yangyang
 * @date 2017/7/12 17:48
 * @email kekecany@163.com
 */
@Component
public class CarpoolConsumer {

    @Autowired
    private CarpoolOrderService carpoolOrderService;
    @Autowired
    private CarpoolMatchService carpoolMatchService;
    @Autowired
    private CarpoolRouteService carpoolRouteService;
    @Autowired
    private CarpoolRouteStationService carpoolRouteStationService;
    @Autowired
    private PushMsgService pushMsgService;

    @Autowired
    private UserOdService userOdService;


    /**
     * 消费单个用户拼车动态
     *
     * @param msg 从kafka消费到的消息
     */
    @KafkaListener(topics = "${kafka.carpool.single-user.topic}")
    public void singleUserListen(ConsumerRecord<Integer, String> msg) {
        UserCarpoolDynamic userCarpoolDynamic = JSONObject.parseObject(msg.value(), UserCarpoolDynamic.class);
        // TODO 更新用户动态至数据库, 观察更新频率是否太高, 会压垮数据库
        if (!StringUtils.isEmpty(userCarpoolDynamic)) {
            carpoolOrderService.updateByOrderNoSelective(UserCarpoolDynamic.parse(userCarpoolDynamic, ChargingModelEnum.UNITE_PRICE));
        }
    }

    /**
     * 消费大拼车订单(含多个用户)拼车动态
     *
     * @param msg 从kafka消费到的消息
     */
    @KafkaListener(topics = "${kafka.carpool.big-order.topic}")
    public void bigOrderListen(ConsumerRecord<Integer, String> msg) {
        BigCarpoolDynamic bigCarpoolDynamic = JSONObject.parseObject(msg.value(), BigCarpoolDynamic.class);
        if (!StringUtils.isEmpty(bigCarpoolDynamic)) {
            // TODO 更新拼车动态至数据库, 无则添加, 有则更新      观察更新频率是否太高, 会压垮数据库
            int count = carpoolMatchService.countMatchId(bigCarpoolDynamic.getMatchId());
            CarpoolMatch carpoolMatch = BigCarpoolDynamic.parse(bigCarpoolDynamic);
            if (count <= 0) {
                carpoolMatchService.insertSelective(carpoolMatch);
            } else {
                carpoolMatchService.updateByMatchIdSelective(carpoolMatch);
            }
        }

    }

    /**
     * 消费推送消息
     *
     * @param msg 从kafka消费到的消息
     */
    @KafkaListener(topics = "${kafka.carpool.pushmsg.topic}")
    public void pushMsgListen(ConsumerRecord<Integer, String> msg) {
        CarpoolPushMsg carpoolPushMsg = JSONObject.parseObject(msg.value(), CarpoolPushMsg.class);
        if (!StringUtils.isEmpty(carpoolPushMsg)) {
            // TODO 观察数据库是否能承受
            PushMsgType pushMsgType = PushMsgType.valueOf(carpoolPushMsg.getMsgType());
            switch (pushMsgType) {
                case MATCH_SUCCESS:
                case MATCH_FAIL:
                    CarpoolMatchDetail carpoolMatchDetail = carpoolMatchService.matchDetail(carpoolPushMsg.getMatchId());
                    if (StringUtils.isEmpty(carpoolMatchDetail.getDepartTime()) && !StringUtils.isEmpty(carpoolPushMsg.getDepartTime())) {
                        carpoolMatchDetail.setDepartTime(new Date(carpoolPushMsg.getDepartTime()));
                    }
                    pushMsgService.jpushBatchCarpoolResult(carpoolMatchDetail, pushMsgType);
                    break;
                case UP_POINT_CHANGE:
                case DOWN_POINT_CHANGE:
                case UP_DOWN_POINTS_BOTH_CHANGED:
                case UP_DOWN_POINTS_BOTH_NOT_CHANGED:
                    JSONObject jsonObject = JSONObject.parseObject(carpoolPushMsg.getPushMsg());
                    String startStation = jsonObject.getString("startStation");
                    String endStation = jsonObject.getString("endStation");
                    pushMsgService.jpushCarpooling(startStation, endStation,
                            Integer.valueOf(carpoolPushMsg.getUserId()),
                            carpoolPushMsg.getOrderNo(), carpoolPushMsg.getCityCode());
                    break;
                case ABOUT_TO_DEPART:
                    break;
                case DEPART:
                    break;
                case DEFAULT:
                    break;
            }
        }
    }

    /**
     * 消费专线基础信息
     *
     * @param msg 从kafka消费到的消息
     */
    @KafkaListener(topics = "${kafka.carpool.customline-base.topic}")
    public void customlineBaseListen(ConsumerRecord<Integer, String> msg) {
        CarpoolRouteBasic carpoolRouteBasic = JSONObject.parseObject(msg.value(), CarpoolRouteBasic.class);
        CarpoolRoute carpoolRoute = CarpoolRouteBasic.parse(carpoolRouteBasic, ChargingModelEnum.UNITE_PRICE);
        if (!StringUtils.isEmpty(carpoolRoute)) {
            // TODO 存储或更新到数据库中 观察更新频率是否太高, 会压垮数据库
            int count = carpoolRouteService.countCarpoolRouteId(carpoolRoute.getCarpoolRouteId());
            if (count <= 0) {
                carpoolRouteService.insertSelective(carpoolRoute);
            } else {
                carpoolRouteService.updateByCarpoolRouteIdSelective(carpoolRoute);
            }
        }
    }

    /**
     * 消费专线线站关系
     *
     * @param msg 从kafka消费到的消息
     */
    @KafkaListener(topics = "${kafka.carpool.customline-relation.topic}")
    public void customlineRelationListen(ConsumerRecord<Integer, String> msg) {
        JSONObject jsonObject = JSONObject.parseObject(msg.value());
        String carpoolRouteId = jsonObject.getString("carpoolRouteId");
        String cityCode = jsonObject.getString("cityCode");
        String stations = jsonObject.getString("stations");

        List<CarpoolRouteStation> carpoolRouteStations = JSONObject.parseArray(stations, CarpoolRouteStation.class);
        if (!CollectionUtils.isEmpty(carpoolRouteStations)) {
            carpoolRouteStations.forEach(carpoolRouteStation -> {
                carpoolRouteStation.setCarpoolRouteId(carpoolRouteId);
                carpoolRouteStation.setCityCode(cityCode);
            });
            // TODO 先删除后批量插入 观察更新频率是否太高, 会压垮数据库
            carpoolRouteStationService.deleteByCarpoolRouteId(carpoolRouteStations.get(0).getCarpoolRouteId());
            System.err.println(carpoolRouteStationService.insertBatch(carpoolRouteStations));
        }
    }

    @KafkaListener(topics = "${kafka.userod.topic}")
    public void userOdListen(ConsumerRecord<Integer, String> msg) {
        UserOd userOd = JSONObject.parseObject(msg.value(), UserOd.class);
        userOd.setId(UUID.randomUUID().toString());
        // TODO 注意观察是否会压垮数据库
        userOdService.insertSelective(userOd);
    }

}