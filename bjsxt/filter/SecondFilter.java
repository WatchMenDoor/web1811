package com.bjsxt.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @Auther: liuxw
 * @Date: 2020-07-24
 * @Description: com.bjsxt.filter
 * @version: 1.0
 */
@WebFilter(value = "/*",initParams = {@WebInitParam(name = "name",value = "value")})
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("注解过滤器");
        System.out.println(filterConfig.getInitParameter("name"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
