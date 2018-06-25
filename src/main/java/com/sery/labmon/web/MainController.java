package com.sery.labmon.web;

import com.sery.labmon.model.EquipmentDataDTO;
import com.sery.labmon.model.Equipments;
import com.sery.labmon.model.Rooms;
import com.sery.labmon.service.AlarmInfoService;
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

    @Autowired
    private AlarmInfoService alarmInfoService;

    /**
     * 获取所有的房间信息
     * @return
     */
    @RequestMapping(value = "rooms",method = RequestMethod.GET)
    public @ResponseBody
    List<Rooms> getAllRooms(){
        List<Rooms> roomsList = roomsService.getAllRooms();
        return roomsList;
    }

    /**
     * 根据房间ID获取房间内的设备信息
     * @param roomId
     * @return
     */
    @RequestMapping(value = "equipments/{roomId}",method = RequestMethod.GET)
    public @ResponseBody List<EquipmentDataDTO> getEquipmentByRoomId(@PathVariable("roomId") int roomId){
        List<EquipmentDataDTO> equipmentsList = equipmentService.getEquipmentByRoomId(roomId);
        return equipmentsList;
    }

    /**
     * 获取所有房间的所有设备的数量
     * @return
     */
    @RequestMapping(value = "rooms/equipments",method = RequestMethod.GET)
    public @ResponseBody List getEquipmentsByRooms(){
        List list = roomsService.getEquipmentsByRooms();
        return list;
    }

    /**
     * 根据房间ID获取房间信息
     * @param roomId
     * @return
     */
    @RequestMapping(value = "rooms/{roomId}",method = RequestMethod.GET)
    public @ResponseBody Rooms getRoomByRoomId(@PathVariable("roomId") int roomId){
        Rooms room = roomsService.getRoomByRoomId(roomId);
        return room;
    }

    /**
     * 获取24小时内的报警信息
     * @return
     */
    @RequestMapping(value = "alarmInfos",method = RequestMethod.GET)
    public @ResponseBody List getAllAlarmInfos(){
        List list = alarmInfoService.getAllAlarmInfoList();
        return list;
    }

    /*@RequestMapping(value = "rooms/equipments",method = RequestMethod.GET)
    public @ResponseBody List getEquipmentsByRooms(){
        List list = equipmentDataService.getTheLastEquipmentData();
        return list;
    }*/
}
