package com.bjsxt.servlet;

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
 * @Date: 2020-07-21
 * @Description: com.bjsxt.servlet
 * @version: 1.0
 */
public class DownFileSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读文件
        File file = new File("D:\\triumph_big1.jpg");
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
}
