package com.lantaiyuan.ebus.common.jpush;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.model.enummodel.JpushTypeEnum;
import com.lantaiyuan.ebus.custom.model.enummodel.LastLoginSysTypeEnum;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.IosNotification.Builder;
import cn.jpush.api.push.model.notification.Notification;

/**
 * 描述:消息推送帮助类
 * 作者:温海金
 * 最后更改时间:下午3:47:38
 */
public class JpushHelper {

	//private static final String APP_KEY = "4f796617ec645d50bb4e620c";//myKey
	//private static final String MASTER_SECRET = "91628aed5f1d7eb7c7d7bc13";//mySecret
	private static final String APP_KEY = "fcce08d7d0a638dcb39bd65e";//companyKey
	private static final String MASTER_SECRET = "66442e460601816ebf761368";//companySecret
	private static Logger logger = Logger.getLogger(JpushHelper.class);

	private static JPushClient jpushClient = null;

	public static JPushClient getJPushClient() {
		if (jpushClient == null) {
			synchronized (JpushHelper.class) {
				if (jpushClient == null) {
					ClientConfig instance = ClientConfig.getInstance();
					//设置了该配置项，在进行消息推送的时候才能推送到IOS的生产环境
					//TODO instance.setApnsProduction(true);
					instance.setApnsProduction(false);
					jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, instance);
				}
			}
		}
		return jpushClient;
	}

	/**
	 * 功能描述:向所有用户发送消息推送
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月20日 下午3:48:12
	 */
	private static PushPayload buildPushObject_all_all_alert(String pushMsg) {
		return PushPayload.alertAll(pushMsg);
	}

	/**
	 * 功能描述:向所有用户进行消息推送
	 * 参数: pushContent表示要推送的具体内容
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月20日 下午3:48:12
	 */
	public static void pushAll(String pushMsg) {
		PushPayload payload = buildPushObject_all_all_alert(pushMsg);
		try {
			PushResult result = getJPushClient().sendPush(payload);
			logger.info("成功发送消息推送 - " + result);

		} catch (APIConnectionException e) {
			logger.error("连接异常，请稍后再试", e);

		} catch (APIRequestException e) {
			logger.error("消息推送出错", e);
			logger.info("HTTP状态码: " + e.getStatus());
			logger.info("错误代码: " + e.getErrorCode());
			logger.info("报错信息: " + e.getErrorMessage());
		}
	}
	
	/**
	 * 功能描述:向所有用户发送消息
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月4日 下午5:40:00
	 */
	public static void sendMessageAll(String msgContent, Map<String, String> extras) {
		try {
			//向所有IOS平台推送消息
			JpushHelper.getJPushClient().sendPush(JpushHelper.buildPushObject_ios_audienceAll(msgContent, extras));
			//向所有android用户发送消息
			getJPushClient().sendPush(getAndroidMessagePushPayloadToAll(msgContent, extras));
		}  catch (APIConnectionException e) {
			logger.error("连接异常，请稍后再试", e);
		} catch (APIRequestException e) {
			logger.error("消息推送出错", e);
			logger.info("HTTP状态码: " + e.getStatus());
			logger.info("错误代码: " + e.getErrorCode());
			logger.info("报错信息: " + e.getErrorMessage());
		}
	}
	

	/**
	 * 功能描述:根据registrationId向用户发送消息(IOS不支持消息，故用通知)
	 * 参数: pushContent表示要推送的具体内容
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月20日 下午3:48:12
	 */
	public static void sendMessageWithRegistrationID(String title, String msgContent, String registrationID, Integer lastLoginSysType, Map<String, String> extras) {
		try {
			if (LastLoginSysTypeEnum.ANDROID.value() == lastLoginSysType) {
				//向安卓平台发送消息
				//getJPushClient().sendAndroidMessageWithRegistrationID(title, msgContent, registrationID);
				getJPushClient().sendPush(getAndroidMessagePushPayload(msgContent, registrationID, extras));
			} else if (LastLoginSysTypeEnum.IOS.value() == lastLoginSysType) {
				//向IOS平台推送通知
				getJPushClient().sendPush(JpushHelper.buildPushObject_ios_audienceMore_regId(registrationID, msgContent, extras));
			} else {
				//向安卓平台发送消息
				getJPushClient().sendPush(getAndroidMessagePushPayload(msgContent, registrationID, extras));
				//getJPushClient().sendAndroidNotificationWithRegistrationID(title, msgContent, extras, registrationID);
				//向IOS平台推送通知
				getJPushClient().sendPush(JpushHelper.buildPushObject_ios_audienceMore_regId(registrationID, msgContent, extras));
			}
		} catch (APIConnectionException e) {
			logger.error("连接异常，请稍后再试", e);
		} catch (APIRequestException e) {
			logger.error("消息推送出错", e);
			logger.info("HTTP状态码: " + e.getStatus());
			logger.info("错误代码: " + e.getErrorCode());
			logger.info("报错信息: " + e.getErrorMessage());
		}
	}

	/**
	 * 构建推送对象:所有平台，推送目标是别名为alias，通知内容为 pushMsg。
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月20日 下午4:06:00
	 */
	public static PushPayload buildPushObject_all_alias_alert(String alias, String pushMsg) {
		return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(alias)).setNotification(Notification.alert(pushMsg))
				.setOptions(Options.newBuilder()
						//此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
						.setApnsProduction(true)
						//此字段是给开发者自己给推送编号，方便推送者分辨推送记录
						.setSendno(1)
						//此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天，单位为秒
						.setTimeToLive(86400).build())
				.build();
	}

	/**
	 * 构建推送对象:平台是 Android，目标是 tag 为 taget 的设备，内容是 Android 通知 pushMsg，并且标题为 title。
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月20日 下午4:12:04
	 */
	public static PushPayload buildPushObject_android_tag_alertWithTitle(String taget, String pushMsg, String title) {
		return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag(taget)).setNotification(Notification.android(pushMsg, title, null))
				.build();
	}

	/**
	* 构建推送对象：平台是 iOS，推送目标是 "tag1", "tag_all" 的交集，
	* 	                       推送内容同时包括通知与消息 - 通知信息是 notifyAlert，角标数字为 5，
	* 		通知声音为 "happy"，并且附加字段 from = "JPush"；
	* 		消息内容是 msgContent。
	* 		通知是 APNs 推送通道的，消息是 JPush 应用内消息通道的。
	* 		APNs 的推送环境是“生产”（如果不显式设置的话，Library 会默认指定为开发）
	* 作者:温海金
	* 最后更改时间 : 2017年2月20日 下午4:15:27
	*/
	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(String tag1, String tag_all, String notifyAlert, String happy, String msgContent) {
		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.tag_and(tag1, tag_all))
				.setNotification(Notification.newBuilder()
						.addPlatformNotification(IosNotification.newBuilder().setAlert(notifyAlert).setBadge(5).setSound(happy).addExtra("from", "JPush").build())
						.build())
				.setMessage(Message.content(msgContent)).setOptions(Options.newBuilder().setApnsProduction(true).build()).build();
	}

	/**
	 * 构建推送对象：平台是 Andorid 与 iOS，按照registrationId推送
	 * 		推送内容是 - 内容为 msgContent 的消息，并且附加字段 from = JPush。
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月20日 下午4:20:46
	 */
	public static PushPayload buildPushObject_ios_audienceMore_regId(String registrationId, String msgContent, Map<String, String> extras) {
		Builder iosBuilder = IosNotification.newBuilder().setAlert(msgContent).setBadge(5).setSound("default");
		Set<Entry<String, String>> entrySet = extras.entrySet();
		entrySet.forEach(mapEntry ->{
			iosBuilder.addExtra(mapEntry.getKey(), mapEntry.getValue());
		});
		IosNotification iosBuild = iosBuilder.build();
		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.registrationId(registrationId))

				.setNotification(Notification.newBuilder()
						.addPlatformNotification(iosBuild)
						.build())
				.build();
	}
	
	/**
	 * 构建推送对象：平台是 iOS，推送给所有用户
	 * 		推送内容是 - 内容为 msgContent 的消息，并且附加字段 extras。
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月20日 下午4:20:46
	 */
	public static PushPayload buildPushObject_ios_audienceAll(String msgContent, Map<String, String> extras) {
		Builder iosBuilder = IosNotification.newBuilder().setAlert(msgContent);
		Set<Entry<String, String>> entrySet = extras.entrySet();
		entrySet.forEach(mapEntry ->{
			iosBuilder.addExtra(mapEntry.getKey(), mapEntry.getValue());
		});
		IosNotification iosBuild = iosBuilder.build();
		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.all())
				.setNotification(Notification.newBuilder()
						.addPlatformNotification(iosBuild)
						.build())
				.build();
	}

	/**
	 * 功能描述:根据registrationId向用户发送通知
	 * 参数: pushContent表示要推送的具体内容
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月20日 下午3:48:12
	 */
	public static void sendNotificationWithRegistrationID(String title, String msgContent, Map<String, String> extras, String registrationID, Integer lastLoginSysType) {
		try {
			if (LastLoginSysTypeEnum.ANDROID.value() == lastLoginSysType) {
				//向安卓平台推送消息
				getJPushClient().sendAndroidNotificationWithRegistrationID(title, msgContent, extras, registrationID);
			} else if (LastLoginSysTypeEnum.IOS.value() == lastLoginSysType) {
				//向IOS平台推送消息
				JpushHelper.getJPushClient().sendPush(JpushHelper.buildPushObject_ios_audienceMore_regId(registrationID, msgContent, extras));
			} else {
				//向IOS平台推送消息
				JpushHelper.getJPushClient().sendPush(JpushHelper.buildPushObject_ios_audienceMore_regId(registrationID, msgContent, extras));
				//向安卓平台推送消息
				getJPushClient().sendAndroidNotificationWithRegistrationID(title, msgContent, extras, registrationID);
			}
		} catch (APIConnectionException e) {
			logger.error("连接异常，请稍后再试", e);
		} catch (APIRequestException e) {
			logger.error("消息推送出错", e);
			logger.info("HTTP状态码: " + e.getStatus());
			logger.info("错误代码: " + e.getErrorCode());
			logger.info("报错信息: " + e.getErrorMessage());
		}
	}
	
	
	/**
	 * 功能描述:构建推送对象：平台是 Andorid，推送内容是 - 内容为 msgContent 的消息，推送regId是registrationId，并且添加附加字段extras。
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月9日 下午6:20:49
	 */
    public static PushPayload getAndroidMessagePushPayload(String msgContent, String registrationId, Map<String, String> extras) {
    	cn.jpush.api.push.model.Message.Builder builder = cn.jpush.api.push.model.Message.newBuilder();
    	return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.registrationId(registrationId))
    	.setMessage(builder.addExtras(extras).setMsgContent(msgContent).build())
		.build();
    }
    
    /**
     * 功能描述:构建推送对象：平台是 Andorid，推送内容是 - 内容为 msgContent 的消息，推送对象是所有andriod用户，并且添加附加字段extras。
     * 作者:温海金
     * 最后更改时间 : 2017年5月9日 下午6:20:49
     */
    public static PushPayload getAndroidMessagePushPayloadToAll(String msgContent, Map<String, String> extras) {
    	cn.jpush.api.push.model.Message.Builder builder = cn.jpush.api.push.model.Message.newBuilder();
    	return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.all())
    			.setMessage(builder.addExtras(extras).setMsgContent(msgContent).build())
    			.build();
    }
    

	/**
	 * 功能描述:按标签发送消息,平台是 Andorid，推送内容是 - 内容为 msgContent 的消息，推送标签为tag，并且添加附加字段extras。
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月9日 下午6:20:49
	 */
    private static PushPayload getAndroidMessagePushPayload4tag(String msgContent, String tag, Map<String, String> extras) {
    	cn.jpush.api.push.model.Message.Builder builder = cn.jpush.api.push.model.Message.newBuilder();
    	return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag(tag))
    	.setMessage(builder.addExtras(extras).setMsgContent(msgContent).build())
		.build();
    }
	
	/**
	* 构建推送对象：平台是 iOS，推送目标是 "tag"，推送的是通知
	* 作者:温海金
	* 最后更改时间 : 2017年2月20日 下午4:15:27
	*/
	private static PushPayload buildPushObject4IOSByTagWithExtrasAndMessage(String msgContent, String tag, Map<String, String> extras) {
		Builder iosBuilder = IosNotification.newBuilder().setAlert(msgContent).setSound("default");
		Set<Entry<String, String>> entrySet = extras.entrySet();
		entrySet.forEach(mapEntry ->{
			iosBuilder.addExtra(mapEntry.getKey(), mapEntry.getValue());
		});
		IosNotification iosBuild = iosBuilder.build();
		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.tag(tag))

				.setNotification(Notification.newBuilder()
						.addPlatformNotification(iosBuild)
						.build())
				.build();
	}
    
    public static void sendMessageByTag(String msgContent, String tag, int lastLoginSysType, Map<String, String> extras) {
    	try {
			if (LastLoginSysTypeEnum.ANDROID.value() == lastLoginSysType) {
				//向安卓平台发送消息
				getJPushClient().sendPush(getAndroidMessagePushPayload4tag(msgContent, tag, extras));
			} else if (LastLoginSysTypeEnum.IOS.value() == lastLoginSysType) {
				//向IOS平台推送通知
				getJPushClient().sendPush(JpushHelper.buildPushObject4IOSByTagWithExtrasAndMessage(msgContent, tag, extras));
			} else {
				//向安卓平台发送消息
				getJPushClient().sendPush(getAndroidMessagePushPayload4tag(msgContent, tag, extras));
				//向IOS平台推送通知
				getJPushClient().sendPush(JpushHelper.buildPushObject4IOSByTagWithExtrasAndMessage(msgContent, tag, extras));
			}
		} catch (APIConnectionException e) {
			logger.error("连接异常，请稍后再试", e);
		} catch (APIRequestException e) {
			logger.error("消息推送出错", e);
			logger.info("HTTP状态码: " + e.getStatus());
			logger.info("错误代码: " + e.getErrorCode());
			logger.info("报错信息: " + e.getErrorMessage());
		}
    }
    
	public static void main(String[] args) {
		HashMap<String, String> extras = new HashMap<String, String>();
		extras.put(SysGlobalConstants.MSG_TYPE, JpushTypeEnum.NOTICE.value());
		//JpushHelper.sendMessageWithRegistrationID("test", "helloWorld", "190e35f7e075f5f3383", LastLoginSysTypeEnum.ANDROID.value() , extras);
		//向所有用户发送消息
		//JpushHelper.sendMessageAll("2");
		//JpushHelper.pushAll("消息推送测试");
		//JpushHelper.sendMessageWithRegistrationID("IOS通知-单个用户", "helloWorld", "13165ffa4e3be05398d", LastLoginSysTypeEnum.IOS.value(), extras);
		//JpushHelper.sendMessageAll("IOS通知-所有用户", extras);
		
		JpushHelper.sendMessageByTag("根据标签进行消息推送", "610300", 1, extras);
	}

}
