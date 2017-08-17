package com.lantaiyuan.ebus.carpool.model.kafkamodel;

import com.lantaiyuan.ebus.carpool.enums.ChargingModelEnum;
import com.lantaiyuan.ebus.carpool.model.CarpoolRoute;
import org.lanqiao.ssm.common.model.Model;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 线路基础信息
 *
 * @author yangyang
 * @date 2017/8/2 10:14
 * @email kekecany@163.com
 */
public class CarpoolRouteBasic extends Model {

    private static final long serialVersionUID = 3609280807946149361L;

    private String carpoolRouteId;
    private String carpoolRouteName;
    private Integer carpoolRouteType;
    private BigDecimal distance;
    private BigDecimal price;
    private BigDecimal sectionMinPrice;
    private BigDecimal sectionMaxPrice;
    private BigDecimal unitePrice;
    private String startStation;
    private String endStation;
    private Byte status;
    private String cityCode;
    private Date departTime;
    private Date arriveTime;

    public static CarpoolRoute parse(CarpoolRouteBasic basic, ChargingModelEnum chargingModelEnum) {
        CarpoolRoute route = new CarpoolRoute();
        route.setCarpoolRouteId(basic.getCarpoolRouteId());
        route.setCarpoolRouteName(basic.getCarpoolRouteName());
        route.setCarpoolRouteType(basic.getCarpoolRouteType());
        route.setDistance(basic.getDistance());
        if (chargingModelEnum == ChargingModelEnum.UNITE_PRICE) {
            route.setPrice(StringUtils.isEmpty(basic.getUnitePrice()) ? basic.getPrice().toString() : basic.getUnitePrice().toString());
        } else {
            route.setPrice(basic.getSectionMinPrice().toString() + "-" + basic.getSectionMaxPrice().toString());
        }
        route.setStartStation(basic.getStartStation());
        route.setEndStation(basic.getEndStation());
        route.setStatus(basic.getStatus());
        route.setCityCode(basic.getCityCode());
        route.setDepartTime(basic.getDepartTime());
        route.setArriveTime(basic.getArriveTime());
        return route;
    }

    public String getCarpoolRouteId() {
        return carpoolRouteId;
    }

    public void setCarpoolRouteId(String carpoolRouteId) {
        this.carpoolRouteId = carpoolRouteId;
    }

    public String getCarpoolRouteName() {
        return carpoolRouteName;
    }

    public void setCarpoolRouteName(String carpoolRouteName) {
        this.carpoolRouteName = carpoolRouteName;
    }

    public Integer getCarpoolRouteType() {
        return carpoolRouteType;
    }

    public void setCarpoolRouteType(Integer carpoolRouteType) {
        this.carpoolRouteType = carpoolRouteType;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSectionMinPrice() {
        return sectionMinPrice;
    }

    public void setSectionMinPrice(BigDecimal sectionMinPrice) {
        this.sectionMinPrice = sectionMinPrice;
    }

    public BigDecimal getSectionMaxPrice() {
        return sectionMaxPrice;
    }

    public void setSectionMaxPrice(BigDecimal sectionMaxPrice) {
        this.sectionMaxPrice = sectionMaxPrice;
    }

    public BigDecimal getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(BigDecimal unitePrice) {
        this.unitePrice = unitePrice;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Date getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }
}
