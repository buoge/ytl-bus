package com.lantaiyuan.ebus.custom.service;


import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.NoticePoint;
import com.lantaiyuan.ebus.custom.model.NoticePointQueryModel;
/**
 * 描述:紧急通知业务接口
 * 作者:温海金
 * 最后更改时间:下午4:04:55
 */
public interface NoticePointServiceI extends BaseServiceI<NoticePoint, NoticePointQueryModel> {
	/**
	 * 功能描述:根据通知Id查找地图打点
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月17日 上午9:11:46
	 */
	List<NoticePoint> getPointsByNoticeId(String id);

	
}
