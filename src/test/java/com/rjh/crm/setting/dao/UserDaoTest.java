package com.rjh.crm.setting.dao;

import com.rjh.crm.setting.domain.User;
import com.rjh.crm.util.MD5Util;
import com.rjh.crm.util.SqlSessionUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rjh
 * @date 2021/1/11 22:41
 */
public class UserDaoTest {
    @Test
    public void testLogin() {
        UserDao dao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("loginAct", "rjh");
        map.put("loginPwd", MD5Util.getMD5("123"));
        User user = dao.login(map);
        System.out.println(user);
    }
}
