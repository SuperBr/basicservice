package com.suber.config;


import com.suber.JaveBean.ZookeeperConfig;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@ImportResource("classpath:dubbo.xml")
public class BeanConfig {


    @Bean
    public CuratorFramework curatorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        CuratorFramework client =
                CuratorFrameworkFactory.builder()
                        .connectString(zookeeperConfig().getZookeeperConnection())
                        .sessionTimeoutMs(5000)
                        .connectionTimeoutMs(5000)
                        .retryPolicy(retryPolicy)
                        .build();
        client.start();
        return client;
    }

    @Bean
    public ZookeeperConfig zookeeperConfig() {
        return new ZookeeperConfig();
    }

}
