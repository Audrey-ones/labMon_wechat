package com.sery.labmon.model;

import javax.persistence.*;

/**
 * Created by LuDan on 2018/4/23 9:43
 */

public class Rooms {
    private Integer roomId;
    private String name;
    private String description;
    private String equipmentPositionDic;

    public Rooms(Integer roomId, String name, String description, String equipmentPositionDic) {
        this.roomId = roomId;
        this.name = name;
        this.description = description;
        this.equipmentPositionDic = equipmentPositionDic;
    }

    public Rooms() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEquipmentPositionDic() {
        return equipmentPositionDic;
    }

    public void setEquipmentPositionDic(String equipmentPositionDic) {
        this.equipmentPositionDic = equipmentPositionDic;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", equipmentPositionDic='" + equipmentPositionDic + '\'' +
                '}';
    }
}
