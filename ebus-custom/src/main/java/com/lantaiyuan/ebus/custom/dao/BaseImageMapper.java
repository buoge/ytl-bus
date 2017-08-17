package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.BaseImage;
import com.lantaiyuan.ebus.custom.model.BaseImageDetail;
import com.lantaiyuan.ebus.custom.model.BaseImageQueryModel;

/**
 * 图片mapper
 * @Title: BaseImageMapper.java
 * @Package com.lantaiyuan.ebus.custom.dao
 * @Description:
 * @author yangyang
 * @date 2017年3月22日 上午10:27:33
 * @version v1.0
 */
public interface BaseImageMapper extends BaseDAO<BaseImage, BaseImageQueryModel> {

	public List<BaseImage> queryImage(@Param("cityCode") String cityCode, @Param("type") int type);

	/**
	 * 
	 * modifyImageToValid(这里用一句话描述这个方法的作用)
	 * 
	 * @param @param
	 *            id
	 * @param @return
	 *            设定文件
	 * @return int 返回类型
	 */
	public int modifyImageToValid(String id);

	/**
	 * 
	 * modifyImageToUnValid(这里用一句话描述这个方法的作用)
	 * 
	 * @param @param
	 *            id
	 * @param @return
	 *            设定文件
	 * @return int 返回类型
	 */
	public int modifyImageToUnValid(String id);

	/**
	 * 
	 * findAllImageByPage(这里用一句话描述这个方法的作用)
	 * 
	 * @param @param
	 *            imageQueryModel
	 * @param @return
	 *            设定文件
	 * @return List<BaseImageDetail> 返回类型
	 */
	public List<BaseImageDetail> findAllImageByPage(BaseImageQueryModel imageQueryModel);

	/**
	 * 
	 * findValidListByPage(这里用一句话描述这个方法的作用)
	 * 
	 * @param @param
	 *            imageQueryModel
	 * @param @return
	 *            设定文件
	 * @return List<BaseImageDetail> 返回类型
	 */
	public List<BaseImageDetail> findValidListByPage(BaseImageQueryModel imageQueryModel);

	/**
	 * 
	 * findUnValidListByPage(这里用一句话描述这个方法的作用)
	 * 
	 * @param @param
	 *            imageQueryModel
	 * @param @return
	 *            设定文件
	 * @return List<BaseImageDetail> 返回类型
	 */
	public List<BaseImageDetail> findUnValidListByPage(BaseImageQueryModel imageQueryModel);
}