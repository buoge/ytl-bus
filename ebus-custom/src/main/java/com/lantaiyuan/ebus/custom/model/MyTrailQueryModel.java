/**
* <p>Title: MyTrailQueryModel.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.BaseModel;

/**
* <p>Title: MyTrailQueryModel</p>
* <p>Description: </p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年2月18日 下午5:36:20
*/
public class MyTrailQueryModel extends BaseModel<MyTrail>{

	/***serialVersionUID***/
	private static final long serialVersionUID = 1L;
	
	//主键id
    private Integer id;

    //用户id
    private Integer userid;

    //对象属性：起始站点
    private BaseStation startstation;
    
    //起始站点id
    private Integer startstationid;

    //起始时间
    private Date starttime;

    //对象属性：结束站点
    private BaseStation endstation;
    
    //结束站点id
    private Integer endstationid;

    //结束时间
    private Date endtime;

    //创建时间
    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public BaseStation getStartstation() {
		return startstation;
	}

	public void setStartstation(BaseStation startstation) {
		this.startstation = startstation;
	}

	public BaseStation getEndstation() {
		return endstation;
	}

	public void setEndstation(BaseStation endstation) {
		this.endstation = endstation;
	}

	public Integer getStartstationid() {
		return startstationid;
	}

	public void setStartstationid(Integer startstationid) {
		this.startstationid = startstationid;
	}

	public Integer getEndstationid() {
		return endstationid;
	}

	public void setEndstationid(Integer endstationid) {
		this.endstationid = endstationid;
	}
}
