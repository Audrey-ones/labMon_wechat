package com.sery.labmon.service.impl;

import com.sery.labmon.dao.AlarmInfoMapper;
import com.sery.labmon.dao.EquipmentMapper;
import com.sery.labmon.dao.RoomMapper;
import com.sery.labmon.model.AlarmInfo;
import com.sery.labmon.model.Equipments;
import com.sery.labmon.service.AlarmInfoService;
import com.sery.labmon.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by LuDan on 2018/6/15 14:00
 */
@Service
public class AlarmInfoServiceImpl implements AlarmInfoService{
    @Autowired
    private AlarmInfoMapper alarmInfoMapper;

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<AlarmInfo> getAlarmInfos() {
        List<AlarmInfo> alarmInfoList = alarmInfoMapper.getAllAlarmInfo();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        long nowTime = Long.parseLong(df.format(new Date()).substring(2));// new Date()为获取当前系统时间，也可使用当前时间戳
        //取截止此时此刻为止24小时内的数据
        List<AlarmInfo> list = new ArrayList<>();
        for (AlarmInfo alarmInfo:alarmInfoList){
            if (nowTime-alarmInfo.getTimeStamp()<=1000000){
                list.add(alarmInfo);
            }
        }

        //去重,当类型、设备ID、物理量索引一致时，获取最新时间的报警值
        for (int i=0; i<list.size()-1; i++){
            for (int j=list.size()-1; j>i; j--){
                if (list.get(i).getType()==list.get(j).getType() && (list.get(i).getEquipmentID()==list.get(j).getEquipmentID())
                        && (list.get(i).getIndexOfTemplate()==list.get(j).getIndexOfTemplate())){
                    list.get(i).setHandled(1);
                    list.get(i).setHandler("过期失效");
                    alarmInfoMapper.updateAlarmInfo(list.get(i));
                    list.remove(list.get(i));
                }
            }
        }
        return list;
    }

    @Override
    public List getAllAlarmInfoList() {
        List<AlarmInfo> alarmInfoList = alarmInfoMapper.selectAllAlarmInfo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        long nowTime = Long.parseLong(sdf.format(new Date()).substring(2));
        List list = new ArrayList();
        for (int i=0; i<alarmInfoList.size(); i++){
            AlarmInfo alarmInfo = alarmInfoList.get(i);
            Equipments equipment = equipmentMapper.getEquipmentById(alarmInfo.getEquipmentID());
            String roomName = roomMapper.getRoomByRoomId(equipment.getRoomId()).getName();
            String equipmentName = roomName+"&"+equipment.getName();
            Map map = new HashMap();
            if (nowTime-alarmInfo.getTimeStamp()<=1000000){
                map.put("no",i+1);
                map.put("alarmTime", DateUtils.timeStampToString(alarmInfo.getTimeStamp()));
                map.put("equipmentName",equipmentName);
                String physicalQuantity = alarmInfo.getPhysicalQuantity().replaceAll(":","");
                map.put("value",physicalQuantity+"："+alarmInfo.getCurrentVal()+alarmInfo.getUnit());
                map.put("handler",alarmInfo.getHandler());
                map.put("type",alarmInfo.getType());
                list.add(map);
            }
        }
        return list;
    }

    @Override
    public int handleAlarmIo(AlarmInfo alarmInfo) {
        int result = alarmInfoMapper.updateAlarmInfo(alarmInfo);
        return result;
    }

    @Override
    public AlarmInfo getRecentlyHandler() {
        AlarmInfo alarmInfo = alarmInfoMapper.getRecentlyHandler();
        return alarmInfo;
    }

    @Override
    public String getAlarmInfoByHandler(String handler) {
        List<AlarmInfo> alarmInfoList = alarmInfoMapper.getAlarmInfoByHandler(handler);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        long nowTime = Long.parseLong(df.format(new Date()).substring(2));// new Date()为获取当前系统时间，也可使用当前时间戳
        //取截止此时此刻为止24小时内的数据
        List<AlarmInfo> list = new ArrayList<>();
        int i = 1;
        StringBuffer sb = new StringBuffer();
        sb.append("您在24小时内处理的信息有：\n");
        for (AlarmInfo alarmInfo:alarmInfoList){
            if (nowTime-alarmInfo.getTimeStamp()<=1000000){
                list.add(alarmInfo);
                String date = DateUtils.TimeStampToDate(alarmInfo.getTimeStamp());
                Equipments equipment = equipmentMapper.getEquipmentById(alarmInfo.getEquipmentID());
                String roomName = roomMapper.getRoomByRoomId(equipment.getRoomId()).getName();
                String equipmentName = roomName+"-"+equipment.getName();
                String valueMsg = "";
                if (alarmInfo.getType() == 1){
                    valueMsg = "为"+alarmInfo.getCurrentVal()+alarmInfo.getUnit()+",超过警戒值；";
                }
                if (alarmInfo.getType() == 2){
                    valueMsg = "为"+alarmInfo.getCurrentVal()+alarmInfo.getUnit()+",低于警戒值；";
                }
                if (alarmInfo.getType() == 3){
                    valueMsg = "为"+alarmInfo.getCurrentVal()+alarmInfo.getUnit()+",出现掉电异常；";
                }
                if (alarmInfo.getType() == 4){
                    valueMsg = "出现掉线异常,";
                }
                String msg = i+"."+date+equipmentName+"的"+alarmInfo.getPhysicalQuantity()+valueMsg+"\n";
                sb.append(msg);
                i++;
            }
        }

        String msg = "";
        if (list.size() != 0){
            msg = sb.toString();
        }else {
            msg = "您在24小时内没有处理过报警哦~";
        }

        return msg;
    }
}
