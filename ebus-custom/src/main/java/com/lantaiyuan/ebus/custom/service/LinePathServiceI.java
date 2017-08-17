/**
* <p>Title: MySettingsI.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.custom.service;

import java.util.List;

import com.lantaiyuan.ebus.custom.model.mytrail.LinePath;

/**
 * 描述:行程轨迹业务接口
 * 作者:温海金
 * 最后更改时间:下午2:34:11
 */
public interface LinePathServiceI {
	
	public	int deleteByPrimaryKey(String id);

	public	int insert(LinePath record);

	public	int insertSelective(LinePath record);

	public	LinePath selectByPrimaryKey(String id);

	public int updateByPrimaryKeySelective(LinePath record);

	public int updateByPrimaryKey(LinePath record);
	/**
	 * 功能描述:根据行程ID查找轨迹
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月25日 下午2:44:08
	 */
	public List<LinePath> getLinePathsByMyTrailId(Integer mytrailid);

}
