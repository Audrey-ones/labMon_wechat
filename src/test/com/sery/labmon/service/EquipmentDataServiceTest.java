package com.sery.labmon.service;

import com.sery.labmon.model.EquipmentDatas;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    public void getAllEquipmentDatas() {

        List<EquipmentDatas> list = equipmentDataService.getAllEquipmentDatas();
        System.out.println(list);
        System.out.println(list.size());
    }

    @Test
    public void getTheLastEquipmentData() {
        Map equipmentData = equipmentDataService.getTheLastEquipmentData();
        /*System.out.println(equipmentData.get("data"));*/
        JSONArray json = (JSONArray) equipmentData.get("data");
        if (json.size()>0){
            for (int i=0; i<json.size(); i++){
                JSONObject jsonObject = json.getJSONObject(i);
                int equipmentId = Integer.parseInt(String.valueOf(jsonObject.get("I")));
                String equData = String.valueOf(jsonObject.get("S")).replaceAll("\\[","").replaceAll("\\]","");
                if (equData != null){
                    String[] sarray = equData.split(",");
                    for (int j=0; j<sarray.length; j++){
                        System.out.println(sarray[j]);
                    }
                }

                System.out.println(equipmentId+"数据为："+equData);
            }
        }
    }
}