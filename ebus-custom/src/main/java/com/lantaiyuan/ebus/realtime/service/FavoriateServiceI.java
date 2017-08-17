/**
* <p>Title: FavoriteServiceI.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.service;

import java.util.List;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.realtime.model.Collection;
import com.lantaiyuan.ebus.realtime.model.Favoriate;
import com.lantaiyuan.ebus.realtime.model.FavoriateQueryModel;

/**
* <p>Title: FavoriteServiceI</p>
* <p>Description: 用户收藏业务逻辑处理接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2016年12月22日 下午6:29:06
*/
public interface FavoriateServiceI extends BaseServiceI<Favoriate,FavoriateQueryModel>{
	public List<Collection> getCollectionRoutes(Integer userId, String cityCode);
	
	public List<String> getCollectionTags(String userId, String cityCode);

	public boolean addFavoriteRoute(FavoriateQueryModel favoriateQueryModel);
	
	public boolean deleteFavoriteRoute(FavoriateQueryModel favoriateQueryModel);
	
	public int getCollectionRoute(Favoriate favorite);
	
	public int save(Favoriate favorite) throws Exception;
	
	public int delete(Favoriate favorite) throws Exception;
	/**
	 * 功能描述:根据所有收藏信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月2日 下午7:23:32
	 */
	public List<Favoriate> findAll();
	/**
	 * 功能描述:根据用户ID和cityCode查询我的收藏信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月2日 下午7:23:32
	 */
	public List<Favoriate> findFavoriateByUserIdAndCityCode(Integer userId, String cityCode);
	/**
	 * 功能描述:根据线路id查找关注该线路的所有用户ID
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月5日 上午10:19:24
	 */
	public List<Integer> findUserIdByRouteId(String routeId);
}
