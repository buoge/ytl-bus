package com.lantaiyuan.ebus.custom.model.acquisition;


import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/**
 * 描述:附近站点搜索埋点模型
 * 作者:温海金
 * cmd:112
 * 最后更改时间:下午4:07:36
 */
public class NearStationCollection extends BaseModel {
   
    /**
     * 
     */
    private static final long serialVersionUID = 4200680586637663627L;
    //城市编码
    private String citycode;
    //查看地点
    private String currentposition;
    
    
    public String getCitycode() {
        return citycode;
    }
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
    public String getCurrentposition() {
        return currentposition;
    }
    public void setCurrentposition(String currentposition) {
        this.currentposition = currentposition;
    }
    
}
