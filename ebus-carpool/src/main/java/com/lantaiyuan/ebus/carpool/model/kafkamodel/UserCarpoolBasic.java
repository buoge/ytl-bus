/**
* <p>Title: UserCarpoolBasic.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.carpool.model.kafkamodel;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.lanqiao.ssm.common.model.Model;

import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;

/**
* <p>Title: UserCarpoolBasic</p>
* <p>Description: 用户提交拼车基础信息</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年7月13日 上午11:37:22
*/
public class UserCarpoolBasic extends Model{
	/***serialVersionUID***/
	private static final long serialVersionUID = 1L;
	
	private String orderNo;
	private Integer userId;
	private BigDecimal paidPrice;
	private String startPlaceName;
	private BigDecimal startPlaceLon;
	private BigDecimal startPlaceLat;
	private String endPlaceName;
	private BigDecimal endPlaceLon;
	private BigDecimal endPlaceLat;
	private Byte seats;
	private Integer maxWalkDistance;
	private Date earliestStartTime;
	private Date latestStartTime;
	private Byte isRegular;
	private Byte regularDetail;
	private String cityCode;
	@JsonIgnore
	private String matchId;
	
	
	public static UserCarpoolBasic parse(CarpoolOrder carpoolOrder){
		UserCarpoolBasic userCarpoolBasic = new UserCarpoolBasic();
		
		userCarpoolBasic.setOrderNo(carpoolOrder.getOrderNo());
		userCarpoolBasic.setUserId(carpoolOrder.getUserId());
		userCarpoolBasic.setPaidPrice(carpoolOrder.getPaidPrice());
		userCarpoolBasic.setStartPlaceName(carpoolOrder.getInitialStartPlace());
		userCarpoolBasic.setStartPlaceLon(carpoolOrder.getInitialStartLon());
		userCarpoolBasic.setStartPlaceLat(carpoolOrder.getInitialStartLat());
		userCarpoolBasic.setEndPlaceName(carpoolOrder.getInitialEndPlace());
		userCarpoolBasic.setEndPlaceLon(carpoolOrder.getInitialEndLon());
		userCarpoolBasic.setEndPlaceLat(carpoolOrder.getInitialEndLat());
		userCarpoolBasic.setSeats(carpoolOrder.getSeats());
		userCarpoolBasic.setMaxWalkDistance(carpoolOrder.getMaxWalkDistance());
		userCarpoolBasic.setIsRegular(carpoolOrder.getIsRegular());
		userCarpoolBasic.setRegularDetail(carpoolOrder.getRegularDetail());
		userCarpoolBasic.setCityCode(carpoolOrder.getCityCode());
	
		if(carpoolOrder.getIsRegular() == 0){
			userCarpoolBasic.setEarliestStartTime(carpoolOrder.getEarliestStartTime());
			userCarpoolBasic.setLatestStartTime(carpoolOrder.getLatestStartTime());
		}
		else{
			//TODO 规律性的下个版本迭代...
		}
		
		//加入已有拼车订单需要
		userCarpoolBasic.setMatchId(carpoolOrder.getMatchId());
		
		return userCarpoolBasic;
	}
	
