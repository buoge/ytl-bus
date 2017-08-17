package com.lantaiyuan.ebus.custom.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.lanqiao.ssm.common.core.dao.BaseDAO;
import org.lanqiao.ssm.common.core.service.BaseService;
import org.lanqiao.ssm.common.page.Page;
import org.springframework.stereotype.Service;

import com.lantaiyuan.ebus.custom.dao.BaseVersionMapper;
import com.lantaiyuan.ebus.custom.model.BaseVersion;
import com.lantaiyuan.ebus.custom.model.BaseVersionQueryModel;
import com.lantaiyuan.ebus.custom.service.VersionServiceI;
/**
 * 描述:版本更新业务类
 * 作者:温海金
 * 最后更改时间:下午3:50:59
 */
@Service("versionService")
public class VersionServiceImpl extends BaseService<BaseVersion, BaseVersionQueryModel> implements VersionServiceI{

    @Resource
    private BaseVersionMapper versionMapper;
    
    public BaseDAO<BaseVersion, BaseVersionQueryModel> getDao() {
	return versionMapper;
    }
    
    /**
     * 描述:新增版本信息
     * 作者:温海金
     * 最后更改时间:下午3:50:59
     */
    @Override
    public int insertSelective(BaseVersion baseVersion) {
	baseVersion.setId(UUID.randomUUID().toString());
	return super.insertSelective(baseVersion);
    }
    
    /**
     * 描述:查询版本对象
     * 作者:温海金
     * 最后更改时间:下午3:50:59
     */
    @Override
    public BaseVersion queryBaseVersion(String cityCode, String versionId, String type) {
	BaseVersion baseVersion = versionMapper.queryBaseVersion(cityCode, type);
	if(baseVersion!=null && baseVersion.getVersionid()!=null) {
	    //数据库中的版本号与当前版本号不一致，则需要进行版本更新
	    baseVersion.setIsneedupdate(!baseVersion.getVersionid().equals(versionId));
	}
	return baseVersion;
    }

    /**
     * 分页查询版本信息
     */
    @Override
    public Page<BaseVersion> getBaseVersionByPage(BaseVersionQueryModel versionQueryModel, int page) {
	versionQueryModel.getPageModel().setNowPage(page);
	List<BaseVersion> baseVersions = versionMapper.findObjectsByPage(versionQueryModel);
	versionQueryModel.getPageModel().setRows(baseVersions);
	return versionQueryModel.getPageModel();
    }

    /**
     * 获取最新的版本信息
     */
    @Override
    public BaseVersion getFinalVersion() {
	return versionMapper.getFinalVersion();
    }

}
