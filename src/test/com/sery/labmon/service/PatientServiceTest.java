package com.sery.labmon.service;

import com.sery.labmon.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;

    @Autowired
    WechatTest wechatTest;


    @Test
    public void getPatientList() {
        List<Patient> patientList = patientService.getPatientList();
        System.out.println(patientList);
    }

    @Test
    public void updatePatient() {
        Patient patient = new Patient();
        patient.setPatientId(11);
        patient.setMedicalRecord("ssfdf");
        patient.setFemaleName("gfghfh");
        patient.setMaleName("retfgd");
        patient.setFemaleIdNum("fgdfg");
        patient.setMaleIdNum("ghgh");
        patient.setAddress("hgh");
        patient.setPhone("ghgh");
        patient.setRemark("张雨绮");
        int result = patientService.updatePatient(patient);
        System.out.println(result);
    }


    @Test
    public void getHtmlData() {
        System.out.println(patientService.getHtmlData());
    }


    @Test
    public void getTestInfo() {
        System.out.println(wechatTest.run());

    }
}