package com.lantaiyuan.ebus.custom.model.enummodel;

/**
 * 
 * @Title: CMDEnum.java
 * @Description:(数据采集枚举类型)
 * @author 刘伟 15818570028@163.com
 * @date 2017年2月15日 下午6:03:01
 * @version V1.2.0
 */
public enum CMDEnum {
	DEFAULT(100, "default", "默认"),

	INSTALL(101, "install", "安装APP"),
	
	START(102, "startApp", "启动APP"),

	ROUTE_DETAIL(106, "route_detail", "查看线路详情"),
	
	TRANSFER(111, "transfer", "换乘方案查询"),
	
	FIND_MODEL(117, "find_model", "查看发现"),
	
	BUS_EVALUTION(119, "bus_evaluation", "车辆评价"),
	
	STATION_EVALUTION(120, "station_evaluation", "站台评价"),
	
	LOGIN(121, "login", "登录"),
	
	EBOARD_SEARCH(110,"eboard_search","查看电子站牌"),
	
	FAVORIATE_ADD(116,"favoriate_add","新增收藏"),
	
	INTERVAL_PER10S(103,"interval_10s_position","每10s获取用户位置"),
    
    	NEAR_STATION(112,"near_station","附近站点"),//保存到mongDb的附近站点表
    	
    	NEAR_STATION_MAP_VIEW(113,"near_station","附近站点-地图查看"),//保存到mongDb的附近站点表
    	
    	NEAR_STATION_WALKING_NAVIGATION(114,"near_station","附近站点-步行导航"),//保存到mongDb的附近站点表
    	
    	CUSTOMLINE_STARTEND_SEARCH(118,"customline_startend_search","专线起点终点搜索");
	
	/**
	 * 命令类型的值
	 */
	private int value;
	/**
	 * 存储到mongodb的表名
	 */
	private String tableName;
	/**
	 * 详情描述
	 */
	private String description;

	private CMDEnum(int value, String tableName, String description) {
		this.value = value;
		this.tableName = tableName;
		this.description = description;
	}

	public int value() {
		return value;
	}

	public String description() {
		return description;
	}

	public String tableName() {
		return tableName;
	}

	public static CMDEnum valueOf(int value) {
		for (CMDEnum type : CMDEnum.values()) {
			if (type.value() == value) {
				return type;
			}
		}
		return DEFAULT;
	}
}