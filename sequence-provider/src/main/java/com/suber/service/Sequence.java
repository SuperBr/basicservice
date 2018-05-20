package com.suber.service;

import com.suber.JaveBean.ZookeeperConfig;
import com.suber.api.ISequence;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class Sequence implements ISequence {
    private static volatile int num = 1000;

    private static volatile Long laseCurrentTimeMillis = 0l;
    @Autowired
    private ZookeeperConfig zookeeperConfig;


    @Override
    public Long getDefaultSequence() throws Exception {


        StringBuilder baseB = new StringBuilder(zookeeperConfig.getRoomNum() + zookeeperConfig.getGroupNum());
        Long CurrentTimeMillis = getCurrentTimeMillis();
        if (laseCurrentTimeMillis > CurrentTimeMillis) {
            throw new Exception("time is error");
        }
        synchronized (this) {
            if (num==9999) {
                num=1000;
            }
            if (laseCurrentTimeMillis < CurrentTimeMillis) {
                num=1000;
                baseB.append(CurrentTimeMillis);
                baseB.append("0000");
                laseCurrentTimeMillis = CurrentTimeMillis;
                return Long.valueOf(baseB.toString());
            } else {
                baseB.append(CurrentTimeMillis);
                baseB.append(num++);
                return Long.valueOf(baseB.toString());
            }

        }
    }


    private static Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }


}
