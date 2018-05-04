package com.sery.labmon.service;

import com.sery.labmon.model.EquipmentDatas;

import java.util.List;
import java.util.Map;

/**
 * Created by LuDan on 2018/5/2 15:09
 */
public interface EquipmentDataService {
    /**
     * 获取所有的采集数据
     * @return
     */
    List<EquipmentDatas> getAllEquipmentDatas();

    /**
     * 获取最后一条记录
     * @return
     */
    /*EquipmentDatas getTheLastEquipmentData();*/

    /**
     * 获取最后一条记录
     * @return
     */
    List getTheLastEquipmentData();
}
