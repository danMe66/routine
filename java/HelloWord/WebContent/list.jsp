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
			<td>
				<%=res.getInt("id")%>
			</td>
			<td>
				<%=res.getString("name")%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>