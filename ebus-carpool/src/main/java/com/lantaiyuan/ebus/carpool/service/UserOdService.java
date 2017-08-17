package com.lantaiyuan.ebus.carpool.service;

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
public interface UserOdService extends BaseServiceI<UserOd, UserOdQueryModel> {

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
}
