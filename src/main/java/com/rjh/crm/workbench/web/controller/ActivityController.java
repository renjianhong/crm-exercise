package com.rjh.crm.workbench.web.controller;

import com.rjh.crm.setting.domain.User;
import com.rjh.crm.setting.service.UserService;
import com.rjh.crm.setting.service.impl.UserServiceImpl;
import com.rjh.crm.util.DateTimeUtil;
import com.rjh.crm.util.PrintJson;
import com.rjh.crm.util.ServiceFactory;
import com.rjh.crm.util.UUIDUtil;
import com.rjh.crm.vo.PaginationVO;
import com.rjh.crm.workbench.domain.Activity;
import com.rjh.crm.workbench.service.ActivityService;
import com.rjh.crm.workbench.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        } else if ("/workbench/activity/save.do".equals(path)) {
            save(request, response);
        } else if ("/workbench/activity/pageList.do".equals(path)) {
            pageList(request, response);
        }
    }

    private void pageList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入到分页查询");
        String name = request.getParameter("name");
        String owner = request.getParameter("owner");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
        Integer pageCount = pageSize * (pageNo - 1);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        map.put("owner", owner);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("pageSize", pageSize);
        map.put("pageCount", pageCount);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        PaginationVO<Activity> vo = as.pageList(map);
        PrintJson.printJsonObj(response, vo);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行市场用户添加操作");

        String id = UUIDUtil.getUUID();
        String owner = request.getParameter("owner");
        String name = request.getParameter("name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
        String createTime = DateTimeUtil.getSysTime();
        User user = (User) request.getSession().getAttribute("user");
        String createBy = user.getName();

        Activity activity = new Activity();
        activity.setId(id);
        activity.setOwner(owner);
        activity.setName(name);
        activity.setStartDate(startDate);
        activity.setEndDate(endDate);
        activity.setCost(cost);
        activity.setDescription(description);
        activity.setCreateTime(createTime);
        activity.setCreateBy(createBy);

        ActivityService activityService = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        boolean existed = activityService.save(activity);
        if (existed) {
            System.out.println("success");
        }
        PrintJson.printJsonFlag(response, existed);
    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得用户信息列表");
        UserService userService = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> userList = userService.getUserList();
        PrintJson.printJsonObj(response, userList);
    }

    private void xxx(HttpServletRequest request, HttpServletResponse response) {

    }
}
