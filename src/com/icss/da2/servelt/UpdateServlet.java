package com.icss.da2.servelt;

import com.icss.da2.pojo.Employee;
import com.icss.da2.service.EmployeeService;
import com.icss.da2.pojo.Employee;
import com.icss.da2.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 提取前端数据
        int index = Integer.parseInt(request.getParameter("index"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 修改操作
        Employee employee = new Employee(username,password);
        EmployeeService es = new EmployeeService();
        es.updateEmployee(employee);

        // 回到展示页面
        response.sendRedirect("ShowServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
