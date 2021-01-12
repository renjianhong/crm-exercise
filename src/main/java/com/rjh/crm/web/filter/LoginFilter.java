package com.rjh.crm.web.filter;

import com.rjh.crm.setting.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author rjh
 * @date 2021/1/12 16:39
 */
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入登录验证器");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String path = request.getServletPath();
        if (user != null || "/setting/user/login.do".equals(path) || "/login.jsp".equals(path)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
