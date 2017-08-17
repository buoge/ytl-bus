package com.lantaiyuan.ebus.carpool.timer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * TODO 简单说明
 *
 * @author yangyang
 * @date 2017/7/19 11:24
 * @email kekecany@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTimerScannerTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Test
    public void carpoolOrderSentToKafkaTimer() throws Exception {

        kafkaTemplate.send("test", "test test");
        System.out.println(kafkaTemplate.getDefaultTopic());
    }

}