package com.suber.JaveBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

public class ZookeeperConfig {
    @Value("${zookeeper.connectionInfo}")
    private String zookeeperConnection;
    @Value("${zookeeper.groupNum}")
    private String groupNum;
    @Value("${zookeeper.roomNum}")
    private String roomNum;

    public Boolean getAutoAdd() {
        return autoAdd;
    }

    public void setAutoAdd(Boolean autoAdd) {
        this.autoAdd = autoAdd;
    }

    @Value("${zookeeper.autoAdd}")

    private Boolean autoAdd;
    /**
     * 基础路径 d.g  /sequence/11
     */
    public static final String BASE_PATH = "suberb/sequence";

    public  String getPath() {
        Assert.notNull(groupNum, "groupNum is null");
        Assert.notNull(roomNum, "roomNum is null");

        return this.roomNum.toString()+this.groupNum;
    }

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
