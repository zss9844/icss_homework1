<%@ page import="com.icss.da2.pojo.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhuhe
  Date: 2020/3/9
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Employee> emps = (List<Employee>) request.getAttribute("emps");
%>

<table width="400" border="1" cellpadding="10" cellspacing="0">
    <tr>
        <td>Username</td>
        <td>Password</td>
        <td>Delete</td>
        <td>Edit</td>
    </tr>
    <%
        int index = 0;
        //for(int i = 0;i < emps.size();i++){
        for(Employee e:emps){
    %>
    <tr>
        <td><%=e.getUsername()%></td>
        <td><%=e.getPassword()%></td>
        <td><a href="DeleteServlet?user=<%=e.getUsername()%>&pass=<%=e.getPassword()%>">Delete</a></td>
        <td><a href="update.jsp?index=<%=index%>&user=<%=e.getUsername()%>&pass=<%=e.getPassword()%>">Edit</a></td>
    </tr>
    <%
            index++;
        }
    %>


</table>
<br>
<a href="add.jsp">Add Employees...</a>
</body>
</html>
