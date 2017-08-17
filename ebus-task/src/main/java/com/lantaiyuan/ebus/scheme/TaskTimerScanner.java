package com.lantaiyuan.ebus.scheme;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lantaiyuan.ebus.service.TaskTimerServiceI;

/**
 * 描述:定时器 作者:温海金 最后更改时间:下午5:29:49
 */
@Component
public class TaskTimerScanner implements InitializingBean {
	private static Logger logger = LoggerFactory.getLogger(TaskTimerScanner.class);
	@Resource
	private TaskTimerServiceI taskTimerService;

	/**
	 * 功能描述:若30分钟没有付款则更改订单表的状态为订单失效 同时将包车状态改为已取消 作者:温海金 最后更改时间 : 2016年11月21日
	 * 上午10:28:42 方法说明: cron表达式：* * * * * *（共6位，使用空格隔开，具体如下） cron表达式：*(秒0-59)
	 * *(分钟0-59) *(小时0-23)*(日期1-31) *(月份1-12或是JAN-DEC)
	 * *(星期1-7或是SUN-SAT) @Scheduled(cron="0/5 * * * * ? ") //每5秒执行一次
	 */
	@Scheduled(cron = "${task.updateOrderStatus2Invalid}") 
	public int updateOrderStatus2Invalid() {
		int count = taskTimerService.updateOrderStatus2Invalid();
		logger.debug("-------------------30分钟未付款取消订单定时器(" + count + "条记录得到更新)--------------------------");
		return count;
	}

	/**
	 * 功能描述:定时器实现车票是否提供给用户购买的状态修改（每天凌晨12点执行一次）
	 * 状态修改规则：小于当前日期且isOpenToBuy=1的票改为isOpenToBuy=0（不开放购买） 作者:温海金 最后更改时间 :
	 * 2016年11月22日 下午4:02:35
	 */
	@Scheduled(cron = "${task.updateTickcetStatusBeforeNow}")
	public int updateTickcetStatusBeforeNow() {
		int count = taskTimerService.updateTickcetStatusBeforeNow();
		logger.debug("-------------------每天凌晨12将过去的票置为关闭状态(" + count + "条记录得到更新)--------------------------");
		return count;
	}

	/**
	 * 功能描述:定时器实现车票是否提供给用户购买的状态修改 状态修改规则：开放购买当前日期到当月最后一天的票 (系统初始化的时候执行一次) 作者:温海金
	 * 最后更改时间 : 2016年11月22日 下午4:02:35
	 */
	public int updateTickcetStatus4now2lastDay() {
		int count = taskTimerService.updateTickcetStatus4now2lastDay();
		logger.debug("-------------------初始化当天到月底的票为开放购买(执行了" + count + "条记录)--------------------------");
		return count;
	}

	/**
	 * 功能描述:定时器实现车票是否提供给用户购买的状态修改 状态修改规则：开放购买下个月的票(每月27号执行一次) 作者:温海金 最后更改时间 :
	 * 2016年11月22日 下午4:02:35
	 */
	@Scheduled(cron = "${task.updateTickcetStatusNextMonth}")
	public int updateTickcetStatusNextMonth() {
		int count = taskTimerService.updateTickcetStatusNextMonth();
		logger.debug("-------------------每月27号开放下月的票(执行了" + count + "条记录)--------------------------");
		return count;
	}

	/**
	 * 功能描述:每天凌晨定时清空用户上车提醒动态表JPUSH_ALREADY_ALERT_DYNAMIC 作者:温海金 最后更改时间 :
	 * 2017年2月24日 上午10:41:17
	 */
	@Scheduled(cron = "${task.clearTheDataOfAlreadyAlert}")
	public void clearTheDataOfAlreadyAlert() {
		taskTimerService.clearTheDataOfAlreadyAlert();
	}

	/**
	 * 功能描述: 每天凌晨定时清空用户下车提醒动态表中已经提醒过的数据#DELETE from t_trave_car_setting where
	 * IS_REMIND = TRUE; 作者:温海金 最后更改时间 : 2017年3月21日 下午6:01:29
	 */
	@Scheduled(cron = "${task.clearTheDataInLeavingCarAlert}")
	public void clearTheDataInLeavingCarAlert() {
		taskTimerService.clearTheDataInLeavingCarAlert();
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		// 系统初始化时，开放购买当前日期到当月最后一天的票
		updateTickcetStatus4now2lastDay();
		logger.debug("-------------------开放购买当前日期到当月最后一天的票--------------------------");
	}

	/**
	 * 用户当前日期之前且票状态为1（有效）-*代表其未乘车* 的车票，状态改为3(过期) 作者:YvanTan 最后更改时间 : 2016年11月25日
	 * 下午4:02:35
	 */
	@Scheduled(cron = "${task.modifyTickcetStatusToExpired}")
	public int modifyTickcetStatusToExpired() {
		int count = taskTimerService.modifyTickcetStatusToExpired();
		logger.info("-------------------更新用户过期未使用的车票(执行了" + count + "条记录)--------------------------");
		logger.debug("-------------------更新用户过期未使用的车票(执行了" + count + "条记录)--------------------------");
		return count;
	}

	/**
	 * modifyUnPaidTickcetOrderStatus 若10分钟没有付款的车票订单则更改订单表的号码状态为订单失效 作者:YvanTan
	 * 最后更改时间 : 2016年11月25日 下午4:02:35
	 */
	@Scheduled(cron = "${task.modifyUnPaidTickcetOrderStatus}")
	public void modifyUnPaidTickcetOrderStatus() {
		taskTimerService.modifyUnPaidTickcetOrderStatus();
	}
	
	/**
	 * modifyUnPaidTravelOrderStatus 用户若60分钟没有付款 ,周边游订单则更改订单失效，票池重新计算
	 * 作者:YvanTan
	 * 最后更改时间 : 2017年8月1日 下午4:02:35
	 */
	@Scheduled(cron = "${task.modifyUnPaidTravelOrderStatus}")
	public void modifyUnPaidTravelOrderStatus() {
		taskTimerService.modifyUnPaidTravelOrderStatus();
	}


}
