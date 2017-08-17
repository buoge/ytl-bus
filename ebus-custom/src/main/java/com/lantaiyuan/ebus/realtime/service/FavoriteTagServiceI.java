/**
* <p>Title: FavoriteTagServiceI.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.realtime.model.BaseFavoriteTag;
import com.lantaiyuan.ebus.realtime.model.BaseFavoriteTagQueryModel;

/**
* <p>Title: FavoriteTagServiceI</p>
* <p>Description: 自定义标签业务接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年4月26日 上午9:16:07
*/
public interface FavoriteTagServiceI extends BaseServiceI<BaseFavoriteTag, BaseFavoriteTagQueryModel>{
	public List<String> queryCollectionTagsByUserId(String userId,String citycode);
	
	public int getCountByName(String name, String userId, String cityCode);
	
	public int getCountById(String id, String userId, String cityCode);
}
