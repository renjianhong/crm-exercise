package com.rjh.crm.util;

/**
 * @author rjh
 * @date 2021/1/11 18:48
 */
public class ServiceFactory {
    public static Object getService(Object service) {
        return new TransactionInvocationhandler(service).getProxy();
    }
}
