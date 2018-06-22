package com.sery.labmon.service;

import com.sery.labmon.model.Student;

import java.util.List;

/**
 * Created by LuDan on 2018/6/21 14:26
 */
public interface StudentService {
    /**
     * 获取所有的学生信息
     * @return
     */
    List<Student> getAllStudentList();

    /**
     * 插入一条学生信息
     * @param student
     * @return
     */
    int insertStudent(Student student);
}
