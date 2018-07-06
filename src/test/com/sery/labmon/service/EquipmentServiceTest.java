package com.sery.labmon.service;

import com.google.gson.Gson;
import com.sery.labmon.dao.DataTemplateMapper;
import com.sery.labmon.dao.EquipmentMapper;
import com.sery.labmon.dao.RoomMapper;
import com.sery.labmon.model.*;
import com.sery.labmon.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by LuDan on 2018/4/26 13:42
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class EquipmentServiceTest {
    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EquipmentDataService equipmentDataService;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private DataTemplateMapper dataTemplateMapper;

    @Test
    public void getEquipmentByRoomId() {
        List<EquipmentDataDTO> dataDTOList = equipmentService.getEquipmentByRoomId(1);
        System.out.println(dataDTOList);
        /*List<Equipments> equipmentsList = equipmentService.getEquipmentByRoomId(1);
        JsonData jsonData = equipmentDataService.getTheLastEquipmentData();
        List<EquipmentDataDTO> dataDTOList = new ArrayList<EquipmentDataDTO>();

        for (Equipments equipment : equipmentsList){
            for (JsonEquipmentData jsonEquipmentData : jsonData.getData()){
                if (equipment.getEquipmentId().equals(jsonEquipmentData.getI())){
                    DataTemplates dataTemplate = dataTemplateMapper.getDataTemplateById(equipment.getDataTemplateId());
                    String templateStr = dataTemplate.templateToJsonString();
                    Gson gson = new Gson();
                    Template template = gson.fromJson(templateStr,Template.class);
                    List<Double> equValues = jsonEquipmentData.getS();
                    StringBuffer result = new StringBuffer();
                    if (equValues != null){
                        for (int i=0; i<equValues.size(); i++){
                            String tempValue = template.getTemplate().get(i);
                            StringBuffer sb = new StringBuffer(tempValue);
                            int index = tempValue.lastIndexOf(":");
                            sb.insert(index+1,equValues.get(i));
                            String str = sb.toString();
                            result.append(str+";");
                        }
                    }else {
                        result.append("参数为mull");
                    }
                    EquipmentDataDTO equipmentDataDTO = new EquipmentDataDTO();
                    equipmentDataDTO.setEquipmentId(equipment.getEquipmentId());
                    equipmentDataDTO.setEquipmentName(equipment.getName());
                    equipmentDataDTO.setParameter(result.toString());
                    equipmentDataDTO.setDataTime(DateUtils.TimeStampToDate(jsonData.getTimeStamp()));
                    equipmentDataDTO.setMsg("参数正常");
                    *//*System.out.println(equipmentDataDTO);*//*
                    dataDTOList.add(equipmentDataDTO);
                }
            }
        }
        System.out.println(new Date());
        System.out.println(dataDTOList);*/
        /*if (jsonData.getData().get(j).getO() == true){
            System.out.println("离线");
        }
        if (jsonData.getData().get(j).getD() == true){
            System.out.println("开仓、开门");
        }
        if (jsonData.getData().get(j).getR() == true){
            System.out.println("数据超出正常值");
        }
        if (jsonData.getData().get(j).getV() == true){
            System.out.println("连通，但无效");
        }*/
    }

    @Test
    public void getEquipmentByRoomId1() {
       /* List<Rooms> roomsList = roomMapper.getAllRooms();
        for (Rooms rooms : roomsList){
            List<EquipmentDataDTO> list = equipmentService.getEquipmentByRoomId(rooms.getRoomId());
            System.out.println(list);
        }*/
        /*JsonData jsonData=equipmentDataService.getTheLastEquipmentData();
        System.out.println(jsonData);*/
        /*List<EquipmentDataDTO> list = equipmentService.getEquipmentByRoomId(1);
        System.out.println(list);*/
        /*Map map = new HashMap();
        map.put("equipmentId",0);
        map.put("roomId",1);
        Equipments equipments = equipmentMapper.getEquipmentByIdAndRoomId(map);
        System.out.println(equipments);*/
        List<Equipments> equipmentsList = equipmentMapper.getEquipmentByRoomId(1);
        JsonData jsonData = equipmentDataService.getTheLastEquipmentData();
        //当采集的json数据和房间的设备不一致时
        /*for (int i=0; i<equipmentsList.size();i++){
            for (int j=0; j<jsonData.getData().size(); j++){
                if (equipmentsList.get(i).getEquipmentId() == jsonData.getData().get(j).getI()){
                    equipmentsList.remove(equipmentsList.get(i));
                }
                System.out.println("equipmentsList："+equipmentsList.get(i).getEquipmentId()+"+++++++++++jsonData："+jsonData.getData().get(j).getI());
            }
           *//* System.out.println(equipmentsList);*//*
        }

        for (Equipments equipments : equipmentsList){
            System.out.println(equipments);
        }*/

        /*long startTime = System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            List<EquipmentDataDTO> equipmentDataDTO = equipmentService.getEquipmentByRoomId(1);

        }*/
        //List<EquipmentDataDTO> equipmentDataDTO = equipmentService.getEquipmentByRoomId(1);
        /*System.out.println(equipmentDataDTO);*/
        /*long endTime = System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("执行时间："+excTime+"s");*/
        List<EquipmentDataDTO> equipmentDataDTO = equipmentService.getEquipmentByRoomId(1);
        /*System.out.println(equipmentDataDTO);*/


    }
}