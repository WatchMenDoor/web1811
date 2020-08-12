package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: liuxw
 * @Date: 2020-07-19
 * @Description: com.bjsxt.servlet
 * @version: 1.0
 */
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer requestURL = req.getRequestURL();
        String requestURI = req.getRequestURI();
        String remoteAddr = req.getRemoteAddr();

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01Transitional//EN\">");
        out.println("<HTML>");
        out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println(" <BODY>");
        out.println("URL"+requestURL+"</br>");
        out.println("URI"+requestURI+"</br>");
        out.println("remoteAddr"+remoteAddr+"</br>");
        out.println(" </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
        out.flush();
        out.close();
    }
}
