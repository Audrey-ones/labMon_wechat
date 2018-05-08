package com.sery.labmon.service;

import com.google.gson.Gson;
import com.sery.labmon.dao.DataTemplateMapper;
import com.sery.labmon.dao.EquipmentDataMapper;
import com.sery.labmon.dao.EquipmentMapper;
import com.sery.labmon.model.*;
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

    @Autowired
    private EquipmentDataMapper equipmentDataMapper;

    @Test
    public void getAllEquipmentDatas() {

        List<EquipmentDatas> list = equipmentDataService.getAllEquipmentDatas();
        System.out.println(list);
        System.out.println(list.size());
    }

    @Test
    public void getTheLastEquipmentData() {
        String equipmentData = equipmentDataMapper.getTheLastEquipmentData().toString();
        System.out.println(equipmentData);
        Gson gson = new Gson();
        JsonData jsonData = gson.fromJson(equipmentData,JsonData.class);
        System.out.println(jsonData);
        System.out.println(jsonData.getTimeStamp());
        System.out.println(jsonData.getData());
        for (JsonEquipmentData json : jsonData.getData()){
            /*System.out.println(json.getI());
            System.out.println(json.getS());*/
            /*System.out.println(json.getI());*/
            List<Double> values = json.getS();
            if (values == null){
                System.out.println("skdks");
            }else {
                //System.out.println(S.size());
                for (int i=0;i< values.size();i++){
                    System.out.println(values.get(i));
                }
            }
            /*System.out.println(S.size());*/
            /*if (S.toString().equals(null)){
                for (int i=0;i< S.size();i++){
                    System.out.println(S.get(i));
                }
            }*/
            /*System.out.println(S.size());*/
            /*for (int i=0;i< S.size();i++){
                System.out.println(S.get(i));
            }*/
            /*List<Double> doubles = new ArrayList<Double>();*/
            /*doubles.add(1.0);
            doubles.add(5.2);
            System.out.println(doubles);
            for (int i=0;i< doubles.size();i++){
                System.out.println(doubles.get(i));
            }*/
        }
        /*Map equipmentData = equipmentDataService.getTheLastEquipmentData();*/
        /*JSONArray json = (JSONArray) equipmentData.get("data");*/
        /*EquipmentDatas equipmentData = equipmentDataMapper.getTheLastEquipmentData();
        JSONArray json = JSONArray.fromObject(equipmentData.getData());
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
                *//*if (!equData.equals("null")){*//*
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
                *//*}*//*
                System.out.println(equipmentId+"数据为："+equData);
            }
            System.out.println(list);
            *//*System.out.println(list.equals(""));*//*
        }
        for (int i=0;i<list.size();i++){
            Map map = (Map) list.get(i);
            *//*System.out.println(map.get("")map.get("data"));*//*
        }*/


    }
}