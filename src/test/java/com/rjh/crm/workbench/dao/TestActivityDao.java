package com.rjh.crm.workbench.dao;

import com.rjh.crm.util.SqlSessionUtil;
import com.rjh.crm.workbench.domain.Activity;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rjh
 * @date 2021/1/18 16:43
 */
public class TestActivityDao {
    @Test
    public void testGetPageListByCondition() {
        ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "");
        map.put("owner", "");
        map.put("startDate", "");
        map.put("endDate", "");
        map.put("pageSize", 2);
        map.put("pageCount", 0);
        List<Activity> dataList = activityDao.getActivityListByCondition(map);
        for (Activity a : dataList) {
            System.out.println(a.getId());
        }
    }

    @Test
    public void testGetTotalByCondition() {
        ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "");
        map.put("owner", "");
        map.put("startDate", "");
        map.put("endDate", "");
        map.put("pageSize", 2);
        map.put("pageCount", 0);
        int total = activityDao.getTotalByCondition(map);
        System.out.println(total);
    }

    @Test
    public void testSelect() {
        ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
        List<Activity> dataList = activityDao.select();
        for (Activity a : dataList) {
            System.out.println(a);
        }
    }
}
