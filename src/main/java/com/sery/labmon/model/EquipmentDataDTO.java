package com.sery.labmon.model;

/**
 * Created by LuDan on 2018/5/7 15:07
 */
public class EquipmentDataDTO {
    private Integer equipmentId;
    private String equipmentName;
    private String dataTime;
    private String parameter;
    private String msg;

    public EquipmentDataDTO(Integer equipmentId, String equipmentName, String dataTime, String parameter, String msg) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.dataTime = dataTime;
        this.parameter = parameter;
        this.msg = msg;
    }

    public EquipmentDataDTO() {
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "EquipmentDataDTO{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", dataTime='" + dataTime + '\'' +
                ", parameter='" + parameter + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
