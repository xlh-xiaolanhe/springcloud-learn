package com.xiaolanhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *@author: xiaolanhe
 *@createDate: 2022/3/7 21:00
 */

@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class OrderConsulMain80 {
    public static void main(String[] args)
    {
        SpringApplication.run(OrderConsulMain80.class,args);
    }

}
