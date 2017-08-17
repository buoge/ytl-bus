package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.web.bind.annotation.RequestParam;

import com.lantaiyuan.ebus.custom.model.BusNews;
import com.lantaiyuan.ebus.custom.model.BusNewsQueryModel;
import com.lantaiyuan.ebus.custom.model.BusNewsResult;
import com.lantaiyuan.ebus.custom.model.BusNewsResultQueryModel;
import com.lantaiyuan.ebus.custom.model.LostProperty;
import com.lantaiyuan.ebus.custom.model.LostPropertyQueryModel;
import com.lantaiyuan.ebus.custom.model.enummodel.JpushTypeEnum;

/**
 * 公交动态 + 失物招领
 * @author yangyang
 *
 */
public interface BusNewsServiceI extends BaseServiceI<BusNews, BusNewsQueryModel>{

	List<BusNewsResult> getFiveBigNews(String cityCode);


	boolean insertNews(BusNews news, String ip);

	boolean insertFromWebapp(BusNews news);

	boolean updateNews(BusNews news);

	Page<BusNews> findBusNewsByPage(BusNewsQueryModel model, int page, String cityCode);

	boolean deleteBusNews(int id);

	BusNews getNewsDetail(int id);

	String getNewsContent(int id);

	Page<BusNewsResult> findSmallNewsByPage(BusNewsResultQueryModel model, int page);


	Page<LostProperty> findLostPropertyByPage(LostPropertyQueryModel model, int page);
	
	/**
	 * 功能描述:是否显示角标
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月20日 下午2:45:13
	 */
	Boolean showAngle ( String userId, String lastRequestTime, JpushTypeEnum jpushTypeEnum);
}
