package com.rjh.crm.workbench.dao;

import com.rjh.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

/**
 * @author rjh
 * @date 2021/1/12 17:40
 */
public interface ActivityDao {
    int save(Activity activity);
    int saveTest(Activity activity);
    List<Activity> select();
    int getTotalByCondition(Map<String, Object> map);

    List<Activity> getActivityListByCondition(Map<String, Object> map);
}
