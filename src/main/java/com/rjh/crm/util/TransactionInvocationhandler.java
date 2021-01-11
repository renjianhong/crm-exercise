package com.rjh.crm.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author rjh
 * @date 2021/1/11 18:40
 */
public class TransactionInvocationhandler implements InvocationHandler {
    private Object target;

    public TransactionInvocationhandler(Object target) {
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        SqlSession sqlSession = null;
        Object obj = null;
        try {
            sqlSession = SqlSessionUtil.getSqlSession();
            obj = method.invoke(target, args);
            sqlSession.commit();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw e.getCause();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw e.getCause();
        } finally {
            SqlSessionUtil.close(sqlSession);
        }
        return obj;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
