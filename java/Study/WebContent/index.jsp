<%@ page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.study.DataAccess.DataList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>name</th>
		</tr>
		<%
			DataList dataList = new DataList();
		ResultSet rs = dataList.getList("select * from user");
		while (rs.next()) {
		%>
		<tr>
			<td>
				<%
					rs.getInt("id");
				%>
			</td>
			<td>
				<%
					rs.getString("name");
				%>
			</td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>