<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 声明常量 -->
	<%
		String RootPath = request.getContextPath();
	%>
	在这里获取 list.jsp 页面传递过来的参数， 传递过来的参数是：
	<br>
	<%
		//如果出现中文乱码，则需要进行编码转换
	request.setCharacterEncoding("UTF-8");//只对于get的请求有效
	String msg = request.getParameter("abc");
	//String msg = new String(request.getParameter("abc").getBytes("UTF-8"), "iso-8859-1");//处理转码【比如将 UTF8 转为 iso-8859-1 】
	out.println(msg);
	%>
	<br>
	<button>
		<a href="<%=RootPath%>/Demo/HelloServlet">点击我调用 Servlet 的 GET 方法</a>
	</button>
	<br>
	<form name="form"
		action="<%=request.getContextPath()%>/Demo/HelloServlet" method="POST">
		<input type="submit" name="btnpost" value="点击我调用 Servlet 的 POST 方法" />
	</form>
</body>
</html>