package com.lantaiyuan.ebus.custom.model.travelaround;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 * TODO 简单说明
 *
 * @author yangyang
 * @date 2017/7/18 10:27
 * @email kekecany@163.com
 */
public class TravelAroundQueryModel extends BaseModel<TravelAround> {

    private static final long serialVersionUID = -7816667893954093158L;
    
    /**
     * 城市编码，-1代表所有城市
     * 表字段 : travel_around.city_code
     */
    private String cityCode;

    /**
     * 标题
     * 表字段 : travel_around.title
     */
    private String title;

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
	* @return title
	*/
	public String getTitle() {
		return title;
	}

	/**
	* @param title 要设置的 title
	*/
	public void setTitle(String title) {
		this.title = title;
	}

}
