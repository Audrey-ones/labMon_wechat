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
}
