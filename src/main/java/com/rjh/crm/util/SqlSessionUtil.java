package com.rjh.crm.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取SqlSession的工具类
 * @author rjh
 * @date 2021/1/11 16:54
 */
public class SqlSessionUtil {
    private SqlSessionUtil() {}
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> t= new ThreadLocal<SqlSession>();
    static {
        String config = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = t.get();
        if (sqlSession == null) {
            sqlSession = factory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }

    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
            t.remove();
        }
    }
}
