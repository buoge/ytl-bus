package com.lantaiyuan.ebus.custom.model;

import javax.validation.constraints.NotNull;

import org.lanqiao.ssm.common.model.Model;

import com.lantaiyuan.ebus.realtime.model.valid.First;
import com.lantaiyuan.ebus.realtime.model.valid.Second;

/***
 * 
* <p>Title: CircularTour</p>
* <p>Description: 周边游实体类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年6月12日 下午2:53:55
 */
public class CircularTour extends Model{
    /***serialVersionUID***/
	private static final long serialVersionUID = 1L;

	@NotNull(message = "id不能为空！",groups = { Second.class})
	private Integer id;

	@NotNull(message = "tourName不能为空！",groups = { First.class, Second.class})
    private String tourName;

	@NotNull(message = "tourUrl不能为空！",groups = { First.class, Second.class})
    private String tourUrl;

	@NotNull(message = "cityCode不能为空！",groups = { First.class, Second.class})
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