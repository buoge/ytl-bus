package com.lantaiyuan.ebus.custom.model;

import java.util.List;

import org.lanqiao.ssm.common.model.Model;
import org.lanqiao.ssm.common.page.Page;

public class CustomLineSubList extends Model{

	public CustomLineSubList(String promoter, List<StationCount> start, List<StationCount> end,
			Page<CustomLineApplication> pageList,List<CustomLineApplication> filteredResult) {
		super();
		this.promoter = promoter;
		this.start = start;
		this.end = end;
		this.pageList = pageList;
		this.filteredResult = filteredResult;
	}

	private static final long serialVersionUID = 6980362825471244505L;
	
	private String promoter;
	private List<StationCount> start;
	private List<StationCount> end;
	private List<CustomLineApplication> filteredResult;
	
	private Page<CustomLineApplication> pageList;

	public String getPromoter() {
		return promoter;
	}

	
	public List<CustomLineApplication> getFilteredResult() {
		return filteredResult;
	}


	public void setFilteredResult(List<CustomLineApplication> filteredResult) {
		this.filteredResult = filteredResult;
	}


	public void setPromoter(String promoter) {
		this.promoter = promoter;
	}

	public List<StationCount> getStart() {
		return start;
	}

	public void setStart(List<StationCount> start) {
		this.start = start;
	}

	public List<StationCount> getEnd() {
		return end;
	}

	public void setEnd(List<StationCount> end) {
		this.end = end;
	}

	public Page<CustomLineApplication> getPageList() {
		return pageList;
	}

	public void setPageList(Page<CustomLineApplication> pageList) {
		this.pageList = pageList;
	}
 
}
