package com.lantaiyuan.ebus.custom.model;

import java.math.BigDecimal;
import java.util.Date;
import org.lanqiao.ssm.common.model.Model;

/**
 * 
 * @ClassName: CustomLineApplication
 * @author Yuan.Tan
 * @date 2016年11月8日 上午11:46:41
 *
 */
public class CustomLineApplication extends Model {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String lineid;

	private Integer userid;

	private String username;

	private String sourcelocation;

	private String targetlocation;

	private BigDecimal startlongitude;

	private BigDecimal startlatitude;

	private BigDecimal endlongitude;

	private BigDecimal endlatitude;

	private String starttime;

	private String backtime;

	private Date createtime;

	private Integer flag;

	private Integer applicantid;

	public CustomLineApplication() {

	}

	public CustomLineApplication(String lineid, Integer userid, String username, String sourcelocation,
			String targetlocation, BigDecimal startlongitude, BigDecimal startlatitude, BigDecimal endlongitude,
			BigDecimal endlatitude, String starttime, String backtime, Integer applicantid, Integer flag) {
		super();
		this.lineid = lineid;
		this.userid = userid;
		this.username = username;
		this.sourcelocation = sourcelocation;
		this.targetlocation = targetlocation;
		this.startlongitude = startlongitude;
		this.startlatitude = startlatitude;
		this.endlongitude = endlongitude;
		this.endlatitude = endlatitude;
		this.starttime = starttime;
		this.backtime = backtime;
		this.applicantid = applicantid;
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLineid() {
		return lineid;
	}

	public void setLineid(String lineid) {
		this.lineid = lineid == null ? null : lineid.trim();
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getSourcelocation() {
		return sourcelocation;
	}

	public void setSourcelocation(String sourcelocation) {
		this.sourcelocation = sourcelocation == null ? null : sourcelocation.trim();
	}

	public String getTargetlocation() {
		return targetlocation;
	}

	public void setTargetlocation(String targetlocation) {
		this.targetlocation = targetlocation == null ? null : targetlocation.trim();
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

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime == null ? null : starttime.trim();
	}

	public String getBacktime() {
		return backtime;
	}

	public void setBacktime(String backtime) {
		this.backtime = backtime == null ? null : backtime.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getApplicantid() {
		return applicantid;
	}

	public void setApplicantid(Integer applicantid) {
		this.applicantid = applicantid;
	}
}