package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * @Auther: liuxw
 * @Date: 2020-07-23
 * @Description: com.bjsxt.servlet
 * @version: 1.0
 */
public class SessionWelcomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession(false);
        boolean flag =true;
        if (session==null){
            flag=false;
            req.getSession();
        }
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01Transitional//EN\">");
        out.println("<HTML>");
        out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println(" <BODY>");
        if (flag){
            out.println("欢迎您回来");
        }else {
            out.println("您好，欢迎您第一次访问");
            Cookie cookie = new Cookie("first", URLDecoder.decode("first", "utf-8"));
            cookie.setMaxAge(30);
            resp.addCookie(cookie);
        }
        out.println(" </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
        out.flush();
        out.close();
    }
}
