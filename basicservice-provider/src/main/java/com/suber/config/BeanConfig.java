package com.suber.config;


import com.suber.JaveBean.ZookeeperConfig;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Configuration
public class BeanConfig {
    private final static String BasePath = "/";

    @Bean
    public CuratorFramework curatorFramework() throws Exception {

        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        ZookeeperConfig zooConf = zookeeperConfig();
        CuratorFramework client =
                CuratorFrameworkFactory.builder()
                        .connectString(zooConf.getZookeeperConnection())
                        .sessionTimeoutMs(5000)
                        .connectionTimeoutMs(5000)
                        .retryPolicy(retryPolicy)
                        .namespace(zooConf.BASE_PATH)
                        .build();
        client.start();
        Stat stat = client.checkExists().forPath(getBasePath(zooConf.getPath()));
        if (stat != null) {
            if (zooConf.getAutoAdd()) {
                if (Integer.valueOf(zooConf.getGroupNum()) < 9) {
                    zooConf.setGroupNum((Integer.valueOf(zooConf.getGroupNum() + 1)).toString());
                }else {
                    throw new Exception("room and group is repeat! and group is max!");
                }
                client.create().withMode(CreateMode.EPHEMERAL).forPath(getBasePath(zooConf.getPath()));

            } else {
                throw new Exception("room and group is repeat!");
            }
        } else {
            client.create().withMode(CreateMode.EPHEMERAL).forPath(getBasePath(zooConf.getPath()));
        }
        return client;
    }


    @Bean
    public ZookeeperConfig zookeeperConfig() {
        return new ZookeeperConfig();
    }


    private static String getBasePath(String path) {
        return BasePath + path;
    }

}
