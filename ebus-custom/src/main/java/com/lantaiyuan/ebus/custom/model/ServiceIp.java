package com.lantaiyuan.ebus.custom.model;

/**
 * ip限制表（城市服务及IP配置）
 * ServiceIp
 * 数据库表：base_service_ip
 */
public class ServiceIp {

    public ServiceIp(String cityname, String citycode) {
		super();
		this.cityname = cityname;
		this.citycode = citycode;
	}

	public ServiceIp() {
		super();
	}

	/**
     * 主键(UUID)
     * 表字段 : base_service_ip.id
     */
    private String id;

    /**
     * 可上传的ip
     * 表字段 : base_service_ip.serviceIp
     */
    private String serviceip;

    /**
     * 每日上传次数限制
     * 表字段 : base_service_ip.times
     */
    private Byte times;

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
     * 权限描述
     */
    private String authdesc;

    /**
     * 权限  (0：资讯，1：资讯、包车、包线)
     * 表字段 : base_service_ip.authority
     */
    private Short authority;

    /**
     * 图片在fastdfs中保存的位置
     */
    private String busCompanyTitle;
    
    /**
     * 公交公司标题名称
     */
    private String imgurl;
    /**
     * 获取 主键(UUID) 字段:base_service_ip.id
     *
     * @return base_service_ip.id, 主键(UUID)
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键(UUID) 字段:base_service_ip.id
     *
     * @param id the value for base_service_ip.id, 主键(UUID)
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 可上传的ip 字段:base_service_ip.serviceIp
     *
     * @return base_service_ip.serviceIp, 可上传的ip
     */
    public String getServiceip() {
        return serviceip;
    }

    /**
     * 设置 可上传的ip 字段:base_service_ip.serviceIp
     *
     * @param serviceip the value for base_service_ip.serviceIp, 可上传的ip
     */
    public void setServiceip(String serviceip) {
        this.serviceip = serviceip == null ? null : serviceip.trim();
    }

    
    public String getAuthdesc() {
		return authdesc;
	}

	public void setAuthdesc(String authdesc) {
		this.authdesc = authdesc;
	}

	/**
     * 获取 每日上传次数限制 字段:base_service_ip.times
     *
     * @return base_service_ip.times, 每日上传次数限制
     */
    public Byte getTimes() {
        return times;
    }

    /**
     * 设置 每日上传次数限制 字段:base_service_ip.times
     *
     * @param times the value for base_service_ip.times, 每日上传次数限制
     */
    public void setTimes(Byte times) {
        this.times = times;
    }

    /**
     * 获取 城市名称 字段:base_service_ip.cityName
     *
     * @return base_service_ip.cityName, 城市名称
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * 设置 城市名称 字段:base_service_ip.cityName
     *
     * @param cityname the value for base_service_ip.cityName, 城市名称
     */
    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    /**
     * 获取 城市代码 字段:base_service_ip.cityCode
     *
     * @return base_service_ip.cityCode, 城市代码
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置 城市代码 字段:base_service_ip.cityCode
     *
     * @param citycode the value for base_service_ip.cityCode, 城市代码
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    /**
     * 获取 权限  (0：资讯，1：资讯、包车、包线) 字段:base_service_ip.authority
     *
     * @return base_service_ip.authority, 权限  (0：资讯，1：资讯、包车、包线)
     */
    public Short getAuthority() {
        return authority;
    }

    /**
     * 设置 权限  (0：资讯，1：资讯、包车、包线) 字段:base_service_ip.authority
     *
     * @param authority the value for base_service_ip.authority, 权限  (0：资讯，1：资讯、包车、包线)
     */
    public void setAuthority(Short authority) {
        this.authority = authority;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

	public String getBusCompanyTitle() {
		return busCompanyTitle;
	}

	public void setBusCompanyTitle(String busCompanyTitle) {
		this.busCompanyTitle = busCompanyTitle;
	}
    
    
    
}