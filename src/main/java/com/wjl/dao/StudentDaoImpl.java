package com.wjl.dao;

import com.wjl.entity.Student;
import com.wjl.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        String sql = "select * from student";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setSut_num(resultSet.getString("student_num"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Student findById(int id) {
        String sql = "select * from student where id = ?";
        Student student = null;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setSut_num(rs.getString("student_num"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    @Override
    public int add(Student student) {
        String sql = "insert into student(id,student_num,name,age) values(?,?,?,?)";
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2,student.getSut_num());
            preparedStatement.setString(3,student.getName());
            preparedStatement.setInt(4,student.getAge());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from student where id = ?";
        int result = 0;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int update(Student student) {
        String sql=
                "update student set student_num = ?,name = ?,age = ? where id=?";
        int result=0;
        try{
            Connection conn=JDBCUtil.getConnection();
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,student.getSut_num());
            ps.setString(2,student.getName());
            ps.setInt(3,student.getAge());
            ps.setInt(4,student.getId());
            result=ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
