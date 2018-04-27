package com.sery.labmon.service;

import com.sery.labmon.model.Rooms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LuDan on 2018/4/26 10:41
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class RoomsServiceTest {
    @Autowired
    private RoomsService roomsService;

    @Test
    public void getAllRooms() {
        List<Rooms> roomsList = roomsService.getAllRooms();
        System.out.println(roomsList);
    }

    @Test
    public void getEquipmentsByRooms() {
        List list = roomsService.getEquipmentsByRooms();
        System.out.println(list);
    }
}