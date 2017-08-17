/**
* <p>Title: MySettingsI.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.service;


import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.MyTrail;
import com.lantaiyuan.ebus.custom.model.MyTrailQueryModel;
import com.lantaiyuan.ebus.custom.model.MyTrailSchedule;
import com.lantaiyuan.ebus.custom.model.mytrail.MyTrailDetail;

/**
* <p>Title: MySettingsI</p>
* <p>Description: 我的设置业务逻辑接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年2月18日 下午5:24:27
*/
public interface MySettingsServiceI extends BaseServiceI<MyTrail, MyTrailQueryModel>{
	MyTrail getMyTrailById(String id);
	
	/**
	 * 功能描述:根据用户Id查看我的行程列表
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月23日 下午5:08:39
	 */
	List<MyTrailSchedule> selectByUserId(Integer userId);

	/**
	 * 功能描述:根据行程ID拼装行程详情
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月24日 下午5:18:17
	 */
	MyTrailDetail getMyTrailDetail(String entityId);
}
