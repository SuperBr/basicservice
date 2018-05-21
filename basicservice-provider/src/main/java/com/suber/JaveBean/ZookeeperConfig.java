package com.suber.JaveBean;

import org.springframework.beans.factory.annotation.Value;

public class ZookeeperConfig {
    @Value("${zookeeper.connectionInfo}")
    private String zookeeperConnection;
    @Value("${zookeeper.groupNum}")
    private String groupNum;
    @Value("${zookeeper.roomNum}")
    private String roomNum;

    public String getZookeeperConnection() {
        return zookeeperConnection;
    }

    public void setZookeeperConnection(String zookeeperConnection) {
        this.zookeeperConnection = zookeeperConnection;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}
