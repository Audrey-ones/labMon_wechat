package com.sery.labmon.service.impl;

import com.sery.labmon.dao.PatientMapper;
import com.sery.labmon.model.Patient;
import com.sery.labmon.service.PatientService;
import com.sery.labmon.wechat.utils.HttpRequestUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;



    @Override
    public List<Patient> getPatientList() {
        List<Patient> patientList = patientMapper.selectAllPatient();
        return patientList;
    }

    @Override
    public int updatePatient(Patient patient) {
        int result = patientMapper.updatePatient(patient);
        return result;
    }

    @Override
    public Patient getPatientById(int patientId) {
        Patient patient = patientMapper.selectPatientById(patientId);
        return patient;
    }

    @Override
    public String getHtmlData() {
        String url = "http://192.168.1.200/pIndex?pgNo=1";
        String jsoninfo = HttpRequestUtils.httpGetHtml(url);
        String data = jsoninfo.toString();
        return data;
    }


}
