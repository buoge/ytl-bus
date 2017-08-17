package com.lantaiyuan.ebus.custom.model.carpool;

import org.lanqiao.ssm.common.model.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 拼车动态
 * @author yangyang
 * @date 2017年6月13日 下午4:50:21 
 */
public class CarpoolDynamics extends Model{

	private static final long serialVersionUID = 6376511368947543225L;

	private Byte matchStatus;
	
	private String matchId;

	private String startStation;

	private String endStation;
	
	private BigDecimal paidPrice;

	private Double distance;

	private Date initialAboardTime;
	
	private Date expectAboardTime;

	private BigDecimal realPrice;

	private Integer requiredPersons;

	private Integer matchedPersons;

	private Long matchCostTime;

	private Integer matchedTimes;

	private Integer matchExpectTime;
	
	private String carpoolRouteId;
	
	private String carpoolRouteName;

	private List<JpushDynamics> dynamics;

	public CarpoolDynamics matchStatus(Byte matchStatus) {
		this.matchStatus = matchStatus;
		return this;
	}

	public CarpoolDynamics startStation(String startStation) {
		this.startStation = startStation;
		return this;
	}

	public CarpoolDynamics matchId(String matchId) {
		this.matchId = matchId;
		return this;
	}

	public CarpoolDynamics endStation(String endStation) {
		this.endStation = endStation;
		return this;
	}

	public CarpoolDynamics paidPrice(BigDecimal paidPrice) {
		this.paidPrice = paidPrice;
		return this;
	}

	public CarpoolDynamics distance(Double distance) {
		this.distance = distance;
		return this;
	}

	public CarpoolDynamics initialAboardTime(Date initialAboardTime) {
		this.initialAboardTime = initialAboardTime;
		return this;
	}

	public CarpoolDynamics expectAboardTime(Date expectAboardTime) {
		this.expectAboardTime = expectAboardTime;
		return this;
	}

	public CarpoolDynamics realPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
		return this;
	}

	public CarpoolDynamics requiredPersons(Integer requiredPersons) {
		this.requiredPersons = requiredPersons;
		return this;
	}

	public CarpoolDynamics matchedPersons(Integer matchedPersons) {
		this.matchedPersons = matchedPersons;
		return this;
	}

	public CarpoolDynamics matchCostTime(Long matchCostTime) {
		this.matchCostTime = matchCostTime;
		return this;
	}

	public CarpoolDynamics matchedTimes(Integer matchedTimes) {
		this.matchedTimes = matchedTimes;
		return this;
	}

	public CarpoolDynamics matchExpectTime(Integer matchExpectTime) {
		this.matchExpectTime = matchExpectTime;
		return this;
	}

	public CarpoolDynamics carpoolRouteId(String carpoolRouteId) {
		this.carpoolRouteId = carpoolRouteId;
		return this;
	}
	
	public CarpoolDynamics carpoolRouteName(String carpoolRouteName) {
		this.carpoolRouteName = carpoolRouteName;
		return this;
	}

	public CarpoolDynamics dynamics(List<JpushDynamics> dynamics) {
		this.dynamics = dynamics;
		return this;
	}

	public Byte getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(Byte matchStatus) {
		this.matchStatus = matchStatus;
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

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public BigDecimal getPaidPrice() {
		return paidPrice;
	}

	public void setPaidPrice(BigDecimal paidPrice) {
		this.paidPrice = paidPrice;
	}

	public Date getInitialAboardTime() {
		return initialAboardTime;
	}

	public void setInitialAboardTime(Date initialAboardTime) {
		this.initialAboardTime = initialAboardTime;
	}

	public Date getExpectAboardTime() {
		return expectAboardTime;
	}

	public void setExpectAboardTime(Date expectAboardTime) {
		this.expectAboardTime = expectAboardTime;
	}

	public BigDecimal getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}

	public Integer getRequiredPersons() {
		return requiredPersons;
	}

	public void setRequiredPersons(Integer requiredPersons) {
		this.requiredPersons = requiredPersons;
	}

	public Integer getMatchedPersons() {
		return matchedPersons;
	}

	public void setMatchedPersons(Integer matchedPersons) {
		this.matchedPersons = matchedPersons;
	}

	public Long getMatchCostTime() {
		return matchCostTime;
	}

	public void setMatchCostTime(Long matchCostTime) {
		this.matchCostTime = matchCostTime;
	}

	public Integer getMatchedTimes() {
		return matchedTimes;
	}

	public void setMatchedTimes(Integer matchedTimes) {
		this.matchedTimes = matchedTimes;
	}

	public Integer getMatchExpectTime() {
		return matchExpectTime;
	}

	public void setMatchExpectTime(Integer matchExpectTime) {
		this.matchExpectTime = matchExpectTime;
	}

	public String getCarpoolRouteId() {
		return carpoolRouteId;
	}

	public void setCarpoolRouteId(String carpoolRouteId) {
		this.carpoolRouteId = carpoolRouteId;
	}

	public List<JpushDynamics> getDynamics() {
		return dynamics;
	}

	public void setDynamics(List<JpushDynamics> dynamics) {
		this.dynamics = dynamics;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	
	public String getCarpoolRouteName() {
		return carpoolRouteName;
	}

	public void setCarpoolRouteName(String carpoolRouteName) {
		this.carpoolRouteName = carpoolRouteName;
	}

	
}