package com.rjh.crm.util;

import java.util.UUID;

/**
 * @author rjh
 * @date 2021/1/17 15:21
 */
public class UUIDUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
