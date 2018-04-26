package com.sery.labmon.dao;

import com.sery.labmon.model.Equipments;

import java.util.List;

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
}
