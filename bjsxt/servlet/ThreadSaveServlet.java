package com.bjsxt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: liuxw
 * @Date: 2020-07-23
 * @Description: com.bjsxt.servlet
 * @version: 1.0
 */
public class ThreadSaveServlet extends HttpServlet {
    private PrintWriter pw;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPut(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        pw = resp.getWriter();

        synchronized (this){
            try{
                Thread.sleep(5000);
                pw.println(name);
                pw.flush();
                pw.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
