package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

public class CustomLine extends Model {
	
  
    private static final long serialVersionUID = 1L;
    
    private String id;
    
    private String routeid;
    
    private String routeno;

    private String routename;

    private String shortname;

    private BigDecimal distance;

    private BigDecimal price;

    private String startworktime;

    private String offworktime;

    private String startstation;

    private BigDecimal startlongitude;

    private BigDecimal startlatitude;

    private String endstation;

    private BigDecimal endlongitude;

    private BigDecimal endlatitude;

    private Integer status;

    private String citycode;

    private Integer applicantuserid;

    private Integer count;

    private Date createtime;

    private Integer currentcount;//当前众筹人数，临时字段，查base_custom_line_application表所得
    
    private Integer budgettime;//预计到达目的地需要多少时间，以分钟为单位
    
    private Boolean isPartIn;//临时字段，判断当前用户是否有参与该路线
    
    public CustomLine(){
    	
    }
    
    /**
	
	  * 创建一个新的实例 CustomLine. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  * @param id
	  * @param routeid
	  * @param startworktime
	  * @param offworktime
	  * @param startstation
	  * @param startlongitude
	  * @param startlatitude
	  * @param endstation
	  * @param endlongitude
	  * @param endlatitude
	  * @param citycode
	  * @param applicantuserid
	  */
	public CustomLine(String id, String routeid, String startworktime, String offworktime, String startstation,
			BigDecimal startlongitude, BigDecimal startlatitude, String endstation, BigDecimal endlongitude,
			BigDecimal endlatitude, String citycode, Integer applicantuserid) {
		super();
		this.id = id;
		this.routeid = routeid;
		this.startworktime = startworktime;
		this.offworktime = offworktime;
		this.startstation = startstation;
		this.startlongitude = startlongitude;
		this.startlatitude = startlatitude;
		this.endstation = endstation;
		this.endlongitude = endlongitude;
		this.endlatitude = endlatitude;
		this.citycode = citycode;
		this.applicantuserid = applicantuserid;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRouteno() {
        return routeno;
    }

    public void setRouteno(String routeno) {
        this.routeno = routeno == null ? null : routeno.trim();
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename == null ? null : routename.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStartworktime() {
        return startworktime;
    }

    public void setStartworktime(String startworktime) {
        this.startworktime = startworktime == null ? null : startworktime.trim();
    }

    public String getOffworktime() {
        return offworktime;
    }

    public void setOffworktime(String offworktime) {
        this.offworktime = offworktime == null ? null : offworktime.trim();
    }

    public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation == null ? null : startstation.trim();
    }

    public BigDecimal getStartlongitude() {
        return startlongitude;
    }

    public void setStartlongitude(BigDecimal startlongitude) {
        this.startlongitude = startlongitude;
    }

    public BigDecimal getStartlatitude() {
        return startlatitude;
    }

    public void setStartlatitude(BigDecimal startlatitude) {
        this.startlatitude = startlatitude;
    }

    public String getEndstation() {
        return endstation;
    }

    public void setEndstation(String endstation) {
        this.endstation = endstation == null ? null : endstation.trim();
    }

    public BigDecimal getEndlongitude() {
        return endlongitude;
    }

    public void setEndlongitude(BigDecimal endlongitude) {
        this.endlongitude = endlongitude;
    }

    public BigDecimal getEndlatitude() {
        return endlatitude;
    }

    public void setEndlatitude(BigDecimal endlatitude) {
        this.endlatitude = endlatitude;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public Integer getApplicantuserid() {
        return applicantuserid;
    }

    public void setApplicantuserid(Integer applicantuserid) {
        this.applicantuserid = applicantuserid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public Integer getCurrentcount() {
		return currentcount;
	}

	public void setCurrentcount(Integer currentcount) {
		this.currentcount = currentcount;
	}

	public Integer getBudgettime() {
		return budgettime;
	}

	public void setBudgettime(Integer budgettime) {
		this.budgettime = budgettime;
	}

	 public String getRouteid() {
            return routeid;
        }
        
        public void setRouteid(String routeid) {
            this.routeid = routeid;
        }

	public Boolean getIsPartIn() {
	    return isPartIn;
	}

	public void setIsPartIn(Boolean isPartIn) {
	    this.isPartIn = isPartIn;
	}

}