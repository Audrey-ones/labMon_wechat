package com.sery.labmon.service;

import com.google.gson.Gson;
import com.sery.labmon.dao.DataTemplateMapper;
import com.sery.labmon.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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
        List<Equipments> equipmentsList = equipmentService.getEquipmentByRoomId(1);
        JsonData jsonData = equipmentDataService.getTheLastEquipmentData();
        /*System.out.println(equipmentsList.size());*/
        List<EquipmentDataDTO> dataDTOList = new ArrayList<EquipmentDataDTO>();
        for (int i=0; i<equipmentsList.size(); i++){
            for (int j=0; j<jsonData.getData().size(); j++){
                if (equipmentsList.get(i).getEquipmentId().equals(jsonData.getData().get(j).getI()) ){
                    DataTemplates dataTemplate = dataTemplateMapper.getDataTemplateById(equipmentsList.get(i).getDataTemplateId());
                    System.out.println(dataTemplate.getTemplate());
                    Gson gson = new Gson();
                    /*List<String> strings = gson.fromJson(dataTemplate,JsonData.class);*/
                    /*String template = dataTemplate.getTemplate().replaceAll("\\[","").replaceAll("\\]","").replaceAll("\\\"","").replaceAll("CH","通道");
                    System.out.println(template+"=="+equipmentsList.get(i).getName());*/
                    List<Double> values = jsonData.getData().get(i).getS();
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
                   /* if (values != null){
                        StringBuffer result = new StringBuffer();
                        if (template.indexOf(",") != -1){
                            String[] tempArray = template.split(",");

                            for (int k=0; k<values.size(); k++){
                                System.out.println(tempArray[k]);
                                String dataStr = String.valueOf(values.get(k));
                                StringBuffer sb = new StringBuffer(tempArray[k]);
                                int index = tempArray[k].lastIndexOf(":");
                                sb.insert(index+1,dataStr);
                                String str = sb.toString();
                                result.append(str+";");
                                System.out.println(str);
                            }
                        }else {
                            String dataStr = String.valueOf(values.get(k));
                        }

                        System.out.println(template);

                        System.out.println(result);
                        EquipmentDataDTO dataDTO = new EquipmentDataDTO();
                        dataDTO.setEquipmentId(jsonData.getData().get(j).getI());
                        dataDTO.setEquipmentName(equipmentsList.get(i).getName());
                        dataDTOList.add(dataDTO);
                    }else {

                    }*/
                    /*System.out.println(values);
                    System.out.println(equipmentsList.get(i).getEquipmentId()+"==="+equipmentsList.get(i).getRoomId()+"=="+equipmentsList.get(i).getName());
*/
                }
            }

        }
        System.out.println(dataDTOList);
    }
}