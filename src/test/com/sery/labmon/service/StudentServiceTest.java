package com.sery.labmon.service;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import com.sery.labmon.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LuDan on 2018/6/21 14:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void getAllStudentList() {
        List<Student> students = studentService.getAllStudentList();
        for (int i=0; i<students.size()-1; i++){
            for (int j=students.size()-1;j>i;j--){
                if (students.get(i).getName().equals(students.get(j).getName()) ){
                    System.out.println(students.get(j));
                    /*students.remove(students.get(j));*/
                }
            }
        }
        /*List list = new ArrayList();*/
        /*for (Student student:students){
            if (!list.contains(student)){
                list.add(student);
                *//*System.out.println(student);*//*
            }
        }*/
        System.out.println(students);
    }

    @Test
    public void insertStudent() {
        Student student = new Student();
        student.setId(4);
        student.setName("琪琪怪");
        student.setS_class("高一七班");
        student.setSex("男");
        student.setDescription("没什么可说的");
        int result = studentService.insertStudent(student);
        System.out.println(result);
    }
}