/**
* <p>Title: FavoriteServiceImpl.java</p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.realtime.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.common.util.DesUtil;
import com.lantaiyuan.ebus.common.util.TimeUtils;
import com.lantaiyuan.ebus.custom.model.BaseBus;
import com.lantaiyuan.ebus.custom.model.BaseStation;
import com.lantaiyuan.ebus.custom.service.BaseRouteServiceI;
import com.lantaiyuan.ebus.realtime.dao.FavoriateMapper;
import com.lantaiyuan.ebus.realtime.model.BusDesc;
import com.lantaiyuan.ebus.realtime.model.Collection;
import com.lantaiyuan.ebus.realtime.model.Favoriate;
import com.lantaiyuan.ebus.realtime.model.FavoriateQueryModel;
import com.lantaiyuan.ebus.realtime.model.Group;
import com.lantaiyuan.ebus.realtime.model.RealTime;
import com.lantaiyuan.ebus.realtime.service.FavoriateServiceI;
import com.lantaiyuan.ebus.realtime.service.FavoriteTagServiceI;
import com.lantaiyuan.ebus.realtime.service.TravelServiceI;


/**
* <p>Title: FavoriteServiceImpl</p>
* <p>Description: 用户收藏相关业务逻辑实现类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2016年12月22日 下午6:43:10
*/
@Service("favoriateService")
public class FavoriateServiceImpl extends BaseService<Favoriate,FavoriateQueryModel> implements FavoriateServiceI{
	private static Logger logger = LoggerFactory.getLogger(FavoriateServiceImpl.class);
	
	@Resource
	private FavoriateMapper favoriateMapper;
	
	@Resource
	private BaseRouteServiceI baseRouteService;
	
	@Resource
	private TravelServiceI travelServiceNew;
	
	@Resource
	private FavoriteTagServiceI favoriteTagService;
	
	/**
	* <p>Title: getDao</p>
	* <p>Description: </p>
	*/
	@Override
	public BaseDAO<Favoriate,FavoriateQueryModel> getDao() {
		return favoriateMapper;
	}
	
	/**
	 * <p>Title: getCollectionRoutes</p> 
	 * <p>Description: 查询用户收藏路线</p>
	 */
	@Override
	public List<Collection> getCollectionRoutes(Integer userId, String cityCode){
		//判断用户是否存在
		int count = favoriateMapper.countExist(userId, cityCode);
		if (count <= 0) {
			return Collections.emptyList();// 用户未注册或账户已失效
		}
		
		//查询用户收藏线路
		List<Group> list = favoriateMapper.queryCollectionRoutes(userId, cityCode, TimeUtils.decideSeason());
		Map<String, List<Group>> map = new HashMap<>();

		// 开始循环处理list，将其按照收藏tag放入map中
		String name = null;
		List<Group> value = null;
		BaseStation station = null;
		Integer stationNo = null;
		RealTime bus = null;
		
		for (Group g : list) {
			name = g.getFavoriate().getTag();// 收藏的标签名称
			station = g.getBaseStation();
			stationNo = g.getRelRouteStation().getStationno();
			bus = travelServiceNew.getNearestBus(g.getFavoriate().getCitycode(),station,g.getRouteInBaseLine(),stationNo);
			if(bus == null) {
				bus = new RealTime(new BaseBus(),new BusDesc());
			}
			g.addBusInfo(bus);
			value = map.get(name);
			if (value == null) {// 收藏标签第一次加
				value = new ArrayList<>();
				value.add(g);
				map.put(name, value);
			}
			else {// 收藏标签第n次加
				value.add(g);
				map.put(name, value);
			}
		}

		List<Collection> collections = new ArrayList<>();
		
		// 开始遍历map，将其处理成需要的CollectionRoutes（收藏路线）
		Set<String> keySet = map.keySet();
		keySet.forEach(s -> {
			collections.add(new Collection(s, map.get(s)));
		});	
		return collections;
	}
	
	/**
	 * <p>Title: getCollectionTags</p> 
	 * <p>Description: 查询用户收藏标签</p>
	 */
	/*@Override
	public List<String> getCollectionTags(Integer userId, String cityCode) {
		//判断用户是否存在
		int count = favoriateMapper.countExist(userId, cityCode);
		if (count <= 0) {
			return Collections.emptyList();// 用户未注册或账户已失效
		}
		
		//查询用户收藏标签
		List<String> list = favoriateMapper.queryCollectionTags(userId, cityCode);
		if (list == null ) {
			list = new ArrayList<String>();
		}
		
		//收藏标签个数处理
		if (list.size() < 3) {
			list.clear();
			
			//增加默认选择
			list.add("上班");
			list.add("回家");
			list.add("其它");
		}
		
		return list;
	}*/
	
