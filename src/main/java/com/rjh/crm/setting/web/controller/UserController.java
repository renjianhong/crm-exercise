package com.rjh.crm.setting.web.controller;

import com.rjh.crm.exception.LoginException;
import com.rjh.crm.setting.domain.User;
import com.rjh.crm.setting.service.UserService;
import com.rjh.crm.setting.service.impl.UserServiceImpl;
import com.rjh.crm.util.MD5Util;
import com.rjh.crm.util.PrintJson;
import com.rjh.crm.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author rjh
 * @date 2021/1/11 16:50
 */
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始用户控制");
        String path = request.getServletPath();
        if ("/setting/user/login.do".equals(path)) {
            login(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String loginAct = request.getParameter("loginAct");
        String loginPwd = MD5Util.getMD5(request.getParameter("loginPwd"));
        String ip = request.getRemoteAddr();

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        try {
            User user = us.login(loginAct, loginPwd, ip);
            request.getSession().setAttribute("user", user);
            PrintJson.printJsonFlag(response, true);
        } catch (LoginException e) {
            e.printStackTrace();
            String msg = e.getMessage();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", false);
            map.put("msg", msg);
            response.setContentType("charset=utf-8");
            PrintJson.printJsonObj(response, map);
        }

    }
}
