package com.lantaiyuan.ebus.carpool.timer;

import com.lantaiyuan.ebus.carpool.service.UserOdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lantaiyuan.ebus.carpool.service.TaskTimerServiceI;

/***
 * 
* <p>Title: TaskTimerScanner</p>
* <p>Description: 业务定时器</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年7月13日 下午1:48:40
 */
@Component
@EnableScheduling
public class TaskTimerScanner implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(TaskTimerScanner.class);

	@Autowired
	private TaskTimerServiceI taskTimerService;

	@Autowired
	private UserOdService userOdService;

	/**
	 * 功能描述:若30分钟没有付款则更改订单表的状态为订单失效 同时将包车状态改为已取消 作者:温海金 最后更改时间 : 2016年11月21日
	 * 上午10:28:42 方法说明: cron表达式：* * * * * *（共6位，使用空格隔开，具体如下） cron表达式：*(秒0-59)
	 * *(分钟0-59) *(小时0-23)*(日期1-31) *(月份1-12或是JAN-DEC)
	 * *(星期1-7或是SUN-SAT) @Scheduled(cron="0/5 * * * * ? ") //每5秒执行一次
	 */
	@Scheduled(cron = "${task.carpoolOrderSentToKafkaTimer}") 
	public void carpoolOrderSentToKafkaTimer() {
		int count = taskTimerService.handleUsersInitiatingCarpool(1);
		logger.warn("-------------------向kafka发送" + count + "条用户拼车基础信息--------------------------");
	}
	
	/***
	 * 
	* <p>Title: carpoolOrderInvokeRestTimer</p>
	* <p>Description: 用户加入已有拼业务</p>
	 */
	@Scheduled(cron = "${task.carpoolOrderInvokeRestTimer}") 
	public void carpoolOrderInvokeRestTimer() {
		int count = taskTimerService.handleUsersJoiningCarpool(2);
		logger.warn("-------------------调用RESTfull发送" + count + "条用户加入拼车信息--------------------------");
	}
	
	/***
	 * 
	* <p>Title: carpoolOrderInvokeRestTimer</p>
	* <p>Description: 用户是否需要补差价（多退少补）</p>
	 */
	@Scheduled(cron = "${task.carpoolOrderCompensationTimer}") 
	public void carpoolOrderCompensationTimer() {
		int count = taskTimerService.handleUsersCompensatingCarpool(2, 0);
		logger.warn("-------------------需要补差价记录" + count + "条--------------------------");
	}

	@Scheduled(cron = "${task.od.delete.cron}")
	public void deleteOldOd() {
		int count = userOdService.deleteOldOD();
		logger.warn("-------------------删除了" + count + "条7天前的od记录----------------------");
	}
	
	@Scheduled(cron = "${task.drawback}") 
	public void carpoolDrawbackTimer() {
		int count = taskTimerService.handleUsersDrawbackCarpool();
		logger.warn("-------------------需要退款记录" + count + "条--------------------------");
	}

	/***
	* <p>Title: afterPropertiesSet</p>
	* <p>Description: 定时器启动后初始化</p>
	* @throws Exception
	*/
	@Override
	public void afterPropertiesSet() throws Exception {
		//定时器启动后初始化
		logger.info("初始化........");
	}
}
