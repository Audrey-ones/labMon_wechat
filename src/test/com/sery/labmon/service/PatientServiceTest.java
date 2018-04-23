package com.sery.labmon.service;

import com.sery.labmon.dao.UserMapper;
import com.sery.labmon.model.Patient;
import com.sery.labmon.model.User;
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
    private UserMapper userMapper;

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
    public void getAllUser() {
        List<User> users = userMapper.getAllUser();
        for (User user : users){
            if (user.getPassword().equals("123456")){
                System.out.println(user.getPassword()+"password");
            }else {
                System.out.println("密码不正确");
            }

        }

    }

    @Test
    public void getTestInfo() {
        System.out.println(wechatTest.run());

    }
}