package com.wjl.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db?useSSL=false&serverTimezone=Asia/Shanghai";
    private static final String username = "root";
    private static final String password = "root";

    static{
        try {
            Class.forName(
                    "com.mysql.cj.jdbc.Driver"
            );
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{

        return DriverManager.getConnection(
                URL,username,password
        );
    }
}
