package com.lantaiyuan.ebus.custom.dao;

import org.lanqiao.ssm.common.core.dao.BaseDAO;

import com.lantaiyuan.ebus.custom.model.BaseDriverSchool;
import com.lantaiyuan.ebus.custom.model.BaseDriverSchoolQueryModel;
import java.util.List;

public interface BaseDriverSchoolMapper extends BaseDAO<BaseDriverSchool, BaseDriverSchoolQueryModel>{
   
    
    /**	
     * 分页查询驾校信息
     * @author yangyang
     * @param queryModel
     * @return
     */
    List<BaseDriverSchool> findDriverSchoolByPage(BaseDriverSchoolQueryModel queryModel);
    
    
    /**
     * 根据cityCode查询该城市的驾校（多于一条也只返回一条）
     * @author yangyang
     * @param cityCode
     * @return
     */
    BaseDriverSchool selectByCityCode(String cityCode);
    
    /**
     * 根据主键查询该驾校可接受报名的驾照类型
     * @author yangyang
     * @param id
     * @return
     */
	String selectAcceptLicensesByPrimaryKey(String id);
}