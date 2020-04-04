<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.icss.da2.pojo.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="400" border="1" cellpadding="10" cellspacing="0">
    <c:set value="0" scope="page" var="index"></c:set>
    <tr>
        <td>Username</td>
        <td>Password</td>
        <td>Delete</td>
        <td>Edit</td>
    </tr>
    <c:forEach items="${requestScope.emps}" var="e">
        <tr>
            <td>${e.username}</td>
            <td>${e.password}</td>
            <td><a href="DeleteServlet?user=${e.username}&pass=${e.password}">Delete</a></td>
            <td><a href="update.jsp?index=${pageScope.index}&user=${e.username}&pass=${e.password}">Edit</a></td>
        </tr>
        <c:set value="${pageScope.index+1}" scope="page" var="index"></c:set>
    </c:forEach>
</table>
<br>
<a href="add.jsp">Add Employees...</a>
</body>
</html>
