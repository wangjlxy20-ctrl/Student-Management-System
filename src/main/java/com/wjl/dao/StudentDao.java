package com.wjl.dao;

import com.wjl.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    Student findById(int id);
    int add(Student student);
    int delete(int id);
    int update(Student student);
}
