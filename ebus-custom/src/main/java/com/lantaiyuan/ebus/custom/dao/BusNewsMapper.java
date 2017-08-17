package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.BusNews;
import com.lantaiyuan.ebus.custom.model.BusNewsQueryModel;
import com.lantaiyuan.ebus.custom.model.BusNewsResult;
import com.lantaiyuan.ebus.custom.model.BusNewsResultQueryModel;
import com.lantaiyuan.ebus.custom.model.LostProperty;
import com.lantaiyuan.ebus.custom.model.LostPropertyQueryModel;

/**
 * @author yangyang
 */
public interface BusNewsMapper extends BaseDAO<BusNews, BusNewsQueryModel>{
    
	List<BusNewsResult> getFiveBigNews(@Param("cityCode")String cityCode);
	
	List<BusNewsResult> findSmallNewsByPage(BusNewsResultQueryModel model);

	int insertNews(@Param("news")BusNews news,@Param("ip")String ip);
	
	int countIp(String ip);
	
	int checkDuplicate(BusNews news);
	
	List<Integer> findBigNews(@Param("cityCode")String cityCode);
	
	int changeBigToSmall(@Param("list")List<Integer> list);
	
	int insertFromWebapp(BusNews news);
	
	int updateNews(BusNews news);
	
	List<BusNews> findBusNewsByPage(BusNewsQueryModel model);

	String selectNewsContent(@Param("id")int id);

	List<LostProperty> findLostPropertyByPage(LostPropertyQueryModel model);
	
	/**
	 * 功能描述:是否显示角标
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月20日 下午2:51:22
	 */
	Integer getCountByCondition(@Param("citycode")String citycode, @Param("lastRequestTime")String lastRequestTime, @Param("newsOrLost")String newsOrLost);
	
}