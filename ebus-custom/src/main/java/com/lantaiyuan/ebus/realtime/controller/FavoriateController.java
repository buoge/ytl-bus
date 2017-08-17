/**
* <p>Title: FavoriteController.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.realtime.model.FavoriateQueryModel;
import com.lantaiyuan.ebus.realtime.service.FavoriateServiceI;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
* <p>Title: FavoriteController</p>
* <p>Description: 用户个人收藏相关控制器</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2016年12月22日 下午6:20:44
*/
@RestController
@RequestMapping("/favoriteCustom")
public class FavoriateController extends BasicController{
	@Resource
	private FavoriateServiceI favoriateService;
	
	@ApiOperation(value = "根据用户输入userId查询收藏线路  返回json")
	@GetMapping(value = "/routes" )
	public Json getCollectionRoutes(@ApiParam(value = "userid") @RequestParam Integer userid,@ApiParam(value = "citycode") @RequestParam String citycode) {
		 return setSimpleSuccess(favoriateService.getCollectionRoutes(userid, citycode));
	}
	
	@ApiOperation(value = "查询标签 返回json")
	@GetMapping(value = "/tags" )
	public Json getCollectionTags(@ApiParam(value = "userid") @RequestParam String userid,@ApiParam(value = "citycode") @RequestParam String citycode) {
		return setSimpleSuccess(favoriateService.getCollectionTags(userid, citycode));
	}
	
	@ApiOperation(value = "收藏新增 返回json")
	@GetMapping(value = "/addition" )
	public Json add(@Valid FavoriateQueryModel favoriateQueryModel) {
		boolean flag = favoriateService.addFavoriteRoute(favoriateQueryModel);
		return flag ? setSimpleSuccess() : setFailed("您已收藏过该站点，站点标签不可再收藏为"+favoriateQueryModel.getTag());
	}

	@ApiOperation(value = "收藏路线删除 返回json")
	@GetMapping(value = "/deletion" )
	public Json delete(@Valid FavoriateQueryModel favoriateQueryModel) {		
		boolean flag = favoriateService.deleteFavoriteRoute(favoriateQueryModel);
		return flag ? setSimpleSuccess() : setFailed("收藏线路不存在或者删除线路不成功！");
	}
}
