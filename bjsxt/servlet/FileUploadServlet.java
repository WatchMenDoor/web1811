package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * @Auther: liuxw
 * @Date: 2020-07-24
 * @Description: com.bjsxt.servlet
 * @version: 1.0
 */
@WebServlet("/upload.do")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String desc = req.getParameter("desc");
        //与html页面的文件上传name一致
        Part part = req.getPart("file");
        //获取文件上传字节流
        InputStream inputStream = part.getInputStream();

        String name = part.getName();

        //上传的目录路径转换
        String realPath = this.getServletContext().getRealPath("images" );

        part.write(realPath);
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01Transitional//EN\">");
        out.println("<HTML>");
        out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println(" <BODY>");
        out.println("上传成功</br>");
        out.println(" </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
        out.flush();
        out.close();


    }
}
