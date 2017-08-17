package com.lantaiyuan.ebus.custom.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.custom.dao.BookTicketMapper;
import com.lantaiyuan.ebus.custom.dao.TickcetSchedualMapper;
import com.lantaiyuan.ebus.custom.model.BookTicket;
import com.lantaiyuan.ebus.custom.model.TickcetSchedual;
import com.lantaiyuan.ebus.custom.model.TickcetSchedualInfo;
import com.lantaiyuan.ebus.custom.model.TickcetSchedualQueryModel;
import com.lantaiyuan.ebus.custom.service.CustomLineServiceI;
import com.lantaiyuan.ebus.custom.service.TickcetSchedualServiceI;

/**
 * 
 * @ClassName: TickcetSchedualServiceImpl 
 * Company:深圳市蓝泰源信息技术股份有限公司
 * @author Yuan.Tan
 * @date 2016年12月20日 下午8:52:48
 */
@Service("tickcetSchedualService")
public class TickcetSchedualServiceImpl extends BaseService<TickcetSchedual, TickcetSchedualQueryModel>
		implements TickcetSchedualServiceI {
	@Resource
	private TickcetSchedualMapper tickcetSchedualMapper;
	@Resource
	private CustomLineServiceI customLineService;
	@Resource
	private BookTicketMapper bookTicketMapper;
	private static Logger logger = LoggerFactory.getLogger(TickcetSchedualServiceImpl.class);

	@Override
	public BaseDAO<TickcetSchedual, TickcetSchedualQueryModel> getDao() {
		return tickcetSchedualMapper;
	}

	@Override
	public List<TickcetSchedualInfo> queryTicketByRouteId(String userid, String routeid, String citycode) {
		String lineId = customLineService.queryCustomLinIdByRouteId(routeid, citycode);
		lineId = lineId == null ? "" : lineId;
		// 查询车辆是否有票可售
		List<TickcetSchedual> schedualList = tickcetSchedualMapper.queryTicketByRouteId(lineId, citycode);
		List<TickcetSchedualInfo> tickcetSchedualInfos = new LinkedList<>();
		if (CollectionUtils.isEmpty(schedualList)) {
			return tickcetSchedualInfos;
		}
		// 查询用户在该城市是否买票且未乘车
		List<BookTicket> bookTicketList = bookTicketMapper.queryBookedTicket(userid, lineId, citycode);
		// 用户买票张数为0
		if (CollectionUtils.isEmpty(bookTicketList)) {
			schedualList.forEach(TickcetSchedual -> {
				TickcetSchedualInfo TickcetSchedualInfo = new TickcetSchedualInfo();
				BeanUtils.copyProperties(TickcetSchedual, TickcetSchedualInfo);
				TickcetSchedualInfo.setIsbooked(SysGlobalConstants.NOT_BOOKED);
				tickcetSchedualInfos.add(TickcetSchedualInfo);
			});
			return tickcetSchedualInfos;
		}
		List<TickcetSchedual> schedualListTemp = new ArrayList<>();
		// 1.查询出已经购票的日期
		bookTicketList.forEach(bookTicket -> {
			schedualList.forEach(tickcetSchedual -> {
				TickcetSchedualInfo TickcetSchedualInfo = new TickcetSchedualInfo();
				BeanUtils.copyProperties(tickcetSchedual, TickcetSchedualInfo);
				if (tickcetSchedual.getServerdate().equals(bookTicket.getTakedate())) {
					TickcetSchedualInfo.setIsbooked(SysGlobalConstants.WAS_BOOKED);// 有买票
					schedualListTemp.add(tickcetSchedual);
					tickcetSchedualInfos.add(TickcetSchedualInfo);
				}
			});
		});
		// 2.去除掉购票的日期，保留未购票的日期
		schedualListTemp.forEach(tickcetSchedual -> {
			schedualList.remove(tickcetSchedual);
		});
		// 3.添加未购票的日期
		schedualList.forEach(tickcetSchedual -> {
			TickcetSchedualInfo TickcetSchedualInfo = new TickcetSchedualInfo();
			BeanUtils.copyProperties(tickcetSchedual, TickcetSchedualInfo);
			TickcetSchedualInfo.setIsbooked(SysGlobalConstants.NOT_BOOKED);// 没有买票
			tickcetSchedualInfos.add(TickcetSchedualInfo);
		});
		// 4 按日期排序
		Collections.sort(tickcetSchedualInfos, new Comparator<TickcetSchedualInfo>() {
			/*
			 * int compare(TickcetSchedualInfo o1, TickcetSchedualInfo o2)
			 * 返回一个基本类型的整型， 返回负数表示：o1 小于o2， 返回正数表示：o1大于o2。
			 */
			public int compare(TickcetSchedualInfo o1, TickcetSchedualInfo o2) {
				Date date1 = null;
				Date date2 = null;
				try {
					date1 = new SimpleDateFormat(SysGlobalConstants.PARAM_YYYY_MM_DD).parse(o1.getServerdate());
					date2 = new SimpleDateFormat(SysGlobalConstants.PARAM_YYYY_MM_DD).parse(o2.getServerdate());
				} catch (ParseException e) {
					logger.error("***ParseException at method:queryTicketByRouteId********" + e.getMessage(),e);
				}
				// 按照serverdate升序排列
				if (date1.getTime() > date2.getTime()) {
					return 1;
				}
				if (date1.getTime() == date2.getTime()) {
					return 0;
				}
				return -1;
			}
		});
		return tickcetSchedualInfos;
	}

	/**
	 * 用户买票支付成功后，根据訂單號碼查詢出线路id和服务日期， 然后对当天天票数做減1操作
	 */
	@Override
	public int updateRemainTicketNum(String orderNo) {
		return tickcetSchedualMapper.updateRemainTicketNum(orderNo);
	}

	/**
	 * 下订单前，查询用户所选日期车次的剩余票数
	 */
	@Override
	public List<TickcetSchedual> getTicketNumBeforeMakeOrder(String routeId, String cityCode, String[] serverDate) {
		int serverDateLength = serverDate.length;
		List<String> dateList = new ArrayList<>();
		for (int i = 0; i < serverDateLength; i++) {
			dateList.add(serverDate[i].trim().substring(1, serverDate[i].trim().length() - 1));
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("routeId", routeId);
		params.put("cityCode", cityCode);
		params.put("serverDate", dateList);
		return tickcetSchedualMapper.getTicketsBeforeMakeOrder(params);
		 
	}

	@Override
	public int addRemainTicketNum(String orderNo) {
		return tickcetSchedualMapper.addRemainTicketNum(orderNo);
	}

}
