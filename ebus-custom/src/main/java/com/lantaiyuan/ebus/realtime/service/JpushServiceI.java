package com.lantaiyuan.ebus.realtime.service;

import java.util.List;
import java.util.Map;

import com.lantaiyuan.ebus.realtime.model.AppUser;

/**
 * 描述:消息推送相关业务接口
 * 作者:温海金
 * 最后更改时间:上午11:46:57
 */
public interface JpushServiceI {
    /**
     * 功能描述:为所有用户发送消息推送
     * 参数:pushMsg要推送的具体内容
     * 作者:温海金
     * 最后更改时间 : 2017年2月21日 上午11:49:24
     */
    void jpushToAllUsers(String pushMsg,  Map<String, String> extras);
    
    /**
     * 功能描述:为某个特定的用户发送消息推送
     * 参数:appUser:app用户对象; pushMsg要推送的具体内容
     * 作者:温海金
     * 最后更改时间 : 2017年2月21日 上午11:49:24
     */
    void jpushToTheOneUser(AppUser appUser, String pushMsg, Map<String, String> extras);
    
    /**
     * 功能描述:为某个特定的用户发送消息
     * 作者:温海金
     * 最后更改时间 : 2017年5月2日 上午11:28:35
     */
    void jmessageToTheOneUser(AppUser appUser, String pushMsg, Map<String, String> extras);
    
    /**
     * 功能描述:为某个特定的用户发送消息
     * 作者:温海金
     * 最后更改时间 : 2017年5月2日 上午11:28:35
     */
    void jmessageByUserId(Integer userId, String pushMsg, Map<String, String> extras);
    
    /**
     * 功能描述:为用户组发送消息推送
     * 参数:appUsers:app用户对象组; pushMsg要推送的具体内容
     * 作者:温海金
     * 最后更改时间 : 2017年2月21日 上午11:49:24
     */
    void jpushToTheUsers(List<AppUser> appUsers, String pushMsg, Map<String, String> extras);
    
    /**
     * 功能描述:根据用户id为用户发送消息推送
     * 参数:userId用户Id; pushMsg要推送的具体内容
     * 作者:温海金
     * 最后更改时间 : 2017年2月21日 上午11:49:24
     */
    void jpushByUserId(Integer userId, String pushMsg, Map<String, String> extras);
    
    /**
     * 功能描述:根据用户id链表为用户组发送消息推送
     * 参数:userId用户Id; pushMsg要推送的具体内容
     * 作者:温海金
     * 最后更改时间 : 2017年2月21日 上午11:49:24
     */
    void jpushByUserIds(List<Integer> userIds, String pushMsg, Map<String, String> extras);
    
    /**
     * 功能描述:向所有app用户发送消息
     * 作者:温海金
     * 最后更改时间 : 2017年4月21日 下午5:54:13
     */
    void jpushMessageToAllUsers(String msgContent, Map<String, String> extras);
    /**
     * 功能描述:根据标签发送消息
     * 作者:温海金
     * 最后更改时间 : 2017年4月21日 下午5:54:13
     */
    void jpushMessageByTag(String msgContent, String tag, int lastLoginSysType, Map<String, String> extras);

    /**
     * 向某一城市所有用户发送消息
     * @author yangyang
     * @param cityCode
     * @param pushMsg
     * @param extras
     */
	void jmessageToCityUsers(String cityCode, String pushMsg, Map<String, String> extras);
    
}