package com.xiaolanhe.services;

import com.xiaolanhe.entities.CommonResult;
import com.xiaolanhe.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *@author: xiaolanhe
 *@createDate: 2022/3/9 21:19
 */

@Component
@FeignClient(value = "cloud-payment-service") // @FeginClient 配置调用provider服务
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/fegin/timeout")
    String paymentFeignTimeOut();
}
