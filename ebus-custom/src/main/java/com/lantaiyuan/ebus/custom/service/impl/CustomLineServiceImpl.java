package com.lantaiyuan.ebus.custom.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.beanutils.BeanUtils;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.druid.util.StringUtils;
import com.lantaiyuan.ebus.common.constants.PayConstants;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.util.RandomGeneratorUtil;
import com.lantaiyuan.ebus.custom.dao.BaseRouteMapper;
import com.lantaiyuan.ebus.custom.dao.CustomLineApplicationMapper;
import com.lantaiyuan.ebus.custom.dao.CustomLineMapper;
import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.BookBus;
import com.lantaiyuan.ebus.custom.model.BookBusQueryModel;
import com.lantaiyuan.ebus.custom.model.CustomLine;
import com.lantaiyuan.ebus.custom.model.CustomLineApplication;
import com.lantaiyuan.ebus.custom.model.CustomLineApplicationQueryModel;
import com.lantaiyuan.ebus.custom.model.CustomLineQueryModel;
import com.lantaiyuan.ebus.custom.model.TicketStatus;
import com.lantaiyuan.ebus.custom.model.enummodel.CustomLineStatusEnum;
import com.lantaiyuan.ebus.custom.service.CustomLineServiceI;
import com.lantaiyuan.ebus.custom.service.OrderServiceI;
import com.lantaiyuan.ebus.realtime.service.JpushServiceI;

/**
 * 描述:公交专线业务类
 * 作者:温海金
 * 最后更改时间:下午2:48:25
 */
@Service("customLineService")
public class CustomLineServiceImpl extends BaseService<CustomLine, CustomLineQueryModel> implements CustomLineServiceI {

	@Resource
	private CustomLineMapper customLineMapper;

	@Resource
	private CustomLineApplicationMapper customLineApplicationMapper;

	@Resource
	private BaseRouteMapper baseRouteMapper;

	@Resource
	private JpushServiceI jpushService;
	@Resource
	private OrderServiceI orderService;

	@Override
	public BaseDAO<CustomLine, CustomLineQueryModel> getDao() {
		return customLineMapper;
	}

	private static Logger logger = LoggerFactory.getLogger(CustomLineServiceImpl.class);

	/**
	 * 分页查询定制公交
	 */
	@Override
	public Page<CustomLine> findCustomLineListByPage(int page, int pageSize, int status, String cityCode, String startStation, String endStation) {
		CustomLineQueryModel model = new CustomLineQueryModel();
		model.getPageModel().setNowPage(page);
		model.getPageModel().setPageShow(pageSize);
		model.setStartstation(startStation);
		model.setEndstation(endStation);
		model.setCitycode(cityCode);
		model.setStatus(status);
		List<CustomLine> customLines = customLineMapper.findCustomLineListByPage(model);
		model.getPageModel().setRows(customLines);
		return model.getPageModel();
	}

	@Override
	public CustomLine selectByPrimaryKey(String id) {
		CustomLine customLine = customLineMapper.selectByPrimaryKey(id);
		return handleCustomLines(customLine);
	};

	/**
	 * 数据处理，为当前线路补充一些信息供前端展示
	 */
	private CustomLine handleCustomLines(CustomLine customLine) {
		//设置当前参与人数
		customLine.setCurrentcount(findPaticalNumByLineId(customLine.getId()));
		//设置全程预估时间
		customLine.setBudgettime(getBugetTimeIfNotAssign(customLine));
		return customLine;
	}

	/**
	 * 功能描述:查询当前用户是否有参与该路线
	 * 作者:温海金
	 * 最后更改时间 : 下午2016-11-17 2:19:31
	 */
	private Boolean getCurrentUserPartIn(Integer userId, String lineId) {
		//设置当前用户是否参与这条专线
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("lineId", lineId);
		int count = customLineMapper.getApplicationCountByUserIdAndLineId(paramMap);
		return count > 0;
	}

	/**
	 * 查找当前专线走完全程预计耗时
	 * 如果线路本身有设置全程预估时间则直接返回，否者采用最简单的算法按每小时30公里的速度计算后返回
	 */
	public int getBugetTimeIfNotAssign(CustomLine customLine) {
		Integer bugetTime = customLine.getBudgettime();
		if ((customLine.getBudgettime() == null || customLine.getBudgettime() <= 0) && customLine.getDistance() != null) {
			if (customLine.getDistance() != null) {
				bugetTime = (customLine.getDistance().intValue() / SysGlobalConstants.SPEED) * SysGlobalConstants.SECONDS_PER_MIN;
			}
		} else {
			bugetTime = 0;
		}
		return bugetTime;
	}

	/**
	 * 查找当前专线参与人员数量（包括申请人和加入人员）
	 */
	public int findPaticalNumByLineId(String lineId) {
		return customLineApplicationMapper.findPaticalNumByLineId(lineId);
	}

