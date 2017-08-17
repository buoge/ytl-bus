package com.lantaiyuan.ebus.custom.model.enummodel;

/** 
  * @Title: EvaluationRankEnum.java
  * @Package com.lantaiyuan.ebus.custom.model.enummodel
  * @Description: 评价等级枚举类
  * @author YvanTan
  * @date 2017年3月29日 上午10:59:30
  * @version v1.3.0 
 */
public enum EvaluationRankEnum {
	WORST("很不满意",0),
	TERRIBLE("很不满意",20),
	AWFUL("不满意",25),
	WRONG("不满意",40),
	BAD("不满意",50),
	COMMON("一般",60),
	GOOD("满意",75),
	FINE("满意",80),
	GREAT("很满意",100); 
 
	private String rankName;
	private int score;
	
	EvaluationRankEnum(String rankName,int score){
		this.rankName = rankName;
		this.score = score;
	}
	
	public String rankName() {
		return rankName;
	}
	
	public int score() {
		return score;
	}
	

}
