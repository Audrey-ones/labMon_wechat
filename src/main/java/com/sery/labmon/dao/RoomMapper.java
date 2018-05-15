package com.sery.labmon.dao;

import com.sery.labmon.model.Rooms;

import java.util.List;

/**
 * Created by LuDan on 2018/4/26 10:20
 */
public interface RoomMapper {
    /**
     * 查询所有的房间
     * @return
     */
    List<Rooms> getAllRooms();

    /**
     * 根据房间ID查找房间信息
     * @param roomId
     * @return
     */
    Rooms getRoomByRoomId(int roomId);
}
