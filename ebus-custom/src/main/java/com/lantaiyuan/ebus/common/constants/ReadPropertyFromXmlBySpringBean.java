package com.lantaiyuan.ebus.common.constants;
  
/**  
* 利用spring注入方式管理实现配置文件属性的读取 
* File: ReadPropertyFromXmlBySpringBean.java  
* User: 温海金  
* Date: 2016-12-05 10:38:40  
*/   
public class ReadPropertyFromXmlBySpringBean {   
 

    private static String fdsAddressPre;   
    
    
    public static String getFdsAddressPre() {
        return fdsAddressPre;
    }
    public void setFdsAddressPre(String fdsAddressPre) {
        ReadPropertyFromXmlBySpringBean.fdsAddressPre = fdsAddressPre;
    }
     

}  