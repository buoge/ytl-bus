package com.lantaiyuan.ebus.realtime.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lantaiyuan.ebus.common.jpush.JpushHelper;
import com.lantaiyuan.ebus.realtime.model.AppUser;
import com.lantaiyuan.ebus.realtime.service.AppUserServiceI;
import com.lantaiyuan.ebus.realtime.service.JpushServiceI;

@Service("jpushService")
public class JpushServiceImpl implements JpushServiceI {

	private static Logger logger = LoggerFactory.getLogger(JpushServiceImpl.class);

	@Resource
	private AppUserServiceI appUserService;

	/**
	 * 功能描述:为所有用户发送通知 参数:pushMsg要推送的具体内容 作者:温海金 最后更改时间 : 2017年2月21日 上午11:49:24
	 */
	@Override
	@Async("jpushExecutor")
	public void jpushToAllUsers(String pushMsg, Map<String, String> extras) {
		JpushHelper.pushAll(pushMsg);
		logger.info("向所有用户发送消息推送!推送内容:" + pushMsg);
	}

	/**
	 * 功能描述:为所有用户发送消息 作者:温海金 最后更改时间 : 2017年4月21日 下午5:46:39
	 */
	@Override
	@Async("jpushExecutor")
	public void jpushMessageToAllUsers(String msgContent, Map<String, String> extras) {
		JpushHelper.sendMessageAll(msgContent, extras);
		logger.info("向所有用户发送消息!消息内容:" + msgContent);
	}

	/**
	 * 功能描述:为某个特定的用户发送通知 参数:appUser:app用户对象; pushMsg要推送的具体内容 作者:温海金 最后更改时间 :
	 * 2017年2月21日 上午11:49:24
	 */
	@Override
	@Async("jpushExecutor")
	public void jpushToTheOneUser(AppUser appUser, String pushMsg, Map<String, String> extras) {
		if (appUser != null && !StringUtils.isEmpty(appUser.getRegistrationId())) {
			JpushHelper.sendNotificationWithRegistrationID("消息推送", pushMsg, extras, appUser.getRegistrationId(),
					appUser.getLastLoginSysType());
			logger.info("向用户(id为" + appUser.getUserid() + ")发送消息推送!推送内容:" + pushMsg);
		}
	}

	/**
	 * 功能描述:为用户组发送消息推送 参数:appUsers:app用户对象组; pushMsg要推送的具体内容 作者:温海金 最后更改时间 :
	 * 2017年2月21日 上午11:49:24
	 */
	@Override
	@Async("jpushExecutor")
	public void jpushToTheUsers(List<AppUser> appUsers, String pushMsg, Map<String, String> extras) {
		appUsers.forEach(appUser -> {
			jpushToTheOneUser(appUser, pushMsg, extras);
		});
	}

	/**
	 * 功能描述:根据用户id为用户发送消息推送 参数:userId用户Id; pushMsg要推送的具体内容 作者:温海金 最后更改时间 :
	 * 2017年2月21日 上午11:49:24
	 */
	@Override
	@Async("jpushExecutor")
	public void jpushByUserId(Integer userId, String pushMsg, Map<String, String> extras) {
		if (userId != null) {
			AppUser appUser = appUserService.getAppUserById(userId);
			jpushToTheOneUser(appUser, pushMsg, extras);
		}
	}

	/**
	 * 功能描述:根据用户id链表为用户组发送消息推送 参数:userId用户Id; pushMsg要推送的具体内容 作者:温海金 最后更改时间 :
	 * 2017年2月21日 上午11:49:24
	 */
	@Override
	@Async("jpushExecutor")
	public void jpushByUserIds(List<Integer> userIds, String pushMsg, Map<String, String> extras) {
		userIds.forEach(userId -> {
			jpushByUserId(userId, pushMsg, extras);
		});
	}

	/**
	 * 功能描述:为某个特定的用户发送消息 作者:温海金 最后更改时间 : 2017年5月2日 上午11:29:00
	 */
	@Override
	@Async("jpushExecutor")
	public void jmessageToTheOneUser(AppUser appUser, String pushMsg, Map<String, String> extras) {
		if (appUser != null && !StringUtils.isEmpty(appUser.getRegistrationId())) {
			JpushHelper.sendMessageWithRegistrationID("消息推送", pushMsg, appUser.getRegistrationId(),
					appUser.getLastLoginSysType(), extras);
			logger.info("向用户(id为" + appUser.getUserid() + ")发送消息!消息内容:" + pushMsg);
		}
	}

	/**
	 * 功能描述:根据用户id向特定用户发送消息 作者:温海金 最后更改时间 : 2017年5月8日 上午10:50:33
	 */
	@Override
	@Async("jpushExecutor")
	public void jmessageByUserId(Integer userId, String pushMsg, Map<String, String> extras) {
		if (userId != null) {
			AppUser appUser = appUserService.getAppUserById(userId);
			jmessageToTheOneUser(appUser, pushMsg, extras);
		}
	}

	/**
	 * 向某一城市所有用户发送消息
	 * 
	 * @author yangyang
	 * @param cityCode
	 * @param pushMsg
	 * @param extras
	 */
	@Override
	@Async("jpushExecutor")
	public void jmessageToCityUsers(String cityCode, String pushMsg, Map<String, String> extras) {
		List<AppUser> cityUserList = appUserService.getCityUsers(cityCode);
		cityUserList.stream().filter(u -> !Objects.equals(u.getRegistrationId(), "0")).forEach(user -> {
			jmessageToTheOneUser(user, pushMsg, extras);
		});
	}

	/**
	 * 功能描述:按标签发送消息
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月17日 上午11:54:25
	 */
	@Override
	@Async("jpushExecutor")
	public void jpushMessageByTag(String msgContent, String tag, int lastLoginSysType, Map<String, String> extras) {
		JpushHelper.sendMessageByTag(msgContent, tag, lastLoginSysType, extras);
	}

	
}
