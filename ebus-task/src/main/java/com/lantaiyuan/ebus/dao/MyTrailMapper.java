package com.lantaiyuan.ebus.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.model.MyTrail;
import com.lantaiyuan.ebus.model.MyTrailQueryModel;
import com.lantaiyuan.ebus.model.ProduceOriginPoint;

/**
 * MyTrailMapper 
 * @author yangyang
 * @date 2017年5月18日 上午10:52:44 
 */
@Mapper
public interface MyTrailMapper extends BaseDAO<MyTrail, MyTrailQueryModel>{
    /**
     *  根据主键删除数据库的记录,my_trail
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,my_trail
     *
     * @param record
     */
    int insert(MyTrail record);

    /**
     *  动态字段,写入数据库记录,my_trail
     *
     * @param record
     */
    int insertSelective(MyTrail record);

    /**
     *  根据指定主键获取一条数据库记录,my_trail
     *
     * @param id
     */
    MyTrail selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,my_trail
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MyTrail record);

    /**
     *  根据主键来更新符合条件的数据库记录,my_trail
     *
     * @param record
     */
    int updateByPrimaryKey(MyTrail record);

	int insertOriginPoint(ProduceOriginPoint originPoint);

	MyTrail getCurrentTrail(@Param("userId")String userId);
}