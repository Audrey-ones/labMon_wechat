package com.sery.labmon.service;

import com.sery.labmon.dao.AlarmInfoMapper;
import com.sery.labmon.model.AlarmInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LuDan on 2018/6/19 17:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class AlarmInfoServiceTest {

    @Autowired
    private AlarmInfoService alarmInfoService;

    @Autowired
    private AlarmInfoMapper alarmInfoMapper;

    @Test
    public void getAllAlarmInfoList() {
        List list = alarmInfoService.getAllAlarmInfoList();
        System.out.println(list);
    }

    @Test
    public void hanleAlarmIo() {
        AlarmInfo alarmInfo = new AlarmInfo();
        alarmInfo.setId(49);
        alarmInfo.setHandled(0);
        alarmInfo.setHandler("陆丹");
        alarmInfo.setType(5);
        alarmInfoService.handleAlarmIo(alarmInfo);
    }

    @Test
    public void getInfo() {
        List<AlarmInfo> alarmInfoList = alarmInfoMapper.getAlarmInfoByHandled();
        System.out.println(alarmInfoList);
        System.out.println(alarmInfoList.size());
        List<AlarmInfo> list = alarmInfoService.getAlarmInfos();
        for (AlarmInfo alarmInfo:alarmInfoList){
            System.out.println(alarmInfo);
            alarmInfo.setHandled(0);
            alarmInfo.setHandler("");
            alarmInfoService.handleAlarmIo(alarmInfo);
        }
        System.out.println(list);
        System.out.println(list.size());

    }
}