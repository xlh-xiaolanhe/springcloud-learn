package com.xiaolanhe.dao;

import com.xiaolanhe.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *@author: xiaolanhe
 *@createDate: 2022/2/28 20:24
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
