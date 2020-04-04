package com.icss.da2.servelt;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/*@WebServlet("/ThirdServlet")*/
public class ThirdServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 1.获取初始化参数
        String user = servletConfig.getInitParameter("user");
        String pass = servletConfig.getInitParameter("pass");

        System.out.println(user);
        System.out.println(pass);
        // 2.获取servletContext对象
        ServletContext context = servletConfig.getServletContext();

        // ① 获取整个web应用的初始化参数
        String driver = context.getInitParameter("driver");
        System.out.println(driver);

        // ② 获取当前web应用的名称
        String path = context.getContextPath();
        System.out.println(path);

        // ③ 获取文件的真实路径
        String realPath = context.getRealPath("/note.txt");
        System.out.println(realPath);
        // System.out.println("init...");

        // ④ 和attribute相关的方法（讲完request之后对比讲解）
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文乱码问题
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // System.out.println("doPost...");
        //String user = request.getParameter("user");
        //String pass = request.getParameter("pass");

        //System.out.println(user);
       // System.out.println(pass);

        // 获取请求的方式
        String method = request.getMethod();
        System.out.println(method);

        // 获取当前请求的访问地址
        String url = request.getRequestURI();
        System.out.println(url);

        // 获取输出对象，并调用write方法向页面上输出内容
//        Writer out = response.getWriter();
//        out.write("<h1><font color='red'>欢迎来到淘宝页面！</font></h1>");

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // 校验用户名和密码是否正确
        if (user.equals("tom") && pass.equals("789")){
            Writer out = response.getWriter();
            out.write("welcome," + user);
        }else{
            response.sendRedirect("/login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet...");
        doPost(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
