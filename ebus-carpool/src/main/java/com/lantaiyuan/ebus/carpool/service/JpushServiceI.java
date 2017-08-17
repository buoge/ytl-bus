package com.lantaiyuan.ebus.carpool.service;

import com.lantaiyuan.ebus.carpool.model.jpush.JpushData;


/**
 * 描述:消息推送相关业务接口
 * 作者:温海金
 * 最后更改时间:上午11:46:57
 */
public interface JpushServiceI {
    
    void jpushByJpushData(JpushData jpushData);
}