package com.wjl.util;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        try {

            Connection conn =
                    JDBCUtil.getConnection();

            System.out.println("Database connects Successful");

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
