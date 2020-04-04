package com.icss.da2.servelt;

import com.icss.da2.pojo.Employee;
import com.icss.da2.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取添加的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        EmployeeService es = new EmployeeService();
        //2.实现添加操作
        es.addEmployee(new Employee(username,password));

        //3.回到show页面来展示信息
        request.getRequestDispatcher("ShowServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
