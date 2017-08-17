/**
* <p>Title: CityTopicEnum.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.model.modelenum;

import java.util.Objects;

import com.lantaiyuan.ebus.constants.GlobalConstants;

/**
* <p>Title: CityTopicEnum</p>
* <p>Description: </p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月5日 下午6:52:36
*/
public enum CityTopicEnum {
	BENGBU_TOPIC("340300","gw2app-bengbu"),
	
	TIANSHUI_TOPIC("620500","gw2app-tianshui"),
	
	KAIPING_TOPIC("440783","gw2app-kaiping"),
	
	EERDUOSI_TOPIC("150600","gw2app-eerduosi"),
	
	DATONG_TOPIC("140200","gw2app-datong"),
	
	CHIBI_TOPIC("421281","gw2app-chibi"),
	
	SHANGQIU_TOPIC("411400","gw2app-shangqiu"),
	
	BAZHONG_TOPIC("511900","gw2app-bazhong"),
	
	QINHUANGDAO_TOPIC("130300","gw2app-qinhuangdao"),
	
	CHANGSHA_TOPIC("430100","gw2app-changsha"),
	
	MUDANJIANG_TOPIC("231000","gw2app-mudanjiang"),
	
	HANDAN_TOPIC("130400","gw2app-handan"),
	
	BAOJI_TOPIC("610300","gw2app-baoji"),
	
	LIUZHOU_TOPIC("450200","gw2app-liuzhou"),
	
	QIANJIANG_TOPIC("429005","gw2app-qianjiang"),
	
	TONGREN_TOPIC("429005","gw2app-tongren"),
	
	DEFAULT("000000","default");
	
	private String cityCode;
	private String desc;
	
	private CityTopicEnum(String cityCode,String desc){
		this.cityCode = cityCode;
		this.desc = desc;
	}
	
	/**
	* @return cityCode
	*/
	public String getCityCode() {
		return cityCode;
	}
	/**
	* @return desc
	*/
	public String getDesc() {
		return desc;
	}
	
	/**
	 * 不再抛出异常，而是没有匹配的就返回默认值
	 * @author yangyang
	 * @param desc
	 * @return
	 */
	public static CityTopicEnum desc(String desc){ 
		for(CityTopicEnum cityTopicEnum : values()){
			if(cityTopicEnum.desc.equals(desc)){
				return cityTopicEnum;
			}
		}
		return DEFAULT;
	}
	
	/**
	 * 
	 * @author yangyang
	 * @param cityCode
	 * @return
	 */
	public static CityTopicEnum cityCode(String cityCode) {
		for (CityTopicEnum topicEnum: CityTopicEnum.values()) { 
			for(int i = GlobalConstants.MAX_CITYCODE_LEN; i >= GlobalConstants.MIN_CITYCODE_LEN; i--) {
				if (cityCode.length() < 6) {
					System.out.println("short cityCode: " + cityCode);
				}
				if (Objects.equals(cityCode.substring(0, i), topicEnum.cityCode.substring(0, i))) {
					return topicEnum;
				}
			}
		}
		return DEFAULT;
	}
	
	
}
