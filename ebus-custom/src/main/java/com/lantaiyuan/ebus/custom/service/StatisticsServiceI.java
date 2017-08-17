package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import com.lantaiyuan.ebus.custom.model.ODMap;
import com.lantaiyuan.ebus.custom.model.StatisticsQueryModel;
import com.lantaiyuan.ebus.custom.model.TrendStatistics;
import com.lantaiyuan.ebus.custom.model.UserStatistics;

public interface StatisticsServiceI {
	
	/**
	 * 用户统计
	 * @auther yangyang
	 * @return
	 */
	UserStatistics userStatistics();
	
	/**
	 * 趋势分析
	 * @auther yangyang
	 * @return
	 */
	List<TrendStatistics> trendStatistics(StatisticsQueryModel queryModel);

	List<ODMap> odMap(String cityCode);
	
	
}