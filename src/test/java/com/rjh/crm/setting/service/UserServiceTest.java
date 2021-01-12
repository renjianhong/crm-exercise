package com.rjh.crm.setting.service;

import com.rjh.crm.setting.domain.User;
import com.rjh.crm.setting.service.impl.UserServiceImpl;
import com.rjh.crm.util.ServiceFactory;
import org.junit.Test;

import java.util.List;

/**
 * @author rjh
 * @date 2021/1/12 20:52
 */
public class UserServiceTest {
    @Test
    public void testGetUserList() {
        UserService userService = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> userList = userService.getUserList();
        for (User user : userList) {
            System.out.println(user.getName());
        }
    }
}
