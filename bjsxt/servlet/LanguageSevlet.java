package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Auther: liuxw
 * @Date: 2020-07-19
 * @Description: com.bjsxt.servlet
 * @version: 1.0
 */
public class LanguageSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lan = req.getHeader("Accept-Language");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println(lan);


        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01Transitional//EN\">");
        out.println("<HTML>");
        out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println(" <BODY>");
        if (lan.indexOf("zh-CN")!=-1){
            out.println("你好，聪明的中国人");
        }else if (lan.indexOf(" en-US")!=-1){
            out.println("Hello，American");
        }else{
            out.println("Not found");
        }

        out.println(" </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
        out.flush();
        out.close();
    }
}
