package com.sery.labmon.dao;

import com.sery.labmon.model.AlarmInfo;

import java.util.List;

/**
 * Created by LuDan on 2018/6/14 15:49
 */
public interface AlarmInfoMapper {

    /**
     * 查询所有未处理的报警信息
     * @return
     */
    List<AlarmInfo> getAllAlarmInfo();

    /**
     * 查询所有已处理的报警信息
     * @return
     */
    List<AlarmInfo> getAlarmInfoByHandled();

    /**
     * 查找24小时内所有的报警记录
     * @return
     */
    List<AlarmInfo> selectAllAlarmInfo();

    /**
     * 处理报警信息
     * @return
     */
    int updateAlarmInfo(AlarmInfo alarmInfo);

    /**
     * 获取最新的处理人
     * @return
     */
    AlarmInfo getRecentlyHandler();

    /**
     * 根据处理人查找24小时内处理的报警信息
     * @param handler
     * @return
     */
    List<AlarmInfo> getAlarmInfoByHandler(String handler);
}
