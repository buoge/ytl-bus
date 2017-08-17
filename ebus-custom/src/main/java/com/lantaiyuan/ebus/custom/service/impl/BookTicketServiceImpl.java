package com.lantaiyuan.ebus.custom.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.pay.alipay.core.Config;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.lantaiyuan.ebus.common.constants.SysGlobalConstants;
import com.lantaiyuan.ebus.common.util.Position;
import com.lantaiyuan.ebus.common.util.Tools;
import com.lantaiyuan.ebus.custom.dao.BaseStationMapper;
import com.lantaiyuan.ebus.custom.dao.BookTicketMapper;
import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.model.BookTicket;
import com.lantaiyuan.ebus.custom.model.BookTicketQueryModel;
import com.lantaiyuan.ebus.custom.model.MyTicketInfo;
import com.lantaiyuan.ebus.custom.model.MyTickets;
import com.lantaiyuan.ebus.custom.model.OnBusInfo;
import com.lantaiyuan.ebus.custom.model.TicketDetail;
import com.lantaiyuan.ebus.custom.model.TicketDetailQueryModel;
import com.lantaiyuan.ebus.custom.service.BaseStationServiceI;
import com.lantaiyuan.ebus.custom.service.BookTicketServiceI;
import com.lantaiyuan.ebus.custom.service.OnBusInfoServiceI;

/**
 * 
  * @ClassName: BookTicketServiceImpl
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2016年12月20日 下午9:12:43
 */
@Service("bookTicketService")
public class BookTicketServiceImpl extends BaseService<BookTicket, BookTicketQueryModel> implements BookTicketServiceI {
	@Resource
	private BookTicketMapper bookTicketMapper;
	@Resource
	private BaseStationMapper baseStationMapper;
	@Resource
	private BaseStationServiceI baseStationService;
	@Resource
	private OnBusInfoServiceI onBusInfoService;
	
	@Override
	public BaseDAO<BookTicket, BookTicketQueryModel> getDao() {
		return bookTicketMapper;
	}
	
	@Override
	public List<MyTicketInfo> queryMyTickets(String userid, String citycode) {
		List<MyTickets> ticketsList = bookTicketMapper.queryMyTickets(userid, citycode);
		List<MyTicketInfo> myTicketInfoList = new ArrayList<>();
		ticketsList.forEach(myTickets -> {
			TicketDetailQueryModel ticketDetailQueryModel = new TicketDetailQueryModel();
			MyTicketInfo myTicketInfo = new MyTicketInfo();
			ticketDetailQueryModel.setUserid(Integer.valueOf(userid));
			BeanUtils.copyProperties(myTickets, ticketDetailQueryModel);
			ticketDetailQueryModel.setCitycode(citycode);
			String takedate = bookTicketMapper.queryTicketDetail(ticketDetailQueryModel).getTakedate();
			BeanUtils.copyProperties(myTickets, myTicketInfo);
			myTicketInfo.setTakedate(takedate);
			myTicketInfoList.add(myTicketInfo);
		});
       
		myTicketInfoList.forEach(myTicketInfoEach -> {
			BaseStation sourcelocation = baseStationMapper.queryStationByName(myTicketInfoEach.getSourcelocation(),citycode);
			BaseStation targetlocation = baseStationMapper.queryStationByName(myTicketInfoEach.getTargetlocation(),citycode);
			//当数据库没有站点信息，给默认值
			if (sourcelocation == null || targetlocation == null) {
				myTicketInfoEach.setDistance(new BigDecimal(0)); 
				myTicketInfoEach.setBudgettime(0);
			} else {
			double longitudeOfSource = sourcelocation.getLongitude().doubleValue();
			double latitudeOfSource = sourcelocation.getLatitude().doubleValue();
			double longitudeOfTarget = targetlocation.getLongitude().doubleValue();
			double latitudeOfTarget = targetlocation.getLatitude().doubleValue();
			Position source = new Position(longitudeOfSource, latitudeOfSource);
			Position target = new Position(longitudeOfTarget, latitudeOfTarget);
			BigDecimal distance = Position.getDistance(source, target);
			// 两站距离
			myTicketInfoEach.setDistance(distance);
			//1千米默认用时2分钟
			myTicketInfoEach.setBudgettime(distance.intValue() * 2);
			}
		});
		return myTicketInfoList;
	}

