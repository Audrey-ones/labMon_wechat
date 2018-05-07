package com.sery.labmon.web;

import com.sery.labmon.model.Equipments;
import com.sery.labmon.model.Rooms;
import com.sery.labmon.service.EquipmentDataService;
import com.sery.labmon.service.EquipmentService;
import com.sery.labmon.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by LuDan on 2018/4/26 11:34
 */
@RestController
public class MainController {
    @Autowired
    private RoomsService roomsService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EquipmentDataService equipmentDataService;

    @RequestMapping(value = "rooms",method = RequestMethod.GET)
    public @ResponseBody
    List<Rooms> getAllRooms(){
        List<Rooms> roomsList = roomsService.getAllRooms();
        return roomsList;
    }

    @RequestMapping(value = "equipments/{roomId}",method = RequestMethod.GET)
    public @ResponseBody List<Equipments> getEquipmentByRoomId(@PathVariable("roomId") int roomId){
        List<Equipments> equipmentsList = equipmentService.getEquipmentByRoomId(roomId);
        return equipmentsList;
    }

    @RequestMapping(value = "rooms/equipments",method = RequestMethod.GET)
    public @ResponseBody List getEquipmentsByRooms(){
        List list = roomsService.getEquipmentsByRooms();
        return list;
    }

    /*@RequestMapping(value = "rooms/equipments",method = RequestMethod.GET)
    public @ResponseBody List getEquipmentsByRooms(){
        List list = equipmentDataService.getTheLastEquipmentData();
        return list;
    }*/
}
