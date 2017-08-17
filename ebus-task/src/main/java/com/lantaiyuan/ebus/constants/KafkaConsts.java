package com.lantaiyuan.ebus.constants;

/**
 * 描述：kafka相关的常量类
 * @author YvanTan
 * @version 1.3.0
 *
 */
public class KafkaConsts {
	
	/**
	 * 参数：packetType 网关发送数据包的类型
	 */
	public static final String  PARAM_PACKE_TTYPE = "packetType";
	
	/**
	 *数据包为车票类型的标志
	 */
	public static final String TICKET_PACKAGE = "LTY-P";

	/**
	 * 参数：车票唯一性Id标志，并不是指真正意义上的订单号
	 */
	public static final String  PARAM_ORDER_NUMBER = "orderNumber";
	
	/**
	 * 线路方向
	 */
	public static final String  PARAM_DIRECTION = "direction";

	/**
	 * 用户上车站台的站序
	 */
	public static final String  PARAM_ONBUS_STATIONNO = "onBusStationNo";

	/**
	 * 上车时间
	 */
	public static final String  PARAM_ONBUS_TIME = "onBusTime";
}
