package com.lantaiyuan.ebus.carpool.producer;

import com.alibaba.fastjson.JSONObject;
import com.lantaiyuan.ebus.carpool.model.kafkamodel.UserCarpoolDynamic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * TODO 简单说明
 *
 * @author yangyang
 * @date 2017/7/19 15:16
 * @email kekecany@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaProducerTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.carpool.single-user.topic}")
    private String singleUserTopic;

    @Value("${kafka.carpool.big-order.topic}")
    private String bigOrderTopic;

    @Value("${kafka.carpool.pushmsg.topic}")
    private String pushMsgTopic;

    @Value("${kafka.carpool.customline-base.topic}")
    private String customLineBaseTopic;

    @Value("${kafka.carpool.customline-relation.topic}")
    private String customLineRelationTopic;

    @Value("${kafka.userod.topic}")
    private String userODTopic;

    @Test
    public void singleUserTopicSend() throws InterruptedException {
        UserCarpoolDynamic userCarpoolDynamic = new UserCarpoolDynamic();
        userCarpoolDynamic.setExpectAboardTime(System.currentTimeMillis());
        userCarpoolDynamic.setMatchId("111111111");
        userCarpoolDynamic.setMatchStatus((byte)1);
        userCarpoolDynamic.setOrderNo("111111111");
        userCarpoolDynamic.setMatchTimes(12);
        userCarpoolDynamic.setRealEndPlaceLat(new BigDecimal("30.11"));
        userCarpoolDynamic.setRealEndPlaceLon(new BigDecimal("120.11"));
        userCarpoolDynamic.setRealEndPlaceName("end");
        userCarpoolDynamic.setRealPrice(new BigDecimal("11"));
        userCarpoolDynamic.setRealStartPlaceLat(new BigDecimal("29.11"));
        userCarpoolDynamic.setRealStartPlaceLon(new BigDecimal("118.11"));
        userCarpoolDynamic.setRealStartPlaceName("start");
        userCarpoolDynamic.setExpectOffBusTime(System.currentTimeMillis());
       /* for (int i = 0; i < 10; i++) {
            userCarpoolDynamic.setMatchTimes(i);
            kafkaTemplate.send(singleUserTopic, JSONObject.toJSONString(userCarpoolDynamic));
            TimeUnit.SECONDS.sleep(1);
        }*/



    }

    public void bigOrderTopicSend() {

    }

    public void pushMsgTopicSend() {

    }

    public void customLineBaseTopicSend() {

    }

    public void customLineRelationTopicSend() {

    }

    public void userODTopicSend() {

    }

}
