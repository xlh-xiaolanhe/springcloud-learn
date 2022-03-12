package com.xiaolanhe.services.impl;

import com.xiaolanhe.dao.PaymentDao;
import com.xiaolanhe.entities.Payment;
import com.xiaolanhe.services.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *@author: xiaolanhe
 *@createDate: 2022/2/28 20:35
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
