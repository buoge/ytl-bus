package com.lantaiyuan.ebus.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.dao.NoticeMapper;
import com.lantaiyuan.ebus.model.Notice;
import com.lantaiyuan.ebus.model.NoticeQueryModel;
import com.lantaiyuan.ebus.service.NoticeServiceI;

/**
 * 描述:版本更新业务类 
 * 作者:温海金 
 * 最后更改时间:下午3:50:59
 */
@Service("noticeService")
public class NoticeServiceImpl extends BaseService<Notice, NoticeQueryModel> implements NoticeServiceI {

	@Resource
	private NoticeMapper noticeMapper;

	public BaseDAO<Notice, NoticeQueryModel> getDao() {
		return noticeMapper;
	}

	/**
	 * 功能描述:新增紧急通知信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:56:26
	 */
	@Override
	public int insertSelective(Notice notice) {
		notice.setId(UUID.randomUUID().toString());
		return super.insertSelective(notice);
	}
	
	/**
	 * 功能描述:通知信息分页查询
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:56:16
	 */
	@Override
	public Page<Notice> listByPage(NoticeQueryModel noticeQM) {
		List<Notice> notices = noticeMapper.listByPage(noticeQM);
		noticeQM.getPageModel().setRows(notices);
		return noticeQM.getPageModel();
	}
	
	/**
	 * 功能描述:紧急通知信息条件查询
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午6:34:39
	 */
	@Override
	public List<Notice> listByCondition(NoticeQueryModel noticeQM) {
		return noticeMapper.listByCondition(noticeQM);
	}

}
