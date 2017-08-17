package com.lantaiyuan.ebus.custom.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.custom.dao.NoticePointMapper;
import com.lantaiyuan.ebus.custom.model.NoticePoint;
import com.lantaiyuan.ebus.custom.model.NoticePointQueryModel;
import com.lantaiyuan.ebus.custom.service.NoticePointServiceI;

/**
 * 描述:版本更新业务类 
 * 作者:温海金 
 * 最后更改时间:下午3:50:59
 */
@Service("noticePointService")
public class NoticePointServiceImpl extends BaseService<NoticePoint, NoticePointQueryModel> implements NoticePointServiceI {
	
	
	@Resource
	private NoticePointMapper noticePointMapper;

	public BaseDAO<NoticePoint, NoticePointQueryModel> getDao() {
		return noticePointMapper;
	}

	/**
	 * 功能描述:根据通知Id查找地图打点
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月17日 上午9:11:46
	 */
	@Override
	public List<NoticePoint> getPointsByNoticeId(String noticeId) {
		return noticePointMapper.getPointsByNoticeId(noticeId);
	}

	
}
