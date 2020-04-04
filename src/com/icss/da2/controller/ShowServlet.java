package com.icss.da2.controller;

import com.icss.da2.pojo.Employee;
import com.icss.da2.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.拿数据
        EmployeeService es = new EmployeeService();
        List<Employee> emps = es.getAllEmployees();
        // 2.存储在request
        request.setAttribute("emps",emps);
        // 3.跳转到show.jsp
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
