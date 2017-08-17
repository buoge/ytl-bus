/**
* <p>Title: AudioRouteReturnEnum.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.model.enummodel;

/**
* <p>Title: AudioRouteReturnEnum</p>
* <p>Description: 语音线路精确匹配枚举</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月8日 下午2:27:05
*/
public enum AudioRouteReturnEnum {
	EMPTY_RESULT(0,"无目标结果"),
	UNIQUE_RESULT(1,"仅有唯一结果"),
	MULTIPLE_RESULT(2,"有多个结果");
	
	private Integer type;
	private String desc;
	
	private AudioRouteReturnEnum(Integer type,String desc){
		this.type = type;
		this.desc = desc;
	}
	
	/**
	* @return type
	*/
	public Integer getType() {
		return type;
	}

	/**
	* @return desc
	*/
	public String getDesc() {
		return desc;
	}

	public static AudioRouteReturnEnum valueOf(Integer type){
		for(AudioRouteReturnEnum status : values()){
			if(status.type == type){
				return status;
			}
		}
		
		throw new IllegalArgumentException("No matching constant for [" + type + "]");
	}
}
