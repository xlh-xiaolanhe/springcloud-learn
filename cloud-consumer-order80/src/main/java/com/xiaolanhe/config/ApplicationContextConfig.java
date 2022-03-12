package com.xiaolanhe.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *@author: xiaolanhe
 *@createDate: 2022/3/2 19:29
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
