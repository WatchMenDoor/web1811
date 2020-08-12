package com.bjsxt.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther: liuxw
 * @Date: 2020-07-23
 * @Description: com.bjsxt.servlet
 * @version: 1.0
 */
public class AutoStartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String path = (String)servletContext.getAttribute("path");
        String realPath = servletContext.getRealPath(path + "triumph_big1.jpg");
        System.out.println(realPath);
        //读文件
        File file = new File(realPath);
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        //设置文件下载的响应头
        resp.setHeader("Content-Disposition", "attachment; filename="+file.getName());
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(buffer);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public void init() throws ServletException {
        ServletConfig servletConfig = this.getServletConfig();
        String path = servletConfig.getInitParameter("path");
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("path", path);


    }
}