	/**
	 * 根据用户ID查找可能关注的专线
	 */
	@Override
	public List<CustomLine> findMayFocLineByUserId(Integer userId, String citycode) {
		CustomLineApplicationQueryModel condition = new CustomLineApplicationQueryModel();
		condition.setUserid(userId);
		List<CustomLineApplication> customLineApplis = customLineApplicationMapper.findObjectsByPage(condition);
		Set<String> customLineIds = new HashSet<String>();
		customLineApplis.forEach(customLineAppli -> {
			customLineIds.add(customLineAppli.getLineid());
		});
		Map<String, Object> queryMap = new HashMap<>();
		List<CustomLine> customLines = null;
		if (customLineIds.size() > 0) {
			queryMap.put("ids", customLineIds);
		}
		queryMap.put("citycode", citycode);
		if (!CollectionUtils.isEmpty(customLineIds) && queryMap != null && !queryMap.isEmpty()) {
			customLines = customLineMapper.findMayFocLine(queryMap);
			for (CustomLine customLine : customLines) {//数据处理，填充一些展示信息
				handleCustomLines(customLine);
			}
		}
		return CollectionUtils.isEmpty(customLines) ? Collections.emptyList() : customLines;
	}

	@Override
	public List<CustomLine> findAllCustomLine() {
		List<CustomLine> customLines = customLineMapper.findAllCustomLine();
		for (CustomLine customLine : customLines) {
			handleCustomLines(customLine);
		}
		return customLines;
	}

	@Override
	public List<CustomLine> findCustomLineByStartAndDistinctPlace(Integer userid, BigDecimal startlongitude, BigDecimal startlatitude, BigDecimal endlongitude,
			BigDecimal endlatitude, String citycode, Integer status) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startlongitude", startlongitude);//设置起点经度
		paramMap.put("startlatitude", startlatitude);//设置起点纬度

		paramMap.put("endlongitude", endlongitude);//设置起点经度
		paramMap.put("endlatitude", endlatitude);//设置起点纬度

		paramMap.put("citycode", citycode);//城市编码
		paramMap.put("status", status);//线路状态

		//这边查出来的线路是包括两个方向的线路
		List<CustomLine> customLines = customLineMapper.findCustomLineByStartAndDistinctPlace(paramMap);
		//再进行一层过滤，出发地到起点的距离要比目的地到起点的距离小
		List<CustomLine> result = new ArrayList<CustomLine>();

