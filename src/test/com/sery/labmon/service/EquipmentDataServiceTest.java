package com.sery.labmon.service;

import com.sery.labmon.dao.DataTemplateMapper;
import com.sery.labmon.dao.EquipmentMapper;
import com.sery.labmon.model.DataTemplates;
import com.sery.labmon.model.EquipmentDatas;
import com.sery.labmon.model.Equipments;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by LuDan on 2018/5/2 15:12
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class EquipmentDataServiceTest {
    @Autowired
    private EquipmentDataService equipmentDataService;

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private DataTemplateMapper dataTemplateMapper;

    @Test
    public void getAllEquipmentDatas() {

        List<EquipmentDatas> list = equipmentDataService.getAllEquipmentDatas();
        System.out.println(list);
        System.out.println(list.size());
    }

    @Test
    public void getTheLastEquipmentData() {
        /*Map equipmentData = equipmentDataService.getTheLastEquipmentData();
        JSONArray json = (JSONArray) equipmentData.get("data");
        List list = new ArrayList();
        if (json.size()>0){
            for (int i=0; i<json.size(); i++){
                Map map = new HashMap();
                JSONObject jsonObject = json.getJSONObject(i);
                int equipmentId = Integer.parseInt(String.valueOf(jsonObject.get("I")));
                Equipments equipment = equipmentMapper.getEquipmentById(equipmentId);
                DataTemplates dataTemplate = dataTemplateMapper.getDataTemplateById(equipment.getDataTemplateId());
                String template = dataTemplate.getTemplate().replaceAll("\\[","").replaceAll("\\]","").replaceAll("\\\"","").replaceAll("CH","通道");
                String equData = String.valueOf(jsonObject.get("S")).replaceAll("\\[","").replaceAll("\\]","");
                if (!equData.equals("null")){
                    String[] equDataArray = equData.split(",");
                    String[] tempArray = template.split(",");
                    StringBuffer result = new StringBuffer();
                    for (int j=0; j<equDataArray.length; j++){
                        StringBuffer sb = new StringBuffer(tempArray[j]);
                        int index = tempArray[j].lastIndexOf(":");
                        sb.insert(index+1,equDataArray[j]);
                        String str = sb.toString();
                        result.append(str+";");
                    }
                    System.out.println(result.toString());
                    map.put("equipment",equipment);
                    map.put("data",result);
                    list.add(map);
                }
                *//*System.out.println(equipmentId+"数据为："+equData);*//*
            }
            System.out.println(list);
        }*/
    }
}