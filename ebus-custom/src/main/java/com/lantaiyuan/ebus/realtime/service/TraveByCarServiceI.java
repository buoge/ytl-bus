package com.lantaiyuan.ebus.realtime.service;


import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BaseStationQueryModel;
/**
 * 功能描述:上下车提醒接口定义
 * 作者:温海金
 * 最后更改时间 : 2017年02月17日 上午10:28:42
 */
public interface TraveByCarServiceI extends BaseServiceI<BaseStation,BaseStationQueryModel>{

    /**
     * 功能描述: 定时清理下车提醒定动态表中已经提醒过的数据
     * 作者:温海金
     * 最后更改时间 : 2017年2月22日 下午5:59:26
     */
    int clearTheDataInLeavingCarAlert();
    /**
     * 功能描述:每天凌晨12点定时清空上车提醒数据动态表JPUSH_ALREADY_ALERT_DYNAMIC
     * 作者:温海金
     * 最后更改时间 : 2017年3月4日 上午10:37:56
     */
    int clearTheDataOfAlreadyAlert();
    
    /**
     * 功能描述:根据用户传过来的数据进行上车提醒
     * 作者:温海金
     * 最后更改时间 : 2017年3月2日 下午4:15:51
     */
    void jpushGotoCarByDateCollection(String datacollection);
    
    /**
     * 功能描述:根据用户传过来的数据进行下车提醒
     * 作者:温海金
     * 最后更改时间 : 2017年3月6日 下午3:18:58
     */
    void jpushLeavingCarByDateCollection(String datacollection);
    /**
     * 功能描述:根据用户传过来的数据进行上下车提醒消息推送
     * 作者:温海金
     * 最后更改时间 : 2017年3月24日 下午5:25:34
     */
    void jpush4GoToCarAndLeavingCar(String datacollection);
}
