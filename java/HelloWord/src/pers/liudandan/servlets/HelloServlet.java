package pers.liudandan.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ 开头代表是注解 Servlet implementation class HelloServlet
 */
//@WebServlet(description = "第一个Servlet 程序", urlPatterns = { "/Demo/HelloServlet" })
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        // 调用父类的构造函数
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 处理输出的格式，否则会乱码
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        // 返回json数据
        String json = "[{'id':1,'name':‘小明’},{'id':2,'name':'小红'}]";
        out.println(json);
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 处理输出的格式，否则会乱码
        response.setCharacterEncoding("GBK");
        PrintWriter out = response.getWriter();
        out.println("我是 POST 处理方法");
        out.close();
    }

}
