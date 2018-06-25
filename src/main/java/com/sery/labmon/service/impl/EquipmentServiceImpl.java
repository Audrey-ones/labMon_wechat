package com.sery.labmon.service.impl;

import com.google.gson.Gson;
import com.sery.labmon.dao.DataTemplateMapper;
import com.sery.labmon.dao.EquipmentMapper;
import com.sery.labmon.model.*;
import com.sery.labmon.service.EquipmentDataService;
import com.sery.labmon.service.EquipmentService;
import com.sery.labmon.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuDan on 2018/4/26 13:40
 */

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private EquipmentDataService equipmentDataService;

    @Autowired
    private DataTemplateMapper dataTemplateMapper;

    /*@Override
    public List<Equipments> getEquipmentByRoomId(int roomId) {
        List<Equipments> equipmentsList = equipmentMapper.getEquipmentByRoomId(roomId);
        return equipmentsList;
    }*/
    @Override
    public List<EquipmentDataDTO> getEquipmentByRoomId(int roomId) {
        //根据房间ID获取该房间的所有设备
        List<Equipments> equipmentsList = equipmentMapper.getEquipmentByRoomId(roomId);
        //获取采集到最新一条记录的json数组
        JsonData jsonData = equipmentDataService.getTheLastEquipmentData();
        List<EquipmentDataDTO> dataDTOList = new ArrayList<EquipmentDataDTO>();
        for (Equipments equipment : equipmentsList){
            for (JsonEquipmentData jsonEquipmentData : jsonData.getData()){
                //遍历房间内所有设备和json数组，是否匹配
                if (equipment.getEquipmentId().equals(jsonEquipmentData.getI())){
                    DataTemplates dataTemplate = dataTemplateMapper.getDataTemplateById(equipment.getDataTemplateId());
                    String templateStr = dataTemplate.templateToJsonString();
                    Gson gson = new Gson();
                    Template template = gson.fromJson(templateStr,Template.class);
                    List<Double> equValues = jsonEquipmentData.getS();
                    StringBuffer result = new StringBuffer();
                    if (equValues != null){
                        for (int i=0; i<equValues.size(); i++){
                            //让double类型的保留两位小数
                            BigDecimal bg = new BigDecimal(equValues.get(i));
                            double equValue = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                            /*DecimalFormat df = new DecimalFormat("#.00");
                            String equValue = df.format(equValues.get(i));*/
                            //替换模板的字符(CH替换成t；把CH之后的:温度去掉；小写的冒号替换成大写的冒号)
                            String tempValue = template.getTemplate().get(i).replaceAll("CH","t").replaceAll(":温度","")
                                    .replaceAll(":","：");
                            //字符串拼接，在字符串的某个位置插入另一个字符
                            StringBuffer sb = new StringBuffer(tempValue);
                            int index = tempValue.lastIndexOf("：");
                            sb.insert(index+1,equValue);
                            String str = sb.toString();
                            result.append(str+"；");
                        }
                    }else {
                        result.append("参数为null");
                    }
                    EquipmentDataDTO equipmentDataDTO = new EquipmentDataDTO();
                    equipmentDataDTO.setEquipmentId(equipment.getEquipmentId());
                    equipmentDataDTO.setEquipmentName(equipment.getName());
                    equipmentDataDTO.setParameter(result.toString());
                    equipmentDataDTO.setDataTime(DateUtils.TimeStampToDate(jsonData.getTimeStamp()));
                    equipmentDataDTO.setMsg("参数正常");
                    dataDTOList.add(equipmentDataDTO);
                }
            }
        }

        return dataDTOList;
    }
}