		for (CustomLine entity : customLines) {
			BigDecimal firstStationLongitude = entity.getStartlongitude();
			BigDecimal firstStationLatitude = entity.getStartlatitude();

			double distance2start = Math.pow((startlongitude.doubleValue() - firstStationLongitude.doubleValue()), 2)
					+ Math.pow((startlatitude.doubleValue() - firstStationLatitude.doubleValue()), 2);

			double distance2end = Math.pow((endlongitude.doubleValue() - firstStationLongitude.doubleValue()), 2)
					+ Math.pow((endlatitude.doubleValue() - firstStationLatitude.doubleValue()), 2);

			if (distance2start < distance2end) {
				result.add(entity);
			}
		}
		//将符合条件的众筹中的线路也查出来
		List<CustomLine> tempLines = customLineMapper.findTempLineByStartAndDistinctPlace(paramMap);
		result.addAll(tempLines);
		//加入当前线路参与人及预计到达时间
		for (CustomLine customLine : result) {
			handleCustomLines(customLine);
			//设置当前用户是否有参与当前线路
			if (!StringUtils.isEmpty(customLine.getId()))
				customLine.setIsPartIn(getCurrentUserPartIn(userid, customLine.getId()));
		}
		//为返回结果根据状态进行排序处理
		Collections.sort(result, new Comparator<CustomLine>() {
			@Override
			public int compare(CustomLine o1, CustomLine o2) {
				return o1.getStatus().compareTo(o2.getStatus());
			}
		});
		return result;
	}

	/**
	 * 描述方法：更改专线状态
	 * 使用场景：审批专线开通、不开通、参与人数达到预定人数 
	 * 参数说明：lineid:线路id; status:线路状态(1-众筹中(默认) 2-待处理 3-不开通 4-已开通)
	 */
	@Override
	public void updateLineStatus(String lineid, Integer status) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("lineid", lineid);
		paramMap.put("status", status);
		//if(status==4)及改操作为开通操作，则将该信息添加到base_route表中
		if (status == CustomLineStatusEnum.ALREAD_OPEN.value()) {
			CustomLine origEntity = customLineMapper.selectByPrimaryKey(lineid);
			BaseRoute destEntity = new BaseRoute();
			try {
				BeanUtils.copyProperties(destEntity, origEntity);
				destEntity.setId(null);//id不复制，直接在base_route表中以自增形式生成
				destEntity.setDirection(0);//方向都设为0
				baseRouteMapper.insertSelective(destEntity);
			} catch (IllegalAccessException | InvocationTargetException e) {
				logger.error("线路保存失败：", e);
			}
		}
		customLineMapper.updateLineStatus(paramMap);
	}

	/**
	 * 描述方法：保存专线实体
	 * 使用场景：申请专线
	 */
	@Override
	public int insertSelective(CustomLine customLine) {
		//为实体类生成一个String类型的routeId
		customLine.setRouteid(RandomGeneratorUtil.getRandomStringByLength(20));
		return customLineMapper.insertSelective(customLine);
	}

	/**
	 * 描述方法：当参与人数达到指定人数的时候，专线状态更改为待处理
	 * 使用场景：在加入专线的时候判断：customLineService.updateLineStatusIfCountFull(lineid);
	 * 参数说明：lineid:线路id; 
	 */
	@Override
	public void updateLineStatusIfCountFull(String lineid) {
		CustomLine customLine = this.selectByPrimaryKey(lineid);
		handleCustomLines(customLine);
		if (customLine.getCurrentcount() == customLine.getCount()) {
			this.updateLineStatus(lineid, CustomLineStatusEnum.PRE_HANDLE.value());
		}
	}

	@Override
	public String queryCustomLinIdByRouteId(String routeId) {
		return customLineMapper.queryCustomLinIdByRouteId(routeId);
	}

	@Override
	public String queryCustomLinIdByRouteId(String routeId, String citycode) {
		return customLineMapper.queryCustomLinIdByRouteId(routeId, citycode);
	}

	@Override
	public Page<BookBus> findOrderByPage(BookBusQueryModel model, int page) {
		model.getPageModel().setNowPage(page);
		List<BookBus> list = customLineMapper.findOrderByPage(model);
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}

	@Override
	public Page<BookBus> findVerifyOrderByPage(BookBusQueryModel model, int page) {
		model.getPageModel().setNowPage(page);
		List<BookBus> list = customLineMapper.findVerifyOrderByPage(model);
		model.getPageModel().setRows(list);
		return model.getPageModel();
	}

	@Override
	public boolean refuseRefund(String orderNo, String orderDetailId) {
		int a = customLineMapper.updateOrderRefuseRefund(orderNo);
		int b = customLineMapper.updateTicketRefuseRefund(orderDetailId);
		return a >= 1 && b >= 1;
	}

	@Override
	public boolean applyRefund(String orderNo, String orderDetailId, String remark) {
		List<TicketStatus> ticketStatusList = orderService.queryTicketDetailByOrderNo(orderNo);
		for (TicketStatus ticketStatus : ticketStatusList) {
			if (!"1".equals(ticketStatus.getTicketStatus())) {//如果有任何一张车票不是有效状态，后台web管理不退票 走APP前台
				return false;
			}
		}
		int a = customLineMapper.updateOrderApplyRefund(orderNo, remark);
		int b = customLineMapper.updateTicketApplyRefund(orderDetailId);
		return a >= 1 && b >= 1;
	}

	@Override
	public boolean approveRefund(String orderNo, String orderDetailId) {
		List<TicketStatus> ticketStatusList = orderService.queryTicketDetailByOrderNo(orderNo);
		String ticketIds = "";
		for (TicketStatus ticketStatus : ticketStatusList) {
			ticketIds = ticketIds.concat("-").concat(ticketStatus.getTicketId());
		}
		ticketIds = ticketIds.substring(1);
		String userId = customLineMapper.queryUserIdByOrderNo(orderNo);
		Map<String, Object> refundMap = orderService.refundTicket(Integer.valueOf(userId), orderNo, ticketIds);
		//退款：1-成功
		if ("1".equals(refundMap.get(PayConstants.PARAM_STATUS))) {
			int a = customLineMapper.updateOrderApproveRefund(orderNo);
			int b = customLineMapper.updateTicketApproveRefund(orderDetailId);
			return a >= 1 && b >= 1;
		} else {
			return false;
		}
	}

	@Override
	public void apply(CustomLine customLine, CustomLineApplication customLineApplication) {
		customLineMapper.insertSelective(customLine);
		customLineApplicationMapper.insertSelective(customLineApplication);
	}

	@Override
	public int openCustomLine(String id) {
		// TODO 1.对接调度系统实现专线开通功能
		//2.对参与该专线的人员发送消息提醒
		List<Integer> userIds = customLineMapper.getPaticalUserIdByLineId(id);
		jpushService.jpushByUserIds(userIds, "您参与的专线申请已通过审核，请您持续关注！", null);
		return 0;
	}

	/**
	 * 功能描述:根据用户当前位置信息获取经过该位置的专线
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月17日 下午6:36:44
	 */
	@Override
	public List<CustomLine> findCustomRoutesByCurrentPlace(BigDecimal startlongitude, BigDecimal startlatitude, String citycode) {
		return customLineMapper.findCustomRoutesByCurrentPlace(startlongitude, startlatitude, citycode);
	}

}
