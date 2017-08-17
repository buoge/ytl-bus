package com.lantaiyuan.ebus.custom.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.CustomLineApplication;
import com.lantaiyuan.ebus.custom.model.CustomLineApplicationQueryModel;
import com.lantaiyuan.ebus.custom.model.CustomLineComment;

public interface CustomLineApplicationServiceI extends BaseServiceI<CustomLineApplication, CustomLineApplicationQueryModel>{

    Object findByLineId(String lineid);

	/**
	  * extraApply(专线加开)
	  * @param @param customLineComment
	  */
	int extraApply(CustomLineComment customLineComment);
	
	Object findCustomLineSubListByPage(CustomLineApplicationQueryModel model, int page);

	Object getMapCount(String lineId);
}
