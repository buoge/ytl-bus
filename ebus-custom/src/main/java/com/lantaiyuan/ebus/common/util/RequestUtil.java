package com.lantaiyuan.ebus.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

/**
 * 
  * @ClassName: RequestUtil
  * Company:深圳市蓝泰源信息技术股份有限公司
  * @author Yuan.Tan
  * @date 2016年12月20日 下午2:24:52
 */
public class RequestUtil {

    /**
     * 获取所有request请求参数key-value
     * @param request
     * @return
     */
    public static Map<String, String> getRequestParams(HttpServletRequest request){
        Map<String, String> params = new HashMap<String, String>();
        if(null != request){
            @SuppressWarnings("unchecked")
			Set<String> paramsKey = request.getParameterMap().keySet();
            for(String key : paramsKey){
                params.put(key, request.getParameter(key));
            }
        }
        return params;
    }
}
