package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/** 
  * @Title: Cities.java
  * @Package com.lantaiyuan.ebus.custom.model
  * @Description: 
  * @author yangyang   
  * @date 2017年1月11日 下午3:55:43
  * @version v1.0  
 */
public class Cities extends Model{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 5350687671457000008L;

	/**
     * 城市名称
     * 表字段 : base_service_ip.cityName
     */
    private String cityname;

    /**
     * 城市代码
     * 表字段 : base_service_ip.cityCode
     */
    private String citycode;
    
    /**
     * 图片在fastdfs中保存的位置
     */
    private String imgurl;

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
    
    
}
