package com.lantaiyuan.ebus.custom.model.carpool;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lantaiyuan.ebus.carpool.model.CarpoolMatch;
import com.lantaiyuan.ebus.carpool.model.CarpoolOrder;
import org.lanqiao.ssm.common.model.Model;

/**
 * 包含用户提交的拼车信息、最新撮合动态的实体类
 * @author yangyang
 * @date 2017年6月13日 下午4:20:25 
 */
public class CarpoolDetail extends Model {

	private static final long serialVersionUID = 3559023038084278511L;
	
	@JsonIgnore
	private Long id;
	
	private String carpoolRouteName;
	
	private CarpoolMatch carpoolMatch;
	
	public String getCarpoolRouteName() {
		return carpoolRouteName;
	}

	public void setCarpoolRouteName(String carpoolRouteName) {
		this.carpoolRouteName = carpoolRouteName;
	}

	private CarpoolOrder carpoolOrder;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CarpoolMatch getCarpoolMatch() {
		return carpoolMatch;
	}

	public void setCarpoolMatch(CarpoolMatch carpoolMatch) {
		this.carpoolMatch = carpoolMatch;
	}

	public CarpoolOrder getCarpoolOrder() {
		return carpoolOrder;
	}

	public void setCarpoolOrder(CarpoolOrder carpoolOrder) {
		this.carpoolOrder = carpoolOrder;
	}

}
