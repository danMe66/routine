<%@page import="java.sql.ResultSet"%>
<%@page import="pers.liudandan.demo.UsersList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp?abc=Hello Word  你好 世界！"> <%
 	out.print("点击跳转传递参数");
 %>
	</a>
	<table border="1px">
		<tr>
			<th>ID</th>
			<th>name</th>
		</tr>
		<%
			UsersList userList = new UsersList();
		ResultSet res = userList.getList("select * from user");
		while (res.next()) {
		%>
		<tr>
			<td><%=res.getInt("id")%></td>
			<td><%=res.getString("name")%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>