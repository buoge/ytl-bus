package com.lantaiyuan.ebus.custom.model;

import java.util.List;

/**
 * 描述:所有线路信息（人民公交，专线，后续与大数据集成的拼公交线路）
 * 根据用户输入的起点和终点进行搜索得到的结果
 * 作者:温海金
 * 最后更改时间:下午5:58:55
 */
public class AllRoutesVo {
	/**
	 * 人民公交线路集合
	 */
	List<GeneralRoute> generalRoutes;
	/**
	 * 专线集合
	 */
	List<CustomLine> customLines;

	public AllRoutesVo() {
	}
	
	public AllRoutesVo(List<GeneralRoute> generalRoutes, List<CustomLine> customLines) {
		super();
		this.generalRoutes = generalRoutes;
		this.customLines = customLines;
	}

	public List<GeneralRoute> getGeneralRoutes() {
		return generalRoutes;
	}

	public void setGeneralRoutes(List<GeneralRoute> generalRoutes) {
		this.generalRoutes = generalRoutes;
	}

	public List<CustomLine> getCustomLines() {
		return customLines;
	}

	public void setCustomLines(List<CustomLine> customLines) {
		this.customLines = customLines;
	}
	
	
}
