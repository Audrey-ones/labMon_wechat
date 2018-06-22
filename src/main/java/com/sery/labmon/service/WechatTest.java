package com.sery.labmon.service;

import com.sery.labmon.dao.EquipmentMapper;
import com.sery.labmon.dao.RoomMapper;
import com.sery.labmon.model.AlarmInfo;
import com.sery.labmon.model.Equipments;
import com.sery.labmon.utils.DateUtils;
import com.sery.labmon.wechat.WechatHelper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.List;

@Component("testQuartz")
public class WechatTest {

    /*public String run(){
        Date date = new Date();
        String result = date+"每五秒执行一次run方法！";
        System.out.println(result);
        return result;
    }*/

    @Autowired
    private AlarmInfoService alarmInfoService;

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private RoomMapper roomMapper;

   public boolean run() {
       List<AlarmInfo> alarmInfoList = alarmInfoService.getAlarmInfos();
       if (alarmInfoList.size() != 0){
           for (AlarmInfo alarmInfo : alarmInfoList) {
               if (alarmInfo.getHandled() == 0){
                   String date = DateUtils.TimeStampToDate(alarmInfo.getTimeStamp());
                   Equipments equipment = equipmentMapper.getEquipmentById(alarmInfo.getEquipmentID());
                   String roomName = roomMapper.getRoomByRoomId(equipment.getRoomId()).getName();
                   String equipmentName = roomName+"-"+equipment.getName();
                   String valueMsg = "";
                   if (alarmInfo.getType() == 1){
                       valueMsg = "超过警戒值,值为"+alarmInfo.getCurrentVal()+alarmInfo.getUnit()+",";
                   }
                   if (alarmInfo.getType() == 2){
                       valueMsg = "低于警戒值,值为"+alarmInfo.getCurrentVal()+alarmInfo.getUnit()+",";
                   }
                   if (alarmInfo.getType() == 3){
                       valueMsg = "出现掉电异常,值为"+alarmInfo.getCurrentVal()+alarmInfo.getUnit()+",";
                   }
                   if (alarmInfo.getType() == 4){
                       valueMsg = "出现掉线异常,";
                   }
                   String msg;
                   msg = "您好，实验室"+equipmentName+"中的"+alarmInfo.getPhysicalQuantity()+"在"+date+valueMsg+"请及时处理！";
                   StringBuffer sb = new StringBuffer();
                   sb.append("{ 'totag': '1','msgtype': 'text', 'agentid': 1000003, 'text': {'content': '" + msg + "'}}");
                   JSONObject jsonParam = JSONObject.fromObject(sb.toString());
                   WechatHelper wechatHelper = new WechatHelper();
                   ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
                   String accessToken = (String) servletContext.getAttribute("accessToken");
                   wechatHelper.sendCorpMsg(accessToken, jsonParam);
                   /*System.out.println(accessToken+"+++++++++"+jsonParam);*/
               }
           }
       }
      /* String msg;
       msg = "您好，实验室液氮罐组的状态出现异常，请及时处理！";
       StringBuffer sb = new StringBuffer();
       sb.append("{ 'totag': '1','msgtype': 'text', 'agentid': 1000003, 'text': {'content': '" + msg + "'}}");
       JSONObject jsonParam = JSONObject.fromObject(sb.toString());
       WechatHelper wechatHelper = new WechatHelper();
       ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
       String accessToken = (String) servletContext.getAttribute("accessToken");
       wechatHelper.sendCorpMsg(accessToken, jsonParam);
       System.out.println(accessToken+"+++++++++"+jsonParam);
       return true;*/
       return true;
   }
}
