package com.sery.labmon.model;

/**
 * Created by LuDan on 2018/6/14 15:36
 */
public class AlarmInfo {
    private Integer id;
    private Long timeStamp;
    private Integer type;
    private Integer equipmentID;
    private Double currentVal;
    private Integer indexOfTemplate;
    private Integer handled;
    private Boolean valReturnNormal;
    private String physicalQuantity;
    private String unit;
    private String handler;

    public AlarmInfo(Integer id, Long timeStamp, Integer type, Integer equipmentID, Double currentVal, Integer indexOfTemplate,
                     Integer handled, Boolean valReturnNormal, String physicalQuantity, String unit, String handler) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.type = type;
        this.equipmentID = equipmentID;
        this.currentVal = currentVal;
        this.indexOfTemplate = indexOfTemplate;
        this.handled = handled;
        this.valReturnNormal = valReturnNormal;
        this.physicalQuantity = physicalQuantity;
        this.unit = unit;
        this.handler = handler;
    }

    public AlarmInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(Integer equipmentID) {
        this.equipmentID = equipmentID;
    }

    public Double getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(Double currentVal) {
        this.currentVal = currentVal;
    }

    public Integer getIndexOfTemplate() {
        return indexOfTemplate;
    }

    public void setIndexOfTemplate(Integer indexOfTemplate) {
        this.indexOfTemplate = indexOfTemplate;
    }

    public Integer getHandled() {
        return handled;
    }

    public void setHandled(Integer handled) {
        this.handled = handled;
    }

    public Boolean getValReturnNormal() {
        return valReturnNormal;
    }

    public void setValReturnNormal(Boolean valReturnNormal) {
        this.valReturnNormal = valReturnNormal;
    }

    public String getPhysicalQuantity() {
        return physicalQuantity;
    }

    public void setPhysicalQuantity(String physicalQuantity) {
        this.physicalQuantity = physicalQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Override
    public String toString() {
        return "AlarmInfo{" +
                "id=" + id +
                ", timeStamp=" + timeStamp +
                ", type=" + type +
                ", equipmentID=" + equipmentID +
                ", currentVal=" + currentVal +
                ", indexOfTemplate=" + indexOfTemplate +
                ", handled=" + handled +
                ", valReturnNormal=" + valReturnNormal +
                ", physicalQuantity='" + physicalQuantity + '\'' +
                ", unit='" + unit + '\'' +
                ", handler='" + handler + '\'' +
                '}';
    }
}
