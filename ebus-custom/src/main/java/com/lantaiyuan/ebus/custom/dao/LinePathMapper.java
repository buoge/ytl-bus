package com.lantaiyuan.ebus.custom.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lantaiyuan.ebus.custom.model.mytrail.LinePath;

public interface LinePathMapper {
    /**
     *  根据主键删除数据库的记录,my_trail_line_path
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     *  新写入数据库记录,my_trail_line_path
     *
     * @param record
     */
    int insert(LinePath record);

    /**
     *  动态字段,写入数据库记录,my_trail_line_path
     *
     * @param record
     */
    int insertSelective(LinePath record);

    /**
     *  根据指定主键获取一条数据库记录,my_trail_line_path
     *
     * @param id
     */
    LinePath selectByPrimaryKey(String id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,my_trail_line_path
     *
     * @param record
     */
    int updateByPrimaryKeySelective(LinePath record);

    /**
     *  根据主键来更新符合条件的数据库记录,my_trail_line_path
     *
     * @param record
     */
    int updateByPrimaryKey(LinePath record);
    /**
	 * 功能描述:根据行程ID查找轨迹
	 * 作者:温海金
	 * 最后更改时间 : 2017年5月25日 下午2:44:08
	 */
    public List<LinePath> getLinePathsByMyTrailId(@Param("mytrailid")Integer mytrailid);
}