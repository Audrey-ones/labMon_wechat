package com.sery.labmon.service.impl;

import com.google.gson.Gson;
import com.sery.labmon.dao.DataTemplateMapper;
import com.sery.labmon.dao.EquipmentDataMapper;
import com.sery.labmon.dao.EquipmentMapper;
import com.sery.labmon.model.*;

import com.sery.labmon.service.EquipmentDataService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LuDan on 2018/5/2 15:10
 */

@Service
public class EuqipmentDataServiceImpl implements EquipmentDataService {
    @Autowired
    private EquipmentDataMapper equipmentDataMapper;

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    DataTemplateMapper dataTemplateMapper;

    @Override
    public List<EquipmentDatas> getAllEquipmentDatas() {
        List<EquipmentDatas> equipmentDatasList = equipmentDataMapper.getAllEquipmentDatas();
        return equipmentDatasList;
    }

    @Override
    public JsonData getTheLastEquipmentData() {
        String equipmentData = equipmentDataMapper.getTheLastEquipmentData().toString();
        //使用Gson把字符串转换成json对象
        Gson gson = new Gson();
        JsonData jsonData = gson.fromJson(equipmentData,JsonData.class);
        return jsonData;

        /*Map map = new HashMap();
        map.put("timestamp",equipmentData.getTimeStamp());
        JSONArray json = JSONArray.fromObject(equipmentData.getData());
        if (json.size() > 0){
            for (int i=0; i<json.size();i++){
                JSONObject obj = json.getJSONObject(i);
                int equipmentId = Integer.parseInt(String.valueOf(obj.get("I")));
                Equipments equipment = equipmentMapper.getEquipmentById(equipmentId);
            }
        }
        map.put("data",json);
        return map;*/
        /*JSONArray json = JSONArray.fromObject(equipmentData.getData());
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
        }

        return list;*/
    }
}
