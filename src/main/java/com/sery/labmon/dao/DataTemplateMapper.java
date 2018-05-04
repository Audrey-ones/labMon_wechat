package com.sery.labmon.dao;

import com.sery.labmon.model.DataTemplates;

/**
 * Created by LuDan on 2018/5/4 15:08
 */
public interface DataTemplateMapper {
    /**
     * 根据模板ID查找数据模板信息
     * @param dataTemplateId
     * @return
     */
    DataTemplates getDataTemplateById(int dataTemplateId);
}
