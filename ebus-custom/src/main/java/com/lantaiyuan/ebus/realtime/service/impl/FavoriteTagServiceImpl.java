package com.lantaiyuan.ebus.realtime.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.common.util.DesUtil;
import com.lantaiyuan.ebus.realtime.dao.BaseFavoriteTagMapper;
import com.lantaiyuan.ebus.realtime.model.BaseFavoriteTag;
import com.lantaiyuan.ebus.realtime.model.BaseFavoriteTagQueryModel;
import com.lantaiyuan.ebus.realtime.service.FavoriteTagServiceI;

/***
 * 
* <p>Title: FavoriteTagServiceImpl</p>
* <p>Description: 用户收藏自定义标签业务实现类</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年4月26日 下午2:48:57
 */

@Service("favoriteTagService")
public class FavoriteTagServiceImpl extends BaseService<BaseFavoriteTag, BaseFavoriteTagQueryModel>
		implements FavoriteTagServiceI {

	@Resource
	private BaseFavoriteTagMapper baseFavoriteTagMapper;

	@Override
	public BaseDAO<BaseFavoriteTag, BaseFavoriteTagQueryModel> getDao() {
		return baseFavoriteTagMapper;
	}

	/***
	 * *
	* <p>Title: insertSelective</p>
	* <p>Description: 插入标签，这之前需要解密userId，并判断该标签是否存在</p>
	* @param record
	* @return
	 */
	@Override
	public int insertSelective(BaseFavoriteTag record) {
		String userId = DesUtil.decrypt(record.getUserid());
		int count = getCountByName(record.getName(),userId,record.getCitycode());
		
		//如果存在，返回-1
		if(count > 0){
			return -1;
		}
		
		record.setId(UUID.randomUUID().toString());
		//userid解密
		record.setUserid(userId);
		record.setCreatetime(new Date());
		return super.insertSelective(record);
	}
	
	/***
	* <p>Title: updateByPrimaryKeySelective</p>
	* <p>Description: 更新标签，这之前需要解密userId，并判断该标签是否存在</p>
	* @param record
	* @return
	*/
	@Override
	public int updateByPrimaryKeySelective(BaseFavoriteTag record) {
		String userId = DesUtil.decrypt(record.getUserid());
		int count = getCountById(record.getId(),userId,record.getCitycode());
		
		//如果不存在，返回-1
		if(count <= 0){
			return -1;
		}
		
		//userid解密
		record.setUserid(userId);
		return super.updateByPrimaryKeySelective(record);
	}
	
	/***
	* <p>Title: deleteByPrimaryKey</p>
	* <p>Description: 删除标签，这之前需判断该标签是否存在</p>
	* @param id
	* @return
	*/
	@Override
	public int deleteByPrimaryKey(String id) {
		BaseFavoriteTag baseFavoriteTag = super.selectByPrimaryKey(id);
		
		//如果不存在，返回-1
		if(baseFavoriteTag == null){
			return -1;
		}
		
		return super.deleteByPrimaryKey(id);
	}

	/***
	* <p>Title: queryCollectionTagsByUserId</p>
	* <p>Description: 查询用户自定义标签列表</p>
	* @param userId
	* @param citycode
	* @return
	*/
	@Override
	public List<String> queryCollectionTagsByUserId(String userId, String cityCode) {
		//先解密
		userId = DesUtil.decrypt(userId);
		return baseFavoriteTagMapper.queryCollectionTagsByUserId(userId,cityCode);
	}
	
	/***
	 * *
	* <p>Title: getCountByName</p>
	* <p>Description: 根据标签名称判断该标签是否存在</p>
	* @param name
	* @param userId
	* @param cityCode
	* @return
	 */
	@Override
	public int getCountByName(String name, String userId, String cityCode){
		return baseFavoriteTagMapper.queryCountByName(name, userId, cityCode);
	}
	
	/***
	 * *
	* <p>Title: getCountById</p>
	* <p>Description: 根据主键id和userId判断标签是否存在</p>
	* @param id
	* @param userId
	* @param cityCode
	* @return
	 */
	@Override
	public int getCountById(String id, String userId, String cityCode){
		return baseFavoriteTagMapper.queryCountById(id, userId, cityCode);
	}

}