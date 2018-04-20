package com.sery.labmon.dao;



import com.sery.labmon.model.Patient;

import java.util.List;

public interface PatientMapper {


    /**
     * 查询所有的病人信息
     * @return
     */
    List<Patient> selectAllPatient();


    /**
     * 根据病人ID查找一条病人记录
     * @param patientId
     * @return
     */
    Patient selectPatientById(int patientId);

    /**
     * 更新病人信息
     * @param patient
     * @return
     */
    int updatePatient(Patient patient);


}
