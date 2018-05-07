package com.sery.labmon.model;

import java.util.List;

/**
 * Created by LuDan on 2018/5/7 12:43
 */
public class JsonData {
    private Long timeStamp;
    private List<JsonEquipmentData> data;

    public JsonData(Long timeStamp, List<JsonEquipmentData> data) {
        this.timeStamp = timeStamp;
        this.data = data;
    }

    public JsonData() {
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<JsonEquipmentData> getData() {
        return data;
    }

    public void setData(List<JsonEquipmentData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "timeStamp=" + timeStamp +
                ", data=" + data +
                '}';
    }
}
