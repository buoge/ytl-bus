package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/***
 * 
* <p>Title: MyTrail</p>
* <p>Description: 我的行程实体类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年2月18日 下午4:47:16
 */
public class MyTrail extends Model{
	/***serialVersionUID***/
	private static final long serialVersionUID = 1L;

	//主键id
    private Integer id;

    //用户id
    private Integer userid;

    //对象属性：起始站点
    private BaseStation startstation;
    
    //起始站点id
    private Integer startstationid;

    //起始时间
    private Date starttime;

    //对象属性：结束站点
    private BaseStation endstation;
    
    //结束站点id
    private Integer endstationid;

    //结束时间
    private Date endtime;

    //创建时间
    private Date createtime;
    
    //城市编码
    private String citycode;
    
    /**
     * 线路Id
     */
    private String routeId;
    
    /**
     * 线路方向
     */
    private Integer direction;
    
    /**
     * 总行程
     */
    private Double trailDistance;
    /**
     * 车辆编号
     */
    private String vehicleId;
    
    /**
     * 车牌号
     */
    private String busPlateNumber;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public BaseStation getStartstation() {
		return startstation;
	}

	public void setStartstation(BaseStation startstation) {
		this.startstation = startstation;
	}

	public BaseStation getEndstation() {
		return endstation;
	}

	public void setEndstation(BaseStation endstation) {
		this.endstation = endstation;
	}

	public Integer getStartstationid() {
		return startstationid;
	}

	public void setStartstationid(Integer startstationid) {
		this.startstationid = startstationid;
	}

	public Integer getEndstationid() {
		return endstationid;
	}

	public void setEndstationid(Integer endstationid) {
		this.endstationid = endstationid;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getBusPlateNumber() {
		return busPlateNumber;
	}

	public void setBusPlateNumber(String busPlateNumber) {
		this.busPlateNumber = busPlateNumber;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public Double getTrailDistance() {
		return trailDistance;
	}

	public void setTrailDistance(Double trailDistance) {
		this.trailDistance = trailDistance;
	}
	
	
}