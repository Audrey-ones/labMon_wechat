package com.sery.labmon.service;

import com.sery.labmon.model.Rooms;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LuDan on 2018/4/26 10:36
 */

public interface RoomsService {
    /**
     * 获取所有的房间
     * @return
     */
    List<Rooms> getAllRooms();

    /**
     * 获取所有房间的所有设备的数量
     * @return
     */
    List getEquipmentsByRooms();

    /**
     * 根据房间ID查找房间信息
     * @param roomId
     * @return
     */
    Rooms getRoomByRoomId(int roomId);
}
