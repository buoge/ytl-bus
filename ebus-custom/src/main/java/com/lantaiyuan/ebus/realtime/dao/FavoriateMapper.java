package com.lantaiyuan.ebus.realtime.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.realtime.model.Favoriate;
import com.lantaiyuan.ebus.realtime.model.FavoriateQueryModel;
import com.lantaiyuan.ebus.realtime.model.Group;

/***
 * 
* <p>Title: FavoriateMapper</p>
* <p>Description: 用户线路收藏相关dao接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2016年12月23日 下午3:07:00
 */
public interface FavoriateMapper extends BaseDAO<Favoriate,FavoriateQueryModel>{
    int deleteByPrimaryKey(Integer id);

    int insert(Favoriate record);

    int insertSelective(Favoriate record);

    Favoriate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Favoriate record);

    int updateByPrimaryKey(Favoriate record);
    
    Integer countExist(@Param("userId") Integer userId, @Param("cityCode") String cityCode);
    
    List<Group> queryCollectionRoutes(@Param("userId") Integer userId, @Param("cityCode") String cityCode,
			@Param("season") Integer season);
    
    List<String> queryCollectionTags(@Param("userId") Integer userId, @Param("cityCode") String cityCode);
    
    /**
	 * 数据查询
	 * 
	 * @param favorite
	 */
	public int getCollectionRoute(Favoriate favorite);
	
	int delete(Favoriate favorite);

	List<Favoriate> findAll();
	/**
	 * 功能描述:根据用户ID和cityCode查询我的收藏信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月2日 下午7:23:32
	 */
	List<Favoriate> findFavoriateByUserIdAndCityCode(@Param("userId") Integer userId, @Param("cityCode") String cityCode);
	/**
	 * 功能描述:根据线路ID查找关注该线路的用户ID
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月5日 上午10:21:30
	 */
	List<Integer> findUserIdByRouteId(@Param("routeId") String routeId);

	List<Favoriate> findFavoriateByRouteAndCity(String routeId, String cityCode);
}