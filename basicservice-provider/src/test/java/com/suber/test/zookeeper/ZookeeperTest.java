package com.suber.test.zookeeper;

import com.suber.test.TestBase;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.curator.framework.CuratorFramework;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ZookeeperTest extends TestBase {
    @Autowired
    private CuratorFramework curatorFramework;

    @Test
    public void ConnectionTest() {
        System.out.println(curatorFramework);
        while (true) {
            System.out.println( DateFormatUtils.format(new Date(),"yyyyMMddHHmmssSSS"));
        }


    }
}
