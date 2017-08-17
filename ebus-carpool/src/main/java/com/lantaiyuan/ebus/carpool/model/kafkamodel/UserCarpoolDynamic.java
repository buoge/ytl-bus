package com.lantaiyuan.ebus.carpool.model.kafkamodel;

import com.lantaiyuan.ebus.carpool.enums.ChargingModelEnum;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import org.lanqiao.ssm.common.model.Model;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户拼车动态
 *
 * @author yangyang
 * @date 2017/7/12 18:16
 * @email kekecany@163.com
 */
public class UserCarpoolDynamic extends Model{

    private static final long serialVersionUID = 1523228016440059084L;

    private String orderNo;
    private String matchId;
    private String realStartPlaceName;
    private BigDecimal realStartPlaceLon;
    private BigDecimal realStartPlaceLat;
    private String realEndPlaceName;
    private BigDecimal realEndPlaceLon;
    private BigDecimal realEndPlaceLat;
    private Byte matchStatus;
    private Integer matchTimes;
    private BigDecimal realPrice;
    private Long expectAboardTime;
    private Long expectOffBusTime;
    // new added for v1.0.7.xls
    private BigDecimal sectionPrice;
    private BigDecimal unitePrice;

    public static CarpoolOrder parse(UserCarpoolDynamic userCarpoolDynamic, ChargingModelEnum chargingModelEnum) {
        CarpoolOrder carpoolOrder = new CarpoolOrder();
        carpoolOrder.setOrderNo(userCarpoolDynamic.getOrderNo());
        carpoolOrder.setMatchId(userCarpoolDynamic.getMatchId());
        carpoolOrder.setRealStartPlace(userCarpoolDynamic.getRealStartPlaceName());
        carpoolOrder.setRealStartLon(userCarpoolDynamic.getRealStartPlaceLon());
        carpoolOrder.setRealStartLat(userCarpoolDynamic.getRealStartPlaceLat());
        carpoolOrder.setRealEndPlace(userCarpoolDynamic.getRealEndPlaceName());
        carpoolOrder.setRealEndLon(userCarpoolDynamic.getRealEndPlaceLon());
        carpoolOrder.setRealEndLat(userCarpoolDynamic.getRealEndPlaceLat());
        carpoolOrder.setMatchStatus(userCarpoolDynamic.getMatchStatus());
        carpoolOrder.setMatchTimes(userCarpoolDynamic.getMatchTimes());
        // TODO 一票制，分段制检测
        if (chargingModelEnum == ChargingModelEnum.UNITE_PRICE) {
            carpoolOrder.setRealPrice(StringUtils.isEmpty(userCarpoolDynamic.getRealPrice()) ? userCarpoolDynamic.getUnitePrice() : userCarpoolDynamic.getRealPrice());
        } else {
            carpoolOrder.setRealPrice(userCarpoolDynamic.getSectionPrice());
        }
        carpoolOrder.setExpectAboardTime((StringUtils.isEmpty(userCarpoolDynamic.getExpectAboardTime()) || userCarpoolDynamic.getExpectAboardTime() == -1) ? null : new Date(userCarpoolDynamic.getExpectAboardTime()));
        carpoolOrder.setExpectOffBusTime((StringUtils.isEmpty(userCarpoolDynamic.getExpectOffBusTime()) || userCarpoolDynamic.getExpectOffBusTime() == -1) ? null : new Date(userCarpoolDynamic.getExpectOffBusTime()));
        return carpoolOrder;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getRealStartPlaceName() {
        return realStartPlaceName;
    }

    public void setRealStartPlaceName(String realStartPlaceName) {
        this.realStartPlaceName = realStartPlaceName;
    }

    public BigDecimal getRealStartPlaceLon() {
        return realStartPlaceLon;
    }

    public void setRealStartPlaceLon(BigDecimal realStartPlaceLon) {
        this.realStartPlaceLon = realStartPlaceLon;
    }

    public BigDecimal getRealStartPlaceLat() {
        return realStartPlaceLat;
    }

    public void setRealStartPlaceLat(BigDecimal realStartPlaceLat) {
        this.realStartPlaceLat = realStartPlaceLat;
    }

    public String getRealEndPlaceName() {
        return realEndPlaceName;
    }

    public void setRealEndPlaceName(String realEndPlaceName) {
        this.realEndPlaceName = realEndPlaceName;
    }

    public BigDecimal getRealEndPlaceLon() {
        return realEndPlaceLon;
    }

    public void setRealEndPlaceLon(BigDecimal realEndPlaceLon) {
        this.realEndPlaceLon = realEndPlaceLon;
    }

    public BigDecimal getRealEndPlaceLat() {
        return realEndPlaceLat;
    }

    public void setRealEndPlaceLat(BigDecimal realEndPlaceLat) {
        this.realEndPlaceLat = realEndPlaceLat;
    }

    public Byte getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(Byte matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Integer getMatchTimes() {
        return matchTimes;
    }

    public void setMatchTimes(Integer matchTimes) {
        this.matchTimes = matchTimes;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public Long getExpectAboardTime() {
        return expectAboardTime;
    }

    public void setExpectAboardTime(Long expectAboardTime) {
        this.expectAboardTime = expectAboardTime;
    }

    public Long getExpectOffBusTime() {
        return expectOffBusTime;
    }

    public void setExpectOffBusTime(Long expectOffBusTime) {
        this.expectOffBusTime = expectOffBusTime;
    }

    public BigDecimal getSectionPrice() {
        return sectionPrice;
    }

    public void setSectionPrice(BigDecimal sectionPrice) {
        this.sectionPrice = sectionPrice;
    }

    public BigDecimal getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(BigDecimal unitePrice) {
        this.unitePrice = unitePrice;
    }
}