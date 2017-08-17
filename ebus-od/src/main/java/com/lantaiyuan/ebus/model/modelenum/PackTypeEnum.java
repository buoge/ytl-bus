/**
* <p>Title: PackTypeEnum.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.model.modelenum;

/**
* <p>Title: PackTypeEnum</p>
* <p>Description: </p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月5日 下午6:09:58
*/
public enum PackTypeEnum {
	GPS_PACK("gps"),
	INSTATION_PACK("inStation"),
	OUTSTATION_PACK("outStation"),
	INOUTPARK_PACK("inoutPark");
	
	private String packType;
	
	private PackTypeEnum(String packType){
		this.packType = packType;
	}

	/**
	* @return packType
	*/
	public String getPackType() {
		return packType;
	}
	
	public static PackTypeEnum value(String packType) {
		for (PackTypeEnum pack : values()) {
			if (pack.packType.equals(packType)) {
				return pack;
			}
		}
		throw new IllegalArgumentException("No matching constant for [" + packType + "]");
	}
}
