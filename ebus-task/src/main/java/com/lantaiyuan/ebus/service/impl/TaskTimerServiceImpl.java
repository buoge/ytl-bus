package com.lantaiyuan.ebus.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.dao.TaskTimerScannerMapper;
import com.lantaiyuan.ebus.model.BaseTravelOrder;
import com.lantaiyuan.ebus.model.Favoriate;
import com.lantaiyuan.ebus.service.TaskTimerServiceI;
import com.xiaoleilu.hutool.db.sql.Order;

/**
 * 描述:定时器实现车票及订单状态更改业务 作者:温海金 最后更改时间:下午2:52:51
 */
@Service("taskTimerService")
public class TaskTimerServiceImpl implements TaskTimerServiceI {
	@Resource
	private TaskTimerScannerMapper taskTimerScannerMapper;


	public TaskTimerScannerMapper getDao() {
		return taskTimerScannerMapper;
	}

	/**
	 * 功能描述:若30分钟没有付款则更改订单表的状态为订单失效 同时将包车状态改为已取消 作者:温海金 最后更改时间 : 2016年11月21日
	 * 上午10:28:42 方法说明: cron表达式：* * * * * *（共6位，使用空格隔开，具体如下） cron表达式：*(秒0-59)
	 * *(分钟0-59) *(小时0-23)*(日期1-31) *(月份1-12或是JAN-DEC)
	 * *(星期1-7或是SUN-SAT) @Scheduled(cron="0/5 * * * * ? ") //每5秒执行一次
	 */
	@Override
	public int updateOrderStatus2Invalid() {
		taskTimerScannerMapper.invalidOrderStatus(new Date());// 更改订单表状态
		return taskTimerScannerMapper.invalidBookBusStatus(new Date());// 更改车辆表状态为已取消
	}

	/**
	 * 功能描述:定时器实现车票是否提供给用户购买的状态修改（每天凌晨12点执行一次）
	 * 状态修改规则：小于当前日期且isOpenToBuy=1的票改为isOpenToBuy=0（不开放购买） 作者:温海金 最后更改时间 :
	 * 2016年11月22日 下午4:02:35
	 */
	@Override
	public int updateTickcetStatusBeforeNow() {
		return taskTimerScannerMapper.updateTickcetStatusBeforeNow(new Date());
	}

	/**
	 * 功能描述:定时器实现车票是否提供给用户购买的状态修改 状态修改规则：开放购买当前日期到当月最后一天的票 (系统初始化的时候执行一次) 作者:温海金
	 * 最后更改时间 : 2016年11月22日 下午4:02:35
	 */
	@Override
	public int updateTickcetStatus4now2lastDay() {
		return taskTimerScannerMapper.updateTickcetStatus4now2lastDay(new Date());
	}

	/**
	 * 功能描述:定时器实现车票是否提供给用户购买的状态修改 状态修改规则：开放购买下个月的票(每月27号执行一次) 作者:温海金 最后更改时间 :
	 * 2016年11月22日 下午4:02:35
	 */
	@Override
	public int updateTickcetStatusNextMonth() {
		return taskTimerScannerMapper.updateTickcetStatusNextMonth();
	}

	@Override
	public int modifyTickcetStatusToExpired() {
		return taskTimerScannerMapper.modifyTickcetStatusToExpired(new Date());
	}

	@Override
	public void modifyUnPaidTickcetOrderStatus() {
		List<String> unPaidOrderNumList = taskTimerScannerMapper.queryUnPaidTicketOrderNum();
		unPaidOrderNumList.forEach(orderNo -> {
			taskTimerScannerMapper.modifyTicketOrderStatus(orderNo);
			taskTimerScannerMapper.addRemainTicketNum(orderNo);
		});
	}

	/**
	 * 功能描述:每天凌晨定时清空用户上车提醒动态表JPUSH_ALREADY_ALERT_DYNAMIC
	 * 作者:温海金
	 * 最后更改时间 : 2017年2月24日 上午10:41:17
	 */
	@Override
	public void clearTheDataOfAlreadyAlert() {
	    taskTimerScannerMapper.clearTheDataOfAlreadyAlert();
	}
	/**
	 * 功能描述: 每天凌晨定时清空用户下车提醒动态表中已经提醒过的数据#DELETE from t_trave_car_setting where IS_REMIND = TRUE;
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月21日 下午6:01:29
	 */
	@Override
	public void clearTheDataInLeavingCarAlert() {
	    taskTimerScannerMapper.clearTheDataInLeavingCarAlert();
	}

	@Override
	public int updateStatusToUsed(String ticketId) {
		return taskTimerScannerMapper.updateStatusToUsed(ticketId);
	}

	@Override
	public List<Favoriate> findFavoriateByRouteAndCity(String routeId, String cityCode) {
		return taskTimerScannerMapper.findFavoriateByRouteAndCity(routeId, cityCode);
	}

	@Override
	public void modifyUnPaidTravelOrderStatus() {
		taskTimerScannerMapper.updateBaseOrderStatusToInvalid();
		List<BaseTravelOrder> travelOrderList = taskTimerScannerMapper.queryUnPaidTravelOrderTicketNum();
		travelOrderList.forEach(order ->{
			taskTimerScannerMapper.updateTravelTicketNumById(order.getId(), order.getNum());
		});
		taskTimerScannerMapper.updateTravelOrderStatusToInvalid();
	}
}