	/***
	 * 
	* <p>Title: getCollectionTags</p>
	* <p>Description: 升级后的查询自定义标签</p>
	* @param userId
	* @param cityCode
	* @return
	 */
	@Override
	public List<String> getCollectionTags(String userId, String cityCode) {
		userId = DesUtil.decrypt(userId);
		return favoriteTagService.queryCollectionTagsByUserId(userId,cityCode);
	}
	
	/**
	 * <p>Title: addFavoriteRoute</p> 
	 * <p>Description: 向个人收藏中添加指定线路（调用本类中相关方法）</p>
	 */
	@Override
	public boolean addFavoriteRoute(FavoriateQueryModel favoriateQueryModel){
		Favoriate favorite = new Favoriate();
		
		//对象属性拷贝
		try {
			PropertyUtils.copyProperties(favorite, favoriateQueryModel);
		} catch (Exception e) {
			logger.error("收藏新增接口对象属性拷贝出错！",e);
			return false;
		}
		
		//查询相同记录是否存在  
		int insertFlag = getCollectionRoute(favorite);
		
		if(insertFlag > 0){
			return false;
		}
		else{
			try {
				return save(favorite) > 0;
			} catch (Exception e) {
				logger.error("收藏新增接口插入数据库出错！",e);
				return false;
			}
		}
	}
	
	/**
	 * <p>Title: deleteFavoriteRoute</p> 
	 * <p>Description: 删除个人收藏中指定线路（调用本类中相关方法）</p>
	 */
	@Override
	public boolean deleteFavoriteRoute(FavoriateQueryModel favoriateQueryModel){
		Favoriate favorite = new Favoriate();
		
		try {
			PropertyUtils.copyProperties(favorite, favoriateQueryModel);
		} catch (Exception e) {
			logger.error("收藏删除接口对象属性拷贝出错！", e);
			return false;
		}
		
		//查询相同记录是否存在  
		int delFlag = getCollectionRoute(favorite);
		
		if(delFlag <= 0){
			return false;
		}
		else{
			try {
				//删除数据是否成功标志
				return delete(favorite) > 0;
			} catch (Exception e) {
				logger.error("收藏删除接口数据库删除出错！",e);
				return false;
			}
		}
	}
	
	/**
	 * <p>Title: getCollectionRoute</p> 
	 * <p>Description: dao查询个人收藏中是否存在该线路</p>
	 */
	@Override
	public int getCollectionRoute(Favoriate favorite) {
		return	favoriateMapper.getCollectionRoute(favorite);
	}
	
	/**
	 * <p>Title: save</p> 
	 * <p>Description: 调用dao插入该线路</p>
	 */
	@Override
	public int save(Favoriate favorite) throws Exception{
		return favoriateMapper.insert(favorite);
	}
	
	/**
	 * <p>Title: delete</p> 
	 * <p>Description: 调用dao删除指定线路</p>
	 */
	@Override
	public int delete(Favoriate favorite) throws Exception{
		return favoriateMapper.delete(favorite);
	}
	
	/**
	  * 功能描述:查看所有收藏信息
	  * 作者:温海金
	  * 最后更改时间 : 2017年02月17日 下午4:02:35
	  */	
	@Override
	public List<Favoriate> findAll() {
	    return favoriateMapper.findAll();
	}
	/**
	 * 功能描述:根据用户ID和cityCode查询我的收藏信息
	 * 作者:温海金
	 * 最后更改时间 : 2017年3月2日 下午7:23:32
	 */
	@Override
	public List<Favoriate> findFavoriateByUserIdAndCityCode(Integer userId, String cityCode) {
	    return favoriateMapper.findFavoriateByUserIdAndCityCode(userId, cityCode);
	}
	/**
	 * 功能描述:根据线路ID查找关注该线路的用户ID
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月5日 上午10:21:30
	 */
	@Override
	public List<Integer> findUserIdByRouteId(String routeId) {
		return favoriateMapper.findUserIdByRouteId(routeId);
	}
}
