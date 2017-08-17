package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;

import com.lantaiyuan.ebus.custom.model.NoticeHistory;
import com.lantaiyuan.ebus.custom.model.NoticeHistoryQueryModel;
/**
 * 描述:通知记录信息
 * 作者:温海金
 * 最后更改时间:下午4:06:50
 */
public interface NoticeHistoryServiceI extends BaseServiceI<NoticeHistory, NoticeHistoryQueryModel> {
	/**
	 * 功能描述:通知记录信息分页查询
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午6:36:38
	 */
	Page<NoticeHistory> listByPage(NoticeHistoryQueryModel noticeHistoryQM);
	
	/**
	 * 功能描述:根据用户id查询紧急通知历史记录
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月19日 下午5:12:31
	 */
	List<NoticeHistory> getNoticeHistorysByUserId(String userId);
	
	/**
	 * 功能描述:根据用户id查询紧急通知历史记录供天气信息滚动用
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月19日 下午5:12:31
	 */
	List<NoticeHistory> getNoticeHistorysByUserId4Weather(String userId);
	
	/**
	 * 功能描述:是否显示角标
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月18日 上午11:52:29
	 */
	Boolean showAngleByUserId(String userId, String lastRequestTime);
}
