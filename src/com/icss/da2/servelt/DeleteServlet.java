package com.icss.da2.servelt;
import com.icss.da2.pojo.Employee;
import com.icss.da2.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 提取请求中的数据
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        // 执行删除操作
        EmployeeService es = new EmployeeService();
        es.deleteEmployee(new Employee(user,pass));

        // 回到展示页面
        response.sendRedirect("ShowServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
