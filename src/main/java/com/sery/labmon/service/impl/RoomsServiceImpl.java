package com.sery.labmon.service.impl;

import com.sery.labmon.dao.RoomMapper;
import com.sery.labmon.model.Rooms;
import com.sery.labmon.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LuDan on 2018/4/26 10:40
 */

@Service
public class RoomsServiceImpl implements RoomsService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Rooms> getAllRooms() {
        List<Rooms> roomsList = roomMapper.getAllRooms();
        return roomsList;
    }
}
