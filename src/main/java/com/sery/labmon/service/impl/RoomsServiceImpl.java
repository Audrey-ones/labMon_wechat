package com.sery.labmon.service.impl;

import com.sery.labmon.dao.EquipmentMapper;
import com.sery.labmon.dao.RoomMapper;
import com.sery.labmon.model.Equipments;
import com.sery.labmon.model.Rooms;
import com.sery.labmon.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LuDan on 2018/4/26 10:40
 */

@Service
public class RoomsServiceImpl implements RoomsService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Rooms> getAllRooms() {
        List<Rooms> roomsList = roomMapper.getAllRooms();
        return roomsList;
    }

    @Override
    public List getEquipmentsByRooms() {
        List<Rooms> rooms = roomMapper.getAllRooms();
        List list = new ArrayList();
        for (Rooms room : rooms){
            Map map = new HashMap();
            List<Equipments> equipments = equipmentMapper.getEquipmentByRoomId(room.getRoomId());
            map.put("room",room);
            map.put("equipments",equipments);
            list.add(map);

        }
        return list;
    }
}
