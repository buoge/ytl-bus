package com.lantaiyuan.ebus.carpool.model.kafkamodel;

import com.lantaiyuan.ebus.carpool.model.CarpoolMatch;
import org.lanqiao.ssm.common.model.Model;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 大拼车订单(含多个用户订单)拼车动态
 *
 * @author yangyang
 * @date 2017/7/12 18:23
 * @email kekecany@163.com
 */
public class BigCarpoolDynamic extends Model{
    private static final long serialVersionUID = -6576680065847508822L;

    private String matchId;
    private Byte matchStatus;
    private Integer matchExpectTime;
    private Byte matchPersons;
    private Byte requiredPersons;
    private Long departTime;
    private String cityCode;
    private String carpoolRouteId;
    private String driverPhoneNo;
    private Integer departBusType;
    private Byte departBusSeats;
    private String vehicleId;
    private String busPlateNumber;
    private String driverId;
    private String driverName;
    private String driverJudgement;

    public static CarpoolMatch parse(BigCarpoolDynamic bigCarpoolDynamic) {
        CarpoolMatch carpoolMatch = new CarpoolMatch();
        carpoolMatch.setMatchId(bigCarpoolDynamic.getMatchId());
        carpoolMatch.setMatchStatus(bigCarpoolDynamic.getMatchStatus());
        carpoolMatch.setMatchExpectTime(bigCarpoolDynamic.getMatchExpectTime());
        carpoolMatch.setMatchPersons(bigCarpoolDynamic.getMatchPersons());
        carpoolMatch.setRequiredPersons(bigCarpoolDynamic.getRequiredPersons());
        carpoolMatch.setDepartTime((StringUtils.isEmpty(bigCarpoolDynamic.getDepartTime()) || bigCarpoolDynamic.getDepartTime() == -1) ? null : new Date(bigCarpoolDynamic.getDepartTime()));
        carpoolMatch.setCityCode(bigCarpoolDynamic.getCityCode());
        carpoolMatch.setCarpoolRouteId(bigCarpoolDynamic.getCarpoolRouteId());
        carpoolMatch.setDriverPhoneNo(bigCarpoolDynamic.getDriverPhoneNo());
        carpoolMatch.setDepartBusType(bigCarpoolDynamic.getDepartBusType());
        carpoolMatch.setDepartBusSeats(bigCarpoolDynamic.getDepartBusSeats());
        carpoolMatch.setVehicleId(bigCarpoolDynamic.getVehicleId());
        carpoolMatch.setBusPlateNumber(bigCarpoolDynamic.getBusPlateNumber());
        carpoolMatch.setDriverId(bigCarpoolDynamic.getDriverId());
        carpoolMatch.setDriverName(bigCarpoolDynamic.getDriverName());
        carpoolMatch.setDriverJudgement(bigCarpoolDynamic.getDriverJudgement());
        return carpoolMatch;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Byte getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(Byte matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Integer getMatchExpectTime() {
        return matchExpectTime;
    }

    public void setMatchExpectTime(Integer matchExpectTime) {
        this.matchExpectTime = matchExpectTime;
    }

    public Byte getMatchPersons() {
        return matchPersons;
    }

    public void setMatchPersons(Byte matchPersons) {
        this.matchPersons = matchPersons;
    }

    public Byte getRequiredPersons() {
        return requiredPersons;
    }

    public void setRequiredPersons(Byte requiredPersons) {
        this.requiredPersons = requiredPersons;
    }

    public Long getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Long departTime) {
        this.departTime = departTime;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCarpoolRouteId() {
        return carpoolRouteId;
    }

    public void setCarpoolRouteId(String carpoolRouteId) {
        this.carpoolRouteId = carpoolRouteId;
    }

    public String getDriverPhoneNo() {
        return driverPhoneNo;
    }

    public void setDriverPhoneNo(String driverPhoneNo) {
        this.driverPhoneNo = driverPhoneNo;
    }

    public Integer getDepartBusType() {
        return departBusType;
    }

    public void setDepartBusType(Integer departBusType) {
        this.departBusType = departBusType;
    }

    public Byte getDepartBusSeats() {
        return departBusSeats;
    }

    public void setDepartBusSeats(Byte departBusSeats) {
        this.departBusSeats = departBusSeats;
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

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverJudgement() {
        return driverJudgement;
    }

    public void setDriverJudgement(String driverJudgement) {
        this.driverJudgement = driverJudgement;
    }
}
