package com.sery.labmon.model;

/**
 * Created by LuDan on 2018/4/23 10:18
 */
public class EquipmentDatas {
    private Long timeStamp;
    private String data;

    public EquipmentDatas(Long timeStamp, String data) {
        this.timeStamp = timeStamp;
        this.data = data;
    }

    public EquipmentDatas() {
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "'timeStamp':" + timeStamp +
                ", 'data':" + data +
                "}";
    }
}
