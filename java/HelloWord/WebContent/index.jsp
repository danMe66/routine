<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String rp = request.getContextPath();//获取网站项目名称
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="<%=rp%>/scripts/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            //页面加载就发送ajax请求b页面
            <%-- $.get("<%=rp%>/indexb.jsp","",function(rsp){
                $("#contents").html(rsp);
            }); --%>
            // ajax 请求servlet返回json数据
            $("#contents").load("<%=rp%>/Demo/HelloServlet");
            $.get("<%=rp%>/Demo/HelloServlet", "", function (rsp) {
                //先对rsp进行处理，然后解析json数据
                var json = eval('(' + rsp + ')');
                var table = $("<table border="
                1
                px
                "><tr><th>序号</th><th>名称</th></tr></table>"
            )
                ;
                //遍历数组
                $(json).each(function (i, o) {
                    table.append("<tr><td>" + o.id + "</td><td>" + o.name + "</td></tr>");
                });
                $("#contents").html(table);
            });
        })
    </script>
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
<form name="form" action="<%=rp%>/Demo/HelloServlet" method="POST">
    <input type="submit" name="btnpost" value="点击我调用 Servlet 的 POST 方法"/>
</form>
通过ajax拿到列表页indexb.jsp的内容
<div id="contents"></div>
</body>
</html>