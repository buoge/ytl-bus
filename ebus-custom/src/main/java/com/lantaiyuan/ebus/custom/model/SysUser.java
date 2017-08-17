package com.lantaiyuan.ebus.custom.model;

import org.lanqiao.ssm.common.model.Model;

/**
 * web后台user表
 * SysUser
 * 数据库表：base_sys_user
 */
public class SysUser extends Model{
	
	private static final long serialVersionUID = -5408278698269259798L;

	/**
     * 用户id
     * 表字段 : base_sys_user.id
     */
    private String id;

    /**
     * 用户名称
     * 表字段 : base_sys_user.userName
     */
    private String username;

    /**
     * 密码
     * 表字段 : base_sys_user.passWord
     */
    private String password;

    /**
     * 城市编码
     * 表字段 : base_sys_user.cityCode
     */
    private String citycode;

    /**
     * 获取 用户id 字段:base_sys_user.id
     *
     * @return base_sys_user.id, 用户id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 用户id 字段:base_sys_user.id
     *
     * @param id the value for base_sys_user.id, 用户id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户名称 字段:base_sys_user.userName
     *
     * @return base_sys_user.userName, 用户名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户名称 字段:base_sys_user.userName
     *
     * @param username the value for base_sys_user.userName, 用户名称
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取 密码 字段:base_sys_user.passWord
     *
     * @return base_sys_user.passWord, 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 密码 字段:base_sys_user.passWord
     *
     * @param password the value for base_sys_user.passWord, 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取 城市编码 字段:base_sys_user.cityCode
     *
     * @return base_sys_user.cityCode, 城市编码
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置 城市编码 字段:base_sys_user.cityCode
     *
     * @param citycode the value for base_sys_user.cityCode, 城市编码
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }
}