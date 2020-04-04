<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
欢迎你
<%=request.getAttribute("user")%>
你的密码是：
<%=request.getAttribute("pass")%>
<a href="/ShowServlet">show All Employees...</a>
</body>
</html>

