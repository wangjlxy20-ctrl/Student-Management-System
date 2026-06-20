package com.wjl.dao;


import com.wjl.dao.StudentDao;
import com.wjl.dao.StudentDaoImpl;


public class TestDao {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();
        dao.findAll().forEach(System.out::println);
    }

}