	@Override
	public int updateStatusToValid(String orderNo) {
		return bookTicketMapper.updateStatusToValid(orderNo);
	}

	@Override
	public Map<String, String> generateTicketCode(TicketDetailQueryModel ticketDetailQueryModel) {
		// 第二版票价二维码格式：1-2（2位）到期日期
		// 3-6（4位）票价：单位为分，最大9999，7-12表示城市id(6位)，13-18位为线路id（6位）
		// 19-38位为车票编号_唯一标识:（20位），39-48（10位）车票生成时间戳           第49（1位）车票是否有效
		TicketDetail ticketDetail = bookTicketMapper.queryTicketDetail(ticketDetailQueryModel);
		ticketDetail.setTimestamp(String.valueOf(new Date().getTime()/1000));
		String[] takeDate = ticketDetail.getTakedate().split("-");
		StringBuilder ticketCode = new StringBuilder(Tools.generateStr(takeDate[2], 2))
				.append(Tools.generateStr(new Double(ticketDetail.getPrice().doubleValue() * 100).intValue() + "", 4))
				.append(Tools.generateStr(ticketDetail.getCitycode(), 6))
				.append(Tools.generateStr(ticketDetail.getRouteid(), 6))
				.append(Tools.generateStr(ticketDetail.getOrderno(), 20)) 
				.append(Tools.generateStr(ticketDetail.getTimestamp(), 10))
				.append(SysGlobalConstants.PAY_STATUS_SUCCESS_CODE.equals(ticketDetailQueryModel.getTicketstatus()) ? SysGlobalConstants.PAY_STATUS_SUCCESS_CODE : SysGlobalConstants.ORDER_NOT_PAY_CODE);
		String rsaSign = "";
		try {
			rsaSign = AlipaySignature.rsaSign(ticketCode.toString(), Config.RSA_RRIVATE_KEY, Config.CHARSET);
		} catch (AlipayApiException e) {
			logger.error("****AlipayApiException****"+e.getMessage(),e);
		}
		Map<String, String> ticketCodeMap = new HashMap<>();
		ticketCodeMap.put(SysGlobalConstants.PARAM_TICKET_CODE, ticketCode + rsaSign.substring(0, 10));
		return ticketCodeMap;
	}

	@Override
	public int updateStatusToUsed(String ticketId) {
		return bookTicketMapper.updateStatusToUsed(ticketId);
	}
	 
	@Override
	public List<BookTicket> queryUnPaidTicketOrder(Integer userId, String routeId, String cityCode,String[] takeDateArr) {
		int serverDateLength = takeDateArr.length;
		List<String> dateList = new ArrayList<>();
		for (int i = 0; i < serverDateLength; i++) {
			dateList.add(takeDateArr[i].trim().substring(1, takeDateArr[i].trim().length() - 1));
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(SysGlobalConstants.PARAM_USER_ID, userId);
		params.put(SysGlobalConstants.PARAM_ROUTE_ID, routeId);
		params.put(SysGlobalConstants.PARAM_CITY_CODE, cityCode);
		params.put(SysGlobalConstants.PARAM_TAKE_DATE, dateList);
		return bookTicketMapper.queryUnPaidTicketOrder(params);
	}

	@Override
	public void updateTicketStatusFromGw(String ticketInfo) {
		JSONObject jsonObj = JSONObject.parseObject(ticketInfo);
		if ("LTY-P".equals(jsonObj.getString("packetType"))) {//代表的是车票类型的包
			logger.info("*****接受车票消息开始***********");
			String ticketId = jsonObj.getString("orderNumber");//车票唯一性Id标志，并不是指真正意义上的订单号
			int direction = jsonObj.getIntValue("direction");//线路方向
			int onBusStationNo = jsonObj.getIntValue("onBusStationNo");//用户上车站台的站序
			String onBusTime=jsonObj.getString("onBusTime");
			BaseStation onBusStation =baseStationService.queryStationByTicketIdAndStationNo(ticketId, direction, onBusStationNo);
			OnBusInfo onBusInfo = new OnBusInfo(ticketId, onBusTime, onBusStation.getName());
			onBusInfoService.insertSelective(onBusInfo);
			int flag = updateStatusToUsed(ticketId);
			Assert.isTrue(flag == 1, "车票id有误");
		}
		
	}
}
