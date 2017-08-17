package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.NoticePoint;
import com.lantaiyuan.ebus.custom.model.NoticePointQueryModel;

/**
 * 描述:地图打点dao层
 * 作者:温海金
 * 最后更改时间:上午9:13:55
 */
public interface NoticePointMapper extends BaseDAO<NoticePoint, NoticePointQueryModel>{

	/**
	 * 功能描述:根据通知Id查找地图打点
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月17日 上午9:11:46
	 */
	List<NoticePoint> getPointsByNoticeId(@Param("noticeId") String noticeId);
    
}