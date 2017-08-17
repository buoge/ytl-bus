package com.lantaiyuan.ebus.carpool.model.kafkamodel;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * TODO 简单说明
 *
 * @author yangyang
 * @date 2017/8/2 11:09
 * @email kekecany@163.com
 */
public class CarpoolRouteBasicTest {

    @Test
    public void testBigDecimalToString() {
        BigDecimal b = new BigDecimal("1.100");
        System.out.println(b.toString());
    }

}