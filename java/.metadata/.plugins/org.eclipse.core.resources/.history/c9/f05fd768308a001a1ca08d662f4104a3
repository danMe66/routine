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
	<table border="3px">
		<tr>
			<th>ID</th>
			<th>名称</th>
			<th>地区</th>
		</tr>
		<%
			DataList nnas = new DataList();
		ResultSet rs = nnas.getList("select * from lp");
		while (rs.next()) {
		%>
		<tr>
			<td>
				<%
					rs.getInt("lp_uid");
				%>
			</td>
			<td>
				<%
					rs.getInt("lp_uid");
				%>
			</td>
			<td>
				<%
					rs.getString("lpLoc");
				%>
			</td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>