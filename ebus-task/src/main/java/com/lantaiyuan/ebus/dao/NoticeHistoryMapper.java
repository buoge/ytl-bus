package com.lantaiyuan.ebus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.model.NoticeHistory;
import com.lantaiyuan.ebus.model.NoticeHistoryQueryModel;


/**
 * 描述:通知信息历史记录dao持久层
 * 作者:温海金
 * 最后更改时间:下午6:39:50
 */
@Mapper
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
	List<NoticeHistory> getNoticeHistorysByUserId(@Param("userId")String userId);
    
    
}