
package com.lantaiyuan.ebus.service;

import java.util.List;

import com.lantaiyuan.ebus.model.Favoriate;

public interface TaskTimerServiceI {
    /**
     * 功能描述:若30分钟没有付款则更改订单表的状态为订单失效
     * 作者:温海金
     * 最后更改时间 : 2016年11月21日 上午10:28:42
     * 方法说明: cron表达式：* * * * * *（共6位，使用空格隔开，具体如下） cron表达式：*(秒0-59) *(分钟0-59) *(小时0-23)*(日期1-31) *(月份1-12或是JAN-DEC) *(星期1-7或是SUN-SAT)
     * @Scheduled(cron="0/5 * * * * ? ") //每5秒执行一次
     */
    public int updateOrderStatus2Invalid();
    
    /**
     * 功能描述:定时器实现车票是否提供给用户购买的状态修改（每天凌晨12点执行一次）
     * 状态修改规则：小于当前日期且isOpenToBuy=1的票改为isOpenToBuy=0（不开放购买）
     * 作者:温海金
     * 最后更改时间 : 2016年11月22日 下午4:02:35
     */
    public int updateTickcetStatusBeforeNow();
    
    /**
     * 功能描述:定时器实现车票是否提供给用户购买的状态修改
     * 状态修改规则：开放购买当前日期到当月最后一天的票 (系统初始化的时候执行一次)
     * 作者:温海金
     * 最后更改时间 : 2016年11月22日 下午4:02:35
     */
    public int updateTickcetStatus4now2lastDay();
    
    /**
     * 功能描述:定时器实现车票是否提供给用户购买的状态修改
     * 状态修改规则：开放购买下个月的票(每月27号执行一次)
     * 作者:温海金
     * 最后更改时间 : 2016年11月22日 下午4:02:35
     */
    public int updateTickcetStatusNextMonth();
    
    /**
     * 用户当前日期之前且票状态为1（有效）-*代表其未乘车* 的车票，状态改为3(过期)
     * 作者:YvanTan
     * 最后更改时间 : 2016年11月25日 下午4:02:35
     */
    public int modifyTickcetStatusToExpired();
    public void modifyUnPaidTickcetOrderStatus();

    /**
     * 功能描述:每天凌晨定时清空用户上车提醒动态表JPUSH_ALREADY_ALERT_DYNAMIC
     * 作者:温海金
     * 最后更改时间 : 2017年2月24日 上午10:41:17
     */
    public void clearTheDataOfAlreadyAlert();

    /**
     * 功能描述: 每天凌晨定时清空用户下车提醒动态表中已经提醒过的数据#DELETE from t_trave_car_setting where IS_REMIND = TRUE;
     * 作者:温海金
     * 最后更改时间 : 2017年3月21日 下午6:01:29
     */
    public void clearTheDataInLeavingCarAlert();

    /**
     * 修改车票状态已经使用
     * @param ticketId
     * @return
     */
	public int updateStatusToUsed(String ticketId);
	
	public List<Favoriate> findFavoriateByRouteAndCity(String routeId,String cityCode);

	public void modifyUnPaidTravelOrderStatus();
}
