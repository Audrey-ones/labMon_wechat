package com.sery.labmon.service;

import com.google.gson.Gson;
import com.sery.labmon.dao.DataTemplateMapper;
import com.sery.labmon.model.*;
import com.sery.labmon.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private EquipmentDataService equipmentDataService;

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
}