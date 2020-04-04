package com.icss.da2.servelt;

import com.icss.da2.util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取前端参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // ==
        // 校验
//        if(username.equals("tom") && password.equals("789")){
//            request.setAttribute("user",username);
//            request.setAttribute("pass",password);

        Connection conn = null;
        Statement stmt = null;
        Statement stmt1 = null;
        ResultSet rs = null;
        ResultSet rs1= null;
        try {
            // 1.获取连接对象connection
            conn = JDBCUtils.getConn();

            // 2.获取语句对象statement
            stmt = conn.createStatement();
            stmt1 = conn.createStatement();

            // 3.查询用户及其密码
            String sql = "SELECT username FROM employee t WHERE username='"+ username +"'";
            String sql1 = "SELECT password FROM employee t WHERE password='"+ password +"'";

            // 4.执行查询
            rs = stmt.executeQuery(sql); //执行用户查询
            rs1 = stmt1.executeQuery(sql1);//执行密码查询

            // 5.处理结果集
            if(rs.next()&&rs1.next()){
                request.setAttribute("user",username);
                request.setAttribute("pass",password);
                request.getRequestDispatcher("success.jsp").forward(request,response);
            }else{
                // 获取session对象
                HttpSession session = request.getSession();
                session.setAttribute("msg","用户名或密码错误");
                response.sendRedirect("login.jsp");
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


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
