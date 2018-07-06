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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    /*@Override
    public List<EquipmentDataDTO> getEquipmentByRoomId(int roomId) {
        //根据房间ID获取该房间的所有设备
        List<Equipments> equipmentsList = equipmentMapper.getEquipmentByRoomId(roomId);
        //获取采集到最新一条记录的json数组
        JsonData jsonData = equipmentDataService.getTheLastEquipmentData();
        List<EquipmentDataDTO> dataDTOList = new ArrayList<EquipmentDataDTO>();
        for (Equipments equipment : equipmentsList){
            StringBuffer result = new StringBuffer();
            String msg = "";
            //当最近一条采集数据的json数据不为空时，获取采集数据，与模板进行拼接
            if (jsonData.getData().size() != 0){
                //遍历房间内所有设备和json数组，是否匹配
                for (JsonEquipmentData jsonEquipmentData : jsonData.getData()){
                    //房间内的设备ID和json数组的设备ID一致时，表示json数组采集了该设备的数据
                    if (equipment.getEquipmentId().equals(jsonEquipmentData.getI())){
                        DataTemplates dataTemplate = dataTemplateMapper.getDataTemplateById(equipment.getDataTemplateId());//根据模板ID，获取该设备的数据模板
                        String templateStr = dataTemplate.templateToJsonString();//转换成符合Gson规范的
                        Gson gson = new Gson();
                        Template template = gson.fromJson(templateStr,Template.class);
                        List<Double> equValues = jsonEquipmentData.getS();
                        if (equValues != null){//该设备没有异常，有数据
                            for (int i=0; i<equValues.size(); i++){
                                //让double类型的保留两位小数
                                BigDecimal bg = new BigDecimal(equValues.get(i));
                                double equValue = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                                *//*DecimalFormat df = new DecimalFormat("#.00");
                                String equValue = df.format(equValues.get(i));*//*
                                //替换模板的字符(CH替换成t；把CH之后的:温度去掉；小写的冒号替换成大写的冒号)
                                String tempValue = template.getTemplate().get(i).replaceAll("CH","t")
                                        .replaceAll(":温度","").replaceAll(":","：");
                                //字符串拼接，在字符串的某个位置插入另一个字符
                                StringBuffer sb = new StringBuffer(tempValue);
                                int index = tempValue.lastIndexOf("：");
                                sb.insert(index+1,equValue);
                                String str = sb.toString();
                                result.append(str+"；");
                            }
                            msg = "采集正常";
                        }else {//该设备出现异常，掉电或掉线，没有数据
                            result.append("暂无采集数据，有可能出现异常哦~");
                            msg = "采集异常，掉电或掉线";
                        }
                        EquipmentDataDTO equipmentDataDTO = new EquipmentDataDTO();
                        equipmentDataDTO.setEquipmentId(equipment.getEquipmentId());
                        equipmentDataDTO.setEquipmentName(equipment.getName());
                        equipmentDataDTO.setParameter(result.toString());
                        equipmentDataDTO.setDataTime(DateUtils.TimeStampToDate(jsonData.getTimeStamp()));
                        equipmentDataDTO.setMsg(msg);
                        dataDTOList.add(equipmentDataDTO);
                    }*//*else {//表示json数组不含有该设备的数据，没有采集到
                        result.append("该设备没有采集数据哦~");
                        msg = "采集的json数组不含有该设备的采集数据";
                    }*//*

                }
            }else {//最近的采集表采集数据为空
                result.append("该设备暂无采集数据哦");
                msg = "该设备暂无采集数据";
                EquipmentDataDTO equipmentDataDTO = new EquipmentDataDTO();
                equipmentDataDTO.setEquipmentId(equipment.getEquipmentId());
                equipmentDataDTO.setEquipmentName(equipment.getName());
                equipmentDataDTO.setParameter(result.toString());
                equipmentDataDTO.setDataTime(DateUtils.TimeStampToDate(jsonData.getTimeStamp()));
                equipmentDataDTO.setMsg(msg);
                dataDTOList.add(equipmentDataDTO);
            }
            *//*EquipmentDataDTO equipmentDataDTO = new EquipmentDataDTO();
            equipmentDataDTO.setEquipmentId(equipment.getEquipmentId());
            equipmentDataDTO.setEquipmentName(equipment.getName());
            equipmentDataDTO.setParameter(result.toString());
            equipmentDataDTO.setDataTime(DateUtils.TimeStampToDate(jsonData.getTimeStamp()));
            equipmentDataDTO.setMsg(msg);
            dataDTOList.add(equipmentDataDTO);*//*

        }

        return dataDTOList;
    }*/

    @Override
    public List<EquipmentDataDTO> getEquipmentByRoomId(int roomId) {
        //根据房间ID获取该房间的所有设备
        List<Equipments> equipmentsList = equipmentMapper.getEquipmentByRoomId(roomId);
        //获取采集到最新一条记录的json数组
        JsonData jsonData = equipmentDataService.getTheLastEquipmentData();
        List<EquipmentDataDTO> dataDTOList = new ArrayList<EquipmentDataDTO>();
        for (JsonEquipmentData jsonEquipmentData:jsonData.getData()){
            StringBuffer result = new StringBuffer();
            String msg = "";
            Map map = new HashMap();
            map.put("equipmentId",jsonEquipmentData.getI());
            map.put("roomId",roomId);
            Equipments equipment = equipmentMapper.getEquipmentByIdAndRoomId(map);
            if (equipment != null){
                DataTemplates dataTemplate = dataTemplateMapper.getDataTemplateById(equipment.getDataTemplateId());//根据模板ID，获取该设备的数据模板
                String templateStr = dataTemplate.templateToJsonString();//转换成符合Gson规范的
                Gson gson = new Gson();
                Template template = gson.fromJson(templateStr,Template.class);
                List<Double> equValues = jsonEquipmentData.getS();
                if (equValues != null){//该设备没有异常，有数据
                    for (int i=0; i<equValues.size(); i++){
                        //让double类型的保留两位小数
                        BigDecimal bg = new BigDecimal(equValues.get(i));
                        double equValue = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        /*DecimalFormat df = new DecimalFormat("#.00");
                        String equValue = df.format(equValues.get(i));*/
                        try {
                            //替换模板的字符(CH替换成t；把CH之后的:温度去掉；小写的冒号替换成大写的冒号)
                            String tempValue = template.getTemplate().get(i).replaceAll("CH","t")
                                    .replaceAll(":温度","").replaceAll(":","：");
                            //字符串拼接，在字符串的某个位置插入另一个字符
                            StringBuffer sb = new StringBuffer(tempValue);
                            int index = tempValue.lastIndexOf("：");
                            sb.insert(index+1,equValue);
                            String str = sb.toString();
                            result.append(str+"；");
                        }catch (Exception e){
                            continue;
                        }

                    }
                    msg = "采集正常";
                }else {//该设备出现异常，掉电或掉线，没有数据
                    result.append("暂无采集数据，有可能出现异常哦~");
                    msg = "采集异常，掉电或掉线";
                }
                EquipmentDataDTO equipmentDataDTO = new EquipmentDataDTO();
                equipmentDataDTO.setEquipmentId(equipment.getEquipmentId());
                equipmentDataDTO.setEquipmentName(equipment.getName());
                equipmentDataDTO.setParameter(result.toString());
                equipmentDataDTO.setDataTime(DateUtils.TimeStampToDate(jsonData.getTimeStamp()));
                equipmentDataDTO.setMsg(msg);
                dataDTOList.add(equipmentDataDTO);
            }

        }

        //当采集的json数据不包含该房间所有设备时
        if (equipmentsList.size() != dataDTOList.size()){
            for (int i=0; i<equipmentsList.size();i++){
                for (int j=0; j<jsonData.getData().size(); j++){
                    //System.out.println(jsonData.getData().get(j));
                    if (equipmentsList.get(i).getEquipmentId() == jsonData.getData().get(j).getI()){
                        //System.out.println("dataList:"+equipmentsList.get(i));
                        equipmentsList.remove(equipmentsList.get(i));
                    }
                }
            }

            for (Equipments equipment : equipmentsList){
                EquipmentDataDTO equipmentDataDTO = new EquipmentDataDTO();
                equipmentDataDTO.setEquipmentId(equipment.getEquipmentId());
                equipmentDataDTO.setEquipmentName(equipment.getName());
                equipmentDataDTO.setParameter("该设备目前没有采集数据哦~");
                equipmentDataDTO.setDataTime(DateUtils.TimeStampToDate(jsonData.getTimeStamp()));
                equipmentDataDTO.setMsg("采集的json表不含有该房间全部设备的数据");
                dataDTOList.add(equipmentDataDTO);
            }
        }
        return dataDTOList;
    }
}
