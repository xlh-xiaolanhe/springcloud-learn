package com.xiaolanhe.services.impl;

import com.xiaolanhe.services.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.support.MessageBuilder;
import org.springframework.integration.support.MessageBuilder;
import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;
import java.util.UUID;

/**
 *@author: xiaolanhe
 *@createDate: 2022/3/16 21:03
 */

@EnableBinding(Source.class)  // 可以理解为是一个消息的发送管道的定义
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息的发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        this.output.send(MessageBuilder.withPayload(serial).build());//创建并发送消息
        System.out.println("****serial: " + serial);
        return serial;
    }
}
