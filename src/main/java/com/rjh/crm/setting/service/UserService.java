package com.rjh.crm.setting.service;

import com.rjh.crm.exception.LoginException;
import com.rjh.crm.setting.domain.User;

/**
 * @author rjh
 * @date 2021/1/11 16:48
 */
public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
