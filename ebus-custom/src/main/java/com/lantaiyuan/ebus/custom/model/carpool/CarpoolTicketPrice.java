package com.lantaiyuan.ebus.custom.model.carpool;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.lanqiao.ssm.common.model.Model;

/**
 * 用户拼车车票票价计算因子
 * CarpoolTicketPrice
 * @author YvanTan
 * 2017-07-13
 */
public class CarpoolTicketPrice extends Model{

	private static final long serialVersionUID = -3737285420261647615L;
  
	/**
     * 用户id，对应base_user
     */
    private int userId;
    
    /**
     * 里程数，单位-千米
     */
	//@Size(min=1, message = "里程数为不小于1的整数（单位：千米）")
    private int distance;
    
    /**
     *城市ID
     */
    @NotEmpty(message = "cityCode不能为空")
    private String cityCode;

    @NotEmpty(message = "version版本号不能为空")
    private String version;
    
    
	public CarpoolTicketPrice() {
	}

	public CarpoolTicketPrice(int userId, int distance, String cityCode) {
		super();
		this.userId = userId;
		this.distance = distance;
		this.cityCode = cityCode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}