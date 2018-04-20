package com.sery.labmon.service;


import com.sery.labmon.model.Patient;
import net.sf.json.JSONObject;

import java.util.List;

public interface PatientService {


    /**
     * 查询所有的病人信息
     * @return
     */
    List<Patient> getPatientList();

    /**
     * 更新病人信息
     * @param patient
     * @return
     */
    int updatePatient(Patient patient);


    /**
     * 根据病人ID获取病人信息
     * @param patientId
     * @return
     */
    Patient getPatientById(int patientId);

    String getHtmlData();


}
