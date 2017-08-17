package com.lantaiyuan.ebus.custom.model;

import java.util.Date;

import org.lanqiao.ssm.common.model.Model;

import com.wordnik.swagger.annotations.ApiModel;

/**
 * 反馈建议表
 * Suggestion
 * 数据库表：base_suggestion
 */
@ApiModel
public class Suggestion extends Model {

    /**
     * 
     */
    private static final long serialVersionUID = -5719589883368917702L;

    /**
     * 反馈建议id(主键)
     * 表字段 : base_suggestion.id
     */
    private String id;

    /**
     * 用户id
     * 表字段 : base_suggestion.userId
     */
    private Integer userid;

    /**
     * 用户名
     * 表字段 : base_suggestion.userName
     */
    private String username;

    /**
     * 附件url连接串（中间用英文逗号分割）
     * 表字段 : base_suggestion.attachPaths
     */
    private String attachpaths;

    /**
     * 城市编码
     * 表字段 : base_suggestion.cityCode
     */
    private String citycode;

    /**
     * 提交时间
     * 表字段 : base_suggestion.createTime
     */
    private Date createtime;

    /**
     * 消息类型：0-用户提交给系统 1-系统回复给用户的信息
     * 表字段 : base_suggestion.messageType
     */
    private Byte messagetype;

    /**
     * 联系信息(保存用户输入的手机号或qq号码等联系方式)
     * 表字段 : base_suggestion.contactInfo
     */
    private String contactinfo;

    /**
     * 所属反馈id（主反馈信息为空）
     * 表字段 : base_suggestion.topicId
     */
    private String topicid;

    /**
     * 反馈内容
     * 表字段 : base_suggestion.content
     */
    private String content;
    
    /**
     * 系统最后回复内容
     * 表字段 :临时字段,不存库
     */
    private String sysLastReply;

    /**
     * 获取 反馈建议id(主键) 字段:base_suggestion.id
     *
     * @return base_suggestion.id, 反馈建议id(主键)
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 反馈建议id(主键) 字段:base_suggestion.id
     *
     * @param id the value for base_suggestion.id, 反馈建议id(主键)
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户id 字段:base_suggestion.userId
     *
     * @return base_suggestion.userId, 用户id
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 用户id 字段:base_suggestion.userId
     *
     * @param userid the value for base_suggestion.userId, 用户id
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 用户名 字段:base_suggestion.userName
     *
     * @return base_suggestion.userName, 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户名 字段:base_suggestion.userName
     *
     * @param username the value for base_suggestion.userName, 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取 附件url连接串（中间用英文逗号分割） 字段:base_suggestion.attachPaths
     *
     * @return base_suggestion.attachPaths, 附件url连接串（中间用英文逗号分割）
     */
    public String getAttachpaths() {
        return attachpaths;
    }

    /**
     * 设置 附件url连接串（中间用英文逗号分割） 字段:base_suggestion.attachPaths
     *
     * @param attachpaths the value for base_suggestion.attachPaths, 附件url连接串（中间用英文逗号分割）
     */
    public void setAttachpaths(String attachpaths) {
        this.attachpaths = attachpaths == null ? null : attachpaths.trim();
    }

    /**
     * 获取 城市编码 字段:base_suggestion.cityCode
     *
     * @return base_suggestion.cityCode, 城市编码
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * 设置 城市编码 字段:base_suggestion.cityCode
     *
     * @param citycode the value for base_suggestion.cityCode, 城市编码
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    /**
     * 获取 提交时间 字段:base_suggestion.createTime
     *
     * @return base_suggestion.createTime, 提交时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 提交时间 字段:base_suggestion.createTime
     *
     * @param createtime the value for base_suggestion.createTime, 提交时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 消息类型：0-用户提交给系统 1-系统回复给用户的信息 字段:base_suggestion.messageType
     *
     * @return base_suggestion.messageType, 消息类型：0-用户提交给系统 1-系统回复给用户的信息
     */
    public Byte getMessagetype() {
        return messagetype;
    }

    /**
     * 设置 消息类型：0-用户提交给系统 1-系统回复给用户的信息 字段:base_suggestion.messageType
     *
     * @param messagetype the value for base_suggestion.messageType, 消息类型：0-用户提交给系统 1-系统回复给用户的信息
     */
    public void setMessagetype(Byte messagetype) {
        this.messagetype = messagetype;
    }

    /**
     * 获取 联系信息(保存用户输入的手机号或qq号码等联系方式) 字段:base_suggestion.contactInfo
     *
     * @return base_suggestion.contactInfo, 联系信息(保存用户输入的手机号或qq号码等联系方式)
     */
    public String getContactinfo() {
        return contactinfo;
    }

    /**
     * 设置 联系信息(保存用户输入的手机号或qq号码等联系方式) 字段:base_suggestion.contactInfo
     *
     * @param contactinfo the value for base_suggestion.contactInfo, 联系信息(保存用户输入的手机号或qq号码等联系方式)
     */
    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo == null ? null : contactinfo.trim();
    }

    /**
     * 获取 所属反馈id（主反馈信息为空） 字段:base_suggestion.topicId
     *
     * @return base_suggestion.topicId, 所属反馈id（主反馈信息为空）
     */
    public String getTopicid() {
        return topicid;
    }

    /**
     * 设置 所属反馈id（主反馈信息为空） 字段:base_suggestion.topicId
     *
     * @param topicid the value for base_suggestion.topicId, 所属反馈id（主反馈信息为空）
     */
    public void setTopicid(String topicid) {
        this.topicid = topicid == null ? null : topicid.trim();
    }

    /**
     * 获取 反馈内容 字段:base_suggestion.content
     *
     * @return base_suggestion.content, 反馈内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 反馈内容 字段:base_suggestion.content
     *
     * @param content the value for base_suggestion.content, 反馈内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSysLastReply() {
        return sysLastReply;
    }

    public void setSysLastReply(String sysLastReply) {
	 this.sysLastReply = sysLastReply == null ? null : sysLastReply.trim();
    }

    
}