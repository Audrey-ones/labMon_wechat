package com.sery.labmon.service;

import com.sery.labmon.model.AlarmInfo;

import java.util.List;

/**
 * Created by LuDan on 2018/6/15 13:58
 */
public interface AlarmInfoService {
    /**
     * 获取所有未处理的报警信息
     * @return
     */
    List<AlarmInfo> getAlarmInfos();

    /**
     * 获取24小时内的所有报警记录
     * @return
     */
    List getAllAlarmInfoList();

    /**
     * 处理报警信息
     * @param alarmInfo
     * @return
     */
    int hanleAlarmIo(AlarmInfo alarmInfo);

    /**
     * 获取最新的处理人
     * @return
     */
    AlarmInfo getRecentlyHandler();
}
