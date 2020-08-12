package com.bjsxt.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Auther: liuxw
 * @Date: 2020-07-20
 * @Description: com.bjsxt.servlet
 * @version: 1.0
 */
public class GetConfigServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();

        /*Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            System.out.println(servletConfig.getInitParameter(initParameterNames.nextElement()));
        }*/
        ServletContext servletContext = servletConfig.getServletContext();
       /* System.out.println(servletContext.getContextPath());
        System.out.println(servletContext.getEffectiveMajorVersion());
        System.out.println(servletContext.getEffectiveMinorVersion());
        System.out.println(servletContext.getServerInfo());
        System.out.println(servletContext.getContextPath());*/

        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println(s);
            System.out.println(servletContext.getInitParameter(s));
        }
    }
}
