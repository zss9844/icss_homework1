package com.icss.da2.dao;

import com.icss.da2.pojo.Employee;
import com.icss.da2.util.JDBCUtils;
import com.icss.da2.pojo.Employee;
import com.icss.da2.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
   /* static List<Employee> employees;
    static{
        employees = new ArrayList<>();
        employees.add(new Employee("AA","123"));
        employees.add(new Employee("BB","456"));
        employees.add(new Employee("CC","789"));
        employees.add(new Employee("DD","666"));
        employees.add(new Employee("EE","999"));
    }*/

    public List<Employee> getAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Employee> emps = new ArrayList<>();
        try{
            // 1.连接数据库
            conn = JDBCUtils.getConn();
            stmt = conn.createStatement();

            // 2.准备sql语句
            String sql = "select * from employee";

            // 3.执行sql语句
            rs = stmt.executeQuery(sql);

            // 4.将执行的结果封装为一个集合
            while(rs.next()){
                // 1）先创建一个空对象
                Employee emp = new Employee();
                // 2）将第n行的数据封装到空对象中
                emp.setUsername(rs.getString(1));
                emp.setPassword(rs.getString(2));
                // 3）将的到的数据整个的存入到集合中
                emps.add(emp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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

        return emps;
    }

    public void add(Employee employee){
        String username = employee.getUsername();
        String password = employee.getPassword();
        String sql = "insert into employee values('"+username+"','"+password+"')";
        JDBCUtils.update(sql);
        //employees.add(employee);
    }

    public void delete(Employee employee){
        String sql = "delete from employee where username = '"+employee.getUsername()+"'";
        JDBCUtils.update(sql);
        //employees.remove(employee);
    }

    public void update(Employee employee){
        String sql = "update employee set password = '"+employee.getPassword()+"' where username = '"+employee.getUsername()+"'";
        JDBCUtils.update(sql);
        //employees.set(index,employee);
    }
}
