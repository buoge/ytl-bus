package com.lantaiyuan.ebus.custom.service;

import javax.servlet.http.HttpSession;

import org.lanqiao.ssm.common.core.service.BaseServiceI;

import com.lantaiyuan.ebus.custom.model.SysUser;
import com.lantaiyuan.ebus.custom.model.SysUserQueryModel;
import com.lantaiyuan.ebus.custom.model.enummodel.LoginResultEnum;

public interface SysUserServiceI extends BaseServiceI<SysUser, SysUserQueryModel> {

	LoginResultEnum login(String userName, String passWord, HttpSession session);
}
