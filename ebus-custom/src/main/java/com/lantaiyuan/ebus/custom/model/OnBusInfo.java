package com.lantaiyuan.ebus.custom.model;

import java.util.Date;
import org.lanqiao.ssm.common.model.Model;

/**
 */
/**
 * 用户实际乘车信息表
 * OnBusInfo
 * 数据库表：base_onbusinfo
 */
public class OnBusInfo extends Model {

    /**
	  * @Fields serialVersionUID :
	  */
	private static final long serialVersionUID = 1L;

	/**
     * 车票唯一id，对应base_bookticket的goodsId
     * 表字段 : base_onbusinfo.id
     */
    private String id;

    /**
	
	  * 创建一个新的实例 OnBusInfo. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  * @param id
	  * @param onbustime
	  * @param onbusstationname
	  */
	public OnBusInfo(String id, String onbustime, String onbusstationname) {
		super();
		this.id = id;
		this.onbustime = onbustime;
		this.onbusstationname = onbusstationname;
	}

	/**
     * 实际上车时间
     * 表字段 : base_onbusinfo.onBusTime
     */
    private String onbustime;

    /**
     * 实际上车站点名称
     * 表字段 : base_onbusinfo.onBusStationName
     */
    private String onbusstationname;

    /**
     * 创建时间
     * 表字段 : base_onbusinfo.ceateTime
     */
    private Date ceatetime;

    /**
     * 获取 车票唯一id，对应base_bookticket的goodsId 字段:base_onbusinfo.id
     *
     * @return base_onbusinfo.id, 车票唯一id，对应base_bookticket的goodsId
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 车票唯一id，对应base_bookticket的goodsId 字段:base_onbusinfo.id
     *
     * @param id the value for base_onbusinfo.id, 车票唯一id，对应base_bookticket的goodsId
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 实际上车时间 字段:base_onbusinfo.onBusTime
     *
     * @return base_onbusinfo.onBusTime, 实际上车时间
     */
    public String getOnbustime() {
        return onbustime;
    }

    /**
     * 设置 实际上车时间 字段:base_onbusinfo.onBusTime
     *
     * @param onbustime the value for base_onbusinfo.onBusTime, 实际上车时间
     */
    public void setOnbustime(String onbustime) {
        this.onbustime = onbustime == null ? null : onbustime.trim();
    }

    /**
     * 获取 实际上车站点名称 字段:base_onbusinfo.onBusStationName
     *
     * @return base_onbusinfo.onBusStationName, 实际上车站点名称
     */
    public String getOnbusstationname() {
        return onbusstationname;
    }

    /**
     * 设置 实际上车站点名称 字段:base_onbusinfo.onBusStationName
     *
     * @param onbusstationname the value for base_onbusinfo.onBusStationName, 实际上车站点名称
     */
    public void setOnbusstationname(String onbusstationname) {
        this.onbusstationname = onbusstationname == null ? null : onbusstationname.trim();
    }

    /**
     * 获取 创建时间 字段:base_onbusinfo.ceateTime
     *
     * @return base_onbusinfo.ceateTime, 创建时间
     */
    public Date getCeatetime() {
        return ceatetime;
    }

    /**
     * 设置 创建时间 字段:base_onbusinfo.ceateTime
     *
     * @param ceatetime the value for base_onbusinfo.ceateTime, 创建时间
     */
    public void setCeatetime(Date ceatetime) {
        this.ceatetime = ceatetime;
    }
}