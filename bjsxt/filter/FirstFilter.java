package com.bjsxt.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Auther: liuxw
 * @Date: 2020-07-24
 * @Description: com.bjsxt.filter
 * @version: 1.0
 */
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init-------------------------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("预处理请求");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("预处理响应");
    }

    @Override
    public void destroy() {

    }
}
