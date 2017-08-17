package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.MyTrail;
import com.lantaiyuan.ebus.custom.model.MyTrailQueryModel;
import com.lantaiyuan.ebus.custom.model.MyTrailVo;

/***
 * 
* <p>Title: MyTrailMapper</p>
* <p>Description: 我的行程映射接口</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年2月18日 下午4:47:26
 */
public interface MyTrailMapper extends BaseDAO<MyTrail, MyTrailQueryModel>{
    /**
     * 功能描述:根据用户Id查看我的行程列表
     * 作者:温海金
     * 最后更改时间 : 2017年2月23日 下午5:08:39
     */
	List<MyTrailVo> selectByUserId(@Param("userId") Integer userId);
}