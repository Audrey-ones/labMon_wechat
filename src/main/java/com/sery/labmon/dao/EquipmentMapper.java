package com.sery.labmon.dao;

import com.sery.labmon.model.Equipments;

import java.util.List;
import java.util.Map;

/**
 * Created by LuDan on 2018/4/26 13:19
 */
public interface EquipmentMapper {

    /**
     * 根据房间ID查找该房间的设备
     * @param roomId
     * @return
     */
    List<Equipments> getEquipmentByRoomId(int roomId);

    /**
     * 根据设备ID获取该设备信息
     * @param equipmentId
     * @return
     */
    Equipments getEquipmentById(int equipmentId);

    /**
     * 根据设备ID和房间ID查找该设备信息
     * @param map
     * @return
     */
    Equipments getEquipmentByIdAndRoomId(Map map);
}
