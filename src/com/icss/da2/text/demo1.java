package com.icss.day20;


import com.icss.da2.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo1 {

    /**
     * ResultSet：结果集，对数据库中查询出来的表格结果进行了封装，封装成了一个对象
     *  1.调用statement对象的executeQuery()方法，来得到结果集
     *  2.ResultSet返回的实际上就是一个数据表，有一个指针，指向第一行的上边，可以调用
     *  next方法，用于检查下一行是否有有效数据，若有则返回true，并讲指针指向下一行
     *  3.当指针对应到某一行，可以通过getXxxx(index)或者getXxxx(columnName)来获取每一列的值
     *  如：rs.getInt(1)  或  rs.getString("stu_name")
     * @param args
     */
    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 1.获取连接对象connection
            conn = JDBCUtils.getConn();

            // 2.获取语句对象statement
            stmt = conn.createStatement();

            // 3.准备sql
            String sql = "select stu_id,stu_name from stu where stu_id = 1008";

            // 4.执行查询
            rs = stmt.executeQuery(sql);

            // 5.处理结果集
            if(rs.next()){
                // 显示某一行记录的所有数据
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
