package com.wjl.service;


import com.wjl.dao.StudentDao;
import com.wjl.dao.StudentDaoImpl;
import com.wjl.entity.Student;

import java.util.List;


public class StudentServiceImpl implements StudentService {


    private StudentDao dao = new StudentDaoImpl();

    @Override
    public List<Student> findAll(){

        return dao.findAll();

    }



    @Override
    public Student findById(int id){

        return dao.findById(id);

    }



    @Override
    public int add(Student student){
        return dao.add(student);
    }



    @Override
    public int delete(int id){

        return dao.delete(id);

    }



    @Override
    public int update(Student student){

        return dao.update(student);

    }


}
