package com.lantaiyuan.ebus.common.util;



import org.apache.commons.lang3.StringUtils;

import com.xiaoleilu.hutool.crypto.SecureUtil;

/**
 * 
 * DesUtil 
 * 对称加密算法
 * @author yangyang
 * @date 2017年4月25日 上午10:05:15 
 */
public class DesUtil {
	
	/**
	 * 加密解密的key
	 */
	private static final byte[] KEY = "lantaiyuanzuogongjiao".getBytes(); 
	
	/**
	 * 加密
	 * @author yangyang
	 * @param data
	 * @return
	 */
	public static String encrypt(String data) {
		return SecureUtil.des(KEY).encryptHex(data);
	}
	
	/**
	 * 解密
	 * @author yangyang
	 * @param data
	 * @return
	 */
	public static String decrypt(String data) {
		if (StringUtils.isNumeric(data)) {
			return data;
		}
		return SecureUtil.des(KEY).decryptStr(data);
	}
	
	
}
