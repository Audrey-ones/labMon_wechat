package com.sery.labmon.dao;

import com.sery.labmon.model.EquipmentDatas;

import java.util.List;

/**
 * Created by LuDan on 2018/5/2 15:00
 */
public interface EquipmentDataMapper {
    /**
     * 获取所有的采集数据
     * @return
     */
    List<EquipmentDatas> getAllEquipmentDatas();

    /**
     * 获取最后一条记录
     * @return
     */
    EquipmentDatas getTheLastEquipmentData();
}
