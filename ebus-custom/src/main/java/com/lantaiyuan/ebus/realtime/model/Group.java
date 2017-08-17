package com.lantaiyuan.ebus.realtime.model;

import org.lanqiao.ssm.common.model.Model;

import com.lantaiyuan.ebus.custom.model.BaseRoute;
import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.RelRouteStation;

/**
 * 
* @Title: Group.java
* @Package com.lantaiyuan.ebus.realtime.model
* @Description: 收藏线路展示的线路详情
* @author yangyang   
* @date 2016年12月21日 下午2:18:33
* @version v1.0
 */
public class Group extends Model {

	private static final long serialVersionUID = 4399847208480637087L;
	
	private Favoriate favoriate;
	
	private BaseRoute routeInBaseLine;
	
	private RelRouteStation relRouteStation;
	
	private RealTime realTime;
	
	private BaseStation baseStation;

	public Favoriate getFavoriate() {
		return favoriate;
	}

	public void setFavoriate(Favoriate favoriate) {
		this.favoriate = favoriate;
	}

	public BaseRoute getRouteInBaseLine() {
		return routeInBaseLine;
	}

	public void setRouteInBaseLine(BaseRoute routeInBaseLine) {
		this.routeInBaseLine = routeInBaseLine;
	}

	public RealTime getRealTime() {
		return realTime;
	}

	public void setRealTime(RealTime realTime) {
		this.realTime = realTime;
	}

	public BaseStation getBaseStation() {
		return baseStation;
	}

	public void setBaseStation(BaseStation baseStation) {
		this.baseStation = baseStation;
	}
	
	public RelRouteStation getRelRouteStation() {
		return relRouteStation;
	}

	public void setRelRouteStation(RelRouteStation relRouteStation) {
		this.relRouteStation = relRouteStation;
	}
	
	/***
	 * 
	* <p>Title: addBusInfo</p>
	* <p>Description: 注入车辆信息</p>
	 */
	public Group addBusInfo(RealTime realTime) {
		this.realTime = realTime;
		return this;
	}
	
	/*private String cityCode;
	private String userId;
    private Integer collectionStatus;//
    private Integer direction;//
    
    private Double routeDistance;//
    private String endStation;
    private String endTime;
    private Integer id;//线路表里的主键
    private String price;//
    private Integer reversal;
    private String routeId;//
    private String routeName;//
    private String routeNo;//
    private Integer routeType;//
    private String selectedStationID;
    private String stationName;
    private String shortName;//
    private String startStation;
    private String startTime;//
    private Integer status;//
    private String tag;//收藏的标签名称
    
    private String vehicleId;// 车辆编号
    
    private String licensePlate; //车牌
	private Integer stationNumber;//距离当前站点的站点数量
	private double distance; //距离当前站点的距离（单位米）
	private Integer time; //距离到达当前站点的预计时间
	private Integer busType;//车辆类型
	private Integer type ; //0 到站 1 过站
	private Double longitude; //车辆经度
	private Double latitude ; //车辆维度
	
	
	*//****************整合baseStation相关字段***************//*
	private Integer stationid;

    private String name;

    private BigDecimal lon;

    private BigDecimal lat;

    private BigDecimal longitudein;

    private BigDecimal latitudein;

    private BigDecimal longitudeout;

    private BigDecimal latitudeout;

    private Integer stationflag;

    private Integer stationstatus;

    private Double stationdistance;
    
    //biz_favorite与rel_route_station联合查询获取stationNo
    private Integer stationNo;
    
    //内部整合BaseStation类
    public BaseStation getStation(){
    	BaseStation station = new BaseStation();
    	
    	station.setStationid(this.stationid);
    	station.setName(this.name);
    	station.setLongitude(this.lon);
    	station.setLatitude(this.lat);
    	station.setLongitudein(this.longitudein);
    	station.setLatitudein(this.latitudein);

    	station.setLongitudeout(this.longitudeout);
    	station.setLatitudeout(this.latitudeout);
    	station.setStationflag(this.stationflag);
    	
    	station.setCitycode(this.cityCode);
    	station.setStationstatus(this.stationstatus);
    	station.setDistance(this.stationdistance);
    	station.setCitycode(this.cityCode);
    	
    	return station;
    }
	
	
	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Group addBusInfo(BusDetail bus) {
		this.vehicleId = bus.getVehicleId();
		this.licensePlate = bus.getLicensePlate();
		this.stationNumber = bus.getStationNumber();
		this.distance = bus.getDistance();
		this.time = bus.getTime();
		this.busType = bus.getBusType();
		this.type = bus.getType();
		this.latitude = bus.getLatitude();
		this.longitude = bus.getLongitude();
		return this;
	}
	
	public Double getRouteDistance() {
		return routeDistance;
	}

	public void setRouteDistance(Double routeDistance) {
		this.routeDistance = routeDistance;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Integer getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(Integer stationNumber) {
		this.stationNumber = stationNumber;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getBusType() {
		return busType;
	}

	public void setBusType(Integer busType) {
		this.busType = busType;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getCityCode() {
		return cityCode;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public Integer getCollectionStatus() {
		return collectionStatus;
	}
	public void setCollectionStatus(Integer collectionStatus) {
		this.collectionStatus = collectionStatus;
	}
	public Integer getDirection() {
		return direction;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	
	public double getDistance() {
		return distance;
	}

	public String getEndStation() {
		return endStation;
	}
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getReversal() {
		return reversal;
	}
	public void setReversal(Integer reversal) {
		this.reversal = reversal;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}
	public Integer getRouteType() {
		return routeType;
	}
	public void setRouteType(Integer routeType) {
		this.routeType = routeType;
	}
	public String getSelectedStationID() {
		return selectedStationID;
	}
	public void setSelectedStationID(String selectedStationID) {
		this.selectedStationID = selectedStationID;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getStationid() {
		return stationid;
	}


	public void setStationid(Integer stationid) {
		this.stationid = stationid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getLon() {
		return lon;
	}


	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}


	public BigDecimal getLat() {
		return lat;
	}


	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}


	public BigDecimal getLongitudein() {
		return longitudein;
	}


	public void setLongitudein(BigDecimal longitudein) {
		this.longitudein = longitudein;
	}


	public BigDecimal getLatitudein() {
		return latitudein;
	}


	public void setLatitudein(BigDecimal latitudein) {
		this.latitudein = latitudein;
	}


	public BigDecimal getLongitudeout() {
		return longitudeout;
	}


	public void setLongitudeout(BigDecimal longitudeout) {
		this.longitudeout = longitudeout;
	}


	public BigDecimal getLatitudeout() {
		return latitudeout;
	}


	public void setLatitudeout(BigDecimal latitudeout) {
		this.latitudeout = latitudeout;
	}


	public Integer getStationflag() {
		return stationflag;
	}


	public void setStationflag(Integer stationflag) {
		this.stationflag = stationflag;
	}


	public Integer getStationstatus() {
		return stationstatus;
	}


	public void setStationstatus(Integer stationstatus) {
		this.stationstatus = stationstatus;
	}

	public Double getStationdistance() {
		return stationdistance;
	}


	public void setStationdistance(Double stationdistance) {
		this.stationdistance = stationdistance;
	}


	public Integer getStationNo() {
		return stationNo;
	}


	public void setStationNo(Integer stationNo) {
		this.stationNo = stationNo;
	}*/
	
}
