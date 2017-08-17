package com.lantaiyuan.ebus.common.mns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;

/**
 * 描述:Aliyun短信服务集成
 * 作者:温海金
 * 最后更改时间:上午10:51:39
 */
public class AliyunMNSHelper {
	
	private static Logger logger = LoggerFactory.getLogger(AliyunMNSHelper.class);
	/**
	 * 访问短信服务的权限KEY唯一标示
	 */
	private static final String ACCESS_KEY_ID = "LTAIDlL1bylKI20O";
	/**
	 * 访问短信服务的权限KEY密钥
	 */
	private static final String ACCESS_KEY_SECRET = "x7Wojdu8mEXV4hOXWr1MF8YHLxdO6P";
	/**
	 * 接口访问地址
	 */
	private static final String MNS_END_POINT = "https://1054280657679380.mns.cn-hangzhou.aliyuncs.com/";
	/**
	 * 华南1主题引用
	 */
	private static final String TOPIC_REF = "sms.topic-cn-hangzhou";
	/**
	 * 签名名称
	 */
	private static final String SIGN_NAME = "坐公交";
	/**
	 * 服务器出现异常
	 */
	public static final String SERVER_EXCEPTION = "SMS_62885094";
	/**
	 * 服务器回复正常
	 */
	public static final String SERVER_BACK_TO_NORMAL = "SMS_62830031";
	/**
	 * 云账号对象
	 */
	public static CloudAccount account = null;
	/**
	 * 短信息客户端对象
	 */
	public static MNSClient client = null;
	/**
	 * 功能描述:获取云账户信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月21日 下午1:04:59
	 */
	private static CloudAccount getCloudAccount() {
		if(account == null) {
			synchronized (CloudAccount.class) {
				if(account == null) {
					account = new CloudAccount(ACCESS_KEY_ID, ACCESS_KEY_SECRET, MNS_END_POINT);
				}
			}
		}
		return account;
	}
	/**
	 * 功能描述:获取短信服务客户端
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月21日 下午1:19:09
	 */
	private static MNSClient getMNSClient() {
		if(client == null) {
			synchronized (MNSClient.class) {
				if(client == null) {
					client = getCloudAccount().getMNSClient();
				}
			}
		}
		return client;
	}
	/**
	 * 功能描述:发送短信服务
	 * 作者:温海金
	 * 参数说明: 	cityName 城市名称
	 * 			phoneNum 需要通知的手机号码
	 * 最后更改时间 : 2017年4月21日 下午1:19:29
	 */
	public static void sendMNS(String cityName, String phoneNum, String smsTemplateCode) {
		/**
		 * Step 1. 获取主题引用
		 */
		CloudTopic topic = getMNSClient().getTopicRef(TOPIC_REF);
		/**
		 * Step 2. 设置SMS消息体（必须）
		 *
		 * 注：目前暂时不支持消息内容为空，需要指定消息内容，不为空即可。
		 */
		RawTopicMessage msg = new RawTopicMessage();
		msg.setMessageBody("sms-message");
		/**
		 * Step 3. 生成SMS消息属性
		 */
		MessageAttributes messageAttributes = new MessageAttributes();
		BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
		// 3.1 设置发送短信的签名（SMSSignName）
		batchSmsAttributes.setFreeSignName(SIGN_NAME);
		// 3.2 设置发送短信使用的模板（SMSTempateCode）
		batchSmsAttributes.setTemplateCode(smsTemplateCode);
		// 3.3 设置发送短信所使用的模板中参数对应的值（在短信模板中定义的，没有可以不用设置）
		BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
		smsReceiverParams.setParam("cityName", cityName);
		// 3.4 增加接收短信的号码
		batchSmsAttributes.addSmsReceiver(phoneNum, smsReceiverParams);
		messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
		try {
			/**
			 * Step 4. 发布SMS消息
			 */
			TopicMessage ret = topic.publishMessage(msg, messageAttributes);
			logger.info("发送短信息通知，MessageId: " + ret.getMessageId());
			logger.info("发送短信息通知，MessageMD5: " + ret.getMessageBodyMD5());
		} catch (ServiceException se) {
			logger.error(se.getErrorCode() + se.getRequestId());
			logger.error(se.getMessage());
		} catch (Exception e) {
			logger.error("发送短信服务异常！",e);
		}
		//client.close();
	}
	
	
	public static void main(String[] args) {
		AliyunMNSHelper.sendMNS("柳州", "18006915046", AliyunMNSHelper.SERVER_BACK_TO_NORMAL);
		AliyunMNSHelper.sendMNS("柳州", "18006915046", AliyunMNSHelper.SERVER_EXCEPTION);
	}
}
