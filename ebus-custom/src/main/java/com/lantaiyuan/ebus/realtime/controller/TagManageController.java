/**
* <p>Title: TagManageController.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.controller;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.model.Json;
import org.lanqiao.ssm.common.web.controller.base.BasicController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lantaiyuan.ebus.realtime.model.BaseFavoriteTag;
import com.lantaiyuan.ebus.realtime.model.valid.First;
import com.lantaiyuan.ebus.realtime.model.valid.Second;
import com.lantaiyuan.ebus.realtime.service.FavoriteTagServiceI;

/**
* <p>Title: TagManageController</p>
* <p>Description: 标签管理控制器</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年4月25日 下午6:55:07
*/
@RestController
@RequestMapping("/tag/manage")
public class TagManageController extends BasicController{
	@Resource
	private FavoriteTagServiceI favoriteTagService;

	/***
	 * 
	* <p>Title: addTag</p>
	* <p>Description: 新增自定义标签</p>
	* @param baseFavoriteTag
	* @return
	 */
	@PostMapping(value = "/add")
	public Json addTag(@Validated({First.class}) BaseFavoriteTag baseFavoriteTag) {
		int flag = favoriteTagService.insertSelective(baseFavoriteTag);
		return flag > 0 ? setSimpleSuccess() : setFailed("您已添加过此标签！");
	}

	/***
	 * 
	* <p>Title: updateTag</p>
	* <p>Description: 更新指定标签名称</p>
	* @param baseFavoriteTag
	* @return
	 */
	@PostMapping(value = "/update")
	public Json updateTag(@Validated({Second.class}) BaseFavoriteTag baseFavoriteTag) {
		int flag = favoriteTagService.updateByPrimaryKeySelective(baseFavoriteTag);
		return flag > 0 ? setSimpleSuccess() : setFailed("不存在此标签！");
	}
	
	/***
	 * 
	* <p>Title: deleteTag</p>
	* <p>Description: 删除指定标签</p>
	* @param id
	* @return
	 */
	@DeleteMapping(value = "/del/{id}")
	public Json deleteTag(@PathVariable String id) {
		int flag = favoriteTagService.deleteByPrimaryKey(id);
	    return flag > 0 ? setSimpleSuccess() : setFailed("不存在此标签！");
	}
	
	/***
	 * 
	* <p>Title: searchByUserId</p>
	* <p>Description: 查询用户自定义标签列表</p>
	* @param userid
	* @param citycode
	* @return
	 */
	@GetMapping(value = "/search/{userid}/{citycode}")
	public Json searchByUserId(@PathVariable String userid,
							   @PathVariable String citycode
			) {
		return setSimpleSuccess(favoriteTagService.queryCollectionTagsByUserId(userid,citycode));
	}
}
