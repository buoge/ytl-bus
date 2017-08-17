package com.lantaiyuan.ebus.service.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.jpush.JpushHelper;
import com.lantaiyuan.ebus.model.JpushDemo;
import com.lantaiyuan.ebus.service.JpushServiceI;

/**
 * 描述:消息推送业务实现类
 * 作者:温海金
 * 最后更改时间:下午5:22:54
 */
@Service
public class JpushServiceImpl implements JpushServiceI {

	@Override
	public void jpushToAllUsers(String pushMsg, Map<String, String> extras) {
		// TODO
		JpushHelper.pushAll(pushMsg);
	}

	@Override
	public void jpushByRegId(String regId, String pushMsg, Map<String, String> extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jpushByRegIds(Set<String> regIds, String pushMsg, Map<String, String> extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jmessageToAllUsers(String msgContent, Map<String, String> extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jmessageByRegId(String regId, String pushMsg, Map<String, String> extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jmessageByRegIds(Set<String> regIds, String pushMsg, Map<String, String> extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jmessageByTag(String msgContent, String tag, int lastLoginSysType, Map<String, String> extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jpushByJpushDemo(JpushDemo jpushDemo) {
		// TODO Auto-generated method stub
		
	}

}
