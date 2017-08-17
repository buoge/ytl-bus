package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.NoticeHistory;
import com.lantaiyuan.ebus.custom.model.NoticeHistoryQueryModel;

/**
 * 描述:通知信息历史记录dao持久层
 * 作者:温海金
 * 最后更改时间:下午6:39:50
 */
public interface NoticeHistoryMapper extends BaseDAO<NoticeHistory, NoticeHistoryQueryModel> {
	/**
	 * 功能描述:分页查询通知历史信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午6:40:27
	 */
	List<NoticeHistory> listByPage(NoticeHistoryQueryModel noticeHistoryQM);
	
	/**
	 * 功能描述:根据用户id查询紧急记录
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月19日 下午5:14:22
	 */
	List<NoticeHistory> getNoticeHistorysByUserId(@Param("userId")String userId, @Param("cityCode")String cityCode);
	
	/**
	 * 功能描述:根据用户id查询紧急记录
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月19日 下午5:14:22
	 */
	List<NoticeHistory> getNoticeHistorysByUserId4Weather(@Param("userId")String userId, @Param("cityCode")String cityCode);

	/**
	 * 功能描述:获取某时间后对应于某个用户的通知数量
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月18日 上午11:55:17
	 */
	int getCountByUserIdAndLastTime(@Param("userId")String userId, @Param("cityCode")String cityCode, @Param("lastRequestTime")String lastRequestTime);

    
}