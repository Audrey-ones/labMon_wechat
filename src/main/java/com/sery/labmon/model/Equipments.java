package com.sery.labmon.model;

/**
 * Created by LuDan on 2018/4/23 10:12
 */
public class Equipments {
    private Integer equipmentId;
    private String name;
    private Integer dataTemplateId;
    private String description;
    private String equipmentType;
    private Integer roomId;

    public Equipments(Integer equipmentId, String name, Integer dataTemplateId, String description, String equipmentType, Integer roomId) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.dataTemplateId = dataTemplateId;
        this.description = description;
        this.equipmentType = equipmentType;
        this.roomId = roomId;
    }

    public Equipments() {
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDataTemplateId() {
        return dataTemplateId;
    }

    public void setDataTemplateId(Integer dataTenplateId) {
        this.dataTemplateId = dataTenplateId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Equipments{" +
                "equipmentId=" + equipmentId +
                ", name='" + name + '\'' +
                ", dataTenplateId=" + dataTemplateId +
                ", description='" + description + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
