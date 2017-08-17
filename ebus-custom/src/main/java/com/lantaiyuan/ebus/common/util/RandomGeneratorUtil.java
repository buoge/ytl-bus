package com.lantaiyuan.ebus.common.util;

import java.util.Random;

/**
 * 描述:随机生成指定长度的字符串
 * 作者:温海金
 * 最后更改时间:上午11:15:55
 */
public class RandomGeneratorUtil {

    /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    
    /**
     * 获取一定位数的int类型
     * @param length 指定int类型的位数
     * @return 一定位数的int类型
     * @throws Exception 
     */
    public static Integer getRandomIntegerByLength(int length) throws IllegalAccessException {
	if(length >= 10) throw new IllegalAccessException("您设置的整数类型过大，最大输入9位数");
        String base = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return Integer.valueOf(sb.toString());
    }

}
