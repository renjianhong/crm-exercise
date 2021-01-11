package com.rjh.crm.util;

import org.junit.Test;

/**
 * @author rjh
 * @date 2021/1/11 19:27
 */
public class MD5UtilTest {
    @Test
    public void testGetMD5() {
        String str = "";
        String md5 = MD5Util.getMD5(str);
        System.out.println(md5);
    }
}
