package com.MyRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@author: xiaolanhe
 *@createDate: 2022/3/7 21:34
 */

/*这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，
否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊化定制的目的了。*/

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule()
    {
        return new RandomRule(); // 定义为随机
    }

}
