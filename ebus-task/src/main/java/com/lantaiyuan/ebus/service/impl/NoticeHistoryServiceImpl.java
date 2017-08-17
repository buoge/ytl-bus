package com.lantaiyuan.ebus.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.dao.NoticeHistoryMapper;
import com.lantaiyuan.ebus.model.NoticeHistory;
import com.lantaiyuan.ebus.model.NoticeHistoryQueryModel;
import com.lantaiyuan.ebus.service.NoticeHistoryServiceI;

/**
 * 描述:通知记录业务实现类 作者:温海金 最后更改时间:下午4:13:52
 */
@Service("noticeHistoryService")
public class NoticeHistoryServiceImpl extends BaseService<NoticeHistory, NoticeHistoryQueryModel> implements NoticeHistoryServiceI {

	@Resource
	private NoticeHistoryMapper noticeHistoryMapper;

	public BaseDAO<NoticeHistory, NoticeHistoryQueryModel> getDao() {
		return noticeHistoryMapper;
	}

	/**
	 * 新增历史记录信息
	 */
	@Override
	public int insertSelective(NoticeHistory noticeHistory) {
		noticeHistory.setId(UUID.randomUUID().toString());
		return super.insertSelective(noticeHistory);
	}

	/**
	 * 功能描述:通知信息分页查询
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:56:16
	 */
	@Override
	public Page<NoticeHistory> listByPage(NoticeHistoryQueryModel noticeHistoryQM) {
		List<NoticeHistory> noticeHistorys = noticeHistoryMapper.listByPage(noticeHistoryQM);
		noticeHistoryQM.getPageModel().setRows(noticeHistorys);
		return noticeHistoryQM.getPageModel();
	}

	@Override
	public List<NoticeHistory> getNoticeHistorysByUserId(String userId) {
		return noticeHistoryMapper.getNoticeHistorysByUserId(userId);
	}
}
