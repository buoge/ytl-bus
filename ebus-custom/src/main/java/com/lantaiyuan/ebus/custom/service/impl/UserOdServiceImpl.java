package com.lantaiyuan.ebus.custom.service.impl;

import com.lantaiyuan.ebus.carpool.model.UserOd;
import com.lantaiyuan.ebus.carpool.model.UserOdQueryModel;
import com.lantaiyuan.ebus.custom.dao.UserOdMapper;
import com.lantaiyuan.ebus.custom.service.UserOdServiceI;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户od的service impl
 *
 * @author yangyang
 * @date 2017/7/18 11:06
 * @email kekecany@163.com
 */
@Service("userOdService")
public class UserOdServiceImpl extends BaseService<UserOd, UserOdQueryModel> implements UserOdServiceI {

    @Autowired
    private UserOdMapper userOdMapper;

    @Override
    public BaseDAO<UserOd, UserOdQueryModel> getDao() {
        return userOdMapper;
    }


    /**
     * 批量添加用户od信息
     *
     * @param list 用户od list
     * @return 返回添加成功的条数
     */
    @Override
    public int insertBatch(List<UserOd> list) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        return userOdMapper.insertBatch(list);
    }

    /**
     * 删除7天前的数据
     *
     * @return
     */
    @Override
    public int deleteOldOD() {
        return userOdMapper.deleteOldOD();
    }

    /**
     * 功能描述:根据用户ID得到常用OD点
     * 作者:温海金
     * 最后更改时间 : 2017年7月20日 下午2:39:17
     */
	@Override
	public UserOd getODByUserId(Integer userId) {
		return userOdMapper.getODByUserId(userId);
	}
}
