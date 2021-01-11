package com.rjh.crm.util;

import org.junit.Test;

/**
 * @author rjh
 * @date 2021/1/11 19:29
 */
public class DateTimeUtilTest {
    @Test
    public void testGetSysTime() {
        String date = DateTimeUtil.getSysTime();
        System.out.println(date);
    }
}
