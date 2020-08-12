package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Auther: liuxw
 * @Date: 2020-07-21
 * @Description: com.bjsxt.servlet
 * @version: 1.0
 */
public class GetResponeseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //读取图片
        File file = new File("D:\\triumph_big1.jpg");
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);

        //设置响应
        resp.setContentType("image/jpeg");
        //获取字节输出流对象
        OutputStream os = resp.getOutputStream();
        os.write(buffer);

        os.flush();
        os.close();

    }
}
