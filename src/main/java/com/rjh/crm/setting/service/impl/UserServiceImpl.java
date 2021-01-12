package com.rjh.crm.setting.service.impl;

import com.rjh.crm.exception.LoginException;
import com.rjh.crm.setting.dao.UserDao;
import com.rjh.crm.setting.domain.User;
import com.rjh.crm.setting.service.UserService;
import com.rjh.crm.util.DateTimeUtil;
import com.rjh.crm.util.SqlSessionUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author rjh
 * @date 2021/1/11 21:40
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
    public User login(String loginAct, String loginPwd, String ip) throws LoginException{
        Map<String, String> map = new HashMap<String, String>();
        map.put("loginPwd", loginPwd);
        map.put("loginAct", loginAct);
        User user = userDao.login(map);
        if (user == null) {
            throw new LoginException("账号密码错误");
        }
        String expireTime = user.getExpireTime();
        String currentTime = DateTimeUtil.getSysTime();
        if (expireTime.compareTo(currentTime) < 0) {
            throw new LoginException("账号已失效");
        }
        String lockState = user.getLockState();
        if ("0".equals(lockState)) {
            throw new LoginException("账号已锁定");
        }
        String allowIps = user.getAllowIps();
        if (!allowIps.contains(ip)) {
            throw new LoginException("ip地址受限");
        }
        return user;
    }

    public List<User> getUserList() {
        List<User> userList = userDao.getUserList();
        return userList;
    }
}
