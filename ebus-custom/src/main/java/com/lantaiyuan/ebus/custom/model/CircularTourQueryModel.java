package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.BaseModel;

/***
 * 
* <p>Title: CircularTour</p>
* <p>Description: 周边游实体类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年6月12日 下午2:53:55
 */
public class CircularTourQueryModel extends BaseModel<CircularTour>{
    /***serialVersionUID***/
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String tourName;

    private String tourUrl;

    private String cityCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName == null ? null : tourName.trim();
    }

    public String getTourUrl() {
        return tourUrl;
    }

    public void setTourUrl(String tourUrl) {
        this.tourUrl = tourUrl == null ? null : tourUrl.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }
}