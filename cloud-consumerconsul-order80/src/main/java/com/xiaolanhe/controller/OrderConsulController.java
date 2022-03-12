package com.xiaolanhe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *@author: xiaolanhe
 *@createDate: 2022/3/7 21:04
 */

@RestController
public class OrderConsulController {

    public static final String INVOKE_URL = "http://consum-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/payment/consul")
    public String paymentInfo()
    {
        String forObject = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        System.out.println("消费者调用支付服务(consule)--->result:" + forObject);
        return forObject;
    }
}
