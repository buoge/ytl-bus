package com.lantaiyuan.ebus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.model.Notice;
import com.lantaiyuan.ebus.model.NoticeQueryModel;

@Mapper
public interface NoticeMapper extends BaseDAO<Notice, NoticeQueryModel> {

	List<Notice> listByPage(NoticeQueryModel noticeQM);
	/**
	 * 功能描述:条件查询通知信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月18日 下午5:55:18
	 */
	List<Notice> listByCondition(NoticeQueryModel noticeQM);
    
}