	/**
	* @return orderNo
	*/
	public String getOrderNo() {
		return orderNo;
	}
	/**
	* @param orderNo 要设置的 orderNo
	*/
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	* @return userId
	*/
	public Integer getUserId() {
		return userId;
	}
	/**
	* @param userId 要设置的 userId
	*/
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	* @return paidPrice
	*/
	public BigDecimal getPaidPrice() {
		return paidPrice;
	}
	/**
	* @param paidPrice 要设置的 paidPrice
	*/
	public void setPaidPrice(BigDecimal paidPrice) {
		this.paidPrice = paidPrice;
	}
	/**
	* @return startPlaceName
	*/
	public String getStartPlaceName() {
		return startPlaceName;
	}
	/**
	* @param startPlaceName 要设置的 startPlaceName
	*/
	public void setStartPlaceName(String startPlaceName) {
		this.startPlaceName = startPlaceName;
	}
	/**
	* @return startPlaceLon
	*/
	public BigDecimal getStartPlaceLon() {
		return startPlaceLon;
	}
	/**
	* @param startPlaceLon 要设置的 startPlaceLon
	*/
	public void setStartPlaceLon(BigDecimal startPlaceLon) {
		this.startPlaceLon = startPlaceLon;
	}
	/**
	* @return startPlaceLat
	*/
	public BigDecimal getStartPlaceLat() {
		return startPlaceLat;
	}
	/**
	* @param startPlaceLat 要设置的 startPlaceLat
	*/
	public void setStartPlaceLat(BigDecimal startPlaceLat) {
		this.startPlaceLat = startPlaceLat;
	}
	/**
	* @return endPlaceName
	*/
	public String getEndPlaceName() {
		return endPlaceName;
	}
	/**
	* @param endPlaceName 要设置的 endPlaceName
	*/
	public void setEndPlaceName(String endPlaceName) {
		this.endPlaceName = endPlaceName;
	}
	/**
	* @return endPlaceLon
	*/
	public BigDecimal getEndPlaceLon() {
		return endPlaceLon;
	}
	/**
	* @param endPlaceLon 要设置的 endPlaceLon
	*/
	public void setEndPlaceLon(BigDecimal endPlaceLon) {
		this.endPlaceLon = endPlaceLon;
	}
	/**
	* @return endPlaceLat
	*/
	public BigDecimal getEndPlaceLat() {
		return endPlaceLat;
	}
	/**
	* @param endPlaceLat 要设置的 endPlaceLat
	*/
	public void setEndPlaceLat(BigDecimal endPlaceLat) {
		this.endPlaceLat = endPlaceLat;
	}
	/**
	* @return seats
	*/
	public Byte getSeats() {
		return seats;
	}
	/**
	* @param seats 要设置的 seats
	*/
	public void setSeats(Byte seats) {
		this.seats = seats;
	}
	/**
	* @return maxWalkDistance
	*/
	public Integer getMaxWalkDistance() {
		return maxWalkDistance;
	}
	/**
	* @param maxWalkDistance 要设置的 maxWalkDistance
	*/
	public void setMaxWalkDistance(Integer maxWalkDistance) {
		this.maxWalkDistance = maxWalkDistance;
	}
	/**
	* @return earliestStartTime
	*/
	public Date getEarliestStartTime() {
		return earliestStartTime;
	}
	/**
	* @param earliestStartTime 要设置的 earliestStartTime
	*/
	public void setEarliestStartTime(Date earliestStartTime) {
		this.earliestStartTime = earliestStartTime;
	}
	/**
	* @return latestStartTime
	*/
	public Date getLatestStartTime() {
		return latestStartTime;
	}
	/**
	* @param latestStartTime 要设置的 latestStartTime
	*/
	public void setLatestStartTime(Date latestStartTime) {
		this.latestStartTime = latestStartTime;
	}
	/**
	* @return isRegular
	*/
	public Byte getIsRegular() {
		return isRegular;
	}
	/**
	* @param isRegular 要设置的 isRegular
	*/
	public void setIsRegular(Byte isRegular) {
		this.isRegular = isRegular;
	}
	/**
	* @return regularDetail
	*/
	public Byte getRegularDetail() {
		return regularDetail;
	}
	/**
	* @param regularDetail 要设置的 regularDetail
	*/
	public void setRegularDetail(Byte regularDetail) {
		this.regularDetail = regularDetail;
	}
	/**
	* @return cityCode
	*/
	public String getCityCode() {
		return cityCode;
	}
	/**
	* @param cityCode 要设置的 cityCode
	*/
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	* @return matchId
	*/
	public String getMatchId() {
		return matchId;
	}

	/**
	* @param matchId 要设置的 matchId
	*/
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	
}
