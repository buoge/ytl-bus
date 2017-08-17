/**
* <p>Title: QueryController.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;
import com.lantaiyuan.ebus.custom.service.BaseStationServiceI;
import com.lantaiyuan.ebus.custom.service.UserOdServiceI;
import com.lantaiyuan.ebus.realtime.service.TravelServiceI;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
* <p>Title: QueryController</p>
* <p>Description: </p>
* <p>Company: lty</p>
* @author liuhao
* @date 2016年12月20日 下午5:16:57
*/
@RestController
@RequestMapping("/queryRouteStation")
public class RouteStationQueryController extends BasicController {
	@Resource
	private BaseRouteServiceI baseRouteService;

	@Resource
	private BaseStationServiceI baseStationService;

	@Resource
	private TravelServiceI travelService;
	
	@Resource
	private UserOdServiceI userOdService;

	/**
	 * @param jsonStr
	 * 模糊匹配路线和站点
	 * @return
	 */
	@ApiOperation(value = "根据用户输入的信息进行模糊查询线路和站点  返回json")
	@GetMapping(value = "/routeAndStation")
	public Json getRouteAndStationByName(@ApiParam(value = "name") @RequestParam String name, @ApiParam(value = "citycode") @RequestParam String citycode) {
		return setSimpleSuccess(baseRouteService.getRouteAndStationByName(name, citycode));
	}

	@ApiOperation(value = "根据语音信息模糊查询线路  返回json")
	@GetMapping(value = "/audioRoutesFilter")
	public Json getAudioRoutesFilter(@ApiParam(value = "audioinfo") @RequestParam String audioinfo, @ApiParam(value = "citycode") @RequestParam String citycode) {
		return setSimpleSuccess(baseRouteService.getRoutesByAudioInfo(audioinfo, citycode));
	}

	@ApiOperation(value = "通过站点Id获取经过该站点的所有线路  返回json(电子站牌1)")
	@GetMapping(value = "/route")
	public Json getRoutesByStationId(@ApiParam(value = "stationid") @RequestParam String stationid, @ApiParam(value = "citycode") @RequestParam String citycode)
			throws Exception {
		return setSimpleSuccess(baseStationService.getRoutesByStationId(stationid, citycode));
	}

	@ApiOperation(value = "通过站点名称获取经过该站点的所有线路  返回json(电子站牌2)")
	@GetMapping(value = "/routesByStationName")
	public Json getRoutesByStationName(@ApiParam(value = "stationname") @RequestParam String stationname, @ApiParam(value = "citycode") @RequestParam String citycode)
			throws Exception {
		return setSimpleSuccess(baseStationService.getRoutesByStationName(stationname, citycode));
	}

	@ApiOperation(value = "精确匹配数字关键字线路")
	@GetMapping(value = "/routesByKeyword")
	public Json getRoutesByKeyword(@ApiParam(value = "keyword") @RequestParam String keyword, @ApiParam(value = "citycode") @RequestParam String citycode)
			throws Exception {
		return setSimpleSuccess(baseRouteService.getRoutesByKeywordNumber(keyword, citycode));
	}

	@ApiOperation(value = "根据当前stationId/stationName/cityCode获取到达目标站点所有线路集合  返回json")
	@GetMapping(value = "/targetRoutes")
	public Json getRoutesByStationIdAndStationName(@ApiParam(value = "stationid") @RequestParam String stationid,
			@ApiParam(value = "stationname") @RequestParam String stationname, @ApiParam(value = "citycode") @RequestParam String citycode) throws Exception {
		return setSimpleSuccess(baseStationService.getRoutesByStationIdAndStationName(stationid, stationname, citycode));
	}

	/**
	 * 功能描述:获取最近站点和最近站点通过的线路 以及附近站点，默认1000米 
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月21日 下午4:12:03
	 * 说明：参数baseStation中传递longitude latitude cityCode
	 */
	@ResponseBody
	@GetMapping(value = "/nearestStation")
	public Json getNearestStationAndNearStations(@Validated BaseStation baseStation) {
		return setSimpleSuccess(baseStationService.getNearestInfo(baseStation));
	}

	/**
	 * 功能描述:分别查出步行5分钟和10分钟内的站点信息（包含经过该站点的线路信息）
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月22日 下午1:56:18
	 */
	@GetMapping(value = "/nearStationsFiveAndTen")
	public Json nearStationsWithRouteFiveAndTen(BaseStation baseStation) {
		return setSimpleSuccess(baseStationService.nearStationsWithRouteFiveAndTen(baseStation));
	}

	/**
	 * 功能描述:附近站点(默认500m范围内),前端暂时没有调用
	 * 作者:温海金
	 * 最后更改时间 : 2016年12月22日 下午1:56:18
	 */
	@GetMapping(value = "/nearStations")
	@Deprecated
	public Json nearStations(BaseStation baseStation) {
		return setSimpleSuccess(baseStationService.nearStations(baseStation));
	}

	/**
	 * 功能描述:根据起始点查询人民公交
	 * 作者:温海金
	 * 最后更改时间 : 2017年6月8日 下午5:16:22
	 */
	@GetMapping(value = "/findRoutesByStartAndDistinctPlace")
	public Json findRoutesByStartAndDistinctPlace(BigDecimal startlongitude, BigDecimal startlatitude, BigDecimal endlongitude, BigDecimal endlatitude, String citycode) {
		return setSimpleSuccess(baseRouteService.findRoutesByStartAndDistinctPlace(startlongitude, startlatitude, endlongitude, endlatitude, citycode));
	}
	
	/**
	 * 功能描述:根据起始点查询所有公交线路
	 * 作者:温海金
	 * 最后更改时间 : 2017年6月8日 下午5:16:22
	 */
	@GetMapping(value = "/findAllRoutesByStartAndDistinctPlace")
	public Json findAllRoutesByStartAndDistinctPlace(
			@RequestParam BigDecimal startlongitude,
			@RequestParam BigDecimal startlatitude,
			@RequestParam BigDecimal endlongitude,
			@RequestParam BigDecimal endlatitude,
			@RequestParam(required=false) String citycode,
			@RequestParam(required=false) Integer status
			) {
		return setSimpleSuccess(baseRouteService.findAllRoutesByStartAndDistinctPlace(startlongitude,startlatitude,endlongitude,endlatitude,citycode));
	}
	
	/**
	 * 功能描述:根据当前位置查询经过该位置附近站点的人民公交
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月17日 下午4:40:38
	 */
	@GetMapping(value = "/findLinesWithRealTimeByStation")
	public Json getLinesNearBy(BaseStation baseStation) {
		return setSimpleSuccess(baseStationService.getLinesNearBy(baseStation));
	}
	
	/**
	 * 功能描述:根据当前位置查询经过该位置附近站点的所有公交（包括人民公交，公交专线，拼车信息）
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月17日 下午4:40:38
	 */
	@GetMapping(value = "/findAllLinesByCurrentLocation")
	public Json findAllLinesByCurrentLocation(
			@RequestParam BigDecimal startlongitude,
			@RequestParam BigDecimal startlatitude,
			@RequestParam(required=false) String citycode) {
		return setSimpleSuccess(baseRouteService.findAllLinesByCurrentLocation(startlongitude, startlatitude, citycode));
	}
	
	/**
	 * 功能描述:根据用户ID得到常用OD点
	 * 作者:温海金
	 * 最后更改时间 : 2017年7月19日 下午3:30:48
	 */
	@GetMapping(value = "/getODByUserId")
	public Json getODByUserId(@RequestParam Integer userId) {
		return setSimpleSuccess(userOdService.getODByUserId(userId));
	}
	
}
