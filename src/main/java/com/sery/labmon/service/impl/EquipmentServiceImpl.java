package com.sery.labmon.service.impl;

import com.sery.labmon.dao.EquipmentMapper;
import com.sery.labmon.model.Equipments;
import com.sery.labmon.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LuDan on 2018/4/26 13:40
 */

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipments> getEquipmentByRoomId(int roomId) {
        List<Equipments> equipmentsList = equipmentMapper.getEquipmentByRoomId(roomId);
        return equipmentsList;
    }
}
