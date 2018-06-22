package com.sery.labmon.service.impl;

import com.sery.labmon.dao.StudentMapper;
import com.sery.labmon.model.Student;
import com.sery.labmon.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LuDan on 2018/6/21 14:27
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudentList() {
        List<Student> students = studentMapper.getAllStudents();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        int result = studentMapper.insertStudent(student);
        return result;
    }
}
