package com.sery.labmon.service.impl;

import com.sery.labmon.dao.EquipmentDataMapper;
import com.sery.labmon.dao.EquipmentMapper;
import com.sery.labmon.model.EquipmentDatas;

import com.sery.labmon.model.Equipments;
import com.sery.labmon.service.EquipmentDataService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<EquipmentDatas> getAllEquipmentDatas() {
        List<EquipmentDatas> equipmentDatasList = equipmentDataMapper.getAllEquipmentDatas();
        return equipmentDatasList;
    }

    @Override
    public Map getTheLastEquipmentData() {
        EquipmentDatas equipmentData = equipmentDataMapper.getTheLastEquipmentData();
        Map map = new HashMap();
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
        return map;
    }
}
