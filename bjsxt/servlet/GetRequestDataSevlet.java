package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @Auther: liuxw
 * @Date: 2020-07-19
 * @Description: com.bjsxt.servlet
 * @version: 1.0
 */
public class GetRequestDataSevlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        new String(username.getBytes("iso-8859-1"),"utf-8");
        String[] userlike = req.getParameterValues("userlike");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
        if (iterator.hasNext()){
            Map.Entry<String, String[]> next = iterator.next();
            System.out.println(next.getKey()+"===="+next.getValue());
        }
        System.out.println(username);
        List<String> list = Arrays.asList(userlike);
        Enumeration<String> names = req.getParameterNames();
        List<String> keys = new ArrayList<>();
        while (names.hasMoreElements()){
            keys.add(names.nextElement());
        }
        String s = list.toString();
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01Transitional//EN\">");
        out.println("<HTML>");
        out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println(" <BODY>");
        out.println("username:"+username+"</br>");
        out.println("userlike:"+ s+"</br>");
        out.println("keys:"+ keys.toString()+"</br>");
        out.println(" </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
        out.flush();
        out.close();
    }
}
