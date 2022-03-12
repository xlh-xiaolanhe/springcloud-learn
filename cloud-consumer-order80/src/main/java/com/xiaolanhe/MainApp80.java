package com.xiaolanhe;

import com.MyRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 *@author: xiaolanhe
 *@createDate: 2022/3/2 19:18
 */

@EnableEurekaClient
@SpringBootApplication
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效，
@RibbonClient(name = "cloud-payment-service", configuration = MySelfRule.class)
public class MainApp80
{
    public static void main(String[] args) {
        SpringApplication.run(MainApp80.class, args);
    }
}
