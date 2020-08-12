package com.bjsxt.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * @Auther: liuxw
 * @Date: 2020-07-24
 * @Description: com.bjsxt.servlet
 * @version: 1.0
 */
@WebServlet(urlPatterns = "/ann.do",initParams = {@WebInitParam(name = "key1",value = "value1"),@WebInitParam(name = "key2",value = "value2")},loadOnStartup = 1)
public class AnnotaServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println(servletConfig.getInitParameter("key1"));
        System.out.println(servletConfig.getInitParameter("key2"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println();
        System.out.println(servletConfig.getInitParameter("key1"));
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01Transitional//EN\">");
        out.println("<HTML>");
        out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println(" <BODY>");
        out.println("value1:"+servletConfig.getInitParameter("key1"));
        out.println("value2:"+servletConfig.getInitParameter("key2"));
        out.println(" </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
        out.flush();
        out.close();
    }
}
