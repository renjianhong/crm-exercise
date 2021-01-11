package com.rjh.crm.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author rjh
 * @date 2021/1/11 23:37
 */
public class EncodingFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入到过滤器");
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
