package com.lantaiyuan.ebus.carpool.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.lantaiyuan.ebus.carpool.enums.JpushNoticeTypeEnum;
import com.lantaiyuan.ebus.carpool.model.jpush.JpushData;
import com.lantaiyuan.ebus.carpool.model.jpush.PushTemplate;
import com.lantaiyuan.ebus.carpool.service.JpushServiceI;
import com.lantaiyuan.ebus.carpool.service.PushMsgService;
import com.lantaiyuan.ebus.carpool.service.PushTemplateService;
import com.lantaiyuan.ebus.carpool.util.JpushHelper;
import com.lantaiyuan.ebus.carpool.util.PlaceholderUtils;

/**
 * 描述:消息推送业务实现类
 * 作者:温海金
 * 最后更改时间:下午5:22:54
 */
@Service
public class JpushServiceImpl implements JpushServiceI {
	
	private static Logger logger = LoggerFactory.getLogger(JpushServiceImpl.class);
	
	@Resource
	private PushTemplateService pushTemplateService;
	@Resource
	private PushMsgService pushMsgService;
	/**
	 * 功能描述:根据推送对象进行消息推送
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月14日 下午5:33:55
	 */
	@Override
	public void jpushByJpushData (JpushData jpushData) {
		String jpushMessage = this.getJpushMessage(jpushData);
		JpushNoticeTypeEnum noticeOrMessage = jpushData.getNoticeTypeEnum();//是通知还是消息
		Integer userId = jpushData.getUserId();
		String regId = pushMsgService.getRegIdByUserId(userId);
		Assert.notNull(regId, "推送对象regId为空，请与管理员联系！");
		if(JpushNoticeTypeEnum.NOTICE == noticeOrMessage){//TODO 发送通知
			JpushHelper.sendNotificationWithRegistrationID(jpushData.getPushTitle(), jpushMessage, jpushData.getVarMap(), regId, null);
			logger.info("向特定用户发送通知，用户ID："+userId+"，通知内容:" + jpushMessage);
		} else {//TODO 发送消息
			JpushHelper.sendMessageWithRegistrationID(jpushData.getPushTitle(), jpushMessage, regId, null, jpushData.getVarMap());
			logger.info("向特定用户发送消息，用户ID："+userId+"，消息内容:" + jpushMessage);
		}
		
	}
	
	/**
	 * 功能描述:
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月14日 下午5:34:33
	 */
	public String getJpushMessage(JpushData jpushData) {
		Integer pushTemplateId = jpushData.getPushTemplateId();
		PushTemplate pushTemplate = pushTemplateService.getPushTemplateById(pushTemplateId);
		String oldContent = pushTemplate.getContent();
		Map<String, String> varMap = jpushData.getVarMap();
		return PlaceholderUtils.resolvePlaceholders(oldContent, varMap);
	}

}
