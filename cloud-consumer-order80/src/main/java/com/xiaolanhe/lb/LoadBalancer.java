package com.xiaolanhe.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lb
 * @date 2022/3/7 22:02
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
