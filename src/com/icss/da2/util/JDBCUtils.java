package com.icss.da2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

    public static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static void update(String sql){
        Connection conn = null;
        Statement stmt = null;
//        Statement stmt1 = null;
        try {
            // 1.获取数据库的连接
            conn = getConn();
            // 2.获取能够执行sql语句的语句对象 Statement
            stmt = conn.createStatement();
            // 4.执行插入操作，调用executeUpdate方法，将sql传入执行插入操作
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            // 5.关闭语句和连接对象
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
