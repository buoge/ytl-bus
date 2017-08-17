package com.lantaiyuan.ebus.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;

import com.lantaiyuan.ebus.model.Notice;
import com.lantaiyuan.ebus.model.NoticeQueryModel;

/**
 * 描述:紧急通知业务接口
 * 作者:温海金
 * 最后更改时间:下午4:04:55
 */
public interface NoticeServiceI extends BaseServiceI<Notice, NoticeQueryModel> {

	/**
	 * 功能描述:紧急通知分页查询
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:52:35
	 */
	Page<Notice> listByPage(NoticeQueryModel noticeQM);
	
	/**
	 * 功能描述:紧急通知条件查询
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午4:52:35
	 */
	List<Notice> listByCondition(NoticeQueryModel noticeQM);

}
