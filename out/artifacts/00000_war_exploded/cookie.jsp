<%--
  Created by IntelliJ IDEA.
  User: zhuhe
  Date: 2020/3/11
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // 1.获取cookie
    // 获取本地的所有cookie
    Cookie[] cookies = request.getCookies();
    if(cookies != null && cookies.length > 0){
        // 2.获取cookie的名字和值
        for(Cookie c:cookies){
            out.write(c.getName() + ":" + c.getValue() + "<br>");
        }
    }

    // 1.创建一个cookie对象
    Cookie cookie1 = new Cookie("name1","icss");
    Cookie cookie2 = new Cookie("name2","bhu");

    // setMaxAge:设置最大的有效时常
    cookie1.setMaxAge(5);

    // 2.将cookie返回给浏览器，并存储起来，通过response来携带
    response.addCookie(cookie1);
    response.addCookie(cookie2);

%>
</body>
</html>
