package com.xiaolanhe.controller;


import com.xiaolanhe.entities.CommonResult;
import com.xiaolanhe.entities.Payment;
import com.xiaolanhe.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *@author: xiaolanhe
 *@createDate: 2022/2/28 20:47
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("*****插入操作返回结果: " + result);

        if(result > 0){
            return new CommonResult(200, "插入数据库成功" + "\t 服务端口: " + serverPort, result);
        }else{
            return new CommonResult(404, "插入数据库失败" + "\t 服务端口: " + serverPort , null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:{}",payment);

        if(payment != null)
        {
            return new CommonResult(200,"查询成功" + "\t 服务端口: " + serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
        }

    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();

        for(String service : services)
        {
            System.out.println(service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for(ServiceInstance element : instances)
        {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t"
            + element.getPort() + "\t" + element.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        System.out.println("****** lb from port: " + serverPort);
        return serverPort;
    }

    @GetMapping(value = "/payment/fegin/timeout")
    public String paymentFeignTimeOut()
    {
        System.out.println("****paymentFeignTimeOut from port: " + serverPort);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
