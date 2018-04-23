package com.sery.labmon.model;

/**
 * Created by LuDan on 2018/4/23 10:12
 */
public class Equipments {
    private Integer equipmentId;
    private String name;
    private Integer dataTenplateId;
    private String description;
    private String equipmentType;
    private String roomId;

    public Equipments(Integer equipmentId, String name, Integer dataTenplateId, String description, String equipmentType, String roomId) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.dataTenplateId = dataTenplateId;
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

    public Integer getDataTenplateId() {
        return dataTenplateId;
    }

    public void setDataTenplateId(Integer dataTenplateId) {
        this.dataTenplateId = dataTenplateId;
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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Equipments{" +
                "equipmentId=" + equipmentId +
                ", name='" + name + '\'' +
                ", dataTenplateId=" + dataTenplateId +
                ", description='" + description + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
