package com.lantaiyuan.ebus.custom.service;

import com.lantaiyuan.ebus.carpool.model.UserOd;
import com.lantaiyuan.ebus.carpool.model.UserOdQueryModel;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.ssm.common.core.service.BaseServiceI;

import java.util.List;

/**
 * 用户 Od Service
 *
 * @author yangyang
 * @date 2017/7/18 11:05
 * @email kekecany@163.com
 */
public interface UserOdServiceI extends BaseServiceI<UserOd, UserOdQueryModel> {

    /**
     * 批量添加用户od信息
     *
     * @param list 用户od list
     * @return 返回添加成功的条数
     */
    int insertBatch(@Param("list") List<UserOd> list);

    /**
     * 删除7天前的数据
     * @return
     */
    int deleteOldOD();
    /**
     * 功能描述:根据用户ID得到用户常用OD点
     * 作者:温海金
     * 最后更改时间 : 2017年7月20日 下午2:35:53
     */
	UserOd getODByUserId(Integer userId);
}
