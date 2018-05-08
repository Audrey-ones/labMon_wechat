package com.sery.labmon.service;

import com.sery.labmon.model.EquipmentDataDTO;
import com.sery.labmon.model.Equipments;

import java.util.List;

/**
 * Created by LuDan on 2018/4/26 13:39
 */
public interface EquipmentService {
    /**
     * 根据房间ID查找该房间的设备
     * @param roomId
     * @return
     */
    List<EquipmentDataDTO> getEquipmentByRoomId(int roomId);
}
