/**
* <p>Title: RestTemplateConfig.java</p>
* <p>Copyright: Copyright (c) 2017</p>
* <p>Company: lty</p>
*/
package com.lantaiyuan.ebus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
* <p>Title: RestTemplateConfig</p>
* <p>Description: RestTemplate初始化配置</p>
* <p>Company: lty</p>
* @author liuhao
* @date 2017年5月6日 上午9:25:12
*/
@Configuration
public class RestTemplateConfig{
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(simpleClientHttpRequestFactory());
    }
    
    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
        return factory;
    }
}
