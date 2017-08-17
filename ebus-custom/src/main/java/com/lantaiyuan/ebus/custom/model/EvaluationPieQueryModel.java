package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.BaseModel;

/**
 *  车辆（站点）评价表
 * Evaluation
 * 数据库表：base_evaluation
 */
public class EvaluationPieQueryModel extends BaseModel {
	/**
	  * @Fields serialVersionUID :
	  */
	private static final long serialVersionUID = 1L;
    private String name;//评价等级名
    private double score;//分数
    private int count;//数量
    private String citycode;
    
    public EvaluationPieQueryModel( ){
    }
    
    public EvaluationPieQueryModel(String name ,double score,int count ){
    	this.name = name;
    	this.count=count;
    	this.score = score;
    }
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	public int add(int count) {
		return this.count + count;
	}

	/**
	 * @return the citycde
	 */
	public String getCitycode() {
		return citycode;
	}

	/**
	 * @param citycde the citycde to set
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

    
}