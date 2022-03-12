package com.xiaolanhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *@author: xiaolanhe
 *@createDate: 2022/3/6 17:43
 */

@SpringBootApplication
@EnableEurekaClient
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
