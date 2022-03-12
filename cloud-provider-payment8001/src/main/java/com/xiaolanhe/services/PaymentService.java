package com.xiaolanhe.services;

import com.xiaolanhe.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 *@author: xiaolanhe
 *@createDate: 2022/2/28 20:34
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
