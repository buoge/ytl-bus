package com.lantaiyuan.ebus.custom.service;

import java.util.List;
import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.CustomStation;
import com.lantaiyuan.ebus.custom.model.CustomStationQueryModel;

public interface CustomStationServiceI extends BaseServiceI<CustomStation, CustomStationQueryModel> {

	List<CustomStationQueryModel> findStationByLineId(String lineId);

	List<CustomStation> findAllCustomStation();

	void addStationByLineId(CustomStationQueryModel stationQM);

}
