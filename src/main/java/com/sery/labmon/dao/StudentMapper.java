package com.sery.labmon.dao;

import com.sery.labmon.model.Student;

import java.util.List;

/**
 * Created by LuDan on 2018/6/21 14:22
 */
public interface StudentMapper {
    /**
     * 获取所有的学生
     * @return
     */
    List<Student> getAllStudents();

    /**
     * 插入一条学生记录
     * @param student
     * @return
     */
    int insertStudent(Student student);
}
