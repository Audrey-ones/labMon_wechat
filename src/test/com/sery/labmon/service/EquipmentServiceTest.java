package com.sery.labmon.service;

import com.sery.labmon.model.Equipments;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LuDan on 2018/4/26 13:42
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class EquipmentServiceTest {
    @Autowired
    private EquipmentService equipmentService;

    @Test
    public void getEquipmentByRoomId() {
        List<Equipments> equipmentsList = equipmentService.getEquipmentByRoomId(1);
        System.out.println(equipmentsList);
    }
}