package com.lantaiyuan.ebus.custom.service;

import java.util.List;
import org.lanqiao.ssm.common.core.service.BaseServiceI;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAround;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundDetail;
import com.lantaiyuan.ebus.custom.model.travelaround.TravelAroundQueryModel;

/**
 * 
 * @ClassName: TravelAroundServiceI
 * @author Yuan.Tan
 * @date 2017年7月18日 上午11:51:01
 *
 */
public interface TravelAroundServiceI extends BaseServiceI<TravelAround, TravelAroundQueryModel> {

	List<TravelAround> queryTravelList(String cityCode);

	TravelAroundDetail queryTravelDetail(String id);
}
