<%--
  Created by IntelliJ IDEA.
  User: zhuhe
  Date: 2020/3/11
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UpdateServlet" method="post">
    <input type="hidden" value="<%=request.getParameter("index")%>" name="index">
    <input type="text" name="username" value="<%=request.getParameter("user")%>" placeholder="请输入用户名"><br>
    <input type="password" name="password" value="<%=request.getParameter("pass")%>" placeholder="请输入密码"><br>
    <input type="submit" value="OK">
</form>
</body>
</html>
