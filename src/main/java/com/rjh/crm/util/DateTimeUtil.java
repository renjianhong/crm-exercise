package com.rjh.crm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间的工具类
 * @author rjh
 * @date 2021/1/11 19:11
 */
public class DateTimeUtil {
    /**
     * 获取指定格式的当前系统时间
     * @return 指定格式时间
     */
    public static String getSysTime() {
        return new SimpleDateFormat(Const.DATE_FORMART_ALL).format(new Date());
    }

}
