package com.rjh.crm.workbench.web.controller;

import com.rjh.crm.setting.domain.User;
import com.rjh.crm.setting.service.UserService;
import com.rjh.crm.setting.service.impl.UserServiceImpl;
import com.rjh.crm.util.PrintJson;
import com.rjh.crm.util.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author rjh
 * @date 2021/1/12 17:43
 */
public class ActivityController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始市场活动控制");
        String path = request.getServletPath();
        if ("/workbench/activity/getUserList.do".equals(path)) {
            getUserList(request, response);
        }
    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> userList = userService.getUserList();
        PrintJson.printJsonObj(response, userList);
    }

    private void xxx(HttpServletRequest request, HttpServletResponse response) {

    }
}
