package com.lantaiyuan.ebus.service;

import java.util.Map;
import java.util.Set;

import com.lantaiyuan.ebus.model.JpushDemo;

/**
 * 描述:消息推送相关业务接口
 * 作者:温海金
 * 最后更改时间:上午11:46:57
 */
public interface JpushServiceI {
    /**
     * 功能描述:向所有用户发送通知
     * 参数:pushMsg要推送的具体内容
     * 作者:温海金
     * 最后更改时间 : 2017年2月21日 上午11:49:24
     */
    void jpushToAllUsers(String pushMsg,  Map<String, String> extras);
    
    /**
     * 功能描述:根据regId向特定用户发通知
     * 作者:温海金
     * 最后更改时间 : 2017年2月21日 上午11:49:24
     */
    void jpushByRegId(String regId, String pushMsg, Map<String, String> extras);
    
    /**
     * 功能描述:向对象组发送通知
     * 作者:温海金
     * 最后更改时间 : 2017年2月21日 上午11:49:24
     */
    void jpushByRegIds(Set<String> regIds, String pushMsg, Map<String, String> extras);
    
    /**
     * 功能描述:向所有app用户发送消息
     * 作者:温海金
     * 最后更改时间 : 2017年4月21日 下午5:54:13
     */
    void jmessageToAllUsers(String msgContent, Map<String, String> extras);
    
    /**
     * 功能描述:根据regId向特定用户发消息
     * 作者:温海金
     * 最后更改时间 : 2017年5月2日 上午11:28:35
     */
    void jmessageByRegId(String regId, String pushMsg, Map<String, String> extras);
    
    /**
     * 功能描述:根据regId向特定用户发消息
     * 作者:温海金
     * 最后更改时间 : 2017年5月2日 上午11:28:35
     */
    void jmessageByRegIds(Set<String> regIds, String pushMsg, Map<String, String> extras);
   
    /**
     * 功能描述:根据标签按系统类型发送消息
     * 作者:温海金
     * 最后更改时间 : 2017年4月21日 下午5:54:13
     */
    void jmessageByTag(String msgContent, String tag, int lastLoginSysType, Map<String, String> extras);

    /**
     * 功能描述:根据自定义对象进行消息推送
     * 作者:温海金
     * 最后更改时间 : 2017年5月19日 下午5:49:07
     */
	void jpushByJpushDemo(JpushDemo jpushDemo);

    
}