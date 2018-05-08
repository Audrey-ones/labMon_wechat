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
    }
}
