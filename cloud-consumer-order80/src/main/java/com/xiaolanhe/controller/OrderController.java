package com.xiaolanhe.controller;

import com.xiaolanhe.entities.CommonResult;
import com.xiaolanhe.entities.Payment;
import com.xiaolanhe.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 *@author: xiaolanhe
 *@createDate: 2022/3/2 19:30
 */

@RestController
public class OrderController {

    /*使用restTemplate访问restful接口非常的简单粗暴无脑。
    (url, requestMap, ResponseBean.class)这三个参数分别代表
    REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。*/

    private static final String Payment_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    // 客户端浏览器用的是get请求，但是底层实质发送post调用服务端8001
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(Payment_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(Payment_URL+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");

        if(instances == null || instances.size() == 0){
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);

        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
