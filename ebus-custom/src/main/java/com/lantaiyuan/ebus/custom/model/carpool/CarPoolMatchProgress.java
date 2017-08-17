package com.lantaiyuan.ebus.custom.model.carpool;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

/**
 * 撮合进度表(拼车业务)
 * CarPoolMatchProgress
 * 数据库表：carpool_match_progress
 */
public class CarPoolMatchProgress extends Model {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 自增主键
     * 表字段 : carpool_match_progress.id
     */
    private Long id;

    /**
     * 对应carpool_match的撮合id
     * 表字段 : carpool_match_progress.match_id
     */
    private String matchId;

    /**
     * 撮合类型:1-首次撮合 2-正在撮合 3-最后一次撮合
     * 表字段 : carpool_match_progress.progess_type
     */
    private Boolean progessType;

    /**
     * 撮合进度号：代表第几次撮合
     * 表字段 : carpool_match_progress.progess_no
     */
    private String progessNo;

    /**
     * 此次撮合对应的拼车订单号
     * 表字段 : carpool_match_progress.progess_order_no
     */
    private String progessOrderNo;

    /**
     * 撮合详情
     * 表字段 : carpool_match_progress.progress_detail
     */
    private String progressDetail;

    /**
     * 城市编码
     * 表字段 : carpool_match_progress.city_code
     */
    private String cityCode;

    /**
     * 创建时间
     * 表字段 : carpool_match_progress.gmt_create
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     * 表字段 : carpool_match_progress.gmt_modified
     */
    private Date gmtModified;

    /**
     * 
     * 表字段 : carpool_match_progress.field1
     */
    private String field1;

    /**
     * 
     * 表字段 : carpool_match_progress.field2
     */
    private String field2;

    /**
     * 
     * 表字段 : carpool_match_progress.field3
     */
    private String field3;

    /**
     * 获取 自增主键 字段:carpool_match_progress.id
     *
     * @return carpool_match_progress.id, 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 自增主键 字段:carpool_match_progress.id
     *
     * @param id the value for carpool_match_progress.id, 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 对应carpool_match的撮合id 字段:carpool_match_progress.match_id
     *
     * @return carpool_match_progress.match_id, 对应carpool_match的撮合id
     */
    public String getMatchId() {
        return matchId;
    }

    /**
     * 设置 对应carpool_match的撮合id 字段:carpool_match_progress.match_id
     *
     * @param matchId the value for carpool_match_progress.match_id, 对应carpool_match的撮合id
     */
    public void setMatchId(String matchId) {
        this.matchId = matchId == null ? null : matchId.trim();
    }

    /**
     * 获取 撮合类型:1-首次撮合 2-正在撮合 3-最后一次撮合 字段:carpool_match_progress.progess_type
     *
     * @return carpool_match_progress.progess_type, 撮合类型:1-首次撮合 2-正在撮合 3-最后一次撮合
     */
    public Boolean getProgessType() {
        return progessType;
    }

    /**
     * 设置 撮合类型:1-首次撮合 2-正在撮合 3-最后一次撮合 字段:carpool_match_progress.progess_type
     *
     * @param progessType the value for carpool_match_progress.progess_type, 撮合类型:1-首次撮合 2-正在撮合 3-最后一次撮合
     */
    public void setProgessType(Boolean progessType) {
        this.progessType = progessType;
    }

    /**
     * 获取 撮合进度号：代表第几次撮合 字段:carpool_match_progress.progess_no
     *
     * @return carpool_match_progress.progess_no, 撮合进度号：代表第几次撮合
     */
    public String getProgessNo() {
        return progessNo;
    }

    /**
     * 设置 撮合进度号：代表第几次撮合 字段:carpool_match_progress.progess_no
     *
     * @param progessNo the value for carpool_match_progress.progess_no, 撮合进度号：代表第几次撮合
     */
    public void setProgessNo(String progessNo) {
        this.progessNo = progessNo == null ? null : progessNo.trim();
    }

    /**
     * 获取 此次撮合对应的拼车订单号 字段:carpool_match_progress.progess_order_no
     *
     * @return carpool_match_progress.progess_order_no, 此次撮合对应的拼车订单号
     */
    public String getProgessOrderNo() {
        return progessOrderNo;
    }

    /**
     * 设置 此次撮合对应的拼车订单号 字段:carpool_match_progress.progess_order_no
     *
     * @param progessOrderNo the value for carpool_match_progress.progess_order_no, 此次撮合对应的拼车订单号
     */
    public void setProgessOrderNo(String progessOrderNo) {
        this.progessOrderNo = progessOrderNo == null ? null : progessOrderNo.trim();
    }

    /**
     * 获取 撮合详情 字段:carpool_match_progress.progress_detail
     *
     * @return carpool_match_progress.progress_detail, 撮合详情
     */
    public String getProgressDetail() {
        return progressDetail;
    }

    /**
     * 设置 撮合详情 字段:carpool_match_progress.progress_detail
     *
     * @param progressDetail the value for carpool_match_progress.progress_detail, 撮合详情
     */
    public void setProgressDetail(String progressDetail) {
        this.progressDetail = progressDetail == null ? null : progressDetail.trim();
    }

    /**
     * 获取 城市编码 字段:carpool_match_progress.city_code
     *
     * @return carpool_match_progress.city_code, 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置 城市编码 字段:carpool_match_progress.city_code
     *
     * @param cityCode the value for carpool_match_progress.city_code, 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取 创建时间 字段:carpool_match_progress.gmt_create
     *
     * @return carpool_match_progress.gmt_create, 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段:carpool_match_progress.gmt_create
     *
     * @param gmtCreate the value for carpool_match_progress.gmt_create, 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 最后修改时间 字段:carpool_match_progress.gmt_modified
     *
     * @return carpool_match_progress.gmt_modified, 最后修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置 最后修改时间 字段:carpool_match_progress.gmt_modified
     *
     * @param gmtModified the value for carpool_match_progress.gmt_modified, 最后修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取  字段:carpool_match_progress.field1
     *
     * @return carpool_match_progress.field1, 
     */
    public String getField1() {
        return field1;
    }

    /**
     * 设置  字段:carpool_match_progress.field1
     *
     * @param field1 the value for carpool_match_progress.field1, 
     */
    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    /**
     * 获取  字段:carpool_match_progress.field2
     *
     * @return carpool_match_progress.field2, 
     */
    public String getField2() {
        return field2;
    }

    /**
     * 设置  字段:carpool_match_progress.field2
     *
     * @param field2 the value for carpool_match_progress.field2, 
     */
    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    /**
     * 获取  字段:carpool_match_progress.field3
     *
     * @return carpool_match_progress.field3, 
     */
    public String getField3() {
        return field3;
    }

    /**
     * 设置  字段:carpool_match_progress.field3
     *
     * @param field3 the value for carpool_match_progress.field3, 
     */
    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}