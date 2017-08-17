package com.lantaiyuan.ebus.custom.service;

import org.lanqiao.ssm.common.core.service.BaseServiceI;
import org.lanqiao.ssm.common.page.Page;

import com.lantaiyuan.ebus.custom.model.BaseVersion;
import com.lantaiyuan.ebus.custom.model.BaseVersionQueryModel;
/**
 * 描述:版本更新业务接口
 * 作者:温海金
 * 最后更改时间:下午3:59:08
 */
public interface VersionServiceI extends BaseServiceI<BaseVersion, BaseVersionQueryModel> {

    BaseVersion queryBaseVersion(String cityCode, String versionId, String type);

    Page<BaseVersion> getBaseVersionByPage(BaseVersionQueryModel versionQueryModel, int page);
    
    /**
     * 功能描述:获取最新的版本信息
     * 作者:温海金
     * 最后更改时间 : 2017年3月22日 下午1:58:38
     */
    BaseVersion getFinalVersion();

}
