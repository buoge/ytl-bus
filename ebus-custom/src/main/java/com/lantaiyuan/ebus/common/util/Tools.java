package com.lantaiyuan.ebus.common.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.lanqiao.ssm.common.util.DateFormatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
/**
 * 
 * @ClassName: Tools 
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2016年12月20日 下午2:21:33
 */
public class Tools {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String TIME_FORMAT = "HH:mm:ss";
	private static Logger logger = LoggerFactory.getLogger(Tools.class);
	private static Date currentDate = new Date();
	 
	public static String generateOrderNo(){
		return DateFormatUtil.getDateFormat("yMMddkkmms").format(currentDate) + generateStr(generateRanNum(4), 8);
	}
	 
	public static String generateOrderDetailId(){
		return DateFormatUtil.getDateFormat("yMMddkkmm").format(currentDate) + generateRanNum(4);
		
	}
	
	public static String generateGoodsId(){
		return DateFormatUtil.getDateFormat("YYMMddkkmms").format(currentDate) + generateStr(generateRanNum(4),8);
	}
	
	/**
	 * 将字符串转换为日期，使用yyyy-MM-dd HH:mm:ss格式
	 * @auther yangyang
	 * @param date
	 * @return
	 */
	public static Date processStrToDate(String date) {
		try {
			return DateFormatUtil.getDateFormat(DATE_FORMAT).parse(date);
		} catch (ParseException e) {
			logger.error("不是合法的日期格式", e);
			throw new RuntimeException("不是合法的日期格式。");
		}
	}
	
	/**
	 * 将字符串转换为日期，可以指定日期格式
	 * @auther yangyang
	 * @param date
	 * @param dateFormat 指定日期格式
	 * @return
	 */
	public static Date processStrToDate(String date,String dateFormat) {
		try {
			return DateFormatUtil.getDateFormat(dateFormat).parse(date);
		} catch (ParseException e) {
			logger.error("不是合法的日期格式", e);
			throw new RuntimeException("不是合法的日期格式。");
		}
	}
	
	/**
	 * 将日期转换为字符串，使用yyyy-MM-dd HH:mm:ss格式
	 * @auther yangyang
	 * @param date
	 * @return
	 */
	public static String processDateToStr(Date date) {
		return DateFormatUtil.getDateFormat(DATE_FORMAT).format(date);
	}
	
	/**
	 * 将日期转换为时间字符串，使用HH:mm:ss格式
	 * @auther yangyang
	 * @param date
	 * @return
	 */
	public static String processDateToHHmmss(Date date) {
		return DateFormatUtil.getDateFormat(TIME_FORMAT).format(date);
	}
	
	/**
	 * 将日期转换为字符串，可以指定格式
	 * @auther yangyang
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String processDateToStr(Date date, String dateFormat) {
		return DateFormatUtil.getDateFormat(dateFormat).format(date);
	}
	
	/**
	 * 比较实时数据时间和当前时间
	 * @auther yangyang
	 */
	public static boolean isTimeValid(String str, Integer timeDiff) {
		Date packetTime = processStrToDate(str);
		// TIME_DIFF之前的时间(认为过时的时间)
		Calendar expire = Calendar.getInstance();
		expire.set(Calendar.MINUTE, expire.get(Calendar.MINUTE) - timeDiff);
		return packetTime.compareTo(expire.getTime()) >= 0;
	}
	
	/**
	 * 返回两个日期的时间差，单位：秒
	 * @author yangyang
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long secondsTimeDiff(Date date1, Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		long diff = Math.abs(time1 - time2);
		return diff / 1000;
	}

	/**
	 * 
	  * generateRanNum(生成(6+rand)位随机数字   rand最大取值4)
	 */
	public static String generateRanNum(int rand) {
		int max = (int) (SysGlobalConstants.TOOLS_MAX * Math.pow(10,  rand));
		int min = (int) (SysGlobalConstants.TOOLS_MIN * Math.pow(10,  rand));
		return new Random().nextInt(max) % (max - min + 1) + min + "";
	}

	/**
	 * generateStr(给定字符串A，将A前往后截取生成指定长度length的字符串，若A
	 * 长度小于length，前面补充length-A.length()个0，然后加上A本身) 
	 */
	public static String generateStr(String soureString, int length) {
		String zero = "0";
		StringBuilder sBuilder = new StringBuilder();
		int len = soureString.length();
		if (len < length) {
			int times = length - len;
			for (int i = 0; i < times; i++) {
				sBuilder.append(zero);
			}
			return sBuilder.append(soureString).toString();
		} else {
			return soureString.substring(0, length);
		}
	}
	
	
	 /**
	  * 功能描述:返回当前日期是星期几
	  * 作者:温海金
	  * 最后更改时间 : 2017年3月2日 下午6:02:54
	  */
	 public static int dayForWeek() {
        	  Calendar c = Calendar.getInstance();
        	  c.setTime(currentDate);
        	  int dayForWeek = 0;
        	  if(c.get(Calendar.DAY_OF_WEEK) == 1){
        	      dayForWeek = 7;
        	  }else{
        	      dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        	  }
        	  return dayForWeek;
	 }
	 
	 /**
	  * 功能描述:返回当前日期是星期几
	  * 作者:温海金
	  * 最后更改时间 : 2017年3月2日 下午6:02:54
	  */
	 public static int getDayForWeek(Date date) {
        	  Calendar c = Calendar.getInstance();
        	  c.setTime(date);
        	  int dayForWeek = 0;
        	  if(c.get(Calendar.DAY_OF_WEEK) == 1){
        	      dayForWeek = 7;
        	  }else{
        	      dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        	  }
        	  return dayForWeek;
	 }
	
}