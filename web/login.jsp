<%--
  Created by IntelliJ IDEA.
  User: zhuhe
  Date: 2020/3/11
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String msg = (String)session.getAttribute("msg");

    if(msg == null){
        msg = "";
    }
%>

<font color="red"><%=msg%></font>

<form action="/ValidateServlet" method="post">
    <input type="text" name="username" placeholder="请输入用户名"><br>
    <input type="password" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="OK">
</form>
</body>
</html>
