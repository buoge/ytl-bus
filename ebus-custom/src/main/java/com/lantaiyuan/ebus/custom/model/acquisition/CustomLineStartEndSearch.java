package com.lantaiyuan.ebus.custom.model.acquisition;

import com.lantaiyuan.ebus.custom.model.acquisition.base.BaseModel;

/**
 * 描述:专线起点终点搜索埋点模型
 * 作者:温海金
 * cmd:118
 * 最后更改时间:下午4:07:36
 */
public class CustomLineStartEndSearch extends BaseModel{
   
    /**
     * 
     */
    private static final long serialVersionUID = 6856695369465171581L;
    
    //城市编码
    private String citycode;
    //出发地
    private String startplace;
    //目的地
    private String endplace;
    //搜索人位置
    private String currentposition;
  
    
    public String getCitycode() {
        return citycode;
    }
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
    public String getStartplace() {
        return startplace;
    }
    public void setStartplace(String startplace) {
        this.startplace = startplace;
    }
    public String getEndplace() {
        return endplace;
    }
    public void setEndplace(String endplace) {
        this.endplace = endplace;
    }
    public String getCurrentposition() {
        return currentposition;
    }
    public void setCurrentposition(String currentposition) {
        this.currentposition = currentposition;
    }
   
    
    
}
