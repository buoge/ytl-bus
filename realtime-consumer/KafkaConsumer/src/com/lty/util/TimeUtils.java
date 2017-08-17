package com.lty.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
  * @Title: TimeUtils.java
  * @Package com.lty.util
  * @Description: 
  * @author yangyang   
  * @date 2017年3月31日 下午4:32:03
  * @version v1.0  
 */
public class TimeUtils {
	
	private static Logger logger = LoggerFactory.getLogger(TimeUtils.class);
	
	private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 把字符串转换为日期
	 * @auther yangyang
	 * @param time
	 * @return
	 */
	public static Date parse(String time) {
		try {
			return DateUtils.parseDate(time, FORMAT);
		} catch (ParseException e) {
			logger.error(time.concat("不能转换为格式为").concat(FORMAT).concat("的日期"), e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 计算now和firstTime之间的时间差（秒）
	 * @auther yangyang
	 * @param firstTime
	 * @param now
	 * @return 			如果firstTime和now不能被正常
	 */
	public static long timeDiff(String firstTime, String now) {		
		Date start = parse(firstTime);
		Date end = parse(now);
		return (end.getTime() - start.getTime()) / 1000;
	}

}
