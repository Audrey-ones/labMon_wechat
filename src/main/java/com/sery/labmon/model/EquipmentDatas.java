package com.sery.labmon.model;

import java.util.Date;

/**
 * Created by LuDan on 2018/4/23 10:18
 */
public class EquipmentDatas {
    private Integer equipmentId;
    private Date timeStamp;
    private String Datas;

    public EquipmentDatas(Integer equipmentId, Date timeStamp, String datas) {
        this.equipmentId = equipmentId;
        this.timeStamp = timeStamp;
        Datas = datas;
    }

    public EquipmentDatas() {
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDatas() {
        return Datas;
    }

    public void setDatas(String datas) {
        Datas = datas;
    }

    @Override
    public String toString() {
        return "EquipmentDatas{" +
                "equipmentId=" + equipmentId +
                ", timeStamp=" + timeStamp +
                ", Datas='" + Datas + '\'' +
                '}';
    }
}
