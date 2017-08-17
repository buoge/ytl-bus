package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;

import com.lantaiyuan.ebus.custom.model.Notice;
import com.lantaiyuan.ebus.custom.model.NoticeQueryModel;
import com.lantaiyuan.ebus.custom.model.SysUser;
import com.lantaiyuan.ebus.custom.model.TrafficInfo;
import com.lantaiyuan.ebus.realtime.model.Favoriate;
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

	/**
	 * 功能描述:新增紧急通知
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月27日 上午11:51:07
	 */
	int insertAndPublishNotice(Notice notice, SysUser user);
	
	/**
	 * 功能描述:更新紧急通知
	 * 作者:温海金
	 * 最后更改时间 : 2017年4月27日 上午11:51:07
	 */
	int updateSelective(Notice notice, SysUser user);
	public List<Favoriate> findFavoriateByRouteAndCity(String routeId,String cityCode);

	void uploadTraffic(TrafficInfo trafficInfo);

	/**
	 * 功能描述:获取当前后台系统用户所在城市
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月16日 下午4:52:10
	 */
	String getCityNameByCurrentUser(SysUser currentUser);
}
