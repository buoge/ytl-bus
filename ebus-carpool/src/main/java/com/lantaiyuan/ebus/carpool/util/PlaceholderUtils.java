package com.lantaiyuan.ebus.carpool.util;
import java.util.HashMap;  
import java.util.Map;  
  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
  
/**
 * 描述:配置文件占位符替换工具类
 * 作者:温海金
 * 最后更改时间:下午7:53:35
 */
public class PlaceholderUtils {  
  
    private static final Logger logger = LoggerFactory.getLogger(PlaceholderUtils.class);  
  
    /** 
     * Prefix for system property placeholders: "${" 
     */  
    public static final String PLACEHOLDER_PREFIX = "${";  
    /** 
     * Suffix for system property placeholders: "}" 
     */  
    public static final String PLACEHOLDER_SUFFIX = "}";  
  
    public static String resolvePlaceholders(String text, Map<String, String> parameter) {  
        if (parameter == null || parameter.isEmpty()) {  
            return text;  
        }  
        StringBuffer buf = new StringBuffer(text);  
        int startIndex = buf.indexOf(PLACEHOLDER_PREFIX);  
        while (startIndex != -1) {  
            int endIndex = buf.indexOf(PLACEHOLDER_SUFFIX, startIndex + PLACEHOLDER_PREFIX.length());  
            if (endIndex != -1) {  
                String placeholder = buf.substring(startIndex + PLACEHOLDER_PREFIX.length(), endIndex);  
                int nextIndex = endIndex + PLACEHOLDER_SUFFIX.length();  
                try {  
                    String propVal = parameter.get(placeholder);  
                    if (propVal != null) {  
                        buf.replace(startIndex, endIndex + PLACEHOLDER_SUFFIX.length(), propVal);  
                        nextIndex = startIndex + propVal.length();  
                    } else {  
                        logger.warn("Could not resolve placeholder '" + placeholder + "' in [" + text + "] ");  
                    }  
                } catch (Exception ex) {  
                    logger.warn("Could not resolve placeholder '" + placeholder + "' in [" + text + "]: " + ex);  
                }  
                startIndex = buf.indexOf(PLACEHOLDER_PREFIX, nextIndex);  
            } else {  
                startIndex = -1;  
            }  
        }  
        return buf.toString();  
    }  
      
    public static void main(String[] args) {  
        String aa= "亲爱的蓝泰源用户，您好，由于……,您的拼车起点站变更为${start_station}, 拼车终点站变更为${end_station},请知悉!";  
        String bb= "亲爱的蓝泰源用户，您好，由于……,您的拼车起点站变更为,请知悉!";  
        Map<String, String> map = new HashMap<String, String>();  
       /* map.put("start_station","豪威大厦");  
        map.put("end_station","西丽法庭");  */
        System.out.println(PlaceholderUtils.resolvePlaceholders(bb, map));  
    }  
  
} 