package com.rjh.crm.util;

import com.rjh.crm.setting.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author rjh
 * @date 2021/1/11 19:31
 */
public class SqlSessionUtilTest {
    @Test
    public void testGetSqlSession() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao dao = sqlSession.getMapper(com.rjh.crm.setting.dao.UserDao.class);
    }
}
