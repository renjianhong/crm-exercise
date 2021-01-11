package com.rjh.crm.setting.dao;

import com.rjh.crm.setting.domain.User;

import java.util.Map;

/**
 * @author rjh
 * @date 2021/1/11 17:10
 */
public interface UserDao {
    User login(Map map);
}
